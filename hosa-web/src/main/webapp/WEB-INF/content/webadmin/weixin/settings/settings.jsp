<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
</head>

<body>
	<div id="content">

		<div class="row">
			<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
				<h1 class="page-title txt-color-blueDark">
					<i class="fa fa-comments fa-fw "></i> 微信管理 <span>> 参数设置 </span>
				</h1>
			</div>
			<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8"></div>
		</div>

		<!-- widget grid -->
		<section id="list-section" class="">

			<!-- row -->
			<div class="row">

				<!-- NEW WIDGET START -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div>
						<div class=" jarviswidget jarviswidget-color-blueDark">

							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>参数信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body no-padding">
										<div class="widget-body-toolbar">
											
											<div class="row">
												
												<div class="col-sm-6">
													
												</div>
												<div class="col-sm-6 text-right">
													
												</div>
												
											</div>
												
				
										</div>
		
										<table id="edit-form" class="table table-striped table-bordered" >
											<tbody>
												<tr class="edit">
													<td style="width:35%;">app id </td>
													<td style="width:65%">
													<label class="view" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_APPID"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input"
																			style="position: relative;">
																			<input type="text" name="val" class="form-control input-sm"
																				style="padding-right: 24px;"><span
																				class="editable-clear-x"></span>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
												<tr class="edit">
													<td>app secret</td>
													<td>
													<label class="view" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_APPSECRET"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input"
																			style="position: relative;">
																			<input type="text" name="val" class="form-control input-sm"
																				style="padding-right: 24px;"><span
																				class="editable-clear-x"></span>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
												<tr>
													<td>url</td>
													<td>
													<label class="view readonly" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_URL"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input"
																			style="position: relative;">
																			<input type="text" name="val" class="form-control input-sm"
																				style="padding-right: 24px;"><span
																				class="editable-clear-x"></span>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
												<tr class="edit">
													<td>token</td>
													<td>
													<label class="view" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_TOKEN"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input"
																			style="position: relative;">
																			<input type="text" name="val" class="form-control input-sm"
																				style="padding-right: 24px;"><span
																				class="editable-clear-x"></span>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
												
												<tr class="edit">
													<td>账号类型</td>
													<td>
													<label class="view" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_TYPE"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input" >
																			<select class="form-control input-sm" name="val" type="select"><option
																					value="">请选择</option>
																				<option value="1">服务号</option>
																				<option value="0">订阅号</option></select>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
												<tr class="edit">
													<td>关注欢迎内容</td>
													<td>
													<label class="view" item-id="val"></label>
													<span item-id="editVariable" class="editable-container editable-inline" style="display:none;"><div>
															<form class="form-inline editableform" style="">
															<input type="hidden" name="variable" value="SETTINGS_WEIXIN_SUBSCRIBE_WELCOME"/>
															<input type="hidden" name="modified"/>
																<div class="control-group form-group">
																	<div>
																		<div class="editable-input " >
																		<select class="form-control input-sm" name="type" type="select"><option
																					value="">请选择</option>
																				<option value="0">进线菜单</option>
																				<option value="1">素材</option></select>
																			<select class="select2" name="val" type="select"  style="width:200px; display:none;">
																			<option
																					value=""></option></select>
																		</div>
																		<div class="editable-buttons">
																			<button type="button" item-id="button-save"
																				class="btn btn-primary btn-sm editable-submit">
																				<i class="glyphicon glyphicon-ok"></i>
																			</button>
																			<button type="button" item-id="button-cancel"
																				class="btn btn-default btn-sm editable-cancel">
																				<i class="glyphicon glyphicon-remove"></i>
																			</button>
																		</div>
																	</div>
																	<div class="editable-error-block help-block"
																		style="display: none;"></div>
																</div>
															</form>
														</div></span>


												</td>
												</tr>
											</tbody>
										</table>
				
									</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- end widget -->
					</div>
				</article>
				<!-- WIDGET END -->

			</div>

			<!-- end row -->

		</section>
		<!-- end widget grid -->



	</div>
	<!-- END MAIN CONTENT -->

	

	<script src="${ctx}/js/platform/weixin/settings.js"></script>
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				settingCheckAll();
			});
		})
	</script>
</body>
</html>

