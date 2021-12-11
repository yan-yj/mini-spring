package com.yan.springframework.beans.factory.config;

public class BeanDefinition {

    private Class beanclass;

    public BeanDefinition(Class beanclass) {
        this.beanclass = beanclass;
    }

    public Class getBeanclass() {
        return beanclass;
    }

    public void setBeanclass(Class beanclass){
        this.beanclass = beanclass;
    }

}
