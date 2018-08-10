package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mzmy.MeetingManager.model.dao.infldao.InfBookMeetingDao;
import com.mzmy.MeetingManager.model.vo.MeetingVo;
import com.mzmy.MeetingManager.util.JDBCUtil;

/**
 *会议数据库实现
 * 
 * @author mzmy
 *
 */
public class ImplBookMeetingDao implements InfBookMeetingDao{
	//定义变量
    Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int insOneMeeting(MeetingVo meetv) {
		//定义变量
		int i=0;
		try {
			//获得连接获得连接
			con=JDBCUtil.getConnection();
			//编辑sql语句
			String sql="insert into meet_meeting values(seq_meeting.nextval,?,?,?,?,?,?,?)";
			//预编译语句处理数据
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, meetv.getM_name());
			pst.setInt(2, meetv.getM_precount());
			pst.setTimestamp(3, meetv.getM_prestarttime());
			pst.setTimestamp(4, meetv.getM_preendtime());
			pst.setInt(5, meetv.getM_prepid());
			pst.setInt(6, meetv.getM_roomid());
			pst.setString(7, meetv.getM_discription());
			//执行语句
			i=pst.executeUpdate();
			System.out.println("-----插入会议："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
			
		}
		return i;
	}
	
	//获取刚刚存储数据库的会议的i
	@Override
	public int getJustNowMeetid() {
		//定义变量
		int mid=0;
		try {
			//获得连接获得连接
			con=JDBCUtil.getConnection();
			//编辑sql语句
			String sql="select m_id from meet_meeting where rownum=1 order by m_id desc";
			//预编译语句处理数据
			pst=con.prepareStatement(sql);
			//执行语句
			rs=pst.executeQuery();
			while(rs.next()){
				mid=rs.getInt(1);
				System.out.println("拿到的id："+mid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return mid;
	}

	//关联会议于参会人员
	@Override
	public int insMeet_Emp(int empid, int meetid) {
		//定义变量
		int i=0;
		try {
			//获得连接获得连接
			con=JDBCUtil.getConnection();
			//编辑sql语句
			String sql="insert into meet_meeting_emp values(seq_meetingandemp.nextval,?,?)";
			//预编译语句处理数据
			pst=con.prepareStatement(sql);
			//设置参数胡
			pst.setInt(1,meetid);
			pst.setInt(2,empid);
			//执行语句
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return i;
	}

}
