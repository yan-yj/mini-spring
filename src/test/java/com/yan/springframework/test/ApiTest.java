package com.yan.springframework.test;

import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yan.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
//        初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//        注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

//        第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
//        第二次获取bean
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
        System.out.println(userService==userService_singleton);
    }
}
