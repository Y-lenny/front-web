package com.hawk.springboot.enums;


import com.hawk.springboot.common.Labeled;

/**
 * Created by yannfeng on 2016/9/14.
 */
public enum DataStatus implements Labeled {

    ENABLE("启用"), DISABLE("禁用"), DELETE("删除");

    private String label;

    private DataStatus(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
