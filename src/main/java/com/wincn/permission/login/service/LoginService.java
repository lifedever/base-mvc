package com.wincn.permission.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.service.UserService;

@Service
public class LoginService {
	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean regeditUser(User user) {
		if (user.getUsername() == null || user.getPassword() == null || "".equals(user.getUsername().trim()) || "".equals(user.getPassword().trim())) {
			return false;
		} else if (userService.findByUsername(user.getUsername()) == null) {
			userService.saveUser(user);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public boolean loginUser(User user) {
		User user2 = userService.findByUsername(user.getUsername());
		if (user2 != null && user2.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
