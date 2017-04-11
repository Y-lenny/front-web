package com.dafycredit.giveu.mall.admin.controller;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;
import com.dafycredit.giveu.mall.admin.service.ISystemModuleService;
import com.dafycredit.giveu.mall.admin.service.ISystemRoleService;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemModule;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemRole;
import com.dafycredit.giveu.mall.common.util.DataStatus;
import com.dafycredit.giveu.mall.common.util.Order;
import com.dafycredit.giveu.mall.common.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
* <br>管理员角色管理，角色权限管理</br>
*
* @class  RolePrivilegesController
* @author  lennylv
* @date    2017/4/11 23:53
* @version 1.0
* @since  1.0
*/

@Controller
@RequestMapping("/admin/sys")
public class RolePrivilegesController extends BaseAdminController {

	@Autowired
	private ISystemRoleService roleService;
	
	@Autowired
	private ISystemModuleService moduleService;
	
	/**
	 * 无权限
	 * @param req
	 * @return
	 */
	@RequestMapping("/noPrivilege")
	public String noPrivilege(HttpServletRequest req) {
		return "/common/no_privilege";
	}
	
	/**
	 * 加载系统角色
	 * @param req
	 * @return
	 */
	@RequestMapping("/listSystemRole")
	public String listSystemRole(PageBean pageBean, HttpServletRequest req) {

		Map<String, Object> filters = pageBean.getFilters();
		if(filters == null) {
			pageBean.addFilter("status", DataStatus.ENABLE.toString());
		}
		pageBean.addOrder(Order.desc("create_time"));
		List<SystemRole> roles = roleService.findSystemRoleByPage(pageBean);
		req.setAttribute("roles", roles);
		req.setAttribute("pageBean", pageBean);
		return "/admin/sys/role_list";
	}
	
	/**
	 * 编辑系统角色
	 * @param req
	 * @return
	 */
	@RequestMapping("/toEditSystemRole")
	public String toEditSystemRole(Integer id, HttpServletRequest req) {
		SystemRole role = roleService.getSystemRoleModules(id);
		List<SystemModule> roleModules = null;
		if(role != null) {
			roleModules = role.getModules();
		}
		List<SystemModule> modules = moduleService.findAllSystemModule();
		if(modules != null) {
			for(SystemModule module:modules) {
				if(roleModules != null && roleModules.contains(module)) {
					module.setChecked(true);
				}
			}
		}
		req.setAttribute("role", role);
		req.setAttribute("modules", modules);
		return "/admin/sys/role_edit";
	}
	
	/**
	 * 更新保存系统角色
	 * @param req
	 * @return
	 */
	@RequestMapping("/updateSystemRole")
	public String updateSystemRole(SystemRole role, HttpServletRequest req) {
		SystemAdmin curAdmin = getCurrentAdmin(req);
		roleService.saveOrUpdateRoleAndRoleModule(role, curAdmin.getId());
		return "redirect:/admin/sys/listSystemRole.shtml";
	}

	/**
	 * 删除系统角色
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/deleteSystemRole")
	public String deleteSystemRole(Integer id, HttpServletRequest req) {
		SystemAdmin currentAdmin = getCurrentAdmin(req);
		roleService.deleteSystemRole(id, currentAdmin.getId(), false);
		return "redirect:/admin/sys/listSystemRole.shtml";
	}
}
