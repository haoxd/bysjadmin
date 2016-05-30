<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
              <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>左边菜单</title>

<script src="./resouse/js/prototype.lite.js" type="text/javascript"></script>
<script src="./resouse/js/moo.fx.js" type="text/javascript"></script>
<script src="./resouse/js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(./resouse/image/menu_bgS.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	height: 26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(./resouse/image/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(./resouse/image/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(./resouse/image/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(./resouse/image/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>
<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a >E理财用户管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="./resouse/image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/BYSJadmin/admin/queryUserInfos" target="right">用户信息</a></li>
        
         
          
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">E理财理财信息管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="./resouse/image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/BYSJadmin/admin/queryInvermentInfos" target="right">理财信息</a></li>
          <li><a href="/BYSJadmin/info/addinvement.jsp" target="right">新增理财信息</a></li>
         
        </ul>
      </div>
      <h1 class="type"><a>反馈意见管理模块</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="./resouse/image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="/BYSJadmin/admin/queryUserMessageBackInfo" target="right">反馈意见信息</a></li>
          <li><a href="/BYSJadmin/admin/queryUserMessageBackInfoHao" target="right" >好评意见</a></li>
          <li><a href="/BYSJadmin/admin/queryUserMessageBackInfocha" target="right">差评意见</a></li>
          <li><a href="/BYSJadmin/admin/queryUserMessageBackInfoyiban" target="right">一般意见</a></li>
         
        </ul>
      </div>
     <h1 class="type"><a>统计模块</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="./resouse/image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="/BYSJadmin/info/countuserinvestment.jsp" target="right">理财统计</a></li>
         
         
        </ul>
      </div>
       <h1 class="type"><a>管理员个人信息管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="./resouse/image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="/BYSJadmin/admin/queryAdminInfo?id=${admin.adminID}" target="right">个人信息</a></li>
		   <li><a href="/BYSJadmin/info/updatemypassword.jsp" target="right">修改密码</a></li>
         
         
        </ul>
      </div>
        <c:choose>
		  <c:when test="${'郝旭东' eq admin.adminName  }">

			<h1 class="type"><a href="/BYSJadmin/admin/queryListToAdminInfo"target="right" >申请信息</a></h1>
		 </c:when>
	    </c:choose>
      
       <h1 class="type"><a href="http://localhost:8080/BYSJ/userlogin.jsp" target="_blank">用户端入口</a></h1>
        
      
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>