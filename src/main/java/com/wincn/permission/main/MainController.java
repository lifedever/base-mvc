package com.wincn.permission.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index() {
		return "main/index";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "common/header";
	}

	@RequestMapping(value = "/footer", method = RequestMethod.GET)
	public String footer() {
		return "common/footer";
	}
}
