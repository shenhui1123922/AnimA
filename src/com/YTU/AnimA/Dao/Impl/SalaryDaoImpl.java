package com.YTU.AnimA.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.Dao.SalaryDao;
import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Salary;

/**
 * 该类引用了SalaryDao接口用于对Salary进行增删改查操作，函数操作要求请查看SalaryDao.java文件
 */
public class SalaryDaoImpl implements SalaryDao {

	@Override
	public void save(Connection connection, Salary salary) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection connection, Long id, Salary salary) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection connection, Salary salary) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet get(Connection connection, Employee employee, Salary salary) throws SQLException {
		// TODO Auto-generated method stub
		
		//SQL查询语句，?为占位符，占位符的内容会被preparedStatement的set方法按照标记的先后次序进行填补
		//由于个人工资的查询需要员工ID，所以要进行表的连接查询，故将查询语句分割为两个字符串对象以方便维护
		String selectSql = "select * from salary join employee on salary.e_ID = employee.e_ID ";
		String limitSql = "WHERE employee.e_ID = ? AND password = ? AND payday = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSql+limitSql);
		
		//填补ID，password和payday，通过这两个字段就可以查出一个员工在Salary表中某个月份的记录
		preparedStatement.setLong(1, employee.getId());
		preparedStatement.setString(2, employee.getPassword());
		preparedStatement.setDate(3, salary.getPayDay());

		//直接返回函数结果，其类型为ResultSet
		return preparedStatement.executeQuery();
	}

}
