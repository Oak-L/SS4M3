package com.oracle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	// 登陆
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		// 调用service登陆
		// ......
		if (username != null && username != "") {
			session.setAttribute("user", username);
			return "redirect:/items/queryItems.action";
		}
		return "redirect:/login.jsp";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清楚session
		// ......
		session.invalidate();
		return "redirect:/login.jsp";
	}
}
