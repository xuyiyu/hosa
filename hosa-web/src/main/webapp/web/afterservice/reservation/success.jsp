<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page  isELIgnored="false"   %>
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
<li class="navactive"><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
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
<section class="submit-result">
	<h3 class="result-title success"><img src="${ctx}/web/images/mc-tj_ico.png" align="absmiddle"><span>已成功提交信息</span></h3>
	<p class="text-intro">稍后我们的客户经理会与您联系</p>
    <!-- <p  class="redfont">温馨提示：到店试驾，请携带您的驾驶执照</p> -->
	<a href="javascript:void();" class="ok-submit">返回首页</a>
</section>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void();"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
</body>
</html>
