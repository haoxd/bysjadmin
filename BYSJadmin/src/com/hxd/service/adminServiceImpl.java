package com.hxd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxd.dao.adminMapper;
import com.hxd.model.Admin;
import com.hxd.model.Investment;
import com.hxd.model.Page;
import com.hxd.model.User;
import com.hxd.model.UserMessageBack;


@Service("adminservice")
public class adminServiceImpl implements adminService {

		@Autowired
		private adminMapper adminmapper;
		
		Logger log = Logger.getLogger(adminServiceImpl.class);//创建log4j实例在这个类当中
		
		/**
		 * 打印日志
		 * @param sysolog
		 */
		private void sysoLog(String sysolog){
			PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		
			log.info(sysolog);
		}
		
	/* 登陆系统
	 * @see com.hxd.service.adminService#isQueryAdminLoginSystem(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unused")
	@Override	
	public boolean isQueryAdminLoginSystem(String phone, String password) {
		Admin loginSystemAdmin = adminmapper.queryAdminLoginSystem(phone, password);
		
		String AdminLoginlog ="管理员："+loginSystemAdmin.getAdminName()+"登录系统";
		sysoLog(AdminLoginlog);
	
		if(loginSystemAdmin!=null){
			return true;
		}else{
			return false;
		}
	}



	/* 查询admin信息
	 * @see com.hxd.service.adminService#queryAdminInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin queryAdminInfo(String phone, String password) {
		
		return adminmapper.queryAdminLoginSystem(phone, password);
	}



	/*分页查询全部用户信息
	 * @see com.hxd.service.adminService#queryUserInfos(com.hxd.model.Page)
	 */
	@Override
	public List<User> queryUserInfos(Page page) {
		int fromNo = (page.getPageNo() - 1) * 5;
		return adminmapper.queryUserInfos(fromNo);
	}



	/*获取用户总数
	 * @see com.hxd.service.adminService#getUserNumber()
	 */
	@Override
	public int getUserNumber() {
		int u = adminmapper.getUserNumber();
		return u;
	}



	/* 全部投资信心
	 * @see com.hxd.service.adminService#queryInvestmentInfos(com.hxd.model.Page)
	 */
	@Override
	public List<Investment> queryInvestmentInfos(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		
		return adminmapper.queryInvestmentInfo(fromNo);
	}



	/*  投资总数
	 * @see com.hxd.service.adminService#getInvestmentNumber()
	 */
	@Override
	public int getInvestmentNumber() {
		return adminmapper.getInvestmentNumber();
	}



	@Override
	public int getUserInvementsNumber(int iid) {
		return adminmapper.getUserInvestmrntsNumer(iid);
	}

	
	/* 删除投资信心
	 * 添加事务注解
	 * (1)使用spropagation指定事务的传播行为，即当前事务方法被另一个事务方法调用时如何使用事务例如： 
	 * 		（1.1）REQUIRED:使用一个事务
	 * 		（1.2）REQUIRES_NEW：开启新的事物
	 * (2) 使用isolation指定事务的隔离级别
	 * 		（2.1）READ_COMMITTED：最为常用，为读以提交
	 * (3)默认情况下spring的什么式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置
	 * 		（3.1）通常情况下取默认值，一半不进行设置
	 * 		（3.2）进行设置时，例如这四个noRollbackFor等等，，，对那些方法进行回滚和不回滚
	 * (4)timeout:设置事务的超时时间
	 * (5)readOnly:指定事务是否为只读，表示这个事务只进行读取数据但不进行更新数据
	 * 		（5.1）这样可以帮助数据库引擎优化事务，若只进行读取数据，设置为true，
	 * @see com.hxd.service.adminService#isDeleateInvestments(int)
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,timeout=3,readOnly=false)
	@Override
	public boolean isDeleateInvestments(int iid) {
		int result = adminmapper.deleateInvestmenrt(iid);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}


	
	/* 查询投资信息
	 * @see com.hxd.service.adminService#queryinvestmentID(int)
	 */
	@Override
	public Investment queryinvestmentID(int iid) {
	
		return adminmapper.queryInvestmen(iid);
	}


	/* 更新投资信息
	 * @see com.hxd.service.adminService#isUpdateInvestment(com.hxd.model.Investment)
	 */
	@Transactional
	@Override
	public boolean isUpdateInvestment(Investment Investment) {

		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String AdminLoginlog ="管理员修改了"+Investment.getInvestmentName()+"理财产品的信息";
		//log.info(AdminLoginlog);
		sysoLog(AdminLoginlog);
		int i = adminmapper.updateInvestment(Investment);
		if(i>0){
			return true;
		}else{
		return false;
	}}



	/* 添加投资信息
	 * @see com.hxd.service.adminService#isAddInvestment(com.hxd.model.Investment)
	 */
	@Override
	public boolean isAddInvestment(Investment Investment) {

		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String AdminLoginlog ="管理员添加了"+Investment.getInvestmentName()+"理财产品";
		//log.info(AdminLoginlog);
		sysoLog(AdminLoginlog);
		int i = adminmapper.addInvestment(Investment);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}



