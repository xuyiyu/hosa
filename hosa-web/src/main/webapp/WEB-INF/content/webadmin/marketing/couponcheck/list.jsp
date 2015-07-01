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
					<i class="fa fa-group fa-fw "></i> 优惠券管理 <span>> 优惠券审核 </span>
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
								<h2>优惠券信息</h2>
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
													paging-sort-column="name">优惠券名称</th>
												<th class="hidden-xs col-sm-2 col-md-2 col-lg-2 sorting"
													>优惠券类型</th>
												<th class="hidden-xs col-sm-4 col-md-2 col-lg-2 ">优惠券金额</th>
												<th class="hidden-xs hidden-sm col-md-4 col-lg-5">日期</th>
												
												<th style="width: 100px;"></th>
											</tr>
										</thead>
										<tbody class="list">
											<tr style="display:none;" item-template>
												<td><label class="checkbox"> <input
														type="checkbox" name="checkRow"> <i></i></label></td>
												<td class="col-xs-12 col-sm-4 col-md-2 col-lg-2 filter_name view"
													item-id="name" item-view>&nbsp;</td>
												<td
													class="hidden-xs col-sm-4 col-md-2 col-lg-2  view"
													item-id="typeString">&nbsp;</td>
												<td
													class="hidden-xs hidden-sm col-md-4 col-lg-5  view"
													item-id="amountValue">&nbsp;</td>
												<td class="hidden-xs col-sm-2 col-md-2 col-lg-2 view"
													item-id="submitTimeString">&nbsp;</td>
												<td>
													<div class="btn-group  btn-group-justified">
														<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " item-view item-id="button-view" >
															详情 </a>
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs" item-id="button-delete" >
															审核</a>
														<a href="javascript:void(0);"
															class="btn btn-danger btn-xs " item-id="button-modify" >
															驳回</a> 
													</div>
												</td>
											</tr>

										</tbody>
									</table>
									<div class="dt-bottom-row">
										<div class="row" style="margin-top: auto;">
											<div class="col-xs-12 col-sm-6">
												<div class="pull-left" >
													<a class="btn btn-default btn-sm" data-toggle="modal" 
														data-target="#searchModal"><i class="fa fa-search"></i>
														搜索</a> 
													<a class="btn btn-primary btn-sm" style="display:none;"
														item-id="button-toolbar-add"><i class="fa fa-plus"></i>
														新增</a> 
													<a class="btn btn-primary btn-sm" href="javascript:void(0);" style="display:none;"
														item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a>
													 <a class="btn btn-danger btn-sm" style="display:none;"
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
		<div class="modal fade" id="selectEditModal" role="dialog"
			aria-labelledby="editModal" aria-hidden="true">
			<div class="modal-dialog" style="width: 700px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">选择优惠券类别</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form class="smart-form">
								<div class="row" style=" margin-bottom: 100px;">
									<div class="col col-6">
											<section style="margin-left: 100px;margin-top: 100px;">
													<label class="label"><a id="voucherPointer" style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer" >代金券</a></label>
													
													<div class="note">
														直接给所有会员派发优惠券
													</div>
												</section>

									</div>
									<div class="col col-6">
											<section style="margin-left: 100px;  margin-top: 100px;">
													<label class="label"><a id="giftPointer" style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer;" >礼品券</a></label>
													
													<div class="note">
														参加活动得实惠
													</div>
												</section>

									</div>
								</div>
							
							
							</form>
													
							
							
						</div>

					</div>
					
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		<!-- Modal -->
		<div class="modal fade" id="editModal" role="dialog"
			aria-labelledby="editModal" aria-hidden="true">
			<div class="modal-dialog" style="width: 700px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">驳回</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="reject-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<section>
									<label class="textarea">  										
										<textarea rows="5" id="rejectReason" name="rejectReason" placeholder="驳回理由"></textarea> 
									</label>
								</section>
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
		<div class="modal fade" id="editModal" role="dialog"
			aria-labelledby="editModal" aria-hidden="true">
			<div class="modal-dialog" style="width: 700px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">优惠券信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input id="type" type="hidden" name="type"/>
								<input id="style" type="hidden" name="style"/>
								<div class="row">
									<section class="col col-6">
										<section style="margin-right: 14px;margin-bottom:0px;">
										<div style="display: block;border-bottom: 1px dashed rgba(0,0,0,.2);background: #fff;font-size: 16px;font-weight: 300;color: #232323;margin-bottom:15px;">
										优惠券信息
										</div>
											<section>
												<label class="input"> <i
												class="icon-append fa fa-question-circle"></i> <input
												type="text" class="form-control" placeholder="用户组名称"
												id="name" name="name" /> <b
												class="tooltip tooltip-top-right">需要输入优惠券名称</b>
												</label>
											</section>
											<section>
												<div class="col-12 input">
														<input class="form-control" name="value" id="value" placeholder=" 面值金额" type="text" list="list">
														<datalist id="list">
															<option value="200">200</option>
															<option value="500">500</option>
															<option value="1000">1000</option>
														</datalist>
													</div>
											</section>
											
											
											<section>
												<div class="input-group">
																	<span class="input-group-addon">自活动开始</span>
																	<input class="form-control" id="validDays" name="validDays" type="text">
																	<span class="input-group-addon" style="display:none;"></span>
																	<span class="input-group-addon">天有效</span>
																</div>
											</section>
											
											<section style="margin-bottom:0px;">
												<label class="input"> <i
												class="icon-append fa fa-question-circle"></i> <input
												type="text" class="form-control" placeholder="总发行量（张）"
												id="amount" name="amount" /> <b
												class="tooltip tooltip-top-right">需要输入优惠券总发行量</b>
												</label>
											</section>
											
										</section>
									</section>
									
									<section class="col col-6">
									<section style="margin-left: 10px;margin-right: 14px;margin-bottom:0px;">
										<div style="display: block;border-bottom: 1px dashed rgba(0,0,0,.2);background: #fff;font-size: 16px;font-weight: 300;color: #232323;margin-bottom:15px;">
										优惠券预览
										</div>
										
										<div name="ticketCard" style="width: 100%;height: 170px;border: solid 1px;">
											<div class="row" style="margin-top: 20px;">
												<div class="col col-8"><label style=" margin-left: 30px;" name="nameView"></label></div>
												<!-- <div class="col col-4" style=""><label>使用范围</label></div> -->
											</div>
											<div class="row" style="margin-top: 30px;font-size: xx-large;">
												<div class="col col-7" style="padding-left: 40px;">￥<label name="valueView"></label></div>
												<div class="col col-5">领取</div>
											</div>
											
											<div class="" style="border-top:solid 1px;margin-top: 30px;padding-left:30px;">
												有效期：<label style="margin-top: 5px;" name="validDaysString"></label>
											</div>
										</div>
										
										
									</section>
									
									</section>
									
								</div>
								<!-- 
								<section>
									<div class="row">
											<div class="col col-8">
												<div class="input-group">
													<span class="input-group-addon">到店消费满</span>
													<input class="form-control" placeholder="不添表示无限制" type="text">
													<span class="input-group-addon" style="display:none;"></span>
													<span class="input-group-addon" >元</span>
												</div>
											</div>
											<div class="col col-1" >
												
											
											</div>
											<div class="col col-3" >
												<label class="checkbox-inline">
															  <input type="checkbox" class="checkbox style-0" >
															  <span>不找零</span>
														</label>
											
											</div>
									</div>
								</section> -->
								<section>
									<div class="row">
										<div class="col col-2">
											<label class="label">允许转赠12</label>
										</div>
										<div class="col col-10">
													<div class="inline-group">
														<label class="radio">
															<input type="radio" name="allowDonationRadio"  checked="checked" value="1">
															<i></i>允许</label>
														<label class="radio">
															<input type="radio" name="allowDonationRadio" value="0">
															<i></i>不允许</label>
														</div>
														
										</div>
									
									</div>
								</section>
								<section>
									<div class="row">
										<div class="col col-2">
											<label class="label">选择样式</label>
										</div>
										<div class="col col-10">
													<div class="inline-group">
														
														<label class="" name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-red" href="javascript:void(0);" ></a>
														</label>
														<label class="" name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-redLight" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-orangeDark" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-orange" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-pink" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-blue" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-purple" href="javascript:void(0);" ></a>
														</label>
														<label class=""  name="color-item" style="margin-right:30px;">
															<a data-toggle="dropdown" class="dropdown-toggle color-box selector bg-color-darken" href="javascript:void(0);" ></a>
														</label>
													</div>
										</div>
									
									</div>
								</section>
								<section>
									<label class="textarea">  										
										<textarea rows="5" id="scope" name="scope" placeholder="使用范围"></textarea> 
									</label>
								</section>
								<section>
									<div class="row">
									<div class="col col-5">
													<label class="label">未选择服务</label>
													<label class="select select-multiple">
														<select name="unselect-service" multiple="" class="custom-scroll">
															
															
														</select> </label>
									</div>
									<div class="col col-2">
										<div class="row">
														<div class="col col-4"></div>
														<div class="col col-4" style="padding-top: 20px;">
														<label class=" ">
																<button name="move-right" type="button" class="btn btn-default" style="width: 30px;">
																>
															</button>
															</label>
															<label class=" ">
																<button name="move-left" type="button" class="btn btn-default" style="width: 30px;" >
																&lt;
															</button>
															</label>
															<label class=" ">
																<button name="move-aright" type="button" class="btn btn-default"  style="width: 30px;">
																>>
															</button>
															</label>
															<label class=" ">
																<button name="move-aleft" type="button" class="btn btn-default"  style="width: 30px;">
																&lt;&lt;
															</button>
															</label>
															
														</div>
										</div>
									</div>	
									<div class="col col-5">
										<label class="label">未选择服务</label>
													<label class="select select-multiple">
														<select name="selected-service" multiple="" class="custom-scroll">
															
														</select> </label>
									
									</div>
									</div>			
								</section>
								
								
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
						<h4 class="modal-title" id="myModalLabel">优惠券信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input id="type" type="hidden" name="type"/>
								<input id="style" type="hidden" name="style"/>
								<div class="row">
									<section class="col col-6">
										<section style="margin-right: 14px;margin-bottom:0px;">
										<div style="display: block;border-bottom: 1px dashed rgba(0,0,0,.2);background: #fff;font-size: 16px;font-weight: 300;color: #232323;margin-bottom:15px;">
										优惠券信息
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">优惠券名称:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="name"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">面值金额:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="value"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">有效日期:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="validDaysString"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">总发行量:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="amount"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">允许转赠:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="allowDonation"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">适用范围:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="scope"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-3">
												<label class="label">适用服务:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="categoriesString"> </label>
											</section>
										</div>
										<!-- 
										<div class="row">
											<section class="col col-3">
												<label class="label">创建人:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="staffName"> </label>
											</section>
										</div> -->
										<div class="row">
											<section class="col col-3">
												<label class="label">状态:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="statusString"> </label>
											</section>
										</div>
										<div class="row" name="rejectReasonDiv">
											<section class="col col-3">
												<label class="label">驳回理由:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="rejectReason"> </label>
											</section>
										</div>
										
											
										</section>
									</section>
									
									<section class="col col-6">
									<section style="margin-left: 10px;margin-right: 14px;margin-bottom:0px;">
										<div style="display: block;border-bottom: 1px dashed rgba(0,0,0,.2);background: #fff;font-size: 16px;font-weight: 300;color: #232323;margin-bottom:15px;">
										优惠券预览
										</div>
										
										<div name="ticketCardView" style="width: 100%;height: 170px;border: solid 1px;">
											<div class="row" style="margin-top: 20px;">
												<div class="col col-8"><label style=" margin-left: 30px;" item-id="name"   ></label></div>
												<!-- <div class="col col-4" style=""><label>使用范围</label></div> -->
											</div>
											<div class="row" style="margin-top: 30px;font-size: xx-large;">
												<div class="col col-7" style="padding-left: 40px;">￥<label item-id="value"   ></label></div>
												<div class="col col-5">领取</div>
											</div>
											
											<div class="" style="border-top:solid 1px;margin-top: 30px;padding-left:30px;">
												有效期：<label style="margin-top: 5px;" name="validDaysString"></label>
											</div>
										</div>
										
										
									</section>
									
									</section>
									
								</div>
								
								
								
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
						<h4 class="modal-title" id="myModalLabel">查询优惠卷信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 优惠券信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="优惠券名称"
											id="nameLike" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入优惠券名称</b>
										</label>
									</section>
									<section>
													<label class="select">
														<select name="type">
															<option value="">优惠券类型</option>
															<option value="1">代金券</option>
															<option value="2">礼品券</option>
														</select> <i></i> </label>
												</section>
									<section class="row">
										<div class="col col-6" style="" >
										<label class="input"> <i class="icon-append fa fa-calendar"></i>
											<input type="text" name="submitTimeBegin" id="startdate"  class="hasDatepicker">
										</label>
										
										</div>
										<div class="col col-6">
											<label class="input"> <i class="icon-append fa fa-calendar"></i>
												<input type="text" name="submitTimeEnd" id="finishdate"  class="hasDatepicker">
											</label>
											
										</div>
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


	<script src="${ctx}/js/platform/marketing/couponcheck.js"></script>
	<script>
		$(function() {
		
		$("#startdate").datetimepicker({
				    format: 'yyyy-mm-dd',
				    autoclose: true,
			        todayBtn: true,
			        startView: 2,
					minView: 2,
				    language: "zh-CN"
				});
				$("#finishdate").datetimepicker({
				    format: 'yyyy-mm-dd',
				    autoclose: true,
			        todayBtn: true,
			        startView: 2,
					minView: 2,
				    language: "zh-CN"
				});
			$("[rel=tooltip]").tooltip();

			$().ready(function() {
				settingCheckAll();
			});
		})
	</script>
</body>
</html>

