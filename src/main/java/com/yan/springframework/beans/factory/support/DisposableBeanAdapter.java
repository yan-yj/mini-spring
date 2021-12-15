package com.yan.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * DisposableBeanAdapter
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/15 16:42
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition){
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // implement the interface of DisposableBean
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }

        // 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroyData".equals(this.destroyMethodName))){
            Method destoryMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destoryMethod){
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destoryMethod.invoke(bean);
        }
    }
}