	/* 查询全部反馈信息
	 * @see com.hxd.service.adminService#queryUserMessageBackInfo(com.hxd.model.Page)
	 */
	@Override
	public List<UserMessageBack> queryUserMessageBackInfo(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return adminmapper.queryUserMessageBackinfos(fromNo);
	}



	/*获取反馈信息总数
	 * @see com.hxd.service.adminService#getUserMessageBackNumber()
	 */
	@Override
	public int getUserMessageBackNumber() {
		return adminmapper.getUserMessageBackNumber();
	}


	/* 删除反馈意见
	 * @see com.hxd.service.adminService#isDeleateUsermessageBacks(int)
	 */
	@Transactional
	@Override
	public boolean isDeleateUsermessageBacks(int umid) {

		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String AdminLoginlog ="管理员删除了 一条反馈意见 ，id为："+umid;
		
		//log.info(AdminLoginlog);
		sysoLog(AdminLoginlog);
		int i  = adminmapper.deleateUserMessageBack(umid);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public int getgetUserMessageBackNumbertoHao() {
		return adminmapper.getgetUserMessageBackNumbertoHao();
	}



	@Override
	public int getgetUserMessageBackNumbertoYiBan() {
		return adminmapper.getgetUserMessageBackNumbertoYiBan();
	}



	@Override
	public int getgetUserMessageBackNumbertoCha() {
		return adminmapper.getgetUserMessageBackNumbertoCha();
	}



	@Override
	public List<UserMessageBack> queryUserMessageBackinfosToHao(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return adminmapper.queryUserMessageBackinfosToHao(fromNo);
	}



	@Override
	public List<UserMessageBack> queryUserMessageBackinfosToCha(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return adminmapper.queryUserMessageBackinfosToCha(fromNo);
	}



	@Override
	public List<UserMessageBack> queryUserMessageBackinfosToYiBan(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return  adminmapper.queryUserMessageBackinfosToYiBan(fromNo);
	}


	@Transactional
	@Override
	public boolean isUpdateUserLoginSystemToYes(int uid) {
		int i = adminmapper.isUpdateUserLoginSystemToYes(uid);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}


	@Transactional
	@Override
	public boolean IsUpdateUserLoginSystemToNo(int uid) {
		int  i = adminmapper.IsUpdateUserLoginSystemToNo(uid);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public int getUserToNanNumber() {
		return adminmapper.getUserToNanNumber();
	}



	@Override
	public int getUserToNvNumber() {
	
		return adminmapper.getUserToNvNumber();
	}



	@Override
	public int getWeekUserRegNumber() {
	
		return adminmapper.getWeekUserRegNumber();
	}



	@Override
	public int getMonthUserRegNumber() {
	
		return adminmapper.getMonthUserRegNumber();
	}



	@Override
	public List<User> queryUserInfoToInvestment(String investmentName, Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return adminmapper.queryUserInfoToInvestment(investmentName, fromNo);
	}



	@Override
	public int getqueryUserInfoToInvestmentNumber(String investmentName) {
		return adminmapper.getqueryUserInfoToInvestmentNumber(investmentName);
	}



	@Override
	public Admin queryAdminInfo(int adminid,String ordpwd) {
		return adminmapper.queryAdminInfo(adminid,ordpwd);
	}


	@Transactional
	@Override
	public boolean isUpdateAdminPassword(Admin admin) {
		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String AdminLoginlog ="管理员："+admin.getAdminName()+"修改了登录密码";
		sysoLog(AdminLoginlog);
		//log.info(AdminLoginlog);
		int i = adminmapper.updateAdminPassowrd(admin);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}


	@Transactional
	@Override
	public boolean isUpdateAdminInfo(Admin admin) {
		//PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		String AdminLoginlog ="管理员："+admin.getAdminName()+"修改了个人信息";
		sysoLog(AdminLoginlog);
		//	log.info(AdminLoginlog);
		int i = adminmapper.updateAdminInfo(admin);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public List<User> queryUserInfosToExcel() {
		
		return adminmapper.queryUserInfoToEccel();
	}



	@Override
	public List<UserMessageBack> queryUserMessageBackInfosToExcel() {
		return adminmapper.queryUserMessageBackinfosEccel();
	}



	@Override
	public List<Investment> queryInvestmentInfosToExcel() {
		return adminmapper.queryInvestmentInfoEccel();
	}



	@Override
	public Admin queryAdminInfoByPhone(String phone) {
		return adminmapper.queryAdminInfoByPhone(phone);
	}



	@Override
	public Admin queryAdminInfoByid(int adminid) {
		return adminmapper.queryAdminInfoBYid(adminid);
	}

	@Override
	public boolean isAddAdmin(Admin admin) {
		int i = adminmapper.addAdmin(admin);
		if(i>0){
			return  true;
		}else{
			return false;
		}
	}

	@Override
	public List<Admin> queryAdminInfos(Page page) {
		int fromNo = (page.getPageNo()-1)*5;
		return adminmapper.queryAdminInfos(fromNo);
	}

	@Override
	public int getAdminNumber() {
		return adminmapper.getAdminNumber();
	}
	@Transactional
	@Override
	public boolean isUpdateAdminState(int adminid, String adminState) {
		int i = adminmapper.isUpdateAdminState(adminid, adminState);
		if(i>0){
			return  true;
		}else{
			return  false;
		}
	}



	

}
