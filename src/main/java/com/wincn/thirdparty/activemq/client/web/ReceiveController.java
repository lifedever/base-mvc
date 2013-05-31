package com.wincn.thirdparty.activemq.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wincn.thirdparty.activemq.client.service.MessageReceiver;

@Controller
@RequestMapping(value = "/message/receive")
public class ReceiveController {

	@Autowired
	private MessageReceiver receiver;

	@RequestMapping
	public String index() {
		receiver.receiveMessage();
		return "message/receive/index";
	}
}
