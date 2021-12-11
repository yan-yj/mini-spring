package com.yan.springframework.beans.factory;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:00
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
