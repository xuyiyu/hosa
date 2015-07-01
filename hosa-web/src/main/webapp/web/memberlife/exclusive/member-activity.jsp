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
	var url = ctx + "/web/baideli/findActivityMap.htm";
	var param = {'activityParticipantQuery.userId':userId};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			$('.list_all').html('');
			if(data) {
				$('.list_all').html('');
				$.each(data,function(i,o){
				    var section = $('<section></section>').appendTo($('.list_all'));
					var div = $('<div class="kuan50 "></div>').html('<span class="dateposition">'+o.key+'</span>').appendTo(section);
					$.each(o.activityList,function(n,m){
						if(n<1){
							$('<img></img>').click(function(){
								window.location.href = ctx +'/web/memberlife/exclusive/activity-info.jsp?id='+m.id+'&d='+d;
							}).attr('src',m.beginPicUrl).appendTo(div);
						}else{
							var div_ojb = $('<div class="kuan50"></div>').appendTo(section);
							$('<img  src="'+m.beginPicUrl+'"/>').click(function(){
								window.location.href = ctx +'/web/memberlife/exclusive/activity-info.jsp?id='+m.id+'&d='+d;
							}).appendTo(div_ojb);
							
						}
						
					});
					
					$('<div class="clear"></div>').appendTo(section);

				});
			}
		}
	});
});
</script>
<body class="mainbg" style="min-height:500px;" >
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


<section class="fenlan" style="min-height:600px;" >
<div class="fl"  style="width:25%; "></div>
<div class="fr" style="width:75%; ">
<p>消息目录</p>
<div class="list_all"></div>
</div>
</section>

<!--
<section class="listicon" style=" position:absolute; right:7%; top:90%;">
<a><img  src="${ctx}/web/images/icon.jpg"/></a>
</section>
-->
<section class="listicon">
<a href="${ctx }/web/memberlife/exclusive/exclusive-member.jsp"><img  src="${ctx }/web/images/icon.jpg"/></a>
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
