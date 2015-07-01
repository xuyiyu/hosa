$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/websetting/model/model-item!list.htm";
	var getUrl = ctx + "/webadmin/websetting/model/model-item!input.htm";
	var saveUrl = ctx + "/webadmin/websetting/model/model-item!save.htm";
	var deleteUrl = ctx + "/webadmin/websetting/model/model-item!delete.htm";
	
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	
	var columns = [  "id" ,  "departmentId" ,  "parentId" ,  "modelId" ,"menuType" ,  "name" ,  "title" ,  "summary" ,  "content" ,  "bgUrl" ,  "bgLink" ,  "picUrl","schemeId" ,  "nextLink" ,  "location" ,  "level" ,  "sort" ,  "modified"];	
	var searchColumns = [  "departmentId" ,  "parentId" ,  "modelId" ,"menuType" ,   "name" ,  "titleLike" ,  "summary" ,  "content" ,  "bgUrl" ,  "bgLink" ,  "picUrl" , "schemeId", "nextLink" ,  "location" ,  "level" ,  "sort" ,  "modified"];
	var filterColumns = [  "filter_departmentId" ,  "filter_parentId" ,  "filter_modelId" ,  "filter_name" ,  "filter_title" ,  "filter_summary" ,  "filter_content" ,  "filter_bgUrl" ,  "filter_bgLink" ,  "filter_picUrl" ,  "filter_nextLink" ,  "filter_location" ,  "filter_level" ,  "filter_sort" ,  "filter_modified"];
	
	var lastModifiedId = 0;
	var articleMap;
	//var categoryMap = new HashMap();
	var parentMap = new HashMap();
	var schemeMap = new HashMap();
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
		param['modelItemQuery.menuType'] = '3';
		return param;
	};

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
					articleMap = new HashMap();
					$.each(data.result, function(i, o){
						articleMap.put(o.id, o);
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
						
						var item = parentMap.get(o.parentId);
						var val = getTableJSONVal(item, 'name');
						tr.find("[item-id=parentId]").text(val);
						
						tr.find("[item-view]").click(function() {
							viewItem(tr);
						});
						tr.find("[item-id=button-modify]").click(function() {//绑定修改操作
							loadEditItem(o.id);
						});
						tr.find("[item-id=button-delete]").click(function() {//绑定删除操作
							deleteItem(o.id);
						});
						tr.find("[item-id=button-view]").click(function() {//绑定预览操作
							iphoneViewItem(o.id);
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
	};
	
	
	
	
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
		var item = articleMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
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
					loadParent(editForm,data.parentId);
					loadScheme(editForm,data.schemeId);
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
		if(data.content){
			editForm.find(".summernote").code(data.content);
		}
		if(data.bgUrl){
			editForm.find("[item-id=preview] a").attr("href", data.bgUrl);
			editForm.find("[item-id=preview] img").attr("src", data.bgUrl);
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
			$.confirm("确认删除文章？", function() {
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
			$.alert("请选择要删除的文章。");
		}
	}
	
	
	
	/**
	 * 预览项
	 */
	var iphoneViewItem = function(itemId) {
		var param = {};
		if(itemId) {
			param["id"] = itemId;
		}
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				
				if(data) {
					var param = 'title='+data.title+"&content="+data.content+"&picUrl="+data.picUrl+"&createDate="+data.createDateString+"&picLink="+data.picLink;
					var viewurl = $('#lightviewContent').attr('src')+"?"+encodeURIComponent(param);
					$('#lightviewContent').attr('src',viewurl);
					$("#iphoneViewModal").modal({backdrop: "static"});
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
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
				param["modelItem."+o+""] = val;
			} else {
				param["modelItem."+o+""] = "";
			}
		});
		
		param["modelItem.content"] = editForm.find(".summernote").code();
		param["modelItem.menuType"] = "3";
		return param;
	}
	
	/**
	 * 校验保存的属性
	 */
	var verifySaveParam = function() {
		editFormValidator = editForm.validate({
				onsubmit:false ,
				rules : {
					title : {
						required : true
					}
				},

				// Messages for form validation
				messages : {
					title : {
						required : '请输入文章标题'
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
		editForm.find("[item-id=preview] a").attr("href", ctx + "/img/user.png");
		editForm.find("[item-id=preview] img").attr("src", ctx + "/img/user.png");
		editForm.find(".summernote").code('');
		editForm.find("#bgUrl").val("");		
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
				param["modelItemQuery."+o+""] = val;
			} else {
				param["modelItemQuery."+o+""] = "";
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
				$.alert("请选择要修改的文章。");
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
		    		
		    		editForm.find("#bgUrl").val("");
				});
	    };

	
		/**
		 * 查询分类列表
		 */
		var loadParentList = function(p) {	
			var url = ctx + "/webadmin/common/queryModelItemList.htm";
			var param = {};
			param['modelItemQuery.menuTypeLE'] = '2';
			//param['modelItemQuery.schemeId'] = id;
			$.webAjax(url, param, function(responseData) {
				
				if(responseData.r_code == 0) {
					var data = responseData.r_data;
					if(data) {
						parentMap = new HashMap();
						$.each(data, function(i, o){
							parentMap.put(o.id, o);
						});
				}else {
					$.errorNotification(responseData.r_info);
				}
			}
			});
		};
		
		/**
		 * 加载分类名称
		 */
		var loadParent= function(form, selectedId) {
			form.find("[name=parentId]").children(".item").remove();
			if(selectedId != null) {
				form.find("[name=parentId]").parent().addClass("state-disabled");
				form.find("[name=parentId]").attr("disabled", false);
			} else {
				form.find("[name=parentId]").parent().removeClass("state-disabled");
				form.find("[name=parentId]").attr("disabled", false);
			}
			
			$.each(parentMap.values(), function(i, o) {
				var selected = "";
				if(selectedId) {
					if(o.id == selectedId) {
						selected = "selected";					
					}
				} 
				form.find("[name=parentId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+o.title+"</option>");
			});
			
			form.find("[name=parentId]").select2({
				placeholder: "父分类名称",
				allowClear: true
			});
			
		};
		
		var loadSchemeList = function(p) {	
			var url = ctx + "/webadmin/common/querySchemeList.htm";
			$.webAjax(url, null, function(responseData) {
				
				if(responseData.r_code == 0) {
					var data = responseData.r_data;
					if(data) {
						schemeMap = new HashMap();
						
						$.each(data, function(i, o){
							schemeMap.put(o.id, o);
						});
				}else {
					$.errorNotification(responseData.r_info);
				}
			}
			});
		};
		
		/**
		 * 加载方案名称
		 */
		var loadScheme= function(form, selectedId) {
			form.find("[name=schemeId]").children(".item").remove();
			if(selectedId != null) {
				form.find("[name=schemeId]").parent().addClass("state-disabled");
				form.find("[name=schemeId]").attr("disabled", true);
			} else {
				form.find("[name=schemeId]").parent().removeClass("state-disabled");
				form.find("[name=schemeId]").attr("disabled", false);
			}
			$.each(schemeMap.values(), function(i, o) {
				var selected = "";
				if(selectedId) {
					if(o.id == selectedId) {
						selected = "selected";					
					}
				} 
				form.find("[name=schemeId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+o.name+"</option>");
			});
			
			form.find("[name=schemeId]").select2({
				placeholder: "方案名称",
				allowClear: true
			});
			
		};
	
	 var settingUpload = function() {
	    	editForm.find("[name=uploadFile]").fileupload({
		        dataType: 'json',
		        done: function (e, responseData) {
		        	
		        	if(responseData.result.r_code == 0) {
		        		var data = responseData.result.r_data;
		        		console.log(data);
		        		editForm.find("[item-id=preview] a").attr("href", data[0]);
		        		editForm.find("[item-id=preview] img").attr("src", data[0]);
		        		
		        		editForm.find("#bgUrl").val(data[0]);
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
		    		
		    		editForm.find("#bgUrl").val("");
				});
	    };
		
		$().ready(function() {
			bindingButtonClick();
			settingUpload();
			loadParentList();
			loadSchemeList();
			loadList();
		});
	
});




var closeIphoneViewModal = function(){
	$("#iphoneViewModal").modal("hide");
};