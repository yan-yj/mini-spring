package com.yan.springframework.stereotype;

import java.lang.annotation.*;

/**
 * Component
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/16 15:34
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
