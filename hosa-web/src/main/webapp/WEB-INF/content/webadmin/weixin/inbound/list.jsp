<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<script type="text/javascript"
	src="${ctx}/js/plugin/ckplayer/ckplayer.js" charset="utf-8"></script>
</head>

<body>
	<div id="content">

		<div class="row">
			<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
				<h1 class="page-title txt-color-blueDark">
					<i class="fa fa-group fa-fw "></i> 微信管理 <span>> 微信客服 </span>
				</h1>
			</div>
			<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8"></div>
		</div>

		<!-- widget grid -->
		<section id="list-section" class="">

			<!-- row -->
			<div class="row">

				<!-- NEW WIDGET START -->
			<article class="col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">

							<!-- new widget -->
							
							<!-- end widget -->

							<!-- new widget -->
							
							<!-- end widget -->

						<div class="jarviswidget jarviswidget-color-blueDark jarviswidget-sortable" id="wid-id-1" data-widget-editbutton="false" data-widget-fullscreenbutton="false" role="widget" style="">

								<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->

								<header role="heading">
								
									<span class="widget-icon"> <i class="fa fa-comments txt-color-white"></i> </span>
									<h2> 聊天(</h2><h2 id="user_tag"></h2><h2>) </h2>
									<div class="widget-toolbar" role="menu">
										<!-- add: non-hidden - to disable auto hide -->

										<div class="btn-group">
											<!-- <button class="btn dropdown-toggle btn-xs btn-success" data-toggle="dropdown">
												状态 <i class="fa fa-caret-down"></i>
											</button> -->
											<ul class="dropdown-menu pull-right js-status-update">
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-green"></i> 在线</a>
												</li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-red"></i> 繁忙</a>
												</li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-orange"></i> 离开</a>
												</li>
												<li class="divider"></li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-power-off"></i> 退出</a>
												</li>
											</ul>
										</div>
									</div>
									<!-- 
								<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span>
								 -->
								
								</header>

								<!-- widget div-->
								<div role="content">
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<div>
											<label>Title:</label>
											<input type="text">
										</div>
									</div>
									<!-- end widget edit box -->

									<div class="row"><div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">

									<div class="widget-body widget-hide-overflow no-padding">
										<!-- content goes here -->

										<!-- CHAT CONTAINER -->
										<div id="chat-container" class="" style="border-bottom:1px solid #CDCECF;">
											<span class="chat-list-open-close"><i class="fa fa-user"></i><b class="new-msg-warn" style="display:none;">!</b></span>

											<div class="chat-list-body custom-scroll">
												<ul id="chat-users">
													<li item-template style="display:none;">
														<a href="javascript:void(0);"><img src="${ctx}/img/user.png" alt=""><span class="name">Robin Berry </span><span class="badge badge-inverse unread">23</span></a>
													</li>
													
												</ul>
											</div>
											<div class="chat-list-footer">

												<div class="control-group">

													<form class="smart-form">

														<section>
															<label class="input">
																<input type="text" id="filter-chat-list" placeholder="Filter">
															</label>
														</section>

													</form>

												</div>

											</div>

										</div>

										<!-- CHAT BODY -->
										<div id="chat-body" class="chat-body custom-scroll profile-message" style="height:400px!important;border-right: 1px solid rgba(0,0,0,.1);overflow:scroll">
											<ul id="message-list">
												
												<li class="message message-reply" style="margin-left:0px!important;margin-right:40px;display:none;" item-template>
													<img src="${ctx}/img/user.png"  alt="">
													<div class="message-text">
														<time style="top:14px;">2014-5-12 9:34:21</time> 
														<a href="javascript:void(0);" class="username">John Doe</a><span > di! Yeah I know what you mean. Thanks for the file Sadi! Yeah I know what you mean. Thanks for the file Sadi! </span> 
													</div>
												</li>
											</ul>

										</div>

										<!-- CHAT FOOTER -->
										<div class="chat-footer" style="background:none;border-right: 1px solid rgba(0,0,0,.1);">

											<!-- CHAT TEXTAREA -->
											<div class="textarea-div">

												<div class="typearea">
													<textarea placeholder="发送内容..." id="textarea-expand" class="custom-scroll" disabled="disabled"></textarea>
												</div>

											</div>

											<!-- CHAT REPLY/SEND -->
											<span class="textarea-controls">
												<button class="btn btn-sm btn-primary pull-right" id="sendMsg" disabled="disabled">
													回复
												</button> 
												<!-- 
												<span class="pull-right smart-form" style="margin-top: 3px; margin-right: 10px;"> <label class="checkbox pull-right">
														<input type="checkbox" name="subscription" id="subscription">
														<i></i>按 <strong> ENTER </strong>发送</label> </span> 
														
												<a href="javascript:void(0);" class="pull-left"><i class="fa fa-camera fa-fw fa-lg"></i></a> </span>
 -->
										</div>

										<!-- end content -->
									</div>
									</div><div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									
									<div class="widget-body">
				
										<div class="tabs-right">
											<ul class="nav nav-tabs">
												<li class="active">
													<a href="#tab1" data-toggle="tab">客户资料<span class="badge bg-color-blue txt-color-white"></span></a>
												</li>
												<li class="">
													<a href="#tab2" id="history_click" data-toggle="tab">联络历史<span class="badge bg-color-blueDark txt-color-white"></span></a>
												</li>
												
											</ul>
											<div id="user_tab" class="tab-content">
												<div class="tab-pane active" id="tab1">
					
							<form id="user_info" class="smart-form" style="width:90%;">
								<header> 客户资料 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">微信昵称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">性别:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="sex"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">地址:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="address"> </label>
										</section>
									</div>
								</fieldset>
							</form>
					
												</div>
												<div class="tab-pane " style="width:90%;height:470px;" id="tab2">
													<div id="history-messages" class="chat-body custom-scroll profile-message" style="height:470px!important;box-shadow:none;overflow:scroll">
													<ul id="history-message-list">
												
														<li class="message message-reply" style="margin-left:0px!important;display:none;" item-template>
															<img src="${ctx}/img/user.png"  alt="">
															<div class="message-text">
																<time style="top:14px;">2014-5-12 9:34:21</time> 
																<a href="javascript:void(0);" class="username">John Doe</a><span > di! Yeah I know what you mean. Thanks for the file Sadi! Yeah I know what you mean. Thanks for the file Sadi! </span> 
															</div>
														</li>
													</ul>

												</div>
												<div class="bottom-row" style="width:90%;border:0px;">
												<div class="row" paging-data paging-summary></div>
											</div>
												
												</div>
												
											</div>
										</div>
				
									</div>
									
									
									
									</div></div>

								</div>
								<!-- end widget div -->
							</div></article>
	<!-- WIDGET END -->

	</div>

	<!-- end row -->

	</section>
	<!-- end widget grid -->



	</div>
	<!-- END MAIN CONTENT -->

	<section id="modal-section" class="">
		

		

		
	</section>

	<script src="${ctx}/js/platform/weixin/inbound.js"></script>
	<script>
		$(function(){
	
				/*
				 * CHAT
				 */

				$.filter_input = $('#filter-chat-list');
				$.chat_users_container = $('#chat-container > .chat-list-body');
				$.chat_users = $('#chat-users');
				$.chat_list_btn = $('#chat-container > .chat-list-open-close');
				$.chat_body = $('#chat-body');

				/*
				* LIST FILTER (CHAT)
				*/

				// custom css expression for a case-insensitive contains()
				jQuery.expr[':'].Contains = function(a, i, m) {
					return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
				};

				function listFilter(list) {// header is any element, list is an unordered list
					// create and add the filter form to the header

					$.filter_input.change(function() {
						var filter = $(this).val();
						if (filter) {
							// this finds all links in a list that contain the input,
							// and hide the ones not containing the input while showing the ones that do
							$.chat_users.find("a:not(:Contains(" + filter + "))").parent('.item').slideUp();
							$.chat_users.find("a:Contains(" + filter + ")").parent('.item').slideDown();
						} else {
							$.chat_users.find("li[class=item]").slideDown();
						}
						return false;
					}).keyup(function() {
						// fire the above change event after every letter
						$(this).change();

					});

				}

				// on dom ready
				listFilter($.chat_users);

				// open chat list
				$.chat_list_btn.click(function() {
					$(this).parent('#chat-container').toggleClass('open');
				})

				$.chat_body.animate({
					scrollTop : $.chat_body[0].scrollHeight
				}, 500);
				
					})
		</script>
</body>
</html>