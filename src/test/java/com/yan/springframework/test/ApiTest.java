package com.yan.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.yan.springframework.beans.PropertyValue;
import com.yan.springframework.beans.PropertyValues;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.config.BeanReference;
import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yan.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yan.springframework.context.support.ClassPathXmlApplicationContext;
import com.yan.springframework.core.io.DefaultResourceLoader;
import com.yan.springframework.core.io.Resource;
import com.yan.springframework.test.bean.UserDao;
import com.yan.springframework.test.bean.UserService;
import com.yan.springframework.test.common.MyBeanFactoryPostProcessor;
import com.yan.springframework.test.common.MyBeanPostProcessor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2 读取配置&注册
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3 BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4 Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService",UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果:"+result);
    }


    @Test
    public void test_xml(){
        // 1 初始化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService",UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果："+result);
    }
}

