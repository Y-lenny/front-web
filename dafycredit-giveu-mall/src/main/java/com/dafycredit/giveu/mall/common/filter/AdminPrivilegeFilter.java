package com.dafycredit.giveu.mall.common.filter;

import com.dafycredit.giveu.mall.common.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName="adminPrivilegeFilter",urlPatterns="/admin/*")
public class AdminPrivilegeFilter implements Filter {

	private  List<String> ignorePrivilegeURI = new ArrayList<String>(); //忽略登录相关的URI
	
	private static final Logger logger = Logger.getLogger(AdminPrivilegeFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String contextPath = req.getContextPath();
		String uri = req.getServletPath();
		
		if (!uri.endsWith(".shtml")) {
			chain.doFilter(request, response);
			return;
		}
		if(!ignorePrivilegeURI.contains(uri)) {
			List<String> noPrivilegeUrls = (List<String>) req.getSession().getAttribute(Constants.Session.ADMIN_PRIVILEGE_KEY);
			if(noPrivilegeUrls != null && noPrivilegeUrls.contains(uri)) { 
				logger.info("has not privileges, uri :"+uri+" can not access!");
				resp.sendRedirect(contextPath + "/admin/sys/noPrivilege.shtml");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
