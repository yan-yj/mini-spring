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
    public void test_xml(){
        // 初始化BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 获取Bean对象的调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果："+result);

        System.out.println("ApplicationContext: " + userService.getApplicationContext());
        System.out.println("BeanFactoryAware: "+userService.getBeanFactory());
    }
}

