package com.yan.springframework.test.bean;

/**
 * IUserService
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 14:29
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
