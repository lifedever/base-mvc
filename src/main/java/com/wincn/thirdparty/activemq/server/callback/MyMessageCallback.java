package com.wincn.thirdparty.activemq.server.callback;

import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;

public class MyMessageCallback implements SessionCallback {
	private JmsTemplate jmsTemplate;  
	  
    public MyMessageCallback(JmsTemplate jmsTemplate) {  
         
        this.jmsTemplate = jmsTemplate;  
    } 
	@Override
	public Object doInJms(Session session) throws JMSException {
		System.out.println("消息接收成功！");
		return null;
	}
}
