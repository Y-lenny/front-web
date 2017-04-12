package com.dafycredit.giveu.mall.admin.controller;


import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;
import com.dafycredit.giveu.mall.admin.service.ISystemAdminService;
import com.dafycredit.giveu.mall.common.base.BaseController;
import com.dafycredit.giveu.mall.common.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* <br>运营管理后台控制器基类</br>
*
* @class  BaseAdminController
* @author  lennylv
* @date    2017/4/11 23:53
* @version 1.0
* @since  1.0
*/

@Controller
public class BaseAdminController extends BaseController {
	
	@Autowired
	protected ISystemAdminService adminService;
	
	/**
	 * 获取当前登录用户信息
	 * @param req
	 * @return
	 */
	public SystemAdmin getCurrentAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String account = (String) session.getAttribute(Constants.Session.ADMIN_LOGIN_KEY);
		return adminService.getSystemAdminByAccount(account);
	}
}
