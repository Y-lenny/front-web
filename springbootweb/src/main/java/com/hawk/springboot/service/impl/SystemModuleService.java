package com.hawk.springboot.service.impl;


import com.hawk.springboot.common.BeanUtil;
import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemModule;
import com.hawk.springboot.dal.mapper.SystemModuleMapper;
import com.hawk.springboot.enums.DataStatus;
import com.hawk.springboot.service.ISystemModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yannfeng on 2016/9/1.
 */
@Service
public class SystemModuleService implements ISystemModuleService {

    @Autowired
    private SystemModuleMapper sysModuleMapper;

    /**
     * 新增或更新系统模块
     * @param module
     * @return
     */
    @Override
    public int saveOrUpdateSystemModule(SystemModule module, Integer optUserId) {
        int rs = 0;
        if(module != null) {
            Integer id = module.getId();
            module.setUpdateUserId(optUserId);
            if(id != null) {
                SystemModule updateSystemModule = sysModuleMapper.getById(id);
                BeanUtil.copyProperties(updateSystemModule, module, true);
                rs = sysModuleMapper.update(updateSystemModule);
            } else {
                module.setCreateUserId(optUserId);
                rs = sysModuleMapper.insert(module);
            }
        }
        return rs;
    }

    /**
     * 删除系统模块
     * @param id
     * @return
     */
    @Override
    public int deleteSystemModule(Integer id) {
        int rs = sysModuleMapper.delete(id);

        sysModuleMapper.deleteSysRoleModuleByModuleId(id);     //级联删除角色模块
        return rs;
    }

    /**
     * 删除系统模块
     * @param id
     * @param optUserId
     * @param real 是否物理删除
     * @return
     */
    @Override
    public int deleteSystemModule(Integer id, Integer optUserId, boolean real) {
        int rs = 0;

        if(real) {
            rs = sysModuleMapper.delete(id);
        } else {
            SystemModule model = sysModuleMapper.getById(id);
            model.setStatus(DataStatus.DELETE.toString());
            rs = saveOrUpdateSystemModule(model, optUserId);
        }

        if(rs > 0) {
            sysModuleMapper.deleteSysRoleModuleByModuleId(id);     //级联删除角色模块
        }
        return rs;
    }

    /**
     * 查询所有系统模块
     * @return
     */
    @Override
    public List<SystemModule> findAllSystemModule() {
        return sysModuleMapper.queryAll();
    }

    @Override
    public List<SystemModule> findSystemModuleByPage(PageBean page) {
        List<SystemModule> modules = sysModuleMapper.queryByPage(page);
        page.setRowCount(sysModuleMapper.countByFilter(page.getFilters()).intValue());
        return modules;
    }

    @Override
    public SystemModule getSystemModuleById(Integer id) {
        return sysModuleMapper.getById(id);
    }
}
