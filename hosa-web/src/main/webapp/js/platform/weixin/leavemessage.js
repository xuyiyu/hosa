$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/weixin/leavemessage/weixin-leave-message!list.htm";
	var replyUrl = ctx + "/webadmin/weixin/leavemessage/weixin-leave-message!reply.htm";

	
	var searchForm = $("#search-form");
	
	
	var columns = ["id", "departmentId","name", "count","modified"];	
	var searchColumns = ["nameLike"];
	var filterColumns = ["filter_name"];
	
	var lastModifiedId = 0;
	/**
	 * 绑定列表参数
	 */
	var bindingListParam = function(o) {
		var param = {};
		if($.isEmptyObject(o)) {
			o = {
					"page.pageNo":1, 
					"page.pageSize":10, 
					"page.orderBy": "msg_id", 
					"page.order": "desc"
					};
		}
		param = $.extend({}, globalParam, o || {});
		globalParam = param;
		return param;
	}
	
	/**
	 * 查询列表
	 */
	var loadList = function(p) {	
		var param = bindingListParam(p);
		
		$.webAjax(queryUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
				var r_data = responseData.r_data;
				var data = r_data.page;
				var systemTime = r_data.systemTime;
				if(data) {console.log(data);
					var smartFormDiv = $('#list_view').empty();
					$.each(data.result, function(i, msg){
						var o = msg.weixinUsers;
						var imgPicUrl = ctx + "/img/user.png";
						if(o.headImgUrl){
							imgPicUrl = o.headImgUrl;
						}
						
						$('<span class="timeline-seperator text-center" id="span_'+msg.messageId+'">'+msg.createdAtString+'</span></span>').appendTo(smartFormDiv);
						var mainRowDiv = $('<div class="row margin-top-10 leavemessage"></div>').appendTo(smartFormDiv);
						var mainRowColDiv = $('<section class="col"></section>').appendTo(mainRowDiv);
						var mainRowsectionDiv = $('<section class="col col-12"></section>').appendTo(mainRowColDiv);
						$('<img src="'+imgPicUrl+'" style="top: 0px; width: 80px; height: 100px;">').appendTo(mainRowsectionDiv);
						
						var secondSectionDiv = $('<section class="col col-6"></section>').appendTo(mainRowDiv);
						var second2RowDiv = $('<div class="row"></div>').appendTo(secondSectionDiv);
						var second2SectionDiv = $('<section class="col col-12"></section>').appendTo(second2RowDiv);
						$('<label class="input"><span>微信昵称：</span><span>'+(o.nickName !=null?o.nickName:"---")+'</span></label>').appendTo(second2SectionDiv);	
						
						
						var second3RowDiv = $('<div class="row"></div>').appendTo(secondSectionDiv);
						var second3SectionDiv = $('<section class="col col-12"></section>').appendTo(second3RowDiv);
						$('<label class="input"><span>客户姓名：</span><span>'+(o.customerName !=null?o.customerName:"---")+'</span></label>').appendTo(second3SectionDiv);	
						
						var second4RowDiv = $('<div class="row"></div>').appendTo(secondSectionDiv);
						var second4SectionDiv = $('<section class="col col-12"></section>').appendTo(second4RowDiv);
						$('<label class="input"><span>性别：</span><span>'+ (o.sex==1?"男":(o.sex==2?"女":"未知")) +'</span></label>').appendTo(second4SectionDiv);	
						
						var second5RowDiv = $('<div class="row"></div>').appendTo(secondSectionDiv);
						var second5SectionDiv = $('<section class="col col-12"></section>').appendTo(second5RowDiv);
						$('<label class="input"><span>手机：</span><span>'+ (o.mobile !=null?o.mobile:"---") +'</span></label>').appendTo(second5SectionDiv);	
						
						var second6RowDiv = $('<div class="row"></div>').appendTo(secondSectionDiv);
						var second6SectionDiv = $('<section class="col col-12"></section>').appendTo(second6RowDiv);
						$('<label class="input"><span>邮箱：</span><span>'+ (o.email !=null?o.email:"---") +'</span></label>').appendTo(second6SectionDiv);	
						
				
						var threeSectionDiv = $('<section class="col col-4"></section>').appendTo(mainRowDiv);
						var three2SectionDiv = $('<section id="section_'+msg.messageId+'"></section>').appendTo(threeSectionDiv);
						var threeRow = $('<div class="row"></div>').appendTo(three2SectionDiv);
						$('<label class="input"><span>留言：</span><span>'+msg.content+'</span></label>').appendTo(threeRow);	
						
						
						
						
						var ButtonRowDiv = $('<div id=br_'+msg.messageId+' class="row"></div>').appendTo(smartFormDiv);
						var ButtonSectionDiv = $('<section class="col col-12"></section>').appendTo(ButtonRowDiv);
						
						

						if(msg.status==1){
							var threeSecondRow = $('<div class="row"></div>').appendTo(three2SectionDiv);
							var content = "("+msg.staff.nickName+")回复:"+msg.feedMessage.content;
							$('<label class="input">'+content+'</label>').appendTo(threeSecondRow);	
						}else{
							
							var Button2SectionDiv = $('<div id="replyDiv_'+msg.messageId+'"></div>').appendTo(ButtonSectionDiv);
							var ulObj = $('<ul id="" class="list-inline font-xs"></ul').appendTo(Button2SectionDiv);
							
							if(msg.createdAtString>systemTime){
								var liObj = $('<li class="pull-right"></li>').appendTo(ulObj);
								$('<a href="javascript:void(0);" class="text-info "></a>').click(function(){
									var reply = $('#br_'+msg.messageId).find('.leavemessage_replay');;
									
									if(reply.is(":hidden")){
										reply.show();
									}else{
										reply.hide();
									}
								}).appendTo(liObj).html('<i class="fa fa-reply"></i> 回复');
								
							}else{
								$('<li class="pull-right">已超时</li>').appendTo(ulObj);
							}
							$('<li></li>').appendTo(ulObj);
						}
						
						var form = $('<form id="reply_form" class="well padding-bottom-10 leavemessage_replay" style="display:none;" onsubmit="return false;"></form>').appendTo(ButtonSectionDiv).append('<textarea rows="3" class="form-control replycontent" placeholder=""></textarea>');
						var formDiv = $('<div class="margin-top-10 padding-bottom-10"></div>').appendTo(form);
						var butDiv = $('<div class="margin-top-10 padding-bottom-10"></div>').appendTo(formDiv);
						
						$('<button type="submit" class="btn btn-sm btn-primary pull-right">提交</button>').click(function(){
							 var content =  $('#br_'+msg.messageId).find('.replycontent').val();
							 replyLeaveMessage(msg.messageId,content,$('#br_'+msg.messageId));
						}).appendTo(butDiv);
						
					});
					
					
					$.paging({template: 'default'})				
					.paging(data, function(p) {
						param['page.pageNo'] = p.pageNo;
						param['page.pageSize'] = p.pageSize;
						param['page.orderBy'] = p.orderBy;
						param['page.order'] = p.order;
						loadList(param);
					});
					//filterItem();
				}

			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	/**
	 * 筛选列表结果集
	 */
	var filterItem = function() {
		 var options = {
		         valueNames: filterColumns,//筛选字段 class="filter_name"
		         plugins: [
		                   ListFuzzySearch()
		                   ]
		     };
		 var contactList = new List(dataTable.attr("id"), options);//页面需要声明data-table, class="list"
		 $("[item-id=input-filter]").off("keyup");
		 $("[item-id=input-filter]").on("keyup", function () {
	         contactList.fuzzySearch.search($(this).val());
	     });
	}
	
	/**
	 * 清空筛选条件
	 */
	var filterRefreshItem = function() {
		$("[item-id=input-filter]").val("");
		loadList(globalParam);
	}
	
	
	
	/**
	 * 搜索项
	 */
	var searchItem = function() {
		var searchModal = $("#searchModal");
		var searchParam = bindingSearchParam();
		loadList(searchParam);
		searchModal.modal("hide");
	}
	
	/**
	 * 绑定搜索条件
	 */
	var bindingSearchParam = function() {
		var param = {};
		$.each(searchColumns, function(i, o) {
			var val =  $.trim(searchForm.find("[name="+o+"]").val());

			if(val) {
				param["weixinGroupsQuery."+o+""] = val;
			} else {
				param["weixinGroupsQuery."+o+""] = "";
			}
		});
		
		return param;
	}
	
	/**
	 * 清空搜索条件
	 */
	var resetSearchItem = function() {
		var searchModal = $("#searchModal");
		$.each(searchColumns, function(i, o) {
			searchForm.find("[name="+o+"]").val("");
		});

		globalParam = {};
		loadList();
		searchModal.modal("hide");
	}
	
	/**
	 * 绑定页面按钮事件
	 */
	var bindingButtonClick = function() {
		
		
		$("[item-id=button-filter-refresh]").click(function() {
			filterRefreshItem();
		});
		/* 搜索*/
		$("[item-id=button-search]").click(function() {
			searchItem();
		});
		$("[item-id=button-search-reset]").click(function() {
			resetSearchItem();
		});
		
	}
	
	function replyLeaveMessage(id,content,_self){
		console.log("id:"+id+"--content:"+content);
		var param = {};
		param['id'] = id;
		param['content'] = content;
		console.log(param);
		$.webAjax(replyUrl, param, function(responseData) {
			if(responseData.r_code == 0) {
					_self.find('.leavemessage_replay').hide();
					_self.find('.replycontent').val('');

					$('#replyDiv_'+id).hide();
					var r_data = responseData.r_data;
					var createdAt = r_data.createdAt;
					var staffNickName = r_data.staffNickName;
					
					var threeSecondRow = $('<div class="row"></div>').appendTo($('#section_'+id));
					content = "("+staffNickName+")回复:"+content;
					$('<label class="input">'+content+'</label>').appendTo(threeSecondRow);	
					$('#span_'+id).html(createdAt);
					
			}else {
				$.errorNotification(responseData.r_info);
			}
			
		});
	}
	
	$().ready(function() {
		bindingButtonClick();
		loadList();
	});
	
	
	
});


