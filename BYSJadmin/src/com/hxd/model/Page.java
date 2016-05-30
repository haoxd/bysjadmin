package com.hxd.model;

/**
 * @author acer11
 *  作者：
* 创建时间：2016-1-4 下午6:31:49  
* 项目名称：2016MyAccountGraduationDesign  
* @author daniel  
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：Page.java  
* 类说明：
 */
public class Page {
	private int totalPage;//总页数
	private int numberPerPage = 5;//每一页的数	
	private int pageNo;//页数编号
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNumberPerPage() {
		return numberPerPage;
	}
	public void setNumberPerPage(int numberPerPage) {
		this.numberPerPage = numberPerPage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
}
