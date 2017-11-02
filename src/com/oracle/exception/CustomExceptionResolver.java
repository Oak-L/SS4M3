package com.oracle.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 系统自定义异常类 针对预期的异常，需要在程序中抛出此类的异常
 * 
 * @author L
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		CustomException customException = null;
		if (exception instanceof CustomException) {
			customException = (CustomException) exception;
		} else {
			customException = new CustomException("未知错误");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", customException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
