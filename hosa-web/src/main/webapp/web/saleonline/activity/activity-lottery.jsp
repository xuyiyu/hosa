<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/web/commons/taglibs.jsp"%>


<!DOCTYPE HTML>
<html>
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
<style>
.ggkDiv {
	width:320px;
	height:160px;
	background-image:url(${ctx}/web/images/ggk.png);
	background-size:100% auto;
	margin:0 auto;
}
.ggkText {
	font-size:24px;
	text-align:left;
	padding:108px 0 0 120px;
	text-shadow:0px 1px 0px rgba(255,255,255,0.4);
}
</style>
</head>

<body class="mainbg">

<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>
</section>
<section>
<ul class="navli clearFix">
<li ><a href="javascript:void(0);">车型中心</a></li>
<li class="navactive"><a href="javascript:void(0);">促销活动</a></li>
<li ><a href="javascript:void(0);">预约试驾</a></li>
<li ><a href="javascript:void(0);">车行助手</a></li>
</ul>
</section>
<section class="paddinfo">
<img src="" item-id="pic">
<div class="titlebold" item-id="name"></div>
<div class="top-block block-select" ><label item-id="endTime"></label><span class="righttext" item-id="number"></span></div>
<div class="top-block block-select" style="display:none;"><label item-id="coupon-name"></label></div>
<div class="clear" style="margin-bottom:5%;"></div>
<div id="lottery-result" class="ggkDiv" style="display:none;">
    <div class="ggkText"><div id="result-info" style="position:absolute;background-color: transparent; height: 40px; width: 130px; font-size: 12px;"></div>
        <canvas id="canvas-lottery-result" style="position:absolute;background-color: transparent; height: 40px; width: 130px;"></canvas>
        <canvas id="canvas-blocking-layer"  style="position:absolute;background-color: transparent; height: 40px; width: 130px; z-index:2"></canvas>
    </div>
</div>

<p class="contenttext">奖品描述：</p>
<div item-id="prize-list">

</div>
</section>
<section class="submittwobtn">
<input   type="hidden"   value="false"  id="server"/>  
	<a href="javascript:void(0);" class="ok-submit fl" item-id="button-join">参加活动</a><a href="javascript:void(0);" class="gray-submit fl">分享朋友圈</a>
    <div class="clear"></div>
</section>




<!--小浮层-->
<section class="fuchen ">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
<script>

