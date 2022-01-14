package com.yan.springframework.test.bean;

import com.yan.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * UserServiceBeforeAdvice
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 21:21
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
