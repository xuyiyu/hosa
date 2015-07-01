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
	var url = ctx + "/web/baideli/getCouponListByUserId.htm";
	var param = {'couponUsedRecordsQuery.userId':userId};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			$('.listcon1').html('');
			if(data) {
				$.each(data,function(i,o){
				    //var date = new Date(o.valid);
				    //date.setDate(date.getDate()+o.validDays);
				    //var vaDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
				 	var valid= o.validString==null?'':o.validString;
				 	var html = '<div class="fl confont" style="margin-top:2%;"><h4>'+o.name+'</h4>';
					html += '<p style="color:#fff;">有效期至：'+valid+'</p></div>';
					if(o.type=='1'){
						html +='<span class="moreimg1 fr">￥ '+o.value+'</span>';
					}
					html +='<div class="clear"></div>';
					$('<li></li>').click(function(){
						window.location.href=ctx+'/web/memberlife/membercar/coupons-info.jsp?id='+o.id+'&d='+d;
					}).html(html).appendTo($('.listcon1'));
					
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
<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li class="navactive"><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>
<section class=" paddinfo">
<ul class="listcon1">
</ul>

</section>
</body>
</html>
