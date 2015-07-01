<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
<%@ include file="/web/commons/scripts.jsp"%>
</head>
<script type="text/javascript">
$(function(){
	var url = ctx + "/web/weixinMessage/loadHistoryMessages.htm";
	var param = {'weixinMessagesQuery.userOpenId':openId,'weixinMessagesQuery.departmentId':d};
	$.webAjax(url, param, function(responseData) {
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			$('.content').html('');
			if(data.list) {
				$.each(data.list,function(i,o){
					//myalert(data.list.length);
					if(o.content==''||o.content==null)return;
					if(o.type==1){
							var html ='';
						 	if(data.weixinUsers !=null&& data.weixinUsers.headImgUrl!=null){
						 		html +='<img  src="'+data.weixinUsers.headImgUrl+'" class="yuanimg1"/>';
						 	}else{
						 		html +='<img  src="'+ctx+'/web/images/user.png" class="yuanimg1"/>';
						 	}
					    html+='<div class="duihuabg2">';
					    html +='<p>'+o.content+'</p><div class="sanjiao"><em></em></div></div>';
						$('<section class=""></section>').appendTo($('.content')).html(html);

					}else if(o.type==2){
							var html ='';
						 	if(o.staff!=null && o.staff.headImgUrl!=null){
						 		html +='<img  src="'+o.staff.headImgUrl+'" class="yuanimg2" style="margin-top:5%;"/>';
						 	}else{
						 		html +='<img  src="'+ctx+'/web/images/getheadimg.jpg" class="yuanimg2"/>';
						 		
						 	}
					
						html += '<div class="duihuabg1 " style="margin-left:0; margin-right:5%; float:right; ">';
						html += '<p>'+o.content+'</p><div class="sanjiao1"><em></em></div></div>';
						html +='<div class="clear"></div>';
						$('<section class=""></section>').appendTo($('.content')).html(html);
					}
				});
			}
		}
		});
	});	
</script>
<body >               
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx }/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li class="navactive"><a href="javascript:void(0);">私人车助理</a></li>
		<li ><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>
<div class="content">
</div>

<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<a><img src="${ctx}/web/images/tou.png">咨询顾问</a>
<a href="javascript:void(0);"><img src="${ctx}/web/images/phone.png">电话咨询</a>
</li>
</ul>
</section>
</body>
</html>
