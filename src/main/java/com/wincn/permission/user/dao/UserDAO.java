package com.wincn.permission.user.dao;

import com.wincn.base.dao.BaseDAO;
import com.wincn.permission.user.bean.User;

public interface UserDAO extends BaseDAO<User, Integer> {
	User findByUsername(String username);
}
