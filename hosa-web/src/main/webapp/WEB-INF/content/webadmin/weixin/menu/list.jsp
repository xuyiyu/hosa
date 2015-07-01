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
					<i class="fa fa-comments fa-fw "></i> 微信管理 <span>> 微信菜单管理 </span>
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
								<h2>微信菜单信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body ">
									<div class="widget-body-toolbar">
										<div class="row">
											<div class="pull-left col-sm-6">
												<a class="btn btn-primary btn-sm"
													item-id="button-toolbar-add"><i class="fa fa-plus"></i>
													新增</a>
													<a class="btn btn-primary btn-sm"
													item-id="button-toolbar-sync"><i class="fa fa-plus"></i>
													同步到微信</a>
											</div>

										</div>
									</div>
									<div class="dd" id="menu-list">
									
									<li class="dd-item dd3-item" style="display:none;" item-template>
												<div class="dd-handle dd3-handle">Drag</div>
												<div class="dd3-content" >
													<label class="view" item-view></label>

													<div class="pull-right">
														<a class="btn btn-primary btn-xs"
														item-id="button-add"><i class="fa fa-plus"></i>
														新增</a> <a class="btn btn-primary btn-xs" href="javascript:void(0);"
														item-id="button-modify"><i
														class="fa fa-pencil"></i> 修改</a> <a class="btn btn-danger btn-xs"
														href="javascript:void(0);" item-id="button-delete"><i
														class="fa fa-times"></i> 删除</a>
													</div>

												</div>
											</li>
											
										<ol class="dd-list list">
										
										</ol>
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
						<h4 class="modal-title" id="myModalLabel">设置微信菜单信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input id="parentId" type="hidden" name="parentId"/>
								<header> 微信菜单信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="菜单名称"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入菜单名称</b>
										</label>
									</section>
									<section>
									<label class="select">
											<select style="width:100%"
														class="select2" id="materialId" name="materialId">
															<option></option>
													</select>
										</label>
									</section>
									<div class="row" item-id="authorize" style="display:none;">
												<section class="col col-4">
													<label class="toggle"> <input type="checkbox"
														name="authorize" > <i
														data-swchon-text="是" data-swchoff-text="否"></i> 链接授权</label>

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
						<h4 class="modal-title" id="myModalLabel">微信菜单信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 微信菜单信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">菜单名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">菜单内容:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="material.name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">链接授权:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="authorizeString"> </label>
										</section>
									</div>
								</fieldset>
							</form>
						</div>

					</div>
					<div class="modal-footer">
					<button style="display:none;" type="button" class="btn btn-default pull-left" item-id="button-view-previous"><i class="fa fa-angle-left"></i></button>
					<button style="display:none;" type="button" class="btn btn-default pull-left" item-id="button-view-next"><i class="fa fa-angle-right"></i></button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

	</section>


	<script src="${ctx}/js/platform/weixin/weixinmenu.js"></script>
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

