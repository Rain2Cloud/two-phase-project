package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.service.MappingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 十八
 * @Date 2020/7/21 15:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends BaseController {

    @Autowired
    private MappingApi mappingApi;


    /**
    * @Auther: czb
    * @Description:
     * 分页查询设备信息
    * @Date: 2020/7/21 15:51
    * @param [pageNo, pageSize]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllEquipment")
     public ResultData selectAllEquipment(@RequestParam("pageNo") Integer pageNo , @RequestParam("pageSize") Integer pageSize){
        return mappingApi.selectAllEquipment(pageNo,pageSize);
    }
}
