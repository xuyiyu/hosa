<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>SmartAdmin</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/font-awesome.min.css">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/smartadmin-production.css">

<!-- SmartAdmin RTL Support is under construction
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/custom.css">

<!-- FAVICONS -->
<link rel="shortcut icon" href="${ctx}/img/favicon/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="${ctx}/img/favicon/favicon.ico"
	type="image/x-icon">

<!-- GOOGLE FONT 
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">-->
<%@ include file="/commons/i18n.jsp"%>

<script type="text/javascript">
	var ctx = '${ctx}';
	</script>
</head>
<body class="">
	<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

	<!-- HEADER -->
	<header id="header">
		<div id="logo-group">

			<!-- PLACE YOUR LOGO HERE -->
			<span id="logo"> <img src="${ctx}/img/logo_bdl.png"
				alt="SmartAdmin">
			</span>
			<!-- END LOGO PLACEHOLDER -->

		</div>


		<div id="left-group" class="pull-left chat-listener">
			<span class="activity"> <i class="fa fa-user"></i> <b
				class="badge" cnt="0">0 </b>
			</span>
		</div>
		<!-- pulled right: nav area -->
		<div class="pull-right">



			<!-- logout button -->
			<div id="logout" class="btn-header transparent pull-right">
				<span> <a href="${ctx}/webadmin/logout.htm" title="登出"><i
						class="fa fa-sign-out"></i></a>
				</span>
			</div>
			<!-- end logout button -->

			<!-- collapse menu button -->
			<div id="hide-menu" class="btn-header pull-right">
				<span> <a href="javascript:void(0);" title="Collapse Menu"><i
						class="fa fa-resize-full"></i></a>
				</span>
			</div>
			<!-- end collapse menu -->


		</div>
		<!-- end pulled right: nav area -->

	</header>
	<!-- END HEADER -->

	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->
	<aside id="left-panel">

		<!-- User info -->
		<div class="login-info">
			<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

				<a href="javascript:void(0);"> <img
					src="<shiro:principal property="headImageUrl"/>" alt="me"
					class="online" /> <span> <shiro:principal property="name" />
				</span>
			</a>

			</span>
		</div>
		<!-- end user info -->
		


		<nav id="main-menu"></nav>
		<span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i>
		</span>

	</aside>
	<!-- END NAVIGATION -->

	<!-- MAIN PANEL -->
	<div id="main" role="main" >
		<!-- RIBBON -->
		<div id="ribbon">
			<!-- 
			<span class="ribbon-button-alignment"> <span id="refresh"
				class="btn btn-ribbon" data-title="refresh" rel="tooltip"
				data-placement="bottom"
				data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings."
				data-html="true"><i class="fa fa-refresh"></i></span>
			</span>
 			-->
			<!-- breadcrumb -->
			<ol class="breadcrumb">
			</ol>
			<!-- end breadcrumb -->

			<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

		</div>
		<!-- END RIBBON -->


	</div>
	<!-- END MAIN PANEL -->
