package com.yan.springframework.test;

import com.yan.springframework.BeanDefinition;
import com.yan.springframework.BeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
//        初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

//        注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeandefinitoin("UserService",beanDefinition);

//        获取bean
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
    }
}
