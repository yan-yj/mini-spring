package com.yan.springframework.beans.factory.support;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * CglibSubclassingInstantiationStrategy
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 15:16
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanclass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
       if (ctor == null){
           return enhancer.create();
       }
       return enhancer.create(ctor.getParameterTypes(), args);
    }
}
