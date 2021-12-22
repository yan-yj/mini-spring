package com.yan.springframework.aop;

/**
 * PointCut
 * A pointcut is composed of a {@link ClassFilter} and a {@link MethodMatcher}.
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 14:55
 */
public interface PointCut {
    /**
     * Return the ClassFilter for this pointcut.
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     * @return
     */
    MethodMatcher getMethodMatcher();
}
