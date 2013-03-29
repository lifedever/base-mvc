package com.wincn.permission.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/signup")
	public String regedit() {
		return "permission/user/signup";
	}
}
