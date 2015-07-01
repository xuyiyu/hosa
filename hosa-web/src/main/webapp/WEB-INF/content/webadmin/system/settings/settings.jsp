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
					<i class="fa fa-wrench fa-fw "></i> 系统管理 <span>> 系统设置 </span>
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
								<h2>参数信息</h2>
							</header>

							<!-- widget div-->
							<div class="panel-collapse collapse in">


								<!-- widget content -->
								<div class="widget-body">
										<div class="widget-body-toolbar">
											
											<div class="row">
												
												<div class="col-sm-6">
													
												</div>
												<div class="col-sm-6 text-right">
													
												</div>
												
											</div>
												
				
										</div>
				
										<table id="user" class="table table-bordered table-striped" style="clear: both">
											<tbody>
												<tr>
													<td style="width:35%;">Simple text field</td>
													<td style="width:65%"><a href="form-x-editable.html#" id="username" data-type="text" data-pk="1" data-original-title="Enter username" class="editable editable-click">superuser</a></td>
												</tr>
												<tr>
													<td>Empty text field, required</td>
													<td><a href="form-x-editable.html#" id="firstname" data-type="text" data-pk="1" data-placement="right" data-placeholder="Required" data-original-title="Enter your firstname" class="editable editable-click editable-empty">Empty</a></td>
												</tr>
												<tr>
													<td>Select, local array, custom display</td>
													<td><a href="form-x-editable.html#" id="sex" data-type="select" data-pk="1" data-value="" data-original-title="Select sex" class="editable editable-click" style="color: rgb(128, 128, 128);">not selected</a></td>
												</tr>
												<tr>
													<td>Select, remote array, no buttons</td>
													<td><a href="form-x-editable.html#" id="group" data-type="select" data-pk="1" data-value="5" data-source="/groups" data-original-title="Select group" class="editable editable-click">Admin</a></td>
												</tr>
											
											</tbody>
										</table>
				
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

	

	<script src="${ctx}/js/platform/organization/staff.js"></script>
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

