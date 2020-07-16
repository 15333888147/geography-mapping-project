package com.aaa.gpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zj
 * @Date: 2020/7/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application8081 {

    public static void main(String[] args) {
        SpringApplication.run(Application8081.class,args);
    }

}
