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
					<i class="fa fa-group fa-fw "></i> 系统管理 <span>> 素材管理 </span>
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
								<h2>素材信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body">
									<ul item-id="tab-type" class="nav nav-tabs bordered">
									</ul>
									<div class="tab-content padding-10">
										<div class="tab-pane fade active in" id="s1">
											<div class="row padding-10">

												<div class="pull-right col-sm-3">
													<div class="input-group">
														<span class="input-group-addon"> <a
															href="javascript:void(0);"
															item-id="button-filter-refresh"><i
																class="fa fa-refresh"></i> </a></span><input item-id="input-filter"
															class="form-control col-sm2" placeholder="过滤" type="text">
													</div>

												</div>
											</div>
											<table id="data-table"
												class="table table-striped table-bordered table-hover table-ellipsis smart-form">
												<thead>
													<tr paging-title>
														<th style="width: 20px;"><label class="checkbox">
																<input type="checkbox" name="check-all"> <i></i>
														</label></th>
														<th class="col-xs-4 col-sm-4 col-md-4 col-lg-4 sorting"
															paging-sort-column="name">素材名称</th>
														<th class="hidden-xs hidden-sm col-md-8 col-lg-8 sorting"
															paging-sort-column="描述">描述</th>
														<th style="width: 100px;"></th>
													</tr>
												</thead>
												<tbody class="list">
													<tr style="display:none;" item-template>
														<td><label class="checkbox"> <input
																type="checkbox" name="checkRow"> <i></i></label></td>
														<td
															class="col-xs-4 col-sm-4 col-md-4 col-lg-4 filter_name view"
															item-id="name" item-view>&nbsp;</td>
														<td
															class="hidden-xs hidden-sm col-md-8 col-lg-8 filter_description view"
															item-id="description" item-view>&nbsp;</td>
														<td>
															<div class="btn-group  btn-group-justified">
																<a href="javascript:void(0);"
																	class="btn btn-primary btn-xs " item-id="button-modify">
																	编辑 </a> <a href="javascript:void(0);"
																	class="btn btn-danger btn-xs" item-id="button-delete">
																	删除 </a>
															</div>
														</td>
													</tr>

												</tbody>
											</table>
											<div class="bottom-row">
												<div class="row" style="margin-top: auto;">
													<div class="col-sm-6">
														<div class="pull-left">
															<a class="btn btn-default btn-sm"
																item-id="buttong-toolbar-search"><i
																class="fa fa-search"></i> 搜索</a> <a
																class="btn btn-primary btn-sm"
																item-id="button-toolbar-add"><i class="fa fa-plus"></i>
																新增</a> <a class="btn btn-primary btn-sm"
																href="javascript:void(0);"
																item-id="button-toolbar-modify"><i
																class="fa fa-pencil"></i> 修改</a> <a
																class="btn btn-danger btn-sm" href="javascript:void(0);"
																item-id="button-toolbar-delete"><i
																class="fa fa-times"></i> 删除</a>
														</div>
													</div>
												</div>
											</div>
											<div class="bottom-row">
												<div class="row" paging-data paging-summary></div>
											</div>
										</div>
									</div>
								</div>

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
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">设置素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" /> <input
									id="modified" type="hidden" name="modified" /> <input
									type="hidden" class="form-control" id="type" name="type"
									value="" />
								<header> 素材信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="素材名称" id="name"
											name="name" /> <b class="tooltip tooltip-top-right">需要输入素材名称</b>
										</label>
									</section>
									<section>
										<label class="textarea"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="素材描述" rows="5"
												id="description" name="description"></textarea> <b
											class="tooltip tooltip-top-right">需要输入素材描述</b>
										</label>
									</section>
								</fieldset>
							</form>
							<form id="edit-sub-form" class="smart-form">
								<input type="hidden" name="tempId" />
								<fieldset item-id="content">
									<div class="row">
										<section class="col col-6 well well-light padding-10">
											<section class="" item-id="sub-image">
												<div class="fileinput-button " item-id="preview">
													<div class="nailthumb-container">
														<img src="${ctx}/img/user.png" style="width: 100%">
														<input type="file" name="uploadFile"
															data-url="${ctx}/webadmin/upload.htm">
													</div>

												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section class="" item-id="sub-video">
												<div id="video-preview" style="width:100%;height:200px;">

												</div>
												<div class="fileinput-button ">
													<a href="#" class="btn  btn-xs btn-block btn-primary"><i
														class="fontello-icon-upload"></i>上传</a> <input type="file"
														name="uploadFile" data-url="${ctx}/webadmin/upload.htm">
												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section class="" item-id="sub-voice">
												<div id="voice-preview" style="width:100%;"></div>
												<div class="fileinput-button ">

													<div class="nailthumb-container">
														<a href="#" class="btn  btn-xs btn-block btn-primary"><i
															class="fontello-icon-upload"></i>上传</a> <input type="file"
															name="uploadFile" data-url="${ctx}/webadmin/upload.htm">
													</div>

												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section item-id="sub-title">
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="素材标题"
													id="tempTitle" name="tempTitle" /> <b
													class="tooltip tooltip-top-right">需要输入素材标题</b>
												</label>
											</section>
											<section item-id="sub-url">
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="链接地址"
													id="tempLinkUrl" name="tempLinkUrl" /> <b
													class="tooltip tooltip-top-right">需要输入链接地址</b>
												</label>
											</section>
											<section item-id="sub-content">
												<label class="textarea"> <i
													class="icon-append fa fa-question-circle"></i> <textarea
														class="form-control" placeholder="素材内容" rows="5"
														id="tempContent" name="tempContent"></textarea> <b
													class="tooltip tooltip-top-right">需要输入素材内容</b>
												</label>
											</section>
											<section class="pull-right">

												<a href="javascript:void(0);" class="btn btn-default btn-xs"
													item-id="button-sub-cancel"> 取消 </a> <a
													href="javascript:void(0);" class="btn btn-primary btn-xs"
													item-id="button-sub-save"> 保存 </a>
											</section>
											<section item-id="sub-error" class="pull-left"
												style="display:none; ">
												<label class="state-error"> </label><em class="invalid">请添加素材</em>
											</section>
										</section>
										<section class="col col-6">
											<table class="table table-bordered table-ellipsis">
												<thead>
													<tr>
														<th style="display:none; "></th>
														<th class=" col-9">标题</th>
														<th class=" col-3"></th>
													</tr>
												</thead>
												<tbody>
													<tr style="display:none;" item-template>
														<td style="display:none; "><input type="hidden"
															name="id" /> <input type="hidden" name="linkUrl" /> <input
															type="hidden" name="storagePath" /> <input type="hidden"
															name="title" /> <input type="hidden" name="url" /> <input
															type="hidden" name="content" /></td>
														<td class=" col-9 view" item-id="title"></td>
														<td class=" col-3"><a href="javascript:void(0);"
															class="btn btn-danger btn-xs" item-id="button-sub-delete">
																删除 </a></td>
													</tr>


												</tbody>
											</table>
										</section>
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
						<h4 class="modal-title" id="myModalLabel">素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 素材信息 </header>
								<fieldset>
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
											<label class="label">描述:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="description"> </label>
										</section>
									</div>
									</fieldset>
									</form>
									<form id="view-sub-form" class="smart-form">
									<fieldset item-id="sub-list" class="padding-10">
									<div class="row well well-light padding-10"  style="display:none; margin: 5px;" item-template>
										<section class="col col-5" item-id="type">
											
										</section>
										<section class="col col-7">
											<div class="row" >
												<h3 item-id="title">
													
												</h3>
												<ul class="list-unstyled">
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<span
																class="txt-color-darken" item-id="linkUrl"></span>
														</p>
													</li>
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<span
																class="txt-color-darken" item-id="content"></span>
														</p>
													</li>
												</ul>

											</div>
										</section>
									</div>
									
								</fieldset>
							</form>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							item-id="button-view-previous">
							<i class="fa fa-angle-left"></i>
						</button>
						<button type="button" class="btn btn-default pull-left"
							item-id="button-view-next">
							<i class="fa fa-angle-right"></i>
						</button>
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
						<h4 class="modal-title" id="myModalLabel">查询素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 素材信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="素材名称" id="name"
											name="nameLike" /> <b class="tooltip tooltip-top-right">需要输入素材名称</b>
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
	</section>


	<script src="${ctx}/js/platform/system/material.js"></script>
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();
			
			$().ready(function() {
				$(".nailthumb-container").nailthumb({ height: 100});
				settingCheckAll();
			});
		})
	</script>
</body>
</html>

