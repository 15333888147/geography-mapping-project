package com.aaa.gpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
@SpringBootApplication
@EnableConfigServer
public class Application4081 {

    public static void main(String[] args) {
        SpringApplication.run(Application4081.class,args);
    }

}
