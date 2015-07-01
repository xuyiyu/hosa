<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
<script src="${ctx}/js/plugin/jquery-qrcode/jquery.qrcode.min.js"></script>
</head>
<script type="text/javascript">
$(function(){
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

	var url = ctx + "/web/baideli/coupons/input.htm";
	var param = {'id':request['id']};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			$('#name').html('');
			$('#valid').html('');
			$('#value').html('');
			if(data) {
				 //var date = new Date(data.valid);
				 //  date.setDate(date.getDate()+data.validDays);
				 // var vaDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
				$('#name').html(data.name);
				var valid =data.validString==null?'':data.validString;
				$('#valid').html('有效期至：'+valid);
				if(data.type=='1'){
					$('#value').html('￥ '+data.value);//+data.value
				}
				
			}
			$('#gcode').qrcode({
				render: "table", //table方式
				width: 200, //宽度
				height:200, //高度
				text: $.toUtf8(data.code)
			});
		}
	});
	
	
});
</script>
<body class="mainbg"  style="background:#eee;">
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
<section class=" paddinfo" style=" background:#473848;">
<ul class="listcon1">
<li>
<div class="fl confont" style="margin-top:2%;"><h4 id="name"></h4>
<p style="color:#fff;" id="valid"></p>
</div>
<div class="clear"></div>
</li>
<div class="yhqbg">
<p  class="moreimg1" style="color:#fff; padding-top:20%; text-align:left;" id="value"></p>
</div>
<div class="clear"></div>
</ul>

</section>
<div id="gcode" style="margin:20px auto;width: 200px; height: 200px;"></div>
<section class=" mc24-3"  >
<a class="submit-btn" href="${ctx }/web/index.jsp" style="margin-top: 10%;">返回首页</a>
</section>

</body>
</html>