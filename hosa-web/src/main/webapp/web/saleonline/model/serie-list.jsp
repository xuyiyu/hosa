<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

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
	var param = {'carSeriesQuery.recommend':1,'carSeriesQuery.sortColumns':' recommend_time desc limit 5 '};
	$.webAjax(queryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('.chexing').html('');
				$.each(data,function(i,o){
				    var index = i+1;
				    var href = ctx+'/web/saleonline/model/car-list.jsp?id='+o.id+'&d='+d;
					$('<div class="chexing-img chexing-style-'+index+'"></div>').html('<a href="'+href+'"><img src="'+o.picUrl+'"/><br>'+o.seriesName+'</a>').appendTo($('.chexing'));
				});
				$('<div class="chexing-img-center"><img src="'+ctx+'/web/images/chexing-car-7.png"></div>').appendTo($('.chexing'));
			}
		}else {
			$.errorNotification(responseData.r_info);
		}
	});
	
	$('.ok-submit01').click(function(){
		window.location.href =  ctx + '/web/saleonline/model/serise-all.jsp?d='+d;
	});
});
</script>

<body class="gray-gradient-bg">
<section>
<div class="mctitle">
<a href="${ctx }/web/index.jsp"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

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
<a href=""><img src="${ctx }/web/images/mc-cxhdflash.jpg" /></a>
<div class="conimg" style="text-align:right; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
</div>
</section>
<section class="chexing">
	<!-- <div class="chexing-img chexing-style-1" ><img src="${ctx}/web/images/chexing-car-1.png">jfdkjfdkjfdj</div>
	<div class="chexing-img chexing-style-2"><img src="${ctx}/web/images/chexing-car-2.png">55554</div>
	<div class="chexing-img chexing-style-3"><img src="${ctx}/web/images/chexing-car-3.png">54555</div>
	<div class="chexing-img chexing-style-4"><img src="${ctx}/web/images/chexing-car-4.png">888</div>
	<div class="chexing-img chexing-style-5"><img src="${ctx}/web/images/chexing-car-5.png">999</div>
	<div class="chexing-img-center"><img src="${ctx}/web/images/chexing-car-6.png"></div> -->
</section>
<a class="ok-submit01 fr">更多</a>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx }/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx }/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
</body>
</html>
