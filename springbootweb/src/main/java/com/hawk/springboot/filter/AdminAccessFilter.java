package com.hawk.springboot.filter;

import com.hawk.springboot.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName="adminAccessFilter",urlPatterns="/admin/*")
public class AdminAccessFilter implements Filter {

	private  List<String> ignoreLoginURI = new ArrayList<String>(); //忽略登录相关的URI
	
	private static final Logger logger = Logger.getLogger(AdminAccessFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ignoreLoginURI.add("/admin/toLogin.shtml");
		ignoreLoginURI.add("/admin/login.shtml");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String contextPath = req.getContextPath();
		String uri = req.getServletPath();
		String queryString = req.getQueryString();
		
		String queryParams = "";
		if(StringUtils.isNotBlank(queryString)) {
			queryParams = "?" + queryString;
		}

		if(uri.equals("/admin")) {
			logger.info("uri :"+uri+" can not access!");
			resp.sendRedirect(contextPath + "/admin/index.shtml");
			return;
		}

		if (!uri.endsWith(".shtml")) {
			chain.doFilter(request, response);
			return;
		}

		if(!ignoreLoginURI.contains(uri)) {
			String account = (String) req.getSession().getAttribute(Constants.Session.ADMIN_LOGIN_KEY);
			if(StringUtils.isBlank(account)) {
				logger.info("has not login, uri :"+uri+" can not access!");
				resp.sendRedirect(contextPath + "/admin/toLogin.shtml?redir="+uri+queryParams+"&message="+URLEncoder.encode("您还未登录，请先登录", "UTF8"));
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
