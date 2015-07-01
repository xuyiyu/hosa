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
<li ><a href="javascript:void(0);">车型中心</a></li>
<li class="navactive"><a href="javascript:void(0);">促销活动</a></li>
<li ><a href="javascript:void(0);">预约试驾</a></li>
<li ><a href="javascript:void(0);">车行助手</a></li>
<div class="clear"></div>
</ul>
</section>


<!--价格分区-->
<section class="paddinfo">
<ul class="cx" item-id="activity-list" >
<li item-template style="display:none;"><img item-id=icon src=""/><div item-id=name>
<p item-id="description"></p></div></li>


</ul>

</section>



<!--小浮层-->
<section class="fuchen hide">
<ul>
<li ><em></em>
<a><img src="${ctx}/web/images/tou.png">咨询顾问</a>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>

<script>
$(function() {

	var loadActivity = function() {
		var categoryId = "${param.categoryId}";
		if(!categoryId) {
			return;
		}
		var param = {};
		param["id"] = categoryId;
		var activityUrl = ctx + "/web/activity/activity!loadActivity.htm";
		$.get(activityUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					var template = $("li[item-template]");
					console.debug(responseData);
					$.each(data, function(i, o) {
						var item = template.clone();
						item.removeAttr("item-template");
						item.find("[item-id=icon]").attr("src", o.beginPicUrl);
						var desc = "活动未开始";
						if(o.beginTimeString) {
							desc = o.beginTimeString + "至" + o.endTimeString;
						}
						item.find("[item-id=name]").html(o.name + "<p>" +desc+ "</p>");
						console.debug(o);
						item.appendTo($("[item-id=activity-list]"));
						item.show();
						item.click(function() {
							if(o.type == 2) {
								location.href = ctx + "/web/saleonline/activity/activity-coupons.jsp?activityId=" + o.id+ "&d=" + d;
							} else if(o.type == 3) {
								location.href = ctx + "/web/saleonline/activity/activity-lottery.jsp?activityId=" + o.id+ "&d=" + d;
							} else if(o.type == 4) {
								location.href = ctx + "/web/saleonline/activity/activity-tuan.jsp?activityId=" + o.id+ "&d=" + d;
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