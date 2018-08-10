<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="js/login.js"></script>
<style type="text/css">
.intx {
	background: #999999;
	width: 90%;
	height: 30px;
	margin: 10px auto;
	padding-left: 15px;
	border: 1px solid #FFFFFF;
	outline: none;
	font-size: 16px;
}
.intx:hover {
	border: 1px solid #ff9900;
	outline-style: 1px solid #ff9900;
}
</style>
</head>
<body>
	<div id="container">
		<div id="main">
			<div id="title">
				登录会议管理系统
			</div>
			<div id="divbody">
			
			<hr/>
			<form id="myform" action="LoginServlet" method="post">
				<span style="font-size:20px;color:yellow">用户名:</span><input id="input_um" type="text" name="username" class="intx"/><br /> 
				<span style="font-size:20px;color:yellow">密&nbsp;&nbsp;码:</span><input id="input_up" type="password" name="password" class="intx"/><br/> 
				<input id="input_btn" type="button" value="登    陆" onclick="mylogin()"/>
				<input id="input_btn" type="button" value="取    消" onclick="window.location.href='ViewAllDepartmentsServlet?code=regist'"/>
			</form>
			<div align="center" id="tishi">${requestScope.msg}</div>
			</div>
		</div>
	</div>
</body>
</html>