package com.example.demo.controller;

import com.example.demo.configuration.HelloWorldComponent;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2022/2/27
 */
@RestController
@RequestMapping("helloWorldComponentController")
@Slf4j
public class HelloWorldComponentController {

    @Autowired
    private HelloWorldComponent helloWorldComponent;

    @RequestMapping("helloWorldSpringBean")
    public Object helloWorldSpringBean() {
        log.info("helloWorldComponentController 打印helloWorldComponent："+JSONObject.toJSONString(helloWorldComponent));
        return JSONObject.toJSONString(helloWorldComponent);
    }

    @RequestMapping("helloWorldSpringBeanOther")
    public Object helloWorldSpringBeanOther() {
        helloWorldComponent.setName("我改了名字");
        helloWorldComponent.setAge("我改了年龄");
        log.info("helloWorldComponentController 打印helloWorldComponentOther："+JSONObject.toJSONString(helloWorldComponent));
        return JSONObject.toJSONString(helloWorldComponent);
    }
}
