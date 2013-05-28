package com.wincn.thirdparty.activemq.server;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.wincn.thirdparty.activemq.ConnectionUtils;

public class Sender {

	private static final String QUEUE_NAME = "queue.first";
	private Session session = null;
	private MessageProducer producer = null;
	private Connection connection = null;

	public Sender() {
		try {
			connection = ConnectionUtils.getConnection();
			session = createSession(connection);
			Destination destination = createDestination(QUEUE_NAME);
			producer = createProducer(destination);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建session
	 * 
	 * @param connection
	 * @return
	 * @throws JMSException
	 */
	private Session createSession(Connection connection) throws JMSException {
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		return session;
	}

	/**
	 * 创建目的地
	 * 
	 * @param queueName
	 * @param session
	 * @return
	 * @throws JMSException
	 */
	private Destination createDestination(String queueName) throws JMSException {
		Destination destination = session.createQueue(queueName);
		return destination;
	}

	/**
	 * 创建消息产生者
	 * 
	 * @param destination
	 * @param session
	 * @return
	 * @throws JMSException
	 */
	private MessageProducer createProducer(Destination destination) throws JMSException {
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);// 不做持久化
		return producer;
	}

	/**
	 * 发送消息
	 * 
	 * @param session
	 * @param producer
	 * @param text
	 * @throws JMSException
	 */
	public void sendMessage(String text) throws JMSException {
		TextMessage message = session.createTextMessage(text);
		producer.send(message);
		session.commit();
		session.close();
		ConnectionUtils.close();
	}

	public static void main(String[] args) {
		Sender sender = new Sender();
		try {
			sender.sendMessage("我给你发消息，这是我的内容r");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
