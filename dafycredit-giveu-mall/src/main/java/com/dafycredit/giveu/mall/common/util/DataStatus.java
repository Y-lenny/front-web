package com.dafycredit.giveu.mall.common.util;


/**
 * <br>DataStatus 状态值</br>
 *
 * @author lennylv
 * @version 1.0
 * @class DataStatus
 * @date 2017/4/11 23:38
 * @since 1.0
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
