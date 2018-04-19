<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人业绩查询页面</title>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20;
}
</style>

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
			url : '/MES/checkPerformanceServlet',
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

</head>
<body>
	<div id="id">
		<table border="1" cellspacing="5" cellpadding="10"
			bordercolor="silver" align="center">
			<tr>
				<%--第一行，表头 --%>
				<td colspan="2" align="center" bgcolor="#EBEBEB">业绩查询</td>
			</tr>
			<tr>
				<%--第二行，输入ID --%>
				<td>ID:</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<%--第三行，输入密码 --%>
				<td>密码：</td>
				<td><input type="password" name="passWord"></td>
			</tr>
			<tr>
				<%--第四行，输入日期 --%>
				<td>日期：</td>
				<td><input type="text" name="oneday"></td>
			</tr>
			<tr>
				<%--第五行，设置两个按钮，提交与重置 --%>
				<td colspan="2" align="center"><input type="button" value="提交"
					onclick="sumbit('id');"></td>
			</tr>
		</table>
	</div>
	<div id="list">绩效明细：</div>
	<script id="some-template" type="text/x-handlebars-template">
		绩效明细：
		<table>
			<thead>
				<th>卡号</th>
				<th>工序号</th>
				<th>酬劳</th>
				<th>累计</th>
				<th>日期</th>
			</thead>
			<tbody>
				{{#each per}}
				<tr>
					<td>{{cardId}}</td>
					<td>{{pcId}}</td>
					<td>{{reward}}</td>
					<td>{{cumulative}}</td>
					<td>{{oneday}}</td>
				</tr>
				{{/each}}
			</tbody>
		</table>
	</script>
</body>
</html>