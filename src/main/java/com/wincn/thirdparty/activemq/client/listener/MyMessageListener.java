package com.wincn.thirdparty.activemq.client.listener;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.print("[message listener]消息属性：");
			Enumeration<?> e = message.getPropertyNames();
			while (e.hasMoreElements()) {
				String str = (String) e.nextElement();
				System.out.print(str+" = "+message.getStringProperty(str)+"，");
			}
			System.out.println();
//			System.out.println("[message listener]消息内容:" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
