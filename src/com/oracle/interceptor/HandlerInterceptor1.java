package com.oracle.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试拦截器1
 * 
 * @author L
 *
 */
public class HandlerInterceptor1 implements HandlerInterceptor {
	// 执行完成Handler方法后执行
	// 统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1----afterCompletion");
	}

	// 进入Handler方法后，返回modelAndView之前执行
	// 应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到模型视图，也可以在这里同一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1----postHandle");
	}

	// 进入Handler方法之前执行
	// 用于身份认证和身份授权
	// 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptor1----preHandle");
		// false表示拦截，不向下执行
		// true表示放行
		return true;
	}

}
