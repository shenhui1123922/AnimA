package com.YTU.AnimA.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Performance;
/**
 * 该接口用于对实体performance类进行增删改查操作
 */
public interface PerformanceDao {
	
	/**
	 * 增操作，需要数据库连接实例，performance类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param performance
	 * @throws SQLException
	 */
	public void save(Connection connection, Performance performance) throws SQLException;
	
	/**
	 * 改操作，需要数据库连接实例，performance类实例，card_id和pc_id定位数据库中的employee记录，失败则会牵扯数据库异常
	 * @param connection
	 * @param id
	 * @param performance
	 * @throws SQLException
	 */
	public void update(Connection connection, Long card_id, Long pc_id, Performance performance) throws SQLException;

	/**
	 * 删操作，需要数据库连接实例，performance类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param performance
	 * @throws SQLException
	 */
	public void delete(Connection connection, Performance performance) throws SQLException;

	/**
	 * 查操作，需要数据库连接实例，Employee类、Date类实例，失败则会牵扯数据库异常，返回值为SQL查询结果集
	 * @param connection
	 * @param employee
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public ResultSet get(Connection connection, Employee employee, Date date) throws SQLException;
	
}
