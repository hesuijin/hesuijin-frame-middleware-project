package com.example.demo.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2022/2/27
 */

@ConfigurationProperties(prefix ="helloworld.configurationproperties")
@Data
public class HelloWorldComponentProperties {
    private String name;
    private String age ;
}
