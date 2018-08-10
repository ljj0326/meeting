package com.mzmy.MeetingManager.model.vo;
/*
 * 
 * 分页的数据
 */
public class FenYeVo {
	//定义属性
	private int pagesize;//每页显示的数据
	private int nowpage;//每页显示的数据
	private int count;//总的条数
	private int mypages;//总页数
	private int startdata;//查询起始数据
	private int enddata;//查询结束数据
	
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMypages() {
		return mypages;
	}
	public void setMypages(int mypages) {
		this.mypages = mypages;
	}
	public int getStartdata() {
		return startdata;
	}
	public void setStartdata(int startdata) {
		this.startdata = startdata;
	}
	public int getEnddata() {
		return enddata;
	}
	public void setEnddata(int enddata) {
		this.enddata = enddata;
	}
	
	

}
