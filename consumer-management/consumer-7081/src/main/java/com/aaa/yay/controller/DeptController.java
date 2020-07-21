package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Dept;
import com.aaa.yay.service.SystemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/18 16:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    private SystemApi systemApi;

    /**
    * @Auther: czb
    * @Description:
     * 添加部门
    * @Date: 2020/7/18 16:09
    * @param [dept]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept){
        return systemApi.addDept(dept);
    }
    /**
    * @Auther: czb
    * @Description:
     * 批量删除部门
    * @Date: 2020/7/18 16:12
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
    @DeleteMapping("/delDept")
      public ResultData delDept(@RequestBody List<Long> ids){
        return systemApi.delDept(ids);
    }

    /**
    * @Auther: czb
    * @Description:
     * 修改部门
    * @Date: 2020/7/18 16:14
    * @param [dept]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateDept")
        public  ResultData updateDept(@RequestBody Dept dept){
        return  systemApi.updateDept(dept);
    }

    /**
    * @Auther: czb
    * @Description:
     * 带条件查询部门
    * @Date: 2020/7/18 16:16
    * @param [map]
    * @return com.aaa.yay.base.ResultData
    */
        @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody HashMap map){
        return systemApi.selectAllDept(map);
        }

}
