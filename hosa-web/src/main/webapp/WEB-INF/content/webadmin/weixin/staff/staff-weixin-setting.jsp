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
					<i class="fa fa-group fa-fw "></i> 微信管理 <span>> 座席微信设置</span>
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
								<h2>座席微信设置</h2>
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
												<th style="width: 20px;"><label class="checkbox">
														<input type="checkbox" name="check-all"> <i></i>
												</label></th>
												<th class="col-xs-4 col-sm-4 col-md-3 col-lg-3 sorting"
													paging-sort-column="name">姓名</th>
												<th class="hidden-xs col-sm-3 col-md-2 col-lg-2 sorting"
													paging-sort-column="departmentId">用户组</th>
												<!--th class="col-xs-4 col-sm-2 col-md-2 col-lg-2 sorting"
													paging-sort-column="gender">性别</th>
												 th class="col-xs-4 col-sm-3 col-md-2 col-lg-2 sorting"
													paging-sort-column="isAvailable">是否有效</th-->
												<th class="hidden-xs hidden-sm col-md-3 col-lg-3 sorting"
													paging-sort-column="lastAccess">微信昵称</th>

												<th style="width: 100px;"></th> 
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td
													class="col-xs-4 col-sm-4 col-md-3 col-lg-3 filter_name view"
													item-id="staff.name" item-view>&nbsp;</td>
												<td
													class="hidden-xs col-sm-3 col-md-2 col-lg-2 filter_departmentId view"
													item-id="department.name" item-view>&nbsp;</td>
												
											
												<td
													class="hidden-xs hidden-sm col-md-3 col-lg-3 filter_lastAccess view"
													item-id="wxNickName" item-view>&nbsp;</td>

												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-id="button-modify">
															编辑 </a> <a href="javascript:void(0);"
															class="btn btn-danger btn-xs" item-id="button-delete">
															删除 </a>
													</div>
												</td >
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
														新增</a> <a class="btn btn-primary btn-sm"
														href="javascript:void(0);" item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a> <a
														class="btn btn-danger btn-sm" href="javascript:void(0);"
														item-id="button-toolbar-delete"><i class="fa fa-times"></i>
														删除</a>
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
						<h4 class="modal-title" id="myModalLabel">绑定微信信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> 座席信息 </header>
								<fieldset>
									<section>
										<label class="select"> <select style="width:100%"
											class="select2" name="departmentId">
												<option></option>
										</select>
										</label>
									</section>
									<section>
										<label class="select"> <select style="width:100%"
											class="select2" name="staffId">
												<option></option>
										</select>
										</label>
									</section>
									<section>
										<label class="select"> <div style="width:100%"
											class="select2" name="wxNickName"></div>
										</label>
									</section>
									<input type="hidden" name="openId">
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
		<div class="modal fade" id="searchModal" role="dialog"
			aria-labelledby="searchModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查询座席微信信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 座席微信信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="姓名" id="staffNameLike"
											name="staffNameLike" /> <b class="tooltip tooltip-top-right">需要输入姓名</b>
										</label>
									</section>
									<section>
										<label class="select">
											<select style="width:100%"
														class="select2" id="departmentId" name="departmentId">
															<option></option>
													</select>
										</label>
									</section>
									
									
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="微信昵称" id="wxNickNameLike"
											name="wxNickNameLike" /> <b class="tooltip tooltip-top-right">需要输入微信昵称</b>
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
		
		<!-- Modal -->
		<div class="modal fade" id="viewModal" role="dialog"
			aria-labelledby="viewModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">用户信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<header> 用户信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<section>
												<div class="fileinput-button">
													<img src="${ctx}/img/user.png"
														style="top: 0px; width: 80px; height: 100px;">
												</div>
											</section>
											
										</section>
										<section class="col col-8">
											<div class="row" style="margin: inherit;">
												<h1>
													<span item-id="name"></span> <br> <small
														item-id="department.name"></small>
												</h1>
												<ul class="list-unstyled">
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<i class="fa fa-male"></i>&nbsp;&nbsp;&nbsp;&nbsp;<span
																class="txt-color-darken" item-id="genderString"></span>
														</p>
													</li>
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<i class="fa fa-phone"></i>&nbsp;&nbsp;&nbsp;<span
																class="txt-color-darken" item-id="mobile"></span>
														</p>
													</li>

													<li style="margin-top: 10px;">
														<p class="text-muted">
															<i class="fa fa-heart"></i>&nbsp;&nbsp;<span
																class="txt-color-darken" item-id="isAvailableString"></span>
														</p>
													</li>
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<i class="fa fa-user"></i>&nbsp;&nbsp;&nbsp;<span
																class="txt-color-darken" item-id="loginId"></span>
														</p>
													</li>
												</ul>

											</div>
										</section>
									</div>

								</fieldset>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">拥有角色:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="role-list"> </label>
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

		
	</section>
	


	<script src="${ctx}/js/platform/weixin/staffweixinsetting.js"></script>
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

