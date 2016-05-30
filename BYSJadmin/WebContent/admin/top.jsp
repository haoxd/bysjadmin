<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
            <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>顶部jsp</title>

<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>
<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>

<link href="./resouse/image/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="./resouse/image/logo.gif" width="262" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt">管理员：<b><font color="red">${admin.adminName }</font></b> 您好,感谢登录使用！</td>
        
        <td width="22%"><a href="http://localhost:8080/BYSJadmin/out.jsp" target="_blank" ><img src="./resouse/image/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>