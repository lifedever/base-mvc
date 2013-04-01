package com.wincn.permission.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wincn.permission.login.service.LoginService;
import com.wincn.permission.user.bean.User;

/**
 * 用于登录
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-3-30 上午10:37:08
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	/**
	 * 用户登录页面
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String loginForm(User user, ModelMap model, HttpSession session) {
		session.removeAttribute("user");
		return "permission/login/signin";
	}

	/**
	 * 用户登录验证
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String login(User user, ModelMap model, RedirectAttributes redirectAttrs, HttpSession session) {
		if ((user = loginService.loginUser(user)).getId() != null) {
			session.setAttribute("user", user);
			return "redirect:/main";
		}
		redirectAttrs.addFlashAttribute("error", "登录失败！");
		return "redirect:/signin";
	}

	/**
	 * 登出操作
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/signin";
	}
}
