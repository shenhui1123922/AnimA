package com.YTU.AnimA.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.TYU.AnimA.utils.ConnectionFactory;
import com.YTU.AnimA.Dao.EmployeeDao;
import com.YTU.AnimA.Dao.Impl.EmployeeDaoImpl;
import com.YTU.AnimA.entity.Employee;

/**
 * EmployeeService类意为员工服务，即可以通过此类完成对员工表中记录的具体操作
 * @author Administrator
 *
 */
public class EmployeeService {
	
	//声明接口对象
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	//通过接口对象，以参数对象employee为对照对数据库表进行查询，并将查询结果存储到一个新的Employee类对象中。
	public Employee check(Employee employee) {
		Connection connection = null;		//声明数据库连接对象
		Employee employee2 = null;			//新的Employee类对象
		try {	
			//由于可能存在异常，所以在数据库连接对象获取数据库连接的操作要放置于try-catch代码段的try代码段中
			connection = ConnectionFactory.getInstance().makeConnection();	
			//取消数据库连接的自动事务提交
			connection.setAutoCommit(false);
			//声明结果集对象，并保存通过employeeDao接口对象的get方法查询到的结果集
			ResultSet resultSet = employeeDao.get(connection, employee);
			while (resultSet.next()) {
				//若查询来的结果集有内容，则初始化新的Employee类对象，并将结果集中的各个字段值赋予新对象。
				employee2 = new Employee();
				employee2.setId(resultSet.getLong("e_ID"));
				employee2.setPassword(resultSet.getString("password"));
				employee2.setBirthday(resultSet.getDate("birthday"));
				employee2.setCancelDate(resultSet.getDate("cancel_date"));
				employee2.setEmail(resultSet.getString("email"));
				employee2.setEmplyDate(resultSet.getDate("emply_date"));
				employee2.setName(resultSet.getString("em_name"));
				employee2.setSex(resultSet.getString("sex"));
			}
			//由于查询性质，结果集只会有一个，所以不会出现反复赋值导致结果混乱的情况，直接返回保存了查找结果的新对象即可。
			return employee2;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();		//若查询过程出了意外则需要进行数据库回滚以保护数据库数据。
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally {
			try {
				connection.close();			//无论查询成功还是失败，完成查询之后必须要关闭数据库连接。
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;	//查询若失败则返回为null的Employee类对象。
	}
}
