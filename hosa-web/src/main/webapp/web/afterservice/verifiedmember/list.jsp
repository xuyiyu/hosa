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
<link rel="stylesheet" type="text/css" href="${ctx}/web/css/mc.css">


</head>
<body class="gray-gradient-bg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>
</div>
</section>
<section>
<ul class="navli">
<li ><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>
<form>
<section class="mc-by">
	<h3 class="form-title">会员认证</h3>
	<input type="hidden" name="openId" value="${param.openId}"/>
	<input type="hidden" name="departmentId" value="${param.d}"/>
	<input type="hidden" name="userId" value="${param.userId}"/>
	<input type="hidden" name="redirect_uri" value="${param.redirect_uri}"/>
	<div class="top-block"><input type="text" name="name" value="" placeholder="姓名：请输入您的真实姓"/></div>
	<div class="top-block"><input type="text" name="mobile" value="" placeholder="手机：请输入您的手机号码"/></div>

    <div style="padding:2.5% ; overflow:hidden;">
    <div class="top-block3 fl"><select name="province"><option>省</option></select></div>
    <div class="top-block3 fl"><select name="areaId"><option>市</option></select></div>
    <div class="top-block3 fl"><select name="carSeriesId"><option>车系</option></select></div>
    <div class="top-block3 fl"><select name="carId"><option>车型</option></select></div>
    <div class="clear"></div>
    </div>
    
    <!-- 
    <div class="top-block fl" style="width:45%;">省<img  src="${ctx}/web/images/mc-zix_condition-selected.png"  class="morered"/></div>
    <div class="top-block fr" style="width:45%;">市<img  src="${ctx}/web/images/mc-zix_condition-selected.png"  class="morered"/></div>
    <div class="top-block fl" style="width:45%;">车系<img  src="${ctx}/web/images/mc-zix_condition-selected.png"  class="morered"/></div>
    <div class="top-block fr" style="width:45%;">车型<img  src="${ctx}/web/images/mc-zix_condition-selected.png"  class="morered"/></div>
     -->
    <div class="clear"></div>
    
	<div class="top-block"><input type="text" name="plate" value="" placeholder="车牌号：请输入您的车牌号"/></div>
    <div class="top-block"><input type="text" name="frameNo" value="" placeholder="车架号：请输入您的车架号"/></div>
	<div style="width: 95%;  margin: 0 auto 4.6%; " class="clearFix">
		<div class="top-block fl" style="width:65%; "><input type="text" name="captcha" value="" placeholder="输入您的验证码"/></div>
		<div id="send-captcha" class="top-block1 fl" style=" margin-top:4.6%;">获取验证码</div>
	</div>
    <div class="clear"></div>
	<a class='submit-btn' href="javascript:void();" id="save" style="margin-top: 10%;">下一步</a>
</section>
</form>


