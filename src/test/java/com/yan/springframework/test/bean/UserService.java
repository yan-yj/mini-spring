package com.yan.springframework.test.bean;

import com.yan.springframework.beans.factory.annotation.Autowired;
import com.yan.springframework.stereotype.Component;

import java.util.Random;

/**
 * UserService
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 14:34
 */
@Component("userService")
public class UserService implements IUserService{

    private String token;

    @Autowired
    private UserDao userDao;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "小胡，100001，广州 " + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "注册用户：" + userName + "success!";
    }

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
