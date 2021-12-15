package com.yan.springframework.beans.factory;

/**
 * DisposableBean
 *
 *  Interface to be implemented by beans that want to release resources
 *  * on destruction. A BeanFactory is supposed to invoke the destroy
 *  * method if it disposes a cached singleton. An application context
 *  * is supposed to dispose all of its singletons on close.
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/15 16:18
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
