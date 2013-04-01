package com.wincn.user.constant;

/**
 * 关于文件存储路径的一个枚举类
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-4-1 下午1:06:48
 */
public enum FilePathEnum {
	USER_MAIN_DIR("userMainDir", "/user");// 注册用户主目录，存储当前用户的所有文件

	private String name;
	private String path;

	private FilePathEnum(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
