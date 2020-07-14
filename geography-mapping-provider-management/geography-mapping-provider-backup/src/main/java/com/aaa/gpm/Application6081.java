package com.aaa.gpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.gpm.mapper")
public class Application6081 {

    public static void main(String[] args) {
        SpringApplication.run(Application6081.class,args);
    }

}
