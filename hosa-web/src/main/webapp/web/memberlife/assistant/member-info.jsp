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
			$('.paddinfo').html('');
			if(data) {
				var name = data.name==null?'':data.name;
				var level = data.levelString==null?'':data.levelString;
				var models = data.models==null?'':data.models;
				var integration = data.integration==null?'':data.integration;
				var card = data.card==null?'':data.card;
				var areaName = data.areaName==null?'':data.areaName;

				$('<div></div>').html('<h3 class="form-title">会员信息</h3>').appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('您的会员信息：').appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('姓名：'+name).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('性别：'+data.genderString).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('手机号：'+data.mobile).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('所在地区：'+areaName).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('车牌号：'+data.plate).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('车架号：'+data.frameNo).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('车型：'+models).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('入会时间：'+data.createdAtString).appendTo($('.paddinfo'));

				$('<div class="top-block block-select"></div>').html('会员卡号：'+card).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('会员级别：'+level).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('积分：'+integration).appendTo($('.paddinfo'));
				$('<div class="top-block block-select"></div>').html('会员余额：'+data.availableOver).appendTo($('.paddinfo'));
				$('<a class="submit-btn" style="margin-top: 10%;">返回首页</a>').attr('href',ctx+"/web/index.jsp").appendTo($('.paddinfo'));
				
			}
		}
	});
});
</script>
<body class="mainbg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx }/web/images/iconhome.png" /></a>
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
<section class=" paddinfo">

</section>
</body>
</html>
