package com.yan.springframework.beans.factory;


public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String anme, Object... args);

}
