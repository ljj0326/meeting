package com.mzmy.MeetingManager.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mzmy.MeetingManager.model.dao.impldao.ImplLoginDao;
import com.mzmy.MeetingManager.model.vo.EmpVo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得页面传递的参数
		String um=request.getParameter("username");
		String up=request.getParameter("password");
		System.out.println("账号："+um);
		System.out.println("密码："+up);
		//登陆的方法
		EmpVo ev=new ImplLoginDao().selLogin(um, up);
		//判断
		if(ev==null){
			request.setAttribute("msg","账号或者密码有误");
			//跳转
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//获取账号名等信息存储到session中去
			HttpSession session=request.getSession();
			//存储属性
			session.setAttribute("ev",ev);
			/*
			 * 登陆计数
			 */
			ServletContext ctx=this.getServletContext();
			//获取上下文中及技术操作
			String str=(String)ctx.getAttribute("count");
			int count =0;
			//判断
			if(str==null){
				count=1;
			}else{
				count=Integer.parseInt(str);
				count++;
			}
			//将数据放到上下文
			ctx.setAttribute("count", count+"");
			//跳转页面
			request.getRequestDispatcher("yjsppage/index.jsp").forward(request, response);
		}
	}

}
