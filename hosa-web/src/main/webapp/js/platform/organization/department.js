$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/organization/department/department!list.htm";
	var getUrl = ctx + "/webadmin/organization/department/department!input.htm";
	var saveUrl = ctx + "/webadmin/organization/department/department!save.htm";
	var deleteUrl = ctx + "/webadmin/organization/department/department!delete.htm";
	
	var queryRoleUrl = ctx + "/webadmin/organization/department/department!loadRole.htm";
	
	var departmentMap = new HashMap();
	var roleArray = new Array();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	
	var columns = ["id", "parentId", "name", "description", "modified"];	
	var searchColumns = ["nameLike"];
	var filterColumns = ["filter_name", "filter_parentName", "filter_description"];
	
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
					"page.orderBy": "created_at", 
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
					departmentMap = new HashMap();
					$.each(data, function(i, o){
						departmentMap.put(o.id, o);
						
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
					.summary(data.length);
					
					if(data.length == 0) {
						
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
						
						tr.appendTo(dataTable.find$("tbody"));		
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
		var item = departmentMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
			$(o).text(val);
		});
		
		var roleNames = "";
		if(item.roleList) {
			$.each(item.roleList, function(i, o) {
				if(i > 0) {
					roleNames += ", ";
				}
				roleNames += o.name;
			});
			viewForm.find("[item-id=role-list]").text(roleNames);
		}
		
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
		
		var roleIdList = data.roleIdList;
		loadRole(function(){
			loadDepartmentCategory(editForm, data.parentId);
			bindingRole(data.parentId, data.id);
			if(roleIdList) {
				$.each(roleIdList, function(i, o) {
					var roleId = o;
					var checkbox = editForm.find("#role-list").find("input[value="+roleId+"]");
					checkbox.prop("checked", true);
				});
			}
		});
		
	}
	
	/**
	 * 加载角色
	 */
	var loadRole = function(callback) {
		roleArray = new Array(); 
		
		editForm.find("#role-list").find(".item").remove();
		$.webAjax(queryRoleUrl, {}, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$.each(data, function(i, o) {
						var roleId = o.id;
						roleArray[roleArray.length] = o;
					});
					
					if($.isFunction(callback)) {
						callback();
					}
				}		
				
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	/**
	 * 绑定角色
	 */
	var bindingRole = function(parentId, itemId) {
		
		 var roleList = new Array();
		 var condition = true;
		 if(parentId == 0) {
			 roleList = roleArray;
		 } else {
			 var item = departmentMap.get(parentId);
			 if(!$.isEmptyObject(item)) {
				 roleList = item.roleList;
			 } else {
				 item = departmentMap.get(itemId);
				 condition = false;
				 if(!$.isEmptyObject(item)) {
					 roleList = item.roleList;
				 } 
			 }
			 
		 }
		 
		 
		
		 
		 editForm.find("#role-list").find(".item").remove();
		 if(!$.isEmptyObject(roleList)) {
			 $.each(roleList, function(i, o) {
					
					var template = editForm.find("#role-list").find("[item-template]");
					var item = template.clone();
					item.removeAttr("item-template");
					item.addClass("item");
					item.find("i").after(o.name);
					item.find("input").val(o.id);
					
					var number = (i+1)%3==0?3:((i+1)%3);
					item.appendTo(editForm.find("#role-list div:nth-child("+(number+1)+")"));
					if(!condition) {
						item.addClass("state-disabled");
						item.find("input").attr("disabled", true);
					} 
					item.show();
				})
		 }
			
		}
	
	/**
	 * 加载隶属用户组
	 */
	var loadDepartmentCategory = function(form, selectedId) {
		form.find("[name=parentId]").children(".item").remove();
		if(selectedId != null) {
			form.find("[name=parentId]").parent().addClass("state-disabled");
			form.find("[name=parentId]").attr("disabled", true);
		} else {
			form.find("[name=parentId]").parent().removeClass("state-disabled");
			form.find("[name=parentId]").attr("disabled", false);
		}
		$.each(departmentMap.values(), function(i, o) {
			
			var levelArray = o.level.split("-");
			var text = "";
			$.each(levelArray, function(m, n) {
				
				if(n && n > 0) {
					var item = departmentMap.get(n);
					if(text != "") {
						text += " >> ";
					}
					if(item) {
						text += item.name;
					}
					
				}
			});
			var selected = "";
			
			if(selectedId) {
				if(o.id == selectedId) {
					selected = "selected";					
					
				}
				
			} 
			form.find("[name=parentId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+text+"</option>");
		});
		
		form.find("[name=parentId]").select2({
			placeholder: "隶属用户组",
			allowClear: true
		});
		
		form.find("[name=parentId]").change(function() {
			bindingRole($(this).val());
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
			$.confirm("确认删除用户组？", function() {
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
			$.alert("请选择要删除的用户组。");
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
				param["department."+o+""] = val;
			} else {
				param["department."+o+""] = "";
			}
		});
		
		
		
		var roleIds = editForm.find('#role-list [name="roleId"]:checked');
		var cnt = 0;
		$.each(roleIds, function(i, o){			
			param['department.roleIdList[' + i + ']'] = $(o).val();
			
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
					parentId : {
						required : true
					},
					name : {
						required : true
					}
				},

				// Messages for form validation
				messages : {
					parentId : {
						required : '请选择隶属用户组'
					},
					name : {
						required : '请输入用户组名称'
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
		
		editForm.find("#role-list").find(".item").remove();
		
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
				param["departmentQuery."+o+""] = val;
			} else {
				param["departmentQuery."+o+""] = "";
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
		$("[item-id=button-toolbar-add]").click(function() {
			loadEditItem();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的用户组。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个用户组。");
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