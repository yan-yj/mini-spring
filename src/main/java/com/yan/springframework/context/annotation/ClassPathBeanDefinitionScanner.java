package com.yan.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.yan.springframework.stereotype.Component;

import java.util.Set;

/**
 * ClassPathBeanDefinitionScanner
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 15:42
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String baenScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(baenScope)) {
                    beanDefinition.setScope(baenScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanclass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanclass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
