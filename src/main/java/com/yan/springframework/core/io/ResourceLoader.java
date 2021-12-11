package com.yan.springframework.core.io;

/**
 * ResourceLoader
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:10
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";
    Resource getResource(String location);
}
