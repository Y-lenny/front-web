package com.dafycredit.giveu.mall.admin.service;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;
import com.dafycredit.giveu.mall.common.util.PageBean;

import java.util.List;

public interface ISystemAdminService {

    int saveOrUpdateSystemAdmin(SystemAdmin admin, Integer optUserId);

    int deleteSystemAdmin(Integer id);

    int deleteSystemAdmin(Integer id, Integer optUserId, boolean real);

    List<SystemAdmin> findAllSystemAdmin();

    List<SystemAdmin> findSystemAdminByPage(PageBean page);

    SystemAdmin getSystemAdminByAccount(String account);

    SystemAdmin getSystemAdminById(Integer id);
}
