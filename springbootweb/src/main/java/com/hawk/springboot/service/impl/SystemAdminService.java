package com.hawk.springboot.service.impl;



import com.hawk.springboot.common.BeanUtil;
import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.dal.mapper.SystemAdminMapper;
import com.hawk.springboot.enums.DataStatus;
import com.hawk.springboot.service.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yannfeng on 2016/9/1.
 */
@Service
public class SystemAdminService implements ISystemAdminService {

    @Autowired
    private SystemAdminMapper sysAdminMapper;

    /**
     * 新增或更新系统管理员
     * @param admin
     * @return
     */
    @Override
    public int saveOrUpdateSystemAdmin(SystemAdmin admin, Integer optUserId) {
        int rs = 0;
        if(admin != null) {
            Integer id = admin.getId();
            Date now = new Date();
            admin.setUpdateTime(now);
            admin.setUpdateUserId(optUserId);
            if(id != null) {
                SystemAdmin updateSystemAdmin = sysAdminMapper.getById(id);
                BeanUtil.copyProperties(updateSystemAdmin, admin, true);
                rs = sysAdminMapper.update(updateSystemAdmin);
            } else {
                admin.setCreateTime(now);
                admin.setCreateUserId(optUserId);
                rs = sysAdminMapper.insert(admin);
            }
        }
        return rs;
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @Override
    public int deleteSystemAdmin(Integer id) {
        return sysAdminMapper.delete(id);
    }

    /**
     * 删除管理员
     * @param id
     * @param optUserId
     * @param real 是否物理删除
     * @return
     */
    @Override
    public int deleteSystemAdmin(Integer id, Integer optUserId, boolean real) {
        int rs = 0;
        if(real) {
           rs = sysAdminMapper.delete(id);
        } else {
            SystemAdmin admin = sysAdminMapper.getById(id);
            admin.setStatus(DataStatus.DELETE.toString());
            rs = saveOrUpdateSystemAdmin(admin, optUserId);
        }
       return rs;
    }

    /**
     * 查询所有系统管理员
     * @return
     */
    @Override
    public List<SystemAdmin> findAllSystemAdmin() {
        return sysAdminMapper.queryAll();
    }

    @Override
    public List<SystemAdmin> findSystemAdminByPage(PageBean page) {
        List<SystemAdmin> admins = sysAdminMapper.queryByPage(page);
        page.setRowCount(sysAdminMapper.countByFilter(page.getFilters()).intValue());
        return admins;
    }

    @Override
    public SystemAdmin getSystemAdminByAccount(String account) {
        return sysAdminMapper.getByAccount(account);
    }

    @Override
    public SystemAdmin getSystemAdminById(Integer id) {
        return sysAdminMapper.getById(id);
    }
}
