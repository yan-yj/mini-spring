package com.yan.springframework.context.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.yan.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.context.ConfigurableApplicationContext;
import com.yan.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * AbstractApplicationContext
 *  Abstract implementation of the {@link com.yan.springframework.context.ApplicationContext}
 *  interface. Doesn't mandate the type of storage used for configuration; simply
 *  implements common context functionality. Uses the Template Method design pattern,
 *  requiring concrete subclasses to implement abstract methods.
 *  <p>
 *  抽象应用上下文
 *  <p>
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 19:11
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void refresh() throws BeansException {
        // 1 创建BeanFactory，加载BeanDefinition
        refreshBeanFactory();

        // 2 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4 BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public void registerShutdownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close(){
        getBeanFactory().destroySingletons();
    }
}
