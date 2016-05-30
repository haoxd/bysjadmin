<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E(-｡-;)理财【编辑投资信息】</title>
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
             <h1>编辑${queryInvestment.investmentName}信息：</h1>

        
             <span style="color: #ff0000;font-size: 14px;" id="message"></span>
          </div>
        <form  action="/BYSJadmin/admin/updateInvestmentInfo" method="post" class="yxj_zx02" style="overflow:visible; height:400px;" onsubmit="return expertSent()">
           
             <div class="yxj_zx02L" style="overflow:visible;">
             	 <input type="hidden" name="investmentId" value="${queryInvestment.investmentId}">
             	
                 <h1><p>投资信息名称</p><span> 3大于字数小于8</span></h1>
                  <input type="text" id="investmentName" name="investmentName" placeholder=" ${queryInvestment.investmentName}">
                  <h1><p>周收益</p><span>周收益</span></h1>
                  <input type="text" id="weekEarnings" name="weekEarnings" placeholder="${queryInvestment.weekEarnings}">
                  <h1><p>月收益</p><span>月收益</span></h1>
                  <input type="text" id="monthEarnings" name="monthEarnings" placeholder="${queryInvestment.monthEarnings}">
                  <h1><p>年收益</p><span>年收益</span></h1>
                  <input type="text" id="yearEarnings" name="yearEarnings" placeholder="${queryInvestment.yearEarnings}">
                  
                  
                  
             </div>
             <div class="yxj_zx02R" style="overflow:visible;">
                <h1><p>类型</p><span>投资的类型</span></h1>
                  <input type="text" id="investmentState" name="investmentState" placeholder="${queryInvestment.investmentState}">
                  
				<h1><p>具体投资内容</p><span>账单详情</span></h1>
				<textarea rows="5" cols="19" id="investmentBody" name="investmentBody"  style="resize: none; height:200px; width:320px; font-family:'黑体'; " placeholder="${queryInvestment.investmentBody}" ></textarea>		
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
    var investmentName = $("#investmentName").val();
    var weekEarnings = $("#weekEarnings").val();
    var monthEarnings = $("#monthEarnings").val();
    
    var yearEarnings = $("#yearEarnings").val();
    var investmentState = $("#investmentState").val();
   
    var investmentBody = $("#investmentBody").val();
    var number=/^(0|[1-9]\d*)$/;//判断是否是数字
    if(investmentName.length<3 ) {
        $("#message").html('请输入正确投资名称！');
        $("#investmentName").addClass("yxj_error");
        $("#investmentName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(investmentName.length>8 ) {
        $("#message").html('请输入正确投资名称！');
        $("#investmentName").addClass("yxj_error");
        $("#investmentName").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!weekEarnings) {
        $("#message").html('请输入周收益');
        $("#weekEarnings").addClass("yxj_error");
        $("#weekEarnings").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!monthEarnings) {
        $("#message").html('请输入月收益');
        $("#monthEarnings").addClass("yxj_error");
        $("#monthEarnings").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

    if(!yearEarnings) {
        $("#message").html('请输入年收益');
        $("#yearEarnings").addClass("yxj_error");
        $("#yearEarnings").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
    if(!investmentState) {
        $("#message").html('请输入理财类型');
        $("#investmentState").addClass("yxj_error");
        $("#investmentState").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }
   
    if(!investmentBody) {
        $("#message").html('请输入详细理财内容');
        $("#spendingBillsBody").addClass("yxj_error");
        $("#spendingBillsBody").focus();
        $('html,body').animate({scrollTop:$('#message').offset().top}, 800);
        return false;
    }

  

   
   
 
}
</script>




</body>
</html>