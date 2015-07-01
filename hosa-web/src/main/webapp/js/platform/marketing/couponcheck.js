$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/marketing/couponcheck/coupon-check!list.htm";
	var getUrl = ctx + "/webadmin/marketing/couponcheck/coupon-check!input.htm";
	var saveUrl = ctx + "/webadmin/marketing/couponcheck/coupon-check!reject.htm";
	var checkUrl = ctx + "/webadmin/marketing/couponcheck/coupon-check!check.htm";
	
	var serviceQueryUrl = ctx + "/webadmin/marketing/couponcheck/coupon-check!loadCategory.htm";
	
	var serviceMap = null;
	
	var couponMap = new HashMap();
	
	
	var editForm =  $("#reject-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	
	var rejectForm = $("#reject-form");
	
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "type" ,  "departmentId" ,  "name" ,  "value" ,  "valid","validDays" ,  "amount" ,  "allowDonation" ,  "style" ,  "code" ,  "status" ,  "scope" ,  "conditions" ,  "collectNumber" ,  "usedNumber" ,  "modified","submitTimeString","rejectReason"];	
	var searchColumns = [  "type" ,  "departmentId" ,  "nameLike" ,  "value" ,  "valid" ,  "amount" ,  "allowDonation" ,  "style" ,  "code" ,  "status" ,  "scope" ,  "conditions" ,  "collectNumber" ,  "usedNumber" ,  "modified","submitTimeBegin","submitTimeEnd"];
	var filterColumns = [  "filter_type" ,  "filter_departmentId" ,  "filter_name" ,  "filter_value" ,  "filter_valid" ,  "filter_amount" ,  "filter_allowDonation" ,  "filter_style" ,  "filter_code" ,  "filter_status" ,  "filter_scope" ,  "filter_conditions" ,  "filter_collectNumber" ,  "filter_usedNumber" ,  "filter_modified"];
	
	
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
					couponMap = new HashMap();
					$.each(data.result, function(i, o){
						couponMap.put(o.id, o);
						
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
								
								
								if(id=="amountValue"){
									var val1 = getTableJSONVal(o, "amount");
									var val2 = getTableJSONVal(o, "value");
									if(!isNaN(val1)&&!isNaN(val2)){
										itemVal = val1*val2;
									}
									
								}
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
							
						}).show();
						tr.find("[item-id=button-delete]").click(function() {//绑定删除操作
							deleteItem(o.id);
						}).show();
						tr.find("[item-id=button-view]").show();
						
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
		var param = {};
		param["id"] = itemId;
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					var dept = couponMap.get(itemId);
					$.each(viewForm.find("[item-id]"), function(i, o) {
						var id = $(o).attr("item-id");
						var val = getTableJSONVal(dept, id);
						if(id == "allowDonation"){
							val = "允许";
							if(val == 0){
								val = "不允许";
							}
						}
						$(o).text(val);
					});
					
					var categoriesString = "";
					$.each(data.categories,function(i,o){
						categoriesString += o.name +",";
						
					});
					if(categoriesString.length>0){
						categoriesString = categoriesString.substring(0,categoriesString.length-1);
					}
					viewForm.find("[item-id=categoriesString]").text(categoriesString);
					viewForm.find("[name=ticketCardView]").css("backgroundColor",dept.style);
					console.log(dept.rejectReason);
					if(dept.status == 3){
						viewForm.find("[name=rejectReasonDiv]").show();
					}else{
						viewForm.find("[name=rejectReasonDiv]").hide();
					}
					
					
				}
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		

		
		
		
		
		
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
	var loadEditItem = function(itemId, callback) {	
		$("#selectEditModal").modal("hide");
		var param = {};
		if(itemId) {
			if($.isFunction(itemId)) {
				callback = itemId;
			} else {
				param["id"] = itemId;
			}
			
		}
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					bindingEditItem(data);
					
					$("#editModal").modal({backdrop: "static"});
				}
				
				if($.isFunction(callback)) {
					callback();
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	
	}
	
	var loadService = function(callback) {	
	
		$.webAjax(serviceQueryUrl, {}, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					serviceMap = new HashMap();
					$.each(data,function(i,o){
						serviceMap.put(o.id, o);
					});
					if($.isFunction(callback)){
						callback();
					}
					
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
//			//editForm.find("[name=allowDonation]")
//			editForm.find("[name=ticketCard]").css("backgroundColor",data["style"]);
//			editForm.find("[name=nameView]").text(data["nameView"]);
//			editForm.find("[name=valueView]").text(data["valueView"]);
//			
//			editForm.find("[name=allowDonationRadio][value="+data["allowDonation"]+"]").attr("checked","checked");
//			
//			
////			editForm.find("[name=nameView]").text(data["name"]);
////			if(data["valid"]){
////				var validStr = "有效期："+
////				editForm.find("[name=validView]").text();
////			}
//			
//			
//			
//			
//			
//			
//		
//		var unselectEle = editForm.find("[name=unselect-service]");
//		var selectedEle = editForm.find("[name=selected-service]");
//		//selectEle.empty();
//		if(serviceMap){
//			if(data){
//				var categoryIds = new Array();
//				$.each(data.categories,function(i,o){
//					categoryIds[i] = o.id	;
//				});
//				console.log(categoryIds);
//				$.each(serviceMap.values(),function(i,o){
//					if($.inArray(o.id,categoryIds)!=-1){
//						$('<option></option').attr("value",o.id).html(o.name).appendTo(selectedEle);
//					}else{
//						$('<option></option').attr("value",o.id).html(o.name).appendTo(unselectEle);
//					}
//					
//					
//				});
//			}
//		}else{
//			loadService(function(){
//				if(data){
//					var categoryIds = new Array();
//					$.each(data.categories,function(i,o){
//						categoryIds[i] = o.id	;
//					});
//					$.each(serviceMap.values(),function(i,o){
//						if($.inArray(o.id,categoryIds)!=-1){
//							$('<option></option').attr("value",o.id).html(o.name).appendTo(selectedEle);
//						}else{
//							$('<option></option').attr("value",o.id).html(o.name).appendTo(unselectEle);
//						}
//						
//						
//					});
//				}
//			});
//		}
	}
	
	
	
	/**
	 * 删除项
	 */
	var deleteItem = function(itemId) {
		var param = {};
		if(itemId) {
			param["id"] = itemId;
		} 
//		else {
//			var checkedObj = dataTable.find("[name=checkRow]:checked");
//			
//			$.each(checkedObj, function(i, o){			
//				param["checkedIdList[" + i + "]"] = $(o).val();
//			});
//		}
		
		if(!$.isEmptyObject(param)) {
			$.confirm("确认审核通过此优惠券？", function() {
				$.webAjax(checkUrl, param, function(responseData) {
					
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
			$.alert("请选择要删除的优惠券表。");
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
		
//		$.each(columns, function(i, o) {
//			var val =  $.trim(editForm.find("[name="+o+"]").val());
//			
//			
//			if(val) {
//				param["coupon."+o+""] = val;
//			} else {
//				param["coupon."+o+""] = "";
//			}
//			
//			
//		});
		param["coupon.id"] = $.trim(editForm.find("[name=id]").val());
		param["coupon.modified"] = $.trim(editForm.find("[name=modified]").val());
		param["coupon.rejectReason"] = $.trim(editForm.find("[name=rejectReason]").val());
		
		


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
					type : {
						required : true
					},
					departmentId : {
						required : true
					},
					name : {
						required : true
					},
					value : {
						required : true
					},
					valid : {
						required : true
					},
					amount : {
						required : true
					},
					allowDonation : {
						required : true
					},
					style : {
						required : true
					},
					code : {
						required : true
					},
					status : {
						required : true
					},
					scope : {
						required : true
					},
					conditions : {
						required : true
					},
					collectNumber : {
						required : true
					},
					usedNumber : {
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
					type : {
						required : '请输入类型{1：代金券，2：礼品券}'
					},
					departmentId : {
						required : '请输入隶属部门'
					},
					name : {
						required : '请输入名称'
					},
					value : {
						required : '请输入面值'
					},
					valid : {
						required : '请输入有效期'
					},
					amount : {
						required : '请输入数量'
					},
					allowDonation : {
						required : '请输入允许转赠{1：允许，0：不允许}'
					},
					style : {
						required : '请输入样式'
					},
					code : {
						required : '请输入内部编码'
					},
					status : {
						required : '请输入状态{1：创建中，2：待审核，3：已驳回，4：待使用，5：已使用}'
					},
					scope : {
						required : '请输入适用范围'
					},
					conditions : {
						required : '请输入使用条件'
					},
					collectNumber : {
						required : '请输入collectNumber'
					},
					usedNumber : {
						required : '请输入usedNumber'
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
//		editForm.find("[name=unselect-service]").empty();
//		editForm.find("[name=selected-service]").empty();
		
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
				param["couponQuery."+o+""] = val;
			} else {
				param["couponQuery."+o+""] = "";
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
			
			$("#selectEditModal").modal();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的优惠券表。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个优惠券表。");
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
		
		$('#voucherPointer').click(function(){
			editForm.find("[name=value]").show();
			editForm.find("[name=amount]").parent(".input").show();
			loadEditItem(function() {
				editForm.find("[name=type]").val(1);
			});
			
		});
		
		$('#giftPointer').click(function(){
			editForm.find("[name=value]").hide();
			editForm.find("[name=amount]").parent(".input").hide();
			loadEditItem(function() {
				editForm.find("[name=type]").val(2);
			});
			
		});
		
		$("[name=color-item]").click(function(){
			var color = $(this).find("a").css("backgroundColor");
			$(this).parents("form").find("[name=ticketCard]").css("backgroundColor",color);
			editForm.find("[name=style]").val(color);
		});
		
		
		$("[name=move-right]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-service]");
			var selected = $(this).parents("form").find("[name=selected-service]");
			var option = unselected.find("option:selected");
			if(option.length){
				var value = option.val();
				var text = option.text();
				option.remove();
				$('<option></option>').val(value).text(text).appendTo(selected);
			}
			
			
		});
		$("[name=move-left]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-service]");
			var selected = $(this).parents("form").find("[name=selected-service]");
			var option = selected.find("option:selected");
			if(option.length){
				var value = option.val();
				var text = option.text();
				option.remove();
				$('<option></option>').val(value).text(text).appendTo(unselected);
			}
		});
		$("[name=move-aright]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-service]");
			var selected = $(this).parents("form").find("[name=selected-service]");
			
			selected.append(unselected.html());
			unselected.empty();
			
			
		});
		$("[name=move-aleft]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-service]");
			var selected = $(this).parents("form").find("[name=selected-service]");
			
			unselected.append(selected.html());
			selected.empty();
		});
		
		
		editForm.find("[name=name]").blur(function(){
			setTimeout(function(){
				editForm.find("[name=nameView]").text(editForm.find("[name=name]").val());
			},500);
		});
		
		editForm.find("[name=value]").blur(function(){
			setTimeout(function(){
				editForm.find("[name=valueView]").text(editForm.find("[name=value]").val());
			},500);
		});
		
		
		
		
	}
	
	$().ready(function() {
		bindingButtonClick();
		loadList();
	});
	
	
})