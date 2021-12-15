package com.yan.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * UserDao
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 18:27
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initData(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "小晏");
        hashMap.put("10002", "小胡");
        hashMap.put("10003", "小李");
    }

    public void destroyData(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
