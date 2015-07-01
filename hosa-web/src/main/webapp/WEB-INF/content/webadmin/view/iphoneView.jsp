<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/iphoneView.css"></link>
<title>无标题文档</title>
<script src="${ctx}/js/jquery/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx = '${ctx}';
</script>
<script>
	function callBackClose(){
		parent.closeIphoneViewModal();
	}
	
	/* function GetRequest() {
	   var url = location.search; //获取url中"?"符后的字串
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
	var param = 'title='+request['title']+"&content="+request['content']+"&picUrl="+request['picUrl'];
	var viewurl = ctx+"/webadmin/view/articleModelView.htm"+"?"+param; */

$(function() {
	
	//var request = new Object();
	//request = GetRequest();
	//var param = 'title='+request['title']+"&content="+request['content']+"&picUrl="+request['picUrl'];
	var viewurl = ctx+"/webadmin/view/articleModelView.htm"+"?"+location.search;
	$('#ifr').attr('src',viewurl);
});
</script>

</head>
<body>
<div id="lightview" style="z-index: 5000;   position: fixed;   width: 311px; height: 520px;">
  <div class="lv_Container" style="z-index: 5001;">
  <img class="imgesalign" onclick='callBackClose();' src="${ctx }/img/iphoneView/close_small.png"/>
  <div class="iphone">
  <div class="iphonetitle">盈讯动力</div>
  <div id="ifrDiv" class="iphonecontern">
  	<iframe frameborder="0" id="ifr"  hspace="0" src="${ctx }/webadmin/view/articleModelView.htm" id="lightviewContent" name="lightviewContent_80816" scrolling="auto" style="border: 0px; margin: 0px; padding: 0px;width: 100%; height: 100%;"></iframe>
  </div>
  </div>
   </div>
</div>
</body>
</html>