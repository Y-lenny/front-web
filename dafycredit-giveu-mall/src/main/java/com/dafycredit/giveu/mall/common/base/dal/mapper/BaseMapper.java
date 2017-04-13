package com.dafycredit.giveu.mall.common.base.dal.mapper;


import com.dafycredit.giveu.mall.common.util.PageBean;

import java.util.List;
import java.util.Map;


public interface BaseMapper<T> {

    T getByAccount(String account);

    int insert(T t);

    int update(T t);

    int delete(Integer id);

    List<T> queryAll();

    List<T> queryByPage(PageBean pageBean);

    Long countByFilter(Map<String, Object> filters);

    T getById(Integer id);

}
