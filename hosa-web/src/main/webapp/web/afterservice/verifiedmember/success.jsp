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
<li ><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>


<h3 class="form-title">会员信息</h3>
	<section class="paddinfo ksz5">
<p>姓名：${baideliUser.name}</p>
<p>性别： ${baideliUser.genderString}</p>
<p>联系电话： ${baideliUser.mobile}</p>
<p>微信昵称：${weixinUsersName}</p>
<p>地域： ${baideliUser.areaName}</p>
<p>4S店：<a style="color:#2e3192;">${departmentName}</a></p>
<p>爱车：${carName}</p>
<p>车架号：${baideliUser.frameNo}  </p>
</section>
	<a href="javascript:void();" class="ok-submit">返回首页</a>

<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void();"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>


<script type="text/javascript">
	$(function(){

	
	
	
	
	
	
	})
					

</script>
</body>
</html>