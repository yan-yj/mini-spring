package com.yan.springframework.test.common;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.PropertyValue;
import com.yan.springframework.beans.PropertyValues;
import com.yan.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * MyBeanFactoryPostProcessor
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/15 11:05
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company","改为：字节跳动"));
    }
}
