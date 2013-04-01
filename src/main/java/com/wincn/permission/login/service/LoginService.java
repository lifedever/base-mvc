package com.wincn.permission.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.dao.UserDAO;

@Service
public class LoginService {
	@Autowired
	private UserDAO userDAO;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public User loginUser(User user) {
		User tempUser = userDAO.findByUsername(user.getUsername());
		if (tempUser != null && tempUser.getPassword().equals(user.getPassword())) {
			user = tempUser;
		}
		return user;
	}
}
