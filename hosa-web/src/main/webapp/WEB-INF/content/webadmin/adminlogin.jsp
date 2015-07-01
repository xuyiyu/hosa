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

<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/custom.css">
<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->


<!-- FAVICONS -->
<link rel="shortcut icon" href="${ctx}/img/favicon/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="${ctx}/img/favicon/favicon.ico"
	type="image/x-icon">

<!-- GOOGLE FONT 
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
-->
<script type="text/javascript">
	var ctx = '${ctx}';
	</script>
</head>
<body id="login" class="animated fadeInDown">
	<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
	<header id="header">
		<!--<span id="logo"></span>-->

		<div id="logo-group">
			<span id="logo"> <img src="${ctx}/img/logo.png" alt="SmartAdmin">
			</span>

			<!-- END AJAX-DROPDOWN -->
		</div>

		<span id="login-header-space" style="display:none;"> <span class="hidden-mobile">Need
				an account?</span> <a href="javascript:void(0);" class="btn btn-danger">Creat
				account</a>
		</span>

	</header>

	<div id="main" role="main">

		<!-- MAIN CONTENT -->
		<div id="content" class="container">

			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
					<h1 class="txt-color-red login-header-big">SmartAdmin</h1>
					<div class="hero">

						<div class="pull-left login-desc-box-l">
							<h4 class="paragraph-header">It's Okay to be Smart.
								Experience the simplicity of SmartAdmin, everywhere you go!</h4>
							<div class="login-app-icons">
								<a href="javascript:void(0);" class="btn btn-danger btn-sm">Frontend
									Template</a> <a href="javascript:void(0);"
									class="btn btn-danger btn-sm">Find out more</a>
							</div>
						</div>

						<img src="${ctx}/img/demo/iphoneview.png"
							class="pull-right display-image" alt="" style="width:210px">

					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">About SmartAdmin - Are you up to
								date?</h5>
							<p>Sed ut perspiciatis unde omnis iste natus error sit
								voluptatem accusantium doloremque laudantium, totam rem aperiam,
								eaque ipsa.</p>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">Not just your average template!</h5>
							<p>Et harum quidem rerum facilis est et expedita distinctio.
								Nam libero tempore, cum soluta nobis est eligendi voluptatem
								accusantium!</p>
						</div>
					</div>

				</div>
				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form action="${ctx}/webadmin/login.htm" id="login-form" method="post"
							class="smart-form client-form">
							<input id="authenticity_token"	name="authenticity_token" type="hidden"
							value="${authenticity_token}">
							<header> 登入系统 </header>

							<fieldset>

								<section>
									<label class="label">用户名</label> <label class="input">
										<i class="icon-append fa fa-user"></i> <input id="j_username" type="text"
										name="j_username"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-user txt-color-teal"></i> 请输入用户名或密码</b>
									</label>
								</section>

								<section>
									<label class="label">密码</label> <label class="input">
										<i class="icon-append fa fa-lock"></i> <input id="j_password" type="password"
										name="j_password"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-lock txt-color-teal"></i> 请输入密码</b>
									</label>
								</section>
								
								<section>
									<label class="label">验证码</label> <label class="input">
										<i class="icon-append fa fa-picture-o"></i> <input id="j_code" type="text"
										name="j_code"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-picture-o txt-color-teal"></i> 请输入验证码</b>
									</label>
									<div class="note">
									<img id="validateCodeImg"
										src="${ctx }/commons/validateCodeServlet.do?t=${authenticity_token}"
										width="100" height="40" border="0" align="absmiddle" /> <a
										id="button-refresh-captcha" class="btn btn-boo" href="javascript:void(0);">看不清？</a>
									</div>
									<div class="note" style="display:none;">
										<a href="forgotpassword.html">忘记密码?</a>
									</div>
								</section>

								<section style="display:none;">
									<label class="checkbox"> <input type="checkbox"
										name="remember" checked=""> <i></i>记住登入状态
									</label>
								</section>
							</fieldset>
							<footer>
								<button id="button-login" type="button" class="btn btn-primary">登入</button>
							</footer>
						</form>

					</div>

					<h5 class="text-center">- Or sign in using -</h5>

					<ul class="list-inline text-center">
						<li><a href="javascript:void(0);"
							class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
						</li>
						<li><a href="javascript:void(0);"
							class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a>
						</li>
						<li><a href="javascript:void(0);"
							class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
						</li>
					</ul>

				</div>
			</div>
		</div>

	</div>
<div id="loading" class="backdrop fade in" style="display:none;"></div>
	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script src="${ctx}/js/plugin/pace/pace.min.js"></script>

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

	<!-- JQUERY SELECT2 INPUT -->
	<script src="${ctx}/js/plugin/select2/select2.min.js"></script>
	
	<!-- JQUERY NOTYFY -->
	<script src="${ctx}/js/plugin/notyfy/jquery.noty.packaged.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script src="${ctx}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script src="${ctx}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices -->
	<script src="${ctx}/js/plugin/fastclick/fastclick.js"></script>
	
	<!-- SPIN -->
	<script src="${ctx}/js/plugin/spin/spin.min.js"></script>
	
	<!-- JQUERY CUSTOM -->
	<script src="${ctx}/js/jquery.custom.js"></script>

	<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

	<!-- MAIN APP JS FILE -->

	<script type="text/javascript">

			$(function() {
				var login = function() {
					if(!verify()) {
						return;
					}
					$("#login-form").submit();
				}
				var verify = function() {
					
					 $("#login-form").validate({
						onsubmit:false ,
						rules : {
							j_username : {
								required : true
							},
							j_password : {
								required : true,
								minlength : 1,
								maxlength : 20
							},
							j_code : {
								required : true
							}
						},

						// Messages for form validation
						messages : {
							j_username : {
								required : '请输入用户名或密码'
							},
							j_password : {
								required : '请输入用密码'
							},
							j_code : {
								required : '请输入用验证码'
							}
						},

						// Do not change code below
						errorPlacement : function(error, element) {
							error.insertAfter(element.parent());
						}
					
					});
					 
					 return $("#login-form").valid();
					
				}
				
				
				$().ready(function() {
					if("${param.errorInfo}" != "") {
						$.errorNotification("${param.errorInfo}");
					}
					
					$("#button-login").click(function() {
						login();
					});
					
					$("#button-refresh-captcha").click(function() {
						var url = "${ctx}/commons/refreshCaptcha.htm";
						$.ajax({
							async: false,
							type : "get",
							url  : url,
							data : {"t": "${authenticity_token}"},
							success : function(data){
								$("#authenticity_token").val(data);
								var url = "${ctx}/commons/validateCodeServlet.do?t=" + $("#authenticity_token").val();
								$("#validateCodeImg").attr("src",url).show();
							}
						});
					});
					
					
					$("body").on("keyup", function(event) {
		    			if (event.keyCode == 13) {
		    				login();
		    			}
					});
					
					$("#j_username").focus();
				});
			});
		</script>

</body>
</html>
