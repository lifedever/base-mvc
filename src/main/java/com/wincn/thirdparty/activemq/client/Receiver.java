package com.wincn.thirdparty.activemq.client;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.wincn.thirdparty.activemq.ConnectionUtils;

public class Receiver {

	private static final String QUEUE_NAME = "queue.first";
	private Session session = null;
	private MessageConsumer consumer = null;
	private Connection connection = null;

	public Receiver() {
		try {
			connection = ConnectionUtils.getConnection();
			session = createSession(connection);
			Destination destination = createDestination(QUEUE_NAME);
			consumer = createConsumer(destination);
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
	 * 创建消息接收者
	 * 
	 * @param destination
	 * @return
	 * @throws JMSException
	 */
	private MessageConsumer createConsumer(Destination destination) throws JMSException {
		MessageConsumer consumer = session.createConsumer(destination);
		return consumer;
	}

	public void receiveMessage() throws JMSException {
		while (true) {
			TextMessage message = (TextMessage) consumer.receive(1000);
			if (null != message) {
				System.out.println("收到消息：" + message.getText());
			}
		}
	}

	public static void main(String[] args) {
		// ConnectionFactory connectionFactory = null;
		// Connection connection = null;
		// Session session = null;
		// Destination destination = null;
		// MessageConsumer consumer = null;
		//
		// connectionFactory = new
		// ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
		// ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		//
		// try {
		// connection = connectionFactory.createConnection();
		// connection.start();
		//
		// session = connection.createSession(Boolean.FALSE,
		// Session.AUTO_ACKNOWLEDGE);
		// destination = session.createQueue("FirstQueue");
		//
		// consumer = session.createConsumer(destination);
		//
		// while (true) {
		// TextMessage message = (TextMessage) consumer.receive(1000);
		// if (null != message) {
		// System.out.println("收到消息：" + message.getText());
		// }
		// }
		// } catch (JMSException e) {
		// e.printStackTrace();
		// } finally {
		// if (null != connection)
		// try {
		// connection.close();
		// } catch (JMSException e) {
		// e.printStackTrace();
		// }
		// }
		Receiver receiver = new Receiver();
		try {
			receiver.receiveMessage();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
