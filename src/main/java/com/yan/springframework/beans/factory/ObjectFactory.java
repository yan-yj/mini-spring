package com.yan.springframework.beans.factory;

import com.yan.springframework.beans.BeansException;

/**
 * ObjectFactory
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/18 10:54
 */
public interface ObjectFactory <T>{
    T getObject() throws BeansException;
}
