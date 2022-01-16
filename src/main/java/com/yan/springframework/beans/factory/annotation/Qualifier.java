package com.yan.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Qualifier
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 20:38
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
