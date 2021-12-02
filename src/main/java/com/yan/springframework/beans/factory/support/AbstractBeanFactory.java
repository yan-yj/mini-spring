package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansExcepton;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansExcepton {
        Object bean = getSingleton(name);
        if (bean != null ){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansExcepton;
    protected abstract Object createBean (String name,BeanDefinition beanDefinition) throws BeansExcepton;
}
