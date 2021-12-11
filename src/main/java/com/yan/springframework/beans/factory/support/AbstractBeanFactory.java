package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansExcepton;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansExcepton {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args){
        return doGetBean(name, args);
    }

    protected <T> T  doGetBean(final String name, final Object[] args){
        Object bean = getSingleton(name);
        if (bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansExcepton;
    protected abstract Object createBean (String name,BeanDefinition beanDefinition, Object[] args) throws BeansExcepton;
}
