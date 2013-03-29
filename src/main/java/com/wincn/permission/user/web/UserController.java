package com.wincn.permission.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wincn.permission.user.bean.User;

@Controller
public class UserController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regeditForm(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "permission/user/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String regedit(User user, ModelMap model) {
		return "permission/user/signup";
	}
}
