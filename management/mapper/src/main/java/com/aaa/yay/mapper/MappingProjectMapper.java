package com.aaa.yay.mapper;

import com.aaa.yay.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author 十八
 */
public interface MappingProjectMapper extends Mapper<MappingProject> {

      /**
      * @Auther: czb
      * @Description:
       * 测绘项目管理，项目名称模糊查询，类型 ，日期精确查
      * @Date: 2020/7/22 19:30
      * @param [mappingProject]
      * @return java.util.List<java.util.HashMap>
      */
    List<HashMap> projectSelect(MappingProject mappingProject);

    /**
    * @Auther: czb
    * @Description:
     * 查询所有测绘项目
    * @Date: 2020/7/22 19:01
    * @param []
    * @return java.util.List<java.util.HashMap>
    */
     List<HashMap> SelectAllProject();

        /**
        * @Auther: czb
        * @Description:
         * 查询测绘类型和开工时间，分组
        * @Date: 2020/7/22 19:01
        * @param [name]
        * @return java.util.List<java.util.HashMap>
        */
    List<HashMap> SelectGroupName(String name);

    /**
     * @Description: 通过id查询测绘工程的详细信息
     * @Param: [id]
     * @return: java.util.List<java.util.HashMap>
     * @Author: czb
     * @Date: 2020/7/22
     */
    List<HashMap> projectDetail(String id);



    /**
    * @Auther: czb
    * @Description:
     * 项目查询
    * @Date: 2020/7/22 19:30
    * @param [userId]
    * @return java.util.List<com.aaa.yay.model.MappingProject>
    */
    List<MappingProject> selectAllPros(Long userId);



}