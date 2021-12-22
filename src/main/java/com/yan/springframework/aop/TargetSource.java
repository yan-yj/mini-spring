package com.yan.springframework.aop;

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

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }
}
