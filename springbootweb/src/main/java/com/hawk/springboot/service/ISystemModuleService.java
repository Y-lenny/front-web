package com.hawk.springboot.service;

import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemModule;

import java.util.List;

/**
 * Created by yannfeng on 2016/9/1.
 */
public interface ISystemModuleService {

    int saveOrUpdateSystemModule(SystemModule module, Integer optUserId);

    int deleteSystemModule(Integer id);

    int deleteSystemModule(Integer id, Integer optUserId, boolean real);

    List<SystemModule> findAllSystemModule();

    List<SystemModule> findSystemModuleByPage(PageBean page);

    SystemModule getSystemModuleById(Integer id);
}
