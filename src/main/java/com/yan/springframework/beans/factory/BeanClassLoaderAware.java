package com.yan.springframework.beans.factory;

/**
 * BeanClassLoaderAware
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/20 17:27
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
