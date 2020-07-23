package com.aaa.yay.service;

import com.aaa.yay.base.ResultData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

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
    @PostMapping("/selectAllEquipment")
        ResultData selectAllEquipment(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);
}
