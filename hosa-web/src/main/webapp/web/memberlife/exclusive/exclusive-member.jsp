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
			$('.member_list').html('');
			if(data) {
			    var name = data.name==null?'':data.name;
				var level = data.levelString==null?'':data.levelString;
				var models = data.models==null?'':data.models;
				var integration = data.integration==null?'':data.integration;
				var areaName = data.areaName==null?'':data.areaName;
				$('<li>姓名：'+name+'</li>').appendTo($('.member_list'));
				$('<li>性别：'+data.genderString+'</li>').appendTo($('.member_list'));
				$('<li>所在地：'+areaName+'</li>').appendTo($('.member_list'));
				if(data.headImageUrl){
					$('.yuanimg').attr('src',data.headImageUrl);
				}
				
				
				$('<li>车型：'+models+'</li>').appendTo($('.member_list'));
				$('<li>级别：'+level+'</li>').appendTo($('.member_list'));
				$('<li>积分：'+integration+'</li>').appendTo($('.member_list'));
			}
		}
	});
});
</script>

<body class="mainbg" style="background:#473848;">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
		<li class="navactive"><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>

<section class="linearbg">
<img  src="" class="yuanimg"/>
<ul class="member_list">
</ul>
</section>
<section style=" position:relative ">
<a href=""><img src="${ctx }/web/images/mc-hd3_03.jpg" /></a>
<div class="conimg" style="text-align:center; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
<em></em>
<em></em>
</div>
</section>
<section class=" paddinfo infobg">
<p style="font-size:1.2rem;">AMG驾驶学院</p>
<p style="font-size:1.2rem;">体验梅赛德斯-AMG的极致驾驭</p>
<div>今年，AMG驾驶学院继续在中国顶级赛道震撼登场，在这些充满挑战且别具特色的赛道上，您将亲身体验AMG的极致魅惑与超凡性能。</div>
</section>
<section class="listicon">
<a href="${ctx }/web/memberlife/exclusive/member-activity.jsp"><img  src="${ctx }/web/images/icon.jpg"/></a>
</section>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<a><img src="${ctx}/web/images/tou.png">咨询顾问</a>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>
</body>
</html>
