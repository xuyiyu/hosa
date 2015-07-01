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
					<i class="fa fa-group fa-fw "></i> 业务管理 <span>> 车型信息管理 </span>
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
								<h2>车型信息</h2>
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
													paging-sort-column="name">车型名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="seriesId">车系</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="price">报价</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="manufacturers">厂商</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="dischargeId">排量</th>
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_seriesId view"
													item-id="seriesId" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_price view"
													item-id="price" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_manufacturers view"
													item-id="manufacturers" item-view>&nbsp;</td>
													
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_dischargeId view"
													item-id="dischargeId" item-view>&nbsp;</td>
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
						<h4 class="modal-title" id="myModalLabel">设置车型型信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 车型信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车型名称"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入车型名称</b>
										</label>
									</section>
									<div class="row">
												<section class="col col-12">
													<select style="width:100%"
														class="select2" id="seriesId" name="seriesId">
															<option></option>
													</select>
												</section>
											</div>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="优惠报价"
											id="discountPrice" name="discountPrice" /><b
											class="tooltip tooltip-top-right">需要输入优惠报价</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="市场报价"
											id="marketPrice" name="marketPrice" /><b
											class="tooltip tooltip-top-right">需要输入市场报价</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车身长宽高"
											id="carrosserie" name="carrosserie" /> <b
											class="tooltip tooltip-top-right">需要输入车身长宽高</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车身结构"
											id="structure" name="structure" /> <b
											class="tooltip tooltip-top-right">需要输入车身结构</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="功率"
											id="capacity" name="capacity" /> <b
											class="tooltip tooltip-top-right">需要输入功率</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="扭矩"
											id="torsion" name="torsion" /> <b
											class="tooltip tooltip-top-right">需要输入扭矩</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="最高车速(km/h)"
											id="speed" name="speed" /> <b
											class="tooltip tooltip-top-right">需要输入最高车速(km/h)</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="加速时间"
											id="speedTime" name="speedTime" /> <b
											class="tooltip tooltip-top-right">需要输入加速时间</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="油耗"
											id="fuel" name="fuel" /> <b
											class="tooltip tooltip-top-right">需要输入油耗</b>
										</label>
									</section>
									<div class="row">
												<section class="col col-12">
													<select style="width:100%"
														class="select2" id="dischargeId" name="dischargeId">
															<option></option>
													</select>
												</section>
									</div>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="发动机型式"
											id="engineType" name="engineType" /> <b
											class="tooltip tooltip-top-right">需要输入发动机型式</b>
										</label>
									</section>	
									<div class="row">
												<section class="col col-12">
													<select style="width:100%"
														class="select2" id="gearbox" name="gearbox">
															<option></option>
													</select>
												</section>
									</div>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="轴距"
											id="wheelbase" name="wheelbase" /> <b
											class="tooltip tooltip-top-right">需要输入轴距</b>
										</label>
									</section>
									<!-- <section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="排放标准"
											id="effluent" name="effluent" /> <b
											class="tooltip tooltip-top-right">需要输入排放标准</b>
										</label>
									</section> -->
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="轮距"
											id="tread" name="tread" /> <b
											class="tooltip tooltip-top-right">需要输入轮距</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="厂商"
											id="manufacturers" name="manufacturers" /> <b
											class="tooltip tooltip-top-right">需要输入厂商</b>
										</label>
									</section>
									
									<div class="row">
												<section class="col col-12">
													<select style="width:100%"
														class="select2" id="level" name="level">
															<option></option>
													</select>
												</section>
									</div>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="颜色"
											id="color" name="color" /> <b
											class="tooltip tooltip-top-right">需要输入颜色</b>
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
											<input type="hidden" id="picUrl" name="picUrl" />
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
						<h4 class="modal-title" id="myModalLabel">车型信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 车型信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">部门编号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="departmentId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">seriesId:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="seriesId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">车型名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">报价:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="price"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">车身长宽高:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="carrosserie"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">车身结构:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="structure"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">功率:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="capacity"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">扭矩:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="torsion"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">最高车速(km/h):</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="speed"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">加速时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="speedTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">油耗:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="fuel"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">排量:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="discharge"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">发动机型式:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="engineType"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">汽车变速器:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="gearbox"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">轴距:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="wheelbase"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">排放标准:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="effluent"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">轮距:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="tread"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">厂商:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="manufacturers"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">级别:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="level"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">picStoragePath:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="picStoragePath"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">picUrl:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="picUrl"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">颜色:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="color"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">modified:</label>
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
						<h4 class="modal-title" id="myModalLabel">查询车型信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 车型信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车型名称"
											id="name" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入车型名称</b>
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


	<script src="${ctx}/js/platform/business/car.js"></script>
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

