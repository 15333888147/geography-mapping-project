package com.aaa.gpm.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: gcy
 * @DateTime: 2020/7/10 15:46
 * @Description: TODO
 */
//@Component
//@PropertySource("classpath:properties/ftp.properties")
//@ConfigurationProperties(prefix = "spring.ftp")
@Data
public class FtpProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String basePath;
    private String httpPath;
}
