package com.YTU.AnimA.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YTU.AnimA.entity.Employee;
import com.YTU.AnimA.entity.Performance;

import com.YTU.AnimA.service.PerformanceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//import com.google.gson.Gson;

/**
 * Servlet implementation class CheckPerformanceServlet
 */
@WebServlet("/CheckPerformanceServlet")
public class CheckPerformanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PerformanceService performanceService = new PerformanceService();
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();//设定时间格式
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckPerformanceServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 在此处实现获得查询结果并将结果推送给信息画面的逻辑。
		// TODO Auto-generated method stub

		JsonObject jsonObject = (JsonObject)new JsonParser().parse(request.getParameter("jD"));
		//解析获得的JD，
		
		String ID = jsonObject.get("ID").getAsString(); // ID用于存储从界面输入的ID字符串
		String passWord = jsonObject.get("passWord").getAsString(); // passWord用于存储从界面输入的密码字符串
		String oneDay = jsonObject.get("oneday").getAsString(); // oneday用于存储从界面输入的日期字符串
		
		java.sql.Date date = java.sql.Date.valueOf(oneDay); // 初始化一个SQL包下的Date对象用来存储Date格式的payDay

		Employee employee = new Employee(); // 初始化employee对象
		employee.setId(Long.parseLong(ID)); // 将ID中存储的字符串转化为employee对象中的ID对应的Long类型并赋值
		employee.setPassword(passWord); // 将passWord中存储的字符串赋给employee对象中的password
		List<Performance> performances = performanceService.check(employee, date);
		System.out.println(performances);
		String s = gson.toJson(performances);
		System.out.println(s);
		response.getWriter().write(s);

	}

}
