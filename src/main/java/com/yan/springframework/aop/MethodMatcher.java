package com.yan.springframework.aop;

import java.lang.reflect.Method;

/**
 * MethodMatcher
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 15:05
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches.
     * @param method
     * @param targetClass
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
