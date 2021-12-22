package com.yan.springframework.beans.factory;

/**
 * FactoryBean
 *
 *  Interface to be implemented by objects used within a {@link BeanFactory}
 *  which are themselves factories. If a bean implements this interface,
 *  it is used as a factory for an object to expose, not directly as a bean
 *  instance that will be exposed itself.
 *  @param <T>
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 16:08
 */
public interface FactoryBean <T>{

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
