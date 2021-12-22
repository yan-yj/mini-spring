package com.yan.springframework.context;

/**
 * ApplicationEventPublisher
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 20:14
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
