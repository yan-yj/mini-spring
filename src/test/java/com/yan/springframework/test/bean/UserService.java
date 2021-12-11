package com.yan.springframework.test.bean;

public class UserService {
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){

        System.out.println("Hello,"+name+"!");

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(name);
        return sb.toString();
    }
}
