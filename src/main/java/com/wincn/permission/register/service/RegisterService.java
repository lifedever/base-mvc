package com.wincn.permission.register.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wincn.base.constant.Global;
import com.wincn.permission.user.bean.User;
import com.wincn.permission.user.dao.UserDAO;
import com.wincn.permission.user.exception.CreateUserMainDirFailException;

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
	public boolean regediterUser(User user) {
		if (user.getUsername() == null || user.getPassword() == null || "".equals(user.getUsername().trim()) || "".equals(user.getPassword().trim())) {
			return false;
		} else if (userDAO.findByUsername(user.getUsername()) == null) {
			try {
				regediterSuccessHandle(user);
				userDAO.save(user);
			} catch (CreateUserMainDirFailException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <h1>用户注册成功的一系列处理</h1>
	 * <ol>
	 * <li>创建用户主目录</li>
	 * </ol>
	 * 
	 * @throws CreateUserMainDirFailException
	 */
	private void regediterSuccessHandle(User user) throws CreateUserMainDirFailException {
		String userPath = Global.WEB_APP_ROOT + "/WEB-INF/views/users/" + user.getUsername();
		createUserDirectory(userPath);
	}

	/**
	 * 创建用户主目录
	 * 
	 * @throws CreateUserMainDirFailException
	 */
	private void createUserDirectory(String path) throws CreateUserMainDirFailException {
		File userDir = new File(path);
		if (!userDir.exists()) {
			if (!new File(path).mkdirs())
				throw new CreateUserMainDirFailException("用户主目录创建失败，请查看是否具有创建文件夹的权限！");
			// TODO 创建基本的模板页面
			
		}
	}
}
