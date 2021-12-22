package com.yan.springframework.context;

import com.yan.springframework.beans.factory.HierarchicalBeanFactory;
import com.yan.springframework.beans.factory.ListableBeanFactory;
import com.yan.springframework.core.io.ResourceLoader;

/**
 * ApplicationContext
 * 应用上下文
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 19:04
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
