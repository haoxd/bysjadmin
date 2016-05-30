<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E(-｡-;)理财【管理员信息】</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="../resouse/css/usermymessage.css">
    <script type="text/javascript" src="../resouse/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="../resouse/js/jquery.ui.select.js"></script>
   
    <script language="javascript">
        $(document).ready(function(){
            $("#zhuanye").sSelect();
            $("#lingyu").sSelect();
            $(".dropselectbox h4").css("width","340px");
            $(".dropselectbox ul").css("width","338px");
        });
        //选择select的值
        function selectMe(_select){
            //选中的值为
            //alert("选中的值为::" + _select[_select.selectedIndex].value);
        }
    </script>
    <style type="text/css">
        /* 大屏幕 */
        @media (min-width: 1500px) {
            .boxcenter{width:1460px; margin:22px auto;}
            .yxj_con1,.yxj_con2,.yxj_con3{width:400px;}
            .yxj_ul2 li{width:60px; height:128px;float:left; text-align:center; margin-left:4%; margin-right:4%;}
            .yxj_cen{max-width: 1460px;min-width: 1280px;}
        }
        @media (min-width: 1280px) and (max-width:1499px) {
            .boxcenter{width:97%;max-width:1460px; min-width:960px;}
            .yxj_con1,.yxj_con2,.yxj_con3{width:27%; max-width:410px; min-width:310px;}
            .yxj_cen{max-width: 1460px;min-width: 1250px;}
        }
        @media (max-width: 1280px) {
            .yxj_nav2{display:block;}
            .yxj_cd{display:none;}
        }
        @media (min-width: 1000px) and (max-width:1279px) {
            .boxcenter{max-width:1080px; margin:22px auto;}
            .yxj_word{margin-right:2%}
            .yxj_cen{max-width:1280px;}
            .yxj_list22{border-bottom: 1px solid #f2f2f2;padding-bottom: 10px;}
            .yxj_ul2 li{width:60px; height:128px;float:left; text-align:center; margin-left:3.6%; margin-right:3.6%;}
        }
        /* 横向放置的手机和竖向放置的平板之间的分辨率 */
        @media (max-width: 999px) {
            .boxcenter{width:960px; margin:20px auto;}
            .yxj_word{margin-right:14px}
            .yxj_line33{display:block;}
            .yxj_cen{width:960px;}
        }

.yxj_zx01{}
.yxj_zx01 a.bklj_a{float:right;font-size:18px;color:#FFC107;}

</style>

<script type="text/javascript">
    $(document).ready(function(e) {
        $(".yxj_nav2").hover(function(){
            $(".yxj_nav2 dd").toggle();
        })

        $(".yxj_box01 ul,.yxj_box01 li").css("width","100%");

    });
</script><style>
    body{font-family: "PingFangSC-Medium", "STHeitiSC-Light","微软雅黑", SimHei, sans-serif; -webkit-font-smoothing:antialiased;}
    .dropdown,.dropselectbox,.dropdown ul li{width:340px;}
    .dropdown h4{background-position:320px center; text-align:left; text-indent:10px; font-size:14px; color:#c4c4c4;}
    .dropdown ul li{text-align:left; text-indent:10px;font-size:14px; color:#c4c4c4;}
    .dropdown ul li:first-child{background-position:320px center;}
</style>
</head>
<body onload="register.init()">
<!--导航开始-->


<script type="text/javascript">
    
	var path = "";
	var userName = "";
    $(".yxj_nav2").hover(function(){
        $(".yxj_nav2 dd").toggle();
    })
</script>
<style>
    .yxj_admin h1 {
        font-size: 13px;
        cursor: pointer;
        font-weight: bold;
    }
    .yxj_admin h1:hover {
        color: #FFC107;
    }
</style>

<!--导航结束-->

<!--导航结束-->

<!--内容开始-->
<div class="yxj_main2">
 <div class="boxcenter" style="overflow:visible;">
    <div class="yxj_zhuce" style="overflow:visible;">
     
       <div class="yxj_zc_con" style="overflow:visible;height: 450px;">
          <div class="yxj_line3" style="background: rgb(250, 197, 59);"></div>
          <div class="yxj_zx01">
             <h1>管理员<font color="red">${admin.adminName}</font>信息：</h1>

        
             <span style="color: #ff0000;font-size: 14px;" id="message"></span>
          </div>
        <form  action="/BYSJadmin/admin/updateAdminInfo" method="post" class="yxj_zx02" style="overflow:visible; height:400px;" onsubmit="return expertSent()">
           
             <div class="yxj_zx02L" style="overflow:visible;">
             	 <input type="hidden" name="adminID" value="${admin.adminID}">
             	
                 <h1><p>姓名</p><span> 3大于字数小于8</span></h1>
                  <input type="text" id="adminName" name="adminName" placeholder=" ${admin.adminName}">
                  <h1><p>手机号</p><span>手机号</span></h1>
                  <input type="text" id="adminPhone" name="adminPhone" placeholder="${admin.adminPhone}">
                  <h1><p>注册时间</p><span>注册时间</span></h1>
                  <input type="text" id="monthEarnings" name="adminCreateTime"  disabled="true" value="${admin.adminCreateTime}">
                  <h1><p>最后修改时间</p><span>最后修改时间</span></h1>
                  <input type="text" id="yearEarnings" disabled="true" name="adminChangeTime" value="${admin.adminChangeTime}">
                  
                  
                  
             </div>
             <div class="yxj_zx02R" style="overflow:visible;">
               
				<h1><p>我的简介</p><span>我的简介</span></h1>
				<textarea rows="5" cols="19" id="adminText" name="adminText"  style="resize: none; height:200px; width:320px; font-family:'黑体'; " placeholder="${admin.adminText}" ></textarea>		
                <div class="yxj_ty" style="margin-top:20px;">
                    <input  id="expertRegisterBtn" type="submit" value="保存信息" class="yxj_yhzc" style="width: 340px; cursor: pointer; background: #fd8238;">
                </div>
             </div>
          </form>
       </div>   
    </div>
  </div>
</div>
<!--内容结束-->


<!-- 底部信息 -->


<script type="text/javascript" >
function expertSent() {
    var adminName = $("#adminName").val();
    var adminPhone = $("#adminPhone").val();
    var adminText = $("#adminText").val();
    var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号码正则
    if(adminName.length<2 ) {
        $("#message").html('请输入您的名字');
        $("#adminName").addClass("yxj_error");
        $("#adminName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(adminName.length>4 ) {
        $("#adminName").html('请输入您的名字！');
        $("#adminName").addClass("yxj_error");
        $("#adminName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

    if(! isMobile.test(adminPhone)) {
        $("#message").html('请输入正确手机号！');
        $("#adminPhone").addClass("yxj_error");
        $("#adminPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
   
    if(!adminText) {
        $("#message").html('请输入详细个人简介');
        $("#adminText").addClass("yxj_error");
        $("#adminText").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

  

   
   
 
}
</script>




</body>
</html>