<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>百得利-车型助手</title>
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
	
	var queryUrl = ctx + "/web/order/getOrderById.htm";
	var param = {'id':request['id']};
	$.webAjax(queryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				var code = data.code==null?'':data.code;
				$('<p></p>').html('订单号：'+code).appendTo($('.paddinfo'));
		   		$('<p></p>').html('订单日期：'+data.createdAtString).appendTo($('.paddinfo'));
				var name = data.user==null?'':data.user.name;
				$('<p></p>').html('订购人：'+name).appendTo($('.paddinfo'));
				var mobile = data.user==null?'':data.user.mobile;
				$('<p></p>').html('订购人电话：'+mobile).appendTo($('.paddinfo'));
				$('<p></p>').html('收货地址:').appendTo($('.paddinfo'));
				$('<div class="clear"></div>').appendTo($('.paddinfo'));
				$('<p></p>').html('支付方式：在线支付').appendTo($('.paddinfo'));
				$('<div class="clear"></div>').appendTo($('.paddinfo'));
				$('<p></p>').html('商品金额：'+data.price).appendTo($('.paddinfo'));
				var value= data.coupon==null?'':data.coupon.value;
		   		$('<p></p>').html('优惠券抵扣：￥ 30').appendTo($('.paddinfo'));
				$('<p></p>').html('积分抵扣:').appendTo($('.paddinfo'));
				$('<p></p>').html('运费:').appendTo($('.paddinfo'));
				$('<div class="clear"></div>').appendTo($('.paddinfo'));
				$('<p></p>').html('应支付金额:'+data.transactionPrice).appendTo($('.paddinfo'));
				$('<div class="clear"></div>').appendTo($('.paddinfo'));
				$('<p></p>').html('配送信息').appendTo($('.paddinfo'));
		   		$('<p></p>').html('配送方式:').appendTo($('.paddinfo'));
				$('<p></p>').html('送货时间:').appendTo($('.paddinfo'));
				$('<p></p>').html('配送时间:').appendTo($('.paddinfo'));
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
<ul class="navli clearFix">
		<li class="navactive"><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>

<h3 class="form-title">订单详情</h3>
	<section class="paddinfo ksz5">
</section>

<a href="#" class="ok-submit">返回首页</a>
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
