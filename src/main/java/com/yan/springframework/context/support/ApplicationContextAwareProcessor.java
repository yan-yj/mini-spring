package com.yan.springframework.context.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.context.ApplicationContext;
import com.yan.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAwareProcessor
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/21 15:35
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postPrecessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
