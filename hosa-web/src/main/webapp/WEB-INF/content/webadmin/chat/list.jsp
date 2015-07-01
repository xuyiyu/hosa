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


								<!-- widget content -->
								<div class="widget-body">
									
									<div class="tab-content padding-10">
										<div class="tab-pane fade active in" id="s1">
											
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 chat">
													<div class="widget-content">
														<ul>
                  <li>
                    <img width="30" height="30" src="${ctx}/img/avatars/3.png">
                    <div class="bubble">
                      <a class="user-name" href="#">John Smith</a>
                      <p class="message">
                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
                      </p>
                      <p class="time">
                        <strong>Today </strong>3:53 pm
                      </p>
                    </div>
                  </li>
                  <li class="current-user">
                    <img width="30" height="30" src="${ctx}/img/avatars/1.png">
                    <div class="bubble">
                      <a class="user-name" href="#">Jane Smith</a>
                      <p class="message">
                        Donec odio. Quisque volutpat mattis eros.
                      </p>
                      <p class="time">
                        <strong>Today </strong>3:53 pm
                      </p>
                    </div>
                  </li>
                  <li>
                    <img width="30" height="30" src="${ctx}/img/avatars/3.png">
                    <div class="bubble">
                      <a class="user-name" href="#">John Smith</a>
                      <p class="message">
                        Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero, faucibus adipiscing, commodo quis, gravida id, est. Sed lectus. Praesent elementum hendrerit tortor. Sed semper lorem at felis. Vestibulum volutpat, lacus a ultrices sagittis, mi neque euismod dui, eu pulvinar nunc sapien ornare nisl.
                      </p>
                      <p class="time">
                        <strong>Today </strong>3:53 pm
                      </p>
                    </div>
                  </li>
                 
                </ul>
													</div>
												</div>
											</di>
											
										
										</div>
									</div>
								</div>

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

	<script>
		$(function() {
			
		})
	</script>
</body>
</html>

