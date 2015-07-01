$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/queue/group/queue!list.htm";
	var getUrl = ctx + "/webadmin/queue/group/queue!input.htm";
	var saveUrl = ctx + "/webadmin/queue/group/queue!save.htm";
	var deleteUrl = ctx + "/webadmin/queue/group/queue!deleteById.htm";
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	
	var columns = ["id", "departmentId","name", "description","modified"];	
	var searchColumns = ["nameLike"];
	var filterColumns = ["filter_name"];
	
	var lastModifiedId = 0;
	var staffMap = new HashMap();
	var queueMap;
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
					queueMap = new HashMap();
					$.each(data.result, function(i, o){
						queueMap.put(o.id, o);
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
		loadList(globalParam);
	}
	
	var viewItem = function(tr) {	
		var itemId = tr.attr("id");
		
		var item = queueMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
			$(o).text(val);
		});
		viewForm.find("[name=hasSelect]").html('');
		
		var param = {};
		param['queueQuery.id'] = itemId;
		var url = ctx +"/webadmin/staff/queryQueueStaffList.htm";
		$.webAjax(url, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				$.each(data, function(i, o) {
					var text = staffMap.get(o.staffId);
					var staffName = getTableJSONVal(text, 'name');
					viewForm.find("[name=hasSelect]").append("<option value='"+o.staffId+"' class='item'>"+staffName+"</option>");
				});
			}else {
				$.errorNotification(responseData.r_info);
			}
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
		param["id"] = itemId;
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var map = responseData.r_data;
				var data = map.queue;
				var staffList = map.staffList;
				if(data) {
					bindingEditItem(data);
				}
				
				//if(staffList==null){
					bindBaseEditItem(staffList);
				//}
				
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	
	}
	
	
	var bindBaseEditItem = function(data){
		//
		$.each(data, function(i, o) {
			editForm.find("[name=waitSelect]").append("<option id='option_"+o.id+"' value='"+o.id+"' class='item'>"+o.name+"</option>");
		});
		editForm.find("[name=addAllButton]").click(function(){
			selectAllToRight();
		});    
		editForm.find("[name=addButton]").click(function(){
			selectToRight();
		});
		editForm.find("[name=delAllButton]").click(function(){
			selectAllToLeft();
		});
		editForm.find("[name=delButton]").click(function(){
			selectToLeft();
		});
		$("#editModal").modal({backdrop: "static"});
	}
	
	/**
	 * 绑定编辑项
	 */
	var bindingEditItem = function(data) {
		cleanEditItem();
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val(data[o]);
		});	
		if(data.queueStaffList==null)return;
		$.each(data.queueStaffList, function(i, o) {
			var staff = staffMap.get(o.staffId);
			console.log(staff);
			var staffName = getTableJSONVal(staff,"name");
			console.log(staffName);
			editForm.find("[name=hasSelect]").append("<option id='option_"+o.staffId+"' value='"+o.staffId+"' class='item'>"+staffName+"</option>");
		});
		
		console.log(editForm.find("[name=hasSelect]").html());
	}


	/**
	 * 删除项
	 */
	var deleteItem = function(itemId) {
		var param = {};
		if(itemId) {
			param["id"] = itemId;
		} 
		
		/*else {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			
			$.each(checkedObj, function(i, o){			
				param["checkedIdList[" + i + "]"] = $(o).val();
			});
		}*/
		
		if(!$.isEmptyObject(param)) {
			$.confirm("确认删除群组？", function() {
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
			$.alert("请选择要删除的群组。");
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
				param["queue."+o+""] = val;
			} else {
				param["queue."+o+""] = "";
			}
		});
		var sourceObj = editForm.find("[name=hasSelect]");
		var index = 0;
	 	$.each(sourceObj.find("option"),function(i,o){
	 		param['checkedIdList['+index+']'] = $(this).val();
	 		index++;
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
					name : {
						required : true
					}
				},

				// Messages for form validation
				messages : {
					title : {
						required : '请输入群组名称'
					}
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
		editForm.find("[name=waitSelect]").html('');
		editForm.find("[name=hasSelect]").html('');
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
				param["queueQuery."+o+""] = val;
			} else {
				param["queueQuery."+o+""] = "";
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
		
		$("[item-id=button-save]").click(function() {
			saveItem();
		});
		
		$("[item-id=button-cancel]").click(function() {
			canceEditlItem();			
		});
		$("[item-id=button-filter-refresh]").click(function() {
			filterRefreshItem();
		});
		$("[item-id=button-toolbar-add]").click(function() {
			loadEditItem();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的群组。");
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
	
	
	/**
	 * 查询座席列表
	 */
	var loadStaffList = function(p) {	
		var url = ctx + "/webadmin/staff/queryStaffList.htm";
		$.webAjax(url, null, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				console.log('staffMap');
				console.log(data);
				if(data) {
					staffMap = new HashMap();
					
					$.each(data, function(i, o){
						staffMap.put(o.id, o);
					});
					console.log(staffMap.values());
				}else {
					$.errorNotification(responseData.r_info);
				}
			}
		});
	};
	
	
	function sort(selectObj){
		selectObj.find('option').sort(function(a,b){ 
		    var aText = $(a).val(); 
		    var bText = $(b).val(); 
		    return aText-bText;
		}).appendTo(selectObj) ; 
	}
	
	function selectToRight(){
		var sourceObj = editForm.find("[name=waitSelect]");
		var targetObj = editForm.find("[name=hasSelect]");
		if(sourceObj.find("option:selected").length>0)
			singleMove(sourceObj,targetObj);
	}
	
	function selectAllToRight(){
		var sourceObj = editForm.find("[name=waitSelect]");
		var targetObj = editForm.find("[name=hasSelect]");
		chooseMove(sourceObj,targetObj);
	}
	
	function selectToLeft(){
		var sourceObj = editForm.find("[name=hasSelect]");
		var targetObj = editForm.find("[name=waitSelect]");
		if(sourceObj.find("option:selected").length>0)
			singleMove(sourceObj,targetObj);
	}
	
	function selectAllToLeft(){
		var sourceObj = editForm.find("[name=hasSelect]");
		var targetObj = editForm.find("[name=waitSelect]");
		chooseMove(sourceObj,targetObj);
	}

	function singleMove(sourceObj,targetObj){
		$.each(sourceObj.find("option:selected"),function(i,o){
			var selectValue = $(this).val();
			var selectTxt = $(this).text();
			$("<option></option>").attr('id','option_'+selectValue).val(selectValue).html(selectTxt).appendTo(targetObj);
			$(o).remove();
		});
		sort(targetObj);
	}
	
	function chooseMove(sourceObj,targetObj){
		$.each(sourceObj.find("option"),function(i,o){
			var selectValue = $(this).val();
			var selectTxt = $(this).text();
			$("<option></option>").attr('id','option_'+selectValue).val(selectValue).html(selectTxt).appendTo(targetObj);
		});
		sourceObj.html("");
		sort(targetObj);
	}
	
	function removeItem(){
		var sourceObj = editForm.find("[name=waitSelect]");	
		$.each(sourceObj.find("option"),function(i,o){
			var item = editForm.find('[name=hasSelect] #option_'+$(this).val());
			if(item.html() != null){
				$(o).remove();
			}
		});
	}
	
	$().ready(function() {
		bindingButtonClick();
		loadStaffList();
		loadList();
	});
	
});


