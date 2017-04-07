package com.hawk.springboot.dal.mapper;

import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemAdmin;

import java.util.List;
import java.util.Map;

/**
 * Created by yannfeng on 2016/11/9.
 */
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
