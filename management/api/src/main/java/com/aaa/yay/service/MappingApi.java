package com.aaa.yay.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author yay
 * @Description MappingApi
 * @CreatTime 2020年 07月20日 星期一 22:27:43
 */
@FeignClient("mapping-interface")
public interface MappingApi {

}
