package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mzmy.MeetingManager.model.dao.infldao.InfEmpDao;
import com.mzmy.MeetingManager.util.JDBCUtil;

/**
 * 员工信息操作
 * @author mzmy
 *
 */
public class ImplEmpDao  implements InfEmpDao{
	//定义变量
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
	@Override
	public Map<Integer, String> selEmpsByDid(int did) {
		Map<Integer, String> myemps=new HashMap<Integer,String>();
		try {
			//获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select u_id,u_name from meet_emp where u_deptid=?";
			//编辑语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, did);
			//执行语句返回见结果
			rs=pst.executeQuery();
			while(rs.next()){
				myemps.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return myemps;
	}
   
}
