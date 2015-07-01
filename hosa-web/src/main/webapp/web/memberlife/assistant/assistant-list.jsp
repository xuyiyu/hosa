<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>
<script type="text/javascript">
$(function(){

	$('.top-block2').click(function(){
		$('.active03').removeClass('active03');
		$(this).addClass('active03');
	});
	$('.member').click(function(){
	  	window.location.href=ctx+'/web/memberlife/assistant/member-info.jsp?d='+d;
	});
	$('.history').click(function(){
		window.location.href=ctx+'/web/memberlife/assistant/history-list.jsp?d='+d;
	});
	$('.weixiu').click(function(){
		window.location.href=ctx+'/web/afterservice/reservation/repair-history-list.jsp?d='+d;
	});
	$('.baoyang').click(function(){
		window.location.href=ctx+'/web/afterservice/reservation/maintain-history-list.jsp?d='+d;
	});
	$('.jiuyuan').click(function(){
		window.location.href=ctx+'/web/afterservice/rescue/rescue-history-list.jsp?d='+d;
	});
	
});
</script>

<body class=" gray-gradient-bg">
<section>
<div class="mctitle">
<a href="${ctx }/web/index.jsp"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>
</div>
</section>
<section>
	<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li class="navactive"><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>
<section class="paddinfo">
    <div class="siche fl"><img  src="${ctx}/web/images/mc-siche1.png"/></div>
	<div class="top-block2 fl  active03 member" >会员资料</div>
     <div class="line clear"></div>
     
     <div class="siche fl"><img  src="${ctx}/web/images/mc-siche2.png"/></div>
	<div class="top-block2 fl history" >联络历史</div>
     <div class="line clear"></div>

     <div class="siche fl"><img  src="${ctx}/web/images/mc-siche3.png"/></div>
	<div class="top-block2 fl weixiu" >维修业务单</div>
     <div class="line clear"></div>
     
     <div class="siche fl"><img  src="${ctx}/web/images/mc-siche4.png"/></div>
	<div class="top-block2 fl baoyang" >保养业务单</div>
     <div class="line clear"></div>
     
     <div class="siche fl"><img  src="${ctx}/web/images/mc-siche5.png"/></div>
	<div class="top-block2 fl jiuyuan" >救援业务单</div>

</section>

</body>
</html>
