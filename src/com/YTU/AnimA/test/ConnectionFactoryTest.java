package com.YTU.AnimA.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.TYU.AnimA.utils.ConnectionFactory;

public class ConnectionFactoryTest {
/**
 * 仅仅用于测试数据库连接工厂类的稳定与否
 * @param args
 * @throws SQLException
 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		
		Connection connection = connectionFactory.makeConnection();
		System.out.println(connection.getAutoCommit());
	}

}
