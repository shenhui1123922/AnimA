package com.YTU.AnimA.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.service.EmployeeService;

/**
 * Servlet implementation class CheckEmployeeServlet
 */
@WebServlet("/CheckEmployeeServlet")
public class CheckEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 由于是对Employee对象的操作，所以要初始化一个EmployeeService类
	private EmployeeService employeeService = new EmployeeService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckEmployeeServlet() {
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

		RequestDispatcher requestDispatcher = null; // 声明RequestDispatcher对象用于页面内容的转发
		String forward = null; // forward对象用于存储页面转发路径
		Employee employee = new Employee(); // 初始化employee对象
		employee.setId(Long.parseLong(ID)); // 将ID中存储的字符串转化为employee对象中的ID对应的Long类型并赋值
		employee.setPassword(passWord); // 将passWord中存储的字符串赋给employee对象中的password
		Employee employee2 = employeeService.check(employee); // 声明新的Employee对象保存查询得来的employee对象数据
		if (employee2 != null) {
			// 当查询成功时，设置查询成功的页面路径并将新employee对象中的数据推送给新页面。
			forward = "/function/query/prsnMsg.jsp";
			request.setAttribute("name", employee2.getName());
			request.setAttribute("ID", employee2.getId());
			request.setAttribute("eMail", employee2.getEmail());
			request.setAttribute("emplyDate", employee2.getEmplyDate().toString());
		} else {
			// 当查询失败时，设置查询失败的页面路径并将错误信息推送给新页面。
			request.setAttribute("Msg", "用户名或密码输入错误，请重新输入！");
			forward = "/function/query/prsnMsg.jsp";
		}
		requestDispatcher = request.getRequestDispatcher(forward);// 初始化requestDispatcher对象并赋予转发路径。
		requestDispatcher.forward(request, response); // 执行转发操作。
	}
}
