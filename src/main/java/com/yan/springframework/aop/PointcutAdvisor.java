package com.yan.springframework.aop;

/**
 * PointcutAdvisor
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 20:35
 */
public interface PointcutAdvisor extends Advisor{
    /**
     * Get the Pointcut that drives this advisor.
     */
    PointCut getPointCut();
}
