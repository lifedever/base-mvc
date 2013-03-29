package com.wincn.permission.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.service.UserService;
import com.wincn.permission.user.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regeditForm(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "permission/user/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String regedit(User user, BindingResult bindingResult, ModelMap model) throws Exception {
		if (!userService.regeditUser(user))
			userValidator.validate(user, bindingResult);
		return "permission/user/signup";
	}
}
