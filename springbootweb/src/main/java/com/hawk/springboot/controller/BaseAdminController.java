package com.hawk.springboot.controller;

import com.hawk.springboot.base.BaseController;
import com.hawk.springboot.common.Constants;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.service.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 运营管理后台控制器基类
 * @author 冯勇
 *
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
