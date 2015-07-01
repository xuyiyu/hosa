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
<script>
$(function(){
	$('.submit-btn').click(function(){
		$("#form1").submit();
	});
	
	$('.ql-item').click(function(){
		$('.selected').removeClass('selected');
		$(this).addClass('selected');
		var firstPrice =$(this).find('[name="value1"]').html();
		var secondPrice =$(this).find('[name="value2"]').html();
		$('#firstPrice').val(firstPrice);
		$('#secondPrice').val(secondPrice);
	});
});
</script>
<body  >
<section>
<div class="mctitle">
<a href="${ctx }/web/index.jsp"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli">
<li ><a href="#">促销活动</a></li>
<li><a href="#">条件自选</a></li>
<li  class="navactive"><a href="#">快速找车</a></li>
<li ><a href="#">按车型找车</a></li>
<div class="clear"></div>
</ul>
</section>

<section class="">
<img  src="${ctx}/web/images/tou1.png" class="yuanimg1"/>
<div class="duihuabg">
<div class="step">
<div class=" step1 circle active02"></div>
<div class=" step2 circle "></div>
<div class=" step3 circle "></div>
</div>
<p>您的预算范围是?</p>
<div class="sanjiao"><em></em></div>
</div>
<!--价格分区-->
<div class="jiage clearfix" style="margin-left:15px;">

<div class="ql-item">
<div class="card"></div>
<div class="">20</div>
<div class="price-tag"><div name="value1">20</div><div name="value2">40</div></div>
</div>

<div class="ql-item">
<div class="card"></div>
<div class="">40</div>
<div class="price-tag"><div name="value1">40</div><div name="value2">60</div></div>
</div>

<div class="ql-item">
<div class="card"></div>
<div class="">60</div>
<div class="price-tag"><div name="value1">60</div><div name="value2">80</div></div>
</div>

<div class="ql-item">
<div class="card"></div>
<div class="">80</div>
<div class="price-tag"><div name="value1">80</div><div name="value2">100</div></div>
</div>
<div class="ql-item">
<div class="card"></div>
<div class="">100</div>
<div class="price-tag"><div name="value1">100</div><div name="value2">200</div></div>
</div>

<div class="ql-item">
<div class="card"></div>
<div class="">200</div>
<div class="price-tag"><div name="value1">200</div><div name="value2">300</div></div>
</div>
<div class="ql-item">
<div class="card"></div>
<div class="">300</div>
<div class="price-tag"><div name="value1">300</div><div name="value2">500</div></div>
</div>
<div class="ql-item">
<div class="card"></div>
<div class="">500</div>
<div class="price-tag"><div name="value1">500</div><div name="value2">800</div></div>
</div>

<div class="ql-item">
<div class="limit-symbol">∞</div>
</div>
<div class="clear"></div>
</div>
<form name="form1" id="form1" method="post" action="${ctx }/web/saleonline/model/car-searchlist.jsp">
<!--输入框-->
<div style="padding:30px 15px 0;">
	           		<div  style="float:right;">
	           			<input type="tel" id="firstPrice" name="firstPrice" class="price-box" >
	           			~
	           			<input type="tel" id="secondPrice" name="secondPrice" class="price-box" >
	           			万元
	           		</div>
	           	</div>

<div class="clear"></div>
</section>
<div style="margin-top:20px;">
 <a class="submit-btn" href="javascript:void(0);">下一步</a>
 </div>
 </form>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<a><img src="${ctx }/web/images/tou.png">咨询顾问</a>
<a href="tel:+861058739999"><img src="${ctx }/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>
</body>
</html>
