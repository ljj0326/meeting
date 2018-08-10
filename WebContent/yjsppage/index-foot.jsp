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
<title>无标题文档</title>
<link rel="stylesheet" href="yjsppage/styles/common.css" />
</head>

<body>
	<div class="page-footer">
		<hr />
		<div align="center">
		<font color="red" size="40px"> 访问了&nbsp;&nbsp;<strong>${applicationScope.count}</strong>&nbsp;次</font>
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
		<img src="images/footer.png" alt="CoolMeeting"> 
	</div></div>

 </body>
</html>
