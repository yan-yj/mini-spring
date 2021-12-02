package com.yan.springframework.beans;

public class BeansExcepton extends RuntimeException{

    public BeansExcepton(){};

    public BeansExcepton(String msg,Throwable cause){
        super(msg,cause);
    }

    public BeansExcepton(String msg) {
        super(msg);
    }
}
