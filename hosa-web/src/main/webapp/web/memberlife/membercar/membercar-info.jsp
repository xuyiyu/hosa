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
	var url = ctx + "/web/baideli/getByUserId.htm";
	var param = {'baideliUserQuery.userId':userId};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			$('.list_all').html('');
			if(data) {
				$('<p>会员信息</p>').appendTo($('.list_all'));
				var name = data.name==null?'':data.name;
				var level = data.levelString==null?'':data.levelString;
				var models = data.models==null?'':data.models;
				var integration = data.integration==null?'':data.integration;
				var card = data.card==null?'':data.card;
				$('<p>姓名：'+name+'</p>').appendTo($('.list_all'));
				$('<p>等级：'+level+'</p>').appendTo($('.list_all'));
				$('<p>车型：'+models+'</p>').appendTo($('.list_all'));
				$('<p>会员卡：'+card+'</p>').appendTo($('.list_all'));
				$('<p>积分：'+integration+'</p>').appendTo($('.list_all'));
				
			}
		}
	});
	$('#jifen').click(function(){
		window.location.href=ctx+'/web/memberlife/membercar/integration-info.jsp';
	});
	$('#coupons').click(function(){
		window.location.href=ctx+'/web/memberlife/membercar/coupons-list.jsp';
	});
	$('#search').click(function(){
		window.location.href=ctx+'/web/memberlife/membercar/order-list.jsp';
	});
	
	  
});
</script>

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
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li class="navactive"><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>
<img src="${ctx }/web/images/mc-huiyuanka_03.png"/>
<section class="paddinfo kabao ksz5">
<div class="list_all" style="width: 96.25%;margin: 0 auto;"> 
</div>
<div class="top-block block-select" id="jifen" >积分规则<img src="${ctx}/web/images/more1.png" class="more1"></div>
<div class="top-block block-select" id="coupons" >所持优惠劵<img src="${ctx}/web/images/more1.png" class="more1"></div>
<div class="top-block block-select" id="search">消费查询<img src="${ctx}/web/images/more1.png" class="more1"></div>
</section>

</body>
</html>
