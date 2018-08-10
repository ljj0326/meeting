package com.mzmy.MeetingManager.model.dao.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mzmy.MeetingManager.model.dao.infldao.InfMRoomDao;
import com.mzmy.MeetingManager.model.vo.MRoomVo;
import com.mzmy.MeetingManager.util.JDBCUtil;
/**
 * 
 * 会议室的相关的操作过程
 * @author mzmy
 *
 */
public class ImplMRoomDao implements InfMRoomDao {
	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public ArrayList<MRoomVo> selAllMRooms() {
		ArrayList<MRoomVo> rlist=new ArrayList<MRoomVo>();
		try {
			//获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from meet_room";
			//获得预编译语句
			pst=con.prepareStatement(sql);
			//发送执行语句
			rs=pst.executeQuery();
		//循环
			while(rs.next()){
				MRoomVo mrv=new MRoomVo();
				//设置数据
				mrv.setR_id(rs.getInt(1));
				mrv.setR_roomid(rs.getString(2));
				mrv.setR_name(rs.getString(3));
				mrv.setR_maxsize(rs.getInt(4));
				mrv.setR_nowstatus(rs.getInt(5));
				mrv.setR_remark(rs.getString(6));
				//将对象存储到集合
				rlist.add(mrv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return rlist;
	}

}
