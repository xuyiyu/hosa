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
<a href=""><img src="${ctx}/web/images/mc-hd3_03.jpg"></a>
<div class="titlebold"> 您好：${sessionScope.webUser.userName}</div>
<p class="contenttext"></p>
</section>
<a href="${ctx}/web/afterservice/activity/index.jsp?d=${sessionScope.webUser.rootDepartmentId}" class="ok-submit">返回首页</a>
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
		$(".contenttext").text("您未能参加${param.activity}活动，原因：${param.error}");
	} else {
		$(".contenttext").text("您已经成功参加${param.activity}活动，请准时莅临参加。");
	}
 	$().ready(function() {
 
 	});
})
</script>
</body>
</html>