package com.mzmy.MeetingManager.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzmy.MeetingManager.model.dao.impldao.ImplDeptDao;
import com.mzmy.MeetingManager.model.dao.impldao.ImplLoginDao;
import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.model.vo.EmpVo;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用方法
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得前台提交的数据
		String uname=request.getParameter("uname");
		String accname=request.getParameter("accname");
		String passw=request.getParameter("passw");
		String utel=request.getParameter("utel");
		String uemail=request.getParameter("uemail");
		String departmentid=request.getParameter("departmentid");
		String remark=request.getParameter("remark");
		//打包成对象
		EmpVo ev=new EmpVo();
		ev.setU_name(uname);
		ev.setU_account(accname);
		ev.setU_passw(passw);
		ev.setU_tel(utel);
		ev.setU_email(uemail);
		ev.setU_deptid(Integer.parseInt(departmentid));
		ev.setU_remark(remark);
		ev.setU_type(0);
		//调用方法注册
		int i=new ImplLoginDao().insRegister(ev);
		//判断
		if(i==0){
			request.setAttribute("regmsg", "注册不成功");
		}else{
			request.setAttribute("regmsg", "完美注册成功");
			
		}
//		//获取所有的部门信息
//		ArrayList<DeptVo> dlist=new ImplDeptDao().selAllDepts();
//		//请求属性
//		request.setAttribute("dlist", dlist);
//		//跳转页面
//		request.getRequestDispatcher("yjsppage/register.jsp").forward(request, response);
		request.getRequestDispatcher("DeptServlet?opera=selall").forward(request, response);
	}

}
