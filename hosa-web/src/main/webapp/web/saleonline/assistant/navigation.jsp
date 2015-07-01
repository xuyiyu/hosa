<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/web/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>
<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
}

@media ( max-device-width : 780px) {
	#golist {
		display: block !important;
	}
}

#golist {
	display: none;
}
</style>
<script src="${ctx}/js/jquery/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=32b9e0d16e082ac8ef3c3be6846f4fa3"></script>
<script type="text/javascript"
	src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script>
	var x = 0;
	var y = 0;
	$().ready(function() {
		getLocation();

	});

	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}

	function showPosition(position) {
		x = position.coords.latitude;
		y = position.coords.longitude;
		//x=39.930073;y=116.274533;
		//x=39.93013;y=116.272891;
		//x=39.930167;y=116.269973;
		//x= 39.930311;y=116.265633;

		var gpsPoint = new BMap.Point(y, x);

		BMap.Convertor.translate(gpsPoint, 0, translateCallback);

	}
	var map;
	function translateCallback(point) {

		map = new BMap.Map("allmap");

		map.centerAndZoom(point, 10);

		var marker1 = new BMap.Marker(point); // 创建标注
		map.addOverlay(marker1);

		var info = new BMap.InfoWindow(
				"<span style='color:#00a6ac'>我的位置</span>", {
					width : 50,
					height : 20,
					enableMessage : false
				});
		marker1.addEventListener("click", function() {
			this.openInfoWindow(info);
		});

		//var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
		var lat = point.lat;
		var lng = point.lng;
	//	alert(lat+":"+lng);
		addMarker(
				0,
				new BMap.Point(116.28069060672, 39.937900950127),
				"<div style='font-size:15px;'><span style='color:#00a6ac'>"
						+ '百得利汽车贸易有限公司'
						+ "</span>"
						+ "<br/> <span style='font-weight:bold;'><b>介绍：</b></span>"
						+ '北京百得利汽车进出口集团有限公司是1996年底经国家工商总局和国家计委审核批准成立的，国内知名的汽车经销商集团之一，主要经营高端轿车市场的各项服务。'
						+ "<br/><span style=\"font-weight:bold;\">地址：</span>"
						+ '北京经济技术开发区东环北路1号'
						+ "<br/><span style=\"font-weight:bold;\">电话：</span><a href='tel:"
						+ '(010)67870909'
						+ "'>"
						+ '(010)67870909'
						+ "</a>"
						//+ "<br/>营业时间：" + '周一至周日 9：00～18：00'       
						+ "<div style='text-align:center;'><input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.937900950127,116.28069060672|name:北京百得利汽车贸易公司&mode=transit&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='公 交'/>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.937900950127,116.28069060672|name:北京百得利汽车贸易公司&mode=driving&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='驾 车'/>" + "</div>");
			
		/*addMarker(
				0,
				new BMap.Point(116.52570088377, 39.81940484536),
				"<div style='font-size:15px;'><span style='color:#00a6ac'>"
						+ '百得利汽车贸易有限公司'
						+ "</span>"
						+ "<br/> <span style='font-weight:bold;'><b>介绍：</b></span>"
						+ '北京百得利汽车进出口集团有限公司是1996年底经国家工商总局和国家计委审核批准成立的，国内知名的汽车经销商集团之一，主要经营高端轿车市场的各项服务。'
						+ "<br/><span style=\"font-weight:bold;\">地址：</span>"
						+ '北京经济技术开发区东环北路1号'
						+ "<br/><span style=\"font-weight:bold;\">电话：</span><a href='tel:"
						+ '(010)67870909'
						+ "'>"
						+ '(010)67870909'
						+ "</a>"
						//+ "<br/>营业时间：" + '周一至周日 9：00～18：00'       
						+ "<div style='text-align:center;'><input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.81940484536,116.52570088377|name:北京百得利汽车贸易公司&mode=transit&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='公 交'/>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.81940484536,116.52570088377|name:北京百得利汽车贸易公司&mode=driving&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='驾 车'/>" + "</div>");*/

		/*addMarker(
				0,
				new BMap.Point(116.47430805907, 39.904107937561),
				"<div style='font-size:15px;'><span style='color:#00a6ac'>"
						+ '百得利汽车贸易有限公司'
						+ "</span>"
						+ "<br/> <span style='font-weight:bold;'><b>介绍：</b></span>"
						+ '北京百得利汽车进出口集团有限公司是1996年底经国家工商总局和国家计委审核批准成立的，国内知名的汽车经销商集团之一，主要经营高端轿车市场的各项服务。'
						+ "<br/><span style=\"font-weight:bold;\">地址：</span>"
						+ '北京经济技术开发区东环北路1号'
						+ "<br/><span style=\"font-weight:bold;\">电话：</span><a href='tel:"
						+ '(010)67870909'
						+ "'>"
						+ '(010)67870909'
						+ "</a>"
						//+ "<br/>营业时间：" + '周一至周日 9：00～18：00'       
						+ "<div style='text-align:center;'><input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.904107937561,116.47430805907|name:北京百得利汽车贸易公司&mode=transit&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='公 交'/>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' onclick='window.location.href=\""
						+ 'http://api.map.baidu.com/direction?origin=latlng:'
						+ lat
						+ ','
						+ lng
						+ '|name:我的位置&destination=latlng:39.904107937561,116.47430805907|name:北京百得利汽车贸易公司&mode=driving&region=北京&output=html&src=美讯易诚|美讯易诚;'
						+ "\"' value='驾 车'/>" + "</div>");*/

	}

	function addMarker(i, point, cotent) {
		var marker = new BMap.Marker(point, {
			icon : new BMap.Icon("${ctx}/web/images/location.png", new BMap.Size(
					51, 53))
		}); // 创建标注
		map.addOverlay(marker);

		var infoWindow = new BMap.InfoWindow(cotent, {
			enableMessage : false
		});
		marker.addEventListener("click", function() {
			this.openInfoWindow(infoWindow);
		});
	}
</script>
</head>

<body>
	<div id="allmap"></div>

	<div id="bb" style="display:none;">
		<p id='aaa'
			style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>驾车</p>
	</div>
</body>
</html>

