package com.YTU.AnimA.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.entity.Employee;
/**
 * 该接口用于对实体employee类进行增删改查操作
 */
public interface EmployeeDao {
	
	/**
	 * 增操作，需要数据库连接实例，Employee类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param employee
	 * @throws SQLException
	 */
	public void save(Connection connection, Employee employee) throws SQLException;

	/**
	 * 改操作，需要数据库连接实例，Employee类实例，id定位数据库中的employee记录，失败则会牵扯数据库异常
	 * @param connection
	 * @param id
	 * @param employee
	 * @throws SQLException
	 */
	public void update(Connection connection, Long id, Employee employee) throws SQLException;	

	/**
	 * 删操作，需要数据库连接实例，Employee类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param employee
	 * @throws SQLException
	 */
	public void delete(Connection connection, Employee employee) throws SQLException;

	/**
	 * 查操作，需要数据库连接实例，Employee类实例，失败则会牵扯数据库异常，返回值为SQL查询结果集
	 * @param connection
	 * @param employee
	 * @return
	 * @throws SQLException
	 */
	public ResultSet get(Connection connection, Employee employee) throws SQLException;
	
}
