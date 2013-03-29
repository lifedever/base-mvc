package com.wincn.permission.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wincn.permission.user.bean.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
