package com.YTU.AnimA.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.TYU.AnimA.utils.ConnectionFactory;
import com.YTU.AnimA.Dao.PerformanceDao;
import com.YTU.AnimA.Dao.Impl.PerformanceDaoImpl;
import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Performance;

public class PerformanceService {
//我们现在需要建立接口对象，check函数检查数据库表里面有没有我们需要查找的业绩记录，并将查找到的业绩记录返回到CheckPerformanceServlet的那一层。
	private PerformanceDao performanceDao = new PerformanceDaoImpl();

	public List<Performance> check(Employee employee,Date date) {
		Connection connection = null;
		List<Performance> performance = new ArrayList<Performance>();
		
		try {
			//由于可能存在异常，所以在数据库连接对象获取数据库连接的操作要放置于try-catch代码段的try代码段中
			connection = ConnectionFactory.getInstance().makeConnection();
			//取消数据库连接的自动事务提交
			connection.setAutoCommit(false);
			ResultSet resultSet = performanceDao.get(connection, employee, date);
			while (resultSet.next()) {
				Performance p=new Performance();
				p.setCardId(resultSet.getLong("card_ID"));
				p.setCumulative(resultSet.getInt("cumulative"));
				p.setOneday(resultSet.getDate("oneday"));
				p.setReward(resultSet.getDouble("reward"));
				p.setPcId(resultSet.getLong("pc_ID"));
				performance.add(p);
			}
			return performance;
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
		return null;
	}
}
