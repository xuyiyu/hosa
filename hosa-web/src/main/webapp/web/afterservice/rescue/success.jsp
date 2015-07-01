<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>
<%@ page  isELIgnored="false"   %>
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
<li class="navactive"><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>


<h3 class="form-title">24小时救援</h3>
	<section class="paddinfo ksz5" id="info">
<p name="name">姓名：张先生</p>
<p name="mobile">手机：13879023345</p>

<p>地理位置：${rescueOrder.location}</p>
<p style="margin-top:3%;">您的救援单已提交成功，请您耐心等待，我们的维修人.<a href="javascript:void(0);" id="uploadAccidentImg" style="text-decoration: underline;">上传照片</a></p>
<div class="top-block1"  style=" margin-top:4.6%;display:none;" >上传照片</div> 

</section>
	<a href="javascript:void(0);" class="ok-submit">返回首页</a>

<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
<section class="tanchuposition" id="uploadimg-prompt-layer" style="z-index:100000;display:none;">
<img style="margin-top:20%;" src="${ctx}/web/images/uploadimg.png"  >
</section>
<script type="text/javascript">
	$(function(){
		$("#info").find("[name=name]").text("姓名："+userName);
		$("#info").find("[name=mobile]").text("电话："+userMobile);
		
		$("#uploadAccidentImg").click(function(){
			$("#uploadimg-prompt-layer").show();
		});
		$("#uploadimg-prompt-layer").click(function(){
			$("#uploadimg-prompt-layer").hide();
		});
	})
</script>
</body>

</html>