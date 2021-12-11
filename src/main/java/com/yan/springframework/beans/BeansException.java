package com.yan.springframework.beans;

public class BeansException extends RuntimeException{

    public BeansException(){};

    public BeansException(String msg, Throwable cause){
        super(msg,cause);
    }

    public BeansException(String msg) {
        super(msg);
    }
}
