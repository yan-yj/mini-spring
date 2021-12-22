package com.yan.springframework.context.event;

import com.yan.springframework.beans.factory.BeanFactory;
import com.yan.springframework.beans.factory.DisposableBean;
import com.yan.springframework.context.ApplicationEvent;
import com.yan.springframework.context.ApplicationListener;

/**
 * SimpleApplicationEventMulticaster
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/22 20:21
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)){
            listener.onApplicationEvent(event);
        }
    }

}
