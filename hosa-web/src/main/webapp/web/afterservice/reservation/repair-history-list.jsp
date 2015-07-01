<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>
<%@ page  isELIgnored="false"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link rel="stylesheet" type="text/css" href="${ctx}/web/css/mc.css">
</head>
<body class="mainbg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli">
<li class="navactive"><a href="javascript:void(0);">售后预约</a></li>
<li ><a href="javascript:void(0);">24小时救援</a></li>
<li ><a href="javascript:void(0);">售后活动</a></li>
<li ><a href="javascript:void(0);">专家知识库</a></li>
<div class="clear"></div>
</ul>
</section>
<section style=" position:relative ">
<a href=""><img src="${ctx}/web/images/322323_03.jpg" /></a>
</section>
<section class=" paddinfo" id="orderDayList">

</section>
<script type="text/javascript">
	$(function(){
	
	var loadOrderDayList = function(){
		var param = {};
		
		$.webAjax(ctx+"/web/afterservice/reservation/repair/repair!loadOrderDayList.htm", param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data){
					//$("#time-table").empty();
					
					$("#orderDayList").empty();
					if(!data.length){
						$("#orderDayList").html("您目前还没提交过保养单");
					}
					$.each(data,function(i,o){
						var _div = $('<div class="top-block blocktext history-item"></div>');
						$("<span></span>").text(o).appendTo(_div);
						$("<img></img>").attr("src",ctx+"/web/images/more1.png").addClass("more1").appendTo(_div);
						_div.appendTo($("#orderDayList")).click(function(){
										var date = $(this).find("span").text();
										window.location.href = ctx + "/web/afterservice/reservation/repair/repair/historyorderinfo.htm?date="+date;
									});
					
					});
					
				}
			}
		});
	}
	
	
	
	
	
	$().ready(function() {
		
		loadOrderDayList();
		
		
	});
	
	})
					

</script>
</body>
</html>