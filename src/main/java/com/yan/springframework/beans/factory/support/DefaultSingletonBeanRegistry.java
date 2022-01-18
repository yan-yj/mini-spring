package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.beans.factory.ObjectFactory;
import com.yan.springframework.beans.factory.config.SingletonBeanRigstry;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRigstry {

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    /**
     * 一级缓存，存放普通对象
     * Cache of singleton objects: bean name --> bean instance
     */
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 二级缓存，存放提前暴露的对象、没有完成实例化的对象(半成品)
     * Cache of early singleton objects: bean name --> bean instance
     */
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

    /**
     * 三级缓存，存放代理对象
     * Cache of singleton factories: bean name --> ObjectFactory
     */
    protected final Map<String, ObjectFactory<?>> singletonFactories =new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        // 先尝试从一级缓存中获取对象
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            // 无法从一级缓存中取到，则尝试从二级缓存中获取
            singletonObject = earlySingletonObjects.get(beanName);
            if (null == singletonObject) {
                // 无法从二级缓存中取到，则尝试从三级缓存中获取
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (null != singletonFactory) {
                    // 把三级缓存中代理对象的真实对象取出来放入二级缓存，并删除三级缓存中的代理对象
                    singletonObject = singletonFactory.getObject();
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName,ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean){
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons(){
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--){
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' throw an exception", e);
            }
        }
    }
}
