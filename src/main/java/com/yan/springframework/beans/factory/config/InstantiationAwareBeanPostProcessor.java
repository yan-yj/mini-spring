package com.yan.springframework.beans.factory.config;

import com.yan.springframework.beans.BeansException;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 21:00
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     *
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
