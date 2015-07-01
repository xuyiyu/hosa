$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/order/drives/drives-order!list.htm";
	var getUrl = ctx + "/webadmin/order/drives/drives-order!input.htm";
	var saveUrl = ctx + "/webadmin/order/drives/drives-order!save.htm";
	var deleteUrl = ctx + "/webadmin/order/drives/drives-order!delete.htm";
	
	var queryBrandUrl = ctx + "/webadmin/order/drives/drives-order!loadBrands.htm";
	var queryModelUrl = ctx + "/webadmin/order/drives/drives-order!loadModels.htm";
	
	var drivesorderMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "userId" ,"code","userMobile","userPlate","userName",  "appointmentTimeString" ,  "appointmentTime" ,  "carModelId" ,  "description" ,  "status" ,  "modified"];	
	var searchColumns = [  "userId" ,  "appointmentTime" ,  "carModelId" ,  "description" ,  "status" ,  "modified"];
	var filterColumns = [  "filter_userId" ,  "filter_appointmentTime" ,  "filter_carModelId" ,  "filter_description" ,  "filter_status" ,  "filter_modified"];
	
	
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
					drivesorderMap = new HashMap();
					$.each(data.result, function(i, o){
						drivesorderMap.put(o.id, o);
						
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
		var dept = drivesorderMap.get(itemId);
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
		
		if(!data["status"]){
			editForm.find("[name=status]").val(1);
		}
		
		
		editForm.find("[name=status]").val(1);
		editForm.find("[name=carModelId]").select2({
			placeholder: "选择车系",
			allowClear: true
		});
		editForm.find("[name=carBrandId]").select2({
			placeholder: "选择车型",
			allowClear: true
		}).change(function(){
			
			editForm.find("[name=carModelId]").find(".item").remove();
			editForm.find("[name=carModelId]").select2("val","");
			loadCarModel(editForm,function(){
				editForm.find("[name=carModelId]").select2("val",data["carModelId"]);
			});
		});
		loadCarBrand(editForm,function(){
			var brandId = "";
			if(data.car){
				brandId = data.car.seriesId;
			}
			
			editForm.find("[name=carBrandId]").select2("val",brandId).trigger("change");
		});
	}
	
var loadCarModel = function(form, callback) {
		var brandId = form.find("[name=carBrandId]").select2("val");
		var param = {};
		param["id"] = brandId;
		console.log("11");
		$.webAjax(queryModelUrl, param, function(responseData) {
			console.log("11093");
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					console.log("116");
					$.each(data, function(i, o) {
						form.find("[name=carModelId]").append("<option value='"+o.id+"'  class='item'>"+o.name+"</option>");
					});
					console.log("119");
					if($.isFunction(callback)){
						callback();
					}
				}		
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
		
	}
	
	
	var loadCarBrand = function(form, callback) {
		
		form.find(".item").remove();
		$.webAjax(queryBrandUrl, {}, function(responseData) {
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$.each(data, function(i, o) {
						form.find("[name=carBrandId]").append("<option value='"+o.id+"'  class='item'>"+o.seriesName+"</option>");
					});
					if($.isFunction(callback)){
						callback();
					}
				}		
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
			$.confirm("确认删除DrivesOrder？", function() {
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
			$.alert("请选择要删除的DrivesOrder。");
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
				param["drivesOrder."+o+""] = val;
			} else {
				param["drivesOrder."+o+""] = "";
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
					carModelId : {
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
					carModelId : {
						required : '请输入carModelId'
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
		
		editForm.find("[name=carBrandId]").off("change");
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
				param["drivesOrderQuery."+o+""] = val;
			} else {
				param["drivesOrderQuery."+o+""] = "";
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
				$.alert("请选择要修改的DrivesOrder。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个DrivesOrder。");
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