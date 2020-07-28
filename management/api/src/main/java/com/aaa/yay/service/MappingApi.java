package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;

import com.aaa.yay.model.MappingProject;
import com.aaa.yay.model.MappingUnit;
import com.aaa.yay.model.News;
import com.aaa.yay.model.Technicist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

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
     * @param [pageNo, pageSize]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 分页查询设备信息
     * @Date: 2020/7/21 9:02
     */
    @PostMapping("/equipment/selectAllEquipment")
    ResultData selectAllEquipment(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);


    /**
     * @param [hashMap]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 根据传过 来的条件去查询需要测绘成果
     * @Date: 2020/7/21 19:45
     */
    @PostMapping("resultCommit/selcetAllResult")
    ResultData selcetAllResult(@RequestBody HashMap hashMap);


    /**
     * @param []
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 查询数据中所有的测绘类型，可以让前台进行选择查询
     * @Date: 2020/7/21 20:12
     */
    @PostMapping("resultCommit/SelectProjectType")
    ResultData SelectProjectType();


    /**
     * @param [id]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 查询出成果的详细信息
     * @Date: 2020/7/21 20:20
     */
    @PostMapping("resultCommit/resultDetail")
    ResultData resultDetail(@RequestParam("id") String id);

//project(项目管理)

    /**
     * @param [id]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 通过id查询测绘工程的详细信息
     * @Date: 2020/7/22 21:02
     */
    @PostMapping("/project/projectDetail")
    ResultData projectDetail(@RequestParam("id") String id);


    /**
     * @param [mappingProject]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 测绘项目管理，项目名称模糊查询，类型 ，日期精确查
     * @Date: 2020/7/22 21:03
     */
    @PostMapping("/project/projectSelect")
    ResultData projectSelect(@RequestBody MappingProject mappingProject);


    /**
     * @param [name]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 通过字段查询类型，日期 ，进行分组
     * @Date: 2020/7/22 21:03
     */
    @PostMapping("/project/SelectGroupName")
    ResultData SelectGroupName(@RequestParam("name") String name);


    /**
     * @param [manProject]
     * @return java.lang.Integer
     * @Auther: czb
     * @Description: 通过id修改项目
     * @Date: 2020/7/22 21:06
     */
    @PostMapping("/project/updateById")
    Integer updateById(@RequestBody MappingProject manProject);


    /**
     * @param [userId]
     * @return java.util.List<com.aaa.yay.model.MappingProject>
     * @Auther: czb
     * @Description: 查询项目
     * @Date: 2020/7/22 21:06
     */
    @PostMapping("/project/allPro")
    List<MappingProject> selectAllPros(@RequestParam("userId") Long userId);


    /**
     * @param [id]
     * @return com.aaa.yay.model.MappingProject
     * @Auther: czb
     * @Description: 通过id查询项目
     * @Date: 2020/7/22 21:06
     */
    @GetMapping("/project/selectById")
    MappingProject selectById(@RequestParam("id") Long id);


    /**
     * @param [mappingProject]
     * @return com.aaa.yay.base.ResultData
     * @Auther: czb
     * @Description: 添加项目
     * @Date: 2020/7/23 8:44
     */
    @PostMapping("/project/addProject")
    ResultData addProject(@RequestBody MappingProject mappingProject);


