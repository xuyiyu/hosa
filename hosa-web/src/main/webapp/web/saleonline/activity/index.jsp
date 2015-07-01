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

<body class="mainbg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
<li ><a href="javascript:void(0);">车型中心</a></li>
<li class="navactive"><a href="javascript:void(0);">促销活动</a></li>
<li ><a href="javascript:void(0);">预约试驾</a></li>
<li ><a href="javascript:void(0);">车行助手</a></li>
</ul>
</section>
<section style=" position:relative ">
<a href="javascript:void(0);"><img src="${ctx}/web/images/mc-cxhdflash.jpg" /></a>
<div class="conimg" style="text-align:right; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
</div>
</section>
<section class=" paddinfo">
<ul class="listcon" item-id="category-list">
<li item-template style="display:none;">
<img  src="" class="listimg fl" item-id="icon"/>
<div class="fl confont kuan"><h3 item-id="name"></h3>
<p item-id="description"></p>
</div>
<img src="${ctx}/web/images/more.png"  class="moreimg fr" />
<div class="clear"></div>
</li>
<div class="clear"></div>
</ul>
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

	var loadCategory = function() {
		var categoryUrl = ctx + "/web/activity/activity!loadCategory.htm";
		var param = {};
		param["type"] = 1;
		$.get(categoryUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					var template = $("li[item-template]");
					console.debug(responseData);
					$.each(data, function(i, o) {
						var item = template.clone();
						item.removeAttr("item-template");
						item.find("[item-id=icon]").attr("src", o.iconUrl);
						item.find("[item-id=name]").text(o.name);
						item.find("[item-id=description]").text(o.description);
						item.appendTo($("[item-id=category-list]"));
						item.show();
						
						item.click(function() {
							location.href = ctx + "/web/saleonline/activity/activity-list.jsp?categoryId=" + o.id + "&d=" + d;
						});
					});
				}
			}
		});
	}
 	$().ready(function() {
 		loadCategory();
 	});
})
</script>
</body>
</html>