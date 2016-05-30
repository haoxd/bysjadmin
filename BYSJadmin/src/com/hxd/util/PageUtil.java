package com.hxd.util;



import com.hxd.model.Page;





public class PageUtil {

	/*private ApplicationContext ctx= null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}*/
	

	/*WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(servletContext);

	ctx.getBean("bean id");*/
	//不用初始化springIOC容器直接引用ioc容器当中的bean
	//adminServiceImpl asi = (adminServiceImpl)ContextLoader.getCurrentWebApplicationContext().getBean("adminservice");
	//adminServiceImpl asi = (adminServiceImpl) ctx.getBean("adminservice");
	public  static  Page getPage(String pageNoStr ,int number)
	{
		int pageNo = 1;
		
		// 获取到了当前页面的编号
		if (null != pageNoStr && !pageNoStr.equals(""))
		{
			pageNo = Integer.valueOf(pageNoStr);
		}
		
		Page pb = new Page();
		pb.setPageNo(pageNo);
		System.out.println("!!!!!!!!!!!");
		// 获取到了用户的总数
		//int totalNum = asi.getUserNumber();
		int totalNum = number;
		System.out.println("!!!!!!"+totalNum);
		
		// 通过用户的总数计算出总页面
		int totalPage = (totalNum % pb.getNumberPerPage() == 0) ? 
				(totalNum / pb.getNumberPerPage()) : (totalNum / pb.getNumberPerPage() + 1);
				
		pb.setTotalPage(totalPage);		
		
		return pb;
	}
	
	
}