<script type="text/javascript">
	$(function(){
	
	var form = $("form");
	var areaMap = new HashMap();
	var carSeriesMap = new HashMap();
	
	
	var loadAreas  = function(callback){
		$.webAjax(ctx+"/web/afterservice/verifiedmember/baideli/user/web-baideli-user!loadAreas.htm", {}, function(responseData) {
			form.find("[name=province]").empty();
			
			$('<option value="">省</option>').appendTo(form.find("[name=province]"));
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					$.each(data,function(i,o){
						areaMap.put(o.code,o);
						if(o.code.length==6){
					
							var _option = $("<option></option>").attr("value",o.code).text(o.fullName);
								form.find("[name=province]").append(_option);
						}
					});
					
					if($.isFunction(callback)){
						callback();
					}
					form.find("[name=province]").trigger("change");
					
				}
			}
		});
	}
	
	
	
		
	
	
	
	var loadCarSeries  = function(callback){
		$.webAjax(ctx+"/web/commons/web-commons!loadCarSeries.htm", {}, function(responseData) {
			form.find("[name=carSeriesId]").empty();
			$('<option value="">车系</option>').appendTo(form.find("[name=carSeriesId]"));
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					$.each(data,function(i,o){
						carSeriesMap.put(o.id,o);
					
						var _option = $("<option></option>").attr("value",o.id).text(o.seriesName);
							form.find("[name=carSeriesId]").append(_option);
						
					});
					if($.isFunction(callback)){
						callback();
					}
					form.find("[name=carSeriesId]").trigger("change");
				}
			}
		});
	}
	
	
		var loadCar  = function(){
		var param = {};
		param["carSeriesId"] = form.find("[name=carSeriesId]").val();
		$.webAjax(ctx+"/web/commons/web-commons!loadCar.htm", param, function(responseData) {
			form.find("[name=carId]").empty();
			$('<option value="">车型</option>').appendTo(form.find("[name=carId]"));
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					$.each(data,function(i,o){
							var _option = $("<option></option>").attr("value",o.id).text(o.name);
								form.find("[name=carId]").append(_option);
					});
					var carId_temp = form.find("#carId_temp").val()
					if(carId_temp){
						form.find("[name=carId]").val(carId_temp);
					}
				}
			}
		});
	}
	
	var save = function(){
		if(!verifyParam()){
			return ;
		}
		
		$("form").attr("action",ctx + "/web/afterservice/verifiedmember/baideli/user/web-baideli-user!save.htm").submit();
		
	}
	
	
	var verifyParam = function(){
		var name = form.find("[name=name]").val();
		var mobile = form.find("[name=mobile]").val();
		var areaId = form.find("[name=areaId]").val();
		var carId = form.find("[name=carId]").val();
		var plate = form.find("[name=plate]").val();
		var frameNo = form.find("[name=frameNo]").val();
		var captcha = form.find("[name=captcha]").val();
		
		if(!name){
			myalert("请输入名称");
			return false ;
		}
		if(!mobile){
			myalert("请输入手机号");
			return false ;
		}
		/*
		if(!areaId){
			myalert("请选择城市");
			return false;
		}
		if(!carId){
			myalert("请选择车型");
			return false;
		}
		if(!plate){
			myalert("请选择车牌号");
			return false;
		}
		if(!frameNo){
			myalert("请选择车架号");
			return false;
		}*/
		if(!captcha){
			myalert("请输入验证码");
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
						form.find("[name=captcha]").val(data);
						//myalert("验证码已经以短信形式发送至手机");
					
				}
			});
		});
		
		form.find("[name=province]").change(function(){
			form.find("[name=areaId]").empty();
			$('<option value="">市</option>').appendTo(form.find("[name=areaId]"));
			var begin = false;
			var provinceCode = form.find("[name=province]").val();
			console.log("provinceCode:"+provinceCode);
			$.each(areaMap.values(),function(i,o){
						
						if(!begin&&o.code == provinceCode){
							begin = true;
						}else if(begin&&o.code.length==9){
							
							$("<option><option>").attr("value",o.code).text(o.fullName)
								.appendTo(form.find("[name=areaId]"));
						}else if(begin&&o.code.length!=9){
							return false;
						}
			
			});
		});
		
		
		form.find("[name=carSeriesId]").change(function(){
			loadCar();
		});
		
		form.find("#save").click(function(){
			save();
		});
	}
	
	var loadUser = function(){
		var param = {};
		param["id"] = form.find("[name=userId]").val();
		if(!form.find("[name=userId]").val()){
			param["id"] = userId;
			form.find("[name=userId]").val(userId);
		}
	
		$.webAjax(ctx+"/web/afterservice/verifiedmember/baideli/user/web-baideli-user!input.htm", param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					
					form.find("[name=name]").val(data.name);
					form.find("[name=plate]").val(data.plate);
					form.find("[name=frameNo]").val(data.frameNo);
					form.find("[name=carId_temp]").val(data.carId);
					
					var mobileReg = /^[1][358]\d{9}$/; 
					 if(mobileReg.test(data.mobile)){
						form.find("[name=mobile]").val(data.mobile);
					 }
					
					loadAreas(function(){
						if(data.areaId){
							form.find("[name=province]").val(data.areaId.substring(0,6));
							setTimeout(function(){
								form.find("[name=areaId]").val(data.areaId);
							},500);
						}
					
					});
					loadCarSeries(function(){
						if(data.car){
							form.find("[name=carSeriesId]").val(data.car.seriesId);
						}
					});
					var msg = "您当前已是";
					if(data.type==1){
						msg = msg+"标准会员";
					}else if(data.type==2){
						msg = msg+"正式会员";
					}
					myalert(msg);
					
				}
			}
		});
	
	}
	
	
	
	$().ready(function() {
		bindingButtonClick();
		//loadAreas();
	//	loadCarSeries();
		
		loadUser();
	});
	
	})
					

</script>
</body>
</html>