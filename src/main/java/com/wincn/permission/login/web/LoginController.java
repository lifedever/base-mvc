package com.wincn.permission.login.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * 跳转注册页面
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regeditForm(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "permission/login/signup";
	}

	/**
	 * 用户注册验证
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String regedit(User user, ModelMap model) {
		loginService.regeditUser(user);
		return "permission/login/signup";
	}

	/**
	 * 用户登录页面
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String loginForm(User user, ModelMap model) {
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
	public String login(User user, ModelMap model) {
		loginService.loginUser(user);
		return "permission/login/signup";
	}

}
