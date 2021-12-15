package com.yan.springframework.beans.factory.config;

import com.yan.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:03
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRigstry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
