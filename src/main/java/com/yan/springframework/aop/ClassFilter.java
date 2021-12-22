package com.yan.springframework.aop;

/**
 * ClassFilter
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 15:02
 */
public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
