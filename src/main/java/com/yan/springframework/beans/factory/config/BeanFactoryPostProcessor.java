package com.yan.springframework.beans.factory.config;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.ConfigurableListableBeanFactory;


/**
 * BeanFactoryPostProcessor
 *  Allows for custom modification of an application context's bean definitions,
 *  adapting the bean property values of the context's underlying bean factory.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 19:19
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
