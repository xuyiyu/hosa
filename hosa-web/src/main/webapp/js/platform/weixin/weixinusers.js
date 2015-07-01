$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/weixin/user/weixin-users!list.htm";
	var getUrl = ctx + "/webadmin/weixin/user/weixin-users!input.htm";
	var saveUrl = ctx + "/webadmin/weixin/user/weixin-users!save.htm";
	var deleteUrl = ctx + "/webadmin/weixin/user/weixin-users!delete.htm";
	
	var weixinusersMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "openId" ,  "departmentId" ,  "nickName" ,  "sex" ,  "city" ,  "country" ,  "province" ,  "language" ,  "headImgUrl" ,  "createdAt" ,  "subscribeTime" ,  "customerName" ,  "birthday" ,  "mobile" ,  "officePhone" ,  "homePhone" ,  "email" ,  "qq" ,  "msn" ,  "postcode" ,  "unreadCount" ,  "lastInteractTime" ,  "lastMessageId" ,  "modified"];	
	var searchColumns = [  "nickNameLike" ,  "sex" , "subscribeTimeBegin" , "subscribeTimeEnd"];
	var filterColumns = [  "filter_openId" ,  "filter_departmentId" ,  "filter_nickName" ,  "filter_sex" ,  "filter_city" ,  "filter_country" ,  "filter_province" ,  "filter_language" ,  "filter_headImgUrl" ,  "filter_createdAt" ,  "filter_subscribeTime" ,  "filter_customerName" ,  "filter_birthday" ,  "filter_mobile" ,  "filter_officePhone" ,  "filter_homePhone" ,  "filter_email" ,  "filter_qq" ,  "filter_msn" ,  "filter_postcode" ,  "filter_unreadCount" ,  "filter_lastInteractTime" ,  "filter_lastMessageId" ,  "filter_modified"];
	
	
	/**
	 * 绑定列表参数
	 */
	var bindingListParam = function(o) {
		var param = {};
		if($.isEmptyObject(o)) {
			o = {
					"page.pageNo":1, 
					"page.pageSize":10, 
					"page.orderBy": "id", 
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
			dataTable.find(".item").remove();
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					weixinusersMap = new HashMap();
					$.each(data.result, function(i, o){
						weixinusersMap.put(o.id, o);
						
						var template = dataTable.find("tr[item-template]");
						var tr = template.clone();
						tr.removeAttr("item-template");
						var items = tr.find("td");
						tr.attr("id", o.id);
						tr.addClass("item");
						if(o.id == lastModifiedId) {
							tr.addClass("last-modified");
						}
						tr.find("input[name='checkRow']").val(o.id);//设置复选框值
				
						$.each(items, function(m, n) {//设置每行的内容
							var id = $(n).attr("item-id");
							var itemVal;
							try {
								itemVal = getTableJSONVal(o, id);
								$(n).attr("title", itemVal);
								$(n).text(itemVal);
							}catch(e){								
							}
							
						});
						tr.find("[item-id='headImgUrl'] img").attr("src", o.headImgUrl);
						
						tr.find("[item-view]").click(function() {
							viewItem(tr)
						});
						tr.find("[item-id=button-modify]").click(function() {//绑定修改操作
							loadEditItem(o.id);
						});
						tr.find("[item-id=button-delete]").click(function() {//绑定删除操作
							deleteItem(o.id);
						});
						
						tr.appendTo(dataTable.find("tbody"));						
						tr.show();
					});
					
					$.paging({template: 'default'})				
					.paging(data, function(p) {
						param['page.pageNo'] = p.pageNo;
						param['page.pageSize'] = p.pageSize;
						param['page.orderBy'] = p.orderBy;
						param['page.order'] = p.order;
						loadList(param);
					});
					
					if(data.result.length == 0) {
						
						var template = dataTable.find("tr[item-template]");
						
						var tr = template.clone();
						tr.removeAttr("item-template");
						tr.addClass("item");
						
						var itemLength = tr.find("td").length;
						tr.empty();
						
						var item = $("<td></td>");
						item.addClass("data_empty");
						item.attr("colspan", itemLength);
						item.html(i18n.noRecordFound);
						item.appendTo(tr);
						
						tr.appendTo(dataTable.find("tbody"));		
						tr.show();
						
					}
					$(".nailthumb-container").nailthumb();
					filterItem();
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
		$("[item-id=input-filter]").trigger("keyup");
	}
	
	var viewItem = function(tr) {	
		var itemId = tr.attr("id");
		var param = {};
		var dept = weixinusersMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(dept, id);
			$(o).text(val);
		});
		
		$("[item-id=button-view-previous]").off("click");
		if(tr.prev("tr:visible").length > 0) {
			$("[item-id=button-view-previous]").removeClass("disabled");
			$("[item-id=button-view-previous]").on("click", function() {
				viewItem(tr.prev("tr:visible"));
			});
		} else {
			$("[item-id=button-view-previous]").addClass("disabled");
		}
		
		$("[item-id=button-view-next]").off("click");
		if(tr.next("tr:visible").length > 0) {
			$("[item-id=button-view-next]").removeClass("disabled");
			$("[item-id=button-view-next]").on("click", function() {
				viewItem(tr.next("tr:visible"));
			});
		} else {
			$("[item-id=button-view-next]").addClass("disabled");
		}
		
		$("#viewModal").modal();
	}
	
	/**
	 * 加载编辑项
	 */
	var loadEditItem = function(itemId) {		
		var param = {};
		if(itemId) {
			param["id"] = itemId;
		}
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					bindingEditItem(data);
					
					$("#editModal").modal({backdrop: "static"});
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	
	}
	
	
	/**
	 * 绑定编辑项
	 */
	var bindingEditItem = function(data) {
		cleanEditItem();
		
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val(data[o]);
		});
	
		
	}
	
	
	
	/**
	 * 删除项
	 */
	var deleteItem = function(itemId) {
		var param = {};
		if(itemId) {
			param["checkedIdList[0]"] = itemId;
		} else {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			
			$.each(checkedObj, function(i, o){			
				param["checkedIdList[" + i + "]"] = $(o).val();
			});
		}
		
		if(!$.isEmptyObject(param)) {
			$.confirm("确认删除WeixinUsers？", function() {
				$.webAjax(deleteUrl, param, function(responseData) {
					
					if(responseData.r_code == 0) {
						var data = responseData.r_data;
						$.successNotification(responseData.r_info);
						loadList(globalParam);
					}else {
						$.errorNotification(responseData.r_info);
					}
				});
			});
			
		} else {
			$.alert("请选择要删除的WeixinUsers。");
		}
	}
	
	/**
	 * 保存项
	 */
	var saveItem = function() {
		if(!verifySaveParam()) {
			return;
		}
		
		var param = bindingSaveParam();
		console.debug(param);
		$.webAjax(saveUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					lastModifiedId = data.id;
				}
				$.successNotification(responseData.r_info);
				canceEditlItem();
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	}
	
	/**
	 * 绑定保存的属性
	 */
	var bindingSaveParam = function() {
		var param = {};
		
		$.each(columns, function(i, o) {
			var val =  $.trim(editForm.find("[name="+o+"]").val());
			
			
			if(val) {
				param["weixinusers."+o+""] = val;
			} else {
				param["weixinusers."+o+""] = "";
			}
		});

		return param;
	}
	
	/**
	 * 校验保存的属性
	 */
	var verifySaveParam = function() {
		editFormValidator = editForm.validate({
				onsubmit:false ,
				rules : {
					id : {
						required : true
					},
					openId : {
						required : true
					},
					departmentId : {
						required : true
					},
					nickName : {
						required : true
					},
					sex : {
						required : true
					},
					city : {
						required : true
					},
					country : {
						required : true
					},
					province : {
						required : true
					},
					language : {
						required : true
					},
					headImgUrl : {
						required : true
					},
					createdAt : {
						required : true
					},
					subscribeTime : {
						required : true
					},
					customerName : {
						required : true
					},
					birthday : {
						required : true
					},
					mobile : {
						required : true
					},
					officePhone : {
						required : true
					},
					homePhone : {
						required : true
					},
					email : {
						required : true
					},
					qq : {
						required : true
					},
					msn : {
						required : true
					},
					postcode : {
						required : true
					},
					unreadCount : {
						required : true
					},
					lastInteractTime : {
						required : true
					},
					lastMessageId : {
						required : true
					},
					modified : {
						required : true
					},
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入id'
					},
					openId : {
						required : '请输入用户标识'
					},
					departmentId : {
						required : '请输入departmentId'
					},
					nickName : {
						required : '请输入昵称'
					},
					sex : {
						required : '请输入性别{1：男，2：女，3：未知}'
					},
					city : {
						required : '请输入城市'
					},
					country : {
						required : '请输入国家'
					},
					province : {
						required : '请输入省份'
					},
					language : {
						required : '请输入语言'
					},
					headImgUrl : {
						required : '请输入头像'
					},
					createdAt : {
						required : '请输入创建时间'
					},
					subscribeTime : {
						required : '请输入关注时间'
					},
					customerName : {
						required : '请输入customerName'
					},
					birthday : {
						required : '请输入birthday'
					},
					mobile : {
						required : '请输入mobile'
					},
					officePhone : {
						required : '请输入officePhone'
					},
					homePhone : {
						required : '请输入homePhone'
					},
					email : {
						required : '请输入email'
					},
					qq : {
						required : '请输入qq'
					},
					msn : {
						required : '请输入msn'
					},
					postcode : {
						required : '请输入postcode'
					},
					unreadCount : {
						required : '请输入unreadCount'
					},
					lastInteractTime : {
						required : '请输入lastInteractTime'
					},
					lastMessageId : {
						required : '请输入lastMessageId'
					},
					modified : {
						required : '请输入modified'
					},
				},

				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			
			});
			 
			 return editForm.valid();
	}
	
	/**
	 * 取消编辑项
	 */
	var canceEditlItem = function() {
		cleanEditItem();
		loadList(globalParam);
		$("#editModal").modal("hide");
	}
	
	/**
	 * 清空编辑项
	 */
	var cleanEditItem = function() {
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val("");
		});
		
		if(editFormValidator) {
			editForm.find(".state-error").removeClass("state-error");
			editForm.find(".state-error").removeClass("state-success");
			editFormValidator.resetForm();  
		}
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
				param["weixinUsersQuery."+o+""] = val;
			} else {
				param["weixinUsersQuery."+o+""] = "";
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
			searchForm.find("[name="+o+"]").val("")
		});
		searchForm.find("[name=sex]").select2("val", "");
		globalParam = {};
		loadList();
		searchModal.modal("hide");
	}
	
	/**
	 * 绑定页面按钮事件
	 */
	var bindingButtonClick = function() {
		
		$("[item-id=button-save]").click(function() {
			saveItem();
		});
		
		$("[item-id=button-cancel]").click(function() {
			canceEditlItem();			
		});
		$("[item-id=button-filter-refresh]").click(function() {
			filterRefreshItem();
		});
		$("[item-id=buttong-toolbar-search]").click(function() {	
			searchForm.find("[name=sex]").select2({
				placeholder: "性别",
				allowClear: true
			});
			$("#searchModal").modal();
		});
		$("[item-id=button-toolbar-add]").click(function() {
			loadEditItem();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的WeixinUsers。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个WeixinUsers。");
				return;
			}
			loadEditItem(checkedObj.val());
		});
		$("[item-id=button-toolbar-delete]").click(function() {
			deleteItem();
		});

		/* 搜索*/
		$("[item-id=button-search]").click(function() {
			searchItem();
		});
		$("[item-id=button-search-reset]").click(function() {
			resetSearchItem();
		});
	}
	
	$().ready(function() {
		bindingButtonClick();
		loadList();
	});
	
	
})