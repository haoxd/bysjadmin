 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有投资信息</title>
<style type="text/css">
table	li{
	list-style: none;
	}
table
  {
  border-collapse:collapse;
  }

table,th, td
  {
  border: 1px solid black;
 
  }
table td
{
 width:80px;height:0px
}
</style>
</head>
<body  background="./resouse/image/back02.jpg" >
<center>
<h4>全部投资信息</h4>

	
<h5> <font color="orange">${updateinvestment }</font></h5>
<p style="text-align:left; width:700px; margin:0 auto;">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	导出：<font color="red"><a href="http://localhost:8080/BYSJadmin/admin/downloadInvestment">文档</a></font>
	</p>

		<table border="1" align="center" border:#ee0000 3 ridge >
		
	

		
			
			
		
			
			<tr  bgcolor="orange" >
		
		<!-- 	<th><font color="blue">选择</font></th>
			 -->
				<th><font color="blue">投资名称</font></th>
				<th><font color="blue">周收益</font></th>
				<th><font color="blue">月收益</font></th>
				<th><font color="blue">年收益</font></th>
				<th><font color="blue">投资类型</font></th>				
				<th><font color="blue">创建时间</font></th>
				<th><font color="blue">投资内容</font></th>
			
				<th><font color="blue">操作</font></th>
			</tr>
	<c:forEach items="${queryinvementInfos}" var="invementinfo">
	<tr onmouseout="this.style.background='white'" onmouseover="this.style.background='Aquamarine'">
<%-- 
	   <td align="center"><input type="checkbox" name="choose" value="${invementinfo.investmentId}">
			 --%>		
	    <td  title="${invementinfo.investmentBody }"><font color="red">${invementinfo.investmentName}</font></td>
	      <td >${invementinfo.weekEarnings}</td>
	      <td >${invementinfo.monthEarnings}</td>	
	      <td >${invementinfo.yearEarnings}</td>		
		<td >${invementinfo.investmentState}</td>
	   
	   <td align="center">${invementinfo.investmentCreateTime} </td>
	
	
		  <td >
		  <p  class="" style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;" title="  ${invementinfo.investmentBody} ">
		  ${invementinfo.investmentBody}
		  </p>
		  </td>
		 
	 	
	  <td align="center">
		<a href="/BYSJadmin/admin/queryInvestmentByiid?iid=${invementinfo.investmentId}">修改</a>
		 
	  </td>
	  
	 </tr>
	
		</c:forEach>
			
		
		</div>	
		
			
			
			<!-- 我的标签 -->
			<td colspan="8" align="center">
			 <div>
      	<c:choose>
 
      	<c:when test="${pb.pageNo == 1}">
      		首页&nbsp;
    		上一页&nbsp;
      	</c:when>
      	<c:otherwise>
      		<a href="/BYSJadmin/admin/queryInvermentInfos?pageNo=1">首页</a>&nbsp;
      		<a href="/BYSJadmin/admin/queryInvermentInfos?pageNo=${pb.pageNo-1}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a href="/BYSJadmin/admin/queryInvermentInfos?pageNo=${pb.pageNo+1}">下一页</a>&nbsp;
    			<a href="/BYSJadmin/admin/queryInvermentInfos?pageNo=${pb.totalPage}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    		第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页&nbsp;&nbsp;&nbsp; 
   总数：<font color="red">${inverstmentNumber }</font>
	
    </div>
			
			</td>
			<!-- 我的结束标签 -->
					</tr>
			</table>
	
	</center>

</body>
</html> 
