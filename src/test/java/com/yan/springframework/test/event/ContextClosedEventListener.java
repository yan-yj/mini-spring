package com.yan.springframework.test.event;

import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.context.ApplicationListener;
import com.yan.springframework.context.event.ContextClosedEvent;

/**
 * ContextClosedEventListener
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 20:57
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
