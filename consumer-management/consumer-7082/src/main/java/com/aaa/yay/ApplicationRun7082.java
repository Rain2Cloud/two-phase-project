package com.aaa.yay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author yay
 * @Description ApplicationRun7082
 * @CreatTime 2020年 07月21日 星期二 15:21:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.aaa.yay"})
public class ApplicationRun7082 {
    public static void main(String[] args){
        SpringApplication.run(ApplicationRun7082.class,args);
    }
}
