<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百得利-车型助手</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>

<script type="text/javascript">
$(function() {
	
	var queryUrl = ctx + "/web/order/queryOrderList.htm";
	$.webAjax(queryUrl, null, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$.each(data,function(i,o){
		   			var html = '<img  src="'+o.goodsSnapshot.picUrl+'"/><div>'+o.goodsSnapshot.name;
		   			html+='<p class="yellow">¥：'+o.transactionPrice+'</p>';
		   			html+='<p class="yellow">x'+o.goodsQuantity+'</p>';
		   			html+='</div>';
		   			$('<li></li>').click(function(){
		   				window.location.href = ctx+"/web/memberlife/membercar/order-detail.jsp?id="+o.id+"&d="+d;
		   			}).html(html).appendTo($('.cx'));
				});
				
				$('<div class="clear"></div>').appendTo($('.navli'));
			}
			$('#li_0').click();
		}else {
			$.errorNotification(responseData.r_info);
		}
	});
});
</script>
<body >
<section>
<div class="mctitle">
<a href="${ctx }/web/index.jsp"><img src="${ctx }/web/images/iconhome.png" /></a>
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

<section class="paddinfo">
<ul class="cx">
</ul>

</section>
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
