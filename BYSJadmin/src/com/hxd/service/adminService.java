package com.hxd.service;

import java.util.List;



import com.hxd.model.Admin;
import com.hxd.model.Investment;
import com.hxd.model.Page;
import com.hxd.model.User;
import com.hxd.model.UserMessageBack;

public interface adminService {
	
	public boolean isQueryAdminLoginSystem(String phone,String Password);
	public Admin queryAdminInfo(String phone,String password);
	public Admin queryAdminInfoByPhone(String phone);
	public List<User> queryUserInfos(Page page);
	
	public List<Investment> queryInvestmentInfos(Page page);
	public int getUserNumber();//获取用户总数
	public int getInvestmentNumber();
	public int getUserInvementsNumber(int iid);
	public boolean  isDeleateInvestments(int iid);
	public boolean isDeleateUsermessageBacks(int umid);
	public Investment queryinvestmentID(int iid);
	public boolean isUpdateInvestment(Investment Investment);
	public boolean isAddInvestment(Investment Investment);
	public List<UserMessageBack> queryUserMessageBackInfo(Page page);
	public int getUserMessageBackNumber();
	public Admin queryAdminInfo(int adminid,String ordpwd);
	public Admin queryAdminInfoByid(int adminid);
	
	
	
	public int getgetUserMessageBackNumbertoHao();
	public int getgetUserMessageBackNumbertoYiBan();
	public int getgetUserMessageBackNumbertoCha();
	public List<UserMessageBack> queryUserMessageBackinfosToHao(Page page);//查询用户反馈意见
	public List<UserMessageBack> queryUserMessageBackinfosToCha(Page page);//查询用户反馈意见
	public List<UserMessageBack> queryUserMessageBackinfosToYiBan(Page page);//查询用户反馈意见

	//用户登录权限
	public boolean isUpdateUserLoginSystemToYes(int  uid);
	public boolean IsUpdateUserLoginSystemToNo( int uid);
	
	
	public int getUserToNanNumber();//男性用户数
	public int getUserToNvNumber();//女性用户数
	public int getWeekUserRegNumber();//周注册用户数
	public int getMonthUserRegNumber();//月注册用户数
	
	
	
	public List<User> queryUserInfoToInvestment(String investmentName,Page page);

	public int getqueryUserInfoToInvestmentNumber(String investmentName);

	public boolean isUpdateAdminPassword(Admin admin);
	public boolean isUpdateAdminInfo(Admin admin);
	
	
	public List<User> queryUserInfosToExcel();
	public List<UserMessageBack> queryUserMessageBackInfosToExcel();
	public List<Investment> queryInvestmentInfosToExcel();
	
	
	public boolean isAddAdmin(Admin admin);//添加管理员
	
	
	public List<Admin> queryAdminInfos(Page page);
	
	public int getAdminNumber();
	
	public boolean isUpdateAdminState(int adminid,String adminState);//管理员权限
	
} 
