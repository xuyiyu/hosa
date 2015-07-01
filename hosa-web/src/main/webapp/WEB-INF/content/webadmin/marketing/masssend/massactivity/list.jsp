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
					<i class="fa fa-group fa-fw "></i> 群发消息 <span>> 群发活动 </span>
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
								<h2>群发活动信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body no-padding">
									<div class="widget-body-toolbar">
										<div class="row">

											<div class="pull-right col-sm-3">
												<div class="input-group">
													<span class="input-group-addon"> <a
														href="javascript:void(0);" item-id="button-filter-refresh"><i
															class="fa fa-refresh"></i> </a></span><input item-id="input-filter"
														class="form-control col-sm2" placeholder="过滤" type="text">
												</div>

											</div>
										</div>
									</div>

									<table id="data-table"
										class="table table-striped table-bordered table-hover table-ellipsis smart-form">
										<thead>
											<tr paging-title>
												<th style="width: 20px;"><label class="checkbox"> <input
														type="checkbox" name="check-all"> <i></i></label></th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="sendTime">发送时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="name">发送内容</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="status">状态</th>
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_sendTime view"
													item-id="sendTimeString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_status view"
													item-id="status" item-view>&nbsp;</td>
												
												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-id="button-modify">
															修改 </a>
													</div>
												</td>
											</tr>

										</tbody>
									</table>
									<div class="dt-bottom-row">
										<div class="row" style="margin-top: auto;">
											<div class="col-sm-6">
												<div class="pull-left">
													<a class="btn btn-default btn-sm" item-id="buttong-toolbar-search"><i class="fa fa-search"></i>
														搜索</a> <a class="btn btn-primary btn-sm"
														item-id="button-toolbar-add"><i class="fa fa-plus"></i>
														新增</a> <!-- <a class="btn btn-primary btn-sm" href="javascript:void(0);"
														item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a>  -->
												</div>
											</div>
										</div>
									</div>
									<div class="dt-bottom-row">
										<div class="row" paging-data paging-summary></div>
									</div>
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

	<section id="modal-section" class="">
		<!-- Modal -->
		<div class="modal fade" id="editModal" role="dialog"
			aria-labelledby="editModal" aria-hidden="true">
			<div class="modal-dialog" style="width: 720px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">设置群发活动信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header>发送人群</header>
								<fieldset><section>
										<label class="select"> <select multiple style="width:100%" class="select2" name="groupId">
										</select>
										</label>
									</section>
								</fieldset>
								
								<header>消息信息</header>
								<fieldset>
										<section>
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="消息名称"
													id="name" name="name" /> <b
													class="tooltip tooltip-top-right">需要输入消息名称</b>
												</label>
											</section>
								</fieldset>
								<header>发送内容</header>
								<fieldset>
									
									<div class="row">
										
										<section class="col col-6 well well-light padding-10">
											<input type="hidden" id="activityMessageContentId" name="activityMessageContentId">
											<input type="hidden" id="activityMessageId" name="activityMessageId">
											<input type="hidden" id="activityId" name="activityId">
											<input type="hidden" id="storagePath" name="storagePath">
											<input type="hidden" id="linkUrl" name="linkUrl">
											<section>
												<button type="button" class="btn btn-default" item-id="button-activity">选择活动</button>
											</section>
											<section>
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="活动名称"
													id="title" name="title" /> <b
													class="tooltip tooltip-top-right">需要输入活动名称</b>
													
												</label>
											</section>
											<section>
												<label class="textarea"> <i
													class="icon-append fa fa-question-circle"></i> <textarea
														class="form-control" placeholder="内容" rows="5"
														id="content" name="content"></textarea> <b
													class="tooltip tooltip-top-right">需要输入内容</b>
												</label>
											</section>
											<section>
												<label class="label">选择图片:</label>
											</section>
											<section>
												<div class="fileinput-button" item-id="preview">
													<img src=""
																style="top: 0px; width: 320px; height: 150px;">
															<button type="button" class="btn btn-danger btn-xs"
																style="position: absolute; top: 40px; left: 25px; z-index: 1000; display: none;">删除</button>
															<input type="file" name="uploadFile"
																data-url="${ctx}/webadmin/upload.htm">
														</div>
													<input type="hidden" id="picUrl" name="picUrl" />
											</section>
											<section class="pull-right">
												<button type="button" class="btn btn-default btn-xs" item-id="button-itemcancel">取消</button>
												<button type="button" class="btn btn-primary btn-xs"  item-id="button-itemsave">保存</button>
											</section>
										</section>
										<section class="col col-6">
											<table class="table table-bordered table-ellipsis">
													<tr>
														<th class=" col-5">消息名称</th>
														<th class=" col-5">图片</th>
														<th class=" col-2"></th>
													</tr>
													<tbody class="section_activity ">
														<tr style="" class="item-empty"><td class="data_empty" colspan="3">没有记录</td></tr>
													</tbody>
											</table>
										</section>
									</div>
									
								</fieldset>
								
								<header>发送设置</header>
								<fieldset>
									<div class="row">
										
										<div class="col col-4">
													<div class="inline-group">
														<label class="radio">
															<input type="radio" name="allowDonationRadio" checked="checked" value="1">
															<i></i>立即发送</label>
														<label class="radio">
															<input type="radio" name="allowDonationRadio" value="0">
															<i></i>定时发送</label>
														</div>
														
										</div>
										<div class="col col-4">
											<label class="input"> <i class="icon-append fa fa-calendar"></i>
												<input type="text" name="sendTime" id="sendTime"  class="hasDatepicker">
											</label>
														
										</div>
										<div class="col col-4">
												
											<select id="sendTimeAdd" name="sendTimeAdd" style="width:100%;height:32px;" >
												<option value="0">当前时间</option>
												<option value="10">+10分钟</option>
												<option value="30">+30分钟</option>
												<option value="60">+1小时</option>
											</select>
											
										</div>
											
									
									</div>
								</fieldset>
								
							</form>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							item-id="button-cancel">取消</button>
						<button type="button" class="btn btn-primary"
							item-id="button-save">保存</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		<!-- Modal -->
		<div class="modal fade" id="viewModal" role="dialog"
			aria-labelledby="viewModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">活动消息表信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 活动消息表信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">departmentId:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="departmentId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">接收人:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="recipient"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">消息类型{1：文本，2：语音，3：图片，4：视频，5：图文}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="type"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">消息分类{1：微信}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="category"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">素材名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">description:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="description"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">发送时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="sendTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">状态{1：待发送，2：发送完成}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="status"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">最后修改时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="modified"> </label>
										</section>
									</div>
								</fieldset>
							</form>
						</div>

					</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left" item-id="button-view-previous"><i class="fa fa-angle-left"></i></button>
					<button type="button" class="btn btn-default pull-left" item-id="button-view-next"><i class="fa fa-angle-right"></i></button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		<!-- Modal -->
		<div class="modal fade" id="searchModal" role="dialog"
			aria-labelledby="searchModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查询活动消息表信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 活动消息表信息 </header>
								<fieldset>
									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="消息名称"
											id="name" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入消息名称</b>
										</label>
									</section>
								</fieldset>

							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							item-id="button-search-reset">重置</button>
						<button type="button" class="btn btn-primary"
							item-id="button-search">查询</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		

		<div class="modal fade" id="activitySearchModal" role="dialog"
			aria-labelledby="searchModal" aria-hidden="true">
			<div class="modal-dialog" style="width:600px;">
			
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查询活动消息表信息</h4>
					</div>
					
				<section id="list-section" class="">

			<!-- row -->
			<div class="row">

				<!-- NEW WIDGET START -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div>
						<div class=" jarviswidget jarviswidget-color-blueDark">


							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body no-padding">
									<div class="widget-body-toolbar">
										<div class="row">

											<div class="pull-right col-sm-3">
												<div class="input-group">
													<span class="input-group-addon"> <a
														href="javascript:void(0);" item-id="button-filter-act-refresh"><i
															class="fa fa-refresh"></i> </a></span><input item-id="input-filter"
														class="form-control col-sm2" placeholder="过滤" type="text">
												</div>

											</div>
										</div>
									</div>

									<table id="activitydata-table"
										class="table table-striped table-bordered table-hover table-ellipsis smart-form">
										<thead>
											<tr paging-title>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="name">活动名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="beginTime">活动时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="type">活动类型</th>
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_beginTimeString view"
													item-id="beginTimeString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_type view"
													item-id="type" item-view>&nbsp;</td>
											
												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-id="button-selectAct">
															选择 </a> 
													</div>
												</td>
											</tr>

										</tbody>
									</table>
									<div class="dt-bottom-row">
										<div class="row" paging-data paging-summary></div>
									</div>
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
			</div>	
			<!-- /.modal-dialog -->
		</div>
		
		</div>
	</section>
	<script src="${ctx}/js/platform/marketing/activitymessage.js"></script>
	
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				settingCheckAll();
			});
			$("#sendTime").datetimepicker({
				    format: 'yyyy-mm-dd hh:mm',
				    autoclose: true,
			        todayBtn: true,
			        startView: 2,
					minView: 2,
				    language: "zh-CN"
			});
		});
	</script>
	 <script>
        $(document).ready(function() { 
        	$("#groupId").select2();
        });
    </script>
</body>
</html>

