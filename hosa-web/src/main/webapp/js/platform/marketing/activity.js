$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/marketing/activity/activity!list.htm";
	var getUrl = ctx + "/webadmin/marketing/activity/activity!input.htm";
	var saveUrl = ctx + "/webadmin/marketing/activity/activity!save.htm";
	var deleteUrl = ctx + "/webadmin/marketing/activity/activity!delete.htm";
	
	var groupQueryUrl = ctx + "/webadmin/marketing/activity/activity!loadGroups.htm";
	var apartUrl = ctx + "/webadmin/marketing/activity/activity!apart.htm";
	
	var exportUrl = ctx + "/webadmin/marketing/activity/activity!export.htm";
	var activityMap = new HashMap();
	
	
	
	var groupMap = null;
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var apartForm = $("#apart-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var apartFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "name" ,  "departmentId" ,  "beginTime" ,  "endTime" ,  "beginTimeString" ,  "endTimeString" ,  "validTimeType" ,  "daysLate" ,  "type" ,  "couponId" ,  "limitNumber" ,  "beginPicUrl" ,  "beginPicStoragePath" ,  "beginDescription" ,  "endPicUrl" ,  "endPicStoragePath" ,  "endDescription" ,  "minimumNumber" ,  "number" ,  "successInfo" ,  "failureInfo" ,  "errorInfo" ,  "status" ,  "modified","estimatePerson","limitCoupon"];	
	var searchColumns = [  "name" , "nameLike", "departmentId" ,  "beginTime" ,  "endTime" ,  "validTimeType" ,  "daysLate" ,  "type" ,  "couponId" ,  "limitNumber" ,  "beginPicUrl" ,  "beginPicStoragePath" ,  "beginDescription" ,  "endPicUrl" ,  "endPicStoragePath" ,  "endDescription" ,  "minimumNumber" ,  "number" ,  "successInfo" ,  "failureInfo" ,  "errorInfo" ,  "status" ,  "modified"];
	var filterColumns = [  "filter_name" ,  "filter_departmentId" ,  "filter_beginTime" ,  "filter_endTime" ,  "filter_validTimeType" ,  "filter_daysLate" ,  "filter_type" ,  "filter_couponId" ,  "filter_limitNumber" ,  "filter_beginPicUrl" ,  "filter_beginPicStoragePath" ,  "filter_beginDescription" ,  "filter_endPicUrl" ,  "filter_endPicStoragePath" ,  "filter_endDescription" ,  "filter_minimumNumber" ,  "filter_number" ,  "filter_successInfo" ,  "filter_failureInfo" ,  "filter_errorInfo" ,  "filter_status" ,  "filter_modified"];
	
	var prizeCHNColumns = ["一等奖：","二等奖：","三等奖：","四等奖：","五等奖：","六等奖："];
	
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
					activityMap = new HashMap();
					$.each(data.result, function(i, o){
						activityMap.put(o.id, o);
						
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
								if(id == "type"){
									console.log("type in");
									switch(itemVal){
									case 1:itemVal="优惠券活动";break;
									case 2:itemVal="促销活动";break;
									case 3:itemVal="抽奖活动";break;
									case 4:itemVal="团购活动";break;
									}
									$(n).text(itemVal);
								}else if(id == "status"){
									if(itemVal == 1){
										$(n).text("未开始");
									}else if(itemVal == 2){
										$(n).text("执行中");
									}else if(itemVal == 3){
										$(n).text("已结束");
									}
								}
								
							}catch(e){								
							}
						});
						
						tr.find("[status"+o.status+"]").show();
						
						
						if(o.couponId==null){
							tr.find("[item-id=button-apart]").hide();
							tr.find("[item-id=button-print]").hide();
						}
						
						
						
						tr.find("[item-view]").click(function() {
							viewItem(tr);
						});
						tr.find("[item-id=button-modify]").click(function() {//绑定修改操作
							loadEditItem(o.id);
						});
						tr.find("[item-id=button-delete]").click(function() {//绑定删除操作
							deleteItem(o.id);
						});
						tr.find("[item-id=button-apart]").click(function() {//绑定删除操作
							apartItem(o.id);
						});
						
						tr.find("[item-id=button-print]").click(function(){
							printItem(o.id);
						});
					
						tr.find("[item-id=button-export]").click(function(){
							exportItem(o.id);
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
		loadList(globalParam);
	}
	
	var viewItem = function(tr){
		var itemId = tr.attr("id");
		var param = {};
		if(itemId) {
				param["id"] = itemId;
		}
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					viewItemCore(tr,data);
					
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
			
			
			
		});
	}
	
	
	var viewItemCore = function(tr,data) {	
		var itemId = tr.attr("id");
		var param = {};
		var dept = data;
			//activityMap.get(itemId);
		
		console.log(dept);
		viewForm.find("[view1]").hide();
		viewForm.find("[view2]").hide();
		viewForm.find("[view3]").hide();
		viewForm.find("[view4]").hide();
		viewForm.find("[view"+dept.type+"]").show();
		
		var groupNames = "";
		$.each(data.groupList,function(i,o){
			
			if(groupNames != ""){
				groupNames = groupNames + ",";
			}
			groupNames = groupNames+o.name;
		});
		dept.groupNames = groupNames;
		console.log("groupNames:"+groupNames);
		
		
		var validString = "";
		
		if(dept.validTimeType==1){
			validString = dept.beginTimeString+"~"+dept.endTimeString;
		}else if(dept.validTimeType==2){
			validString = "自活动开始"+dept.daysLate+"天内";
		}
		dept.validString = validString;
		
		
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(dept, id);
		
			$(o).text(val);
			if(id=="endDescription"||id=="errorInfo"||id=="successInfo"||id=="failureInfo"){
				$(o).val(val);
			}
			
		});
		
		$.each(data.prizeList,function(i,o){
			var prizeDiv = viewForm.find("[prize-template]").clone();
			prizeDiv.removeAttr("prize-template");
			var prizeNameCHN = prizeCHNColumns[o.level-1];
			prizeDiv.find("[name=prizeNameCHN]").text(prizeNameCHN);
			prizeDiv.find("[name=prizeName]").text(o.prize);
			prizeDiv.find("[name=prizeNumber]").text(o.number);
			prizeDiv.appendTo(viewForm.find("[name=prizesDiv]"));
			prizeDiv.show();
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
	
	
	
	var apartItem = function(itemId){
		var param = {};
		if(itemId) {
			
				param["id"] = itemId;
		}
		$.webAjax(getUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					$.each(columns, function(i, o) {
						apartForm.find("[name="+o+"]").val(data[o]);
					});
					$("#apartModal").modal({backdrop: "static"});
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
			
			
			
		});
	}
	
	
	/**
	 * 加载编辑项
	 */
	var loadEditItem = function(itemId,callback) {		
		$("#selectEditModal").modal("hide");
		editForm.find("[data-target=#step1]").find("a").trigger("click");
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
					var type = data.type;
					if(type==1){
						editForm.find("[coupon]").show();
					}else if(type==2){
						editForm.find("[coupon]").show();
						editForm.find("[marketing]").show();
					}else if(type==3){
						editForm.find("li[lucky-draw]").show();
					}else if(type==4){
						editForm.find("li[group-purchase]").show();
					}
					$("#editModal").modal({backdrop: "static"});
					
				}
				
			}else {
				$.errorNotification(responseData.r_info);
			}
			
			if($.isFunction(callback)) {
				callback();
			}
			
		});
		
	
	}
	
	
	/**
	 * 绑定编辑项
	 */
	var bindingEditItem = function(data) {
		console.log("binding ....");
		cleanEditItem();
		
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val(data[o]);
		});
		
		editForm.find("[name=couponName]").select2({
			id:function(obj){
				return obj.id;
			},
			placeholder: "优惠卷名称",
		    minimumInputLength: 1,
		    ajax: {
		        url: ctx+"/webadmin/marketing/activity/activity!loadCoupons.htm",
		        dataType: 'json',
		        quietMillis: 1000,
		        type: "POST",
		        data: function (term, page) { // page is the one-based page number tracked by Select2
		        	console.log("term"+term);
		        	console.log("page"+page);
		            return {
		            	"couponName": term, //search term
		            };
		        },
		        results: function (data) {
		            return {results: data.r_data};
		        }
		    },
		    formatResult: function(obj){
		    	var markup = "<table><tr><td>"+obj.name+"</td></table>";
		    	return markup;
		    			}, // omitted for brevity, see the source of this page
		    formatSelection: function(obj){
		    	editForm.find("[name=couponId]").val(obj.id);
		    	return obj.name;
		    }, // omitted for brevity, see the source of this page
		    dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
		    escapeMarkup: function (m) { return m; } 
			
		});
		
		var unselectEle = editForm.find("[name=unselect-group]");
		var selectedEle = editForm.find("[name=selected-group]");
		//selectEle.empty();
		if(groupMap){
			if(data){
				var categoryIds = new Array();
				$.each(data.groupList,function(i,o){
					categoryIds[i] = o.id	;
				});
				console.log(categoryIds);
				$.each(groupMap.values(),function(i,o){
					if($.inArray(o.id,categoryIds)!=-1){
						$('<option></option').attr("value",o.id).html(o.name).appendTo(selectedEle);
					}else{
						$('<option></option').attr("value",o.id).html(o.name).appendTo(unselectEle);
					}
					
					
				});
			}
		}else{
			loadGroup(function(){
				if(data){
					var categoryIds = new Array();
					$.each(data.groupList,function(i,o){
						categoryIds[i] = o.id	;
					});
					$.each(groupMap.values(),function(i,o){
						if($.inArray(o.id,categoryIds)!=-1){
							$('<option></option').attr("value",o.id).html(o.name).appendTo(selectedEle);
						}else{
							$('<option></option').attr("value",o.id).html(o.name).appendTo(unselectEle);
						}
						
						
					});
				}
			});
		}
		var prizeAmount = data.prizeList.length;
		if(prizeAmount>3){
			for(var i=4;i<=data.prizeList.length;i++){
				var maxLevel = editForm.find("#prizeList").attr("maxLevel");
				maxLevel = parseInt(maxLevel);
				
				
				editForm.find("#prizeList").attr("maxLevel",maxLevel+1);
				var template = editForm.find("[prize-item-template]");
				var section = template.clone();
				section.addClass("prize-item").addClass("extra-item");
				section.removeAttr("prize-item-template");
				var CHNLevel = prizeCHNColumns[maxLevel];
				section.find("[name=prizeLevelCHN]").html(CHNLevel);
				section.attr("level",maxLevel+1);
				section.appendTo(editForm.find("#prizeList"));
				section.show();
			}
		}
		
		$.each(data.prizeList,function(i,o){
			var section = editForm.find("[level="+o.level+"]");
			console.log("section");
			console.log(section);
			section.find("[name=prize]").val(o.prize);
			section.find("[name=number]").val(o.number);
		});
		
		editForm.find("[name=validTimeRadio][value="+data.validTimeType+"]").trigger("click");
		if(data.beginPicUrl){
			
			editForm.find("#beginImg").attr("src",data.beginPicUrl);
		}
		if(data.endPicUrl){
			
			editForm.find("#endImg").attr("src",data.endPicUrl);
		}
		
		$('.summernote').code(data.beginDescription);
		
		
		
	}
	
	
	var loadGroup = function(callback){
		$.webAjax(groupQueryUrl, {}, function(responseData) {
	
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
			
				if(data) {
					groupMap = new HashMap();
					$.each(data,function(i,o){
						groupMap.put(o.id, o);
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
	
	var exportItem = function(itemId) {
		var param = {};
		if(itemId) {
			param["id"] = itemId;
		} else {
		
		}
		
		if(!$.isEmptyObject(param)) {
			$.confirm("确认打印活动名单？", function() {
				$.webAjax(exportUrl, param, function(responseData) {
					
					if(responseData.r_code == 0) {
						var data = responseData.r_data;
						$.successNotification("稍后访问"+data+"获取文件");
						
					}else {
						$.errorNotification(responseData.r_info);
					}
				});
			});
			
		} else {
			$.alert("请选择要删除的活动表。");
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
			$.confirm("确认删除活动表？", function() {
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
			$.alert("请选择要删除的活动表。");
		}
	}
	
	var saveApartItem = function(){
		if(!verifySaveParam()) {
			return;
		}
		var param = {};
		param["apartNumber"] = apartForm.find("[name=apartNumber]").val();
		param["id"] = apartForm.find("[name=id]").val();
		
		$.webAjax(apartUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					lastModifiedId = data.id;
				}
				$.successNotification(responseData.r_info);
				cancelApartItem();
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	
	
	
	/**
	 * 保存项
	 */
	var saveItem = function() {
		
		if(!verifySaveApartParam()) {
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
				param["activity."+o+""] = val;
			} else {
				param["activity."+o+""] = "";
			}
		});
		var groups = editForm.find("[name=selected-group]").find("option");

		$.each(groups,function(i,o){
			param["activity.groupList["+i+"].id"] = $(o).val();
		});
		
		param["activity.validTimeType"] = editForm.find("[name=validTimeRadio]:checked").val();
		param["activity.beginDescription"] = $('.summernote').code();
		var prizes = editForm.find(".prize-item");
		$.each(prizes,function(i,o){
			param["activity.prizeList["+i+"].prize"] = $(o).find("[name=prize]").val();
			param["activity.prizeList["+i+"].number"] = $(o).find("[name=number]").val();
			param["activity.prizeList["+i+"].level"] = $(o).attr("level");
		});
		
		

		return param;
	}
	
	 var verifySaveApartParam = function(){
		 apartFormValidator = apartForm.validate({
				onsubmit:false ,
				rules : {
					apartNumber:{
						required:true
					},
				},

				// Messages for form validation
				messages : {
					apartNumber:{
						required:'请输入预留优惠券张数'
					},
				},

				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			
			});
			 
			 return apartForm.valid();
				
		 
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
					departmentId : {
						required : true
					},
					beginTime : {
						required : true
					},
					endTime : {
						required : true
					},
					validTimeType : {
						required : true
					},
					daysLate : {
						required : true
					},
					type : {
						required : true
					},
					couponId : {
						required : true
					},
					limitNumber : {
						required : true
					},
					beginPicUrl : {
						required : true
					},
					beginPicStoragePath : {
						required : true
					},
					beginDescription : {
						required : true
					},
					endPicUrl : {
						required : true
					},
					endPicStoragePath : {
						required : true
					},
					endDescription : {
						required : true
					},
					minimumNumber : {
						required : true
					},
					number : {
						required : true
					},
					successInfo : {
						required : true
					},
					failureInfo : {
						required : true
					},
					errorInfo : {
						required : true
					},
					status : {
						required : true
					},
					modified : {
						required : true
					},
					estimatePerson:{
						required:true
					},
					apartNumber:{
						required:true
					},
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入编号'
					},
					name : {
						required : '请输入名称'
					},
					departmentId : {
						required : '请输入隶属部门'
					},
					beginTime : {
						required : '请输入开始时间'
					},
					endTime : {
						required : '请输入结束时间'
					},
					validTimeType : {
						required : '请输入时间类型{1：确定日期，2：未确定日期}'
					},
					daysLate : {
						required : '请输入延迟天数'
					},
					type : {
						required : '请输入活动类型{1：优惠券活动，2：促销活动，3：抽奖活动，4：团购活动}'
					},
					couponId : {
						required : '请输入优惠券'
					},
					limitNumber : {
						required : '请输入参加限制次数'
					},
					beginPicUrl : {
						required : '请输入活动开始图片地址'
					},
					beginPicStoragePath : {
						required : '请输入活动开始图片存储地址'
					},
					beginDescription : {
						required : '请输入活动开始描述'
					},
					endPicUrl : {
						required : '请输入活动结束图片地址'
					},
					endPicStoragePath : {
						required : '请输入活动结束图片存储地址'
					},
					endDescription : {
						required : '请输入活动结束描述'
					},
					minimumNumber : {
						required : '请输入最少参加人数'
					},
					number : {
						required : '请输入参加人数'
					},
					successInfo : {
						required : '请输入成功提示'
					},
					failureInfo : {
						required : '请输入失败提示'
					},
					errorInfo : {
						required : '请输入错误提示'
					},
					status : {
						required : '请输入状态{1：为开始，2：执行中，3：已结束}'
					},
					modified : {
						required : '请输入最后修改时间'
					},
					estimatePerson:{
						required:'请输入预计人数'
					},
					apartNumber:{
						required:'请输入预留优惠券张数'
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
	
	var cancelApartItem = function() {
		apartForm.find("[name=apartNumber]").val("");
		//loadList(globalParam);
		if(apartFormValidator) {
			apartForm.find(".state-error").removeClass("state-error");
			apartForm.find(".state-error").removeClass("state-success");
			apartFormValidator.resetForm();  
		}
		$("#apartModal").modal("hide");
	}
	
	
	/**
	 * 清空编辑项
	 */
	var cleanEditItem = function() {
		
		console.log("clean .....")
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val("");
		});
		editForm.find("[name=unselect-group]").empty();
		editForm.find("[name=selected-group]").empty();
		
		editForm.find("[coupon]").hide();
		editForm.find("[marketing]").hide();
		editForm.find("li[lucky-draw]").hide();
		editForm.find("li[group-purchase]").hide();
		editForm.find("[name=prize]").val("");
		$('.summernote').code("");  
		editForm.find("#beginImg").attr("src", ctx + "/img/user.png");
		editForm.find("#endImg").attr("src", ctx + "/img/user.png");
		editForm.find(".extra-item").remove();
		editForm.find("#prizeList").attr("maxLevel","3");
		editForm.find("button[begin]").hide();
		editForm.find("button[end]").hide();
		  
		
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
				param["activityQuery."+o+""] = val;
			} else {
				param["activityQuery."+o+""] = "";
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
		
		$("[item-id=button-save-apart]").click(function() {
			saveApartItem();
		});
		
		$("[item-id=button-cancel-apart]").click(function() {
			cancelApartItem();			
		});
		
		
		
		$("[item-id=button-filter-refresh]").click(function() {
			filterRefreshItem();
		});
		$("[item-id=buttong-toolbar-search]").click(function() {	
			$("#searchModal").modal();
		});
		$("[item-id=button-toolbar-add]").click(function() {
			//loadEditItem();
			editForm.find("[lucky-draw]").hide();
			editForm.find("[group-purchase]").hide();
			editForm.find("[coupon]").hide();
			editForm.find("[marketing]").hide();
			editForm.find("[data-target=#step1]").find("a").trigger("click");
			$("#selectEditModal").modal();
		});
		$("[item-id=button-toolbar-modify]").click(function() {
			var checkedObj = dataTable.find("[name=checkRow]:checked");
			if(checkedObj.length == 0) {
				$.alert("请选择要修改的活动表。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个活动表。");
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
		
		
		$('#couponPointer').click(function(){
			loadEditItem(function() {
				editForm.find("[coupon]").show();
				editForm.find("[name=type]").val(1);
			});
			
		});
		
		$('#marketingPointer').click(function(){
			loadEditItem(function() {
				editForm.find("[coupon]").show();
				editForm.find("[marketing]").show();
				editForm.find("[name=type]").val(2);
			});
		});
		
		$('#luckyDrawPointer').click(function(){
			loadEditItem(function() {
				editForm.find("li[lucky-draw]").show();
				editForm.find("[name=type]").val(3);
			});
			
		});
		
		$('#groupPurchasePointer').click(function(){
			loadEditItem(function() {
				editForm.find("li[group-purchase]").show();
				editForm.find("[name=type]").val(4);
			});
			
		});
		
		
		
		$("li[data-target=#step5]").find("a").click(function(){
			editForm.find("[item-id=button-save]").show();
		});
		
		
		editForm.find("[item-id=button-next-tab]").click(function(){
			if(verifySaveParam()){
				var activeEle = editForm.find("li[step-item]");
				var originalEle;
				var nextEle;
				
				
				$.each(activeEle,function(i,o){
					if($(o).hasClass("active")){
						originalEle = $(o);
					}else if(originalEle){
						if($(o).is(":hidden")==false){
							nextEle=$(o);
							return false;
						}
					}
				});
				if(nextEle){
					nextEle.find("a").trigger("click");
				}
				
				
				
			}
			
		});
		editForm.find("[item-id=button-toolbar-addprize]").click(function(){
			
			var maxLevel = editForm.find("#prizeList").attr("maxLevel");
			console.log("mexlevel:"+maxLevel);
			maxLevel = parseInt(maxLevel);
			
			
			editForm.find("#prizeList").attr("maxLevel",maxLevel+1);
			var template = editForm.find("[prize-item-template]");
			var section = template.clone();
			section.addClass("prize-item").addClass("extra-item");
			section.removeAttr("prize-item-template");
			var CHNLevel = prizeCHNColumns[maxLevel];
			section.find("[name=prizeLevelCHN]").html(CHNLevel);
			section.attr("level",maxLevel+1);
			section.appendTo(editForm.find("#prizeList"));
			section.show();
		});
		
		
		
		
		$("[name=move-right]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-group]");
			var selected = $(this).parents("form").find("[name=selected-group]");
			var option = unselected.find("option:selected");
			if(option.length){
				var value = option.val();
				var text = option.text();
				option.remove();
				$('<option></option>').val(value).text(text).appendTo(selected);
			}
			
			
		});
		$("[name=move-left]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-group]");
			var selected = $(this).parents("form").find("[name=selected-group]");
			var option = selected.find("option:selected");
			if(option.length){
				var value = option.val();
				var text = option.text();
				option.remove();
				$('<option></option>').val(value).text(text).appendTo(unselected);
			}
		});
		$("[name=move-aright]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-group]");
			var selected = $(this).parents("form").find("[name=selected-group]");
			
			selected.append(unselected.html());
			unselected.empty();
			
			
		});
		$("[name=move-aleft]").click(function(){
			var unselected = $(this).parents("form").find("[name=unselect-group]");
			var selected = $(this).parents("form").find("[name=selected-group]");
			
			unselected.append(selected.html());
			selected.empty();
		});
		
		editForm.find("#timeBucket").click(function(){
			editForm.find("#timeBucketDiv").find("input[type=text]").removeAttr("disabled");
			editForm.find("#timeLineDiv").find("input[type=text]").val("").attr("disabled","disabled");
		});
		
		editForm.find("#timeLine").click(function(){
			editForm.find("#timeLineDiv").find("input[type=text]").removeAttr("disabled");
			editForm.find("#timeBucketDiv").find("input[type=text]").val("").attr("disabled","disabled");
		});
		
	}
	
	 var settingUpload = function() {
		 var uploadFileBegin = editForm.find("[name=uploadFile][begin]");
		 uploadFileBegin.fileupload({
		        dataType: 'json',
		        done: function (e, responseData) {
		        	
		        	if(responseData.result.r_code == 0) {
		        		var data = responseData.result.r_data;
		        		
		        		editForm.find("#beginImg").attr("src", data[0]);
		        		
		        		editForm.find("#beginPicUrl").val(data[0]);
		        		editForm.find("#beginPicStoragePath").val(data[1]);
		        	}
		            
		        }
		    });
		 
		 var uploadFileEnd = editForm.find("[name=uploadFile][end]");
		 uploadFileEnd.fileupload({
		        dataType: 'json',
		        done: function (e, responseData) {
		        	if(responseData.result.r_code == 0) {
		        		var data = responseData.result.r_data;
		        		
		        	
		        		editForm.find("#endImg").attr("src", data[0]);
		        		
		        		editForm.find("#endPicUrl").val(data[0]);
		        		editForm.find("#endPicStoragePath").val(data[1]);
		        	}
		            
		        }
		    });
		 
		 
		 
		 
		 
	    	editForm.find("[item-id=preview]").hover(
	    			  function () {
	    				  var imgSrc = $(this).find("img").attr("src");
	    				  if(imgSrc != ctx + "/img/user.png") {
	    					  $(this).find("button").show();
	    					 
	    				  } 
	    				 
	    			  },
	    			  function () {
	    				  $(this).find("button").hide();
	    			  }
	    			);
	    	 
	    	editForm.find("button[end]").click(function(){
	    		console.log("click");
				  editForm.find("#endImg").attr("src", ctx + "/img/user.png");
				  editForm.find("#endPicUrl").val("");
				  editForm.find("#endPicStoragePath").val("");
			  });
			  
			  editForm.find("button[begin]").click(function(){
				  editForm.find("#beginImg").attr("src", ctx + "/img/user.png");
				  editForm.find("#beginPicUrl").val("");
				  editForm.find("#beginPicStoragePath").val("");
			  });
	    }
	
	 	$('.summernote').summernote({
			height : 180,
			focus : false,
			tabsize : 2
		});
	
	
	
	$().ready(function() {
		bindingButtonClick();
		settingUpload();
		loadList();
		
		
	});
	
	
})