package com.hawk.springboot.controller;


import com.hawk.springboot.common.Order;
import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.dal.entity.SystemModule;
import com.hawk.springboot.enums.DataStatus;
import com.hawk.springboot.service.ISystemModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 后台模块管理
 * @author 冯勇
 *
 */
@Controller
@RequestMapping("/admin/sys")
public class ModuleManageController extends BaseAdminController {

	@Autowired
	private ISystemModuleService moduleService;
	
	/**
	 * 加载系统模块
	 * @param req
	 * @return
	 */
	@RequestMapping("/listSystemModule")
	public String listSystemModule(PageBean pageBean, HttpServletRequest req) {

		Map<String, Object> filters = pageBean.getFilters();
		if(filters == null) {
			pageBean.addFilter("status", DataStatus.ENABLE.toString());
		}
		pageBean.addOrder(Order.asc("sort"));
		List<SystemModule> modules = moduleService.findSystemModuleByPage(pageBean);
		req.setAttribute("modules", modules);
		req.setAttribute("pageBean", pageBean);
		return "/admin/sys/module_list";
	}
	
	/**
	 * 编辑系统模块
	 * @param req
	 * @return
	 */
	@RequestMapping("/toEditSystemModule")
	public String toEditSystemModule(Integer id, HttpServletRequest req) {
		SystemModule module = moduleService.getSystemModuleById(id);
		req.setAttribute("module", module);
		return "/admin/sys/module_edit";
	}
	
	/**
	 * 更新保存系统模块
	 * @param req
	 * @return
	 */
	@RequestMapping("/updateSystemModule")
	public String updateSystemModule(SystemModule module, HttpServletRequest req) {
		SystemAdmin currentAdmin = getCurrentAdmin(req);
		moduleService.saveOrUpdateSystemModule(module, currentAdmin.getId());
		return "redirect:/admin/sys/listSystemModule.shtml";
	}

	/**
	 * 删除系统模块
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/deleteSystemModule")
	public String deleteModule(Integer id, HttpServletRequest req) {
		SystemAdmin currentAdmin = getCurrentAdmin(req);
		moduleService.deleteSystemModule(id, currentAdmin.getId(), false);
		return "redirect:/admin/sys/listSystemModule.shtml";
	}
}
