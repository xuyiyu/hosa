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
$(function() {
	var queryUrl = ctx + "/webadmin/common/queryCarList.htm";
	var param = {'carQuery.discountPriceGE':$('#firstPrice').val(),'carQuery.discountPriceLE':$('#secondPrice').val()};
	$.webAjax(queryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('.cx').html('');
		   		$.each(data,function(n,m){
		   			var html = '<img  src="'+m.picUrl+'"/><div>'+m.name;
		   			html+='<p class="yellow">指导价：'+m.marketPrice+'万</p>';
		   			html+='</div>';
		   			$('<li></li>').click(function(){
		   				window.location.href = ctx+"/web/saleonline/model/car-detail.jsp?id="+m.id+"&d="+d;
		   			}).html(html).appendTo($('.cx'));
		   		});
			}
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
<input type="hidden" id="firstPrice" value="${param.firstPrice}">
<input type="hidden" id="secondPrice" value="${param.secondPrice}">
</div>
</section>
<section>
<ul class="navli clearFix">
<li ><a href="#">促销活动</a></li>
<li class=""><a href="#">条件自选</a></li>
<li ><a href="#">快速找车</a></li>
<li ><a href="#">按车型找车</a></li>
</ul>
</section>

<section style=" position:relative ">
<a href="javascript:void(0);" id="bgLink"><img id="bgUrl" src="${ctx }/web/images/mc-cxhdflash.jpg"></a>
<div class="conimg" >
奔驰S600l<span class="yellow" style="margin-left:40%;">60-80-120.5万</span>
</div>
</section>

<!--价格分区-->
<section class="paddinfo">
<ul class="cx">
</ul>

</section>



<!--小浮层
<section class="fuchen hide">
<ul>
<li><em></em>
<a><img src="${ctx}/web/images/tou.png">咨询顾问</a>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>-->
</body>
</html>
