package com.yan.springframework.context.event;

/**
 * ContextClosedEvent
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 19:44
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
