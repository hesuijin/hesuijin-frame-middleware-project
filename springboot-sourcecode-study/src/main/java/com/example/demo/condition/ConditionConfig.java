package com.example.demo.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2022/2/28
 */

@Configuration
@Slf4j
public class ConditionConfig {
    // 只有`@ConditionalOnLinux`的注解属性`environment`是"linux"时才会创建bean
    @Bean
    @ConditionalOnLinux(environment = "linux")
    public Environment linuxEnvironment() {
        log.info("满足条件，进行Bean的创建");
        return new LinuxEnvironment();
    }
}
