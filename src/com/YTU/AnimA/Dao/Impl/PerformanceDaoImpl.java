package com.YTU.AnimA.Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.Dao.PerformanceDao;

import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Performance;


/**
 * 该类引用了PerformanceDao接口用于对Performance进行增删改查操作，函数操作要求请查看PerformanceDao.java文件
 */
public class PerformanceDaoImpl implements PerformanceDao {

	@Override
	public void save(Connection connection, Performance performance) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection connection, Long card_id, Long pc_id, Performance performance) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection connection, Performance performance) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet get(Connection connection, Employee employee, Date date) throws SQLException {
		// TODO Auto-generated method stub
		//实现get方法，写出数据库表和业绩实体的查询逻辑
		String selectSql = "select em_name, employee.e_ID, card_ID, processconfig.pc_ID, processconfig.reward, cumulative, oneday from calsalary,employee,processconfig ";
		String limitSql = "where employee.e_ID = ? and employee.password = ? and employee.e_ID = calsalary.e_ID "
				+ "and oneday = ? and processconfig.pc_ID = calsalary.pc_ID";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSql+limitSql);

		//填补ID，password和oneday，通过这三个字段就可以查出一个员工某个月份的详细记录
		preparedStatement.setLong(1, employee.getId());
		preparedStatement.setString(2, employee.getPassword());
		preparedStatement.setDate(3, date);
		//直接返回函数结果，其类型为ResultSet
		return preparedStatement.executeQuery();
	}

}
