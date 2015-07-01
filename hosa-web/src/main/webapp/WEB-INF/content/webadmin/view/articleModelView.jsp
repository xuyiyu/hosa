<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script src="${ctx}/js/jquery/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx = '${ctx}';
</script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link href="${ctx}/css/webStyle/news1_2.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/webStyle/index.css">
 <script>

	
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
	$("#article_name").html(request['title']);
	$("#create_date").html(request['createDate']);
	$("#article_content").html(request['content']);

	if(request['picUrl']!=''){
			var aObj = $("<a href='"+request['picLink']+"' target='_black'></a>").html("<img src='"+ctx+request['picUrl']+"'>");
			$('.showpic').html(aObj);
	}

});
</script>
<style>

 

</style>
<link type="text/css" rel="stylesheet" href="chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/style.css"><script type="text/javascript" charset="utf-8" src="chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/js/page_context.js"></script></head> 
<body id="news" screen_capture_injected="true" style="width:250px;">
<div class="tr_right" id="listhome1" class='table table-striped table-bordered table-hover table-ellipsis smart-form'>
<div id="mcover" onclick="document.getElementById(&#39;mcover&#39;).style.display=&#39;&#39;;"><img src="${ctx}/img/iphoneView/guide.png"></div>	
<div id="ui-header" style="display:block">
<div class="fixed">
<a class="ui-btn-left_pre" href="javascript:void(0);" id='gocategory'></a>
<a class="ui-btn-right_home" href="${ctx}/web/index.jsp"></a>
</div>
</div>
<div id="overlay"></div>
<div id="win">
</div>
<div class="Listpage"style="margin-top: 30px;">
<div class="top46"></div>
<div class="page-bizinfo">
<div class="header" style="position: relative;"><h1 id="article_name" class="pageTitle"></h1><span id="create_date"></span></div>
<a id="biz-link" class="btn" href="weixin://contacts/profile/skiingworld" target="_blank" data-transition="slide">
<div class="arrow">
<div class="icons arrow-r"></div>
</div>
<div class="logo">
<div class="circle"></div>
<img id="img" src="${ctx}/img/iphoneView/20140129231556_73765.jpg">
</div>
<div id="nickname">
北京雪世界滑雪场</div>
<div id="weixinid">微信号:skiingworld</div>
</a>
<div class="showpic"></div>
 
<div class="text" id="content">
<p class="MsoNormal" id="article_content">

</p>
<div id="insert3"></div>
</div>
				
<div id="mess_share">
<div id="share_1">
<button class="button2" onclick="document.getElementById(&#39;mcover&#39;).style.display=&#39;block&#39;;"><img src="${ctx}/img/iphoneView/icon_msg.png" style="display:inline;">&nbsp;发送给朋友</button>
</div>
<div id="share_2">
<button class="button2" onclick="document.getElementById(&#39;mcover&#39;).style.display=&#39;block&#39;;"><img src="${ctx}/img/iphoneView/icon_timeline.png" style="display:inline;">&nbsp;分享到朋友圈</button>
</div>
<div class="clr"></div>
</div>					
<div class="page-content">

</div>



</div>	
    <div class="list">
<div id="oldlist">
   <a class="more" href="javascript:void(0);" id="moreContent">更多精彩内容</a>	</div>
</div>
    
<a class="footer" href="javascript:void(0);" onclick="window.scrollTo(0,0);return false;" target="_self"><span class="top">返回顶部</span></a>


    
 
<div style="display:none"> </div>
</div>
 <script type="text/javascript">
 	        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
       window.shareData = {  
           "imgUrl": "http://119.255.34.210/xueshijie/activity/img/20140213114526_53643.jpg", 
            "timeLineLink": 'http://119.255.34.210/xueshijie/activity/4-1.jsp',
            "sendFriendLink": 'http://119.255.34.210/xueshijie/activity/4-1.jsp',
            "weiboLink": 'http://119.255.34.210/xueshijie/activity/4-1.jsp',
            "tTitle": "元宵情人节抽奖活动",
            "tContent": "动动您的拇指，扫一扫雪世界二维码，惊喜等您来拿！点击图片，查看活动详情。",
            "fTitle": "元宵情人节抽奖活动",
            "fContent": "动动您的拇指，扫一扫雪世界二维码，惊喜等您来拿！点击图片，查看活动详情。",
            "wContent": "动动您的拇指，扫一扫雪世界二维码，惊喜等您来拿！点击图片，查看活动详情。" 
        };
        // 发送给好友
        WeixinJSBridge.on('menu:share:appmessage', function (argv) {
            WeixinJSBridge.invoke('sendAppMessage', { 
                "img_url": window.shareData.imgUrl,
                "img_width": "640",
                "img_height": "640",
                "link": window.shareData.sendFriendLink,
                "desc": window.shareData.fContent,
                "title": window.shareData.fTitle
            }, function (res) {
                _report('send_msg', res.err_msg);
            })
        });

        // 分享到朋友圈
        WeixinJSBridge.on('menu:share:timeline', function (argv) {
            WeixinJSBridge.invoke('shareTimeline', {
                "img_url": window.shareData.imgUrl,
                "img_width": "640",
                "img_height": "640",
                "link": window.shareData.timeLineLink,
                "desc": window.shareData.tContent,
                "title": window.shareData.tTitle
            }, function (res) {
                _report('timeline', res.err_msg);
            });
        });

        // 分享到微博
        WeixinJSBridge.on('menu:share:weibo', function (argv) {
            WeixinJSBridge.invoke('shareWeibo', {
                "content": window.shareData.wContent,
                "url": window.shareData.weiboLink,
            }, function (res) {
                _report('weibo', res.err_msg);
            });
        });
        }, false);
    </script>
          </div>        
</body></html>