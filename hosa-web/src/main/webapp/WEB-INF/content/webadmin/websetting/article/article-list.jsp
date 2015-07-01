<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<script src="${ctx}/js/plugin/summernote/summernote.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx}/css/bootstrap.min.css">
</head>

<body>
	<div id="content">

		<div class="row">
			<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
				<h1 class="page-title txt-color-blueDark">
					<i class="fa fa-linkedin-square fa-fw "></i> 微网站管理<span>> 文章管理 </span>
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
								<h2>文章信息</h2>
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
												<th class="col-xs-12 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="parentId">分类名称</th>
												<th class="col-xs-12 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="title">标题</th>
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
														
												<td class="hidden-xs col-sm-4 col-md-2 col-lg-2 filter_title view"
													item-id="parentId">&nbsp;</td>
												<td
													class="hidden-xs col-sm-4 col-md-2 col-lg-2 filter_title view"
													item-id="title">&nbsp;</td>
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
											<div class="col-xs-12 col-sm-6">
												<div class="pull-left">
													<a class="btn btn-default btn-sm" data-toggle="modal"
														data-target="#searchModal"><i class="fa fa-search"></i>
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
						<h4 class="modal-title" id="myModalLabel">设置文章信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 文章信息 </header>
								<fieldset>
									<section>
										<label class="select"> <select style="width:100%"
											class="select2" name="schemeId">
												<option selected>全部</option>
										</select>
										</label>
									</section>
									<section>
										<label class="select"> <select style="width:100%"
											class="select2" name="parentId">
												<option selected>全部</option>
										</select>
										</label>
									</section>
									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="标题"
											id="title" name="title" /> <b
											class="tooltip tooltip-top-right">需要输入标题</b>
										</label>
									</section>
									<section id='se_summary'>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="简介"
											id="summary" name="summary" /> <b
											class="tooltip tooltip-top-right">需要输入简介</b>
										</label>
									</section>
									
									<!-- <section>
										<label class="textarea"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="内容" rows="5"
												id="content" name="content"></textarea> <b
											class="tooltip tooltip-top-right">需要输入内容</b>
										</label>
									</section> -->
									<section id='se_content'>
										<label class="label">内容</label>
									</section>
									<section id='se_summernote'>
									<label class="input"> 
									<div class="widget-body no-padding"  style="margin:0;">
										<div class="summernote"></div>
									</div></label>
									</section>
									
									<!-- <section id="se_nextLink">
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="下级菜单链接"
											id="nextLink" name="nextLink" /> <b
											class="tooltip tooltip-top-right">需要输入下级菜单链接</b>
										</label>
									</section> -->
									<section id="se_sort">
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="顺序"
											id="sort" name="sort" /> <b
											class="tooltip tooltip-top-right">需要输入顺序</b>
										</label>
									</section>
									<section id="se_bgLink">
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="背景链接"
											id="bgLink" name="bgLink" /> <b
											class="tooltip tooltip-top-right">需要输入背景链接</b>
										</label>
									</section>

										<section class="col col-3">
											<label class="label">选择图片上传:</label>
									</section>
									<section>
										<div class="fileinput-button" item-id="preview">
											<img src=""
														style="top: 0px; width: 200px; height: 150px;">
													<button type="button" class="btn btn-danger btn-xs"
														style="position: absolute; top: 40px; left: 25px; z-index: 1000; display: none;">删除</button>
													<input type="file" name="uploadFile"
														data-url="${ctx}/webadmin/upload.htm">
												</div>
											<input type="hidden" id="bgUrl" name="bgUrl" />
									</section>
									
									
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
						<h4 class="modal-title" id="myModalLabel">文章信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 文章信息 </header>
								<fieldset>
								    
									<div class="row">
										<section class="col col-3">
											<label class="label">标题:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="title"> </label>
										</section>
									</div>
									
									
									
									<div class="row">
										<section class="col col-3">
											<label class="label">内容:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="content"> </label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3">
											<label class="label">图片URL:</label>
										</section>
										<section class="col col-9">
											<img src="" name="picUrl"  style="top: 0px; width: 200px; height: 150px;">
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
		
		<%-- <!-- Modal -->
		<div class="modal fade" class="table table-striped table-bordered table-hover table-ellipsis smart-form" id="iphoneViewModal" role="dialog"
			aria-labelledby="iphoneViewModal" aria-hidden="true">
			<div class="modal-dialog">
		<!-- 	<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
			</div> -->
			<iframe frameborder="0" hspace="0" src="${ctx }/webadmin/view/iphoneView.htm" id="lightviewContent" name="lightviewContent_80816" scrolling="auto" style="border: 0px; margin: 0px; padding: 0px; width: 600px; height: 800px;">
			</iframe>
			
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal --> --%>

		<!-- Modal -->
		<div class="modal fade" id="searchModal" role="dialog"
			aria-labelledby="searchModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查询文章信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 文章信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="标题"
											id="titleLike" name="titleLike" /> <b
											class="tooltip tooltip-top-right">需要输入标题</b>
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


	<script src="${ctx}/js/platform/websetting/article.js"></script>
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				settingCheckAll();
			});
			
			/* $('.summernote').summernote({
			  	height: 30,                
				minHeight: null,             
				maxHeight: null,            
				focus : false,
			  	toolbar: [
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			  ]
			});  */
			$('.summernote').summernote({
					height : 100,
					focus : false,
					tabsize : 2
				});
		})
	</script>
</body>
</html>

