$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/user/user/user!list.htm";
	var getUrl = ctx + "/webadmin/user/user/user!input.htm";
	var saveUrl = ctx + "/webadmin/user/user/user!save.htm";
	var deleteUrl = ctx + "/webadmin/user/user/user!delete.htm";
	
	var userMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "name" ,  "gender" ,  "email" ,  "mobile" ,  "educationalBackground" ,  "educationalBackgroundId" ,  "birthday" ,  "areaId" ,  "loginId" ,  "password" ,  "headImageUrl" ,  "headImageStoragePath" ,  "videoUrl" ,  "status" ,  "lastAccess" ,  "createdAt" ,  "modified", "source"];	
	var searchColumns = [  "departmentId" ,  "name" ,  "gender" ,  "email" ,  "mobile" ,  "educationalBackground" ,  "educationalBackgroundId" ,  "birthday" ,  "areaId" ,  "loginId" ,  "password" ,  "headImageUrl" ,  "headImageStoragePath" ,  "videoUrl" ,  "status" ,  "lastAccess" ,  "createdAt" ,  "modified", "source"];
	var filterColumns = [  "filter_departmentId" ,  "filter_name" ,  "filter_gender" ,  "filter_email" ,  "filter_mobile" ,  "filter_educationalBackground" ,  "filter_educationalBackgroundId" ,  "filter_birthday" ,  "filter_areaId" ,  "filter_loginId" ,  "filter_password" ,  "filter_headImageUrl" ,  "filter_headImageStoragePath" ,  "filter_videoUrl" ,  "filter_status" ,  "filter_lastAccess" ,  "filter_createdAt" ,  "filter_modified", "filter_source"];
	
	
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
					userMap = new HashMap();
					$.each(data.result, function(i, o){
						userMap.put(o.id, o);
						
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
								if(id=="mobile"){
									
									var mobileReg = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
									 var telReg = /^\d{3,4}-?\d{7,9}$/; 
									 if(!(telReg.test(itemVal)||mobileReg.test(itemVal))){
										 itemVal="";
									 }
									 
									
								}
								
								
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
		var dept = userMap.get(itemId);
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
		editForm.find("[name=birthday]").val(data["birthdayString"]);
		
		if(editForm.find("[name=source]").val() == "") {
			editForm.find("[name=source]").val("线下注册");
		}
		
		var gender = data.gender;
		var status = data.status;
		
		if(gender == 1 || gender == null) {
			editForm.find("[name=gender]").prop("checked", true);
		} else {
			editForm.find("[name=gender]").prop("checked", false);
		}
		
		if(status == 1 || status == null) {
			editForm.find("[name=status]").prop("checked", true);
		} else {
			editForm.find("[name=status]").prop("checked", false);
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
			$.confirm("确认删除用户表？", function() {
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
			$.alert("请选择要删除的用户表。");
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
				param["user."+o+""] = val;
			} else {
				param["user."+o+""] = "";
			}
		});

		var gender = editForm.find("[name=gender]:checked");
		var status = editForm.find("[name=status]:checked");
		if(gender.length > 0) {
			param["user.gender"] = 1;
		} else {
			param["user.gender"] = 2;
		}
		if(status.length > 0) {
			param["user.status"] = 1;
		} else {
			param["user.status"] = 0;
		}
		
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
					name : {
						required : true
					},
					email : {
						required : true,
						email: true
					},
					mobile : {
						required : true,
						isPhone: true
					},
					birthday : {
						required : true
					},
					areaId : {
						required : true
					},
					loginId : {
						required : true
					},
					password : {
						required : true
					},
					headImageUrl : {
						required : true
					},
					headImageStoragePath : {
						required : true
					},
					videoUrl : {
						required : true
					},
					lastAccess : {
						required : true
					},
					createdAt : {
						required : true
					},
					modified : {
						required : true
					},
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入编号'
					},
					name : {
						required : '请输入姓名'
					},
					email : {
						required : '请输入邮箱',
						email: '请输入有效的邮箱'
					},
					mobile : {
						required : '请输入联系方式',
						isPhone: '请输入有效的联系方式'
					},
					birthday : {
						required : '请输入出生日期'
					},
					areaId : {
						required : '请输入所在地区'
					},
					loginId : {
						required : '请输入登录名'
					},
					password : {
						required : '请输入登录密码'
					},
					headImageUrl : {
						required : '请输入头像'
					},
					headImageStoragePath : {
						required : '请输入头像存储地址'
					},
					videoUrl : {
						required : '请输入videoUrl'
					},
					lastAccess : {
						required : '请输入最后登录时间'
					},
					createdAt : {
						required : '请输入创建时间'
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
				param["userQuery."+o+""] = val;
			} else {
				param["userQuery."+o+""] = "";
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
				$.alert("请选择要修改的用户表。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个用户表。");
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