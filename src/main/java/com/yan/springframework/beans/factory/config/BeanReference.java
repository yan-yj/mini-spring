package com.yan.springframework.beans.factory.config;

/**
 * BeanReference
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 18:03
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName(){
        return beanName;
    }
}
