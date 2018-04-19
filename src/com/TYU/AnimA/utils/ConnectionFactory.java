package com.TYU.AnimA.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * 连接工厂类，用于建立数据连接的类，通过读取配置文件中的信息来建立数据库连接，采用单例模式，该类产生的对象仅有一个。
 */
public class ConnectionFactory {
	
	private static String driver;		//该字符串用于存储数据库连接驱动
	private static String dburl;		//该字符串用于存储数据库的URL连接地址
	private static String user;			//该字符串用于存储数据库管理员ID
	private static String password;		//该字符串用于存储数据库管理员密码
	
	private static final ConnectionFactory CONNECTION_FACTORY = new ConnectionFactory();//静态final实例，表示该类仅能有一个实例
	
	private Connection connection;		//该对象用于存储数据库连接
	
	static {//静态代码段用于初始化类。
		Properties properties = new Properties();
		try {
			InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("============配置文件读取错误============");
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	/**
	 * 默认构造函数
	 */
	private ConnectionFactory() {}
	
	public static ConnectionFactory getInstance() {
		return CONNECTION_FACTORY;
	}
	/**
	 * 通过类属性获取数据库连接，返回值亦为数据库连接实例。
	 */
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
}
