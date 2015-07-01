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
<body >
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
		<li ><a href="javascript:void(0);">专享信息</a></li>
		<li ><a href="javascript:void(0);">精品汇</a></li>
		<li ><a href="javascript:void(0);">私人车助理</a></li>
		<li class="navactive"><a href="javascript:void(0);">会员卡信息</a></li>
	</ul>
</section>

<!--价格分区-->
<section>
<h3 class="form-title">积分规则说明</h3>
<table class=" ksz3 clearFix" cellspacing="3" cellpadding="0" style="width:100%;">

		<tr>
			<td class="tdl" style="border-top:solid 1px #ccc;">用户行为
			</td>
			<td class="tdr" style="border-top:solid 1px #ccc;">奖励积分
			</td>
		</tr>
		<tr>
			<td class="tdl">注册
			</td>
			<td class="tdr">1分
			</td>
		</tr>
        <tr>
			<td class="tdl">完善信息
			</td>
			<td class="tdr">1分
			</td>
		</tr>
        <tr>
			<td class="tdl">分享到朋友圈
			</td>
			<td class="tdr">3分
			</td>
		</tr>
        <tr>
			<td class="tdl">预约试驾
			</td>
			<td class="tdr">4分
			</td>
		</tr>
            <tr>
			<td class="tdl">预约保养
			</td>
			<td class="tdr">10分
			</td>
		</tr>
        <tr>
			<td class="tdl">预约维修
			</td>
			<td class="tdr">10分
			</td>
		</tr>
        <tr>
			<td class="tdl">救援
			</td>
			<td class="tdr">20分
			</td>
		</tr>
	</table>
<div  class=" paddinfo ksz5">
<p>积分会员升级</p>
<p>标准会员，积分满30分，可升级为正式会员</p>
<p>积分可以用来参与兑换活动，XXXX会不定期退出各类积分兑换活动，请随时关注关于积分的活动告知。</p>
</div>
</section>
<a class="submit-btn" href="javascript:history.go(-1)" >返回</a>
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
