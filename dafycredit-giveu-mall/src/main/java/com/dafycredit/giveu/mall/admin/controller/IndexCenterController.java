package com.dafycredit.giveu.mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* <br>运营后台首页</br>
*
* @class  IndexCenterController
* @author  lennylv
* @date    2017/4/11 23:54
* @version 1.0
* @since  1.0
*/

@Controller
@RequestMapping("/admin")
public class IndexCenterController extends BaseAdminController {
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/admin/index";
	}
}
