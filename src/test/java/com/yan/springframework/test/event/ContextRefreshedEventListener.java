package com.yan.springframework.test.event;

import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.context.ApplicationListener;
import com.yan.springframework.context.event.ContextRefreshedEvent;

/**
 * ContextRefreshedEventListener
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 20:55
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
