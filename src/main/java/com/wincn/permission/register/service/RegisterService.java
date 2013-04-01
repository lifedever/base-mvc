package com.wincn.permission.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.dao.UserDAO;

/**
 * 注册逻辑
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-4-1 上午11:34:09
 */
@Service
public class RegisterService {
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
}
