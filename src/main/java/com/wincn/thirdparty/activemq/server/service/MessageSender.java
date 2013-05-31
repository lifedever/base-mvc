package com.wincn.thirdparty.activemq.server.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String msgText) {
		jmsTemplate.send("helloQueue",new MessageCreator() {
			private Message message;
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				message = session.createTextMessage(msgText);
				message.setStringProperty("jmsUserId", "001"); // 消息所属的用户编码
				message.setStringProperty("jmsUserName", "葛方帅");    //    消息所属的应用程序编码 
				return message;
			}
		});
	}
}
