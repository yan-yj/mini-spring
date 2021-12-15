package com.yan.springframework.beans.factory;

/**
 * InitializingBean
 *
 *  Interface to be implemented by beans that need to react once all their
 *  * properties have been set by a BeanFactory: for example, to perform custom
 *  * initialization, or merely to check that all mandatory properties have been set.
 *  *
 *  * 实现此接口的 Bean 对象，会在 BeanFactory 设置属性后作出相应的处理，如：执行自定义初始化，或者仅仅检查是否设置了所有强制属性。
 *  *
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/15 16:17
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
