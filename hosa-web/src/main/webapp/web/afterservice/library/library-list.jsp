<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link rel="stylesheet" type="text/css" href="${ctx}/web/css/mc.css">
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>

</head>
<script>
$(function(){
	var url = ctx + "/web/library/queryExpertCategoryList.htm";
	$.webAjax(url, null, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('.listcon').html('');
				$.each(data,function(i,o){
				    var index = i+1;
				    var html = '<img  src="'+ctx+'/web/images/auto-cx'+index+'.png" class="listimg fl"/>';
					html+='<div class="fl confont"><h3>'+o.name+'</h3></div>';
					html+='<img src="'+ctx+'/web/images/more.png"  class="moreimg fr" /><div class="clear"></div>';
					$('<li></li>').click(function(){
						window.location.href = ctx +'/web/afterservice/library/question-list.jsp?id='+o.id;
					}).html(html).appendTo($('.listcon'));
					
				});
			}
		}
	});
});

</script>
<body class="mainbg">
<section>
<div class="mctitle">
<a href="${ctx }/web/index.jsp"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli">
<li ><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li class="navactive"><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
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
<section class=" paddinfo">
<ul class="listcon">
</ul>
</section>

<!--小浮层-->
<section class="fuchen ">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
</body>
</html>
