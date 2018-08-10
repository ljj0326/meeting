package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.*;
import java.util.ArrayList;

import com.mzmy.MeetingManager.model.dao.infldao.InfDeptDao;
import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.util.JDBCUtil;
/**
 * 部门相关数据库操作的实现类
 * 
 * @author mzmy
 *
 */
public class ImplDeptDao implements InfDeptDao {

	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public ArrayList<DeptVo> selAllDepts() {
		ArrayList<DeptVo> dlist=new ArrayList<DeptVo>();
		try {
			// 获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from meet_dept";
			//预编译语句处理
			pst=con.prepareStatement(sql);
			//执行语句
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				DeptVo dv=new DeptVo();
				dv.setD_id(rs.getInt(1));
				dv.setD_name(rs.getString(2));
				//将存储数据的对象添加到集合
				dlist.add(dv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}

}
