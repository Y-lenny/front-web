package com.dafycredit.giveu.mall.admin.service;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemRoleModule;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemRole;
import com.dafycredit.giveu.mall.common.util.PageBean;

import java.util.List;


public interface ISystemRoleService {

    int saveOrUpdateSystemRole(SystemRole role, Integer optUserId);

    int deleteSystemRole(Integer id);

    int deleteSystemRole(Integer id, Integer optUserId, boolean real);

    List<SystemRole> findAllSystemRole();

    List<SystemRole> findSystemRoleByPage(PageBean page);

    List<SystemRole> findAllSystemRoleModules();

    SystemRole getSystemRoleModules(Integer id);

    int insertSystemRoleModule(SystemRoleModule roleModule);

    int insertSystemRoleModuleBatch(List<SystemRoleModule> roleModules);

    int saveOrUpdateRoleAndRoleModule(SystemRole role, Integer optUserId);

}
