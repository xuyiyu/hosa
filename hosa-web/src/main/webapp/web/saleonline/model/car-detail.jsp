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

	function GetRequest() {
		   var url = decodeURIComponent(location.search); //获取url中"?"符后的字串
		   var theRequest = new Object();
		   if (url.indexOf("?") != -1) {
		      var str = url.substr(1);
		      strs = str.split("&");
		      for(var i = 0; i < strs.length; i ++) {
		         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
		      }
		   }
		   return theRequest;
		}
	var request = new Object();
	request = GetRequest();
	var levelarray = ['全部','小型车','紧凑型车','中型车','中大型车','豪华车','SUV','跑车','两厢轿车','三厢轿车'];
	var array = ['全部','自动挡','手动挡','手自一体'];
	var url = ctx + "/web/car/input.htm";
	var param = {'id':request['id']};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('#bgLink').attr('href',data.picLink);
				$('#bgUrl').attr('src',data.picUrl);
				$('.conimg').html(data.name);
				var level = data.level==null?"":levelarray[data.level];
				var gearbox = data.gearbox==null?"":array[data.gearbox];
				$('.list_data').html('');
				$('<tr></tr>').html('<td class="tdl">厂商</td><td class="tdr">'+data.manufacturers+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">级别</td><td class="tdr">'+level+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">发动机</td><td class="tdr">'+data.engineType+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">变速箱</td><td class="tdr">'+gearbox+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">车辆颜色</td><td class="tdr">'+data.color+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">最高车速（km/h）</td><td class="tdr">'+data.speed+'</td>').appendTo($('.list_data'));
			
			
				$('<tr></tr>').html('<td class="tdl">优惠报价(万元)</td><td class="tdr">'+data.discountPrice+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">市场报价(万元)</td><td class="tdr">'+data.marketPrice+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">车身长宽高</td><td class="tdr">'+data.carrosserie+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">车身结构</td><td class="tdr">'+data.structure+'</td>').appendTo($('.list_data'));
				
				$('<tr></tr>').html('<td class="tdl">功率</td><td class="tdr">'+data.capacity+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">扭矩</td><td class="tdr">'+data.torsion+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">加速时间</td><td class="tdr">'+data.speedTime+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">油耗</td><td class="tdr">'+data.fuel+'</td>').appendTo($('.list_data'));
				
				$('<tr></tr>').html('<td class="tdl">轴距</td><td class="tdr">'+data.wheelbase+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">轮距</td><td class="tdr">'+data.tread+'</td>').appendTo($('.list_data'));
				$('<tr></tr>').html('<td class="tdl">排放标准</td><td class="tdr">'+data.effluent+'</td>').appendTo($('.list_data'));
				$("[name=carId]").val(data.id);
				$("[name=carSeriesId]").val(data.seriesId);
			}
		}
	});
	
	$('.ok-submit').click(function(){
		var carId = $("[name=carId]").val();
		var carSeriesId = $("[name=carSeriesId]").val();
		window.location.href=ctx+'/web/saleonline/testdrive/index.jsp?d='+d+'&ci='+carId+'&csi='+carSeriesId;
	});
	$('.gray-submit').click(function(){
		
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

<input type="hidden" name="carId"/>
<input type="hidden" name="carSeriesId"/>
<section>
<ul class="navli clearFix">
<li ><a href="#">促销活动</a></li>
<li class=""><a href="#">条件自选</a></li>
<li ><a href="#">快速找车</a></li>
<li ><a href="#">按车型找车</a></li>
</ul>
</section>

<section style=" position:relative ">
<a href="javascript:void(0);" id="bgLink"><img id="bgUrl" src="${ctx}/web/images/mc-cxhdflash.jpg"></a>
<div class="conimg" >
奔驰S600l
</div>
</section>
<section class="submittwobtn">
	<a href="javascript:void(0);" class="ok-submit fl">预约试驾</a><a name="consult" href="javascript:void();" class="gray-submit fl">咨询</a>
    <div class="clear"></div>
</section>
<!--价格分区-->

<section>
<div class="titleinfo">基本参数</div>
<table class=" ksz3 clearFix" cellspacing="3" cellpadding="0" style="width:100%;">
	<tbody class = "list_data"></tbody>
	</table>

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
