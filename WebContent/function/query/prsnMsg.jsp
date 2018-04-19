<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息查询结果</title>
</head>
<body>
	你的当前信息<br><br>

	用户名：<%= request.getAttribute("name") %><br>
	ID: <%= request.getAttribute("ID") %><br>
	邮箱：<%= request.getAttribute("eMail") %><br>
	入职日期：<%= request.getAttribute("emplyDate") %><br>
	<a href="<%= request.getContextPath() %>/MyMain.jsp">回到首页</a>
	
</body>
</html>