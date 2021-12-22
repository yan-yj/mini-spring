package com.yan.springframework.beans.factory.config;

public interface SingletonBeanRigstry {

    public Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
