<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	你的当前信息<br><br>

	用户名：<%= request.getAttribute("name") %><br>
	ID: <%= request.getAttribute("ID") %><br>
	工资单号：<%= request.getAttribute("s_ID") %><br>
	日期：<%= request.getAttribute("payDay") %><br>
	薪水总计:<%= request.getAttribute("salary") %><br>
	<%--跳转回首页的链接 --%>
	<a href="<%= request.getContextPath() %>/MyMain.jsp">回到首页</a>
</body>
</html>