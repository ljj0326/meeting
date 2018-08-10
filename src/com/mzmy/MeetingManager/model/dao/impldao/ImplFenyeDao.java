package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.*;
import java.util.ArrayList;

import com.mzmy.MeetingManager.model.dao.infldao.InfFenYeDao;
import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.model.vo.FenYeVo;
import com.mzmy.MeetingManager.util.JDBCUtil;

/**
 * 分页的查询
 * @author mzmy
 *
 */
public class ImplFenyeDao implements InfFenYeDao{
  //定义属性
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int myDataCount() {
		//定义变量
		int count=0;
		try {
			// 获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select count(*) from meet_dept";
			//预编译语句对象
			pst=con.prepareStatement(sql);
			//执行语句
			rs=pst.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public ArrayList<DeptVo> selMyDatas(FenYeVo fy) {
		ArrayList<DeptVo> ddlist=new ArrayList<DeptVo>();
		try {
			// 获得连接对象
			con = JDBCUtil.getConnection();
			// 编写sql语句
			String sql = "select * from(select a.*,rownum rn from (select * from meet_dept) a) b where rn between ? and ?";
			// 预编译语句对象
			pst = con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, fy.getStartdata());
			pst.setInt(2,fy.getEnddata());
			//执行语句
			rs=pst.executeQuery();
			while(rs.next()){
				DeptVo dv=new DeptVo();
				dv.setD_id(rs.getInt(1));
				dv.setD_name(rs.getString(2));
				//添加到集合
				ddlist.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ddlist;
	}
   
}
