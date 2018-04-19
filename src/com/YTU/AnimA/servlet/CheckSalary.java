package com.YTU.AnimA.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Salary;

import com.YTU.AnimA.service.SalaryService;

/**
 * Servlet implementation class CheckSalaryServlet
 */
@WebServlet("/CheckSalary")
public class CheckSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 由于是对Salary对象的操作，所以要初始化一个SalaryService类
	private SalaryService salaryService = new SalaryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckSalary() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 通过get方法执行的表单推送也转给post方法执行
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("ID"); // ID用于存储从界面输入的ID字符串
		String passWord = request.getParameter("passWord"); // passWord用于存储从界面输入的密码字符串
		String payDay = request.getParameter("payDay"); // payDay用于存储从界面输入的日期字符串
		java.sql.Date date = java.sql.Date.valueOf(payDay); // 初始化一个SQL包下的Date对象用来存储Date格式的payDay
		RequestDispatcher requestDispatcher = null; // 声明RequestDispatcher对象用于页面内容的转发
		String forward = null; // forward对象用于存储页面转发路径
		Employee employee = new Employee(); // 初始化employee对象
		employee.setId(Long.parseLong(ID)); // 将ID中存储的字符串转化为employee对象中的ID对应的Long类型并赋值
		employee.setPassword(passWord); // 将passWord中存储的字符串赋给employee对象中的password
		Salary salary = new Salary(); // 初始化Salary对象
		salary.setPayDay(date); // 将date赋予Salary对象的payDay成员
		Salary salary2 = salaryService.check(employee, salary); // 声明新的Salary对象保存查询得来的Salary对象数据
		if (salary2 != null) {
			// 当查询成功时，设置查询成功的页面路径并将新employee对象中的数据推送给新页面。
			forward = "/function/query/slryMsg.jsp";
			request.setAttribute("name", salary2.getName());
			request.setAttribute("ID", salary2.getEmplyId());
			request.setAttribute("payDay", salary2.getPayDay());
			request.setAttribute("salary", salary2.getSalary());
			request.setAttribute("s_ID", salary2.getId());
		} else {
			// 当查询失败时，设置查询失败的页面路径并将错误信息推送给新页面。
			request.setAttribute("Msg", "用户名或密码输入错误，请重新输入！");
			forward = "/function/query/slryMsg.jsp";
		}
		requestDispatcher = request.getRequestDispatcher(forward);// 初始化requestDispatcher对象并赋予转发路径。
		requestDispatcher.forward(request, response); // 执行转发操作。
	}

}
