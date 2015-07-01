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
					<i class="fa fa-group fa-fw "></i> 商城管理   <span>> 商品管理 </span>
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
								<h2>商品信息</h2>
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
													paging-sort-column="category_id">分类</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="name">名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="specifications">规格</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="price">价格</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="discount">折扣</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="on_time">上架时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="off_time">下架时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="number">数量</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="remaining_number">剩余数量</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="status">状态</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_categoryId view"
													item-id="goodsCategory.name" item-view>&nbsp;</td>										
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_specifications view"
													item-id="specifications" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_price view"
													item-id="price" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_discount view"
													item-id="discount" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_onTime view"
													item-id="onTimeString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_offTime view"
													item-id="offTimeString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_number view"
													item-id="number" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_remainingNumber view"
													item-id="remainingNumber" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_status view"
													item-id="statusString" item-view>&nbsp;</td>
												
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
						<h4 class="modal-title" id="myModalLabel">设置商品信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 商品信息 </header>
								<fieldset>
							
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="categoryId" name="categoryId">
															<option></option>
													</select>
										</label>
									</section>
									<section class="">
												<div class="fileinput-button" item-id="preview">
													<img src="${ctx}/img/user.png"
														style="top: 0px; width: 400px; height: 150px;">
													<button type="button" class="btn btn-danger btn-xs"
														style="position: absolute; top: 74px; left: 190px; z-index: 1000; display: none;">删除</button>
													<input type="file" name="uploadFile"
														data-url="${ctx}/webadmin/upload.htm">
												</div>
												<input type="hidden" id="picUrl" name="picUrl" />
												<input type="hidden" id="picStoragePath"
													name="picStoragePath" />
											</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="名称"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入名称</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="规格"
											id="specifications" name="specifications" /> <b
											class="tooltip tooltip-top-right">需要输入规格</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="价格"
											id="price" name="price" /> <b
											class="tooltip tooltip-top-right">需要输入价格</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="折扣"
											id="discount" name="discount" /> <b
											class="tooltip tooltip-top-right">需要输入折扣</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="数量"
											id="number" name="number" /> <b
											class="tooltip tooltip-top-right">需要输入数量</b>
										</label>
									</section>
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="status" name="status">
															<option></option>
															<option value="1">上架</option>
															<option value="2">下架</option>
													</select>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="商品介绍" rows="20"
												id="introduction" name="introduction"></textarea> <b
											class="tooltip tooltip-top-right">需要输入商品介绍</b>
										</label>
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
						<h4 class="modal-title" id="myModalLabel">商品信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 商品信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">分类编号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="categoryId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">商品编码:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="code"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">隶属部门:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="departmentId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">头像:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="picUrl"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">头像存储地址:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="picStoragePath"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">规格:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="specifications"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">价格:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="price"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">折扣:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="discount"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">上架时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="onTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">下架时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="offTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">数量:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="number"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">剩余数量:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="remainingNumber"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">状态{1：上架，2：下架}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="status"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">介绍:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="introduction"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">createdAt:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="createdAt"> </label>
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
						<h4 class="modal-title" id="myModalLabel">查询商品信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 商品信息 </header>
								<fieldset>
								
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="categoryId" name="categoryId">
															<option></option>
													</select>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="名称"
											id="nameLike" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入名称</b>
										</label>
									</section>
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="status" name="status">
															<option></option>
															<option value="1">上架</option>
															<option value="2">下架</option>
													</select>
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


	<script src="${ctx}/js/platform/mall/goods.js"></script>
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

