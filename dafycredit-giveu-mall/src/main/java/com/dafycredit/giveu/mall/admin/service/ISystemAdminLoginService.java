package com.dafycredit.giveu.mall.admin.service;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;


public interface ISystemAdminLoginService {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    SystemAdmin login(SystemAdmin admin);

    /**
     * 管理员修改密码
     * @param account
     * @param newPassword
     * @param oldPassword
     * @return
     */
    boolean modifyPassword(String account, String newPassword, String oldPassword, Integer optUserId);
}
