package com.mzmy.MeetingManager.service;

import com.mzmy.MeetingManager.model.vo.FenYeVo;

//分页的方法
public class FenYeService {

	// 分页计算方法
	public FenYeVo takData(int pagesize, int count, String npage) {
		int mypages = 0;
		//判断当前页
		int nowpage = 1;
		if (npage != null) {
			nowpage = Integer.parseInt(npage);
		}
		// 计算
		int startdata = (nowpage - 1) * pagesize + 1;
		int enddata = nowpage * pagesize;

		// 计算总页数
		if (count % pagesize != 0) {
			mypages = count / pagesize + 1;
		} else {
			mypages = count / pagesize;
		}
		
		//定义对象封装数据
		FenYeVo fy=new FenYeVo();
		fy.setCount(count);
		fy.setMypages(mypages);
		fy.setEnddata(enddata);
		fy.setStartdata(startdata);
		fy.setPagesize(pagesize);
		fy.setNowpage(nowpage);
		
		//返回结果
		return fy;

	}

}
