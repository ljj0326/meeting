package com.mzmy.MeetingManager.model.vo;

import java.sql.Timestamp;


/**
 * 会议的实体类
 * 
 * @author mzmy
 *
 */
public class MeetingVo {
	private int m_id;
	private String m_name;
	private int m_precount;
	private Timestamp m_prestarttime;
	private Timestamp m_preendtime;
	private int m_prepid;
	private int m_roomid;
	private String m_discription;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_precount() {
		return m_precount;
	}
	public void setM_precount(int m_precount) {
		this.m_precount = m_precount;
	}
	public Timestamp getM_prestarttime() {
		return m_prestarttime;
	}
	public void setM_prestarttime(Timestamp m_prestarttime) {
		this.m_prestarttime = m_prestarttime;
	}
	public Timestamp getM_preendtime() {
		return m_preendtime;
	}
	public void setM_preendtime(Timestamp m_preendtime) {
		this.m_preendtime = m_preendtime;
	}
	public int getM_prepid() {
		return m_prepid;
	}
	public void setM_prepid(int m_prepid) {
		this.m_prepid = m_prepid;
	}
	public int getM_roomid() {
		return m_roomid;
	}
	public void setM_roomid(int m_roomid) {
		this.m_roomid = m_roomid;
	}
	public String getM_discription() {
		return m_discription;
	}
	public void setM_discription(String m_discription) {
		this.m_discription = m_discription;
	}

}
