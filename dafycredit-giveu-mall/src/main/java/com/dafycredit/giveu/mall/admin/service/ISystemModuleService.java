package com.dafycredit.giveu.mall.admin.service;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemModule;
import com.dafycredit.giveu.mall.common.util.PageBean;

import java.util.List;

public interface ISystemModuleService {

    int saveOrUpdateSystemModule(SystemModule module, Integer optUserId);

    int deleteSystemModule(Integer id);

    int deleteSystemModule(Integer id, Integer optUserId, boolean real);

    List<SystemModule> findAllSystemModule();

    List<SystemModule> findSystemModuleByPage(PageBean page);

    SystemModule getSystemModuleById(Integer id);
}
