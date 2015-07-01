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

<body  class="mcbg">
<!-- <script>
$(function() {
	var queryUrl = ctx + "/webadmin/common/queryModelItemlist.htm";
	var param = {'modelItemQuery.menuType':1};
	$.webAjax(queryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
			    
			   //$('.mcbg').css('background','url('+ctx+'/web/images/mcindexbg.jpg) no-repeat');
			   //$('.mcbg').css('min-height','400px');
			   // $('.mcbg').css('background-size','100%');
			  /*  if(data.result[0].bgUrl){
			   		$('.mcbg').css('background','url('+data.result[0].bgUrl+') no-repeat');
			   } */
				
			}
		}else {
			$.errorNotification(responseData.r_info);
		}
	});
});
</script> -->
<section class="mcli">
<ul style="">
<li style="background:#473848;"><a href="${ctx}/web/saleonline/model/serie-list.jsp?i=0&d=${sessionScope.webUser.rootDepartmentId}" style="color:#FFF;">车型中心</a></li>
<li><a href="${ctx}/web/saleonline/activity/index.jsp?d=${sessionScope.webUser.rootDepartmentId}" style="color:#FFF;">促销活动</a></li>
<li><a href="${ctx}/web/memberlife/mall/index.jsp?d=${sessionScope.webUser.rootDepartmentId}" style="color:#FFF;">精品汇</a></li>
<li><a href="javascript:void(0);" style="color:#FFF;">售后活动</a></li>
<li><a href="${ctx}/web/saleonline/assistant/index.jsp?i=0&d=${sessionScope.webUser.rootDepartmentId}" style="color:#FFF;">车行助手</a></li>
<li><a href="${ctx}/web/assistant/navigation.jsp?i=0&d=${sessionScope.webUser.rootDepartmentId}" >4s店导航</a></li>
</ul>
</section>
</body>
</html>
