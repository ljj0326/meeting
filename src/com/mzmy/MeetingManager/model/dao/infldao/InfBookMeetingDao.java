package com.mzmy.MeetingManager.model.dao.infldao;

import com.mzmy.MeetingManager.model.vo.MeetingVo;

/**
 * 关于会议的相关的数据库操作
 * 
 * @author mzmy
 *
 */
public interface InfBookMeetingDao {
	//存入一个会议
	public int insOneMeeting(MeetingVo meetv);
	//获得刚刚存储数据的会议的id
	public int getJustNowMeetid();
	//向第三方表插入插入一个会议与员工的关联系
	public int insMeet_Emp(int empid,int meetid);
	

}
