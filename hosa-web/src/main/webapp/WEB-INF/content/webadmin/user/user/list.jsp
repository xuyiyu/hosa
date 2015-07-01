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
					<i class="fa fa-group fa-fw "></i> 会员管理 <span>> 会员管理 </span>
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
								<h2>会员信息</h2>
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
													paging-sort-column="name">姓名</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="gender">性别</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="email">邮箱</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="mobile">联系方式</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="birthday">出生日期</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="status">状态</th>
													<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="source">来源</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="lastAccess">最后登录时间</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_gender view"
													item-id="genderString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_email view"
													item-id="email" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_mobile view"
													item-id="mobile" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_birthday view"
													item-id="birthdayString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_status view"
													item-id="statusString" item-view>&nbsp;</td>
													<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_source view"
													item-id="source" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_lastAccess view"
													item-id="lastAccessString" item-view>&nbsp;</td>
												
												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-id="button-modify">
															编辑 </a>
															
															 <a href="javascript:void(0);"
															class="btn btn-danger btn-xs" item-id="button-delete" style="display:none;">
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
														href="javascript:void(0);" item-id="button-toolbar-delete"  style="display:none;"><i
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
						<h4 class="modal-title" id="myModalLabel">设置会员信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input id="source" type="hidden" name="source" value="线下注册"/>
								<header> 会员信息 </header>
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
									<section class="col col-2">
													<label class="toggle"> <input type="checkbox"
														name="status" checked="checked"> <i
														data-swchon-text="有效" data-swchoff-text="无效"></i>
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
						<h4 class="modal-title" id="myModalLabel">用户表信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 用户表信息 </header>
								<fieldset>
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
											<label class="label">姓名:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">性别{1：男，2：女，0：未知}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="gender"> </label>
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
											<label class="label">联系方式:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="mobile"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">最高学历:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="educationalBackground"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">学历编号:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="educationalBackgroundId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">出生日期:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="birthday"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">所在地区:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="areaId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">登录名:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="loginId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">登录密码:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="password"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">头像:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="headImageUrl"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">头像存储地址:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="headImageStoragePath"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">videoUrl:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="videoUrl"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">状态{1：有效，0：无效}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="status"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">最后登录时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="lastAccess"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">创建时间:</label>
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
						<h4 class="modal-title" id="myModalLabel">查询用户表信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 用户表信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="隶属部门"
											id="departmentId" name="departmentId" /> <b
											class="tooltip tooltip-top-right">需要输入隶属部门</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="姓名"
											id="name" name="name" /> <b
											class="tooltip tooltip-top-right">需要输入姓名</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="性别{1：男，2：女，0：未知}"
											id="gender" name="gender" /> <b
											class="tooltip tooltip-top-right">需要输入性别{1：男，2：女，0：未知}</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="邮箱"
											id="email" name="email" /> <b
											class="tooltip tooltip-top-right">需要输入邮箱</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="联系方式"
											id="mobile" name="mobile" /> <b
											class="tooltip tooltip-top-right">需要输入联系方式</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="最高学历"
											id="educationalBackground" name="educationalBackground" /> <b
											class="tooltip tooltip-top-right">需要输入最高学历</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="学历编号"
											id="educationalBackgroundId" name="educationalBackgroundId" /> <b
											class="tooltip tooltip-top-right">需要输入学历编号</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="出生日期"
											id="birthday" name="birthday" /> <b
											class="tooltip tooltip-top-right">需要输入出生日期</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="所在地区"
											id="areaId" name="areaId" /> <b
											class="tooltip tooltip-top-right">需要输入所在地区</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="登录名"
											id="loginId" name="loginId" /> <b
											class="tooltip tooltip-top-right">需要输入登录名</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="登录密码"
											id="password" name="password" /> <b
											class="tooltip tooltip-top-right">需要输入登录密码</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="头像"
											id="headImageUrl" name="headImageUrl" /> <b
											class="tooltip tooltip-top-right">需要输入头像</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="头像存储地址"
											id="headImageStoragePath" name="headImageStoragePath" /> <b
											class="tooltip tooltip-top-right">需要输入头像存储地址</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="videoUrl"
											id="videoUrl" name="videoUrl" /> <b
											class="tooltip tooltip-top-right">需要输入videoUrl</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="状态{1：有效，0：无效}"
											id="status" name="status" /> <b
											class="tooltip tooltip-top-right">需要输入状态{1：有效，0：无效}</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="最后登录时间"
											id="lastAccess" name="lastAccess" /> <b
											class="tooltip tooltip-top-right">需要输入最后登录时间</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="创建时间"
											id="createdAt" name="createdAt" /> <b
											class="tooltip tooltip-top-right">需要输入创建时间</b>
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


	<script src="${ctx}/js/platform/user/user.js"></script>
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
				settingCheckAll();
			});
		})
	</script>
</body>
</html>

