package com.hawk.springboot.common;

import java.io.Serializable;

/**
 * Created by yannfeng on 2016/9/14.
 */
public class Order implements Serializable {
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    private String name;

    private String mode = ASC;

    /**
     * Constructor for Order.
     */
    private Order(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Ascending order
     *
     * @param name
     * @return Order
     */
    public static Order asc(String name) {
        return new Order(name, ASC);
    }

    /**
     * Descending order
     *
     * @param name
     * @return Order
     */
    public static Order desc(String name) {
        return new Order(name, DESC);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (ASC == mode ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Order other = (Order) obj;
        if (name == null) {
            if (other.name != null)
                return false;
            if (mode != other.mode)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + ' ' + mode;
    }
}