//   信息(News)

    /**
    * @Auther: czb
    * @Description:
     * 信息（news）增加
    * @Date: 2020/7/27 18:44
    * @param [news]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("news/addNews")
    ResultData addNews (@RequestBody News news);

    /**
    * @Auther: czb
    * @Description:
     * 批量删除信息（News）
    * @Date: 2020/7/27 18:45
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("news/delNews")
    ResultData delNews (@RequestBody List<Long> ids);


    /**
    * @Auther: czb
    * @Description:
     * 分页查询全部信息(News)
    * @Date: 2020/7/27 18:50
    * @param [pageNo, pageSize]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("news/selectAllNews")
    ResultData selectAllNews(@RequestParam ("pageNo") Integer pageNo , @RequestParam("pageSize") Integer pageSize);



//测绘管理接口


    /**
     * @Description: 查询单位基本信息
     * @Author:czb
     * @Date: 2020/5/22 19:08
     * @Param: [userId]
     * @return: com.aaa.qy108.base.ResultData
     */
    @PostMapping("/unit/selectUnitInfo")
    ResultData selectUnitInfo(@RequestParam("userId") String userId);

    /**
     * @Description: 修改单位信息
     * @Author:czb
     * @Date: 2020/5/22 20:29
     * @Param: [mappingUnit]
     * @return: com.aaa.qy108.base.ResultData
     */
    @PostMapping("/unit/updateUnitInfo")
    ResultData updateUnitInfo(@RequestBody MappingUnit mappingUnit);



   /**
   * @Auther: czb
   * @Description:
    * 查询全部的单位负责人信息
   * @Date: 2020/7/27 22:35
   * @param [userId]
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping("/unit/selectAllPrincipal")
    ResultData selectAllPrincipal(@RequestParam("userId") String userId);

    /**
    * @Auther: czb
    * @Description:
     * 查询全部技术员信息
    * @Date: 2020/7/27 22:35
    * @param [userId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/unit/selectAllTechnicist")
    ResultData selectAllTechnicist(@RequestParam("userId") String userId);


    /**
     *
     * @Param: [id]
     * @Return: com.aaa.qy108.base.ResultData
     * 查询单个技术人员信息
     * @Author: czb
     * @Date: 2020/7/27 21:34
     */
    @PostMapping("/unit/selectTechnicistById")
    ResultData selectTechnicistById(@RequestParam("id") String id);


   /**
   * @Auther: czb
   * @Description:
    * 根据id删除技术人员信息
   * @Date: 2020/7/27 22:35
   * @param [id]
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping("/unit/deleteTechnicistById")
    ResultData deleteTechnicistById(@RequestParam("id") String id);


         /**
         * @Auther: czb
         * @Description:
          * 修改技术人员信息
         * @Date: 2020/7/27 22:36
         * @param [technicist]
         * @return com.aaa.yay.base.ResultData
         */
    @PostMapping("/unit/updatedTechnicistById")
    ResultData updatedTechnicistById(@RequestBody Technicist technicist);

   /**
   * @Auther: czb
   * @Description:
    * 添加技术人员信息
   * @Date: 2020/7/27 22:59
   * @param [files, majorType, name, idType, idNumber, age, sex, workYear, duty, title, school, graduationDate, degree, educationBackground, major, titleMajor, startTime, titleTime, startContract, endContract, post, mappingYear, specialPost, affirm, userId]
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping(value = "/unit/addTechnicist",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    ResultData addTechnicist(@RequestPart(value = "files") MultipartFile[] files,@RequestParam("majorType") String majorType,@RequestParam("name") String name,@RequestParam("idType") String idType,
                             @RequestParam("idNumber") String idNumber,@RequestParam("age") Integer age,@RequestParam("sex") Integer sex,
                             @RequestParam("workYear") Integer workYear,@RequestParam("duty") String duty,@RequestParam("title") String title,
                             @RequestParam("school") String school,@RequestParam("graduationDate") String graduationDate,@RequestParam("degree") String degree,
                             @RequestParam("educationBackground") String educationBackground,@RequestParam("major") String major,
                             @RequestParam("titleMajor") String titleMajor,@RequestParam("startTime") String startTime,@RequestParam("titleTime") String titleTime,
                             @RequestParam("startContract") String startContract,@RequestParam("endContract") String endContract,@RequestParam("post") String post,
                             @RequestParam("mappingYear") Integer mappingYear,@RequestParam("specialPost") String specialPost,@RequestParam("affirm") String affirm,
                             @RequestParam("userId") Long userId);


          /**
          * @Auther: czb
          * @Description:
           * ftp文件上传，因为feign只能发送默认普通类型，不能发送特殊类型，所以需要转换
           *             让postmapping去接收MultipartFile类型
          * @Date: 2020/7/27 23:01
          * @param [file]
          * @return java.lang.Boolean
          */
    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(MultipartFile file);

    /**
    * @Auther: czb
    * @Description:
     * 添加单位负责人
    * @Date: 2020/7/27 23:17
    * @param [files, type, name, idType, idNumber, age, sex, workYear, duty, title, major, mappingYear, userId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping(value = "/unit/addPrincipal",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData addPrincipal(@RequestPart(value = "files") MultipartFile[] files, @RequestParam("type") String type, @RequestParam("name") String name, @RequestParam("idType") String idType,
                            @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                            @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                            @RequestParam("major") String major, @RequestParam("mappingYear") Integer mappingYear, @RequestParam("userId") Long userId);


   /**
   * @Auther: czb
   * @Description:
    * 查询单个负责人的信息
   * @Date: 2020/7/27 23:33
   * @param [id]
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping("/unit/selectPrincipalById")
    ResultData selectPrincipalById(@RequestParam("id") String id);



      /**
      * @Auther: czb
      * @Description:
       * 根据id删除单个负责人的信息
      * @Date: 2020/7/27 23:37
      * @param [id]
      * @return com.aaa.yay.base.ResultData
      */
    @PostMapping("/unit/deletePrincipalById")
    ResultData deletePrincipalById(@RequestParam("id") String id);

    /**
    * @Auther: czb
    * @Description:
     * 添加测绘成果及档案管理
    * @Date: 2020/7/27 23:48
    * @param [file1, file2, file3, file4, unitId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping(value = "/unit/addRecord",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData addRecord(@RequestPart("file1") MultipartFile file1,@RequestPart("file2") MultipartFile file2
            ,@RequestPart("file3") MultipartFile file3,@RequestPart("file4") MultipartFile file4,@RequestParam("unitId") Long unitId);

}


