package com.mzmy.MeetingManager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzmy.MeetingManager.model.dao.impldao.ImplEmpDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlMap;

/**
 * Servlet implementation class AjaxEmpsServlet
 */
public class AjaxEmpsServlet extends HttpServlet {
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
		
		//获得部门id
		String did=request.getParameter("deptid");
		Map<Integer, String> myemp=null;
		System.out.println(did);
		//转换
		if(did!=null&&did!=""){
			int deptid=Integer.parseInt(did);
			//调用方法
			myemp=new ImplEmpDao().selEmpsByDid(deptid);
		}
	System.out.println(myemp);
		//设置编码
		response.setCharacterEncoding("utf-8");
		//获得响应流对象
		PrintWriter  out=response.getWriter();
		//响应数据
		out.print(myemp);
		
	}

}
