package com.wincn.permission.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.dao.UserDAO;

/**
 * 用户逻辑层
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-3-30 下午1:25:05
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void saveUser(User user) {
		userDAO.save(user);
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

}
