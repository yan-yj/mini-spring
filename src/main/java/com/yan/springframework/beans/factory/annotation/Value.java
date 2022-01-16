package com.yan.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * value
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 20:40
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value();
}
