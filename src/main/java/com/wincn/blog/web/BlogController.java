package com.wincn.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wincn.user.constant.FilePathEnum;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	@RequestMapping(value = "{username}")
	public String index(@PathVariable String username) {
		return FilePathEnum.USER_MAIN_DIR.getPath() + username + "/index";
	}

	@RequestMapping(value = "{username}/newpost")
	public String newPost(@PathVariable String username) {
		return FilePathEnum.USER_MAIN_DIR.getPath() + username + "/newpost";
	}
}
