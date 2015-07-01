<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/web/commons/taglibs.jsp"%>


<!DOCTYPE HTML>
<html>
<head>
<title>北京百得利之星</title>
<%@ include file="/web/commons/meta.jsp"%>

<%@ include file="/web/commons/css.jsp"%>
</head>

<body class="bdlBody">

<table width="90%" border="0" align="center" cellpadding="10" cellspacing="0" class="bdlList">
  <tr>
    <td><a href="http://cha.weiche.me/uc"><img src="${ctx}/web/images/bdl-i1.png"></a>违章查询</td>
    <td><a href="http://map.baidu.com/mobile/webapp/index/index/foo=bar/vt=map&traffic=on&viewmode=no_ad/?third_party=ucsearchbox#index/index/foo=bar/vt=map&traffic=on&viewmode=no_ad"><img src="${ctx}/web/images/bdl-i2.png"></a>交通路况</td>
    <td><a href="http://map.baidu.com/mobile/webapp/search/search/qt=s&wd=%E5%8A%A0%E6%B2%B9%E7%AB%99&c=131"><img src="${ctx}/web/images/bdl-i3.png"></a>加油站</td>
  </tr>
  <tr>
    <td><a href="${ctx}/web/saleonline/assistant/navigation.jsp?i=0&d=${sessionScope.webUser.rootDepartmentId}"><img src="${ctx}/web/images/bdl-i4.png"></a>4S店导航</td>
    <td><a href="http://m.hao123.com/a/tianqi"><img src="${ctx}/web/images/bdl-i5.png"></a>天气</td>
    <td><a href="http://map.baidu.com/mobile/webapp/search/search/qt=s&wd=%E5%81%9C%E8%BD%A6%E5%9C%BA&c=131/"><img src="${ctx}/web/images/bdl-i6.png"></a>停车场</td>
  </tr>
</table>
</body>
</html>