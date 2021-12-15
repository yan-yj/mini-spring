package com.yan.springframework.test.common;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.test.bean.UserService;

/**
 * MyBeanPostProcessor
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 22:05
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postPrecessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
