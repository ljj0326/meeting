package com.mzmy.MeetingManager.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzmy.MeetingManager.model.dao.impldao.ImplDeptDao;
import com.mzmy.MeetingManager.model.dao.impldao.ImplMRoomDao;
import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.model.vo.MRoomVo;

/**
 * Servlet implementation class PreMeetingServlet
 */
public class PreMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //获得操作
		String opera=request.getParameter("opera");
		
		//跳转到会议室界面
		if(opera!=null&&opera.equals("tomeetingpage")){
			//获取所有的部门信息
			ArrayList<DeptVo> dlist=new ImplDeptDao().selAllDepts();
			//获取所有的会议室信息
			ArrayList<MRoomVo> rlist=new ImplMRoomDao().selAllMRooms();
			//将两个集合添加到请求属性
			request.setAttribute("dlist", dlist);
			request.setAttribute("rlist", rlist);
			//请求转发页面
			request.getRequestDispatcher("yjsppage/bookmeeting.jsp").forward(request, response);
		}
	}

}
