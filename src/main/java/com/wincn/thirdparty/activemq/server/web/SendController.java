package com.wincn.thirdparty.activemq.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wincn.thirdparty.activemq.server.service.MessageSender;

@Controller
@RequestMapping(value = "/message/send")
public class SendController {

	@Autowired
	private MessageSender messageSender;

	@RequestMapping
	public String index() {
		return "message/send/index";
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(String message) {
		messageSender.sendMessage(message);
		return "redirect:/message/send";
	}
}
