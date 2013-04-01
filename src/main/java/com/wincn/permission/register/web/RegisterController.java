package com.wincn.permission.register.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wincn.permission.register.service.RegisterService;
import com.wincn.permission.user.bean.User;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	/**
	 * 跳转注册页面
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regeditForm(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "permission/login/signup";
	}

	/**
	 * 用户注册验证
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String regedit(User user, ModelMap model, RedirectAttributes redirectAttrs) {
		if (registerService.regediterUser(user)) {
			redirectAttrs.addFlashAttribute("message", "注册成功，请登录！");
			return "redirect:/signin";
		}
		redirectAttrs.addFlashAttribute("error", "注册失败！");
		return "redirect:/signup";
	}
}
