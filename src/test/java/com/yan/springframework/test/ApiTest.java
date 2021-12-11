package com.yan.springframework.test;

import com.yan.springframework.beans.PropertyValue;
import com.yan.springframework.beans.PropertyValues;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.config.BeanReference;
import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yan.springframework.test.bean.UserDao;
import com.yan.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        // 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

