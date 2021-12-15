package com.yan.springframework.beans.factory;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 *  Configuration interface to be implemented by most listable bean factories.
 *  * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 *  * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:00
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
