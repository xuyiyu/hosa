$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/system/inboundmenu/inbound-menu!list.htm";
	var getUrl = ctx + "/webadmin/system/inboundmenu/inbound-menu!input.htm";
	var saveUrl = ctx + "/webadmin/system/inboundmenu/inbound-menu!save.htm";
	var deleteUrl = ctx + "/webadmin/system/inboundmenu/inbound-menu!delete.htm";
	
	var queryQueueUrl = ctx +  "/webadmin/system/inboundmenu/inbound-menu!loadQueues.htm";
	var queryMaterialUrl = ctx +  "/webadmin/system/inboundmenu/inbound-menu!loadMaterials.htm";
	var sortUrl = ctx +  "/webadmin/system/inboundmenu/inbound-menu!sortMenu.htm";
	
	var inboundmenuMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable =$("#menu-list");
	
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "name" ,  "level" ,  "expanded" ,  "parentId" ,  "keyword" ,  "type" ,  "clickCount" ,  "materialId" ,  "modified"];	
	var searchColumns = [  "departmentId" ,  "name" ,  "level" ,  "expanded" ,  "parentId" ,  "keyword" ,  "type" ,  "clickCount" ,  "materialId" ,  "modified"];
	var filterColumns = [  "filter_departmentId" ,  "filter_name" ,  "filter_level" ,  "filter_expanded" ,  "filter_parentId" ,  "filter_keyword" ,  "filter_type" ,  "filter_clickCount" ,  "filter_materialId" ,  "filter_modified"];
	
	var currentParentId = 0;
	var listSerialize;
	var listObj;
	
	var menuTypeMap = new HashMap();
	menuTypeMap.put("1", "文本");
	menuTypeMap.put("2", "人工");
	
	menuTypeMap.put("5", "留言");
	menuTypeMap.put("6", "图文");
	
	
	 var menu2materialMatchMap = new HashMap();
	 /* 菜单类型和素材类型匹配 */
	 menu2materialMatchMap.put(1, 1);
	 menu2materialMatchMap.put(2, 0);
	 menu2materialMatchMap.put(5, 1);
	 menu2materialMatchMap.put(6, 6);
	 
	
	/**
	 * 绑定列表参数
	 */
	var bindingListParam = function(o) {
		var param = {};
	
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
					console.log("data:");
					console.log(data);
					inboundmenuMap = new HashMap();
					$.each(data, function(i, o){
						inboundmenuMap.put(o.id, o);
						
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
							//viewItem(li);
						});
						if(o.type ==1 ){
							li.find("[item-id=button-add]").show();
							li.find("[item-id=button-add]").click(function() {//绑定修改操作
								currentParentId = o.id;
								loadEditItem();
							});
							
						}else{
							
							li.find("[item-id=button-add]").hide();
							
						}
						
						
							
						
						
						
						li.find("[item-id=button-modify]").click(function() {//绑定修改操作
							currentParentId = o.parentId;
							loadEditItem(o.id);
						});
						if(o.expanded!=0){
							li.find("[item-id=button-delete]").hide();
						}else{
							li.find("[item-id=button-delete]").show();
							li.find("[item-id=button-delete]").click(function() {//绑定删除操作
								deleteItem(o.id);
							});
						}
						
						
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
					dataTable.nestable({}).on('change', function(e) {//return;
						var list = e.length ? e : $(e.target);						
						sortItem(list.nestable('serialize'));
					});
					console.log("dataTable serialize:");
					console.log(dataTable.nestable('serialize'));
					listObj = dataTable.nestable('serialize');
					listSerialize = window.JSON.stringify(dataTable.nestable('serialize'));
					
				}

			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	
	var sortItem = function(items) {
		var changedListSerialize = window.JSON.stringify(items);
		console.debug(listSerialize);
		console.debug(changedListSerialize);
		
		if(listSerialize == changedListSerialize) {
			return;
		}
		var coord = getFirstCoordinateObject(listObj,items,0,0);
		console.log("first:");
		console.log(coord);
		var findArr = (coord.original==0?items:listObj);
		
		var otherCoord = getSecondCoordinateObject(findArr,coord.id,0,0);
		var originalCoord = otherCoord;
		var newCoord = coord;
		if(coord.original == 0){
			otherCoord.original = 1;
			
			originalCoord = coord;
			newCoord = otherCoord;
		}
	
		console.log(otherCoord);
		var param = {};
		param["originalCoord.id"]=originalCoord.id;
		param["originalCoord.sort"]=originalCoord.sort;
		param["originalCoord.level"]=originalCoord.level;
		param["originalCoord.parentId"]=originalCoord.parentId;
		
		param["newCoord.id"]=newCoord.id;
		param["newCoord.sort"]=newCoord.sort;
		param["newCoord.level"]=newCoord.level;
		param["newCoord.parentId"]=newCoord.parentId;
		
		
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
	
	var getSecondCoordinateObject = function(findArr,id,level,parentId){
		console.log(findArr);
		var coord = null;
		$.each(findArr,function(i,o){
			if(o.id == id){
				coord = new coordinate(id,i,level,0,parentId);
				return false;
			}else if(o.children){
				coord = getSecondCoordinateObject(o.children,id,level+1,o.id);
				if(coord != null){
					return false;
				}
			}
			
			
		});
		
		return coord;
		
	}
	
	
	/* 进行比较的两个数组 
	 * 
	 * return 获取被移动到元素的 原始位置或新位置
	 * */
	var getFirstCoordinateObject = function(arr1,arr2,level,parentId){
		console.log(arr1);
		console.log(arr2);
		var coord = null;
		if(arr1.length > arr2.length){
			coord = getExtraId(arr1,arr2);
			coord.original = 0;
			coord.level = level;
			coord.parentId = parentId;
		}else if(arr1.length < arr2.length){
			coord = getExtraId(arr2,arr1);
			coord.original = 1;
			coord.level = level;
			coord.parentId = parentId;
		}else{
			$.each(arr1,function(i,o){
				if(o.id == arr2[i].id){
					
						if(o.children&&arr2[i].children){//都有子节点
							coord = getFirstCoordinateObject(o.children,arr2[i].children,level+1,o.id);
							if(coord!=null){
								return false;
							}
						}else if(o.children){
							coord = new coordinate(o.children[0].id,0,level+1,0,parentId);
						}else if(arr2[i].children){
							coord = new coordinate(arr2.children[0].id,0,level+1,1,parentId);
						}
					
					
				}else{//如果id不相等，则必然arr1的该对象在arr2处于不同位置
					coord = new coordinate(o.id,i);
					coord.original = 0 ;
					coord.level = level;
					coord.parentId = parentId; 
				}
			});
			
			
		}
		
		
	
		return coord;
	}
	
	
	
	var getExtraId = function(maxArr,minArr){
		var coord = null;
		$.each(maxArr,function(i,o){
			var exist = 0;
			$.each(minArr,function(m,n){
				if(o.id == n.id){
					exist = 1;
					return false;
				}
			});
			if(exist == 0){
				coord =  new coordinate(o.id,i);
			}
		});
		return coord;
	}
	
	/*元素坐标对象
	 * id 元素id
	 * sort 元素在本列中排名(以0开始计算)
	 * level 元素在第几层分支
	 * original 0，代表始位置      1，代表新位置
	 * */
	var coordinate = function(id,sort,level,original,parentId ){
		this.id = id ;
		this.sort = sort ;
		
		this.level = level ;
		this.original = original;
		this.parentId = parentId ;
	}
	
	
	
	
	var viewItem = function(li) {	
		var itemId = li.attr("data-id");
		var param = {};
		var item = inboundmenuMap.get(itemId);
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
		
		editForm.find("[name=type] .item").remove();
		
		$.each(menuTypeMap.keys(), function(i, o){
			
			var menuType = menuTypeMap.get(o);
			editForm.find("[name=type]").append("<option value='"+o+"'  class='item'>"+menuType+"</option>");
		});
		
		console.debug("type:"+data.type);
		editForm.find("[name=type]").select2({
			placeholder: "菜单类型",
			allowClear: true
		});
		
		
		var materialId = data.materialId;
		loadMaterial(editForm, function() {
			console.log("materialId:"+materialId);
			editForm.find("[name=materialId]").select2("val", materialId);
		});
		
		
		editForm.find("[name=type]").select2("val",data.type).trigger("change");
	}
	
	var loadMaterial = function(form, callback) {
		
		
		
		
		form.find("[name=type]").change(function(){
			
			var type = form.find("[name=type]").select2("val");
			materialType = menu2materialMatchMap.get(type);
			
			if(materialType == 0){
				//form.find(".material_section").hide();
				if(type==2){
					$.webAjax(queryQueueUrl, {}, function(responseData) {
						
						if(responseData.r_code == 0) {
							var data = responseData.r_data;
							if(data) {
								
								bindingQueue(form,data);
								if($.isFunction(callback)) {
									callback();
								}
							}		
						}else {
							$.errorNotification(responseData.r_info);
						}
					});
				}
				
				
				
			}else{
				//form.find(".material_section").show();
				$.webAjax(queryMaterialUrl, {"type":materialType}, function(responseData) {
					
					if(responseData.r_code == 0) {
						var data = responseData.r_data;
						if(data) {
							
							bindingMaterial(form,data);
							if($.isFunction(callback)) {
								callback();
							}
						}		
					}else {
						$.errorNotification(responseData.r_info);
					}
				});
			}
			
		});
		form.find("[name=keyword]").select2({
			placeholder: "菜单编号",
			allowClear: true
		});
	}
	
	
	

	var bindingMaterial = function(form,data) {
		form.find("[name=materialId] .item").remove();
		
		
		$.each(data, function(i, o) {
			
			var text = o.name;
			var selected = "";
			$("<option value='"+o.id+"' "+selected+" class='item' type='"+o.type+"'>"+text+"</option>").appendTo(form.find("[name=materialId] "));
			
		});
		form.find("[name=materialId]").select2({
			placeholder: "菜单内容",
			allowClear: true
		});
		
	}
	
	
	var bindingQueue = function(form,data) {
		form.find("[name=materialId] .item").remove();
		
		
		$.each(data, function(i, o) {
			
			var text = o.name;
			var selected = "";
			$("<option value='"+o.id+"' "+selected+" class='item' type='"+o.type+"'>"+text+"</option>").appendTo(form.find("[name=materialId] "));
			
		});
		form.find("[name=materialId]").select2({
			placeholder: "选择群组",
			allowClear: true
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
				param["inboundMenu."+o+""] = val;
			} else {
				param["inboundMenu."+o+""] = "";
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
					name : {
						required : true
					},
					type : {
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
					type : {
						required : '请选择菜单类型'
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
		
		editForm.find("[name=materialId]").select("val","");
		
		editForm.find("[name=type]").off("change");
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