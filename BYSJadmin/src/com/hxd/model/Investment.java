package com.hxd.model;
/*
 * 
 * 投资信息管理
 * 
 * */
/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:29:13  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：Investment.java  
* 类说明：
 */
public class Investment {
	private int investmentId;//投资信息id
	private String investmentName;//投资名称
	private String investmentBody;//内容
	private String weekEarnings;//周收益
	private String monthEarnings;//月收益
	private String yearEarnings;//年收益
	private String investmentState;//类型
	private String investmentCreateTime;//创建时间
	private User investment_User;//投资信息所属的用户
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public String getInvestmentName() {
		return investmentName;
	}
	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}
	public String getInvestmentBody() {
		return investmentBody;
	}
	public void setInvestmentBody(String investmentBody) {
		this.investmentBody = investmentBody;
	}
	public String getWeekEarnings() {
		return weekEarnings;
	}
	public void setWeekEarnings(String weekEarnings) {
		this.weekEarnings = weekEarnings;
	}
	
	public String getMonthEarnings() {
		return monthEarnings;
	}
	public void setMonthEarnings(String monthEarnings) {
		this.monthEarnings = monthEarnings;
	}
	public String getYearEarnings() {
		return yearEarnings;
	}
	public void setYearEarnings(String yearEarnings) {
		this.yearEarnings = yearEarnings;
	}
	public String getInvestmentState() {
		return investmentState;
	}
	public void setInvestmentState(String investmentState) {
		this.investmentState = investmentState;
	}
	public String getInvestmentCreateTime() {
		return investmentCreateTime;
	}
	public void setInvestmentCreateTime(String investmentCreateTime) {
		this.investmentCreateTime = investmentCreateTime;
	}
	public User getInvestment_User() {
		return investment_User;
	}
	public void setInvestment_User(User investment_User) {
		this.investment_User = investment_User;
	}
	
	
	


}
