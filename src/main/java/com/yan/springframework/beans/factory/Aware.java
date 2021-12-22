package com.yan.springframework.beans.factory;

/**
 * Aware
 *  Marker superinterface indicating that a bean is eligible to be
 *  notified by the Spring container of a particular framework object
 *  through a callback-style method.  Actual method signature is
 *  determined by individual subinterfaces, but should typically
 *  consist of just one void-returning method that accepts a single
 *  argument.
 *
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/20 17:24
 */
public interface Aware {
}
