package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.FactoryBean;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.yan.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args){
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> rerequiredType) throws BeansException{
        return (T)getBean(name);
    }

    protected <T> T  doGetBean(final String name, final Object[] args){
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null){
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName){
        if (!(beanInstance instanceof FactoryBean)){
            return beanInstance;
        }

        Object obj = getCachedObjectForFactoryBean(beanName);

        if (obj == null){
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            obj = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return obj;
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
    protected abstract Object createBean (String name,BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors(){
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader(){
        return this.beanClassLoader;
    }
}
