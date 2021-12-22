package com.yan.springframework.test;

import com.yan.springframework.context.support.ClassPathXmlApplicationContext;
//import com.yan.springframework.test.bean.UserService;
import com.yan.springframework.test.event.CustomEvent;
import org.junit.Test;
//import org.openjdk.jol.info.ClassLayout;

public class ApiTest {

    @Test
    public void test_event(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}

