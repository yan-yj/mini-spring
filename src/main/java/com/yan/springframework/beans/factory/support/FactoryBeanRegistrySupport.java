package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FactoryBeanRegistrySupport
 *
 *   Support base class for singleton registries which need to handle
 *   {@link com.yan.springframework.beans.factory.FactoryBean} instances,
 *   integrated with {@link DefaultSingletonBeanRegistry}'s singleton management.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 16:14
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName){
        Object obj = this.factoryBeanObjectCache.get(beanName);
        return (obj == NULL_OBJECT ? null : obj);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName){
        if (factory.isSingleton()){
            Object obj = this.factoryBeanObjectCache.get(beanName);
            if (obj == null){
                obj = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (obj == null ? NULL_OBJECT : obj));
            }
            return (obj == null ? NULL_OBJECT : obj);
        }else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        }catch (Exception e){
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
