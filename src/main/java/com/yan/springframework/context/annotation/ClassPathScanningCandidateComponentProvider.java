package com.yan.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ClassPathScanningCandidateComponentProvider
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 15:36
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
