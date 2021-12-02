package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansExcepton;
import com.yan.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansExcepton {
        Object bean = null;
        try{
            bean = beanDefinition.getBeanclass().newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            throw new BeansExcepton("Instantiation of bean failed",e);
        }
        addSingleton(name,bean);
        return bean;
    }
}
