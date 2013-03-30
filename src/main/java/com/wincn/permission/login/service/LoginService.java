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
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean regeditUser(User user) {
		if (user.getUsername() == null || user.getPassword() == null || "".equals(user.getUsername().trim()) || "".equals(user.getPassword().trim())) {
			return false;
		} else if (userDAO.findByUsername(user.getUsername()) == null) {
			userDAO.save(user);
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
	public User loginUser(User user) {
		User tempUser = userDAO.findByUsername(user.getUsername());
		if (tempUser != null && tempUser.getPassword().equals(user.getPassword())) {
			user = tempUser;
		}
		return user;
	}
}
