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
					<i class="fa fa-group fa-fw "></i> 优惠券管理 <span>> 促销活动</span>
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
													paging-sort-column="name">活动名称</th>
												<th class="hidden-xs col-sm-4 col-md-2 col-lg-2 ">活动开始时间</th>
												<th class="hidden-xs hidden-sm col-md-4 col-lg-5">活动结束时间</th>
												<th class="hidden-xs col-sm-2 col-md-2 col-lg-2 sorting"
													>活动状态</th>
												<th class="hidden-xs col-sm-2 col-md-2 col-lg-2 sorting"
													>活动类型</th>
												<th style="width: 200px;"></th>
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
													item-id="beginTimeString">&nbsp;</td>
												<td
													class="hidden-xs hidden-sm col-md-4 col-lg-5  view"
													item-id="endTimeString">&nbsp;</td>
												<td class="hidden-xs col-sm-2 col-md-2 col-lg-2 view"
													item-id="status">&nbsp;</td>
												
												<td class="hidden-xs col-sm-2 col-md-2 col-lg-2 view"
													item-id="type">&nbsp;</td>
												<td>
													<div class="">
													 
														
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " status1 item-id="button-preview" style="display:none;">
															预览</a>
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " status1 item-id="button-modify" style="display:none;">
															编辑</a>
															<a href="javascript:void(0);"
															class="btn btn-danger btn-xs"  status1 item-id="button-delete" style="display:none;">
															删除</a>
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " status2 item-id="button-apart" style="display:none;">
															预留优惠券</a> 
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " status2 item-id="button-print" style="display:none;">
															打印优惠券</a> 
															<a href="javascript:void(0);"
															class="btn btn-primary btn-xs " status2 status3 item-id="button-export" style="display:none;">
															导出名单</a> 
															 
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
														新增</a> 
														
														<!-- 
														<a class="btn btn-primary btn-sm" href="javascript:void(0);"
														item-id="button-toolbar-modify"><i
														class="fa fa-pencil"></i> 修改</a> <a class="btn btn-danger btn-sm"
														href="javascript:void(0);" item-id="button-toolbar-delete"><i
														class="fa fa-times"></i> 删除</a>
														
														 -->
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
						<h4 class="modal-title" id="myModalLabel">选择活动类别</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form class="smart-form">
								<div class="row" style="">
									<div class="col col-6">
											<section style="margin-left: 50px;margin-top: 100px;">
													<label class="label"><a id="couponPointer" showType="1"  style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer" >派发优惠券活动</a></label>
													
													<div class="note">
														针对所有会员或特定会员，直接推送优惠劵信息，收到信息的会员点击领取相关优惠券
													</div>
												</section>

									</div>
									<div class="col col-6">
											<section style="margin-left: 50px;  margin-top: 100px;">
													<label class="label"><a id="luckyDrawPointer" showType="3"  style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer;" >抽奖活动</a></label>
													
													<div class="note">
														针对所有会员或特定会员，直接推送抽奖活动信息，收到信息的会员点击报名参加抽奖活动
													</div>
												</section>

									</div>
								</div>
								<div class="row" style=" margin-bottom: 100px;">
									<div class="col col-6">
											<section style="margin-left: 50px;margin-top: 100px;">
													<label class="label"><a id="marketingPointer" showType="2" style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer" >优惠促销活动</a></label>
													
													<div class="note">
														通知所有会员或特定会员，参加优惠促销活动，享受相关优惠信息。在设置活动时可选择优惠劵。
													</div>
												</section>

									</div>
									<div class="col col-6">
											<section style="margin-left: 50px;  margin-top: 100px;">
													<label class="label"><a id="groupPurchasePointer" showType="4" style="font-size: xx-large;" href="javascript:void(0);" style="cursor:pointer;" >团购活动</a></label>
													
													<div class="note">
														向全体会员直接推送团购活动信息，收到信息的会员点击参加团购报名，并获取团购消息
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
						<h4 class="modal-title" id="myModalLabel">优惠券信息</h4>
					</div>
					<div class="modal-body" >
						<form id="edit-form">
						<div class="widget-body no-padding">
							<div >
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<input id="type" type="hidden" name="type"/>
								
								
								<div id="bootstrap-wizard-1" class="">
													<div class="form-bootstrapWizard smart-form" style="margin-top:10px;margin-buttom:10px;">
														<ul class="bootstrapWizard form-wizard">
															<li class="active" data-target="#step1" step-item>
																<a href="#tab1" data-toggle="tab"> <span class="step"><i class="fa fa-check"></i></span> <span class="title">基本信息</span> </a>
															</li>
															<li data-target="#step2" class="" group-purchase style="display:none;" step-item> 
																<a href="#tab2" data-toggle="tab"> <span class="step"><i class="fa fa-check"></i></span> <span class="title">团购信息</span> </a>
															</li>
															<li data-target="#step3" class="" lucky-draw style="display:none;" step-item>
																<a href="#tab3" data-toggle="tab"> <span class="step"><i class="fa fa-check"></i></span> <span class="title">抽奖信息</span> </a>
															</li>
															<li data-target="#step4" class="" group-purchase lucky-draw marketing step-item>
																<a href="#tab4" data-toggle="tab"> <span class="step"><i class="fa fa-check"></i></span> <span class="title">活动开始信息</span> </a>
															</li>
															<li data-target="#step5" class="tab" step-item>
																<a href="#tab5" data-toggle="tab"> <span class="step"><i class="fa fa-check"></i></span> <span class="title">活动结束信息</span> </a>
															</li>
														</ul>
														<div class="clearfix"></div>
													</div>
													<div class="tab-content">
														<div class="tab-pane  active smart-form" id="tab1">
															<br>
															<h3 style="margin-top:10px;margin-bottom:10px;"><strong>基本信息</strong></h3>
									<section>
										<div class="row">
											<div class="col col-2" style="padding-right: 0px;">
												<label style="font-size:large;">活动名称：</label>
											</div> 
											
											<div class="col col-8" style="padding-left:0px;">
													<label class="input"><input
												type="text" class="form-control" 
												id="name" name="name" />
												</label>
											</div>
											 <div class="col col-2"></div>
										</div>
									</section>
									<section>
										
										<div class="row" >
													<div class="col col-2" style="padding-right: 0px;">
														<label style="font-size:large;">有效时间：</label>
													</div>
													<div class="col col-8">
														<div class="row" id="timeBucketDiv">
															<div class="col col-1">
															<label class="radio">
																<input id="timeBucket" type="radio" value="1" name="validTimeRadio" checked="checked" >
																<i></i></label>
															</div>
															<div class="col col-5" style="" >
																<label class="input"> <i class="icon-append fa fa-calendar"></i>
																	<input type="text" name="beginTimeString" id="startdate" placeholder="开始时间" class="hasDatepicker">
																</label>
																
																</div>
																<div class="col col-5">
																	<label class="input"> <i class="icon-append fa fa-calendar"></i>
																		<input type="text" name="endTimeString" id="finishdate" placeholder="结束时间" class="hasDatepicker">
																	</label>
																	
																</div>
														</div>
														<div class="row" style="margin-top:10px;">
															<div class="col col-1">
															<label class="radio ">
																<input id="timeLine"  type="radio" value="2" name="validTimeRadio" >
																<i></i></label>
															</div>
															<div class="input-group col col-11" style="padding-right:15px;" id="timeLineDiv">
																	<span class="input-group-addon">自活动开始</span>
																	<input class="form-control"  name="daysLate" type="text" disabled="disabled">
																	<span class="input-group-addon" style="display:none;"></span>
																	<span class="input-group-addon">天有效</span>
															</div>
															
														</div>
													</div>
												</div>
									</section>
									<section coupon style="display:none;">
										<div class="row">
											<div class="col col-2" style="padding-right: 0px;">
												<label style="font-size:large;">限量领取：</label>
											</div> 
											
											<div class="input-group col col-8">
																	<span class="input-group-addon">每人</span>
																	<input class="form-control" id="limitCoupon" name="limitCoupon" type="text" placeholder="不填表示无限制">
																	<span class="input-group-addon" style="display:none;"></span>
																	<span class="input-group-addon">张优惠券</span>
															</div>
										</div>
									</section >
									<section coupon style="display:none;">
										<div class="row">
											<div class="col col-3" style="padding-right: 0px;margin-right: -45px;">
												<label style="font-size:large;">选择优惠券：</label>
											</div> 
											
											<div class="col col-8" style="padding-left:0px;">
													<label class="select" > <div style="width:100%" class="select2" name="couponName"></div>
													<div  style="margin-top:-20px; ">
													<input name="couponId" style="width: 0; height: 0;" /></div>
														</label>
											</div>
											 <div class="col col-1"></div>
										</div>
									</section>
									<section style="">
									<div class="row">
									<div class="col col-5">
													<label class="label">未选择组</label>
													<label class="select select-multiple">
														<select name="unselect-group" multiple="" class="custom-scroll">
															
															
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
										<label class="label">已选择组</label>
													<label class="select select-multiple">
														<select name="selected-group" multiple="" class="custom-scroll">
															
														</select> </label>
									
									</div>
									</div>			
								</section>
															
				
															
				
														</div>
														<div class="tab-pane smart-form" id="tab2">
															<br>
															<h3 style="margin-top:10px;margin-bottom:10px;"><strong>团购信息</strong></h3>
															<section>
																<div class="row">
																		<div class="col col-2" style="padding-right: 0px;">
																			<label style="font-size:large;">成团条件：</label>
																		</div> 
																		
																		<div class="col col-8" style="padding-left:0px;">
																				<div class="row">
																						<div class="input-group col col-12" style="padding-left:0px;">
																					
																					<input class="form-control" id="minimumNumber" name="minimumNumber" type="text" placeholder="描述">
																					<span class="input-group-addon" style="display:none;"></span>
																					<span class="input-group-addon">人参与，团购开始</span>
																					</div>
																				<div class="row">
																					<div class="input-group col col-12" style="margin-top:10px;">
																					<span class="input-group-addon">最多允许参加</span>
																					<input class="form-control" id="number" name="number" type="text" placeholder="描述">
																					<span class="input-group-addon" style="display:none;"></span>
																					<span class="input-group-addon">人（不填为没有限制）</span>
																					</div>
																				
																				</div>
																				</div>
																		</div>
																		 <div class="col col-2"></div>
																	</div>
															</section>
															<section>
																<div class="row">
																		<div class="col col-2" style="padding-right: 0px;">
																			<label style="font-size:large;">消息提示：</label>
																		</div> 
																		
																		<div class="col col-8" style="padding-left:0px;">
																				
																				<div class="row">
																					<label class="label">团购开始时，给参见团购的人发送如下消息</label>
																					<label class="textarea textarea-resizable"> 										
																						<textarea name="successInfo" rows="3" class="custom-scroll" placeholder="亲，团购开始了，及时参加哟。"></textarea> 
																					</label>
																					<label class="label">团购失败时，给参见团购的人发送如下消息</label>
																					<label class="textarea textarea-resizable" > 										
																						<textarea name="failureInfo" rows="3" class="custom-scroll" placeholder="亲，团购没启动，等待下次机会吧。"></textarea> 
																					</label>
																				
																				</div>
																				</div>
																		 <div class="col col-2"></div>
																		</div>
																	
															</section>
															
															
															
															
															
															
															
														</div>
														
														
														
														
														
														
														<div class="tab-pane smart-form" id="tab3">
															<br>
															<h3 style="margin-top:10px;margin-bottom:10px;"><strong>抽奖信息</strong></h3>
															<section  maxLevel="3" id="prizeList">
															<section prize-item-template style="display:none;"  level="0">
																<div class="row"  >
																		<div class="input-group col col-12">
																		<span class="input-group-addon" name="prizeLevelCHN"></span>
																		<input class="form-control" id="validDays" name="prize" type="text" placeholder="描述">
																		<span class="input-group-addon" style="display:none;"></span>
																		<span class="input-group-addon">   数量</span>
																		<input class="form-control" id="validDays" name="number" type="text" placeholder="不填则表示无限制" size="5">
																</div>
																</div>
															</section>
															<section  class="prize-item" level="1">
																<div class="row">
																		<div class="input-group col col-12">
																		<span class="input-group-addon">一等奖：</span>
																		<input class="form-control" id="validDays" name="prize" type="text" placeholder="描述">
																		<span class="input-group-addon" style="display:none;"></span>
																		<span class="input-group-addon">   数量</span>
																		<input class="form-control" id="validDays" name="number" type="text" placeholder="不填则表示无限制" size="5">
																</div>
																</div>
															</section>
															<section  class="prize-item" level="2">
																<div class="row">
																		<div class="input-group col col-12">
																		<span class="input-group-addon">二等奖：</span>
																		<input class="form-control" id="validDays" name="prize" type="text" placeholder="描述">
																		<span class="input-group-addon" style="display:none;"></span>
																		<span class="input-group-addon">   数量</span>
																		<input class="form-control" id="validDays" name="number" type="text" placeholder="不填则表示无限制" size="5">
																</div>
																</div>
															</section>
															<section  class="prize-item" level="3">
																<div class="row">
																		<div class="input-group col col-12">
																		<span class="input-group-addon">三等奖：</span>
																		<input class="form-control" id="validDays" name="prize" type="text" placeholder="描述">
																		<span class="input-group-addon" style="display:none;"></span>
																		<span class="input-group-addon">数量</span>
																		<input class="form-control" id="validDays" name="number" type="text" placeholder="不填则表示无限制" size="5">
																</div>
																</div>
															</section>
															</section>
															<section>
																<div class="pull-center">
																	<a class="btn btn-primary btn-sm" item-id="button-toolbar-addprize"><i class="fa fa-plus"></i>新增奖项</a> 
																</div>
															</section>
															
															<section>
																<div class="row">
																		<div class="input-group col col-8">
																		<span class="input-group-addon">每微信昵称可参加</span>
																		<input class="form-control" id="limitNumber" name="limitNumber" type="text" placeholder="次数">
																		<span class="input-group-addon" style="display:none;"></span>
																		<span class="input-group-addon">次（不填为没有限制）</span>
																	</div>
																</div>
															</section>
															<section>
																<label class="label">重复参加的提示</label>
																<label class="textarea textarea-resizable"> 										
																	<textarea rows="3" class="custom-scroll" name="errorInfo"></textarea> 
																</label>
															</section>
															<section>
																<div class="row">
																		<div class="input-group col col-8">
																		<span class="input-group-addon">预计参加人数</span>
																		<input class="form-control" id="estimatePerson" name="estimatePerson" type="text" >
																	
																	</div>
																</div>
															</section>
															
														</div>
														
														
														<div class="tab-pane" id="tab4">
															<br>
															<h3 style="margin-top:10px;margin-bottom:10px;"><strong>活动素材</strong></h3>
															<div class="smart-form">
									
									<section>
										<div class="row">
											<div class="col col-3" style="padding-right: 0px;">
												<label style="font-size:large;">活动图片：</label>
											</div> 
											
											<div class="col col-9" style="padding-left:0px;">
												<div class="fileinput-button" item-id="preview">
													<img src="${ctx}/img/user.png" id="beginImg" style="top: 0px; width: 80px; height: 100px;">
													<button type="button" begin class="btn btn-danger btn-xs" style="position: absolute; top: 40px; left: 25px; z-index: 1000; display: none;">删除</button>
													<input type="file" name="uploadFile" begin data-url="${ctx}/webadmin/upload.htm">
												</div>
												<input type="hidden" id="beginPicUrl" name="beginPicUrl" value="">
												<input type="hidden" id="beginPicStoragePath" name="beginPicStoragePath" value="">
											</div>
											 
										</div>
									</section>
									</div>
									
									<section>
										<div class="jarviswidget jarviswidget-color-blue" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-fullscreenbutton="false" data-widget-sortable="false" role="widget" style="">
				<header role="heading"><div class="jarviswidget-ctrls" role="menu">     </div>
					<span class="widget-icon"> <i class="fa fa-pencil"></i> </span>
					<h2>活动描述</h2>

				<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>

				
				<div role="content">

					<div class="jarviswidget-editbox">

					</div>

					<div class="widget-body no-padding">

						<div class="summernote">
							
						
						
						
					</div>

				</div>

			</div>
									
									</section>			
															
								<!-- 				
								<section>
									<label class="input"> 
									<div class="widget-body no-padding" style="margin:0;">
										<div class="summernote"></div>
									</div></label>
									</section>							
									 -->									
															
															
														</div>
														<div class="tab-pane smart-form" id="tab5">
															<br>
															<h3 style="margin-top:10px;margin-bottom:10px;"><strong>活动素材</strong></h3>
															<div class="smart-form">
									<section>
										<div class="row">
											<div class="col col-3" style="padding-right: 0px;">
												<label style="font-size:large;">活动结束信息：</label>
											</div> 
											
											<div class="col col-9" style="padding-left:0px;">
													<label class="textarea textarea-resizable"> 										
														<textarea rows="3" class="custom-scroll" name="endDescription"></textarea> 
													</label>
											</div>
											 
										</div>
									</section>
									<section>
										<div class="row">
											<div class="col col-3" style="padding-right: 0px;">
												<label style="font-size:large;">活动结束图片：</label>
											</div> 
											
											<div class="col col-9" style="padding-left:0px;">
												<div class="fileinput-button" item-id="preview">
													<img src="${ctx}/img/user.png"  id="endImg" style="top: 0px; width: 80px; height: 100px;">
													<button type="button" end class="btn btn-danger btn-xs" style="position: absolute; top: 40px; left: 25px; z-index: 1000; display: none;">删除</button>
													<input type="file" name="uploadFile" end data-url="${ctx}/webadmin/upload.htm">
												</div>
												<input type="hidden" id="endPicUrl" name="endPicUrl" value="">
												<input type="hidden" id="endPicStoragePath" name="endPicStoragePath" value="">
											</div>
											 
										</div>
									</section>
									
									
														</div>
				
														
				
													</div>
												</div>
								
							
							
							
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							item-id="button-next-tab">下一步</button>
						<button type="button" class="btn btn-default"
							item-id="button-cancel">取消</button>
						<button type="button" class="btn btn-primary" style="display:none;"
							item-id="button-save">保存</button>
					</div>
				</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		</div>
			 </div>
		
		<!-- Modal  -->
		<div class="modal fade in" id="apartModal" role="dialog"
			aria-labelledby="editModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">优惠券信息</h4>
					</div>
					<div class="modal-body" >
						<div class="widget-body no-padding">
						<form id="apart-form" class="smart-form">
						
								<input id="id" type="hidden" name="id" value="${param.id}" />
								
							
								<fieldset>
										<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="优惠卷张数"
											id="apartNumber" name="apartNumber" /> <b
											class="tooltip tooltip-top-right">优惠卷张数</b>
										</label>
										
										</section>
								</fieldset>
					</form>	
					<div class="modal-footer">
						
						<button type="button" class="btn btn-default"
							item-id="button-cancel-apart">取消</button>
						<button type="button" class="btn btn-primary" 
							item-id="button-save-apart">保存</button>
					</div>
				
				</div>
			</div>
		</div>
		</div>
		</div>
		
	
		
		<!-- Modal -->
		<div class="modal fade" id="viewModal" role="dialog"
			aria-labelledby="viewModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">活动信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" />
								<input id="modified" type="hidden" name="modified"/>
								<div class="row">
											<section class="col col-2">
												<label class="label">活动名称:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="name"> </label>
											</section>
										</div>
										<div class="row">
											<section class="col col-2">
												<label class="label" >发送人群:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="groupNames"> </label>
												<label view1 view2>每人<label item-id="limitCoupon"></label>张</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-2">
												<label class="label">有效日期:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="validString"> </label>
											</section>
										</div>
										
										<div class="row" view1 view2>	
										<section class="col col-2" >
												<label class="label">优惠券:</label>
											</section>
											<section class="col col-9" >
												<div name="ticketCard" style="width: 100%;height: 170px;border: solid 1px;">
											<div class="row" style="margin-top: 20px;">
												<div class="col col-8"><label style=" margin-left: 30px;" item-id="coupon.name"></label></div>
												<!-- <div class="col col-4" style=""><label>使用范围</label></div> -->
											</div>
											<div class="row" style="margin-top: 30px;font-size: xx-large;">
												<div class="col col-7" style="padding-left: 40px;"><label item-id="coupon.value"></label></div>
												<div class="col col-5">领取</div>
											</div>
											
											<div class="" style="border-top:solid 1px;margin-top: 30px;padding-left:30px;">
												有效期：<label style="margin-top: 5px;" item-id="coupon.validDaysString"></label>
											</div>
											</div>
											</section>
											
										</div>
										
										<div class="row" view3>
											<section class="col col-2" >
												<label class="label">奖品描述:</label>
											</section>
											<section class="col col-9"  name="prizesDiv">
												<div class="row" prize-template style="display:none;">
													<div class="col col-5">
													<div class="row">
														<div class="col col-4"><label class="label" name="prizeNameCHN"></label></div>
														<div class="col col-6"><label class="" name="prizeName"> </label></div>
													</div>
													</div>
													<div class="col col-5">
													<div class="row">
														<div class="col col-4"><label class="label">数量:</label></div>
														<div class="col col-6"><label class="" name="prizeNumber"> </label></div>
													</div>
													</div>
												</div>
											</section>
										</div>
										
										
										
										
										
										<div class="row" view3>
											<section class="col col-2">
												<label class="label">活动限制:</label>	
											</section>
											<section class="col col-9">
												<label class="label">每微信昵称可参加<label item-id="limitNumber"></label>次</label>
												<label class="label">重复参加的提示</label>
												<label class="textarea textarea-resizable"> 										
													<textarea item-id="errorInfo" rows="3" class="custom-scroll"  disabled="disabled"></textarea> 
												</label>
												<label class="label">预计参加人数<label item-id="estimatePerson"></label></label>
											</section>
										</div>
										
										
										
										<div class="row" view4>
											<section class="col col-2">
												<label class="label">成团条件:</label>
											</section>
											<section class="col col-9">
												<label class="" ><label item-id="minimumNumber"></label>人参与团购开始，最多限制<label item-id="number"></label>人参加。</label>
											</section>
										</div>
										<div class="row" view4>
											<section class="col col-2">
												<label class="label">消息提示:</label>
											</section>
											<section class="col col-9">
												<div class="row">
													<label class="label">团购开始时，给参见团购的人发送如下消息</label>
													<label class="textarea textarea-resizable"> 										
														<textarea item-id="successInfo" rows="3" class="custom-scroll" placeholder="亲，团购开始了，及时参加哟。" disabled="disabled"></textarea> 
													</label>
													<label class="label">团购失败时，给参见团购的人发送如下消息</label>
													<label class="textarea textarea-resizable" > 										
														<textarea item-id="failureInfo" rows="3" class="custom-scroll" placeholder="亲，团购没启动，等待下次机会吧。" disabled="disabled"></textarea> 
													</label>
												
												</div>
											</section>
										</div>
										
										
										<div class="row" view2 view3 view4>
											<section class="col col-2">
												<label class="label">活动图片:</label>
											</section>
											<section class="col col-9">
													<div >
													<img src="${ctx}/img/user.png" item-id="beginPicUrl"  style="top: 0px; width: 80px; height: 100px;">
												</div>
											</section>
										</div>
										<div class="row"  view2 view3 view4>
											<section class="col col-2">
												<label class="label">活动描述:</label>
											</section>
											<section class="col col-9">
												<label class="" item-id="beginDescription"> </label>
											</section>
										</div>
										<div class="row" name="rejectReasonDiv">
											<section class="col col-2">
												<label class="label">活动结束图片:</label>
											</section>
											<section class="col col-9">
												<div >
													<img src="${ctx}/img/user.png" item-id="endPicUrl"  style="top: 0px; width: 80px; height: 100px;">
												</div>
											</section>
										</div>
										<div class="row" name="rejectReasonDiv">
											<section class="col col-2">
												<label class="label">活动结束提示:</label>
											</section>
											<section class="col col-9">
												<label class="textarea textarea-resizable"> 										
														<textarea item-id="endDescription" rows="3" class="custom-scroll" placeholder="亲，团购开始了，及时参加哟。" disabled="disabled"></textarea> 
												</label>
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
						<h4 class="modal-title" id="myModalLabel">查询活动信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 活动信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="活动名称"
											id="nameLike" name="nameLike" /> <b
											class="tooltip tooltip-top-right">需要输入活动名称</b>
										</label>
									</section>
									<section>
										<label class="select">
														<select name="type">
															<option value="">活动类型</option>
															<option value="1">优惠卷活动</option>
															<option value="2">促销活动</option>
															<option value="3">抽奖活动</option>
															<option value="4">团购活动</option>
														</select> <i></i> </label>
											
									</section>
									<section>
										<label class="select">
														<select name="status">
															<option value="">活动状态</option>
															<option value="1">未开始</option>
															<option value="2">执行中</option>
															<option value="3">已结束</option>
														</select> <i></i> </label>
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


	<script src="${ctx}/js/platform/marketing/activity.js"></script>
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

