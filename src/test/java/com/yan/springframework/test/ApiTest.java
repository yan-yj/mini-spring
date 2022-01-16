package com.yan.springframework.test;

import com.yan.springframework.context.support.ClassPathXmlApplicationContext;
import com.yan.springframework.test.bean.IUserService;
import org.junit.Test;


public class ApiTest {
    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("result:" + userService.queryUserInfo());
    }
}

