$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/weixin/menu/weixin-menu!list.htm";
	var getUrl = ctx + "/webadmin/weixin/menu/weixin-menu!input.htm";
	var saveUrl = ctx + "/webadmin/weixin/menu/weixin-menu!save.htm";
	var deleteUrl = ctx + "/webadmin/weixin/menu/weixin-menu!delete.htm";
	
	var queryMaterialUrl = ctx + "/webadmin/weixin/menu/weixin-menu!loadMaterial.htm";
	var sortUrl = ctx + "/webadmin/weixin/menu/weixin-menu!sort.htm";
	var syncUrl = ctx + "/webadmin/weixin/menu/weixin-menu!sync.htm";
	
	var weixinMenuMap = new HashMap();
	var materialArray = new Array(); 
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#menu-list");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "name" ,  "type" ,  "level" ,  "parentId" ,  "sort" ,  "materialId" ,  "authorize" ,  "modified"];	
	var searchColumns = [  "departmentId" ,  "name" ,  "type" ,  "level" ,  "parentId" ,  "sort" ,  "materialId" ,  "authorize" ,  "modified"];
	var filterColumns = [  "filter_departmentId" ,  "filter_name" ,  "filter_type" ,  "filter_level" ,  "filter_parentId" ,  "filter_sort" ,  "filter_materialId" ,  "filter_authorize" ,  "filter_modified"];
	
	var materialMap = new HashMap();
	materialMap.put("1", "文本");
	materialMap.put("2", "图片");
	materialMap.put("3", "语音");
	materialMap.put("4", "视频");
	materialMap.put("6", "图文");
	materialMap.put("7", "链接");
	
	var currentParentId = 0;
	var listSerialize;
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
					weixinMenuMap = new HashMap();
					$.each(data, function(i, o){
						weixinMenuMap.put(o.id, o);
						
						var template = dataTable.find("li[item-template]");
						var li = template.clone();
						li.removeAttr("item-template");
						li.addClass("item");
						if(o.id == lastModifiedId) {
							li.addClass("last-modified");
						}
						li.attr("data-id", o.id);
						li.attr("data-modified", o.modified);
						li.find("[item-view]").text(o.name);
						li.find("[item-view]").click(function() {
							viewItem(li);
						});
						if(o.parentId == 0) {
							li.find("[item-id=button-add]").click(function() {//绑定修改操作
								currentParentId = o.id;
								loadEditItem();
							});
						} else {
							li.find("[item-id=button-add]").hide();
						}
						
						li.find("[item-id=button-modify]").click(function() {//绑定修改操作
							currentParentId = o.parentId;
							loadEditItem(o.id);
						});
						li.find("[item-id=button-delete]").click(function() {//绑定删除操作
							deleteItem(o.id);
						});
						if(o.parentId == 0) {
							li.appendTo(dataTable.find(".list"));
						} else {
							var parentLi = dataTable.find("li[data-id='"+o.parentId+"']");
							var ol;
							if(parentLi.find("ol").length == 0) {
								ol = $("<ol class='dd-list'></ol>");
								ol.appendTo(parentLi);
							} else {
								ol = parentLi.find("ol");
							}
							li.appendTo(ol);
						}
										
						li.show();
					});
					
					
					if(data.length == 0) {
						
					
						
					}
					dataTable.nestable("destroy");
					dataTable.off('change');
					dataTable.nestable({maxDepth:2}).on('change', function(e) {//return;
						var list = e.length ? e : $(e.target);						
						sortItem(list.nestable('serialize'));
					});
					listSerialize = window.JSON.stringify(dataTable.nestable('serialize'));
					
				}

			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	var sortItem = function(items) {
		var changedListSerialize = window.JSON.stringify(items);
		if(listSerialize == changedListSerialize) {
			return;
		}
		var param = {};
		var cnt = 0;
		var sort = 1;
		$.each(items, function(i, o) {
			param["menuList["+cnt+"].id"] = o.id;
			param["menuList["+cnt+"].modified"] = o.modified;
			param["menuList["+cnt+"].sort"] = sort++;
			param["menuList["+cnt+"].parentId"] = 0;
			param["menuList["+cnt+"].level"] = 1;
			if(sort > 4) {
				loadList(globalParam);
				$.errorNotification("一级菜单最大数量3");
				return;
			}
			cnt++;
			var subSort = 1;
			if(o.children && o.children.length > 0) {
				if(o.children.length > 5) {
					loadList(globalParam);
					$.errorNotification("子菜单最大数量5");
					return;
				}
				$.each(o.children, function(m, n) {
					param["menuList["+cnt+"].id"] = n.id;
					param["menuList["+cnt+"].modified"] = n.modified;
					param["menuList["+cnt+"].sort"] = subSort++;
					param["menuList["+cnt+"].parentId"] = o.id;
					param["menuList["+cnt+"].level"] = 2;
					cnt++;
				});
			}
		});
		
		$.webAjax(sortUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					$.successNotification(responseData.r_info);
					loadList(globalParam);
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}

	var viewItem = function(li) {	
		var itemId = li.attr("data-id");
		var param = {};
		var item = weixinMenuMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
			$(o).text(val);
		});
		
		/*if(li.prev("li:visible").length > 0) {
			$("[item-id=button-view-previous]").removeClass("disabled");
			$("[item-id=button-view-previous]").click(function() {
				viewItem(li.prev("li:visible"));
			});
		} else {
			$("[item-id=button-view-previous]").addClass("disabled");
		}
		if(li.next("li:visible").length > 0) {
			$("[item-id=button-view-next]").removeClass("disabled");
			$("[item-id=button-view-next]").click(function() {
				viewItem(li.next("li:visible"));
			});
		} else {
			$("[item-id=button-view-next]").addClass("disabled");
		}*/
		
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
		
		editForm.find("[name=parentId]").val(currentParentId);
		var authorize = data.authorize;
		if(authorize == 1) {
			editForm.find("[name=authorize]").prop("checked", true);
		} else {
			editForm.find("[name=authorize]").prop("checked", false);
		}
		var materialId = data.materialId;
		loadMaterial(editForm, function() {
			editForm.find("[name=materialId]").select2("val", materialId);
			var type =editForm.find("[name=materialId]").find("option:selected").attr("type");
			if(type == 7) {
				editForm.find("[item-id=authorize]").show();
			} else {
				editForm.find("[item-id=authorize]").hide();
			}
		});
	}
	
	var loadMaterial = function(form, callback) {
		materialArray = new Array(); 
		
		$.webAjax(queryMaterialUrl, {}, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$.each(data, function(i, o) {
						//var authorityId = o.id;
						materialArray[materialArray.length] = o;
						
					});
					bindingMaterial(form);
					if($.isFunction(callback)) {
						callback();
					}
				}		
				
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}

	var bindingMaterial = function(form) {
		form.find("[name=materialId] .item").remove();
		$.each(materialMap.keys(), function(i, o){
			var materialText = materialMap.get(o);
			$("<optgroup></optgroup>").attr("id", o).attr("label", materialText).addClass("item").appendTo(form.find("[name=materialId]"));
		});
		
		$.each(materialArray, function(i, o) {
			
			var text = o.name;
			var selected = "";
			$("<option value='"+o.id+"' "+selected+" class='item' type='"+o.type+"'>"+text+"</option>").appendTo(form.find("[name=materialId] #" + o.type));
			
		});
		form.find("[name=materialId]").select2({
			placeholder: "菜单内容",
			allowClear: true
		});
		form.find("[name=materialId]").change(function() {
			var type = $(this).find("option:selected").attr("type");
			console.debug(type);
			if(type == 7) {
				form.find("[item-id=authorize]").show();
			} else {
				form.find("[item-id=authorize]").hide();
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
			$.confirm("确认删除微信菜单？", function() {
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
			$.alert("请选择要删除的微信菜单。");
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
				param["weixinMenu."+o+""] = val;
			} else {
				param["weixinMenu."+o+""] = "";
			}
		});

		var type = editForm.find("[name=materialId] option:selected").attr("type");
		param["weixinMenu.type"] = (type==7?2:1);
		
		var authorize = editForm.find("[name=authorize]:checked");
		if(authorize.length > 0) {
			param["weixinMenu.authorize"] = 1;
		} else {
			param["weixinMenu.authorize"] = 0;
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
					parentId : {
						required : true
					},
					materialId : {
						required : true
					}
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入id'
					},
					name : {
						required : '请输入菜单名称'
					},
					parentId : {
						required : '请输入上级菜单'
					},
					materialId : {
						required : '请输入菜单内容'
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
		
		editForm.find("[name=authorize]").prop("checked", false);
		editForm.find("[item-id=authorize]").hide();
		
		if(editFormValidator) {
			editForm.find(".state-error").removeClass("state-error");
			editForm.find(".state-error").removeClass("state-success");
			editFormValidator.resetForm();  
		}
	}
	
	var syncItem = function() {
		var param = {};
		$.webAjax(syncUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				$.successNotification(responseData.r_info);
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
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

		$("[item-id=button-toolbar-add]").click(function() {
			currentParentId = 0;
			loadEditItem();
		});
		$("[item-id=button-toolbar-sync]").click(function() {
			syncItem();
		});
	}
	
	$().ready(function() {
		bindingButtonClick();
		loadList();
		
		
		
	});
	
	
})