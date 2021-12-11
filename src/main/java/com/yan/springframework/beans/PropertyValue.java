package com.yan.springframework.beans;

/**
 * PropertyValue
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 17:54
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
