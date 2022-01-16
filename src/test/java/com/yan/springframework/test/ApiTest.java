package com.yan.springframework.test;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.BeanPostProcessor;
import com.yan.springframework.context.support.ApplicationContextAwareProcessor;
import com.yan.springframework.context.support.ClassPathXmlApplicationContext;
import com.yan.springframework.test.bean.IUserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApiTest {
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("result:" + userService.queryUserInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("result:" + userService);
    }

    @Test
    public void test_beanPost() {
        BeanPostProcessor beanPostProcessor = new BeanPostProcessor() {
            @Override
            public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }

            @Override
            public Object postPrecessorAfterInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }
        };
        List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
        System.out.println(beanPostProcessors.size());

        beanPostProcessors.remove(beanPostProcessor);
        System.out.println(beanPostProcessors.size());
    }
}

