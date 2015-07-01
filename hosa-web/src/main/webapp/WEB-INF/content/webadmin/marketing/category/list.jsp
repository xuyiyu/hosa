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
					<i class="fa fa-group fa-fw "></i> 组织管理 <span>> 活动分类管理 </span>
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
								<h2>活动分类信息</h2>
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
													paging-sort-column="name">名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="description">描述</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_description view"
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
									<div class="dt-bottom-row">
										<div class="row" style="margin-top: auto;">
											<div class="col-sm-6">
												<div class="pull-left">
													<a class="btn btn-default btn-sm" item-id="buttong-toolbar-search"><i class="fa fa-search"></i>
														搜索</a> <a class="btn btn-primary btn-sm"
														item-id="button-toolbar-add"><i class="fa fa-plus"></i>
														新增</a> <a class="btn btn-primary btn-sm" href="javascript:void(0);"
														item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a> <a class="btn btn-danger btn-sm"
														href="javascript:void(0);" item-id="button-toolbar-delete"><i
														class="fa fa-times"></i> 删除</a>
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
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">设置活动分类信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 活动分类信息 </header>
								<fieldset>
								<section>
										<label class="select"> <select style="width:100%"
														class="select2" id="type" name="type">
															<option></option>
															<option value="1">售前</option>
															<option value="2">售后</option>
													</select>
													</label>
									</section>
								<div class="row">
								<section class="col col-2">
												<div class="fileinput-button" item-id="preview">
													<img src="${ctx}/img/user.png"
														style="top: 0px; width: 48px; height: 48px;">
													<button type="button" class="btn btn-danger btn-xs"
														style="position: absolute; top: 10px; left: 5px; z-index: 1000; display: none;">删除</button>
													<input type="file" name="uploadFile"
														data-url="${ctx}/webadmin/upload.htm">
												</div>
												<input type="hidden" id="iconUrl" name="iconUrl" />
												<input type="hidden" id="iconStoragePath"
													name="iconStoragePath" />
											</section>
											
											<section class="col col-10">
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="活动分类名称"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入活动分类名称</b>
										</label>
									</section>
								</div>
									
									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="分类描述" rows="5"
												id="description" name="description"></textarea> <b
											class="tooltip tooltip-top-right">需要输入分类描述</b>
										</label>
									</section>
								</fieldset>
								
								<fieldset>
								<div class="row">
									<section class="col col-5">
									<select multiple="multiple" id="optional" style="width: 100%; height: 170px;">
									
									</select>
									</section>
									<section class="col col-2" style="text-align: center;">
										<section>
										<a class="btn btn-primary btn-sm"
														item-id="button-fast-forward"><i class="fa fa-fast-forward"></i>
														</a>
										</section>
										<section>
										<a class="btn btn-primary btn-sm"
														item-id="button-forward"><i class="fa fa-forward"></i>
														</a>
										</section>
										<section>
										<a class="btn btn-primary btn-sm"
														item-id="button-backward"><i class="fa fa-backward"></i>
														</a>
										</section>
										<section>
										<a class="btn btn-primary btn-sm"
														item-id="button-fast-backward"><i class="fa fa-fast-backward"></i>
														</a>
										</section>
									</section>
									<section class="col col-5">
									<select multiple="multiple" id="selected" style="width: 100%; height: 170px;">
									
									</select>
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
						<h4 class="modal-title" id="myModalLabel">活动分类信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 活动分类信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">name:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">iconUrl:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="iconUrl"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">iconStoragePath:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="iconStoragePath"> </label>
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
						<h4 class="modal-title" id="myModalLabel">查询活动分类信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 活动分类信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="name"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入name</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="iconUrl"
											id="iconUrl" name="iconUrl" /> <b
											class="tooltip tooltip-top-right">需要输入iconUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="iconStoragePath"
											id="iconStoragePath" name="iconStoragePath" /> <b
											class="tooltip tooltip-top-right">需要输入iconStoragePath</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="description"
											id="description" name="description" /> <b
											class="tooltip tooltip-top-right">需要输入description</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="最后修改时间"
											id="modified" name="modified" /> <b
											class="tooltip tooltip-top-right">需要输入最后修改时间</b>
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


	<script src="${ctx}/js/platform/marketing/activitycategory.js"></script>
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

