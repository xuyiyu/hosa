<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ include file="../../commons/scripts.jsp"%>
<%@ page  isELIgnored="false"   %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>
<%@ include file="/web/commons/css.jsp"%>
<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/web/css/mc.css">
</head>

<body class="gray-gradient-bg">
<section>
<div class="mctitle">
<a href="${ctx}/web/index.jsp?d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/iconhome.png" /></a>
<a name="menu" href="javascript:void();"><img src="${ctx}/web/images/newlist.png" /></a>

</div>
</section>
<section>
<ul class="navli clearFix">
<li ><a href="javascript:void(0);">车型中心</a></li>
<li ><a href="javascript:void(0);">促销活动</a></li>
<li class="navactive"><a href="javascript:void(0);">预约试驾</a></li>
<li ><a href="javascript:void(0);">车行助手</a></li>
</ul>
</section>
<section style=" position:relative ">
<a href=""><img src="${ctx }/web/images/mc-cxhdflash.jpg" /></a>
<div class="conimg" style="text-align:right; padding-right:5%;">
<em></em>
<em class="active"></em>
<em></em>
</div>
</section>
<section class="submit-result">
	<h3 class="result-title success"><img src="${ctx }/web/images/mc-tj_ico.png" align="absmiddle"><span>已成功提交信息</span></h3>
	<p class="text-intro">稍后我们的客户经理会与您联系</p>
    <p  class="redfont">温馨提示：到店试驾，请携带您的驾驶执照</p>
	<a href="javascript:void(0);" class="ok-submit">返回首页</a>
</section>
<!--小浮层-->
<section class="fuchen hide">
<ul>
<li><em></em>
<p><img src="${ctx }/web/images/tou.png">咨询顾问</p>
<a href="javascript:void(0);"><img src="${ctx }/web/images/phone.png"><span>电话咨询</span></a>
</li>
</ul>
</section>
</body>
</html>