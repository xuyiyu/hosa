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

<body class="gray-gradient-bg">
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
<section style=" position:relative ">
<a href=""><img src="${ctx}/web/images/mc-cxhdflash.jpg" /></a>
<div class="conimg" style="text-align:right; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
</div>
</section>

	<section class="paddinfo">
		<div class="jphnew" item-template>
			<a href=""><img src="" item-id="pic"></a>
			<div class="conimg" style="text-align:center;" item-id="name"></div>
		</div>
	</section>


	

<!--小浮层-->
<section class="fuchen hide">
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
		var categoryUrl = ctx + "/web/mall/mall!loadCategory.htm";
		var param = {};
		param["type"] = 2;
		$.get(categoryUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					var template = $("div[item-template]");
					console.debug(responseData);
					$.each(data, function(i, o) {
						var item = template.clone();
						item.removeAttr("item-template");;
						item.find("[item-id=name]").text(o.name);
						item.find("[item-id=pic]").attr("src", o.picUrl);
						item.click(function() {
							location.href = ctx + "/web/memberlife/mall/goods-list.jsp?categoryId=" + o.id + "&d=" + d;
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