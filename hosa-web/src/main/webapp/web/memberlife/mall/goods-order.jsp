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

<!-- 
<section class="linearbg"  style="background:#efefef; min-height:125px;">
<img item-id="goods-pic"  src="${ctx}/web/images/mc-jph4_1.png" class="productimg">
<ul style="border:none;">
<li style="color:#595757; border:none; margin-top:3%;" item-id="goods-name"></li>
<li style="color:red;border:none;" item-id="goods-remainingNumber"><span style="margin-left:80%;">&gt;</span></li>
<li  style="color:#b5b5b6;border:none;" item-id="goods-code"></li>
<li  style="color:#b5b5b6;border:none;">数量：<input type="tel" class="price-box" value="1" id="number"><span style="color:red;" item-id="price"></span></li>
</ul>
</section>
 -->
<section>
<a href="javascript:void(0);"><img item-id="goods-pic" src=""></a>
</section>
<section class="proinfo">
<p class="plineheight" style="font-size:1.4rem;" item-id="goods-name"></p>
<ul><li style="color:#b5b5b6;border:none;">数量：<input type="tel" class="price-box" value="1" id="number"><span style="color:red;" item-id="goods-remainingNumber"></span></li></ul><p></p>
<a class="jia" item-id="price"></a><span style=" margin-top:5px;" item-id="goods-code"></span>
</section>


<section >
<div class="top-block top-inter" ><span>优惠券</span><img  src="${ctx}/web/images/mc-jph4_2.png"  class="cardsmall"/><input  type="radio" name="attach" value="1" style="margin-right:10%; margin-top:4px;"/><a><img  src="${ctx}/web/images/more1.png" class="more1"/></a></div>
</section>
<section >
<div class="top-block top-inter" ><span>积分兑换</span><img src="${ctx}/web/images/mc-jph4_5.png" class="cardsmall"/><input  type="radio" name="attach" value="2" style="margin-right:10%; margin-top:4px;"/><a><img  src="${ctx}/web/images/more1.png" class="more1"/></a></div>
</section>

<section class="top-block top-inter" >
<div><span >商品金额</span><a style="color:red; margin-right:3%;" item-id="price"></a></div>
<div style="display:none;" item-id="discount"><span item-id="discount-name">使用优惠劵</span><a style="color:red; margin-right:3%;" item-id="discount-price"></a></div>
<div ><span>折扣力度</span><a style="color:red; margin-right:3%;" item-id="discount-strength"></a></div>
</section>

<section class="jiesuan">
应付总额：<a style="color:red; margin-right:3%;" item-id="transaction-price"></a>
<input type="hidden" id="goodsId"/>
<input type="hidden" id="price"/>
<input type="hidden" id="discountPrice"/>
<input type="hidden" id="transactionPrice"/>
<input type="hidden" id="integral"/>
<input type="hidden" id="couponId"/>
<a class="ok-submit" item-id="button-buy" href="javascript:void(0);" style="width:25%; display:inline-block; margin:2% auto; margin-left:30%;">去结算</a>
</section>
<script>

$(function() {
	var loadGoods = function() {
		var goodsId = "${param.goodsId}";
		
		if(!goodsId) {
			return;
		}
		$("#goodsId").val(goodsId);
		var param = {};
		param["id"] = goodsId;
		var goodsUrl = ctx + "/web/mall/mall!input.htm";
		$.get(goodsUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				console.debug(data);
				if(data) {
					$("[item-id=goods-pic]").attr("src", data.picUrl);
					$("[item-id=goods-name]").html(data.name);
					$("[item-id=goods-price]").text(data.price);
					$("[item-id=goods-code]").text("编号：" + data.code);
					$("[item-id=goods-discount-price]").text(data.price * data.discount);
					$("[item-id=goods-introduction]").html(data.introduction);
					
					if(data.remainingNumber > 0) {
						$("[item-id=goods-remainingNumber]").html("有货");
						$("[item-id=button-join]").click(function() {
							location.href = ctx + "/web/memberlife/mall/goods-order.jsp?goodsId=" + data.id + "&d=" + d;
						});
						$("#number").keyup(function() {
							summary(data);
						});
					
						
						$("#number").trigger("keyup");
						
						$("[name=attach]").click(function() {
							var val = $(this).val();
							$("#discountPrice").val(30);
							
							if(val == 1) {
								$("[item-id=discount-name]").text("使用优惠劵");
								$("#couponId").val(1);
								$("#integral").val("");
							} else if(val == 2) {
								$("[item-id=discount-name]").text("积分兑换");
								$("#integral").val(30);
								$("#couponId").val("");
							}
							
							summary(data);
							$("[item-id=discount]").show();
						});
						
						$("[item-id=button-buy]").click(function() {
							buy();
						});
					} else {
						$("[item-id=goods-remainingNumber]").html("无货");
						$("#number").val(0);
					}
					
					
					
				}
			}
		});
	}
	
	var summary = function(data) {
		$("#price").val($("#number").val() * data.price * data.discount);
		$("#transactionPrice").val($("#price").val() - $("#discountPrice").val());
		
		$("[item-id=price]").text(" ￥ " + Math.ceil($("#number").val() * data.price * data.discount));		
		$("[item-id=transaction-price]").html($("#transactionPrice").val());
		if($("#discountPrice").val() != "") {
			$("[item-id=discount-price]").html(" ￥  -" + $("#discountPrice").val());		
			var re = /([0-9]+.[0-9]{2})[0-9]*/;
			var p = 10-$("#discountPrice").val()/$("#price").val()*10;
			console.debug(p);
			var aNew = Math.round(p*100)/100;
			$("[item-id=discount-strength]").html( aNew + "折");
		}
	}
	
	var buy = function() {
		var goodsId = "${param.goodsId}";
		if(!goodsId) {
			return;
		}
		var param = {};
		param["goodsOrder.goodsId"] = $("#goodsId").val();
		param["goodsOrder.goodsQuantity"] = $("#number").val();
		param["goodsOrder.integral"] = $("#integral").val();
		param["goodsOrder.couponId"] = $("#couponId").val();
		var goodsUrl = ctx + "/web/mall/mall!buy.htm";
		$.get(goodsUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				console.debug(data);
				if(data) {
					if(data.code) {
						location.href = ctx + "/web/memberlife/mall/goods-result.jsp?d=" + d + "&code=" + data.code;
					}
				}
			} else {
				location.href = ctx + "/web/memberlife/mall/goods-result.jsp?d=" + d + "&error=" + responseData.r_info;
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