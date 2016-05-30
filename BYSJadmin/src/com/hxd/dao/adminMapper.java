package com.hxd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hxd.model.Admin;
import com.hxd.model.Investment;
import com.hxd.model.User;
import com.hxd.model.UserMessageBack;

public interface adminMapper {
	
	public Admin queryAdminLoginSystem(@Param("phone")String phone,@Param("password") String password ); //管理员登陆系统
	public Admin queryAdminInfo(@Param("adminid")int adminid,@Param("ordpwd")String ordpwd);//查询个人信息

	public Admin queryAdminInfoBYid(int adminid);//查询个人信息

	public Admin queryAdminInfoByPhone(String phone);//查询个人信息
	public List<User> queryUserInfos(int fromNo);//查询全部用户信息
	public List<User> queryUserInfoToEccel();
	public List<Investment> queryInvestmentInfo(int fromNo);//查询全部投资信心
	public List<Investment> queryInvestmentInfoEccel();
	public int getInvestmentNumber();//获取投资总数
	public int getUserNumber();//获取用户总数
	public int getUserInvestmrntsNumer(int iid);//获取用户投资总数
	public Investment queryInvestmen(int iid);
	public int deleateInvestmenrt(int iid);//删除投资信心
	public int updateInvestment(Investment investment);
	public int addInvestment(Investment  investment);
	public List<UserMessageBack> queryUserMessageBackinfos(int fromNo);//查询用户反馈意见
	public List<UserMessageBack> queryUserMessageBackinfosEccel();
	
	public int getUserMessageBackNumber();
	public int deleateUserMessageBack(int umid);//删除反馈意见
	
	public int getgetUserMessageBackNumbertoHao();
	public int getgetUserMessageBackNumbertoYiBan();
	public int getgetUserMessageBackNumbertoCha();
	public List<UserMessageBack> queryUserMessageBackinfosToHao(int fromNo);//查询用户反馈意见
	public List<UserMessageBack> queryUserMessageBackinfosToCha(int fromNo);//查询用户反馈意见
	public List<UserMessageBack> queryUserMessageBackinfosToYiBan(int fromNo);//查询用户反馈意见
	public int isUpdateUserLoginSystemToYes(int  uid);
	public int IsUpdateUserLoginSystemToNo( int uid);
	
	public int getUserToNanNumber();//男性用户数
	public int getUserToNvNumber();//女性用户数
	public int getWeekUserRegNumber();//周注册用户数
	public int getMonthUserRegNumber();//月注册用户数
	
	public List<User> queryUserInfoToInvestment(@Param("investmentName")String investmentName,@Param("fromNo")int fromNo);

	public int getqueryUserInfoToInvestmentNumber(String investmentName);
	public int updateAdminPassowrd(Admin admin);//修改密码
	public int updateAdminInfo(Admin admin);//修改个人信息
	
	public int addAdmin(Admin  admin);//添加管理员
	
	public List<Admin> queryAdminInfos( int fromNo);//查看管理员信息
	
	public int getAdminNumber();
	
	public int isUpdateAdminState(@Param("adminid")int adminid,@Param("adminState")String adminState);
}
