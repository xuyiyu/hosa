<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link rel="stylesheet" type="text/css" href="${ctx }/web/css/mc.css">
</head>
<body>
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli">
<li class="navactive"><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>

<section class="paddinfo shouhou">
<!--选中用active001-->
<p class="baoyang" onclick="location.href='${ctx}/web/afterservice/reservation/maintain-list.jsp?d=${sessionScope.webUser.rootDepartmentId}'"><a href="${ctx}/web/afterservice/reservation/maintain-list.jsp?d=${sessionScope.webUser.rootDepartmentId}">预约保养</a></p>
<p class="weixiu active002" onclick="location.href='${ctx}/web/afterservice/reservation/repair-list.jsp?d=${sessionScope.webUser.rootDepartmentId}'"><a href="${ctx}/web/afterservice/reservation/repair-list.jsp?d=${sessionScope.webUser.rootDepartmentId}">预约维修</a></p>


</section>

<!--价格分区-->


<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<a href=""><img src="${ctx }/web/images/tou.png">咨询顾问</a>
<a href=""><img src="${ctx }/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>
</body>
</html>
