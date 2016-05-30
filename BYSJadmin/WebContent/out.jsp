<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>安全退出</title>
</head>
<body background="./resouse/image/login_l.png">
<% 
session.invalidate();
response.setHeader("refresh", "1;url=adminlogin.jsp");
%>
</body>
</html>