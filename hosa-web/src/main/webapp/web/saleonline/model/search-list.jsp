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
    var search = function(){
    var url = ctx + "/webadmin/common/queryCarList.htm";
	var array = [];
	var param = {};
	if($('#price').val()!=''){
		array = $('#price').val().split('-');
	}
	if(array != null){
		param['carQuery.discountPriceGE'] = array[0];
		param['carQuery.discountPriceLE'] = array[1];
	}
	param['carQuery.level'] = $('#level').val();
	param['carQuery.gearbox'] = $('#gearbox').val();
	
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('.zix-result-list').html('');
				$.each(data,function(i,o){
					var html = '<em><img  src="'+ctx+'/web/images/more.png"></em>';
					html+='<span class="price">'+o.discountPrice+"-"+o.marketPrice+'万元</span>';
					html+='<p style="text-align:left;">'+o.name+'</p>';
						
					$('<li  style="border-bottom:solid 1px #ccc; background:#fff;"></li>').click(function(){
						window.location.href=ctx+'/web/saleonline/model/car-detail.jsp?id='+o.id+"&d="+d;
					}).html(html).appendTo($('.zix-result-list'));
				});
			}
		}
	});
    };
    
	$('.clear-condition').click(function(){
		$('#price').val('');
		$('#level').val('');
		$('#gearbox').val('');
	});
	$('.search-condition').click(function(){
		search();
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
<li  class="navactive"><a href="#">条件自选</a></li>
<li ><a href="#">快速找车</a></li>
<li ><a href="#">按车型找车</a></li>
</ul>
</section>
<section class="zix">
	<ul class="conditions-list clearFix">
		<li class="condition-selected" style="padding:0; border:none;">
			
			<select id="price" style="font-size:14px;">
			<option value=''>价格范围</option>
			<option value="20-40">20-40万</option>
			<option value="40-60">40-60万</option>
			<option value="60-80">60-80万</option>
			<option value="80-100">80-100万</option>
			<option value="100-200">100-200万</option>
			<option value="200-300">200-300万</option>
			<option value="300-500" >300-500万</option>
			<option value="500-800">500-800万</option>
			</select>
		</li>
		<li style="padding:0; border:none;">
			<select id="level" style="font-size:14px;">
			<option value="">所有级别</option>
			<option value="1">小型车</option>
			<option value="2">紧凑型车</option>
			<option value="3">中型车</option>
			<option value="4">中大型车</option>
			<option value="5">豪华车</option>
			<option value="6">SUV</option>
			<option value="7">跑车</option>
			<option value="8">两厢轿车</option>
			<option value="9">三厢轿车</option>
			</select>
		
		</li>
		<li style="padding:0; border:none;">
			<select id="gearbox" style="font-size:14px;">
			<option value="">变速箱</option>
			<option value="1">自动</option>
			<option value="2">手动</option>
			<option value="3">手自一体</option>
			</select>
		</li>
		<!--<li><span>全部排量</span>
			<select id="price">
			<option>10-20</option>
			<option>20-25</option>
			<option>30-35</option>
			<option>35-40</option>
			<option>50-60</option>
			</select>
		</li>
		<li><span>配置</span><em><img src="${ctx}/web/images/mc-zix_condition-unselected.png"></em></li>-->
	</ul>
</section>
<section class="zix-res">
	<div class="zix-selected-result clearFix">
		<span class="clear-condition" >清空</span>
		<span style="margin-left:15px;margin-right:15px;">&nbsp;</span>
		<span class="search-condition">查询</span>
		<p class="res-text">5个车型（按首字母排序）</p>
	</div>
</section>
<section class="conditon-select-area">
	<ul class="zix-result-list">
		</ul>
</section>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx}/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
</body>
</html>
