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
<li ><a href="javascript:void(0);">售后预约</a></li>
<li class="navactive"><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>
<section class="mc-by" id="info">
	<h3 class="form-title">24小时救援</h3>
	
	<div class="by-custom-name" name="name">姓名：</div>
	<div class="by-custom-name" name="mobile">电话：</div>
	<form>
	<div class="top-block"><input type="text" name="plate" value="" placeholder="请输入您的车牌号"/></div>
	<div class="top-block"><input type="text" name="location" value="" placeholder="请获取当前地理位置"/></div>
	<div class="top-block1" style=" margin-top:4.6%;" id="showLocation">获取地理位置</div>
    <div class="top-block"><textarea style="border:none" name="accidentDescription" placeholder="事故描述"></textarea></div>
    
    <div class="clear"></div>
    </form>
</section>
<section class="submittwobtn">
	<a href="tel:010-58739000" class="ok-submitsos fl">SOS</a><a id="save" href="javascript:void();" class="gray-submit fl">提交</a>
    <div class="clear"></div>
</section>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=32b9e0d16e082ac8ef3c3be6846f4fa3"></script>
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript">
	$(function(){
	var form = $("form");
	
	var save = function(){
		if(!verifyParam()){
			return ;
		}
		$("form").attr("action",ctx + "/web/afterservice/rescue/rescue/rescue/save.htm").attr("method","post").submit();
		
	}
	var verifyParam = function(){
		var plate = form.find("[name=plate]").val();
		var locations = form.find("[name=location]").val();
		if(!plate){
			myalert("请选择车牌号");
			return false;
		}
		if(!locations){
			myalert("请输入事故地点");
			return false;
		}
		return true;
	}
	
	
	
	
	
	var bindingButtonClick = function(){
		$("#save").click(function(){
			save();
		});
	}
	
	function getLocation() {
		  if (navigator.geolocation)
		    {
		    navigator.geolocation.getCurrentPosition(showPosition);
		    }
		  else{x.innerHTML="Geolocation is not supported by this browser.";}
  }
  
  function showPosition(position) {
	x = position.coords.latitude;
	y = position.coords.longitude;
	
	
	
	var gpsPoint = new BMap.Point(y, x);

	BMap.Convertor.translate(gpsPoint,0,translateCallback);
	
	
}

function translateCallback (point){
	var lat = point.lat;
	var lng = point.lng;
	
	var gc = new BMap.Geocoder(); 
	gc.getLocation(point, function(rs){
        var addComp = rs.addressComponents;
       var textfield5 =  document.getElementById("accidentLocation");
	   console.log(addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
      form.find('[name=location]').val(addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
       // myalert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
    }); 
	
}
	
	$().ready(function() {
	
		bindingButtonClick();
		
		form.find("[name=plate]").val(userPlate);
		$("#info").find("[name=name]").text("姓名："+userName);
		$("#info").find("[name=mobile]").text("电话："+userMobile);
		$("#showLocation").click(function(){
			getLocation();
		});
		
	});
	
	})
					

</script>
</body>
</html>
