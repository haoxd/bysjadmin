package com.hxd.model;

/**
 * @author acer11
 *  作者：郝旭东
* 创建时间：2016-1-7 下午2:04:52  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.7
* 文件名称：UserMessageBack.java  
* 类说明：
 */
public class UserMessageBack {
	private int userMessageBackId;//返回内容id
	private String userMessageBackName;//用户名
	private String userMessageBackPhone;//联系方式
	private String userMessageBackText;//反馈意见内容
	private String userMessageTime;//时间
	private String userMessageIdear;
	public String getUserMessageIdear() {
		return userMessageIdear;
	}
	public void setUserMessageIdear(String userMessageIdear) {
		this.userMessageIdear = userMessageIdear;
	}
	public int getUserMessageBackId() {
		return userMessageBackId;
	}
	public void setUserMessageBackId(int userMessageBackId) {
		this.userMessageBackId = userMessageBackId;
	}
	public String getUserMessageBackName() {
		return userMessageBackName;
	}
	public void setUserMessageBackName(String userMessageBackName) {
		this.userMessageBackName = userMessageBackName;
	}
	public String getUserMessageBackPhone() {
		return userMessageBackPhone;
	}
	public void setUserMessageBackPhone(String userMessageBackPhone) {
		this.userMessageBackPhone = userMessageBackPhone;
	}
	public String getUserMessageBackText() {
		return userMessageBackText;
	}
	public void setUserMessageBackText(String userMessageBackText) {
		this.userMessageBackText = userMessageBackText;
	}
	public String getUserMessageTime() {
		return userMessageTime;
	}
	public void setUserMessageTime(String userMessageTime) {
		this.userMessageTime = userMessageTime;
	}
	
	
	

	

}
