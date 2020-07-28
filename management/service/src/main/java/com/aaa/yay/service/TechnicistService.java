package com.aaa.yay.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.ResourceMapper;
import com.aaa.yay.mapper.TechnicistMapper;
import com.aaa.yay.model.Resource;
import com.aaa.yay.model.Technicist;
import com.aaa.yay.properties.FtpProperties;
import com.aaa.yay.utils.FtpFileNameUtil;
import com.aaa.yay.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/23 22:24
 * 技术员的service
 * @Version 1.0
 */
@Service
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;
    @Autowired
    private FtpProperties ftpProperties;
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * @param [technicist, files, uploadService]
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Auther: czb
     * @Description: 添加技术人员信息
     * @Date: 2020/7/23 22:29
     */
    public ResultData addTechnicist(Technicist technicist, MultipartFile[] files, UploadService uploadService) {
       ResultData resultData = new ResultData();
        //设置技术人员创建时间
        technicist.setCreateTime(DateUtil.now());
        //生成一个id，用于技术人员id
        String id = FtpFileNameUtil.getFileName();
        technicist.setId(Long.valueOf(id));
        //添加负责人
        int i = technicistMapper.insertSelective(technicist);
        if (i > 0) {
            Boolean result = false;
            for (MultipartFile file : files) {
//                    添加资源表
                Resource resource = new Resource();
//                    设置资源id
                String resourceId = FtpFileNameUtil.getFileName();
//                      获取当天日期格式化后的数据，用来当做路径
                String filePath = com.aaa.yay.utils.DateUtil.formatDate(new Date(), "yyyy/MM/dd");
//                    获取原始文件的名称
                String oldFilename = file.getOriginalFilename();
                System.out.println(oldFilename);
//                      获取文件名后缀
                String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
//                  生成新的文件名称
                String newFileName = resourceId + "" + extName;
//                      设置resource对象的值
                resource.setName(file.getOriginalFilename()).setSize(Long.valueOf(file.getSize())).setPath(ftpProperties.getHttpPath() + "/" + filePath + "/" + newFileName)
                        .setType(file.getContentType()).setExtName(extName).setRefBizType("身份证").setRefBizId(Long.valueOf(id))
                        .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
//                            数据库添加resource的数据
                int r = resourceMapper.insert(resource);
                if (r > 0) {
//                        添加文件后上传文件
                    result = uploadService.uploadFile(file, filePath, newFileName);
                }

            }
            if (result) {
               resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg());
               return resultData;
            }
        }

     return   resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());
    }

    /**
     * @param [id]
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Auther: czb
     * @Description: 查询单个技术人员信息
     * @Date: 2020/7/24 19:38
     */
    public ResultData selectTechnicistById(String id) {
        ResultData resultData = new ResultData();
        Technicist technicist = technicistMapper.selectByPrimaryKey(id);
        if (technicist != null) {
            resultData.setCode(SELECT_DATA_SUCCESS.getCode()).setMsg(SELECT_DATA_SUCCESS.getMsg());
            resultData.setData(technicist);
        } else {
            resultData.setCode(SELECT_DATA_FAILED.getCode()).setMsg(SELECT_DATA_FAILED.getMsg());
        }
       return  resultData;
    }


    /**
     * @param [id]
     * @return int
     * @Auther: czb
     * @Description: 删除技术人员信息
     * @Date: 2020/7/24 19:59
     */
    public int deleteTechnicistById(String id) {
        //先删除技术人员信息
        int j = technicistMapper.deleteByPrimaryKey(id);
        if (j > 0) {
            //获取看资源表里有几个这个技术人员的资源文件
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

    /**
     * @param [technicist]
     * @return int
     * @Auther: czb
     * @Description: 修改技术人员信息
     * @Date: 2020/7/24 19:59
     */
    public int updateTechnicistById(Technicist technicist) {
        return technicistMapper.updateByPrimaryKeySelective(technicist);
    }




}
