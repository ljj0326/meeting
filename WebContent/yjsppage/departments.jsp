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
 <link rel="stylesheet" href="yjsppage/styles/common03.css"/>
 <script type="text/javascript">
 
 function toPage(){
 var page=document.getElementById("pagenum").value;
 window.location.href="DeptServlet?page="+page;
 }
 </script>
</head>
    <body>
            <div class="page-content">
                <div class="content-nav">&nbsp; 
                     人员管理 &gt; 部门管理 
                </div>
                <form name="form1" action="AddDeleteDepartmentServlet" method="post">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" name="departmentname" maxlength="20"/>
                    <input type="hidden" name="code" value="add"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                
                 <div class="header-info">
                            共<span class="info-number">${requestScope.fy.getCount() }</span>条结果，
                            分成<span class="info-number">${requestScope.fy.getMypages()}</span>页显示，
                            当前第<span class="info-number">${requestScope.fy.getNowpage()}</span>页
                        </div>
                        <div class="header-nav">
                     
                            <input type="button" class="clickbutton" value="首页" onclick="javascript:window.location.href='DeptServlet?page=1'"/>
                            
                            <input type="button" class="clickbutton" value="上页" onclick="javascript:window.location.href='DeptServlet?page=${requestScope.fy.getNowpage()-1 }'"/>
                        
                            <input type="button" class="clickbutton" value="下页" onclick="javascript:window.location.href='DeptServlet?page=${requestScope.fy.getNowpage()+1 }'"/>
         
                            
                            <input type="button" class="clickbutton" value="末页" onclick="javascript:window.location.href='DeptServlet?page=${requestScope.fy.getMypages()}'"/>
                            跳到第<input type="text" id="pagenum"  name="page" class="nav-number"/>页
                            
                            <input type="button" class="clickbutton" value="跳转" onclick="toPage()"/>
                       
                        </div>
                <table class="listtable">
                <caption>所有的部门</caption>
                <tr class="listheader">
                  <td>部门编号</td>
                  <td>部门名称</td>
                  <td>操作</td>
                </tr>
                <c:forEach items="${requestScope.ddlist }" var="dv">
                <tr>
                    <td>${dv.getD_id() }</td>
                    <td>${dv.getD_name()}</td>
                    <td><input type="button" class="clickbutton" value="删除" onclick="window.location.href='AddDeleteDepartmentServlet?code=delete&departmentid=${dv.getD_id()}'"/></td>
                    </tr>
                    </c:forEach>
                    </table>
                    
            </div>
    </body>
</html>