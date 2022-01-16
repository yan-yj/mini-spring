package com.yan.springframework.aop;

import com.yan.springframework.util.ClassUtils;

/**
 * TargetSource
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 15:49
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target){
        this.target = target;
    }

    /**
     * @return the type of targets returned by this {@link TargetSource}
     */
    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    /**
     * Return a target instance. Invoked immediately before the
     * AOP framework calls the "target" of an AOP method invocation.
     * @return Exception if the target object can't be resolved
     */
    public Object getTarget(){
        return this.target;
    }
}
