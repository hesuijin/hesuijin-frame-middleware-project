package com.example.demo.condition;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 实现spring 的Condition接口，并且重写matches()方法，如果@ConditionalOnLinux的注解属性environment是linux就返回true
 * @Author HeSuiJin
 * @Date 2022/2/28
 */
@Slf4j
public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        // 获得注解@ConditionalOnLinux的所有属性
        List<AnnotationAttributes> allAnnotationAttributes = annotationAttributesFromMultiValueMap(
                metadata.getAllAnnotationAttributes(
                        ConditionalOnLinux.class.getName()));

        for (AnnotationAttributes annotationAttributes : allAnnotationAttributes) {
            // 获得注解@ConditionalOnLinux的environment属性
            String environment = annotationAttributes.getString("environment");
            // 若environment等于linux，则返回true
            if ("linux".equals(environment)) {
                return true;
            }
        }
        return false;
    }

    /**
     * MultiValueMap 转 List<AnnotationAttributes>
     * @param multiValueMap
     * @return
     */
    private List<AnnotationAttributes> annotationAttributesFromMultiValueMap(MultiValueMap<String, Object> multiValueMap) {
        log.info("annotationAttributesFromMultiValueMap 入参："+ JSONObject.toJSONString(multiValueMap));
        List<Map<String, Object>> maps = new ArrayList<>();
        multiValueMap.forEach((key, value) -> {
            for (int i = 0; i < value.size(); i++) {
                Map<String, Object> map;
                if (i < maps.size()) {
                    map = maps.get(i);
                } else {
                    map = new HashMap<>();
                    maps.add(map);
                }
                map.put(key, value.get(i));
            }
        });
        List<AnnotationAttributes> annotationAttributes = new ArrayList<>(maps.size());
        for (Map<String, Object> map : maps) {
            annotationAttributes.add(AnnotationAttributes.fromMap(map));
        }
        log.info("annotationAttributesFromMultiValueMap 响应："+ JSONObject.toJSONString(annotationAttributes));
        return annotationAttributes;
    }

}
