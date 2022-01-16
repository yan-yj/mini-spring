package com.yan.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * Scope
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 15:30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
