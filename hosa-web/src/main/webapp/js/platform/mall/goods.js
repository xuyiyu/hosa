$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/mall/goods/goods!list.htm";
	var getUrl = ctx + "/webadmin/mall/goods/goods!input.htm";
	var saveUrl = ctx + "/webadmin/mall/goods/goods!save.htm";
	var deleteUrl = ctx + "/webadmin/mall/goods/goods!delete.htm";
	
	var categoryUrl = ctx + "/webadmin/mall/goods/goods!loadCategory.htm";
	
	var goodsMap = new HashMap();
	
	var categoryMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "categoryId" ,  "code" ,  "departmentId" ,  "picUrl" ,  "picStoragePath" ,  "name" ,  "specifications" ,  "price" ,  "discount" ,  "onTime" ,  "offTime" ,  "number" ,  "remainingNumber" ,  "status" ,  "introduction" ,  "createdAt" ,  "modified"];	
	var searchColumns = [  "categoryId" ,  "code" ,  "departmentId" ,  "picUrl" ,  "picStoragePath" ,  "nameLike" ,  "specifications" ,  "price" ,  "discount" ,  "onTime" ,  "offTime" ,  "number" ,  "remainingNumber" ,  "status" ,  "introduction" ,  "createdAt" ,  "modified"];
	var filterColumns = [  "filter_categoryId" ,  "filter_code" ,  "filter_departmentId" ,  "filter_picUrl" ,  "filter_picStoragePath" ,  "filter_name" ,  "filter_specifications" ,  "filter_price" ,  "filter_discount" ,  "filter_onTime" ,  "filter_offTime" ,  "filter_number" ,  "filter_remainingNumber" ,  "filter_status" ,  "filter_introduction" ,  "filter_createdAt" ,  "filter_modified"];
	
	
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
					goodsMap = new HashMap();
					$.each(data.result, function(i, o){
						goodsMap.put(o.id, o);
						
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
		var dept = goodsMap.get(itemId);
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
					
					loadCategory(data.categoryId);
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	
	}
	
	var loadCategory = function(categoryId) {
		var param = {};
		$.webAjax(categoryUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					$("[name=categoryId]").empty();
					$("[name=categoryId]").append("<option></option>");
					$.each(data, function(i, o) {
						var selected = "";
						if(categoryId == o.id) {
							selected = "selected";
						}
						$("[name=categoryId]").append("<option value=\""+o.id+"\" "+selected+">"+o.name+"</option>");
					});
					
					$("[name=categoryId]").select2({
						placeholder: "选择商品类型",
						allowClear: true
					});
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
	
		if(data["picUrl"]) {
			editForm.find("[item-id=preview] a").attr("href", data["picUrl"]);
			editForm.find("[item-id=preview] img").attr("src", data["picUrl"]);
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
			$.confirm("确认删除商品？", function() {
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
			$.alert("请选择要删除的商品。");
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
				param["goods."+o+""] = val;
			} else {
				param["goods."+o+""] = "";
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
					categoryId : {
						required : true
					},
					code : {
						required : true
					},
					departmentId : {
						required : true
					},
					name : {
						required : true
					},
					price : {
						required : true,
						number: true,
						min: 0
					},
					discount : {
						required : true,
						number: true,
						range: [0,1]
					},
					number : {
						required : true,
						number: true,
						min: 0
					},
					remainingNumber : {
						required : true
					},
					status : {
						required : true
					},
					introduction : {
						required : true
					}
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入编号'
					},
					categoryId : {
						required : '请输入分类编号'
					},
					code : {
						required : '请输入商品编码'
					},
					departmentId : {
						required : '请输入隶属部门'
					},
					name : {
						required : '请输入名称'
					},
					price : {
						required : '请输入价格',
						number: "请输入数字",
						min: "请输入大于 {0} 的数"
					},
					discount : {
						required : '请输入折扣',
						number: "请输入数字",
						range: "请输入 {0} 至 {1} 之间的数值"
					},
					number : {
						required : '请输入数量',
						number: "请输入数字",
						min: "请输入大于 {0} 的数"
					},
					remainingNumber : {
						required : '请输入剩余数量'
					},
					status : {
						required : '请选择状态'
					},
					introduction : {
						required : '请输入介绍'
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
		
		if(editFormValidator) {
			editForm.find(".state-error").removeClass("state-error");
			editForm.find(".state-error").removeClass("state-success");
			editFormValidator.resetForm();  
		}
		$("[item-id=preview]").find("button").trigger("click");
		searchForm.find("[name=categoryId]").select2("val", "");
		searchForm.find("[name=status]").select2("val", "");
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
				param["goodsQuery."+o+""] = val;
			} else {
				param["goodsQuery."+o+""] = "";
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
			loadCategory();
			$("#searchModal").modal();
		});
		$("[item-id=button-toolbar-add]").click(function() {
			loadEditItem();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的商品。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个商品。");
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
	        		
	        		editForm.find("#picUrl").val(data[0]);
	        		editForm.find("#picStoragePath").val(data[1]);
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
	    		
	    		editForm.find("#picUrl").val("");
	    		editForm.find("#picStoragePath").val("");
			});
    }
	$().ready(function() {
		bindingButtonClick();
		loadList();
		settingUpload();
		$("[name=status]").select2({
			placeholder: "选择商品状态",
			allowClear: true
		});
	});
	
	
})