package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.*;

import com.mzmy.MeetingManager.model.dao.infldao.InfLoginCountDao;
import com.mzmy.MeetingManager.util.JDBCUtil;
/**
 * 关于登陆计数的数据库相关操作的实现类
 * 
 * @author mzmy
 *
 */
public class ImplLoginCountDao implements InfLoginCountDao {

	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int selLoginCount() {
		int count=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//定义sql语句
			String sql="select c_count from meet_count where c_id=1";
			//获得预编译语句对象
			pst=con.prepareStatement(sql);
			//执行语句
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return count;
	}

	@Override
	public void updLoginCount(int count) {
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="update meet_count set c_count=? where c_id=1";
			//预编译语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, count);
			//执行语句
			int i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		
	}

}
