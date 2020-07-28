package com.aaa.yay.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.yay.base.BaseService;
import com.aaa.yay.mapper.PrincipalMapper;
import com.aaa.yay.mapper.ResourceMapper;
import com.aaa.yay.model.Principal;
import com.aaa.yay.model.Resource;
import com.aaa.yay.properties.FtpProperties;
import com.aaa.yay.utils.FtpFileNameUtil;
import com.aaa.yay.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.aaa.yay.status.OperationStatus.ADD_FAILED;
import static com.aaa.yay.status.OperationStatus.ADD_SUCCESS;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_FAILED;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_SUCCESS;



/**
 * @Author czb
 * @Description Principal的实现类
 * @Date 2020/7/24 21:32
 */
@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;

    @Autowired
    private FtpProperties ftpProperties;

    @Autowired
    private ResourceMapper resourceMapper;

    /**
    * @Description: 添加单位负责人
    * @Author: czb
    * @Date: 2020/7/24 22:00
    * @Param: [principal, file, uploadService]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String, Object> addPrincipal(Principal principal, MultipartFile[] files, UploadService uploadService) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //设置负责人创建时间
        principal.setCreateTime(DateUtil.now());
        //生成一个id，用于负责人id
        String id = FtpFileNameUtil.getFileName();
        principal.setId(Long.valueOf(id));
        //添加负责人
        int i = principalMapper.insertSelective(principal);
        if (i > 0){
            Boolean result = false;
            for (MultipartFile file : files) {
                //添加资源表
                Resource resource = new Resource();
                //设置资源ID
                String resourceId = FtpFileNameUtil.getFileName();
                //获取今天日期格式化后的数据，用来当做路径
                String filePath = com.aaa.yay.utils.DateUtil.formatDate(new Date(), "yyyy/MM/dd");
                //获取原始文件的名称
                String oldFilename = file.getOriginalFilename();
                System.out.println(oldFilename);
                //截取文件后缀
                String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
                //生成新的文件名称
                String newFileName = resourceId + "" + extName;
                //设置resource对象的值
                resource.setName(file.getOriginalFilename()).setSize(Long.valueOf(file.getSize())).setPath(ftpProperties.getHttpPath()+"/"+filePath+"/"+newFileName)
                        .setType(file.getContentType()).setExtName(extName).setRefBizType("身份证").setRefBizId(Long.valueOf(id))
                        .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
                //数据库添加resource的数据
                int r = resourceMapper.insert(resource);
                if (r > 0){
                    //添加成功后上传文件
                    result = uploadService.uploadFile(file, filePath, newFileName);
                }
            }
            if (result){
                resultMap.put("code",ADD_SUCCESS.getCode());
                resultMap.put("msg",ADD_SUCCESS.getMsg());
                return resultMap;
            }
        }
        resultMap.put("code",ADD_FAILED.getCode());
        resultMap.put("msg",ADD_FAILED.getMsg());
        return resultMap;
    }


    /**
    * @Description: 查询负责人信息
    * @Author: czb
    * @Date: 2020/7/24 20:31
    * @Param: [id]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    public Map<String, Object> selectPrincipalById(String id) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Principal principal = principalMapper.selectPrincipalById(id);
        if (principal != null && !"".equals(principal)){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",principal);
        }else{
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }


    /**
    * @Description: 删除某个单位负责人信息
    * @Author: czb
    * @Date: 2020/7/24 22:49
    * @Param: [id]
    * @return: int
    */
    public int deletePrincipalById(String id) {
        //先删除负责人信息
        Principal principal = new Principal();
        principal.setId(Long.valueOf(id));
        int j = principalMapper.delete(principal);
        if (j > 0){
            //获取看资源表里有几个这个负责人的资源文件
            List<Resource> resources = resourceMapper.select(new Resource().setRefBizId(Long.valueOf(id)));
            //遍历获取每一个资源实体
            for (Resource resource : resources) {
                //删除这个实体和这个实体的ftp文件
                boolean b = FtpUtils.deleteFile(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(), ftpProperties.getPassword(), resource.getPath());
                int i = resourceMapper.delete(resource);
            }
            return 1;
        }
        return 0;
    }






}



