package com.hxd.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.hxd.model.Admin;
import com.hxd.model.CustomException;
import com.hxd.model.Investment;

import com.hxd.model.Page;

import com.hxd.model.User;
import com.hxd.model.UserMessageBack;
import com.hxd.service.adminService;
import com.hxd.service.adminServiceImpl;
import com.hxd.util.ExcelUtil;
import com.hxd.util.MD5;
import com.hxd.util.PageUtil;


@Controller
@RequestMapping("/admin")
public class adminController {
	
	
	/**
	 * @Resource的作用相当于
	 * @Autowired，只不过@Autowired按byType自动注入，
	 * 而
	 * @Resource默认按 byName自动注入罢了。
	 * @Resource有两个属性是比较重要的，
	 * 分是name和type，Spring将@Resource注解的name属性解析为bean的名字，
	 * 而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，
	 * 而使用type属性时则使用byType自动注入策略。
	 * 如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
	 * 
	 * **/
	 @Resource(name = "adminservice")
	 private adminService asi;
	 private ModelAndView modelAndView = new ModelAndView();
	 private Date now = new Date();
	 private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	 private String ds = dateFormat.format(now);
	
	/**
	 * 管理员登录系统
	 * @param adminPhone
	 * @param adminPassword
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryAdminLoginSystem")
	public ModelAndView queryAdminLoginSystem(String adminPhone,String adminPassword,HttpServletRequest request){
		  
		
		try {
			String AdminPassword = new MD5().getMD5ofStr(adminPassword);//将用户的登录密码进行md5加密
			System.out.println(AdminPassword+":AdminPassword");
			Admin admin = asi.queryAdminInfo(adminPhone, AdminPassword);
			boolean result = asi.isQueryAdminLoginSystem(adminPhone, AdminPassword);
			
			if(result){
				
				 
				request.getSession().setAttribute("admin", admin);
				modelAndView.setViewName("/admin/adminmenu");
				return modelAndView;
			}else{
				request.setAttribute("loginFailInfoMessage", "用户名或密码错误，请重新登陆系统!!!");
				modelAndView.setViewName("/adminlogin");
				return modelAndView;	
			}
			
		} catch (Exception e) {
			request.setAttribute("loginFailInfoMessage", "用户名或密码错误，请重新登陆系统!!!");
			modelAndView.setViewName("/adminlogin");
			return modelAndView;
		}
		
	}
	/**
	 * 查询管理员个人信息
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryAdminInfo")
	public ModelAndView queryAdminInfo(int id,HttpServletRequest request){
		try {
			
		
				Admin admin = asi.queryAdminInfoByid(id);
				
				request.getSession().setAttribute("admin", admin);
				modelAndView.setViewName("/info/admininfo");
				return modelAndView;
			
			
		} catch (Exception e) {
			request.setAttribute("loginFailInfoMessage", "用户名或密码错误，请重新登陆系统!!!");
			modelAndView.setViewName("/adminlogin");
			return modelAndView;
		}
		
	}
	
	
	/**
	 * 下载用户信息到excel
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/download")
	 public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{

			String fileName = "用户excel文件";
			 List<User> userList = asi.queryUserInfosToExcel();
			 List<Map<String ,Object>> lists = createExcelRecord(userList);
			 String columnNames[]={"ID","姓名","昵称","手机号","年龄","性别","邮箱","身份证号码","个人简介","注册时间"};//列名
			 String keys[]    =     {"id","name","nickname","phone","age","sex","emil","idcard","text","createtime"};
			
			 ByteArrayOutputStream os = new ByteArrayOutputStream();//常用语存储数据，用来存放缓存数据
	        try {
	        	 ExcelUtil.createWorkBook(lists,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        // 设置response参数，可以打开下载页面
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	        	  bis = new BufferedInputStream(is);
		            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	
	
	
	
	 /**
	    * 创建userinfo excel表数据
	 * @param userInfo
	 * @return
	 */
	private List<Map<String, Object>> createExcelRecord(List<User> userInfo) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();//创建一个list集合 ，用于保存下面的map
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        User ThisUser=null;
	        for (int j = 0; j < userInfo.size(); j++) { //遍历集合，将每一个user对象放入到map当中
	        	ThisUser=userInfo.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("id", ThisUser.getUserID());
	            mapValue.put("name", ThisUser.getUserName());
	            mapValue.put("nickname", ThisUser.getUserNickName());
	            mapValue.put("phone", ThisUser.getUserPhone());
	            mapValue.put("age", ThisUser.getUserAge());
	            mapValue.put("sex", ThisUser.getUserSex());
	            mapValue.put("emil",ThisUser.getUserEmil());	      
	            mapValue.put("idcard",ThisUser.getUserIdcard());
	            mapValue.put("text",ThisUser.getUserText());
	            mapValue.put("createtime", ThisUser.getUserCreateTime());
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	
	/**
	 * 
	 * 查询全部用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryUserInfos")
	public ModelAndView queryUserInfos(HttpServletRequest request,HttpServletResponse response){
		
	
		 try {			 
			 
			 String pageNoStr = request.getParameter("pageNo");		
			 int number = asi.getUserNumber();//用户总数		
			 Page pb = PageUtil.getPage(pageNoStr,number);		
			 List<User> queryUserInfos = asi.queryUserInfos(pb);			
			 request.setAttribute("pb", pb);
			 String countNumber = asi.getUserNumber()+"";//全部用户数
			 String nanNumber = asi.getUserToNanNumber()+"";//男
			 String nvNumber = asi.getUserToNvNumber()+"";//女
			 String weekNumber= asi.getWeekUserRegNumber()+"";//周
			 String MonthNumber= asi.getMonthUserRegNumber()+"";//月			 
			 modelAndView.addObject("nanNumber", nanNumber);
			 modelAndView.addObject("nvNumber", nvNumber);
			 modelAndView.addObject("weekNumber", weekNumber);
			 modelAndView.addObject("MonthNumber", MonthNumber);
			 modelAndView.addObject("countNumber", countNumber);
			 modelAndView.addObject("queryUserInfos", queryUserInfos);
			 modelAndView.setViewName("/info/userinfo");
			 return modelAndView;
		} catch (Exception e) {
		return modelAndView;
		}
		
	}
	
	
	 @RequestMapping(value="/downloadInvestment")
	 public String downloadInvestment(HttpServletRequest request,HttpServletResponse response) throws IOException{

			String fileName = "投资信息excel文件";
			 List<Investment> InvestmentList = asi.queryInvestmentInfosToExcel();
			 List<Map<String ,Object>> lists = createExcelRecordInvestment(InvestmentList);
			 String columnNames[]={"ID","投资名称","内容","周收益","月收益","年收益","类型","创建时间"};//列名
			 String keys[]    =     {"id","name","text","week","month","year","state","time"};
			
			 ByteArrayOutputStream os = new ByteArrayOutputStream();//常用语存储数据，用来存放缓存数据
	        try {
	        	 ExcelUtil.createWorkBook(lists,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        // 设置response参数，可以打开下载页面
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	        	  bis = new BufferedInputStream(is);
		            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	
	
	
	
	 /**
	    * 创建createExcelRecordInvestment excel表数据
	 * @param userInfo
	 * @return
	 */
	private List<Map<String, Object>> createExcelRecordInvestment(List<Investment> InvestmentInfo) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();//创建一个list集合 ，用于保存下面的map
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        Investment ThisInvestment=null;
	        for (int j = 0; j < InvestmentInfo.size(); j++) { //遍历集合，将每一个user对象放入到map当中
	        	ThisInvestment=InvestmentInfo.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("id", ThisInvestment.getInvestmentId());
	            mapValue.put("name", ThisInvestment.getInvestmentName());
	            mapValue.put("text", ThisInvestment.getInvestmentBody());
	            mapValue.put("week", ThisInvestment.getWeekEarnings());
	            mapValue.put("month", ThisInvestment.getMonthEarnings());
	            mapValue.put("year", ThisInvestment.getYearEarnings());
	            mapValue.put("state",ThisInvestment.getInvestmentState());	      
	            mapValue.put("time",ThisInvestment.getInvestmentCreateTime());
	           
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	
	
	
	
	  
	/**
	 * 全部投资信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryInvermentInfos")
	public ModelAndView queryInvermentInfos(HttpServletRequest request){
		try {
			String pageNoStr = request.getParameter("pageNo");		
			int number = asi.getInvestmentNumber();
			
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<Investment> queryinvementInfos = asi.queryInvestmentInfos(pb);
			 List<String> userNumbers  = new ArrayList<String>();
			 for (int i = 0; i < queryinvementInfos.size(); i++) {
				 String userNumber = asi.getUserInvementsNumber(queryinvementInfos.get(i).getInvestmentId())+"";	
				
				 userNumbers.add(userNumber);
				
			 }	
			 String inverstmentNumber= asi.getInvestmentNumber()+"";
			
			 modelAndView.addObject("userNumbers", userNumbers);
			 request.setAttribute("pb", pb);
			 modelAndView.addObject("inverstmentNumber", inverstmentNumber);
			 modelAndView.addObject("queryinvementInfos", queryinvementInfos);
			 modelAndView.setViewName("/info/invementinfo");
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	
	
	
	

	 @RequestMapping(value="/downloaduserMessage")
	 public String downloaduserMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{

			String fileName = "用户反馈意见excel文件";
			 List<UserMessageBack> UserMessageBackList = asi.queryUserMessageBackInfosToExcel();
			 List<Map<String ,Object>> lists = createExcelUserMessage(UserMessageBackList);
			 String columnNames[]={"用户名","联系方式","时间","等级","内容"};//列名
			 String keys[]    =     {"name","phone","time","state","text"};
			
			 ByteArrayOutputStream os = new ByteArrayOutputStream();//常用语存储数据，用来存放缓存数据
	        try {
	        	 ExcelUtil.createWorkBook(lists,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        // 设置response参数，可以打开下载页面
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	        	  bis = new BufferedInputStream(is);
		            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	
	
	
	
	 /**
	    * 创建createExcelRecordInvestment excel表数据
	 * @param userInfo
	 * @return
	 */
	private List<Map<String, Object>> createExcelUserMessage(List<UserMessageBack> UserMessageBackInfo) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();//创建一个list集合 ，用于保存下面的map
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        UserMessageBack ThisUserMessageBack=null;
	        for (int j = 0; j < UserMessageBackInfo.size(); j++) { //遍历集合，将每一个user对象放入到map当中
	        	ThisUserMessageBack=UserMessageBackInfo.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("name", ThisUserMessageBack.getUserMessageBackName());
	            mapValue.put("phone", ThisUserMessageBack.getUserMessageBackPhone());
	            mapValue.put("time", ThisUserMessageBack.getUserMessageTime());
	            mapValue.put("state", ThisUserMessageBack.getUserMessageIdear());
	            mapValue.put("text", ThisUserMessageBack.getUserMessageBackText());
	           
	         
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	
	
	
	
	
	
	/**
	 * 全部用户反馈的意见
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMessageBackInfo")
	public ModelAndView queryUserMessageBackInfo( HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");		
			 int number = asi.getUserMessageBackNumber();
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<UserMessageBack> queryMessgaeInfos = asi.queryUserMessageBackInfo(pb);
			
			 request.setAttribute("pb", pb);
			 String userMessageNumber  = asi.getUserMessageBackNumber()+"";
			 modelAndView.addObject("queryMessgaeInfos", queryMessgaeInfos);
			 modelAndView.addObject("userMessageNumber", userMessageNumber);
			 modelAndView.setViewName("/info/usermessageinfo");
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 好评
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMessageBackInfoHao")
	public ModelAndView queryUserMessageBackInfoHao( HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");		
			 int number = asi.getgetUserMessageBackNumbertoHao();
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<UserMessageBack> queryMessgaeInfos = asi.queryUserMessageBackinfosToHao(pb);
			
			 request.setAttribute("pb", pb);
			 String userMessageNumber  = asi.getgetUserMessageBackNumbertoHao()+"";
			 modelAndView.addObject("queryMessgaeInfos", queryMessgaeInfos);
			 modelAndView.addObject("userMessageNumber", userMessageNumber);
			 modelAndView.setViewName("/info/usermessageinfotohao");
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 差评
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMessageBackInfocha")
	public ModelAndView queryUserMessageBackInfocha( HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");		
				
			 int number = asi.getgetUserMessageBackNumbertoCha();
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<UserMessageBack> queryMessgaeInfos = asi.queryUserMessageBackinfosToCha(pb);
			
			 request.setAttribute("pb", pb);
			 String userMessageNumber  = asi.getgetUserMessageBackNumbertoCha()+"";
			 modelAndView.addObject("queryMessgaeInfos", queryMessgaeInfos);
			 modelAndView.addObject("userMessageNumber", userMessageNumber);
			 modelAndView.setViewName("/info/usermessageinfotocha");
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 一般
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryUserMessageBackInfoyiban")
	public ModelAndView queryUserMessageBackInfoyiban( HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");		
				
			 int number = asi.getgetUserMessageBackNumbertoYiBan();
				
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<UserMessageBack> queryMessgaeInfos = asi.queryUserMessageBackinfosToYiBan(pb);
			
			 request.setAttribute("pb", pb);
			 String userMessageNumber = asi.getgetUserMessageBackNumbertoYiBan()+"";
			 modelAndView.addObject("queryMessgaeInfos", queryMessgaeInfos);
			 modelAndView.addObject("userMessageNumber", userMessageNumber);
			 modelAndView.setViewName("/info/usermessageinfotoyiban");
			 return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 删除用户反馈意见
	 * @param umid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleateUserMessageByUmid")
	public ModelAndView deleateUserMessageByUmid( int umid,HttpServletRequest request){
		try {
			boolean result = asi.isDeleateUsermessageBacks(umid);
			if(result){
				modelAndView.addObject("delsuccess", "删除成功");
				modelAndView.setViewName("redirect:/admin/queryUserMessageBackInfo");
			}
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}
	/**
	 * 更具id查询投资信息
	 * @param iid
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryInvestmentByiid")
	public ModelAndView queryInvestmentByiid(int iid,HttpServletRequest request){
		try {
			Investment queryInvestment = asi.queryinvestmentID(iid);
			modelAndView.addObject("queryInvestment", queryInvestment);
			modelAndView.setViewName("/info/updateinvement");
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("/info/updateinvement");
			return modelAndView;
		}
	}
	/**
	 * 更新理财信息
	 * @param invement
	 * @param request
	 * @return
	 */
	@RequestMapping(value="updateInvestmentInfo")
	public ModelAndView updateInvestmentInfo(Investment invement ,HttpServletRequest request){
		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			String ds = dateFormat.format(now);
			Investment updateInvestment= asi.queryinvestmentID(invement.getInvestmentId());
			updateInvestment.setInvestmentName(invement.getInvestmentName());
			updateInvestment.setInvestmentState(invement.getInvestmentState());
			updateInvestment.setMonthEarnings(invement.getMonthEarnings());
			updateInvestment.setWeekEarnings(invement.getWeekEarnings());
			updateInvestment.setYearEarnings(invement.getYearEarnings());
			updateInvestment.setInvestmentBody(invement.getInvestmentBody());
			updateInvestment.setInvestmentCreateTime(ds);
			
			boolean result = asi.isUpdateInvestment(updateInvestment);
			if(result){
				modelAndView.setViewName("redirect:/admin/queryInvermentInfos");
				request.getSession().setAttribute("updateinvestment", invement.getInvestmentName()+"编辑成功");
				
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/admin/queryInvestmentByiid?iid="+invement.getInvestmentId());
			request.getSession().setAttribute("updateinvestment","编辑信息有误请重新输入");
			return modelAndView;
		}
		
	}
	/**
	 * 添加理财信息
	 * @param investment
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addInvestment")
	public ModelAndView addInvestment(Investment investment,HttpServletRequest request){
		System.out.println("添加理财信息成功");
		try {
			
			investment.setInvestmentCreateTime(ds);
			System.out.println(investment.getInvestmentBody()+investment.getInvestmentCreateTime());
			boolean result =asi.isAddInvestment(investment);
			System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
			if(result){
				modelAndView.setViewName("redirect:/admin/queryInvermentInfos");
				request.getSession().setAttribute("updateinvestment", investment.getInvestmentName()+"添加成功");
				
			}
			return modelAndView;
		} catch (Exception e) {
	      	return modelAndView;
		}
		
	}
	/**
	 * 用户审核通过
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isUpateUserLoginStateYes")
	public ModelAndView isUpateUserLoginStateYes(int uid ,HttpServletRequest request){
		try {
			boolean result = asi.isUpdateUserLoginSystemToYes(uid);
			if(result){
				modelAndView.setViewName("redirect:/admin/queryUserInfos");
				request.getSession().setAttribute("updatesuccess", "操作成功");
					
			}
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
		
	}
	/**
	 * 用户审核不通过
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isUpateUserLoginStateNo")
	public ModelAndView isUpateUserLoginStateNo(int uid ,HttpServletRequest request){
		try {
			boolean result = asi.IsUpdateUserLoginSystemToNo(uid);
			if(result){
				modelAndView.setViewName("redirect:/admin/queryUserInfos");
				request.getSession().setAttribute("updatesuccess", "操作成功");					
			}
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
		
	}
	
	
	
	/**
	 * 统计查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryUserInfosToInvestment",method=RequestMethod.GET)
	public ModelAndView queryUserInfosToInvestment(HttpServletRequest request){
	
		try {
			 String investmentName = request.getParameter("investmentName");
			 String pageNoStr = request.getParameter("pageNo");	
			 investmentName = new String(investmentName.getBytes("iso8859-1"),"utf-8");  //解决get请求乱码问题
			System.out.println("investmentName"+investmentName);
			int number = asi.getqueryUserInfoToInvestmentNumber(investmentName);
;			
			 Page pb = PageUtil.getPage(pageNoStr, number);
		
			 List<User> queryUserInfos = asi.queryUserInfoToInvestment(investmentName, pb);
			 System.out.println("qqqqqqqqqqqq:"+queryUserInfos.size());
			 if( queryUserInfos.size() == 0 ){
				 modelAndView.addObject("queryfail", "无结果，请重新输入");
				 modelAndView.setViewName("/info/countuserinvestment");
				 return modelAndView;
			}else{
			 request.setAttribute("pb", pb);
			 String countnumber = asi.getqueryUserInfoToInvestmentNumber(investmentName)+"";
			 modelAndView.addObject("investmentName", investmentName);
			 modelAndView.addObject("countnumber", countnumber);
			 modelAndView.addObject("queryUserInfos", queryUserInfos);
			 modelAndView.setViewName("/info/userinfotoinvestment");
			 return modelAndView;
			 }
		} catch (Exception e) {
		return modelAndView;
		}
		
	}
	/**
	 * 修改密码
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateAdminPassword")
	public ModelAndView updateAdminPassword(String ordpassword,Admin admin ,HttpServletRequest request)throws Exception{
		Admin updateAdmin  =asi.queryAdminInfoByid(admin.getAdminID());

		String	ordpasswords = new MD5().getMD5ofStr(ordpassword);//获取到旧密码通过MD5加密
	    System.out.println("旧密码经过MD5加密后"+ordpasswords); 
		String password_table = updateAdmin.getAdminPassword();
		System.out.println("管理员数据库端的密码"+password_table);
		if( !ordpasswords.equalsIgnoreCase(password_table)){
			//throw new CustomException("旧密码错误");
			modelAndView.setViewName("/admin/right");
			request.setAttribute("loginFailInfoMessage", "旧密码填写错误");
			return modelAndView;
		}
		
		try {
			String savePassword = new MD5().getMD5ofStr(admin.getAdminPassword());
			System.out.println("要修改的密码"+savePassword);
			updateAdmin.setAdminPassword(savePassword);
			boolean result = asi.isUpdateAdminPassword(updateAdmin);
			if(result){
				modelAndView.setViewName("/admin/right");
				request.getSession().setAttribute("loginFailInfoMessage", "密码修改成功，请重新登录");				
			}
			return modelAndView;
		} catch (Exception e) {
			request.setAttribute("loginFailInfoMessage", "旧密码填写错误");
			return modelAndView;
		}
		
	}
	
	/**
	 * 修改个人信息
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateAdminInfo")
	public ModelAndView updateAdminInfo(Admin admin ,HttpServletRequest request){
		
		try {
			Admin updateAdmin  =asi.queryAdminInfoByid(admin.getAdminID());
			updateAdmin.setAdminName(admin.getAdminName());
			updateAdmin.setAdminPhone(admin.getAdminPhone());
			updateAdmin.setAdminChangeTime(ds);
			updateAdmin.setAdminText(admin.getAdminText());
			boolean result = asi.isUpdateAdminInfo(updateAdmin);
			if(result){
				modelAndView.setViewName("/admin/right");
				request.getSession().setAttribute("loginFailInfoMessage", "个人信息修改成功");
				
				
			}
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
		
	}
	/**
	 * 申请成为管理员
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addAdmin", method=RequestMethod.POST)
	public ModelAndView addAdmin(Admin admin,HttpServletRequest request){
		
	try {
			admin.setAdminChangeTime(ds);
			admin.setAdminCreateTime(ds);
			String admin_password_MD5 = new MD5().getMD5ofStr("111111");
			admin.setAdminPassword(admin_password_MD5);
			admin.setAdminState("NO");
			boolean result = asi.isAddAdmin(admin);
			System.out.println("resulr"+result);
			if(result){
				request.getSession().setAttribute("addsuccess", "您的信息已提交，请等待审核");
				modelAndView.setViewName("/info/welcomeadmin");
				return modelAndView;
			}else{
				request.getSession().setAttribute("addsuccess","您的信息不符合，请重新填写");
				modelAndView.setViewName("/info/welcomeadmin");
				return modelAndView;
			}
		
		} catch (Exception e) {
			request.getSession().setAttribute("addsuccess","您的信息不符合，请重新填写");
			modelAndView.setViewName("/info/welcomeadmin");
			return modelAndView;
		}
		
		
		
	}
	/**
	 * 查询全部管理员信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryListToAdminInfo")
	public ModelAndView queryListToAdminInfo(HttpServletRequest request){
		try {
			 String pageNoStr = request.getParameter("pageNo");					
			 int number = asi.getAdminNumber();		//管理员总数		
			 Page pb = PageUtil.getPage(pageNoStr, number);	
			 List<Admin> queryAdminInfos = asi.queryAdminInfos(pb);			
			 request.setAttribute("pb", pb);
			 modelAndView.setViewName("/info/admininfosomes");
			 modelAndView.addObject("queryAdminInfos", queryAdminInfos);
			 return modelAndView;
		} catch (Exception e) {
			 return modelAndView;
		}
		
	}
	
	/**
	 * 管理员权限
	 * @param adminid
	 * @param adminstate
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isUpdateAdminState" ,method=RequestMethod.GET)
	public ModelAndView isUpdateAdminState(int adminid,String adminstate,HttpServletRequest request){		
		try {			 
			if(asi.isUpdateAdminState(adminid, adminstate)){
				modelAndView.setViewName("redirect:/admin/queryListToAdminInfo");
				request.getSession().setAttribute("updatesuccess", "操作成功");	
			}
			return modelAndView;
		} catch (Exception e) {			
			return modelAndView;
		}
		
	}
	
}
