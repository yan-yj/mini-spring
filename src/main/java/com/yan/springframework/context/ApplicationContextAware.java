package com.yan.springframework.context;

import com.yan.springframework.beans.BeansException;
import com.yan.springframework.beans.factory.Aware;

/**
 * ApplicationContextAware
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/20 17:31
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
