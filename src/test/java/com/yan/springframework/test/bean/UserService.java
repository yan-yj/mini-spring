package com.yan.springframework.test.bean;

public class UserService {
    private static int times = 0;
    static {
        times++;
    }
    public void queryUserInfo(){

        System.out.println(times+" Hello,Spring!");

    }
}
