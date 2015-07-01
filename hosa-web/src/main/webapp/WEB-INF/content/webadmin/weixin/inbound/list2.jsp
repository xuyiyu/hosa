<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<script type="text/javascript"
	src="${ctx}/js/plugin/ckplayer/ckplayer.js" charset="utf-8"></script>
</head>

<body>
	<div id="content">

		<div class="row">
			<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
				<h1 class="page-title txt-color-blueDark">
					<i class="fa fa-group fa-fw "></i> 系统管理 <span>> 素材管理 </span>
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
								<h2>素材信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">
								<!-- embedded tab  begin-->
							<div class="jarviswidget" id="wid-id-7" data-widget-editbutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false" data-widget-fullscreenbutton="false" data-widget-deletebutton="false" role="widget">
							
								<header role="heading">
									<ul class="nav nav-tabs pull-left in">
				
										<li class="active">
				
											<a data-toggle="tab" href="#hr1"> <img width="30" height="20" src="${ctx}/img/avatars/3.png"> <span class="hidden-mobile hidden-tablet"> Bottom Tabs </span> </a>
				
										</li>
				
										<li class="">
											<a data-toggle="tab" href="#hr2"> <i class="fa fa-lg fa-arrow-circle-o-up"></i> <span class="hidden-mobile hidden-tablet"> Top Tabs <span class="label bg-color-blue txt-color-white"> label <i class="fa fa-exclamation"></i> </span> </span> </a>
										</li>
				
									</ul>
									<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span>
								
								</header>
				
								<!-- widget div-->
								<div role="content">
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="row"><div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="widget-body">
				
										<div class="tab-content">
											<div class="tab-pane active" id="hr1">
				
												<div class="tabbable tabs-below">
													<div class="tab-content padding-10">
														<div class="tab-pane active" id="AA">
															<p>
																The broccoli says 'I look like a small tree', the mushroom says 'I look like an umbrella', the walnut says 'I look like a brain', and the banana says 'Can we please change the subject?'
															</p>
														</div>
														<div class="tab-pane" id="BB">
															<p>
																Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee.
															</p>
														</div>
														<div class="tab-pane" id="CC">
															<p>
																Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table.
															</p>
														</div>
													</div>
													<ul class="nav nav-tabs">
														<li class="active">
															<a data-toggle="tab" href="#AA">Tab 1</a>
														</li>
														<li class="">
															<a data-toggle="tab" href="#BB">Tab 2</a>
														</li>
														<li class="">
															<a data-toggle="tab" href="#CC">Tab 3</a>
														</li>
													</ul>
												</div>
				
											</div>
											<div class="tab-pane" id="hr2">
				
												<ul class="nav nav-tabs">
													<li class="active">
														<a href="#iss1" data-toggle="tab">Item 1</a>
													</li>
													<li>
														<a href="#iss2" data-toggle="tab">Item 2</a>
													</li>
													<li>
														<a href="#iss3" data-toggle="tab">Item 3</a>
													</li>
												</ul>
												<div class="tab-content padding-10">
													<div class="tab-pane active" id="iss1">
														<p>
															Three monkeys escaped from the zoo, one was caught watching TV, the other playing hockey, and the third one was caught reading this quote!
														</p>
													</div>
													<div class="tab-pane fade" id="iss2">
														<p>
															Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee.
														</p>
													</div>
													<div class="tab-pane fade" id="iss3">
														<p>
															Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table.
														</p>
													</div>
												</div>
				
											</div>
										</div>
				
									</div>
									<!-- end widget content -->
									</div><div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									
									<div class="widget-body">
				
										<div class="tabs-right">
											<ul class="nav nav-tabs">
												<li class="">
													<a href="#tab1" data-toggle="tab">Item 1 <span class="badge bg-color-blue txt-color-white">12</span></a>
												</li>
												<li class="active">
													<a href="#tab2" data-toggle="tab">Item 2 <span class="badge bg-color-blueDark txt-color-white">3</span></a>
												</li>
												<li class="">
													<a href="#tab3" data-toggle="tab">Item 3 <span class="badge bg-color-greenLight txt-color-white">3</span></a>
												</li>
											</ul>
											<div class="tab-content">
												<div class="tab-pane" id="tab1">
													<p>
														TEAM WORK: Having somebody else you can blame it on.
														<br>
														HARDWARE: The part of a computer you can kick when there are software problems.
														<br>
														IMPATIENT: Somebody who is waiting in a hurry.
														<br>
													</p>
												</div>
												<div class="tab-pane active" id="tab2">
													<p>
														Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.
													</p>
												</div>
												<div class="tab-pane" id="tab3">
													<p>
														Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.
													</p>
												</div>
											</div>
										</div>
				
									</div>
									
									</div></div><!-- row end -->
									
								</div>
								<!-- end widget div -->
				
							</div>
								
								
								<!-- embedded tab  end-->
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
						<h4 class="modal-title" id="myModalLabel">设置素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="edit-form" class="smart-form">
								<input id="id" type="hidden" name="id" value="${param.id}" /> <input
									id="modified" type="hidden" name="modified" /> <input
									type="hidden" class="form-control" id="type" name="type"
									value="" />
								<header> 素材信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="素材名称" id="name"
											name="name" /> <b class="tooltip tooltip-top-right">需要输入素材名称</b>
										</label>
									</section>
									<section>
										<label class="textarea"> <i
											class="icon-append fa fa-question-circle"></i> <textarea
												class="form-control" placeholder="素材描述" rows="5"
												id="description" name="description"></textarea> <b
											class="tooltip tooltip-top-right">需要输入素材描述</b>
										</label>
									</section>
								</fieldset>
							</form>
							<form id="edit-sub-form" class="smart-form">
								<input type="hidden" name="tempId" />
								<fieldset item-id="content">
									<div class="row">
										<section class="col col-6 well well-light padding-10">
											<section class="" item-id="sub-image">
												<div class="fileinput-button " item-id="preview">
													<div class="nailthumb-container">
														<img src="${ctx}/img/user.png" style="width: 100%">
														<input type="file" name="uploadFile"
															data-url="${ctx}/webadmin/upload.htm">
													</div>

												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section class="" item-id="sub-video">
												<div id="video-preview" style="width:100%;height:200px;">

												</div>
												<div class="fileinput-button ">
													<a href="#" class="btn  btn-xs btn-block btn-primary"><i
														class="fontello-icon-upload"></i>上传</a> <input type="file"
														name="uploadFile" data-url="${ctx}/webadmin/upload.htm">
												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section class="" item-id="sub-voice">
												<div id="voice-preview" style="width:100%;"></div>
												<div class="fileinput-button ">

													<div class="nailthumb-container">
														<a href="#" class="btn  btn-xs btn-block btn-primary"><i
															class="fontello-icon-upload"></i>上传</a> <input type="file"
															name="uploadFile" data-url="${ctx}/webadmin/upload.htm">
													</div>

												</div>
												<div style="margin-top:-20px; ">
													<input type="text" name="tempUrl"
														style="width: 1px; height: 1px;" /> <input type="text"
														name="tempStoragePath" style="width: 1px; height: 1px;" />
												</div>

											</section>
											<section item-id="sub-title">
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="素材标题"
													id="tempTitle" name="tempTitle" /> <b
													class="tooltip tooltip-top-right">需要输入素材标题</b>
												</label>
											</section>
											<section item-id="sub-url">
												<label class="input"> <i
													class="icon-append fa fa-question-circle"></i> <input
													type="text" class="form-control" placeholder="链接地址"
													id="tempLinkUrl" name="tempLinkUrl" /> <b
													class="tooltip tooltip-top-right">需要输入链接地址</b>
												</label>
											</section>
											<section item-id="sub-content">
												<label class="textarea"> <i
													class="icon-append fa fa-question-circle"></i> <textarea
														class="form-control" placeholder="素材内容" rows="5"
														id="tempContent" name="tempContent"></textarea> <b
													class="tooltip tooltip-top-right">需要输入素材内容</b>
												</label>
											</section>
											<section class="pull-right">

												<a href="javascript:void(0);" class="btn btn-default btn-xs"
													item-id="button-sub-cancel"> 取消 </a> <a
													href="javascript:void(0);" class="btn btn-primary btn-xs"
													item-id="button-sub-save"> 保存 </a>
											</section>
											<section item-id="sub-error" class="pull-left"
												style="display:none; ">
												<label class="state-error"> </label><em class="invalid">请添加素材</em>
											</section>
										</section>
										<section class="col col-6">
											<table class="table table-bordered table-ellipsis">
												<thead>
													<tr>
														<th style="display:none; "></th>
														<th class=" col-9">标题</th>
														<th class=" col-3"></th>
													</tr>
												</thead>
												<tbody>
													<tr style="display:none;" item-template>
														<td style="display:none; "><input type="hidden"
															name="id" /> <input type="hidden" name="linkUrl" /> <input
															type="hidden" name="storagePath" /> <input type="hidden"
															name="title" /> <input type="hidden" name="url" /> <input
															type="hidden" name="content" /></td>
														<td class=" col-9 view" item-id="title"></td>
														<td class=" col-3"><a href="javascript:void(0);"
															class="btn btn-danger btn-xs" item-id="button-sub-delete">
																删除 </a></td>
													</tr>


												</tbody>
											</table>
										</section>
									</div>
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
						<h4 class="modal-title" id="myModalLabel">素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="view-form" class="smart-form">
								<header> 素材信息 </header>
								<fieldset>
									<div class="row">
										<section class="col col-3">
											<label class="label">素材名称:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="name"> </label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3">
											<label class="label">描述:</label>
										</section>
										<section class="col col-9">
											<label class="" item-id="description"> </label>
										</section>
									</div>
									</fieldset>
									</form>
									<form id="view-sub-form" class="smart-form">
									<fieldset item-id="sub-list" class="padding-10">
									<div class="row well well-light padding-10"  style="display:none; margin: 5px;" item-template>
										<section class="col col-5" item-id="type">
											
										</section>
										<section class="col col-7">
											<div class="row" >
												<h3 item-id="title">
													
												</h3>
												<ul class="list-unstyled">
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<span
																class="txt-color-darken" item-id="linkUrl"></span>
														</p>
													</li>
													<li style="margin-top: 10px;">
														<p class="text-muted">
															<span
																class="txt-color-darken" item-id="content"></span>
														</p>
													</li>
												</ul>

											</div>
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

		<!-- Modal -->
		<div class="modal fade" id="searchModal" role="dialog"
			aria-labelledby="searchModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查询素材信息</h4>
					</div>
					<div class="modal-body">
						<div class="widget-body no-padding">
							<form id="search-form" class="smart-form">
								<header> 素材信息 </header>
								<fieldset>
									<section>
										<label class="input"> <i
											class="icon-append fa fa-question-circle"></i> <input
											type="text" class="form-control" placeholder="素材名称" id="name"
											name="nameLike" /> <b class="tooltip tooltip-top-right">需要输入素材名称</b>
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


	
</body>
</html>

