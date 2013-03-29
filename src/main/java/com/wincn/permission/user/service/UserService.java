package com.wincn.permission.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void saveUser(User user) {
		userDAO.save(user);
	}

	public boolean regeditUser(User user) {
		if (this.findByUsername(user.getUsername()) == null) {
			saveUser(user);
			return true;
		} else {
			return false;
		}
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
}
