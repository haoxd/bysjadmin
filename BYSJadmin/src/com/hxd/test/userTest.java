package com.hxd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.adminMapper;
import com.hxd.model.Admin;
import com.hxd.model.Investment;
import com.hxd.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class userTest {
		@Autowired
		private adminMapper mapper;
		
		/*@Test
		public void getlist(){
			List<User> users = mapper.queryUserInfos(0);
			for (int i = 0; i < users.size(); i++) {
				System.out.println("aaaaaaaaaaaaa");
			System.out.println("userage ==="+users.get(i).getUserAge());	
			}
		}*/
		/*@Test
		public void getnumber(){
			//int i = mapper.getUserNumber();
			System.out.println(System.currentTimeMillis());
		}
*/
		/*@Test
		public void add(){
			Investment in = new Investment();
			String a = "aaaaaaaa";
			in.setInvestmentBody("aaaaaaaaa");
			in.setInvestmentCreateTime("sssss");
			in.setInvestmentName("vvv");
			in.setInvestmentState(a);
			in.setMonthEarnings(a);
			in.setYearEarnings(a);
			in.setWeekEarnings(a);
		
			
			int i = mapper.addInvestment(in);
			System.out.println(i);
			
		}*/
	/*@Test
		public void query(){
		List<User> us = mapper.queryUserInfoToInvestment("平安理财", 0);
		for (int i = 0; i < us.size(); i++) {
			System.out.println(us.get(i).getUserName());
		}
		}*/
	/*@Test
		public void queryadmin(){
			Admin ad = mapper.queryAdminLoginSystem("15754712018", "96e79218965eb72c92a549dd5a330112");
			System.out.println(ad.getAdminName());
			
			System.out.println("bbq");
			ad = mapper.queryAdminLoginSystem("15754712018", "96e79218965eb72c92a549dd5a330112");
			System.out.println(ad.getAdminChangeTime());

		}*/
		/*@Test
		public void queryinvestment(){
			Investment s   =  mapper.queryInvestmen(1);
			System.out.println(s.getInvestmentBody());
		}
		*/
		/*@Test
		public void getNumber(){
			int  s   =  mapper.getAdminNumber();
			System.out.println(s);
		}*/
		@Test
		public void  isadminstat(){
			int s = mapper.isUpdateAdminState(4, "YES");
			System.out.println(s);
			
		}
		
}
