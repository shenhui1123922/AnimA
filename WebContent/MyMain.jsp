<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
	<div>  
        欢迎<h3><%=session.getAttribute("loginUsername") %></h3>管理员同学
    </div>  
	<br>
	<%--各种操作 --%>

	<a href="function/query/query.jsp">查询</a>
	<a href="function/register/register.jsp">注册</a>
	<a href="function/update/update.jsp">维护</a>
	<a href="function/delete/delete.jsp">注销</a>

</body>
</html>