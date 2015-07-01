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
					<i class="fa fa-comments fa-fw "></i> 微信管理 <span>> 微信用户管理 </span>
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
								<h2>微信用户信息</h2>
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
													paging-sort-column="nick_name">昵称</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="sex">性别</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="city">城市</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="country">国家</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="province">省份</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2"
													>头像</th>
												<th class="col-xs-4 col-sm-4 col-md-2 col-lg-2 sorting"
													paging-sort-column="subscribe_time">关注时间</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_nickName view"
													item-id="nickName" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_sex view"
													item-id="sexString" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_city view"
													item-id="city" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_country view"
													item-id="country" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_province view"
													item-id="province" item-view>&nbsp;</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_headImgUrl view"
													 item-view>
													<div item-id="headImgUrl" class="nailthumb-container" >
														<img src="${ctx}/img/user.png" style="width: 60px; height: 60px;">
													</div>
												</td>
												<td class="col-xs-4 col-sm-4 col-md-2 col-lg-2 filter_subscribeTime view"
													item-id="subscribeTimeString" item-view>&nbsp;</td>
												
												<td>
													<div class="btn-group  btn-group-justified">
														
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
														搜索</a> 
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
						<h4 class="modal-title" id="myModalLabel">设置WeixinUsers信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<header> WeixinUsers信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="用户标识"
											id="openId" name="openId" /> <b
											class="tooltip tooltip-top-right">需要输入用户标识</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="departmentId"
											id="departmentId" name="departmentId" /> <b
											class="tooltip tooltip-top-right">需要输入departmentId</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="昵称"
											id="nickName" name="nickName" /> <b
											class="tooltip tooltip-top-right">需要输入昵称</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="性别{1：男，2：女，3：未知}"
											id="sex" name="sex" /> <b
											class="tooltip tooltip-top-right">需要输入性别{1：男，2：女，3：未知}</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="城市"
											id="city" name="city" /> <b
											class="tooltip tooltip-top-right">需要输入城市</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="国家"
											id="country" name="country" /> <b
											class="tooltip tooltip-top-right">需要输入国家</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="省份"
											id="province" name="province" /> <b
											class="tooltip tooltip-top-right">需要输入省份</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="语言"
											id="language" name="language" /> <b
											class="tooltip tooltip-top-right">需要输入语言</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="头像"
											id="headImgUrl" name="headImgUrl" /> <b
											class="tooltip tooltip-top-right">需要输入头像</b>
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
											type="text" class="form-control" placeholder="关注时间"
											id="subscribeTime" name="subscribeTime" /> <b
											class="tooltip tooltip-top-right">需要输入关注时间</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="customerName"
											id="customerName" name="customerName" /> <b
											class="tooltip tooltip-top-right">需要输入customerName</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="birthday"
											id="birthday" name="birthday" /> <b
											class="tooltip tooltip-top-right">需要输入birthday</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="mobile"
											id="mobile" name="mobile" /> <b
											class="tooltip tooltip-top-right">需要输入mobile</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="officePhone"
											id="officePhone" name="officePhone" /> <b
											class="tooltip tooltip-top-right">需要输入officePhone</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="homePhone"
											id="homePhone" name="homePhone" /> <b
											class="tooltip tooltip-top-right">需要输入homePhone</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="email"
											id="email" name="email" /> <b
											class="tooltip tooltip-top-right">需要输入email</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="qq"
											id="qq" name="qq" /> <b
											class="tooltip tooltip-top-right">需要输入qq</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="msn"
											id="msn" name="msn" /> <b
											class="tooltip tooltip-top-right">需要输入msn</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="postcode"
											id="postcode" name="postcode" /> <b
											class="tooltip tooltip-top-right">需要输入postcode</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="unreadCount"
											id="unreadCount" name="unreadCount" /> <b
											class="tooltip tooltip-top-right">需要输入unreadCount</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="lastInteractTime"
											id="lastInteractTime" name="lastInteractTime" /> <b
											class="tooltip tooltip-top-right">需要输入lastInteractTime</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="lastMessageId"
											id="lastMessageId" name="lastMessageId" /> <b
											class="tooltip tooltip-top-right">需要输入lastMessageId</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="modified"
											id="modified" name="modified" /> <b
											class="tooltip tooltip-top-right">需要输入modified</b>
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
						<h4 class="modal-title" id="myModalLabel">WeixinUsers信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> WeixinUsers信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">用户标识:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="openId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">departmentId:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="departmentId"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">昵称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="nickName"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">性别{1：男，2：女，3：未知}:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="sex"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">城市:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="city"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">国家:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="country"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">省份:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="province"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">语言:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="language"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">头像:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="headImgUrl"> </label>
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
											<label class="label">关注时间:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="subscribeTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">customerName:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="customerName"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">birthday:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="birthday"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">mobile:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="mobile"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">officePhone:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="officePhone"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">homePhone:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="homePhone"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">email:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="email"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">qq:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="qq"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">msn:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="msn"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">postcode:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="postcode"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">unreadCount:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="unreadCount"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">lastInteractTime:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="lastInteractTime"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">lastMessageId:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="lastMessageId"> </label>
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
						<h4 class="modal-title" id="myModalLabel">查询微信用户信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 微信用户信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="昵称"
											id="nickName" name="nickNameLike" /> <b
											class="tooltip tooltip-top-right">需要输入昵称</b>
										</label>
									</section>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> 
											<select style="width:100%"
														class="select2" id="sex" name="sex">
															<option ></option>
															<option value="">全部</option>
															<option value="1">男</option>
															<option value="2">女</option>
													</select>
										</label>
									</section>
									<div class="row">
										<section class="col col-6">
											<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="开始关注时间"
											id="subscribeTimeBegin" name="subscribeTimeBegin" /> <b
											class="tooltip tooltip-top-right">需要输入关注时间</b>
										</label>
										</section>
										<section class="col col-6">
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="结束关注时间"
											id="subscribeTimeEnd" name="subscribeTimeEnd" /> <b
											class="tooltip tooltip-top-right">需要输入关注时间</b>
										</label>
										</section>
									</div>
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


	<script src="${ctx}/js/platform/weixin/weixinusers.js"></script>
	<script>
		$(function() {
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				$("#subscribeTimeBegin").datetimepicker({
				    format: 'yyyy-mm-dd',
				    autoclose: true,
			        todayBtn: true,
			        startView: 2,
					minView: 2,
				    language: "zh-CN"
				});
				$("#subscribeTimeEnd").datetimepicker({
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

