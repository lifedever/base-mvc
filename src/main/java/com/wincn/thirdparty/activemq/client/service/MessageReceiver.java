package com.wincn.thirdparty.activemq.client.service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void receiveMessage() {
		TextMessage textMsg = (TextMessage) jmsTemplate.receive("helloQueue");
		try {
			if (textMsg != null) {
				System.out.println("Message Content:" + textMsg.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
