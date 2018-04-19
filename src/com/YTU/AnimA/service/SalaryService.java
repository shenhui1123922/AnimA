package com.YTU.AnimA.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.TYU.AnimA.utils.ConnectionFactory;
import com.YTU.AnimA.Dao.SalaryDao;
import com.YTU.AnimA.Dao.Impl.SalaryDaoImpl;
import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Salary;

/**
 * EmployeeService类意为工资服务，即可以通过此类完成对工资表中记录的具体操作
 * @author Administrator
 *
 */
public class SalaryService {
	
	//声明接口对象
	private SalaryDao salaryDao = new SalaryDaoImpl();
	//通过接口对象，以参数对象employee和salary为对照对数据库表进行查询，并将查询结果存储到一个新的Salary类对象中。
	public Salary check(Employee employee, Salary salary) {
		
		Connection connection = null;	//声明数据库连接对象
		Salary salary2 = null;			//声明新的Salary对象
		try {
			//由于可能存在异常，所以在数据库连接对象获取数据库连接的操作要放置于try-catch代码段的try代码段中
			connection = ConnectionFactory.getInstance().makeConnection();
			//取消数据库连接的自动事务提交
			connection.setAutoCommit(false);
			//声明结果集对象，并保存通过salaryDao接口对象的get方法查询到的结果集
			ResultSet resultSet = salaryDao.get(connection, employee, salary);
			while (resultSet.next()) {
				//若查询来的结果集有内容，则初始化新的Salary类对象，并将结果集中的各个字段值赋予新对象。
				salary2 = new Salary();
				salary2.setId(resultSet.getLong("s_ID"));
				salary2.setEmplyId(resultSet.getLong("employee.e_ID"));
				salary2.setPayDay(resultSet.getDate("payday"));
				salary2.setSalary(resultSet.getDouble("sal"));
				salary2.setName(resultSet.getString("em_name"));
			}
			//由于查询性质，结果集只会有一条记录，所以不会出现反复赋值导致结果混乱的情况，直接返回保存了查找结果的新对象即可。
			return salary2;
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
