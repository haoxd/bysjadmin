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
<title>所有用户信息</title>
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
<h4>全部用户信息</h4>
	<p style="text-align:left; width:900px; margin:0 auto;">
	男性用户总数：<font color="red">${nanNumber }</font>
	&nbsp;&nbsp;&nbsp;&nbsp;
	女性用户总数：<font color="red">${nvNumber }</font>
	&nbsp;&nbsp;&nbsp;&nbsp;
	周注册用户总数：<font color="red">${weekNumber }</font>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	月注册性用户总数：<font color="red">${MonthNumber }</font>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	导出：<font color="red"><a href="http://localhost:8080/BYSJadmin/admin/download">文档</a></font>
	</p>
		<table border="1" align="center" border:#ee0000 3 ridge >
		
	

		
			
			
		
			
			<tr  bgcolor="orange" >
		
			<!-- 	<th><font color="blue">选择</font></th> -->
			
				<th><font color="blue">姓名</font></th>
				<th><font color="blue">昵称</font></th>
				<th><font color="blue">手机号</font></th>
				<th><font color="blue">性别</font></th>
				<th><font color="blue">年龄</font></th>				
				<th><font color="blue">邮箱</font></th>
				<th><font color="blue">注册时间</font></th>
				<th><font color="blue">登录状态</font></th>
				<th><font color="blue">操作</font></th>
				
			</tr>
	<c:forEach items="${queryUserInfos}" var="userinfo">
	<tr onmouseout="this.style.background='white'" onmouseover="this.style.background='Aquamarine'">

	   
					
	    <td  title="${userinfo.userText }"><p align="center"><font color="red">${userinfo.userName}</font></p></td>
	   <td >${userinfo.userNickName}</td>
	     <td >${userinfo.userPhone}</td>		
		<td >			
	      <c:choose>
		  <c:when test="${'男' eq userinfo.userSex }">

			<ul >
				<li><font color="blue">${userinfo.userSex }</font></li>
			</ul>
		 </c:when>
		 <c:when test="${'女' eq userinfo.userSex}">
			<ul>
			<li><font color="red">${userinfo.userSex}</font></li>							
			</ul>
		</c:when>
	    </c:choose>
	   </td>
	   
	   <td align="center">${userinfo.userAge} </td>
	
	  <td><a style="color: orange; text-decoration:none;" href="http://${userinfo.userEmil}/" target="_blank">${userinfo.userEmil}</a></td>
		
		  <td style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;">${userinfo.userCreateTime}</td>
	 
	  <td >			
	      <c:choose>
		  <c:when test="${'正常' eq userinfo.userState }">

			<p align="center"><font color="blue">${userinfo.userState}</font></p>
		 </c:when>
		 <c:when test="${'不正常' eq userinfo.userState}">
			
			<p align="center"><font color="red">${userinfo.userState}</font></p>							
			
		</c:when>
	    </c:choose>
	   </td>
	   
	  <td >			
	      <c:choose>
		  <c:when test="${'正常' eq userinfo.userState }">

			<p align="center"><a href="http://localhost:8080/BYSJadmin/admin/isUpateUserLoginStateNo?uid=${userinfo.userID}"   onclick="return confirmDel('确定禁止该用户登录吗？');">禁止登陆</a></p>
		 </c:when>
		 <c:when test="${'不正常' eq userinfo.userState}">
			
		 <p align="center"><a href="http://localhost:8080/BYSJadmin/admin/isUpateUserLoginStateYes?uid=${userinfo.userID}"   onclick="return confirmDel('确定取消对该用户的禁止吗？');">取消禁止</a></p>						
			
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
      		<a href="/BYSJadmin/admin/queryUserInfos?pageNo=1">首页</a>&nbsp;
      		<a href="/BYSJadmin/admin/queryUserInfos?pageNo=${pb.pageNo-1}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a href="/BYSJadmin/admin/queryUserInfos?pageNo=${pb.pageNo+1}">下一页</a>&nbsp;
    			<a href="/BYSJadmin/admin/queryUserInfos?pageNo=${pb.totalPage}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    		第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页&nbsp;&nbsp;&nbsp;
    用户总数：<font color="red">${countNumber }</font>
    </div>
			
			</td>
			<!-- 我的结束标签 -->
					</tr>
			
		</table>
		
	
	</center>

</body>
</html> 
