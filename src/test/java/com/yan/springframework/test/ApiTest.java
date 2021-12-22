package com.yan.springframework.test;

import com.yan.springframework.aop.AdvisedSupport;
import com.yan.springframework.aop.MethodMatcher;
import com.yan.springframework.aop.TargetSource;
import com.yan.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.yan.springframework.aop.framework.Cglib2AopProxy;
import com.yan.springframework.aop.framework.JdkDynamicAopProxy;
import com.yan.springframework.aop.framework.ReflectiveMethodInvocation;
import com.yan.springframework.context.support.ClassPathXmlApplicationContext;
//import com.yan.springframework.test.bean.UserService;
import com.yan.springframework.test.bean.IUserService;
import com.yan.springframework.test.bean.UserService;
import com.yan.springframework.test.bean.UserServiceInterceptor;
import com.yan.springframework.test.event.CustomEvent;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//import org.openjdk.jol.info.ClassLayout;

public class ApiTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.yan.springframework.test.bean.IUserService.*(..))");

        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.yan.springframework.test.bean.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("result:" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("result" + proxy_cglib.register("小林"));

    }

    @Test
    public void test_proxy_method(){
        // 目标对象
        Object targetObj = new UserService();

        // AOP代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.yan.springframework.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())){
                    MethodInterceptor methodInterceptor = methodInvocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return methodInvocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + methodInvocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        String result = proxy.queryUserInfo();
        System.out.println(result);
    }
}

