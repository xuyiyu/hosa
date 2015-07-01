<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/web/commons/taglibs.jsp"%>


<!DOCTYPE HTML>
<html>
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>

<body class="mainbg" >
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
<li class="navactive"><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>

<section class="paddinfo">
<img src="" item-id="pic">
<div class="titlebold" item-id="name"></div>
<div class="top-block block-select" ><label item-id="endTime"></label><span class="righttext" item-id="number"></span></div>
<div class="top-block block-select"><label item-id="coupon-name"></label></div>
<div class="clear" style="margin-bottom:5%;"></div>
<div item-id="descritpion">
</div>
</section>
<section class="submittwobtn">
	<a href="javascript:void(0);" class="ok-submit fl" item-id="button-join">参加活动</a><a href="javascript:void(0);" class="gray-submit fl">分享朋友圈</a>
    <div class="clear"></div>
</section>
<!--价格分区-->


<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<a><img src="${ctx}/web/images/tou.png">咨询顾问</a>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png">电话咨询</a>
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
			 					var rd = responseData.r_data;
			 					location.href = ctx + "/web/afterservice/activity/activity-result.jsp?activity=" + data.name + "&d=" + d;
			 				} else {
			 					location.href = ctx + "/web/afterservice/activity/activity-result.jsp?error=" + responseData.r_info + "&d=" + d;
			 				}
			 				
			 			});
			 		});
				}
			}
		});
	}
	
 	$().ready(function() {
 		loadActivity();
 		
 	});
})
</script>
</body>
</html>