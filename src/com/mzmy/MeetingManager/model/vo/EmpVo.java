package com.mzmy.MeetingManager.model.vo;
/**
 * 用户操作的实体层数据
 * 
 * @author mzmy
 *
 */
public class EmpVo {
	//定义属性
	private int u_id;//用户编号
	private String u_name;//用户名
	private String u_account;//账号
	private String u_passw;//用户密码
	private String u_tel;//电话
	private String u_email;//邮箱
	private int u_deptid;//部门id
	private String u_remark;//备注
	private int u_type;//类型
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_passw() {
		return u_passw;
	}
	public void setU_passw(String u_passw) {
		this.u_passw = u_passw;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getU_deptid() {
		return u_deptid;
	}
	public void setU_deptid(int u_deptid) {
		this.u_deptid = u_deptid;
	}
	public String getU_remark() {
		return u_remark;
	}
	public void setU_remark(String u_remark) {
		this.u_remark = u_remark;
	}
	public int getU_type() {
		return u_type;
	}
	public void setU_type(int u_type) {
		this.u_type = u_type;
	}
	
	

}
