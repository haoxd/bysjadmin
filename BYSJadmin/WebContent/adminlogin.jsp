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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登陆</title>
<link href="./resouse/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>

    <div id="login">
	
	     <div id="top">
		      <div id="top_left">
			  <img src="./resouse/image/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <form  method="post" name="queryUserLoginSystem"  action="/BYSJadmin/admin/queryAdminLoginSystem" onsubmit="return expertSent()">
		 <div id="center">
		      <div id="center_left"></div>
		      
			  <div id="center_middle">
			 
			       <div id="user">
			     <p align="center"> <span  style="color: #ff0000;font-size: 7px;" id="message"></span></p>   
			   		    用户名
			         <input type="text"  id="adminPhone" name="adminPhone" placeholder="手机号" />
			       </div>
				   <div id="password">密&nbsp;&nbsp;码
				     <input type="password" id="adminPassword" name="adminPassword" placeholder="密码"/>
				   </div>
				   <div id="btn">
				   <table align="center" style="top: 10px" >
				   <tr >
				   <td >&nbsp;&nbsp;&nbsp;&nbsp;<input   style="width: 50px ;   " type="submit" value="登录"></td>
				   <td><input  style="width: 50px;  left: 20px" type="reset" value="重填"></td>
				   </tr>
				   
				    
				   </table>
				        
				   </div>
			
			  </div>
			 
		 </div>
		 </form>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">E(-｡-;)理财家庭理财网管理系统 V1.0</span>
					   <span class="copyright"><a href="/BYSJadmin/info/welcomeadmin.jsp" >申请成为管理员</a></span>
			      </div>
			  </div>
			  <div id="down_center">
			  <p align="center"><font color="red" size="2px">${loginFailInfoMessage }</font></p> 
			  
			  </div>		 
		 </div>

	</div>
<script src="./resouse/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" >
function expertSent() {
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号码正则
    var adminPhone = $("#adminPhone").val();
    var adminPassword = $("#adminPassword").val();
   
 
    if(! isMobile.test(adminPhone)) {
        $("#message").html('请输入正确手机号！');
        $("#adminPhone").addClass("yxj_error");
        $("#adminPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!adminPassword) {
        $("#message").html('请输入您的密码！');
        $("#adminPassword").addClass("yxj_error");
        $("#adminPassword").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
 
}
</script>
</body>
</html>