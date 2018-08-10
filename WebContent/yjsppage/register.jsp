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
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="yjsppage/styles/common.css"/>
        <script type="text/javascript" src="yjsppage/js/register.js"></script>
        <style type="text/css">
            
        </style>
    </head>
    <body>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册员工
                </div>
                <form id="regform" action="RegisterServlet" method="post">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input name="uname" type="text" id="employeename" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input name="accname" type="text" id="accountname" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input name="passw" type="password" id="password" maxlength="20" placeholder="请输入6位以上的密码"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input name="utel" type="text" id="phone" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input name="uemail" type="text" id="email" maxlength="20"/>
                                </td>
                            </tr>
							<tr>
						<td>所属部门:</td>
						<td><select name="departmentid">
					      <c:forEach items="${requestScope['dlist']}" var="dept">
								<option value="${dept.getD_id()}">${dept.getD_name()}</option>
						   </c:forEach>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td><input id="input_" type="hidden" name="status" value="0" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input id="input_" type="hidden" name="roles" value="2" />
						</td>
					</tr>
					<tr>
						<td>备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
						<td>
						 <input  id="input_" type="text" name="remark"/>
						 <input id="utype" type="hidden" value="0" name="uname">
						</td>
					</tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="注册" onclick="registercheck()"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
            <script type="text/javascript">
              //判断
              var str="${requestScope.regmsg}";
              if(str!=null&&str!=""){
            	  alert(str);
              }
              
            </script>
    </body>
</html>