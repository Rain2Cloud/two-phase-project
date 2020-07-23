package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;

import com.aaa.yay.model.MappingProject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/20 22:42
 * @Version 1.0
 */
@FeignClient(value = "mapping-interface")
public interface MappingApi {


           /**
           * @Auther: czb
           * @Description:
            * 分页查询设备信息
           * @Date: 2020/7/21 9:02
           * @param [pageNo, pageSize]
           * @return com.aaa.yay.base.ResultData
           */
    @PostMapping("/equipment/selectAllEquipment")
        ResultData selectAllEquipment(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);



        /**
        * @Auther: czb
        * @Description:
         * 根据传过 来的条件去查询需要测绘成果
        * @Date: 2020/7/21 19:45
        * @param [hashMap]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("resultCommit/selcetAllResult")
    ResultData selcetAllResult(@RequestBody HashMap hashMap);


   /**
   * @Auther: czb
   * @Description:
    * 查询数据中所有的测绘类型，可以让前台进行选择查询
   * @Date: 2020/7/21 20:12
   * @param []
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping("resultCommit/SelectProjectType")
    ResultData SelectProjectType();


    /**
    * @Auther: czb
    * @Description:
     * 查询出成果的详细信息
    * @Date: 2020/7/21 20:20
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("resultCommit/resultDetail")
    ResultData resultDetail(@RequestParam("id") String id);

//project(项目管理)

    /**
    * @Auther: czb
    * @Description:
     * 通过id查询测绘工程的详细信息
    * @Date: 2020/7/22 21:02
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/project/projectDetail")
    ResultData projectDetail(@RequestParam("id") String id);



        /**
        * @Auther: czb
        * @Description:
         *测绘项目管理，项目名称模糊查询，类型 ，日期精确查
        * @Date: 2020/7/22 21:03
        * @param [mappingProject]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/project/projectSelect")
    ResultData  projectSelect(@RequestBody MappingProject mappingProject);


        /**
        * @Auther: czb
        * @Description:
         * 通过字段查询类型，日期 ，进行分组
        * @Date: 2020/7/22 21:03
        * @param [name]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/project/SelectGroupName")
    ResultData SelectGroupName(@RequestParam ("name") String name);


        /**
        * @Auther: czb
        * @Description:
         * 通过id修改项目
        * @Date: 2020/7/22 21:06
        * @param [manProject]
        * @return java.lang.Integer
        */
    @PostMapping("/project/updateById")
    Integer updateById(@RequestBody MappingProject manProject);



       /**
       * @Auther: czb
       * @Description:
        * 查询项目
       * @Date: 2020/7/22 21:06
       * @param [userId]
       * @return java.util.List<com.aaa.yay.model.MappingProject>
       */
    @PostMapping("/project/allPro")
    List<MappingProject> selectAllPros(@RequestParam("userId") Long userId);


       /**
       * @Auther: czb
       * @Description:
        * 通过id查询项目
       * @Date: 2020/7/22 21:06
       * @param [id]
       * @return com.aaa.yay.model.MappingProject
       */
    @GetMapping("/project/selectById")
    MappingProject selectById(@RequestParam("id") Long id);


    /**
    * @Auther: czb
    * @Description:
     * 添加项目
    * @Date: 2020/7/23 8:44
    * @param [mappingProject]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/project/addProject")
    ResultData addProject(@RequestBody MappingProject mappingProject);

    }

