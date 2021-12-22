package com.yan.springframework.test.bean;

import java.util.Random;

/**
 * UserService
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 14:34
 */
public class UserService implements IUserService{
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "小胡，100001，广州";
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
}
