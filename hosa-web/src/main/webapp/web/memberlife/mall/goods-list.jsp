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
<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li class="navactive"><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>


<!--价格分区-->


<div item-id="activity-list">
<section item-template style="display:none; position:relative; margin-bottom:3%;">
<img item-id=icon src="${ctx}/web/images/mc-cxhdflash.jpg">
<div class="conimg" item-id=name>
奔驰S600l<span  style="margin-left:50%;">60-80-120.50万</span>
</div>
</section>

</div>


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

	var loadGoods = function() {
		var categoryId = "${param.categoryId}";
		if(!categoryId) {
			return;
		}
		var param = {};
		param["id"] = categoryId;
		var goodsUrl = ctx + "/web/mall/mall!loadGoods.htm";
		$.get(goodsUrl, param, function(responseData) {

			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					var template = $("section[item-template]");
					console.debug(responseData);
					$.each(data, function(i, o) {
						var item = template.clone();
						item.removeAttr("item-template");
						item.find("[item-id=icon]").attr("src", o.picUrl);
						var desc = "活动未开始";
						if(o.beginTimeString) {
							desc = o.beginTimeString + "至" + o.endTimeString;
						}
						item.find("[item-id=name]").html(o.name);// + "<span  style=\"margin-left:50%;\">" +desc+ "</span>"
						
						item.appendTo($("[item-id=activity-list]"));
						item.show();
						item.click(function() {
							location.href = ctx + "/web/memberlife/mall/goods.jsp?goodsId=" + o.id+ "&d=" + d;
						});
						
					});
				}
			}
		});
	}
 	$().ready(function() {
 		loadGoods();
 	});
})
</script>
</body>
</html>