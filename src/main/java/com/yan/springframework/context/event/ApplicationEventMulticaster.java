package com.yan.springframework.context.event;

import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.context.ApplicationEvent;
import com.yan.springframework.context.ApplicationListener;

/**
 * ApplicationEventMulticaster
 *
 *  Interface to be implemented by objects that can manage a number of
 *  {@link ApplicationListener} objects, and publish events to them.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 19:45
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
