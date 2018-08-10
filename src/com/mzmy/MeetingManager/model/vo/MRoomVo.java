package com.mzmy.MeetingManager.model.vo;
/**
 * 对会议室的数据描述
 * 会议室编号
        会议室门牌号
        会议室名称
        会议室最多容纳人数
        当前状态
       备注
 * 
 * @author mzmy
 *
 */
public class MRoomVo {
	private int r_id;
	private String r_roomid;
	private String r_name;
	private int r_maxsize;
	private int r_nowstatus;
	private String r_remark;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_roomid() {
		return r_roomid;
	}
	public void setR_roomid(String r_roomid) {
		this.r_roomid = r_roomid;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_maxsize() {
		return r_maxsize;
	}
	public void setR_maxsize(int r_maxsize) {
		this.r_maxsize = r_maxsize;
	}
	public int getR_nowstatus() {
		return r_nowstatus;
	}
	public void setR_nowstatus(int r_nowstatus) {
		this.r_nowstatus = r_nowstatus;
	}
	public String getR_remark() {
		return r_remark;
	}
	public void setR_remark(String r_remark) {
		this.r_remark = r_remark;
	}
	
	

}
