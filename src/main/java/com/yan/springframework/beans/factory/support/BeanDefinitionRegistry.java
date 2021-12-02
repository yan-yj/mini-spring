package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
