package com.example.demo.helloworldcomponent.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.helloworldcomponent.configuration.HelloWorldComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2022/2/27
 */
@RestController
@RequestMapping("helloWorldComponentControllerInOther")
@Slf4j
public class HelloWorldComponentControllerInOther {

    @Autowired
    private HelloWorldComponent helloWorldComponent;

    @RequestMapping("helloWorldSpringBean")
    public Object helloWorldSpringBean() {
        log.info("helloWorldComponentControllerInOther 打印helloWorldComponent："+JSONObject.toJSONString(helloWorldComponent));
        return JSONObject.toJSONString(helloWorldComponent);
    }

}
