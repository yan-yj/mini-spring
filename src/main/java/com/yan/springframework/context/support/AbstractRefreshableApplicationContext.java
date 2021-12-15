package com.yan.springframework.context.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * AbstractRefreshableApplicationContext
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 20:35
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException{
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
