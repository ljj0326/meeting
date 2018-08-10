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
 <title>admin</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<frameset rows="100,*,85" cols="*" framespacing="0" frameborder="no" border="0">

 <frame src="yjsppage/index-top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame"  marginwidth="0" marginheight="0"  frameborder="0" />
 
 <frameset cols="20%,*" id="frame">
	<frame src="yjsppage/index-left.jsp" name="leftFrame" scrolling="No" noresize="noresize" marginwidth="110px" marginheight="0" frameborder="0"  target="main" />
	<frame src="yjsppage/index-main.jsp" name="main" marginwidth="50px" marginheight="40px" frameborder="0" scrolling="auto" target="_self"  />
    </frameset>
 <frame src="yjsppage/index-foot.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" marginwidth="0" marginheight="0"/>
  
</frameset>
</html>
