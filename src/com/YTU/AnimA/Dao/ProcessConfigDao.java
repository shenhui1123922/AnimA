package com.YTU.AnimA.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.entity.ProcessConfig;
/**
 * 该接口用于对实体ProcessConfig类进行增删改查操作
 */
public interface ProcessConfigDao {
	
	/**
	 * 增操作，需要数据库连接实例，ProcessConfig类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param employee
	 * @throws SQLException
	 */
	public void save(Connection connection, ProcessConfig processConfig) throws SQLException;
	
	/**
	 * 改操作，需要数据库连接实例，ProcessConfig类实例，id定位数据库中的ProcessConfig记录，失败则会牵扯数据库异常
	 * @param connection
	 * @param id
	 * @param processConfig
	 * @throws SQLException
	 */
	public void update(Connection connection, Long id, ProcessConfig processConfig) throws SQLException;

	/**
	 * 删操作，需要数据库连接实例，Employee类实例，失败则会牵扯数据库异常
	 * @param connection
	 * @param processConfig
	 * @throws SQLException
	 */
	public void delete(Connection connection, ProcessConfig processConfig) throws SQLException;

	/**
	 * 查操作，需要数据库连接实例，Employee类实例，失败则会牵扯数据库异常，返回值为SQL查询结果集
	 * @param connection
	 * @param processConfig
	 * @return
	 * @throws SQLException
	 */
	public ResultSet get(Connection connection, ProcessConfig processConfig) throws SQLException;
}
