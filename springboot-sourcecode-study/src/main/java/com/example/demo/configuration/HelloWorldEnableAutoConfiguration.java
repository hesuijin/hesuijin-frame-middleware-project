package com.example.demo.configuration;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2022/2/27
 */
@Configuration
@EnableConfigurationProperties(HelloWorldComponentProperties.class)
@ConditionalOnClass(HelloWorldComponent.class)
@ConditionalOnProperty(prefix = "hello.world",matchIfMissing = false,value = {"name","age"})
public class HelloWorldEnableAutoConfiguration {

    @Autowired
    private HelloWorldComponentProperties helloWorldComponentProperties;

    @Bean
    public HelloWorldComponent helloWorldComponent(){
        HelloWorldComponent helloWorldComponent =new HelloWorldComponent();
        helloWorldComponent.setName(helloWorldComponentProperties.getName());
        helloWorldComponent.setAge(helloWorldComponentProperties.getAge());
        return helloWorldComponent;
    }

}
