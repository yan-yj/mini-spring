package com.yan.springframework.context;

import java.util.EventObject;

/**
 * ApplicationEvent
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 19:38
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
