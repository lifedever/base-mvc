package com.wincn.permission.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.service.UserService;

public class LoginService {
	@Autowired
	private UserService userService;

	public boolean regeditUser(User user) {
		if (userService.findByUsername(user.getUsername()) == null) {
			userService.saveUser(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean loginUser(User user) {
		return false;
	}
}
