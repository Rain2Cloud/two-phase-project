package com.aaa.yay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author yay
 * @Description ApplicationRun8082
 * @CreatTime 2020年 07月17日 星期五 09:29:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.yay.mapper")
public class ApplicationRun8182 {
    public static void main(String[] args){
        SpringApplication.run(ApplicationRun8182.class,args);
    }
}
