package com.mzmy.MeetingManager.model.dao.infldao;

import com.mzmy.MeetingManager.model.vo.EmpVo;

/**
 * 登陆操作的接口
 * 
 * @author mzmy
 *
 */
public interface InfLoginDao {
   //登陆的方法
	public EmpVo selLogin(String uname,String upassw);
	//注册的方法
	public int insRegister(EmpVo ev);
}
