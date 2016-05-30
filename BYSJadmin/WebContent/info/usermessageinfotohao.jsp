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
<title>所有好评反馈意见信息</title>
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
<h4>全部好评信息</h4>
<h5 style="color: orange;">${delsuccess }</h5>	
		<table border="1" align="center" border:#ee0000 3 ridge >
		
	

		
			
			
		
			
			<tr  bgcolor="orange" >
		
			<!-- 	<th><font color="blue">选择</font></th> -->
			
				<th><font color="blue">姓名</font></th>
				<th><font color="blue">手机号</font></th>
				<th><font color="blue">反馈等级</font></th>						
				<th><font color="blue">反馈内容</font></th>
				<th><font color="blue">反馈时间</font></th>
					<th><font color="blue">操作</font></th>
			</tr>
	<c:forEach items="${queryMessgaeInfos}" var="MessgaeInfos">
	<tr onmouseout="this.style.background='white'" onmouseover="this.style.background='Aquamarine'">

	   
					
	    <td  ><p align="center"><font color="red">${MessgaeInfos.userMessageBackName}</font></p></td>
	   <td >${MessgaeInfos.userMessageBackPhone}</td>
	   <td >			
	      <c:choose>
		  
		<c:when test="${'好评' eq MessgaeInfos.userMessageIdear}">
			<ul>
			<li  ><p align="center"><font color="orange">${MessgaeInfos.userMessageIdear}</font></p></li>							
			</ul>
		</c:when>
		
	    </c:choose>
	   </td>
	   <td align="left">${MessgaeInfos.userMessageBackText} </td>
	
	  <td style="overflow:hidden; text-overflow: ellipsis;white-space: nowrap;width:8em;">${MessgaeInfos.userMessageTime}</td>
	   <td align="center">
	 <a href=" http://localhost:8080/BYSJadmin/admin/deleateUserMessageByUmid?umid=${MessgaeInfos.userMessageBackId } " style="color: orange; text-decoration:none;"
					  onclick="return confirmDel('确定删除这条反馈意见吗？');">删除
					</a>
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
      		<a href="/BYSJadmin/admin/queryUserMessageBackInfoHao?pageNo=1">首页</a>&nbsp;
      		<a href="/BYSJadmin/admin/queryUserMessageBackInfoHao?pageNo=${pb.pageNo-1}">上一页</a>&nbsp;
      	</c:otherwise>
      </c:choose>
    	
    	<c:choose>
    		<c:when test="${pb.pageNo == pb.totalPage}">
    			下一页&nbsp;
    			尾页&nbsp;
    		</c:when>
    		<c:otherwise>
    			<a href="/BYSJadmin/admin/queryUserMessageBackInfoHao?pageNo=${pb.pageNo+1}">下一页</a>&nbsp;
    			<a href="/BYSJadmin/admin/queryUserMessageBackInfoHao?pageNo=${pb.totalPage}">尾页</a>&nbsp;
    		</c:otherwise>
    	</c:choose>
    		第${pb.pageNo}页&nbsp;&nbsp;&nbsp; 共${pb.totalPage }页&nbsp;&nbsp;&nbsp;
    总数：<font color="red">${userMessageNumber }</font>
    </div>
			
			</td>
			<!-- 我的结束标签 -->
					</tr>
			
		</table>
		
	
	</center>

</body>
</html> 
