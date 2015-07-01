<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link rel="stylesheet" type="text/css" href="${ctx }/web/css/mc.css">
</head>
<body>
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>
</div>
</section>
<section>
<ul class="navli">
<li class="navactive"><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>
<form>
<section class="mc-by">
	<h3 class="form-title">预约信息</h3>
	<input type="hidden" name="locations" />
	<div class="top-block"><input type="text" name="name" value="" placeholder="姓名：请输入您的真实姓"/></div>
	<div class="top-block"><input type="text" name="mobile" value="" placeholder="手机：请输入您的手机号码"/></div>
	<div class="top-block"><input type="text" name="plate" value="" placeholder="车牌号：请输入您的车牌号"/></div>
	<div style="width: 95%;  margin: 0 auto 4.6%; " class="clearFix">
		<div class="top-block fl" style="width:65%; "><input type="text" value="" name="captcha" placeholder="输入您的验证码"/></div>
		<div id="send-captcha" class="top-block1 fl"  style=" margin-top:4.6%;">获取验证码</div>
	</div>
    
    
    <div class="clear"></div>
	<a id="next" class='submit-btn' href="javascript:void();" style="margin-top: 10%;">下一步</a>
</section>
</form>
<script type="text/javascript">
	$(function(){

	var form = $("form");
	
	
	
	
	
	var save = function(){
		if(!verifyParam()){
			return ;
		}
		
		$("form").attr("action",ctx + "/web/verifybasicinfo.htm").attr("method","post").submit();
		
	}
	
	
	var verifyParam = function(){
		var name = form.find("[name=name]").val();
		var mobile = form.find("[name=mobile]").val();
		var plate = form.find("[name=plate]").val();
		var captcha = form.find("[name=captcha]").val();
		
		if(!name){
			myalert("请输入名称");
			return false ;
		}
		if(!mobile){
			myalert("请输入手机号");
			return false ;
		}
		if(!plate){
			myalert("请选择车牌号");
			return false;
		}
		if(!captcha){
			myalert("请选择验证码");
			return false;
		}
		
		
		return true;
		
		
	}
	
	
	
	
	
	var bindingButtonClick = function(){
		$("#send-captcha").click(function() {
			var mobile = $("form").find("[name=mobile]").val();
			console.log("mobile:"+mobile);
			if(mobile){
				var mobileReg = /^[1][358]\d{9}$/; 
				 
				 if(!mobileReg.test(mobile)){
					myalert("请输入正确的电话号码");
					return;
				 }
			}else{
				myalert("请输入电话号码");
					return;
			}
			
			var param = {};
			param["phone"] = mobile;
			var url = "${ctx}/web/sendcaptcha.htm";
			$.ajax({
				async: false,
				type : "post",
				url  : url,
				data :param,
				success : function(data){
					if(data == "success"){
						myalert("验证码已经以短信形式发送至手机");
					}
				}
			});
		});
		
	
		
		form.find("#next").click(function(){
			save();
		});
	}
	
	
	
	$().ready(function() {
		form.find("[name=locations]").val(window.location.href);
		bindingButtonClick();
		
	});
	
	})
					

</script>
</body>
</html>
