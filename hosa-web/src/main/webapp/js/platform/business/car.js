$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/business/car/car!list.htm";
	var getUrl = ctx + "/webadmin/business/car/car!input.htm";
	var saveUrl = ctx + "/webadmin/business/car/car!save.htm";
	var deleteUrl = ctx + "/webadmin/business/car/car!delete.htm";
	
	var carMap = new HashMap();
	var dischargeMap = new HashMap();
	var seriesMap = new HashMap();
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "seriesId" ,  "name" ,  "discountPrice" ,  "marketPrice" ,  "carrosserie" ,  "structure" ,  "capacity" ,  "torsion" ,  "speed" ,  "speedTime" ,  "fuel" ,  "dischargeId" ,  "engineType" ,  "gearbox" ,  "wheelbase" ,  "effluent" ,  "tread" ,  "manufacturers" ,  "level" ,  "picStoragePath" ,  "picUrl" ,  "color" ,  "discountStatus" ,  "modified"];	
	var searchColumns = [  "departmentId" ,  "seriesId" ,  "nameLike" ,  "discountPrice" ,  "marketPrice" ,  "carrosserie" ,  "structure" ,  "capacity" ,  "torsion" ,  "speed" ,  "speedTime" ,  "fuel" ,  "dischargeId" ,  "engineType" ,  "gearbox" ,  "wheelbase" ,  "effluent" ,  "tread" ,  "manufacturers" ,  "level" ,  "picStoragePath" ,  "picUrl" ,  "color" ,  "discountStatus" ,  "modified"];
	var filterColumns = [  "filter_departmentId" ,  "filter_seriesId" ,  "filter_name" ,  "filter_discountPrice" ,  "filter_marketPrice" ,  "filter_carrosserie" ,  "filter_structure" ,  "filter_capacity" ,  "filter_torsion" ,  "filter_speed" ,  "filter_speedTime" ,  "filter_fuel" ,  "filter_dischargeId" ,  "filter_engineType" ,  "filter_gearbox" ,  "filter_wheelbase" ,  "filter_effluent" ,  "filter_tread" ,  "filter_manufacturers" ,  "filter_level" ,  "filter_picStoragePath" ,  "filter_picUrl" ,  "filter_color" ,  "filter_discountStatus" ,  "filter_modified"];
	
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
					carMap = new HashMap();
					$.each(data.result, function(i, o){
						carMap.put(o.id, o);
						
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
						
						if(o.seriesId!=null){
							var item = seriesMap.get(o.seriesId);
							var val = getTableJSONVal(item, 'seriesName');
							tr.find("[item-id=seriesId]").text(val);
						}
						if(o.dischargeId!=null){
							var item = dischargeMap.get(o.dischargeId);
							var val = getTableJSONVal(item, 'name');
							tr.find("[item-id=dischargeId]").text(val);
						}
						
						tr.find("[item-id=parentId]").text(val);
						/*tr.find("[item-view]").click(function() {
							viewItem(tr)
						});*/
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
		var dept = carMap.get(itemId);
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
					loadCarseries(editForm,data.seriesId);
					loadDischarge(editForm,data.seriesId,data.dischargeId);
					loadGearbox(editForm,data.gearbox);
					loadLevel(editForm,data.level);
					/*
					$.each($('[name="dischargeId"]').find('[item-parentid="'+data.seriesId+'"]').parent('span'),function(){
						$(this).children().clone().replaceAll($(this));
					});*/
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
		if(data.picUrl){
			editForm.find("[item-id=preview] a").attr("href", data.picUrl);
			editForm.find("[item-id=preview] img").attr("src", data.picUrl);
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
			$.confirm("确认删除车信息？", function() {
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
			$.alert("请选择要删除的车信息。");
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
				param["car."+o+""] = val;
			} else {
				param["car."+o+""] = "";
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
					name : {
						required : true
					},
				},

				// Messages for form validation
				messages : {
					name : {
						required : '请输入车名称'
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
		editForm.find("[item-id=preview] a").attr("href", ctx + "/img/user.png");
		editForm.find("[item-id=preview] img").attr("src", ctx + "/img/user.png");
		
		editForm.find("#picUrl").val("");	
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
				param["carQuery."+o+""] = val;
			} else {
				param["carQuery."+o+""] = "";
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
				$.alert("请选择要修改的车信息。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个车信息。");
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
		        		console.log(data);
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
		    		
		    		editForm.find("#picUrl").val("");
				});
	    };
	
	
	$().ready(function() {
		bindingButtonClick();
		settingUpload();
		loadCarseriesList();
		loadDischargeList();
		loadList();
	});
	
	$("[name=seriesId]").change(function(){
		var seriesId = $(this).val();
		loadDischarge(editForm ,seriesId);
	});
	

	var loadDischargeList = function(p) {	
		var url = ctx + "/web/queryDischargeList.htm";
		var param = null;
		$.webAjax(url, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					dischargeMap = new HashMap();
					$.each(data, function(i, o){
						dischargeMap.put(o.id, o);
					});
			}else {
				$.errorNotification(responseData.r_info);
			}
		}
		});
	};
	var loadDischarge= function(editForm ,seriesId,selectedId) {
		editForm.find("[name=dischargeId]").html('');
		if(selectedId != null) {
			editForm.find("[name=dischargeId]").parent().addClass("state-disabled");
			editForm.find("[name=dischargeId]").attr("disabled", false);
		} else {
			editForm.find("[name=dischargeId]").parent().removeClass("state-disabled");
			editForm.find("[name=dischargeId]").attr("disabled", false);
		}
		$.each(dischargeMap.values(), function(i, o) {
			if(o.seriesId == seriesId){
				var selected = "";
				if(selectedId) {
					if(o.id == selectedId) {
						selected = "selected";	
					}
				} 
				editForm.find("[name=dischargeId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+o.name+"</option>");
			}
			
		});
		
		editForm.find("[name=dischargeId]").select2({
			placeholder: "排量名称",
			allowClear: true
		});
		
	};
	
	
	var loadCarseriesList = function(p) {	
		var url = ctx + "/webadmin/common/queryCarseriesList.htm";
		$.webAjax(url, null, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					seriesMap = new HashMap();
					
					$.each(data, function(i, o){
						seriesMap.put(o.id, o);
					});
			}else {
				$.errorNotification(responseData.r_info);
			}
		}
		});
	};
	var loadCarseries= function(form, selectedId) {
		form.find("[name=seriesId]").children(".item").remove();
		if(selectedId != null) {
			form.find("[name=seriesId]").parent().addClass("state-disabled");
			form.find("[name=seriesId]").attr("disabled", false);
		} else {
			form.find("[name=seriesId]").parent().removeClass("state-disabled");
			form.find("[name=seriesId]").attr("disabled", false);
		}
		$.each(seriesMap.values(), function(i, o) {
			var selected = "";
			if(selectedId) {
				if(o.id == selectedId) {
					selected = "selected";					
				}
			} 
			form.find("[name=seriesId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+o.seriesName+"</option>");
		});
		
		form.find("[name=seriesId]").select2({
			placeholder: "车系名称",
			allowClear: true
		});
		
	};
	
	var loadGearbox= function(form, selectedId) {
		var array = ['全部','自动挡','手动挡','手自一体'];
		form.find("[name=gearbox]").children(".item").remove();
		if(selectedId != null) {
			form.find("[name=gearbox]").parent().addClass("state-disabled");
			form.find("[name=gearbox]").attr("disabled", false);
		} else {
			form.find("[name=gearbox]").parent().removeClass("state-disabled");
			form.find("[name=gearbox]").attr("disabled", false);
		}
		$.each(array, function(i, o) {
			var selected = "";
			if(selectedId) {
				if(i == selectedId) {
					selected = "selected";					
				}
			} 
			form.find("[name=gearbox]").append("<option value='"+i+"' "+selected+" class='item'>"+o+"</option>");
		});
		
		form.find("[name=gearbox]").select2({
			placeholder: "变速箱",
			allowClear: true
		});
		
	};
	var loadLevel= function(form, selectedId) {
		var array = ['全部','小型车','紧凑型车','中型车','中大型车','豪华车','SUV','跑车','两厢轿车','三厢轿车'];
		form.find("[name=level]").children(".item").remove();
		if(selectedId != null) {
			form.find("[name=level]").parent().addClass("state-disabled");
			form.find("[name=level]").attr("disabled", false);
		} else {
			form.find("[name=level]").parent().removeClass("state-disabled");
			form.find("[name=level]").attr("disabled", false);
		}
		$.each(array, function(i, o) {
			var selected = "";
			if(selectedId) {
				if(i == selectedId) {
					selected = "selected";					
				}
			} 
			form.find("[name=level]").append("<option value='"+i+"' "+selected+" class='item'>"+o+"</option>");
		});
		
		form.find("[name=level]").select2({
			placeholder: "级别",
			allowClear: true
		});
		
	};
	
})