package com.yan.springframework.test;

import com.yan.springframework.beans.factory.config.BeanDefinition;
import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.support.DefaultListableBeanFactory;
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

        // 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小虎");
        userService.queryUserInfo();
    }

    @Test
    public void test_cglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class},new Object[]{"小晏"});
        System.out.println(obj);
    }

    @Test
    public void test_newInsatnce() throws IllegalAccessException, InstantiationException{
        UserService userServiceClass = UserService.class.newInstance();
        System.out.println(userServiceClass);
    }

    @Test
    public void test_constructor()throws NoSuchMethodException,IllegalAccessException, InvocationTargetException,InstantiationException{
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("小胡");
        System.out.println(userService);
    }

    @Test
    public void test_parameterTypes()throws Exception{
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance();
        System.out.println(userService);
    };
}

