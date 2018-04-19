package com.YTU.AnimA.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.entity.Card;
/**
 * 该接口用于对实体Card类进行增删改查操作
 */
public interface CardDao {
	
	/**
	 * 增操作，需要数据库连接实例，Card类实例，失败操作会牵扯到数据库异常
	 * @param connection
	 * @param card
	 * @throws SQLException
	 */
	public void save(Connection connection, Card card) throws SQLException;
	
	/**
	 * 改操作，需要数据库连接实例，Card类实例，id用于定位数据库中的Card记录，失败操作会牵扯数据库异常
	 * @param connection
	 * @param id
	 * @param card
	 * @throws SQLException
	 */
	public void update(Connection connection, Long id, Card card) throws SQLException;
	
	/**
	 * 删操作，需要数据库连接实例，Card类实例，失败操作会牵扯到数据库异常
	 * @param connection
	 * @param card
	 * @throws SQLException
	 */
	public void delete(Connection connection, Card card) throws SQLException;
	
	/**
	 * 查操作，需要数据库连接实例，Card实例，失败操作会牵扯到数据库异常，返回值为SQL查询结果集
	 * @param connection
	 * @param card
	 * @return
	 * @throws SQLException
	 */
	public ResultSet get(Connection connection, Card card) throws SQLException;

}