$(function() {
	var loadActivity = function() {
		var activityId = "${param.activityId}";
		if(!activityId) {
			return;
		}
		var param = {};
		param["id"] = activityId;
		var activityUrl = ctx + "/web/activity/activity!input.htm";
		$.get(activityUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$("[item-id=pic]").attr("src", data.beginPicUrl);
					$("[item-id=name]").text(data.name);
					$("[item-id=endTime]").text(data.endTime?data.endTimeString+"结束":"活动未开始");
					$("[item-id=number]").text("已有"+data.collectNumber+"人参加");
					if(data.coupon) {
						$("[item-id=coupon-name]").text(data.coupon.name);
					}
					$("[item-id=descritpion]").html(data.beginDescription);
					

			 		$("[item-id=button-join]").click(function() {
			 			var param = {};
			 			param["id"] = "${param.activityId}";
			 			var activityJoinUrl = ctx + "/web/activity/activity!join.htm";
			 			$.get(activityJoinUrl, param, function(responseData) {
			 				console.debug(responseData);
			 				if(responseData.r_code == 0) {
			 					$("#lottery-result").show();
			 					var rd = responseData.r_data;
			 					setTimeout(function() {
									loadBlockingLayer(rd);
								})
								
			 				} else {
			 					location.href = ctx + "/web/saleonline/activity/activity-result.jsp?error=" + responseData.r_info + "&d=" + d;
			 				}
			 				
			 			});
			 			
			 			
			 		});
			 		
			 		//$("[item-id=button-join]").trigger("click");
				}
			}
		});
	}
	
	var loadActivityPrize = function() {
		var activityId = "${param.activityId}";
		if(!activityId) {
			return;
		}
		var param = {};
		param["id"] = activityId;
		var activityUrl = ctx + "/web/activity/activity!loadActivityPrize.htm";
		$.get(activityUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					console.debug(data);
					$("[item-id=prize-list]").empty();
					$.each(data, function(i, o) {
						$("[item-id=prize-list]").append("<p class=\"contenttext\"> "+o.level+"等奖："+o.prize+"，数量"+o.number+"</p>");
					});
				}
			}
		});
	}
	
	

	var loadReuslt = function(data) {
		var resultCanvas = $("#canvas-lottery-result")[0];
		var resultContext = resultCanvas.getContext("2d");  
		resultContext.font = "20pt SimSun,arial,sans-serif";
		resultContext.fillStyle = "#333";
		
		var resultInfo = "很遗憾！您没中奖。";
		
		if(data && data.activityPrize && data.activityPrize.status == 2) {
			resultInfo = "恭喜您，获得" + data.activityPrize.level + "等奖，奖品：" + data.activityPrize.prize + "。";
		}
		
		$("#result-info").text(resultInfo);
		//wrapText(resultContext, resultInfo, 5, 30, 280, 35);
	}
	
	var loadBlockingLayer = function(data) {
		var width = 130;
		var height = 50;    
		var blockingLayerCanvas = $("#canvas-blocking-layer").get(0);
		blockingLayerCanvas.width=width;             
		blockingLayerCanvas.height=height;    
		
		var blockingLayerContext = blockingLayerCanvas.getContext("2d");  
		
		setTimeout(function() {
			var blockingLayerContext = blockingLayerCanvas.getContext("2d");  
			blockingLayerContext.fillStyle = "gray";  			
			blockingLayerContext.fillRect(0, 0, width, height); 
			blockingLayerContext.globalCompositeOperation="destination-out";
			
			setTimeout(function() {
				loadReuslt(data);
			});
		});
		

		

		$("#canvas-blocking-layer").mousemove(function(e){
			var offset = $("#canvas-blocking-layer").offset();
			clearBlockingLayer(e, offset);
		});

		//兼容老版本
		blockingLayerCanvas.addEventListener("touchmove", function(e){
			var touch = e.targetTouches[0];
			var offset = $(this).offset();
			clearBlockingLayer(touch, offset)
			});    

		var clearBlockingLayer = function(e, offset) {
				//console.log("page:" + e.pageX + ", " + e.pageY);
				//console.log(offset.left + ", " + offset.top);
			  blockingLayerContext.beginPath();
			  //blockingLayerContext.fillStyle="red";
			  var clearX = e.pageX*1 - offset.left*1;
			  var clearY = e.pageY*1 - offset.top*1;
			  blockingLayerContext.arc(clearX, clearY, 10, 0, 2*Math.PI);
			  blockingLayerContext.fill();
			 
		}
	}
	
	var wrapText = function(context, text, x, y, maxWidth, lineHeight) {
	    var words = text;
	    var line = '';

	    for(var n = 0; n < words.length; n++) {
	      var testLine = line + words[n];
	      
	      var metrics = context.measureText(testLine);
	      var testWidth = metrics.width;
	      if (testWidth > maxWidth && n > 0) {
	    	  context.fillText(line, x, y);
	        line = words[n]; 
	        y += lineHeight;
	      }
	      else {
	        line = testLine;
	      }
	      
	    }console.log(line);
	    context.fillText(line, x, y);
	  }
	
	
	var lottery = function() {

		if($("#server").val() != "false") {
				return ;
			}
		$("#server").val(true);
		
		
		var url = "${ctx}/web/scratch-card/lottery.htm";
		var param = {};
		param["mobile"] = mobileVal;
		param["activityId"] = $.trim($("#activityId").val());
		$.post(url, param,
				  function(responseData){
			
				if(responseData.r_code == 0) {
					$("#lottery-form").hide();
					$("#lottery-result").show();
					//loadReuslt(responseData.r_data);
					setTimeout(function() {
						loadBlockingLayer(responseData.r_data);
					})
				} else {
					$("#activity-description p.red").empty();
					$("#activity-description p.red").text(responseData.r_info);
				}
			
				  });
		
	}
 	$().ready(function() {
 		
 		loadActivity();
 		loadActivityPrize();
 	});
})
</script>
</body>
</html>