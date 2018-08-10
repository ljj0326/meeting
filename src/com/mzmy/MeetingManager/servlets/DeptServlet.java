package com.mzmy.MeetingManager.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzmy.MeetingManager.model.dao.impldao.ImplDeptDao;
import com.mzmy.MeetingManager.model.dao.impldao.ImplFenyeDao;
import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.model.vo.FenYeVo;
import com.mzmy.MeetingManager.service.FenYeService;

/**
 * Servlet implementation class DeptServlet
 */
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  //传递数据过来
		String opera=request.getParameter("opera");
		//判断
		if(opera!=null&&opera.equals("selall")){
			//获取所有的部门信息
			ArrayList<DeptVo> dlist=new ImplDeptDao().selAllDepts();
			//请求属性
			request.setAttribute("dlist", dlist);
			//请求转发
			request.getRequestDispatcher("yjsppage/register.jsp").forward(request, response);
		}
		
		//获得当前页数 nowpage
		String npage=request.getParameter("page");
		//总的数据		
		int count=new ImplFenyeDao().myDataCount();
		//调用分页的方法
		FenYeVo fy=new FenYeService().takData(5, count, npage);
		//获得总的数据
		ArrayList<DeptVo> ddlist=new ImplFenyeDao().selMyDatas(fy);
	   //将数据带回前台
		request.setAttribute("fy",fy);
		request.setAttribute("ddlist",ddlist);
		//跳转页面
		request.getRequestDispatcher("yjsppage/departments.jsp").forward(request, response);
		
	}

}
