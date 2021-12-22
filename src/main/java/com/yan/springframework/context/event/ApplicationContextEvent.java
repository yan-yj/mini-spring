package com.yan.springframework.context.event;

import com.yan.springframework.context.ApplicationEvent;

/**
 * ApplicationContextEvent
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 19:40
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContextEvent getApplicationContext() {
        return (ApplicationContextEvent) getSource();
    }
}
