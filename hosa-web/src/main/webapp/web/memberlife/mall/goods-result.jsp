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

<section class="paddinfo">
<a href=""><img src="${ctx}/web/images/mc-hd3_03.jpg"></a>
<div class="titlebold"> 您好：${sessionScope.webUser.userName}</div>
<p class="contenttext"></p>
</section>
<a href="${ctx}/web/memberlife/mall/index.jsp?d=${sessionScope.webUser.rootDepartmentId}" class="ok-submit">返回首页</a>
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

	if("${param.error}" != "") {
		$(".contenttext").text("购买商品失败，原因：${param.error}");
	} else {
		$(".contenttext").text("商品购买成功，订单编号：${param.code}。");
	}
 	$().ready(function() {
 
 	});
})
</script>
</body>
</html>