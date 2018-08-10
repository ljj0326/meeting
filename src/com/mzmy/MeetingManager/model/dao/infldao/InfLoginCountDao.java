package com.mzmy.MeetingManager.model.dao.infldao;
/**
 * 登陆计数的接口
 * @author mzmy
 *
 */
public interface InfLoginCountDao {

	 //查询计数数据
	public int selLoginCount();
	//更新数据
	public void updLoginCount(int count);
}
