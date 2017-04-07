package com.hawk.springboot.controller;

import com.hawk.springboot.common.Constants;
import com.hawk.springboot.common.MD5Util;
import com.hawk.springboot.common.Order;
import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.dal.entity.SystemModule;
import com.hawk.springboot.dal.entity.SystemRole;
import com.hawk.springboot.enums.DataStatus;
import com.hawk.springboot.service.ISystemAdminLoginService;
import com.hawk.springboot.service.ISystemAdminService;
import com.hawk.springboot.service.ISystemModuleService;
import com.hawk.springboot.service.ISystemRoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yannfeng on 2016/9/1.
 */
@Controller
@RequestMapping("/admin")
public class AdminManageController extends BaseAdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminManageController.class);

    @Autowired
    private ISystemRoleService roleService;

    @Autowired
    private ISystemModuleService moduleService;

    @Autowired
    private ISystemAdminLoginService adminLoginService;

    @Autowired
    private ISystemAdminService sysAdminService;


    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/admin/login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(SystemAdmin admin, String captcha, HttpServletRequest req, HttpServletResponse res) {

        if (StringUtils.isNotBlank(captcha)) {  //验证码不能为空

            String captchaStr = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            req.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            // 验证码检验
            if (StringUtils.equalsIgnoreCase(captchaStr, captcha)) {

               admin = adminLoginService.login(admin);
                if(admin != null) {
                    if(StringUtils.equals(admin.getStatus(), DataStatus.ENABLE.toString())) {

                        logger.debug(admin.getAccount() + " Login success.");
                        HttpSession session = req.getSession();
                        session.setAttribute(Constants.Session.ADMIN_LOGIN_KEY, admin.getAccount());
                        SystemRole role = roleService.getSystemRoleModules(admin.getRoleId());
                        List<SystemModule> allModules = moduleService.findAllSystemModule();
                        List<SystemModule> modules = role == null ? null : role.getModules();
                        List<String> noPrivilegeUrls = null;
                        if (allModules != null) {
                            noPrivilegeUrls = new ArrayList<String>();
                            for (SystemModule module : allModules) {
                                if (modules != null && !modules.contains(module)) {
                                    noPrivilegeUrls.add(module.getUrl());
                                }
                            }
                        }
                        session.setAttribute(Constants.Session.ADMIN_PRIVILEGE_KEY, noPrivilegeUrls);
                        return "redirect:/admin/index.shtml";
                    } else {
                        logger.debug("Login failed.");
                        req.setAttribute("message", "账户已被禁用，请联系管理员!");
                    }
                } else {
                    logger.debug("Login failed.");
                    req.setAttribute("message", "账户或密码不正确!");
                }
            } else {
                req.setAttribute("message", "验证码不正确!");
            }
        }
        return "/admin/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session != null) {
            session.removeAttribute(Constants.Session.ADMIN_LOGIN_KEY);
            session.removeAttribute(Constants.Session.ADMIN_PRIVILEGE_KEY);
        }
        return "/admin/login";
    }

    @RequestMapping("/auth/modifyPassword")
    public String modifyPassword(String oldPassword, String password, HttpServletRequest req, HttpServletResponse res) {
        SystemAdmin currentAdmin = getCurrentAdmin(req);
        if(StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(password)) {
            String account = (String) req.getSession().getAttribute(Constants.Session.ADMIN_LOGIN_KEY);
            boolean rs = adminLoginService.modifyPassword(account, password, oldPassword, currentAdmin.getId());
            if(rs) {
                req.setAttribute("message", "密码修改成功");
            } else {
                req.setAttribute("message", "旧密码不正确");
            }
        }
        return "/admin/auth/admin_pwd";
    }

    /**
     * 加载系统管理员
     * @param req
     * @return
     */
    @RequestMapping("/sys/listSystemAdmin")
    public String listSystemAdmin(PageBean pageBean, HttpServletRequest req) {
        Map<String, Object> filters = pageBean.getFilters();
        if(filters == null) {
            pageBean.addFilter("status", DataStatus.ENABLE.toString());
        }
        pageBean.addOrder(Order.desc("create_time"));
        List<SystemAdmin> admins = sysAdminService.findSystemAdminByPage(pageBean);
        req.setAttribute("admins", admins);
        req.setAttribute("pageBean", pageBean);
        return "/admin/sys/admin_list";
    }

    /**
     * 编辑系统管理员
     * @param req
     * @return
     */
    @RequestMapping("/sys/toEditSystemAdmin")
    public String toEditSystemAdmin(Integer id, HttpServletRequest req) {
        SystemAdmin admin = sysAdminService.getSystemAdminById(id);

        List<SystemRole> roles = roleService.findAllSystemRole();
        req.setAttribute("admin", admin);
        req.setAttribute("roles", roles);
        return "/admin/sys/admin_edit";
    }

    /**
     * 更新保存系统管理员
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/sys/updateSystemAdmin")
    public String updateSystemAdmin(SystemAdmin admin, HttpServletRequest req) throws UnsupportedEncodingException {
        SystemAdmin currentAdmin = getCurrentAdmin(req);
        if(admin != null) {

            Integer id = admin.getId();
            if(id == null) {
                SystemAdmin existAdmin = sysAdminService.getSystemAdminByAccount(admin.getAccount());
                if(existAdmin != null) {
                    return "redirect:/admin/sys/listSystemAdmin.shtml?message="+ URLEncoder.encode("账号已经存在！", "UTF8");
                }
            }

            String password = admin.getPassword();
            if(StringUtils.isNotBlank(password)) {
                admin.setPassword(MD5Util.MD5(password));
            } else {
                admin.setPassword(admin.getOldPassword());
            }
            sysAdminService.saveOrUpdateSystemAdmin(admin, currentAdmin.getId());
        }
        return "redirect:/admin/sys/listSystemAdmin.shtml";
    }

    /**
     * 删除系统管理员
     * @param id
     * @param req
     * @return
     */
    @RequestMapping("/sys/deleteSystemAdmin")
    public String deleteSystemAdmin(Integer id, HttpServletRequest req) {
        SystemAdmin currentAdmin = getCurrentAdmin(req);

        Integer roleId = currentAdmin.getRoleId();



        sysAdminService.deleteSystemAdmin(id, currentAdmin.getId(), false);
        return "redirect:/admin/sys/listSystemAdmin.shtml";
    }

}
