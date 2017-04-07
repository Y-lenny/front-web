package com.hawk.springboot.service;

import com.hawk.springboot.dal.entity.SystemAdmin;

/**
 * Created by yannfeng on 2016/9/1.
 */
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
