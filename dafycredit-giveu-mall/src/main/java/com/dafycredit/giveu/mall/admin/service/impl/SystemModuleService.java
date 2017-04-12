package com.dafycredit.giveu.mall.admin.service.impl;


import com.dafycredit.giveu.mall.admin.service.ISystemModuleService;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemModule;
import com.dafycredit.giveu.mall.admin.dal.mapper.SystemModuleMapper;
import com.dafycredit.giveu.mall.common.util.DataStatus;
import com.dafycredit.giveu.mall.common.util.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
                BeanUtils.copyProperties(updateSystemModule, module);
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
