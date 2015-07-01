$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!list.htm";
	var getUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!input.htm";
	var saveUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!save.htm";
	var deleteUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!delete.htm";
	var queryStaffUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!unbindStaff.htm";
	
	var weixinUsersUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!getWeixinUsers.htm";
	
	var queryDepartmentUrl = ctx + "/webadmin/weixin/staff/staff-weixin-info!loadDepartment.htm";
	
	var departmentMap = new HashMap();
	var roleArray = new Array();
	var staffMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	
	var columns = [  "id" ,  "staffId" ,  "openId" ,  "departmentId" ,  "wxNickName" ,  "wxHeadImg" ,  "modified" ];	
	var searchColumns = [  "staffNameLike" ,  "departmentId" , "wxNickNameLike"];
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
								if(itemVal == ""){
									itemVal == "未绑定";
								}
								$(n).attr("title", itemVal);
								$(n).text(itemVal);
							}catch(e){								
							}
							
						});
						
//						tr.find("[item-view]").click(function() {
//							viewItem(tr);
//						});
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
		}else{
			bindingEditItem();
			$("#editModal").modal({backdrop: "static"});
		}
		
		
	
	}
	
	
	/**
	 * 绑定编辑项
	 */
	var bindingEditItem = function(data) {
		cleanEditItem();
		
		if(data) {
			$.each(columns, function(i, o) {
				editForm.find("[name="+o+"]").val(data[o]);
			});
			var departmentId = data.departmentId;
			var staffId = data.staffId;
			
			loadDepartment(editForm,
				function(){
				
					editForm.find("[name=departmentId]").select2("val", departmentId).trigger("change");
					editForm.find("[name=wxNickName]").select2("data",
							{"openId":data.openId,"nickName":data.wxNickName}
					);
				},staffId);
		} else {
			console.log("no data");
			editForm.find("[name=departmentId]").val("");
			editForm.find("[name=staffId]").val("");
			loadDepartment(editForm);
		}
	
		
		
		
		
	}
	
	
	
	/*
	 * form 表单
	 * callback_departments 加载完department后的回调函数
	 * callback_staffs  加载完staff后的回调函数
	 * 
	 */
	var loadDepartment = function(form, callback_departments,staffId) {
		console.log("1222 : "+staffId);
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
					console.log("122233 : "+staffId);
					bindingDepartment(form,staffId);
					if($.isFunction(callback_departments)) {
						callback_departments();
					}
				}		
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	var bindingDepartment = function(form,staffId) {
		
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
		
		/* 当select选择时，触发事件，即加载部门下的用户*/
		form.find("[name=departmentId]").on("change", function() {
			//editForm.find("[name=departmentId]").select2("val");//
			
			var departmentId = editForm.find("[name=departmentId]").select2("val");
			console.log("departmentId:"+departmentId);
			
			console.log("staffId12:"+staffId);
			
			$.webAjax(queryStaffUrl, {"departmentId":departmentId,"staffId":staffId}, function(responseData) {
				
				if(responseData.r_code == 0) {
					var data = responseData.r_data;
				
					if(data) {
						var staff = editForm.find("[name=staffId]");
						staff.find(".item").remove();
						$.each(data,function(i,o){
							$("<option value='"+o.id+"'  class='item'>"+o.loginId+"</option>").appendTo(staff);
						});
						
						$("#editModal").modal({backdrop: "static"});
					}
					
					if(staffId) {
						editForm.find("[name=staffId]").select2("val", staffId);
					}
					
				}else {
					$.errorNotification(responseData.r_info);
				}
			});
		});
		
		var staffselection = form.find("[name=staffId]");
		if(staffselection){
			form.find("[name=staffId]").select2({
				placeholder: "选择座席",
				allowClear: true
			});
		}
		
		
		var wxNickNameselection = form.find("[name=wxNickName]");
		if(wxNickNameselection){
			form.find("[name=wxNickName]").select2({
				id:function(obj){
					console.log("get openid..");
					return obj.openId;
				},
				placeholder: "微信昵称",
			    minimumInputLength: 1,
			    ajax: {
			        url: weixinUsersUrl,
			        dataType: 'json',
			        quietMillis: 1000,
			        type: "POST",
			        data: function (term, page) { // page is the one-based page number tracked by Select2
			        	console.log("term"+term);
			        	console.log("page"+page);
			            return {
			            	"weixinUserName": term, //search term
			            };
			        },
			        results: function (data) {
			            return {results: data.r_data};
			        }
			    },
			    formatResult: movieFormatResult, // omitted for brevity, see the source of this page
			    formatSelection: movieFormatSelection, // omitted for brevity, see the source of this page
			    dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
			    escapeMarkup: function (m) { return m; } 
				
			}).on("change", function(e) {
				
				form.find("[name=openId]").val(e.val);
			});
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	


    function movieFormatResult(movie) {
        var markup = "<table><tr><td>"+"<img src='" + movie.headImgUrl+ "' style='width:50px;'/>"+"</td><td>"+movie.nickName+"</td></table>";

        return markup;
    }

    function movieFormatSelection(movie) {
    	console.log("show text ..");
        return movie.nickName;
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
				param["staffWeixinInfo."+o+""] = val;
			} else {
				param["staffWeixinInfo."+o+""] = "";
			}
			if(o == "wxNickName"){
				
				param["staffWeixinInfo."+o+""] = editForm.find("[name="+o+"]").select2("data").nickName;
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
					departmentId : {
						required : true
					},
					staffId : {
						required : true
					},
					wxNickName : {
						required : true
					},
					openId :{
						required : true
					}
				},

				// Messages for form validation
				messages : {
				
					departmentId : {
						required : '请选择用户组'
					},
					staffId : {
						required : '请选择用户'
					},
					wxNickName : {
						required : '请填写微信昵称'
					},
					openId : {
						required : '请重现输入微信昵称'
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
		
		
		editForm.find("[name=departmentId]").off("change");
		editForm.find("[name=staffId]").off("change");
		editForm.find("[name=wxNickName]").off("change");
		
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
				param["staffWeixinInfoQuery."+o+""] = val;
			} else {
				param["staffWeixinInfoQuery."+o+""] = "";
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
			loadDepartment(searchForm);
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
	
	 
	 
	
	 
	 
	$().ready(function() {
		bindingButtonClick();
		loadList();
		
		
		
		
		
		
		
	});
	
	
})