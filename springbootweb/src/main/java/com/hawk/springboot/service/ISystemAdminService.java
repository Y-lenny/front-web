package com.hawk.springboot.service;

import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemAdmin;

import java.util.List;

/**
 * Created by yannfeng on 2016/9/1.
 */
public interface ISystemAdminService {

    int saveOrUpdateSystemAdmin(SystemAdmin admin, Integer optUserId);

    int deleteSystemAdmin(Integer id);

    int deleteSystemAdmin(Integer id, Integer optUserId, boolean real);

    List<SystemAdmin> findAllSystemAdmin();

    List<SystemAdmin> findSystemAdminByPage(PageBean page);

    SystemAdmin getSystemAdminByAccount(String account);

    SystemAdmin getSystemAdminById(Integer id);
}
