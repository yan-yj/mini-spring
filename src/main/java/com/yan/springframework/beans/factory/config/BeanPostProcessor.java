package com.yan.springframework.beans.factory.config;

import com.yan.springframework.beans.BeansException;

/**
 * BeanPostProcessor
 *  Factory hook that allows for custom modification of new bean instances,
 *  * e.g. checking for marker interfaces or wrapping them with proxies.
 *  *
 *  * 用于修改新实例化 Bean 对象的扩展点
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 19:29
 */
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postPrecessorAfterInitialization(Object bean, String beanName) throws BeansException;
}
