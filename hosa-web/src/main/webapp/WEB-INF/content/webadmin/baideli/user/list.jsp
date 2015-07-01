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
					<i class="fa fa-group fa-fw "></i> 百得利管理 <span>> 百得利用户管理 </span>
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
								<h2>百得利用户信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body no-padding">
									<div class="widget-body-toolbar">
										<div class="row">
											<div class="pull-left col-sm-3">
											<a class="btn btn-primary btn-sm"
														item-id="button-toolbar-addtogroup"><i class="fa fa-plus"></i>
														添加到组</a>
														<a class="btn btn-primary btn-sm"
														item-id="button-toolbar-delfromgroup"><i class="fa fa-times"></i>
														从组移除</a>
											
											</div>
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
														type="checkbox" name="check-all" data-user-id=""> <i></i></label></th>
														<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="name">名称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="level">级别</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="available_over">可用余额</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="idCard">身份证号</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="plate">车牌号</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="card">会员卡</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="created_at">创建时间</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="integration">积分</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="models">车型</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="discount">折扣</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="frame_no">车架号</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
														<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_level view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_level view"
													item-id="levelString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_availableOver view"
													item-id="availableOver" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_idCard view"
													item-id="idCard" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_plate view"
													item-id="plate" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_card view"
													item-id="card" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_createdAt view"
													item-id="createdAtString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_integration view"
													item-id="integration" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_models view"
													item-id="models" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_discount view"
													item-id="discount" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_frameNo view"
													item-id="frameNo" item-view>&nbsp;</td>
												
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
						<h4 class="modal-title" id="myModalLabel">设置百得利用户信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input type="hidden"id="userId" name="userId" />
								<input id="source" type="hidden" name="source" value="线下注册"/>
								<header> 百得利用户信息 </header>
								<fieldset>
									<div class="row">
												<section class="col col-9">
													<label class="input"> <i
														class="icon-append fa fa-question-circle"></i> <input
														type="text" class="form-control" placeholder="姓名"
														id="name" name="name" /> <b
														class="tooltip tooltip-top-right">需要输入姓名</b>
													</label>
												</section>
												<section class="col col-2">
													<label class="toggle"> <input type="checkbox"
														name="gender" checked="checked"> <i
														data-swchon-text="男" data-swchoff-text="女"></i></label>
												</section>
											</div>
											
										<div class="row">
												<section class="col col-6">
													<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="邮箱"
											id="email" name="email" /> <b
											class="tooltip tooltip-top-right">需要输入邮箱</b>
										</label>
												</section>
												<section class="col col-6">
													<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="出生日期"
											id="birthday" name="birthday" /> <b
											class="tooltip tooltip-top-right">需要输入出生日期</b>
										</label>
												</section>
											</div>	
									
									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="联系方式"
											id="mobile" name="mobile" /> <b
											class="tooltip tooltip-top-right">需要输入联系方式</b>
										</label>
									</section>
								</fieldset>
								
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="身份证号"
											id="idCard" name="idCard" /> <b
											class="tooltip tooltip-top-right">需要输入身份证号</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车牌号"
											id="plate" name="plate" /> <b
											class="tooltip tooltip-top-right">需要输入车牌号</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="会员卡"
											id="card" name="card" /> <b
											class="tooltip tooltip-top-right">需要输入会员卡</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车型"
											id="models" name="models" /> <b
											class="tooltip tooltip-top-right">需要输入车型</b>
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
											type="text" class="form-control" placeholder="车架号"
											id="frameNo" name="frameNo" /> <b
											class="tooltip tooltip-top-right">需要输入车架号</b>
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
						<h4 class="modal-title" id="myModalLabel">百得利用户信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 百得利用户信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">用户名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">性别:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="genderString"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">邮箱:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="email"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">出生日期:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="birthdayString"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">联系方式:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="mobile"> </label>
										</section>
									</div>
									<!-- 
									<div class="row">
										<section class="col col-3">
											<label class="label">类型{1：标准会员，2：正式会员}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="type"> </label>
										</section>
									</div>
									 -->
									<div class="row">
										<section class="col col-3">
											<label class="label">级别:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="levelString"> </label>
										</section>
									</div>
									<!-- 
									<div class="row">
										<section class="col col-3">
											<label class="label">有效期:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="valid"> </label>
										</section>
									</div>
									 -->
									<div class="row">
										<section class="col col-3">
											<label class="label">可用余额:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="availableOver"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">身份证号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="idCard"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">车牌号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="plate"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">会员卡:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="card"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">创建时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="createdAtString"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">积分:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="integration"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">车型:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="models"> </label>
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
											<label class="label">车架号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="frameNo"> </label>
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
						<h4 class="modal-title" id="myModalLabel">查询百得利用户信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 百得利用户信息 </header>
								<fieldset>									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i><select style="width:100%"
														class="select2" id="groupId" name="groupId">
												<option value=""></option>
												</select>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="会员名称"
											id="nameLike" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入会员名称</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="联系方式"
											id="mobileLike" name="mobileLike" /> <b
											class="tooltip tooltip-top-right">需要输入联系方式</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i>
											<select style="width:100%"
														class="select2" id="level" name="level">
															<option ></option>
															<option value="">全部</option>
															<option value="0">准会员</option>
															<option value="1">普通会员</option>
															<option value="2">vip</option>
															<option value="3">金卡</option>
															<option value="4">银卡</option>
													</select>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="身份证号"
											id="idCardLike" name="idCardLike" /> <b
											class="tooltip tooltip-top-right">需要输入身份证号</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车牌号"
											id="plateLike" name="plateLike" /> <b
											class="tooltip tooltip-top-right">需要输入车牌号</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="会员卡"
											id="cardLike" name="cardLike" /> <b
											class="tooltip tooltip-top-right">需要输入会员卡</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车型"
											id="modelsLike" name="modelsLike" /> <b
											class="tooltip tooltip-top-right">需要输入车型</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="车架号"
											id="frameNoLike" name="frameNoLike" /> <b
											class="tooltip tooltip-top-right">需要输入车架号</b>
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
		
		<div class="modal fade" id="groupModal" role="dialog"
			aria-labelledby="groupModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">百得利用户组信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 百得利用户组信息 </header>
								<fieldset>
									
										<select style="width:100%"
														class="select2" id="groupId"  name="groupId">
												<option value=""></option>
												</select>
									
								</fieldset>

							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							item-id="button-group-cancel">取消</button>
						<button type="button" class="btn btn-primary"
							item-id="button-group-save">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		
	</section>


	<script src="${ctx}/js/platform/baideli/baideliuser.js"></script>
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				$("#birthday").datetimepicker({
				    format: 'yyyy-mm-dd',
				    autoclose: true,
			        todayBtn: true,
			        startView: 2,
					minView: 2,
				    language: "zh-CN"
				});
				$("[name=groupId]").select2({
					placeholder: "选择组",
					allowClear: true
				});
				settingCheckAll();
			});
		})
	</script>
</body>
</html>

