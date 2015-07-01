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
					<i class="fa fa-group fa-fw "></i> 商城管理 <span>> 订单管理 </span>
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
								<h2>订单信息</h2>
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
													paging-sort-column="created_at">交易时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="code">订单号</th>
													<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="goods_snapshot_id">商品</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="user_id">用户名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="coupon_id">优惠券使用</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="integral">积分使用</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="transaction_price">实付金额</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="status">状态</th>												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_code view"
													item-id="createdAtString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_code view"
													item-id="code" item-view>&nbsp;</td>
													<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_code view"
													item-id="goodsSnapshot.name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_goodsId view"
													item-id="user.name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_goodsSnapshotId view"
													item-id="couponId" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_price view"
													item-id="integral" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_transactionPrice view"
													item-id="transactionPrice" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_userId view"
													item-id="statusString" item-view>&nbsp;</td>
												
												
												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-id="button-modify">
															编辑 </a> 
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
														搜索</a> <a class="btn btn-primary btn-sm" href="javascript:void(0);"
														item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a>
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
						<h4 class="modal-title" id="myModalLabel">设置订单信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 订单信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="订单编号"
											id="code" name="code" readonly/> <b
											class="tooltip tooltip-top-right">需要输入订单编号</b>
										</label>
									</section>
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="status" name="status">
															<option></option>
															<option value="1">未付款</option>
															<option value="2">已付款</option>
															<option value="3">发货</option>
															<option value="4">完成</option>
															<option value="5">取消</option>
													</select>
													</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="分类描述" rows="5"
												id="description" name="description"></textarea> <b
											class="tooltip tooltip-top-right">需要输入分类描述</b>
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
						<h4 class="modal-title" id="myModalLabel">订单信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 订单信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">订单编号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="code"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">商品名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="goodsSnapshot.name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">商品价格:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="price"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">实际价格:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="transactionPrice"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">用户编号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="user.name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">状态:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="statusString"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">备注:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="description"> </label>
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
						<h4 class="modal-title" id="myModalLabel">查询订单信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 订单信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="订单编号"
											id="codeLike" name="codeLike" /> <b
											class="tooltip tooltip-top-right">需要输入订单编号</b>
										</label>
									</section>
									
									<section>
									<label class="select"> <select style="width:100%"
														class="select2" id="status" name="status">
															<option></option>
															<option value="1">未付款</option>
															<option value="2">已付款</option>
															<option value="3">发货</option>
															<option value="4">完成</option>
															<option value="5">取消</option>
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


	<script src="${ctx}/js/platform/mall/goodsorder.js"></script>
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

