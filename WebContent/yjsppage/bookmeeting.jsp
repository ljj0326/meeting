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
<link rel="stylesheet" href="yjsppage/styles/common03.css" />
<script language="javascript" type="text/javascript"
	src="yjsppage/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>
<script type="text/javascript" src="yjsppage/js/deptandemp.js"></script>
</head>
<body onload="body_load()">
	<div class="page-content">
		<div class="content-nav">会议预定 > 预定会议</div>
		<form action="BookMeetingServlet" method="post">
		
			<fieldset>
				<legend>
					会议信息
				</legend>
				<table class="formtable">
					<tr>
						<td>会议名称：</td>
						<td><input type="text" id="meetingname" maxlength="20"
							name="meetingname" /> <input type="hidden"
							name="reservationistID" value="${sessionScope.employeeid}" /></td>
					</tr>
					<tr>
						<td>预计参加人数：</td>
						<td><input type="text" id="numberofparticipants"
							name="numberofparticipants" /></td>
					</tr>
					<tr>
						<td>预计开始时间：</td>
						<td><input type="datetime" id="startdate" name="starttime"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
					</tr>
					<tr>
						<td>预计结束时间：</td>
						<td><input type="datetime" id="enddate" name="endtime"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
					</tr>
					<tr>
						<td>选择会议室：</td>
						<td><select name="roomid">
								<option selected>请选择会议室</option>
							<c:forEach items="${requestScope.rlist }" var="room">
								<option value="${room.getR_id()}">${room.getR_name()}</option>
						     </c:forEach>
						</select></td>
					</tr>

					<tr>
						<td>会议说明：</td>
						<td><textarea id="description" rows="5" name="description"></textarea>
						</td>
					</tr>
					<tr>
						<td>选择参会人员：</td>
						<td>
							<div id="divfrom">
								<select id="selDepartments" name="departmentid" onchange="showEmployees()" >
										<c:forEach items="${requestScope.dlist }" var="dept">
										<option value="${dept.getD_id()}">${dept.getD_name()}</option>
		                               </c:forEach>
								</select> 
								<select id="selEmployees" multiple="multiple" onclick="myremove()"></select>
							</div>
							<div id="divoperator">
								<input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()" /> 
								<input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()" />
							</div>
							<div id="divto">
								<select id="selSelectedEmployees" multiple="multiple" name="selSelectedEmployees">
								</select>
							</div></td>
					</tr>
					<tr>
						<td class="command" colspan="2"><input type="submit"
							class="clickbutton" value="预定会议" /> <input type="reset"
							class="clickbutton" value="重置" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>