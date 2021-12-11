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

    static {
        hashMap.put("10001", "小晏");
        hashMap.put("10002", "小胡");
        hashMap.put("10003", "小李");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
