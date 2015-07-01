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
	var queryUrl = ctx + "/webadmin/common/queryCarseriesList.htm";
	var param = {};
	$.webAjax(queryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				var tr= null;
				$('.list').html('');
				$.each(data,function(i,o){
				   if(i%2==0){
				   		tr = $('<tr></tr>').appendTo($('.list'));
				   }
				   $('<td class="select-item ksz"><a href="'+ctx+'/web/saleonline/model/car-list.jsp?id='+o.id+"&d="+d+'"><img src="'+o.picUrl+'"/>'+o.seriesName+'</a></td>').appendTo(tr);
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

</div>
</section>
<section>
<ul class="navli">
<li ><a href="#">促销活动</a></li>
<li class=""><a href="#">条件自选</a></li>
<li ><a href="#">快速找车</a></li>
<li ><a href="#">按车型找车</a></li>
<div class="clear"></div>
</ul>
</section>

<section style=" position:relative ">
<a href=""><img src="${ctx }/web/images/mc-cxhdflash.jpg"></a>
<div class="conimg" style="text-align:right; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
</div>
</section>
<!--价格分区-->
<section class="">
<table class="selected-list clearFix" cellspacing="3" cellpadding="0">
	<tbody class="list">
	</tbody></table>
  <!--   <a class="submit-btn" href="javascript:void(0);">下一步</a> -->
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
