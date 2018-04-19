package com.YTU.AnimA.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.Dao.EmployeeDao;
import com.YTU.AnimA.entity.Employee;
/**
 * 该类引用了EmployeeDao接口用于对Employee进行增删改查操作，函数操作要求请查看EmployeeDao.java文件
 */
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Connection connection, Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection connection, Long id, Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection connection, Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet get(Connection connection, Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		//SQL查询语句，?为占位符，占位符的内容会被preparedStatement的set方法按照标记的先后次序进行填补。
		String selectSql = "SELECT * FROM employee WHERE e_ID = ? AND password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
		
		//填补ID和password，通过这两个字段就可以查出一个员工在employee表中的记录
		preparedStatement.setLong(1, employee.getId());
		preparedStatement.setString(2, employee.getPassword());
		
		//直接返回函数结果，其类型为ResultSet
		return preparedStatement.executeQuery();
	}

}
