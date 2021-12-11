package com.yan.springframework.beans.factory.config;

import com.yan.springframework.beans.PropertyValues;

public class BeanDefinition {

    private Class beanclass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanclass) {
        this.beanclass = beanclass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanclass, PropertyValues propertyValues){
        this.beanclass = beanclass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();



    }

    public Class getBeanclass() {
        return beanclass;
    }

    public void setBeanclass(Class beanclass){
        this.beanclass = beanclass;
    }

    public PropertyValues getPropertyValues(){
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues){
        this.propertyValues = propertyValues;
    }
}
