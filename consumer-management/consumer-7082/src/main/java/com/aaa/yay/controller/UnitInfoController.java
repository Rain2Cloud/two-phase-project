package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.MappingUnit;
import com.aaa.yay.model.Technicist;
import com.aaa.yay.service.MappingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author 十八
 * @Date 2020/7/27 21:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/unit")
public class UnitInfoController extends BaseController {
    @Autowired
    private MappingApi mappingApi;

        /**
        * @Auther: czb
        * @Description:
         *查询单基本信息
        * @Date: 2020/7/27 21:09
        * @param [userId]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/selectUnitInfo")
    public ResultData selectUnitInfo(@RequestParam("userId") String userId){
        return mappingApi.selectUnitInfo(userId);
    }

    /**
    * @Auther: czb
    * @Description:
     * 修改单位基本信息
    * @Date: 2020/7/27 21:16
    * @param [mappingUnit]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateUnitInfo")
    public ResultData updateUnitInfo(@RequestBody MappingUnit mappingUnit){
        return mappingApi.updateUnitInfo(mappingUnit);
    }

        /**
        * @Auther: czb
        * @Description:
         * 添加单位负责人
        * @Date: 2020/7/27 22:49
        * @param [files, type, name, idType, idNumber, age, sex, workYear, duty, title, major, mappingYear, userId]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestParam("files") MultipartFile[] files,@RequestParam("type") String type,@RequestParam("name") String name,@RequestParam("idType") String idType,
                                   @RequestParam("idNumber") String idNumber,@RequestParam("age") Integer age,@RequestParam("sex") Integer sex,
                                   @RequestParam("workYear") Integer workYear,@RequestParam("duty") String duty,@RequestParam("title") String title,
                                   @RequestParam("major") String major,@RequestParam("mappingYear") Integer mappingYear,@RequestParam("userId") Long userId){
        return mappingApi.addPrincipal(files,type,name,idType,idNumber,age,sex,workYear,duty,title,major,mappingYear,userId);
    }

        /**
        * @Auther: czb
        * @Description:
         * 查询所有单位负责人信息 (输入userid查询的是单个的  说我自己搞错了)
        * @Date: 2020/7/27 21:22
        * @param [userId]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/selectAllPrincipal")
    public ResultData selectAllPrincipal(@RequestParam("userId") String userId){
        return  mappingApi.selectAllPrincipal(userId);
    }



    /**
     * @Auther: czb
     * @Description:
     * 查询单个负责人信息(查不到？)
     * @Date: 2020/7/27 21:44
     * @param [id]
     * @return com.aaa.yay.base.ResultData
     */
    @PostMapping("/unit/selectPrincipalById")
    public ResultData selectPrincipalById(@RequestParam("id") String id){
        return mappingApi.selectPrincipalById(id);
    }

    /**
    * @Auther: czb
    * @Description:
     * 根据id删除负责人信息
    * @Date: 2020/7/27 22:51
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/deletePrincipalById")
    public ResultData deletePrincipalById(@RequestParam("id") String id ){
        return mappingApi.deletePrincipalById(id);
    }





    /**
    * @Auther: czb
    * @Description:
     * 查询所有技术人员信息
    * @Date: 2020/7/27 21:37
    * @param [userId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestParam("userId") String userId){
        return mappingApi.selectAllTechnicist(userId);
    }

    /**
    * @Auther: czb
    * @Description:
     * 查询单个技术人员信息
    * @Date: 2020/7/27 21:59
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectTechnicistById")
    public ResultData selectTechnicistById(@RequestParam("id") String id){
        return mappingApi.selectTechnicistById(id);
    }

    /**
    * @Auther: czb
    * @Description:
     * 修改技术人员信息
    * @Date: 2020/7/27 22:24
    * @param [technicist]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updatedTechnicistById")
    public ResultData updatedTechnicistById(@RequestBody Technicist technicist){
        return mappingApi.updatedTechnicistById(technicist);
    }

        /**
        * @Auther: czb
        * @Description:
         * 根据id删除技术人员信息
        * @Date: 2020/7/27 22:27
        * @param [id]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/deleteTechnicistById")
    public ResultData deleteTechnicistById(@RequestParam("id") String id){
        return mappingApi.deleteTechnicistById(id);
    }


    /**
    * @Auther: czb
    * @Description:
     *  添加技术人员信息
    * @Date: 2020/7/27 22:38
    * @param [files, majorType, name, idType, idNumber, age, sex, workYear, duty, title, school, graduationDate, degree, educationBackground, major, titleMajor, startTime, titleTime, startContract, endContract, post, mappingYear, specialPost, affirm, userId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestParam("files") MultipartFile[] files, @RequestParam("majorType") String majorType, @RequestParam("name") String name, @RequestParam("idType") String idType,
                                    @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                                    @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                                    @RequestParam("school") String school, @RequestParam("graduationDate") String graduationDate, @RequestParam("degree") String degree,
                                    @RequestParam("educationBackground") String educationBackground, @RequestParam("major") String major,
                                    @RequestParam("titleMajor") String titleMajor, @RequestParam("startTime") String startTime, @RequestParam("titleTime") String titleTime,
                                    @RequestParam("startContract") String startContract, @RequestParam("endContract") String endContract, @RequestParam("post") String post,
                                    @RequestParam("mappingYear") Integer mappingYear, @RequestParam("specialPost") String specialPost, @RequestParam("affirm") String affirm,
                                    @RequestParam("userId") Long userId){
        System.out.println("我是添加技术人员信息");
        return mappingApi.addTechnicist(files,majorType,name,idType,idNumber,age,sex, workYear,duty,title, school,graduationDate,degree,
                educationBackground,major, titleMajor,startTime,titleTime, startContract,endContract,post, mappingYear,specialPost,affirm, userId);
    }



      /**
      * @Auther: czb
      * @Description:
       * 添加测绘成果及档案管理
      * @Date: 2020/7/28 8:55
      * @param [file1, file2, file3, file4, unitId]
      * @return com.aaa.yay.base.ResultData
      */
    @PostMapping("/addRecord")
    public ResultData addRecord(@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2
            ,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@RequestParam("unitId") Long unitId){
        return mappingApi.addRecord(file1,file2,file3,file4,unitId);
    }






}
