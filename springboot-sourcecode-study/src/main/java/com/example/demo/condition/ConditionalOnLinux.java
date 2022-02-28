package com.example.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解  @ConditionalOnLinux 与 @Conditional(LinuxCondition.class)等价
 * @Author HeSuiJin
 * @Date 2022/2/28
 */

@Target({
        ElementType.TYPE,
        ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(LinuxCondition.class)
public @interface ConditionalOnLinux {

    // 标注是哪个环境
    String environment() default "";
}
