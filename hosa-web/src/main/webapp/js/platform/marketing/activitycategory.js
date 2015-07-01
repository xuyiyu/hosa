$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/marketing/category/activity-category!list.htm";
	var getUrl = ctx + "/webadmin/marketing/category/activity-category!input.htm";
	var saveUrl = ctx + "/webadmin/marketing/category/activity-category!save.htm";
	var deleteUrl = ctx + "/webadmin/marketing/category/activity-category!delete.htm";
	
	var activityUrl = ctx + "/webadmin/marketing/category/activity-category!loadActivity.htm";
	
	var activitycategoryMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "type", "name" ,  "iconUrl" ,  "iconStoragePath" ,  "description" ,  "modified"];	
	var searchColumns = [  "name" ,  "type", "iconUrl" ,  "iconStoragePath" ,  "description" ,  "modified"];
	var filterColumns = [  "filter_name" , "type",  "filter_iconUrl" ,  "filter_iconStoragePath" ,  "filter_description" ,  "filter_modified"];
	
	
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
					activitycategoryMap = new HashMap();
					$.each(data.result, function(i, o){
						activitycategoryMap.put(o.id, o);
						
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
		var dept = activitycategoryMap.get(itemId);
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
		var activityIdList = {};
		$("#selected").empty();
		if(data.activityList) {
			
			$.each(data.activityList, function(i, o) {
				$("#selected").append("<option value=\""+o.id+"\">"+o.name+"</option>");
				activityIdList["checkedIdList["+i+"]"] = o.id;
			})
		}
		loadActivity(activityIdList);
	}
	
	var loadActivity = function(activityIdList) {
		//var param = {};
		console.debug(activityIdList);
		$.webAjax(activityUrl, activityIdList, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				$("#optional").empty();
				$.each(data, function(i, o) {
					$("#optional").append("<option value=\""+o.id+"\">"+o.name+"</option>");
				})
			}else {
				$.errorNotification(responseData.r_info);
			}
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
			$.confirm("确认删除活动分类？", function() {
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
			$.alert("请选择要删除的活动分类。");
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
				param["activityCategory."+o+""] = val;
			} else {
				param["activityCategory."+o+""] = "";
			}
		});

		$.each($("#selected").find("option"), function(i, o){
			param["activityCategory.activityList["+i+"].id"] = $(o).val();
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
					type : {
						required : true
					},
					name : {
						required : true
					},
					iconUrl : {
						required : true
					},
					iconStoragePath : {
						required : true
					},
					description : {
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
					type : {
						required : '请选择分类类型'
					},
					name : {
						required : '请输入名称'
					},
					iconUrl : {
						required : '请输入iconUrl'
					},
					iconStoragePath : {
						required : '请输入iconStoragePath'
					},
					description : {
						required : '请输入description'
					},
					modified : {
						required : '请输入最后修改时间'
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
		$("#type").select2("val", "");
		$("[item-id=preview]").find("button").trigger("click");
		$("#optional").empty();
		$("#selected").empty();
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
				param["activitycategoryQuery."+o+""] = val;
			} else {
				param["activitycategoryQuery."+o+""] = "";
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
			$("#searchModal").modal();
		});
		$("[item-id=button-toolbar-add]").click(function() {
			loadEditItem();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的活动分类。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个活动分类。");
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
		
		$("[item-id=button-fast-forward]").click(function() {

			$.each($("#optional").find("option"), function(i, o){
				$("#selected").append(o);
			});
		});
		$("[item-id=button-forward]").click(function() {
			
			 $.each($("#optional").find("option:selected"), function(i, o){
					$("#selected").append(o);
				});
		});
		$("[item-id=button-backward]").click(function() {
			$.each($("#selected").find("option:selected"), function(i, o){
				$("#optional").append(o);
			});
		});
		$("[item-id=button-fast-backward]").click(function() {
			//$("#optional").empty();
			$.each($("#selected").find("option"), function(i, o){
				$("#optional").append(o);
			});
		});
		
		
	}
	
	var settingUpload = function() {
    	editForm.find("[name=uploadFile]").fileupload({
	        dataType: 'json',
	        done: function (e, responseData) {
	        	
	        	if(responseData.result.r_code == 0) {
	        		var data = responseData.result.r_data;
	        		
	        		editForm.find("[item-id=preview] a").attr("href", data[0]);
	        		editForm.find("[item-id=preview] img").attr("src", data[0]);
	        		
	        		editForm.find("#iconUrl").val(data[0]);
	        		editForm.find("#iconStoragePath").val(data[1]);
	        	}
	            
	        }
	    });
    	editForm.find("[item-id=preview]").hover(
    			  function () {
    				  var imgSrc = editForm.find("[item-id=preview] img").attr("src");
    				  if(imgSrc != ctx + "/img/user.png") {
    					  editForm.find("[item-id=preview]").find("button").show();
    					 
    				  } 
    				 
    			  },
    			  function () {
    				  editForm.find("[item-id=preview]").find("button").hide();
    			  }
    			);
    	 
		  editForm.find("[item-id=preview]").find("button").click(function() {
	    		editForm.find("[item-id=preview] a").attr("href", ctx + "/img/user.png");
	    		editForm.find("[item-id=preview] img").attr("src", ctx + "/img/user.png");
	    		
	    		editForm.find("#iconUrl").val("");
	    		editForm.find("#iconStoragePath").val("");
			});
    }
	
	
	$().ready(function() {
		settingUpload();
		bindingButtonClick();
		loadList();
		
		$("#type").select2({
			placeholder: "选择分类类型",
			allowClear: true
		});
	});
	
	
})