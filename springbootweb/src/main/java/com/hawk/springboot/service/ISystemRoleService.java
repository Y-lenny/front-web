package com.hawk.springboot.service;

import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemRole;
import com.hawk.springboot.dal.entity.SystemRoleModule;

import java.util.List;

/**
 * Created by yannfeng on 2016/9/1.
 */
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
