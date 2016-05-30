<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E(-｡-;)理财【申请管理员】</title>
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
            $(".dropselectbox h4").css("width","450px");
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
</script>
<style>
    body{font-family: "PingFangSC-Medium", "STHeitiSC-Light","微软雅黑", SimHei, sans-serif; -webkit-font-smoothing:antialiased;}
    .dropdown,.dropselectbox,.dropdown ul li{width:450px;}
    .dropdown h4{background-position:320px center; text-align:left; text-indent:10px; font-size:14px; color:#c4c4c4;}
    .dropdown ul li{text-align:left; text-indent:10px;font-size:14px; color:#c4c4c4;}
    .dropdown ul li:first-child{background-position:320px center;}
</style>
</head>
<body >
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


<!--内容开始-->
<div class="yxj_main2">
 <div class="boxcenter" >
     <div style="height:400px; width:615px; background:#fff; margin:39px auto;">
	          <div class="yxj_yjfk">
                 <div class="yxj_line3" style="background:#fac53b;"></div>
                  <div class="yxj_zx01">
					<h1>我要成为管理员</h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<h2>${addsuccess }</h2>					
				  </div>
				 
				<p align="center">  <span style="color: #ff0000;font-size: 14px; " id="message" ></span></p>
                  <div class="signup_check">
                  <form action="/BYSJadmin/admin/addAdmin" method="post"   onsubmit="return expertSent()"> 
                     <table class="signup_check2">
              
                    
                      
                     
                        <tr>
                          <td>姓名</td>
                          <td><input id="adminName" type="text" name="adminName"  /></td>
                       </tr>
                       <tr>
                          <td>手机号</td>
                          <td><input id="adminPhone" type="text" name="adminPhone"  /></td>
                       </tr> 
                       <tr>
                          <td>个人简介</td>
                          <td><textarea  id="text" rows="5" cols="19" name="adminText" style="resize: none;"></textarea></td>
                       </tr>              
                       <tr>
                          <td></td>
                          <td align="right">                          
                          <input type="submit" value="确定" class="yxj_yjtj"/>
                          <input  type="reset" value="重置" class="yxj_yjqx"/>
                          </td>
                       </tr>
                       <tr align="center">
				
						</tr>
                     </table>
                    	</form>
                  </div>
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
    var text = $("#text").val();
    
    if( !adminName) {
        $("#message").html('请输入管理员姓名');
        $("#adminName").addClass("yxj_error");
        $("#adminName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if( !adminPhone) {
        $("#message").html('请输入手机号');
        $("#adminPhone").addClass("yxj_error");
        $("#adminPhone").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if( !text) {
        $("#message").html('请输入你的自我简介');
        $("#text").addClass("yxj_error");
        $("#text").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    
}
</script>




</body>
</html>