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
<body class="mainbg">
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
<section class=" paddinfo">
<div class="top-block block-select">预约保养
<p>为了给您更好的服务请您仔细阅读详细信息</p>
</div>
<div class="top-block block-select">您的预约信息：</div>
<div class="top-block block-select"> 客户姓名：${maintainOrder.baideliUser.name }</div>
<div class="top-block block-select"> 联系电话：${maintainOrder.baideliUser.mobile }</div>
<div class="top-block block-select"> 业务单号：${maintainOrder.code }</div>
<div class="top-block block-select"> 预约时间：${maintainOrder.appointmentTimeString }</div>
<div class="top-block block-select"> 车牌照号：${maintainOrder.baideliUser.plate}</div>
<div class="top-block block-select"> 车架号：${maintainOrder.baideliUser.frameNo}</div>
<div class="top-block block-select" id="statusShow"> 状态：</div>
<div id="status" style="display:none;">${maintainOrder.status }</div>
<div class="top-block block-select"> 备注：</div>
<a class="submit-btn" href="javascript:void();" style="margin-top: 10%;">返回首页</a>
</section>
</body>
<script type="text/javascript">

	$(function(){
		console.log("status:");
		$().ready(function() {
		
		
		var status = $("#status").text();
		console.log("status:");
		status = parseInt(status);
		var statusShow = "";
		switch(status){
			case 1:statusShow="已提交";break;
			case 2:statusShow="已确认";break;
			case 3:statusShow="已到店";break;
		}
		statusShow = "状态："+statusShow;
		$("#statusShow").text(statusShow);
	
		
		
	});
	
	})
	</script>
</html>
