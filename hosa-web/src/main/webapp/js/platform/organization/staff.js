$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/organization/staff/staff!list.htm";
	var getUrl = ctx + "/webadmin/organization/staff/staff!input.htm";
	var saveUrl = ctx + "/webadmin/organization/staff/staff!save.htm";
	var deleteUrl = ctx + "/webadmin/organization/staff/staff!delete.htm";
	
	var queryDepartmentUrl = ctx + "/webadmin/organization/staff/staff!loadDepartment.htm";
	var queryRoleUrl = ctx + "/webadmin/organization/staff/staff!loadRole.htm";
	
	var departmentMap = new HashMap();
	var roleArray = new Array();
	var staffMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	
	var columns = [  "id" ,  "name" ,  "departmentId" ,  "gender" ,  "mobile" ,  "loginId" ,  "password" ,  "isAvailable" ,  "headImageUrl" ,  "headImageStoragePath" , "modified"];	
	var searchColumns = [  "nameLike" ,  "departmentId" ,  "gender" ,  "mobileLike" ,  "loginIdLike" ,  "isAvailable"];
	var filterColumns = [  "filter_name" ,  "filter_simpleCode" ,  "filter_departmentId" ,  "filter_gender" ,  "filter_mobile" ,  "filter_loginId" ,  "filter_password" ,  "filter_isAvailable" ,  "filter_headImageUrl" ,  "filter_headImageStoragePath" ,  "filter_lastAccess" ,  "filter_createdAt"];
	
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
					staffMap = new HashMap();
					$.each(data.result, function(i, o){
						staffMap.put(o.id, o);
						
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
		var item = staffMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
			$(o).text(val);
		});
		viewForm.find("img").attr("src", item.headImageUrl);
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
		
		if(data.id > 0) {
			editForm.find("[name=password]").val("");
			editForm.find("[name=confirmPassword]").val("");
			editForm.find("[name=password]").attr("disabled", true);
			editForm.find("[name=confirmPassword]").attr("disabled", true);
			editForm.find("[item-id=account-information]").hide();
			editForm.find("[item-id=account-information-toggle]").show();
			editForm.find("[item-id=account-information-toggle]").find("input").prop("checked", true);
			editForm.find("[item-id=account-information-toggle]").find("input").click(function() {
				if($(this).is(":checked")) {
					editForm.find("[name=password]").val("");
					editForm.find("[name=confirmPassword]").val("");
					editForm.find("[name=password]").attr("disabled", true);
					editForm.find("[name=confirmPassword]").attr("disabled", true);
					editForm.find("[item-id=account-information]").hide();
				} else {
					editForm.find("[item-id=account-information]").show();
					editForm.find("[name=password]").val("");
					editForm.find("[name=confirmPassword]").val("");
					editForm.find("[name=password]").attr("disabled", false);
					editForm.find("[name=confirmPassword]").attr("disabled", false);				
				}
			});
		} else {
			editForm.find("[name=password]").val("");
			editForm.find("[name=confirmPassword]").val("");
			editForm.find("[name=password]").attr("disabled", false);
			editForm.find("[name=confirmPassword]").attr("disabled", false);	
			editForm.find("[item-id=account-information-toggle]").hide();
			editForm.find("[item-id=account-information]").show();
		}
		
		var gender = data.gender;
		var isAvailable = data.isAvailable;
		if(gender == 2) {
			editForm.find("[name=gender]").prop("checked", true);
		} else {
			editForm.find("[name=gender]").prop("checked", false);
		}
		
		if(isAvailable == 0) {
			editForm.find("[name=isAvailable]").prop("checked", true);
		} else {
			editForm.find("[name=isAvailable]").prop("checked", false);
		}
		
		var departmentId = data.departmentId;
		var roleIdList = data.roleIdList;
		loadDepartment(editForm, function(){
			editForm.find("[name=departmentId]").select2("val", departmentId);
			
			loadRole(function() {
				bindingRole(departmentId);
				if(roleIdList) {
					$.each(roleIdList, function(i, o) {
						var roleId = o;
						var checkbox = editForm.find("#role-list").find("input[value="+roleId+"]");
						checkbox.prop("checked", true);
					});
				}
			});
		});
	}
	
	var loadDepartment = function(form, callback) {
		authorityArray = new Array(); 
		
		form.find(".item").remove();
		$.webAjax(queryDepartmentUrl, {}, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$.each(data, function(i, o) {
						var deptId = o.id;
						departmentMap.put(deptId, o);
					});
					

					bindingDepartment(form);
					if($.isFunction(callback)) {
						callback();
					}
				}		
				
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	var bindingDepartment = function(form) {
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
			form.find("[name=departmentId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+text+"</option>");
		});
		form.find("[name=departmentId]").select2({
			placeholder: "隶属用户组",
			allowClear: true
		});
		form.find("[name=departmentId]").change(function() {
			bindingRole($(this).val());
		});
	}
	
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
				}
				
				
				if($.isFunction(callback)) {
					callback();
				}
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	var bindingRole = function(departmentId) {
		
		 var roleList = new Array();
		 if(!departmentId) {
			 return;
		 }
		 var item = departmentMap.get(departmentId);
		 roleList = item.roleList;
		 
		 
		 editForm.find("#role-list").find(".item").remove();
		 
			$.each(roleList, function(i, o) {
				
				var template = editForm.find("#role-list").find("[item-template]");
				var item = template.clone();
				item.removeAttr("item-template");
				item.addClass("item");
				item.find("i").after(o.name);
				item.find("input").val(o.id);
				
				var number = (i+1)%3==0?3:((i+1)%3);
				item.appendTo(editForm.find("#role-list div:nth-child("+(number+1)+")"));
				
				item.show();
			})
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
			$.confirm("确认删除用户？", function() {
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
			$.alert("请选择要删除的用户。");
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
				param["staff."+o+""] = val;
			} else {
				param["staff."+o+""] = "";
			}
		});

		var gender = editForm.find("[name=gender]:checked");
		var isAvailable = editForm.find("[name=isAvailable]:checked");
		if(gender.length > 0) {
			param["staff.gender"] = 2;
		} else {
			param["staff.gender"] = 1;
		}
		if(isAvailable.length > 0) {
			param["staff.isAvailable"] = 0;
		} else {
			param["staff.isAvailable"] = 1;
		}

		var roleIds = editForm.find('#role-list [name="roleId"]:checked');
		var cnt = 0;
		$.each(roleIds, function(i, o){			
			param['staff.roleIdList[' + i + ']'] = $(o).val();
			
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
					},
					departmentId : {
						required : true
					},
					mobile : {
						required : true
					},
					loginId : {
						required : true,
						chrnum: true
					},
					password : {
						required : true
					},
					confirmPassword : {
						required : true,
						equalTo: "#password"
					}
				},

				// Messages for form validation
				messages : {
					name : {
						required : '请输入姓名'
					},
					departmentId : {
						required : '请选择用户组'
					},
					mobile : {
						required : '请输入联系方式'
					},
					loginId : {
						required : '请输入登录名',
						chrnum: '只能输入数字和字母(字符A-Z, a-z, 0-9)'
					},
					password : {
						required : '请输入密码'
					},
					confirmPassword : {
						required : '请再次输入密码',
						equalTo: "两次输入密码不一致"
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
				param["staffQuery."+o+""] = val;
			} else {
				param["staffQuery."+o+""] = "";
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
		searchForm.find("[name=departmentId]").select2("val", "");
		searchForm.find("[name=gender]").select2("val", "");
		searchForm.find("[name=isAvailable]").select2("val", "");
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
			searchForm.find("[name=gender]").select2({
				placeholder: "性别",
				allowClear: true
			});
			searchForm.find("[name=isAvailable]").select2({
				placeholder: "是否有效",
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
				$.alert("请选择要修改的用户。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个用户。");
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
		        		
		        		editForm.find("#headImageUrl").val(data[0]);
		        		editForm.find("#headImageStoragePath").val(data[1]);
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
		    		
		    		editForm.find("#headImageUrl").val("");
		    		editForm.find("#headImageStoragePath").val("");
				});
	    }
	 
	 
	$().ready(function() {
		bindingButtonClick();
		loadList();
		settingUpload();
		loadDepartment(searchForm);
	});
	
	
})