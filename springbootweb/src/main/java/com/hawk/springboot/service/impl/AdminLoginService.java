package com.hawk.springboot.service.impl;


import com.hawk.springboot.common.MD5Util;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.service.ISystemAdminLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yannfeng on 2016/9/1.
 */
@Service
public class AdminLoginService implements ISystemAdminLoginService {

    @Autowired
    private SystemAdminService sysAdminService;

    @Override
    public SystemAdmin login(SystemAdmin admin) {
        if(admin != null) {
            String account = admin.getAccount();
            String password = MD5Util.MD5(admin.getPassword());

            admin = sysAdminService.getSystemAdminByAccount(account);
            if(admin != null && StringUtils.equals(password, admin.getPassword())) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public boolean modifyPassword(String account, String newPassword, String oldPassword, Integer optUserId) {

        SystemAdmin currentAdmin = sysAdminService.getSystemAdminByAccount(account);
        if(currentAdmin != null && StringUtils.equals(MD5Util.MD5(oldPassword), currentAdmin.getPassword())) {
            currentAdmin.setPassword(MD5Util.MD5(newPassword));
            int rs = sysAdminService.saveOrUpdateSystemAdmin(currentAdmin, optUserId);
            if(rs > 0) {
                return true;
            }
        }
        return false;
    }
}
