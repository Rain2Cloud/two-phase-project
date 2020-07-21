package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Dept;
import com.aaa.yay.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.LOGIN_TIMEOUT_EXIT;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_SUCCESS;

/**
 * @Author 十八
 * @Date 2020/7/18 15:30
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/dept")
public class DeptController  extends CommonController<Dept> {

    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }

    /**
    * @Auther: czb
    * @Description:
     * 添加部门
    * @Date: 2020/7/18 15:35
    * @param [dept]
    * @return com.aaa.yay.base.ResultData
    */
        @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
        }

        /**
        * @Auther: czb
        * @Description:
         * 批量删除部门
        * @Date: 2020/7/18 15:38
        * @param [ids]
        * @return com.aaa.yay.base.ResultData
        */
        @DeleteMapping("/delDept")
    public ResultData delDept(@RequestBody List<Long> ids){
            return deptService.delDept(ids);
        }

        /**
        * @Auther: czb
        * @Description:修改部门信息
        * @Date: 2020/7/18 15:59
        * @param [dept]
        * @return com.aaa.yay.base.ResultData
        */
        @PostMapping("/updateDept")
        public ResultData updateDept (@RequestBody Dept dept){
            return deptService.updateDept(dept);
    }


    /**
    * @Auther: czb
    * @Description:
     * 带条件查询部门
    * @Date: 2020/7/18 15:59
    * @param [map]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllDept")
   public  ResultData selectAllDept(@RequestBody HashMap map){
        Map<String,Object> resultMap = deptService.selectAllDept(map);
        if(SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap);
        }else{
            return super.selectFailed();
        }
    }




}
