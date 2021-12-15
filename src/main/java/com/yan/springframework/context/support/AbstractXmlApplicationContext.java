package com.yan.springframework.context.support;

import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yan.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * AbstractXmlApplicationContext
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/14 20:40
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
