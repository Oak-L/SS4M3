package com.oracle.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆拦截器
 * 
 * @author L
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println("LoginInterceptor----afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor----postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor----preHandle");
		// 获取请求的url
		StringBuffer url = request.getRequestURL();
		// 判断地址是否是公开地址
		if (url.indexOf("login.action") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		if (username != null && username != "") {
			return true;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		;
		return false;
	}

}
