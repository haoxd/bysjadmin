package com.hxd.model;

import java.io.Serializable;

public class Admin implements Serializable{


	private int adminID;//管理员id 自增所以,存储在HttpSession对象中的每个属性对象必须实现Serializable接口
	private String adminPhone;//管理员手机号
	private String adminName;//管理员姓名
	private String adminPassword;//密码
	private String adminText;//简介
	private String adminCreateTime;//创建时间
	private String adminChangeTime;//最后修改时间
	private String adminState; // 状态
	
	public String getAdminState() {
		return adminState;
	}
	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminText() {
		return adminText;
	}
	public void setAdminText(String adminText) {
		this.adminText = adminText;
	}
	public String getAdminCreateTime() {
		return adminCreateTime;
	}
	public void setAdminCreateTime(String adminCreateTime) {
		this.adminCreateTime = adminCreateTime;
	}
	public String getAdminChangeTime() {
		return adminChangeTime;
	}
	public void setAdminChangeTime(String adminChangeTime) {
		this.adminChangeTime = adminChangeTime;
	}
}
