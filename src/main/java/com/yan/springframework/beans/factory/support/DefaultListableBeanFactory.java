package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansExcepton;
import com.yan.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String name) throws BeansExcepton {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition != null){
            return beanDefinition;
        }
        throw new BeansExcepton(name + "is not defined");
    }


    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name,beanDefinition);
    }
}
