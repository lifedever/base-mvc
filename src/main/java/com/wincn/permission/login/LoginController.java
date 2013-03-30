package com.wincn.permission.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.service.UserService;
import com.wincn.permission.user.validator.UserValidator;

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
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regeditForm(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "permission/login/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String regedit(User user, BindingResult bindingResult, ModelMap model) throws Exception {
		userService.regeditUser(user);
		return "permission/login/signup";
	}
}
