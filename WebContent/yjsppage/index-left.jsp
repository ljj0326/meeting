<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="yjsppage/styles/common02.css"/>
</head>

<body>
      <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="mynotification.html" target="main">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.html" target="main">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.html" target="main">我的会议</a></li>
                    </ul>
                </div>
                <c:if test="${sessionScope['ev'].getU_type()==2}">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="DeptServlet?page=1" target="main">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="DeptServlet?opera=selall" target="main">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="approveaccount.html" target="main">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees.html" target="main">搜索员工</a></li>
                    </ul>
                </div>
                </c:if>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                    <c:if test="${sessionScope['ev'].getU_type()==2}">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.html" target="main">添加会议室</a></li>
                     </c:if>
                        <li class="sidebar-menuitem"><a href="showmeetingroom.html" target="main">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="PreMeetingServlet?opera=tomeetingpage" target="main">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.html" target="main">搜索会议</a></li>
                    </ul>
                </div>
            </div>
      </div>
</body>
</html>
