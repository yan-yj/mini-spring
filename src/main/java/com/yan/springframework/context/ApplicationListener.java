package com.yan.springframework.context;

import java.util.EventListener;

/**
 * ApplicationListener
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 19:47
 */
public interface ApplicationListener <E extends  ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
