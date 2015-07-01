<%@ page contentType="text/html;charset=UTF-8"%>
<script src="${ctx}/js/jquery/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery.custom.hashmap.js" type="text/javascript"></script>
<script src="${ctx}/js/core.js"></script>
<script src="${ctx}/js/jquery.custom.js"></script>
<script src="${ctx}/js/jquery.validate.ext.js"></script>

<script src="${ctx}/js/plugin/jquery-validate/jquery.validate.min.js"></script>
<script src="${ctx}/js/plugin/jquery-validate/messages_zh.js"></script>

<link href="${ctx}/js/plugin/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet">
<script src="${ctx}/js/plugin/jquery-file-upload/vendor/jquery.ui.widget.js"></script>
<script src="${ctx}/js/plugin/jquery-file-upload/jquery.fileupload.js"></script>
<script src="${ctx}/js/plugin/jquery-file-upload/jquery.iframe-transport.js"></script>

<script src="${ctx}/js/plugin/spin/spin.min.js"></script>

<!-- DATETIME -->
<script src="${ctx}/js/bootstrap/bootstrap.min.js"></script>
	<script src="${ctx}/js/bootstrap/bootstrap-datetimepicker.js"></script>
    <script src="${ctx}/js/bootstrap/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" href="${ctx}/js/bootstrap/datetimepicker/bootstrap-datetimepicker.min.css"/>
<script type="text/javascript">
var ctx = '${ctx}';

var d = "${sessionScope.webUser.rootDepartmentId}";
var userId = "${sessionScope.webUser.userId}";
var userName = "${sessionScope.webUser.userName}";
var openId = "${sessionScope.webUser.openId}";
var userMobile = "${sessionScope.webUser.userMobile}";
var userPlate = "${sessionScope.webUser.userPlate}";
</script>


<style>
#mcover {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
background: rgba(0, 0, 0, 0.7);
display: none;
z-index: 20000;
}
</style>
<div id="mcover" onclick="document.getElementById('mcover').style.display='';"><img src="${ctx}/web/images/guide.png"></div>
<!--小浮层-->
<section id="fuchen" class="fuchen hide">
<ul>
<li><em></em>
<p><a name="consult" href="javascript:void();" style="display:none;"><img src="${ctx}/web/images/tou.png">咨询顾问</p></a>
<a  href="tel:010-58739000"><img src="${ctx}/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
<section class="tanchuposition" style="z-index:100000;display:none;" id="prompt-layer" >
<div class="tanchu">
<p style="text-align:center; line-height:44px;" name="prompt-msg"></p>
<a href="javascript:void(0);" class="ok-submit">确认</a>
</div>
</section>

<section class="tanchuposition" id="consult-prompt-layer" style="z-index:100000;display:none;">
<img style="margin-top:20%;" src="${ctx}/web/images/textinfo.png"  >
</section>


<script>
var myalert = function(msg){
		console.log("---"+msg);
		$('#prompt-layer').show();
		$('#prompt-layer').find("[name=prompt-msg]").text(msg);
	}
	$('#prompt-layer').find(".ok-submit").click(function(){
		$('#prompt-layer').hide();
		$('#prompt-layer').find("[name=prompt-msg]").text("");
	});
	$("#consult-prompt-layer").click(function(){
		$("#consult-prompt-layer").hide();
	});

$(function() {
	$("a").click(function() {
		if($(this).text() == "分享朋友圈") {
			$("#mcover").show();
		} else if($(this).text() == "车型中心") {
			location.href= ctx + "/web/saleonline/model/serie-list.jsp?d=" + d;
		} else if($(this).text() == "促销活动") {
			location.href= ctx + "/web/saleonline/activity/index.jsp?d=" + d;
		}else if($(this).text() == "预约试驾") {
			location.href= ctx + "/web/saleonline/testdrive/index.jsp?d=" + d;
		}else if($(this).text() == "车行助手") {
			location.href= ctx + "/web/saleonline/assistant/index.jsp?d=" + d;
		}
		
		else if($(this).text() == "售后预约") {
			location.href= ctx + "/web/afterservice/reservation/list.jsp?d=" + d;
		}
		else if($(this).text() == "24小时救援") {
			location.href= ctx + "/web/afterservice/rescue/rescue-list.jsp?d=" + d;
		}
		else if($(this).text() == "售后活动") {
			location.href= ctx + "/web/afterservice/activity/index.jsp?d=" + d;
		}
		else if($(this).text() == "专家知识库") {
			location.href= ctx + "/web/afterservice/library/library-list.jsp?d=" + d;
		}
		
		else if($(this).text() == "专享信息") {
			location.href= ctx + "/web/memberlife/exclusive/exclusive-member.jsp?d=" + d;
		}
		else if($(this).text() == "精品汇") {
			location.href= ctx + "/web/memberlife/mall/index.jsp?d=" + d;
		}
		else if($(this).text() == "私人车助理") {
			location.href= ctx + "/web/memberlife/assistant/assistant-list.jsp?d=" + d;
		}
		else if($(this).text() == "会员卡信息") {
			location.href= ctx + "/web/memberlife/membercar/membercar-info.jsp?d=" + d;
		}
		else if($(this).text() == "返回首页") {
			location.href= ctx + "/web/index.jsp?d=" + d;
		}
		
		else if($(this).text() == "条件自选") {
			location.href= ctx + "/web/saleonline/model/search-list.jsp?d=" + d;
		}
		else if($(this).text() == "快速找车") {
			location.href= ctx + "/web/saleonline/model/car-price.jsp?d=" + d;
		}
		else if($(this).text() == "按车型找车") {
			location.href= ctx + "/web/saleonline/model/serie-searchlist.jsp?d=" + d;
		}
	});
	
	$("[name=menu]").click(function(){
		$("#fuchen").toggle();
	});
	if(userId){
	
	$("[name=consult]").click(function(){
		$.webAjax(ctx+"/web/wx/sendmenu.htm?d="+d, {}, function(responseData) {
			if(responseData == "success"){
				$("#fuchen").hide();
				$("#consult-prompt-layer").show();
			}else{
				myalert(responseData);
			}
			
			//myalert("已通过微信方式进入人工服务，请回到微信聊天页面查看");
			
		});
	}).show();
	}
});
	
</script>