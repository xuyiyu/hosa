<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>
<script>
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
	var url = ctx + "/web/library/queryQuestionAnswerList.htm";
	var param ={'questionAnswer.categoryId':request['id']};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('.paddinfo').html('');
				$.each(data,function(i,o){
				    var index = i+1;
					var html = '<span class="red" style="margin-right:5px;">'+index+'</span>'+o.question+'<img src="'+ctx+'/web/images/more1.png" class="more1">';
					$('<div class="top-block block-select"></div>').click(function(){
						window.location.href = ctx +'/web/afterservice/library/answer.jsp?id='+o.id;
					}).html(html).appendTo($('.paddinfo'));
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
<a href=""><img src="${ctx}/web/images/mc-cxhdflash.jpg" /></a>
</section>
<section class=" paddinfo">
</section>
</body>
</html>
