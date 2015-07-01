<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>
<%@ page  isELIgnored="false"   %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>
<%@ include file="/web/commons/css.jsp"%>
<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/web/css/mc.css">
</head>
<body class=" gray-gradient-bg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>
</div>
</section>
<section>
	<ul class="navli clearFix">
		<li ><a href="javascript:void();">车型中心</a></li>
		<li ><a href="javascript:void();">促销活动</a></li>
		<li class="navactive"><a href="javascript:void();">预约试驾</a></li>
		<li ><a href="javascript:void();">车行助手</a></li>
	</ul>
</section>
<section class="mc-by">
	<h3 class="form-title">预约试驾</h3>
	<input type="hidden" id="userId" value="${sessionScope.webUser.userId}"/>
	<div class="by-custom-name">姓名：${sessionScope.webUser.userName}</div>
	<div class="by-custom-name">电话：${sessionScope.webUser.userMobile}</div>
	 <div style="padding:2.5% ; overflow:hidden;">
    <div class="top-block3 fl"><select id="carSeriesId"></select></div>
    <div class="top-block3 fl"><select id="carId"></select></div>
    </div>
    <div class="top-block "><input type="text" name="testDate" id="testDate"  class="hasDatepicker" placeholder="预订时间"></div>
    
    <div class="clear"></div>
	<a class='submit-btn' href="javascript:void(0);" style="margin-top: 10%;" id="button-submit">下一步</a>
</section>
<div id="in_param">
<input type="hidden" name="ci" value="${param.ci }"/>
<input type="hidden" name="csi" value="${param.csi }"/>
</div>
</body>

<script>
$(function() {

	var loadCarSeries = function() {
		
		var carSeriesUrl = ctx +"/web/commons/web-commons!loadCarSeries.htm";
		$.get(carSeriesUrl, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$("#carSeriesId").empty();
					$("#carSeriesId").append("<option value=''>请选择车系</option>");
					$("#carSeriesId").off("change");
					$.each(data, function(i, o) {
						$("#carSeriesId").append("<option value='"+o.id+"'>"+o.seriesName+"</option>");
					});
					$("#carSeriesId").change( function() {
							loadCar();
						});
					if($("#in_param").find("[name=csi]").val()){
						console.log($("#in_param").find("[name=csi]").val());
						$("#carSeriesId").val($("#in_param").find("[name=csi]").val());
						//$("#in_param").find("[name=csi]").val("");
						$("#carSeriesId").trigger("change");
					}
					
				}
			}
		});
	}

	
	var loadCar = function() {
		var carSeriesId = $("#carSeriesId").val();
		var carUrl = ctx +"/web/commons/web-commons!loadCar.htm";
		var param = {};
		param["carSeriesId"] = carSeriesId;
		$.get(carUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$("#carId").empty();
					$("#carId").append("<option value=''>请选择车型</option>");
					$("#carId").off("change");
					$.each(data, function(i, o) {
						$("#carId").append("<option value='"+o.id+"'>"+o.name+"</option>");
					});
					if($("#in_param").find("[name=ci]").val()){
						$("#carId").val($("#in_param").find("[name=ci]").val());
						$("#in_param").find("[name=ci]").val("");
					}
					
				}
			}
		});
	}
	
	
	
	var save = function() {
		var userId = $("#userId").val();
		
		var carId = $("#carId").val();
		var testDate = $("#testDate").val();
		
		
		var param = {};
		if(userId != "") {
			param["drivesOrder.userId"] = userId;
		}
		
		
		
		
		if($.trim(carId) == "") {
			myalert("请选择您的试驾车型");
			return;
		} else {
			param["drivesOrder.carModelId"] = carId;
		}
		
		if($.trim(testDate) == "") {
			myalert("请选择您的试驾时间");
			return;
		} else {
			param["drivesOrder.appointmentTime"] = testDate;
		}
		
		
		
		var testDriveUrl = ctx +"/web/testdrive/test-drive!save.htm";

		$.post(testDriveUrl, param, function(responseData) {
			console.debug(responseData);
			if(responseData.r_code == 0) {
				location.href= ctx + "/web/saleonline/testdrive/success.jsp?d="+d;
			} else {
				myalert(responseData);
			}
		});
	}
	
 	$().ready(function() {
 		
 		$("#testDate").datetimepicker({
		    format: 'yyyy-mm-dd HH:mm',
		    autoclose: true,
	        todayBtn: true,
	        
		    language: "zh-CN"
		});
		
 		loadCarSeries();
 		
 		
 		
 		
 		$("#button-submit").click(function() {
 			save();
 		});
 		
 	
 	});
})
</script>
</html>
