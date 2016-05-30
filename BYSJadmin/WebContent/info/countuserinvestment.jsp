
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投资统计</title>
</head>
<body background="images/back02.jpg">
<form action="/BYSJadmin/admin/queryUserInfosToInvestment" method="get">
		<table align="center">
			<tr align="center">
				<td colspan="2"><h4>输入投资信息</h4></td>
			</tr>
			<tr>
		<td>投资名称：<input type="text" name="investmentName"/>
		<td colspan="2">
		<input type="submit" value="查询" /></td>
			</tr> 		
			
			<tr align="center">
				<td colspan="2"><font color="red"><b>${queryfail }</b></font></td>
			</tr>
		</table>
	</form>
	
</body>
</html>