package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.core.io.Resource;
import com.yan.springframework.core.io.ResourceLoader;

/**
 * BeanDefinitionReader
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:08
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
