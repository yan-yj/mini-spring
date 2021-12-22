package com.yan.springframework.beans.factory;

/**
 * BeanNameAware
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/20 17:29
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
