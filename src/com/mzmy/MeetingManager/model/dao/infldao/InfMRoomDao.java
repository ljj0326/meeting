package com.mzmy.MeetingManager.model.dao.infldao;

import java.util.ArrayList;

import com.mzmy.MeetingManager.model.vo.MRoomVo;

/**
 * 
 * 会议室的相关操作
 * @author mzmy
 *
 */
public interface InfMRoomDao {
	//获取所有的会议室
	public ArrayList<MRoomVo> selAllMRooms();

}
