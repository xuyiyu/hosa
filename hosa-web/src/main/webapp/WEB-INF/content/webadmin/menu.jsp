<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<ul>

		<li><a href="#"><i class="fa fa-lg fa-fw fa-group"></i> <span
				class="menu-item-parent data-default">组织管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="organization/department/list.htm"
					data-name="department-manager" class="data-default">用户组管理</a></li>
					<li><a href="javascript:void(0);"
					data-href="organization/staff/list.htm"
					data-name="staff-manager" class="">用户管理</a></li>
					<li><a href="javascript:void(0);"
					data-href="organization/role/list.htm"
					data-name="role-manager" class="">角色管理</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-lg fa-fw fa-comments"></i> <span
				class="menu-item-parent">微信管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="weixin/inbound/list.htm"
					data-name="staff-manager">微信客服</a></li>
				<li><a href="javascript:void(0);"
					data-href="weixin/settings/settings.htm"
					data-name="settings-manager">参数设置</a></li>
					<li><a href="javascript:void(0);"
					data-href="weixin/menu/list.htm"
					data-name="menu-manager">自定义菜单</a></li>
					<li><a href="javascript:void(0);"
					data-href="weixin/staff/staff-weixin-setting.htm"
					data-name="staff-manager">座席微信设置</a></li>
					<li><a href="javascript:void(0);"
					data-href="weixin/leavemessage/list.htm"
					data-name="leavemessage-manager">留言服务</a></li>
					<li><a href="javascript:void(0);"
					data-href="weixin/user/list.htm"
					data-name="weixin-user-manager">微信用户</a></li>
					
			</ul>
		</li>
		
		<li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">微网站管理</span></a>
			<ul>
				<!-- <li><a href="javascript:void(0);"
					data-href="websetting/scheme/list.htm"
					data-name="scheme-manager">模板管理</a></li> -->
				<!-- <li><a href="javascript:void(0);"
					data-href="websetting/home/list.htm"
					data-name="home-manager">首页管理</a></li> -->
				<!-- <li><a href="javascript:void(0);"
					data-href="websetting/category/list.htm"
					data-name="category-manager">分类管理</a></li>
					
					<li><a href="javascript:void(0);"
					data-href="websetting/article/article-list.htm"
					data-name="article-manager">文章管理</a></li>
					
					<li><a href="javascript:void(0);"
					data-href="websetting/model/model-list.htm"
					data-name="model-manager">页面管理</a></li> -->
				<li><a href="javascript:void(0);"
					data-href="business/series/list.htm"
					data-name="series-manager">车系信息</a></li>
				<li><a href="javascript:void(0);"
					data-href="business/car/list.htm"
					data-name="car-manager">车型信息</a></li>
				<li><a href="javascript:void(0);"
					data-href="business/discharge/list.htm"
					data-name="car-manager">排量信息</a></li>
			</ul>
		</li>
		
			<!-- <li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">车辆管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="business/series/list.htm"
					data-name="series-manager">车系信息</a></li>
				<li><a href="javascript:void(0);"
					data-href="business/car/list.htm"
					data-name="car-manager">车型信息</a></li>
				<li><a href="javascript:void(0);"
					data-href="business/discharge/list.htm"
					data-name="car-manager">排量信息</a></li>
			</ul>
		</li> -->
		
		<!-- <li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">群组管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="weixingroup/group/list.htm"
					data-name="weixingroup-manager">群组管理</a></li>
				<li><a href="javascript:void(0);"
					data-href="weixingroup/groupusers/list.htm"
					data-name="weixingroup-manager">组用户管理</a></li>
			</ul>
		</li> -->
		
		
		<li><a href="#"><i class="fa fa-lg fa-fw fa-tumblr"></i> <span
				class="menu-item-parent">业务群组</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="queue/group/list.htm"
					data-name="queuegroup-manager">群组管理</a></li>
			</ul>
		</li>
		
		<li><a href="#"><i class="fa fa-lg fa-fw fa-ticket"></i> <span
				class="menu-item-parent">营销活动</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="marketing/masssend/massactivity/list.htm"
					data-name="material-manager">群发消息</a></li>
				<li><a href="javascript:void(0);"
					data-href="marketing/coupon/list.htm"
					data-name="material-manager">优惠券管理</a></li>	
				<li><a href="javascript:void(0);"
					data-href="marketing/activity/list.htm"
					data-name="material-manager">促销活动</a></li>
				<li><a href="javascript:void(0);"
					data-href="marketing/couponcheck/list.htm"
					data-name="material-manager">优惠券审核</a></li>
				<li><a href="javascript:void(0);"
					data-href="marketing/couponscan/list.htm"
					data-name="material-manager">优惠券扫描</a></li>
					<li><a href="javascript:void(0);"
					data-href="marketing/category/list.htm"
					data-name="category-manager">活动分类</a></li>
			</ul>
		</li>

		<!-- <li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">会员管理</span></a>
			<ul>				
				<li><a href="javascript:void(0);"
					data-href="user/user/list.htm"
					data-name="user-user-manager">会员管理</a></li>
					
			</ul>
		</li> -->
		<li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">百得利</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="user/group/list.htm"
					data-name="user-group-manager">会员组管理</a></li>
				<li><a href="javascript:void(0);"
					data-href="baideli/user/list.htm"
					data-name="baideli-user-manager">会员管理</a></li>
					
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-lg fa-fw fa-wrench"></i> <span
				class="menu-item-parent">订单管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="order/drives/list.htm"
					data-name="material-manager">试驾订单</a></li>	
					<li><a href="javascript:void(0);"
					data-href="order/repair/list.htm"
					data-name="material-manager">维修订单</a></li>	
					<li><a href="javascript:void(0);"
					data-href="order/maintain/list.htm"
					data-name="material-manager">保养订单</a></li>	
					<li><a href="javascript:void(0);"
					data-href="order/rescue/list.htm"
					data-name="material-manager">救援订单</a></li>	
							
					
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-lg fa-fw fa-linkedin-square"></i> <span
				class="menu-item-parent">商城管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="mall/goodscategory/list.htm"
					data-name="goodscategory-manager">商品分类管理</a></li>
				<li><a href="javascript:void(0);"
					data-href="mall/goods/list.htm"
					data-name="goods-manager">商品管理</a></li>
					<li><a href="javascript:void(0);"
					data-href="mall/goodsorder/list.htm"
					data-name="goodsorder-manager">订单管理</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-lg fa-fw fa-wrench"></i> <span
				class="menu-item-parent">系统管理</span></a>
			<ul>
				<li><a href="javascript:void(0);"
					data-href="system/material/list.htm"
					data-name="material-manager">素材管理</a></li>	
					<li><a href="javascript:void(0);"
					data-href="system/inboundmenu/list.htm"
					data-name="material-manager">自动应答菜单</a></li>		
					
			</ul>
		</li>
		
	</ul>


</body>
</html>
