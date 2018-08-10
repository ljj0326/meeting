package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.*;

import com.mzmy.MeetingManager.model.dao.infldao.InfLoginDao;
import com.mzmy.MeetingManager.model.vo.EmpVo;
import com.mzmy.MeetingManager.util.JDBCUtil;

/**
 * 登陆的JDBC的实现操作
 * 
 * @author mzmy
 *
 */
public class ImplLoginDao implements InfLoginDao{
	//定义属性
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	

	@Override
	public EmpVo selLogin(String uname, String upassw) {
		//实例化一个对象
		EmpVo ev=null;
		try {
			//获得简介对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select u_id,u_name,u_account,u_type from meet_emp where u_account=? and u_passw=?";
			//获得预编译语句对象
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, uname);
			pst.setString(2, upassw);
			//发送语句并且执行
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				ev=new EmpVo();
				ev.setU_id(rs.getInt(1));
				ev.setU_name(rs.getString(2));
				ev.setU_account(rs.getString(3));
				ev.setU_type(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return ev;
	}


	//注册的方法
	@Override
	public int insRegister(EmpVo ev) {
		//定义
		int i=0;
		try {
			//获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="insert into meet_emp values(seqmeeting.nextval,?,?,?,?,?,?,?,?)";
			//获得预编译语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, ev.getU_name());
			pst.setString(2, ev.getU_account());
			pst.setString(3, ev.getU_passw());
			pst.setString(4, ev.getU_tel());
			pst.setString(5, ev.getU_email());
			pst.setInt(6, ev.getU_deptid());
			pst.setString(7, ev.getU_remark());
			pst.setInt(8, ev.getU_type());
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
