<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询</title>
</head>
<body><%--查询功能，目前提供个人信息，个人业绩和个人工资的查询服务 --%>
	<div>
		<label>个人信息查询</label>
		<form action="<%= request.getContextPath() %>/checkEmployee" method="post" name="loginForm">
			ID:<input type="text" name="ID">密码：<input type="password" name="passWord">
			<input type="submit" value="提交">
			<input type="reset" value="重置">
		</form>
	</div>
	<div>
		<label>业绩查询</label>
		<form>
			<div id="id">
				ID:<input type="text" name="ID">密码：<input type="password" name="passWord">
				日期：<input type="text" name="oneday">
				<input type="button" value="提交" onclick="sumbit('id');">
				<input type="reset" value="重置">
			</div>
		</form>
	</div>
	<div>
		<label>工资查询</label>
		<form action="<%= request.getContextPath() %>/checkSalary">
			ID:<input type="text" name="ID">密码：<input type="password" name="passWord">
			日期：<input type="text" name="payDay">
			<input type="submit" value="提交">
			<input type="reset" value="重置">
		</form>
	</div>
	<div>
		<label>工序查询</label>
		<form action="<%= request.getContextPath() %>/checkProfig">
			ID:<input type="text" name="ID"><input type="submit" value="提交">
			<input type="reset" value="重置">
		</form>
	</div>
	<script src="../../jquery-3.3.1.js"></script>
	<script src="../../handlebars-v4.0.11.js"></script>
	<script type="text/javascript">
		function sumbit(id) {
			var form = document.getElementById(id);
			var inputs = form.getElementsByTagName("input");
			var object = new Object();
			for (var i = 0; i < inputs.length; i++) {
				object[inputs[i].getAttribute("name")] = inputs[i].value;//动态生成数据的键值对
			}
			var jsonData = JSON.stringify(object);
			$.ajax({
				url : '/MES/checkPerformance',
				type : 'POST',
				data : {
					"jD" : jsonData
				},
				dataType : 'json',
				success : function(s) {
					var data = {
							"per":s
					};
					//计算当日酬劳。
					var salary = 0;
					var obj = eval(s);
					for (var i = 0; i < obj.length; i++) {
						salary+=obj[i].reward*obj[i].cumulative;
					}
					alert("您当日的工资为："+salary+"￥");
					var source = $("#some-template").html();
					var template = Handlebars.compile(source);
					$("#list").html(template(data));
				},
				error : function() {
					alert("Server error!");
				}
			});
		}
	</script>
</body>
</html>