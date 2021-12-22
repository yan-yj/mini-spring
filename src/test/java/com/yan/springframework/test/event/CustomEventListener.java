package com.yan.springframework.test.event;

import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.context.ApplicationListener;

import java.util.Date;


/**
 * CustomEventListener
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 20:53
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
