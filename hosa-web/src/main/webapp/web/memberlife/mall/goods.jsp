<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/web/commons/taglibs.jsp"%>


<!DOCTYPE HTML>
<html>
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>

<body >
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li class="navactive"><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>
<section >
<a href="javascript:void(0);"><img item-id="goods-pic"  src=""></a>
</section>
<section class="proinfo" >
<p class="plineheight" item-id="goods-name"> </p>
<a class="jia" >现价：<label item-id="goods-discount-price"></label><em item-id="goods-price"></em></a><span style="display:none;"></span>
</section>

<section class="procon" >
<p class="plineheight">产品说明</p>
<p class="plineheight" item-id="goods-introduction"></p>

</section>
<a class="submit-btn" href="javascript:void(0);" item-id="button-join">购买</a>

<script>

$(function() {
	var loadGoods = function() {
		var goodsId = "${param.goodsId}";
		if(!goodsId) {
			return;
		}
		var param = {};
		param["id"] = goodsId;
		var activityUrl = ctx + "/web/mall/mall!input.htm";
		$.get(activityUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				console.debug(data);
				if(data) {
					$("[item-id=goods-pic]").attr("src", data.picUrl);
					$("[item-id=goods-name]").html(data.name);
					$("[item-id=goods-price]").text("原价：" +  data.price);
					$("[item-id=goods-discount-price]").text(data.price * data.discount);
					$("[item-id=goods-introduction]").html(data.introduction);
					
					if(data.remainingNumber > 0) {
						$("[item-id=button-join]").click(function() {
							location.href = ctx + "/web/memberlife/mall/goods-order.jsp?goodsId=" + data.id + "&d=" + d;
						});
					}
					
				}
			}
		});
	}
	
 	$().ready(function() {
 		loadGoods();
 		
 	});
})
</script>
</body>
</html>