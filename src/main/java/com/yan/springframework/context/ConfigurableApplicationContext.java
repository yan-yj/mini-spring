package com.yan.springframework.context;

import com.yan.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext
 *
 *  SPI interface to be implemented by most if not all application contexts.
 *  Provides facilities to configure an application context in addition
 *  to the application context client methods in the
 *  {@link com.yan.springframework.context.ApplicationContext} interface.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 19:05
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
