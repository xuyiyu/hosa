<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webadmin/commons/taglibs.jsp"%>
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
					<i class="fa fa-group fa-fw "></i> Image<s:text name="common.label.management"/><span>>
						Image<s:text name="common.label.management"/> </span>
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
								<span class="widget-icon"> <i class="fa fa-table"></i> </span>
								<h2>Image<s:text name="common.label.info"/></h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body no-padding">
									<div class="widget-body-toolbar">
										<div class="row">
											<div class="pull-left col-sm-12 col-md-6">
											</div>
											<div class="pull-right col-md-3 hidden-xs">
												<div class="input-group">
													<span class="input-group-addon"> <a
														href="javascript:void(0);" item-id="button-filter-refresh"><i
															class="fa fa-refresh"></i> </a> </span><input item-id="input-filter"
														class="form-control col-sm2" placeholder="<s:text name="common.label.filter"/>" type="text">
												</div>

											</div>
										</div>
									</div>

									<table id="data-table"
										class="table table-striped table-bordered table-hover table-ellipsis smart-form">
										<thead>
											<tr paging-title>
												<th style="width: 20px;"><label class="checkbox">
														<input type="checkbox" name="check-all"> <i></i> </label>
												</th> 
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="bitmap_width">bitmapWidth</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="bitmap_height">bitmapHeight</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="original_url">originalUrl</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="compress_url">compressUrl</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="location_name">locationName</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="longitude">longitude</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="latitude">latitude</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="content">content</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="user_id">userId</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="favorited_cnt">favoritedCnt</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="comment_cnt">commentCnt</th>

												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="created_at">createdAt</th>

												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i> </label>
												</td> 
												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_bitmapWidth" item-id="bitmapWidth"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_bitmapHeight" item-id="bitmapHeight"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_originalUrl" item-id="originalUrl"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_compressUrl" item-id="compressUrl"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_locationName" item-id="locationName"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_longitude" item-id="longitude"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_latitude" item-id="latitude"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_content" item-id="content"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_userId" item-id="userId"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_favoritedCnt" item-id="favoritedCnt"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_commentCnt" item-id="commentCnt"> &nbsp;</label></td>

												<td
													class="col-xs-4 col-sm-4 col-md-2 col-lg-2  view"
													item-view><label class="filter_createdAt" item-id="createdAt"> &nbsp;</label></td>

												<td>
													<div class="btn-group  btn-group-justified">
														<shiro:hasAnyRoles name="auth-image-edit">
															<a href="javascript:void(0);"
																class="btn btn-primary btn-xs " item-id="button-modify">
																<s:text name="common.label.edit"/> </a>
														</shiro:hasAnyRoles>
														<shiro:hasAnyRoles name="auth-image-delete">
															<a href="javascript:void(0);"
																class="btn btn-danger btn-xs" item-id="button-delete">
																<s:text name="common.label.delete"/> </a>
														</shiro:hasAnyRoles>
													</div></td>
											</tr>

										</tbody>
									</table>
									<div class="dt-bottom-row">
										<div class="row" style="margin-top: auto;">
											<div class="col-sm-6">
												<div class="pull-left">
													<a class="btn btn-default btn-sm"
														item-id="buttong-toolbar-search"><i
														class="fa fa-search"></i> <s:text name="common.label.search"/></a>
													<shiro:hasAnyRoles name="auth-image-add">
														<a class="btn btn-primary btn-sm"
															item-id="button-toolbar-add"><i class="fa fa-plus"></i>
															<s:text name="common.label.add"/></a>
													</shiro:hasAnyRoles>
													<shiro:hasAnyRoles name="auth-image-edit">
														<a class="btn btn-primary btn-sm"
															href="javascript:void(0);"
															item-id="button-toolbar-modify"><i
															class="fa fa-pencil"></i> <s:text name="common.label.edit"/></a>
													</shiro:hasAnyRoles>
													<shiro:hasAnyRoles name="auth-image-delete">
														<a class="btn btn-danger btn-sm"
															href="javascript:void(0);"
															item-id="button-toolbar-delete"><i
															class="fa fa-times"></i> <s:text name="common.label.delete"/></a>
													</shiro:hasAnyRoles>
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
						<h4 class="modal-title" id="myModalLabel"><s:text name="common.label.setting"/>Image<s:text name="common.label.info"/></h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id"
									value="${param.id}" /> <input id="modified"
									type="hidden" name="modified" />
								<header> Image<s:text name="common.label.info"/> </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="bitmapWidth"
											id="bitmapWidth"
											name="bitmapWidth" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>bitmapWidth</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="bitmapHeight"
											id="bitmapHeight"
											name="bitmapHeight" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>bitmapHeight</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="originalUrl"
											id="originalUrl"
											name="originalUrl" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>originalUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="compressUrl"
											id="compressUrl"
											name="compressUrl" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>compressUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="locationName"
											id="locationName"
											name="locationName" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>locationName</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="longitude"
											id="longitude"
											name="longitude" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>longitude</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="latitude"
											id="latitude"
											name="latitude" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>latitude</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="content"
											id="content"
											name="content" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>content</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="userId"
											id="userId"
											name="userId" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>userId</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="favoritedCnt"
											id="favoritedCnt"
											name="favoritedCnt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>favoritedCnt</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="commentCnt"
											id="commentCnt"
											name="commentCnt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>commentCnt</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="createdAt"
											id="createdAt"
											name="createdAt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>createdAt</b>
										</label>
									</section>
								</fieldset>

							</form>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							item-id="button-cancel"><s:text name="common.label.cancel"/></button>
						<button type="button" class="btn btn-primary"
							item-id="button-save"><s:text name="common.label.save"/></button>
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
						<h4 class="modal-title" id="myModalLabel">Image<s:text name="common.label.info"/></h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> Image<s:text name="common.label.info"/> </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">bitmapWidth:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="bitmapWidth">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">bitmapHeight:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="bitmapHeight">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">originalUrl:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="originalUrl">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">compressUrl:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="compressUrl">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">locationName:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="locationName">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">longitude:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="longitude">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">latitude:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="latitude">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">content:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="content">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">userId:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="userId">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">favoritedCnt:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="favoritedCnt">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">commentCnt:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="commentCnt">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">createdAt:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="createdAt">
											</label>
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
						<button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="common.label.close"/></button>
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
						<h4 class="modal-title" id="myModalLabel"><s:text name="common.label.search"/>Image<s:text name="common.label.info"/></h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> Image<s:text name="common.label.info"/> </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="bitmapWidth"
											id="bitmapWidth"
											name="bitmapWidth" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>bitmapWidth</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="bitmapHeight"
											id="bitmapHeight"
											name="bitmapHeight" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>bitmapHeight</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="originalUrl"
											id="originalUrl"
											name="originalUrl" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>originalUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="compressUrl"
											id="compressUrl"
											name="compressUrl" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>compressUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="locationName"
											id="locationName"
											name="locationName" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>locationName</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="longitude"
											id="longitude"
											name="longitude" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>longitude</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="latitude"
											id="latitude"
											name="latitude" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>latitude</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="content"
											id="content"
											name="content" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>content</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="userId"
											id="userId"
											name="userId" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>userId</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="favoritedCnt"
											id="favoritedCnt"
											name="favoritedCnt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>favoritedCnt</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="commentCnt"
											id="commentCnt"
											name="commentCnt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>commentCnt</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control"
											placeholder="createdAt"
											id="createdAt"
											name="createdAt" /> <b
											class="tooltip tooltip-top-right"><s:text name="common.label.input"/>createdAt</b>
										</label>
									</section>
								</fieldset>

							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							item-id="button-search-reset"><s:text name="common.label.reset"/></button>
						<button type="button" class="btn btn-primary"
							item-id="button-search"><s:text name="common.label.search"/></button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</section>


	<script
		src="${ctx}/webadmin/js/pages/image/image.js"></script>
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

