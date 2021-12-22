package com.yan.springframework.beans.factory;

import com.yan.springframework.beans.BeansException;

/**
 * BeanFactoryAware
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/20 17:30
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
