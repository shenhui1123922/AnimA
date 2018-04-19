<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资查询</title>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20;
}
</style>
<script type="text/javascript"><%--js代码段，用于限制用户不允许输入空字符串 --%>
	function check(form) {
		if (document.forms.SalaryForm.ID.value == "") {
			alert("请输入用户名");
			document.forms.SalaryForm.ID.focus();
			return false;
		}
		if (document.forms.SalaryForm.passWord.value == "") {
			alert("请输入密码");
			document.forms.SalaryForm.passWord.focus();
			return false;
		}
		if (document.forms.SalaryForm.payDay == "") {
			alert("请输入日期");
			document.forms.SalaryForm.payDay.focus();
			return false;
		}
		
	}
</script>
</head>
<body>
	<form action="<%= request.getContextPath() %>/checkSalaryServlet" method="post" name="SalaryForm">
		<table border="1" cellspacing="5" cellpadding="10" bordercolor="silver" align="center">
			<tr><%--第一行，表头 --%>
				<td colspan="2" align="center" bgcolor="#EBEBEB">工资查询</td>
			</tr>
			<tr><%--第二行，输入ID --%>
				<td>ID:</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr><%--第三行，输入密码 --%>
				<td>密码：</td>
				<td><input type="password" name="passWord"></td>
			</tr>
			<tr><%--第四行，输入日期 --%>
				<td>日期：(格式XXXX-XX-XX)</td>
				<td><input type="text" name="payDay"></td>
			</tr>
			<tr><%--第五行，提交和重置按钮 --%>
				<td colspan="2" align="center">
					<input type="submit" value="提交" onclick="return check(this);">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
<body/>