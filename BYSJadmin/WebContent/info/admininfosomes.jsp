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
<title>所有申请信息</title>
<script>

function confirmDel(str){ 
	return confirm(str);
}
</script>
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
<h4>全部申请信息</h4>
	
		<table border="1" align="center" border:#ee0000 3 ridge >
		
	

		
			
			
		
			
			<tr  bgcolor="orange" >
		
			
				<th><font color="blue">姓名</font></th>		
				<th><font color="blue">手机号</font></th>
				<th><font color="blue">申请时间</font></th>			
				<th><font color="blue">介绍</font></th>
				<th><font color="blue">状态</font></th>
				<th><font color="blue">操作</font></th>
				
			</tr>
	<c:forEach items="${queryAdminInfos}" var="admininfo" begin="0">
	<tr onmouseout="this.style.background='white'" onmouseover="this.style.background='Aquamarine'">

	   
					
	    <td ><p align="center"><font color="red">${admininfo.adminName}</font></p></td>
	 
	     <td >${admininfo.adminPhone}</td>		
	     
		  <td style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;">${admininfo.adminCreateTime}</td>
	  <td >${admininfo.adminText}</td>	
	  <td >			
	      <c:choose>
		  <c:when test="${'YES' eq admininfo.adminState }">

			<p align="center"><font color="blue">${admininfo.adminState}</font></p>
		 </c:when>
		 <c:when test="${'NO' eq admininfo.adminState}">
			
			<p align="center"><font color="red">${admininfo.adminState}</font></p>							
			
		</c:when>
	    </c:choose>
	   </td>
	   
	  <td >			
	      <c:choose>
		  <c:when test="${'YES' eq admininfo.adminState}">

			<p align="center"><a href="/BYSJadmin/admin/isUpdateAdminState?adminid=${admininfo.adminID}&&adminstate=NO"   onclick="return confirmDel('确定禁止吗？');">禁止</a></p>
		 </c:when>
		 <c:when test="${'NO' eq admininfo.adminState}">
			
		 <p align="center"><a href="/BYSJadmin/admin/isUpdateAdminState?adminid=${admininfo.adminID}&&adminstate=YES"   onclick="return confirmDel('确定通过吗？');">通过</a></p>						
			
		</c:when>
	    </c:choose>
	   </td>
	 </tr>
		</c:forEach>
			
		
			<tr align="right">
				
			
			<!-- 我的标签 -->
			<td colspan="9" align="center">
			 <div>
      	<c:choose>
 
      	<c:when test="${pb.pageNo == 1}">
      		首页&nbsp;
    		上一页&nbsp;
      	</c:when>
      	<c:otherwise>
      		<a href="/BYSJadmin/admin/queryListToAdminInfo?pageNo=1">首页</a>&nbsp;
      		<a href="/BYSJadmin/admin/queryListToAdminInfo?pageNo=${pb.pageNo-1}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a href="/BYSJadmin/admin/queryListToAdminInfo?pageNo=${pb.pageNo+1}">下一页</a>&nbsp;
    			<a href="/BYSJadmin/admin/queryListToAdminInfo?pageNo=${pb.totalPage}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    		第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页&nbsp;&nbsp;&nbsp;
   
    </div>
			
			</td>
			<!-- 我的结束标签 -->
					</tr>
			
		</table>
		
	
	</center>

</body>
</html> 
