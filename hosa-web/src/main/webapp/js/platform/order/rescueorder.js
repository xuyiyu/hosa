$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/order/rescue/rescue-order!list.htm";
	var getUrl = ctx + "/webadmin/order/rescue/rescue-order!input.htm";
	var saveUrl = ctx + "/webadmin/order/rescue/rescue-order!save.htm";
	var deleteUrl = ctx + "/webadmin/order/rescue/rescue-order!delete.htm";
	
	var rescueorderMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "userId" ,"code","userMobile","userPlate","userName",  "appointmentTime" ,"appointmentTimeString",  "location" ,  "description" ,  "status" ,  "modified" ,  "accidentDescription" ,  "accidentImgStoragePath" ,  "accidentImgUrl"];	
	var searchColumns = [  "userId" ,  "appointmentTime" ,  "location" ,  "description" ,  "status" ,  "modified" ,  "accidentDescription" ,  "accidentImgStoragePath" ,  "accidentImgUrl"];
	var filterColumns = [  "filter_userId" ,  "filter_appointmentTime" ,  "filter_location" ,  "filter_description" ,  "filter_status" ,  "filter_modified" ,  "filter_accidentDescription" ,  "filter_accidentImgStoragePath" ,  "filter_accidentImgUrl"];
	
	
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
					rescueorderMap = new HashMap();
					$.each(data.result, function(i, o){
						rescueorderMap.put(o.id, o);
						
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
							viewItem(tr);
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
					.summary(data.length);
					
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
		loadList(globalParam);
	}
	
	var viewItem = function(tr) {	
		var itemId = tr.attr("id");
		var param = {};
		var dept = rescueorderMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(dept, id);
			$(o).text(val);
		});
		
		if(tr.prev("tr:visible").length > 0) {
			$("[item-id=button-view-previous]").removeClass("disabled");
			$("[item-id=button-view-previous]").click(function() {
				viewItem(tr.prev("tr:visible"));
			});
		} else {
			$("[item-id=button-view-previous]").addClass("disabled");
		}
		if(tr.next("tr:visible").length > 0) {
			$("[item-id=button-view-next]").removeClass("disabled");
			$("[item-id=button-view-next]").click(function() {
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
		if(!data[status]){
			editForm.find("[name=status]").val(1);
		}
		console.log(data["accidentImgUrl"]);
		console.log(editForm.find("[item-id=preview] img").attr("src"));
		if(data["accidentImgUrl"]){
			editForm.find("[item-id=preview] img").attr("src", data["accidentImgUrl"]);
		}
		
		
		
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
			$.confirm("确认删除RescueOrder？", function() {
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
			$.alert("请选择要删除的RescueOrder。");
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
				param["rescueOrder."+o+""] = val;
			} else {
				param["rescueOrder."+o+""] = "";
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
					userId : {
						required : true
					},
					appointmentTime : {
						required : true
					},
					location : {
						required : true
					},
					description : {
						required : true
					},
					status : {
						required : true
					},
					modified : {
						required : true
					},
					accidentDescription : {
						required : true
					},
					accidentImgStoragePath : {
						required : true
					},
					accidentImgUrl : {
						required : true
					},
					userName :{
						required : true
					},
					userMobile:{
						required : true
					},
					userPlate:{
						required : true
					},
					appointmentTimeString:{
						required : true
					},
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入id'
					},
					userId : {
						required : '请输入userId'
					},
					appointmentTime : {
						required : '请输入appointmentTime'
					},
					location : {
						required : '请输入location'
					},
					description : {
						required : '请输入description'
					},
					status : {
						required : '请输入1：已提交             2：已确认             3：已到店'
					},
					modified : {
						required : '请输入modified'
					},
					accidentDescription : {
						required : '请输入accidentDescription'
					},
					accidentImgStoragePath : {
						required : '请输入accidentImgStoragePath'
					},
					accidentImgUrl : {
						required : '请输入accidentImgUrl'
					},
					userName :{
						required : "请输入客户名称"
					},
					userMobile:{
						required : "请输入客户联系方式"
					},
					userPlate:{
						required : "请输入车牌号"
					},
					appointmentTimeString:{
						required : "请输入预订时间"
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
		editForm.find("[item-id=preview] img").attr("src", ctx+"/img/user.png");
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
				param["rescueOrderQuery."+o+""] = val;
			} else {
				param["rescueOrderQuery."+o+""] = "";
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
				$.alert("请选择要修改的RescueOrder。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个RescueOrder。");
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
	
	
	 var settingUpload = function() {
	    	editForm.find("[name=uploadFile]").fileupload({
		        dataType: 'json',
		        done: function (e, responseData) {
		        	
		        	if(responseData.result.r_code == 0) {
		        		var data = responseData.result.r_data;
		        		
		        		editForm.find("[item-id=preview] a").attr("href", data[0]);
		        		editForm.find("[item-id=preview] img").attr("src", data[0]);
		        		
		        		editForm.find("#accidentImgUrl").val(data[0]);
		        		editForm.find("#accidentImgStoragePath").val(data[1]);
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
		    		
		    		editForm.find("#accidentImgUrl").val("");
		    		editForm.find("#accidentImgStoragePath").val("");
				});
	    }
	$().ready(function() {
		bindingButtonClick();
		loadList();
		settingUpload();
	});
	
	
})