<div id="loading" class="backdrop fade in" style="display: none;"></div>
	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="${ctx}/js/plugin/pace/pace.min.js"></script>

	<script src="${ctx}/js/jquery/jquery-1.11.0.min.js"></script>

	<script src="${ctx}/js/jquery/jquery-ui-1.10.3.min.js"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

	<!-- BOOTSTRAP JS -->
	<script src="${ctx}/js/bootstrap/bootstrap.min.js"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script src="${ctx}/js/notification/SmartNotification.min.js"></script>

	<!-- JARVIS WIDGETS -->
	<script src="${ctx}/js/smartwidgets/jarvis.widget.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="${ctx}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script src="${ctx}/js/plugin/jquery-validate/jquery.validate.min.js"></script>
	<script src="${ctx}/js/plugin/jquery-validate/messages_zh.js"></script>
	<script src="${ctx}/js/jquery.validate.ext.js"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script src="${ctx}/js/plugin/select2/select2.min.js"></script>
	<script src="${ctx}/js/plugin/select2/select2_locale_zh-CN.js"></script>	

	<!-- JQUERY NOTYFY -->
	<script src="${ctx}/js/plugin/notyfy/jquery.noty.packaged.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script src="${ctx}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script src="${ctx}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices -->
	<script src="${ctx}/js/plugin/fastclick/fastclick.js"></script>
	
	<!-- SUMMERNOTE -->
	<script src="${ctx}/js/plugin/summernote/summernote.js"></script>
	
	<!-- LIST -->
	<script src="${ctx}/js/plugin/list/list.min.js"></script>
	<script src="${ctx}/js/plugin/list/list.fuzzysearch.min.js"></script>
		
	<!-- SPIN -->
	<script src="${ctx}/js/plugin/spin/spin.min.js"></script>
	
	<!-- SPIN -->
	<link href="${ctx}/js/plugin/nailthumb/jquery.nailthumb.1.1.min.css" rel="stylesheet">
	<script src="${ctx}/js/plugin/nailthumb/jquery.nailthumb.1.1.min.js"></script>
	
	<script src="${ctx}/js/plugin/imgpreload/jquery.imgpreload.min.js"></script>
	
	<!-- UPLOAD -->
	<link href="${ctx}/js/plugin/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet">
	 <script src="${ctx}/js/plugin/jquery-file-upload/vendor/jquery.ui.widget.js"></script>
	 <script src="${ctx}/js/plugin/jquery-file-upload/jquery.iframe-transport.js"></script>
	<script src="${ctx}/js/plugin/jquery-file-upload/jquery.fileupload.js"></script>
	
	<!-- PLUGIN -->
	<script src="${ctx}/js/plugin/x-editable/moment.min.js"></script>
		<script src="${ctx}/js/plugin/x-editable/jquery.mockjax.min.js"></script>
	<script src="${ctx}/js/plugin/x-editable/x-editable.min.js"></script>
	
	<script src="${ctx}/js/plugin/jquery-qrcode/jquery.qrcode.min.js"></script>
	
	<!-- PAGE RELATED PLUGIN(S) -->
	<script src="${ctx}/js/plugin/jquery-nestable/jquery.nestable.js"></script>
		
	<!-- DATETIME -->
	<script src="${ctx}/js/bootstrap/bootstrap-datetimepicker.js"></script>
    <script src="${ctx}/js/bootstrap/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" href="${ctx}/js/bootstrap/datetimepicker/bootstrap-datetimepicker.min.css"/>
    
	<!-- JQUERY CUSTOM -->
	<script src="${ctx}/js/jquery.custom.hashmap.js"></script>
	<script src="${ctx}/js/jquery.custom.js"></script>
	<script src="${ctx}/js/paging/jquery.paging.js"></script>

	
	<!-- APP -->
	<script src="${ctx}/js/core.js"></script>
	
	<!-- COMETD -->
	<script src="${ctx}/js/cometd/org/cometd.js" type="text/javascript"></script>
	<script src="${ctx}/js/cometd/org/cometd/AckExtension.js" type="text/javascript"></script>
	<script src="${ctx}/js/cometd/org/cometd/ReloadExtension.js" type="text/javascript"></script>
	<script src="${ctx}/js/cometd/json2.js" type="text/javascript"></script>
	<script src="${ctx}/js/cometd/jquery.cometd.js" type="text/javascript"></script>
	<script src="${ctx}/js/cometd/jquery.cometd-reload.js" type="text/javascript"></script>

	<script src="${ctx}/js/platform/init/chat.js" type="text/javascript"></script>
	<script src="${ctx}/js/platform/init/chat.listener.js" type="text/javascript"></script>
	<script src="${ctx}/js/platform/init/top.js" type="text/javascript"></script>
	
	
	
	<!--[if IE 7]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

	<script type="text/javascript">
		var loginId =  '<shiro:principal property="loginId"/>'; //当前登录座席用户名
		
		var tenantId = '<shiro:principal property="rootDepartmentId"/>';
		
		var headImageUrl = '<shiro:principal property="headImageUrl"/>';
		
		$(function() {
			
			var loadMainMenu = function() {
				$("#main-menu").load("menu.htm", {}, function() {
					
					$("#main-menu ul").jarvismenu({
						accordion : true,
						speed : $.menu_speed,
						closedSign : "<em class='fa fa-expand-o'></em>",
						openedSign : "<em class='fa fa-collapse-o'></em>"
					});
					
					$(document).on("click", "#main-menu a[data-href]", function() {
						var url = $(this).attr("data-href");
						var name = $(this).attr("data-name");
						var text = $.trim($(this).text());
						
						$("#main-menu li").removeClass("active");
						$(this).parent().addClass("active");
						loadMainContent(url, name, text);
						
						var categoryText = $(this).parents("ul").prev("a").text();
						$.bread_crumb.html("");
						$.bread_crumb.append("<li>"+categoryText+"</li>");
						$.bread_crumb.append("<li>"+text+"</li>");
						return false;
					});
					
					$("#main-menu .data-default").trigger("click");
				});
			}
			
			
			$().ready(function() {
				
				loadMainMenu();
				
				
			});
		});
		</script>


</body>

</html>