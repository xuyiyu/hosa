<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>
<%@ page  isELIgnored="false"   %>
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
<li class="navactive"><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>
<section class="mc-by" id="info">
	<h3 class="form-title">预约维修</h3>
	
		<div class="by-custom-name" name="name">姓名：</div>
	<div class="by-custom-name" name="mobile">电话：</div>
	<form>
	<div class="top-block"><input type="text" name="plate" value="" placeholder="请输入您的车牌号"/></div>
	<input type="hidden" name="appointmentTime" value="" placeholder="请输入您的车牌号"/>
	</form>
	<div class="top-block item-title" id="repairHistory">爱车保养历史</div>
	<div class="top-block block-select">预约保养时间<img  src="${ctx}/web/images/mc-zix_condition-selected.png"  class="morered"/></div>
	<table id="time-table" class="selected-list clearFix" cellspacing="3" cellpadding="0" style="">
		<tr>
			<td class="select-item full" name="e1">
				<dt></dt>
				<dd>
					<p class="order-date" >2014-04-22</p>
					<p class="order-status" >预约名额已满</p>
				</dd>
			</td>
			<td class="select-item busy" name="e2">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-23</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
		</tr>
		<tr>
			<td class="select-item normal"  name="e3">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-24</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
			<td class="select-item normal"  name="e4">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-24</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
		</tr>
		<tr>
			<td class="select-item normal"  name="e5">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-24</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
			<td class="select-item normal"  name="e6">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-24</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
		</tr>
		<tr>
			<td class="select-item normal" name="e7">
				<dt></dt>
				<dd>
					<p class="order-date">2014-04-24</p>
					<p class="order-status">可以预约</p>
				</dd>
			</td>
			<td class=" next-week" id="next-week">
				<p class="order-date" >下一个七天</p>
			</td>
		</tr>
	</table>
	<a class='submit-btn' href="javascript:void();" id="save">提交</a>
</section>
<script type="text/javascript">
	$(function(){
	var nexts = 0;
	var form = $("form");
	var loadOrderDaysInfo = function(){
		var param = {};
		param["nexts"] = nexts;
		$.webAjax(ctx+"/web/afterservice/reservation/repair/repair!loadOrderDaysInfo.htm", param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					//$("#time-table").empty();
					
					$("tr .select-item").removeClass("full").removeClass("busy").removeClass("normal").removeClass("activewhite");
					$.each(data,function(i,o){
						
					$("[name=e"+(i+1)+"]").find(".order-date").text(o.appiontment_time);
					if(o.cnt>=8){
						$("[name=e"+(i+1)+"]").find(".order-status").text("预约名额已满");
						$("[name=e"+(i+1)+"]").addClass("full");
					}else if(o.cnt>4){
						$("[name=e"+(i+1)+"]").find(".order-status").text("可以预约");
						$("[name=e"+(i+1)+"]").addClass("busy");
					}else{
						$("[name=e"+(i+1)+"]").find(".order-status").text("可以预约");
						$("[name=e"+(i+1)+"]").addClass("normal");
					}
					
					
					});
					
				}
			}
		});
	}
	
	
	
	var save = function(){
		if(!verifyParam()){
			return ;
		}
		
		$("form").attr("action",ctx + "/web/afterservice/reservation/repair/repair/save.htm").attr("method","post").submit();
		
	}
	
	
	var verifyParam = function(){
		var plate = form.find("[name=plate]").val();
		var appointmentTime = form.find("[name=appointmentTime]").val();
	
		if(!plate){
			myalert("请选择车牌号");
			return false;
		}
		if(!appointmentTime){
			myalert("请选择预约时间");
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
		
	
		
		$("#next-week").click(function(){
			
			form.find("[name=appointmentTime]").val("");
			nexts = nexts+1;
			loadOrderDaysInfo();
		});
		
		$(".select-item").click(function(){
			form.find("[name=appointmentTime]").val($(this).find(".order-date").text());
			$(".select-item").removeClass("activewhite");
			$(this).addClass("activewhite");
		});
		
		$("#save").click(function(){
			save();
		});
		
		
		
	}
	
	
	
	$().ready(function() {
	
		bindingButtonClick();
		loadOrderDaysInfo();
		$("#info").find("[name=name]").text("姓名："+userName);
		$("#info").find("[name=mobile]").text("电话："+userMobile);
		form.find("[name=plate]").val(userPlate);
		
		$("#repairHistory").click(function(){
		
			window.location.href = ctx + "/web/afterservice/reservation/repair-history-list.jsp?d="+d;
		});
		
	});
	
	})
					

</script>
</body>
</html>
