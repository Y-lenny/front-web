package com.dafycredit.giveu.mall.common.util;

import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
* <br>分页</br>
*
* @class  PageBean
* @author  lennylv
* @date    2017/4/11 23:41
* @version 1.0
* @since  1.0
*/

public class PageBean implements Serializable {

    private final static Integer DEFAULT_PAGESIZE = 15;

    private Integer page = 1;

    private Integer pageSize = DEFAULT_PAGESIZE;

    private Integer rowCount = 0;

    private Integer pageCount = 0;

    private Order[] orders = null;

    private Map<String, Object> filters;

    public PageBean() {

    }

    public PageBean(Integer page, Integer pageSize) {
        setPage(page);
        setPageSize(pageSize);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if(page == null || page < 1) {
            this.page = 1;
        }
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize != null) {
            this.pageSize = pageSize;
        }
    }

    public Integer getOffset() {
        if(page != null && pageSize != null) {
            return (page - 1) * pageSize;
        }
        return 0;
    }

    public Integer getLimit() {
        if(pageSize != null) {
            return pageSize;
        } else {
            return DEFAULT_PAGESIZE;
        }
    }

    public Map<String, Object> addFilter(String fieldName, Object fieldValue) {
        if(filters == null) {
            filters = new HashMap<String, Object>();
        }

        filters.put(fieldName, fieldValue);
        return filters;
    }

    public Map<String, Object> getFilters() {
        return filters;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        pageCount = (getRowCount() + pageSize - 1) / pageSize;
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setFilters(Map<String, Object> filters) {
        this.filters = filters;
    }

    /**
     * data strat number
     * @return
     */
    public int getStart() {
        return (page - 1) * pageSize;
    }

    /**
     * data end number
     * @return
     */
    public int getEnd() {
        return page.equals(getPageCount()) ? rowCount : page * pageSize;
    }

    /**
     * 是否还有下一页.
     */
    public boolean isHasNext() {
        return (page + 1 <= getPageCount());
    }

    /**
     * 返回下页的页号,序号从1开始.
     */
    public int getNextPage() {
        if (isHasNext())
            return page + 1;
        else
            return page;
    }

    /**
     * 是否还有上一页.
     */
    public boolean isHasPre() {
        return (page - 1 >= 1);
    }

    /**
     * 返回上页的页号,序号从1开始.
     */
    public int getPrePage() {
        if (isHasPre())
            return page - 1;
        else
            return page;
    }

    public PageBean addOrder(Order order) {
        if(orders != null) {
            orders = ArrayUtils.add(orders, order);
        } else {
            orders = new Order[]{order};
        }
        return this;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String getAdminPageNavigation() {

        StringBuffer displayInfo = new StringBuffer();
        displayInfo.append("<div class='col-md-5 col-sm-12'>");
        displayInfo.append("<div class='dataTables_info'>");
        if (getRowCount() == 0) {
            displayInfo.append("总共" + getRowCount() + "条");
        } else {
            int start = getStart();
            int end = getEnd();
            displayInfo.append("显示  " + (start + 1) + " to " + end + " 总共" + getRowCount() + "条");
        }
        displayInfo.append("</div></div>");
        if (getRowCount() > 0) {
            displayInfo.append("<div class='col-md-7 col-sm-12'>");
            displayInfo.append("<div class='dataTables_paginate paging_bootstrap'>");
            displayInfo.append("<div class='pagination' style='visibility: visible;'>");
            if (getPage() == 1) {
                displayInfo.append("<li class='prev disabled'><a href=\"javascript:void(0)\" title='First'><i class='fa fa-angle-double-left'></i></a></li>");
                displayInfo.append("<li class='prev disabled'><a href=\"javascript:void(0)\" title='Prev'><i class='fa fa-angle-left'></i></a></li>");
            } else {
                displayInfo.append("<li class='prev'>");
                displayInfo.append("<a href=\"javascript:pageInfo('1');\" title='First'>");
                displayInfo.append("<i class='fa fa-angle-double-left'></i></a></li>");

                displayInfo.append("<li class='prev'>");
                displayInfo.append("<a href=\"javascript:pageInfo('" + getPrePage() + "');\" title='Prev'>");
                displayInfo.append("<i class='fa fa-angle-left'></i></a></li>");
            }


            int sp = 1;
            int ep = getPageCount() > 10 ? 10 : getPageCount();

            if (getPage() > 6) {
                sp = getPage() - 5;
                ep = sp + 9;
                if (ep > getPageCount()) {
                    ep = getPageCount();
                }
            }
            for (int i = sp; i <= ep; i++) {
                if (i == getPage()) {
                    displayInfo.append("<li class='active'>");
                } else {
                    displayInfo.append("<li>");
                }
                displayInfo.append("<a href=\"javascript:pageInfo('" + i + "');\">" + i + "</a></li>");
            }

            if (getPage() == getPageCount()) {
                displayInfo.append("<li class='next disabled'><a href=\"javascript:void(0)\" title='Next'><i class='fa fa-angle-right'></i></a></li>");
                displayInfo.append("<li class='next disabled'><a href=\"javascript:void(0)\" title='Last'><i class='fa fa-angle-double-right'></i></a></li>");
            } else {
                displayInfo.append("<li class='next'>");
                displayInfo.append("<a href=\"javascript:pageInfo('" + getNextPage() + "');\" title='Next'>");
                displayInfo.append("<i class='fa fa-angle-right'></i></a></li>");

                displayInfo.append("<li class='next'>");
                displayInfo.append("<a href=\"javascript:pageInfo('"+getPageCount()+"');\" title='Last'>");
                displayInfo.append("<i class='fa fa-angle-double-right'></i></a></li>");
            }
            displayInfo.append("</ul></div></div>");
        }
        return displayInfo.toString();
    }
}
