package com.mzmy.MeetingManager.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mzmy.MeetingManager.model.dao.impldao.ImplBookMeetingDao;
import com.mzmy.MeetingManager.model.vo.EmpVo;
import com.mzmy.MeetingManager.model.vo.MeetingVo;

/**
 * Servlet implementation class BookMeetingServlet
 */
public class BookMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		HttpSession session=request.getSession();
		EmpVo ev=(EmpVo)session.getAttribute("ev");
		int m_preid=ev.getU_id();//预定者编号
		//会议名称
		String m_name=request.getParameter("meetingname");
		//预计参会人数
		int m_pempcount=Integer.parseInt(request.getParameter("numberofparticipants"));
		//会议预计开始时间
		Timestamp starttime=Timestamp.valueOf(request.getParameter("starttime"));
		//会议预计结束时间
		Timestamp endtime=Timestamp.valueOf(request.getParameter("endtime"));
		//会议室
		int m_roomid=Integer.parseInt(request.getParameter("roomid"));
		//会议说明
		String m_description=request.getParameter("description");
		
	   //参会人员
		String[] m_emps=request.getParameterValues("selSelectedEmployees");
	
		//将会以相关数据打包成对象
		MeetingVo meetv=new MeetingVo();
		//添加数据
		meetv.setM_name(m_name);
		meetv.setM_discription(m_description);
		meetv.setM_precount(m_pempcount);
		meetv.setM_prestarttime(starttime);
		meetv.setM_preendtime(endtime);
		meetv.setM_roomid(m_roomid);
		meetv.setM_prepid(m_preid);
		System.out.println(m_preid);
		//创建dao对象
		ImplBookMeetingDao meetdao=new ImplBookMeetingDao();
		//将会以的数据存储会议表
//		int i=meetdao.insOneMeeting(meetv);
//		if(i>0){
//		  //获取刚刚存储数据库的会议的id
//		  int mid=meetdao.getJustNowMeetid();
		  //存储相关的数据
		 for(int j=0;j<m_emps.length;j++){
//			 int s=meetdao.insMeet_Emp(Integer.parseInt(m_emps[j].trim()),mid);
             System.out.println("第三方表插入了数据："+Integer.parseInt(m_emps[j]));
//         }
		}
		//请求转发
		request.getRequestDispatcher("yjsppage/bookmeeting.jsp").forward(request, response);
	}

}
