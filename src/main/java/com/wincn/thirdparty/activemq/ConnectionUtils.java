package com.wincn.thirdparty.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConnectionUtils {
	private static Connection connection = null;
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String URL = "tcp://localhost:61616";

	/**
	 * 建立连接
	 * 
	 * @return
	 * @throws JMSException
	 */
	private static Connection createConnection() throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		return connection;
	}

	/**
	 * 获得Connection实例
	 * 
	 * @return
	 * @throws JMSException
	 */
	public static Connection getConnection() throws JMSException {
		if (connection == null) {
			connection = createConnection();
		}
		return connection;
	}

	public static void close() throws JMSException {
		if (connection == null) {
			connection.close();
		}
	}
}
