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
									<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="">
								<input id="recordsId" type="hidden" value="">
								<input id="modified" type="hidden" name="modified" value="">
								<div id="step1">
								<fieldset item-id="account-information" style="">
								<div class="row">
									<section class="col col-10">
											<label class="input"> 
											<input type="text" class="form-control" placeholder="扫描区" id="code" name="code"> 
											
											</label>
									</section>
									<section class="pull-left">
											<a class="btn btn-primary btn-sm" item-id="button-toolbar-view">
											获取</a> 
									</section>
								</div>
								</fieldset>
								</div>
									<div id="step2" style="display:none;">
								<fieldset item-id="account-information" id="couponView" style="">
								
									<div class="row">
									<section class="col col-6">
										<section style="margin-right: 14px;margin-bottom:0px;">
										
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
												<label class="" name="categoriesString"> </label>
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
										</section>
									</section>
									
									<section class="col col-6">
									<section style="margin-left: 10px;margin-right: 14px;margin-bottom:0px;">
										
										
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

								</fieldset>
								
							
								<header> 基本信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="微信昵称" id="nickName" name="nickName"> 
													<b class="tooltip tooltip-top-right">需要输入微信昵称</b>
													</label>
											</section>
											</div>
											<div class="row">
											<section class="col col-12">
													<label class="select">
														<select name="gender">
															<option value="1">男</option>
															<option value="2">女</option>
														</select> <i></i> </label>
											</section>
											</div>
										</section>
										<section class="col col-1"></section>
										<section class="col col-3">
											
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="手机号码" id="mobile" name="mobile"> 
													<b class="tooltip tooltip-top-right">需要输入联系方式</b>
													</label>
											</section>
											</div>
										</section>
									
									<section class="col col-1"></section>
									<section class="col col-3">
											<div class="row">
												<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i>
													 <input type="text" class="form-control" placeholder="会员名称" id="name" name="name">
													  <b class="tooltip tooltip-top-right">需要输入会员名称</b>
													</label>
												</section>
											</div>
											
									</section>
									</div>

								</fieldset>
								<header> 会员信息 </header>
								<fieldset item-id="account-information-toggle" >
									<div class="row">
										<section class="col col-3">
											<div class="row">
											<section class="col col-12">
													<label class="select">
														<select name="level">
															<option value="0">准会员</option>
															<option value="1">普通会员</option>
															<option value="2">vip</option>
															<option value="3">金卡</option>
															<option value="4">银卡</option>
														</select> <i></i> </label>
											</section>
											</div>
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="车架号" id="frameNo" name="frameNo""> 
													<b class="tooltip tooltip-top-right">需要输入车架号</b>
													</label>
											</section>
											</div>
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="会员卡号" id="card" name="card"> 
													<b class="tooltip tooltip-top-right">需要输入会员卡号</b>
													</label>
											</section>
											</div>
											
										</section>
										<section class="col col-1"></section>
										<section class="col col-3">
										<!--  
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="有效期" id="valid" name="valid"> 
													<b class="tooltip tooltip-top-right">需要输入有效期</b>
													</label>
											</section>
											</div> -->
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="身份证号" id="idCard" name="idCard"> 
													<b class="tooltip tooltip-top-right">需要输入身份证号</b>
													</label>
											</section>
											</div>
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="积分" id="integration" name="integration"> 
													<b class="tooltip tooltip-top-right">需要输入积分</b>
													</label>
											</section>
											</div>
											<!-- 
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="入会时间" id="createdAt" name="createdAt"> 
													<b class="tooltip tooltip-top-right">需要输入入会时间</b>
													</label>
											</section>
											</div>
											
											 -->
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="车型" id="models" name="models"> 
													<b class="tooltip tooltip-top-right">需要输入车型</b>
													</label>
											</section>
											</div>
										</section>
									
										<section class="col col-1"></section>
										<section class="col col-3">
												<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="会费余额" id="availableOver" name="availableOver"> 
													<b class="tooltip tooltip-top-right">需要输入会费余额</b>
													</label>
											</section>
											</div>
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="车牌号" id="plate" name="plate"> 
													<b class="tooltip tooltip-top-right">需要输入车牌号</b>
													</label>
											</section>
											</div>
											<!-- 
											<div class="row">
											<section class="col col-12">
													<label class="select">
														<select name="status">
															<option value="1">有效</option>
															<option value="0">无效</option>
														</select> <i></i> </label>
											</section>
											</div>
											
											 -->
											<div class="row">
											<section class="col col-12">
													<label class="input"> <i class="icon-append fa fa-question-circle"></i> 
													<input type="text" class="form-control" placeholder="折扣" id="discount" name="discount"> 
													<b class="tooltip tooltip-top-right">需要输入折扣</b>
													</label>
											</section>
											</div>	
										</section>
									</div>
								</fieldset>
							
								<div class="modal-footer" style="text-align: center;">
									
									<button type="button" class="btn btn-primary" style="width: 100px;margin-top: 20px;height: 40px;margin-bottom: 20px;font-size: x-large;" item-id="button-save">保存</button>
								</div>
								</div>
							</form>

									
									
									
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



	<script src="${ctx}/js/platform/marketing/couponscan.js"></script>
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

