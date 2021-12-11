package com.yan.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 17:55
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyValueName){
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyValueName)){
                return pv;
            }
        }
        return null;
    }
}
