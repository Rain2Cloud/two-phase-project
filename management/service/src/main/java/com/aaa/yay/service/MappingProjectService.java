package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.MappingProjectMapper;
import com.aaa.yay.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/22 18:57
 * @Version 1.0
 */
@Service
public class MappingProjectService extends BaseService<MappingProject>{

    @Autowired
    private MappingProjectMapper mappingProjectMapper;


    /**
    * @Auther: czb
    * @Description:
     * 测绘项目管理，项目名称模糊查询，类型，日期精确查
    * @Date: 2020/7/22 19:48
    * @param [mappingProject]
    * @return java.util.Map<java.lang.String,java.lang.Object>
    */
        public ResultData projectSelect(MappingProject mappingProject){
           ResultData resultData = new ResultData();
            List<HashMap> restData = new ArrayList<HashMap>();
            if (null == mappingProject){
                restData = mappingProjectMapper.SelectAllProject();
            }else{
                restData = mappingProjectMapper.projectSelect(mappingProject);
            }
            if (restData.size() > 0){
                resultData.setCode(SELECT_DATA_SUCCESS.getCode()).setMsg(SELECT_DATA_SUCCESS.getMsg());
               resultData.setData(restData);

            }else {
              resultData.setCode(SELECT_DATA_FAILED.getCode()).setMsg(SELECT_DATA_FAILED.getMsg());


            }
            return resultData;

        }


        /**
        * @Auther: czb
        * @Description:
         * 通过字段查询所有的类型和开工日期。分组
        * @Date: 2020/7/22 19:57
        * @param [name]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
        public Map<String,Object> SelectGroupName(String name){
            HashMap<String,Object> resultMap = new HashMap<String, Object>();
            List<HashMap> restData = new ArrayList<HashMap>();

            restData = mappingProjectMapper.SelectGroupName(name);

            if (restData.size() > 0){
                resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
                resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
                resultMap.put("data",restData);
            }else {
                resultMap.put("code",SELECT_DATA_FAILED.getCode());
                resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
            }
            return resultMap;

        }

        /**
        * @Auther: czb
        * @Description:
         * 通过id查询测绘工程的详细信息
        * @Date: 2020/7/22 20:06
        * @param [id]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
        public Map<String,Object> projectDetail(String id){
            HashMap<String,Object> resultMap = new HashMap<String, Object>();
            if (null != id && !("").equals(id)) {
                List<HashMap> restData = mappingProjectMapper.projectDetail(id);
                if ( restData.size() ==1) {
                    resultMap.put("code", SELECT_DATA_BY_ID_SUCCESS.getCode());
                    resultMap.put("msg", SELECT_DATA_BY_ID_SUCCESS.getMsg());
                    resultMap.put("data", restData);
                    return resultMap;
                }
            }
            resultMap.put("code", SELECT_DATA_BY_ID_FAILED.getCode());
            resultMap.put("msg", SELECT_DATA_BY_ID_FAILED.getMsg());
            return resultMap;
        }

        /**
        * @Auther: czb
        * @Description:
         * 项目查询
        * @Date: 2020/7/22 20:11
        * @param [id]
        * @return java.util.List<com.aaa.yay.model.MappingProject>
        */
    public List<MappingProject> selectAllPros(Long id){
        try {
            //查询公司信息
            List<MappingProject> manProjects = mappingProjectMapper.selectAllPros(id);
            //判断是否查询出值
            if (!"".equals(manProjects) && null != manProjects){
                return manProjects;
            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
    * @Auther: czb
    * @Description:
     *根据主键id查询项 目
    * @Date: 2020/7/22 20:31
    * @param [id]
    * @return com.aaa.yay.model.MappingProject
    */
    public MappingProject selectById(Long id){
        try {
            if (!"".equals(id)){
                //根据id获取项目信息
                MappingProject manProject = mappingProjectMapper.selectByPrimaryKey(id);
                //判断是否存在该项目
                if (!"".equals(manProject) && null != manProject){
                    return manProject;
                }else {
                    return null;
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


        /**
        * @Auther: czb
        * @Description:
         * 根据id修改项目
        * @Date: 2020/7/22 20:31
        * @param [manProject]
        * @return java.lang.Integer
        */
    public Integer updateById(MappingProject manProject){
        System.out.println(manProject);
        int i = 0;
        try {
            if (!"".equals(manProject)){
                //执行修改的方法 返回受影响的行数
                i = mappingProjectMapper.updateByPrimaryKeySelective(manProject);
                //判断受影响的行数
                if (i>0){
                    return i;
                }else {
                    //再次执行修改操作
                    int j = mappingProjectMapper.updateByPrimaryKeySelective(manProject);
                    if (j>0){
                        return j;
                    }
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

            /**
            * @Auther: czb
            * @Description:
             * 添加项目
            * @Date: 2020/7/23 8:36
            * @param [mappingProject]
            * @return com.aaa.yay.base.ResultData
            */
    public ResultData addProject(MappingProject mappingProject){
        ResultData resultData = new ResultData();
        int addResult = mappingProjectMapper.insert(mappingProject);
            if (addResult > 0 ){
                return resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg());
            }
            return resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());

        }
}
