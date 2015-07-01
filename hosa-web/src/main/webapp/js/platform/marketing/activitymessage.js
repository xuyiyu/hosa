$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/marketing/activitymessage/activity-message!list.htm";
	var getUrl = ctx + "/webadmin/marketing/activitymessage/activity-message!input.htm";
	var saveUrl = ctx + "/webadmin/marketing/activitymessage/activity-message!save.htm";
	var deleteUrl = ctx + "/webadmin/marketing/activitymessage/activity-message!delete.htm";
	
	var getActivityListUrl = ctx + "/webadmin/marketing/activity/activity!list.htm";
	
	var activitymessageMap = new HashMap();
	var activityMap = null;
	var groupMap = new HashMap();
	
	var editForm = $("#edit-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "recipient" ,  "type" ,  "category" ,  "name" ,  "description" ,  "sendTime" ,  "status" ,  "modified"];	
	var searchColumns = [  "departmentId" ,  "recipient" ,  "type" ,  "category" ,  "nameLike" ,  "description" ,  "sendTime" ,  "status" ,  "modified"];
	var filterColumns = [  "filter_departmentId" ,  "filter_recipient" ,  "filter_type" ,  "filter_category" ,  "filter_name" ,  "filter_description" ,  "filter_sendTime" ,  "filter_status" ,  "filter_modified"];
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
					activitymessageMap = new HashMap();
					$.each(data.result, function(i, o){
						activitymessageMap.put(o.id, o);
						
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
						if(o.status=='1'){
							tr.find("[item-id='status']").text('待发送');
						}else if(o.status=='2'){
							tr.find("[item-id='status']").text('发送成功');
							tr.find("[item-id='button-modify']").text('详情');
						}
						
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
		var dept = activitymessageMap.get(itemId);
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
				var data = responseData.r_data.activityMessage;
				var list = responseData.r_data.activityMessageContentList;
				console.log(responseData.r_data);

				if(data) {
					bindingEditItem(data,list);
					loadGroup(editForm,data.recipient);
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
	var bindingEditItem = function(data,list) {
		cleanEditItem();
		activityMap = new HashMap();
		console.log(activityMap.values());
		if(list){
			$.each(list,function(i,o){
				activityMap.put(o.activityId,o);
				createSetion(o);
			});
			var messageContent = list[0];
			bindingActivityItem(messageContent,messageContent.id);
		}
		$.each(columns, function(i, o) {
			editForm.find("[name="+o+"]").val(data[o]);
		});
		if(data.status == '2'){
			$('[item-id="button-save"]').hide();
		}
		$('[item-id="button-activity"]').click(function(){
			loadActivityList();
			$("#activitySearchModal").modal({backdrop: "static"});
		});
		$('[item-id="button-itemsave"]').click(function(){
			var activity = putActivityMap();
			if(activity == null)return;
			$('.section_activity').html('');
			cleanActivityItem();
			$.each(activityMap.values(),function(i,o){
				createSetion(o);
			});
			
		});
		$('[item-id="button-itemcancel"]').click(function(){
			cleanActivityItem();
		});

		if(data.sendTime!=''){
			$("#sendTime").val(data.sendTimeString);
		}
		
		editForm.find("[name='name']").val(data.name);
		
		
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
			$.confirm("确认删除活动消息表？", function() {
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
			$.alert("请选择要删除的活动消息表。");
		}
	}
	
	/**
	 * 保存项
	 */
	var saveItem = function() {
		if(!verifySaveParam()) {
			return;
		}
		if(activityMap.size()<1) {
			editForm.find('[item-id="button-activity"]').after('<em for="activityMes" style="color: #D56161;font-style: normal;margin-left:10px;" class="invalid">请选择活动</em>');
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
		param["activityMessage.id"] = editForm.find("[name='id']").val();
		param["activityMessage.name"] = editForm.find("[name='name']").val();
		param["activityMessage.type"] = "5";//图文
		param["activityMessage.category"] = "1";//微信
		
		var value = "";
		$.each(editForm.find("[name='groupId']").val(),function(i,o){
			value += o + ",";
		});
		
		if(value != ""){
			var recipient = value.substring(0,value.length-1);
			param["activityMessage.recipient"] = "group:"+recipient;
		}
		
		var isStatus = editForm.find("[name=allowDonationRadio]:checked").val();
		if(isStatus=="0"){
			var mVal = editForm.find("[name=sendTimeAdd]").val();
			var currentDate = new Date(editForm.find("[name=sendTime]").val()); 
			var newTime =  currentDate.getTime() + mVal*60000;
			param["activityMessage.sendTime"] = newTime;
		}else{
			var currentDate = new Date(); 
			param["activityMessage.sendTime"] = currentDate.getTime();
		}
		param["activityMessage.status"] = "1";//待发送
		$.each(activityMap.values(), function(i, o) {
			param["activityMessageContentList["+i+"].id"]=o.activityMessageContentId;
			param["activityMessageContentList["+i+"].activityMessageId"]=o.activityMessageId;
			param["activityMessageContentList["+i+"].activityId"]=o.activityId;
			param["activityMessageContentList["+i+"].title"]=o.title;
			param["activityMessageContentList["+i+"].content"]=o.content;
			param["activityMessageContentList["+i+"].url"]=o.url;
			param["activityMessageContentList["+i+"].linkUrl"]=o.linkUrl;
			param["activityMessageContentList["+i+"].storagePath"]=o.storagePath;
		});		
		
		param["activityMessage.mvStatus"] = editForm.find("[name=allowDonationRadio]:checked").val();
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
						required : '请输入消息名称'
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
		cleanActivityItem();
		$('.section_activity').html('');
		$('[name="sendTime"]').val('');
		$('[name="sendTimeAdd"]').val('');
		$('[item-id="button-save"]').show();
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
				param["activityMessageQuery."+o+""] = val;
			} else {
				param["activityMessageQuery."+o+""] = "";
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
				$.alert("请选择要修改的活动消息表。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个活动消息表。");
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
		        		editForm.find("#storagePath").val(data[1]);
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
		    		editForm.find("#storagePath").val("");
				});
	    };
	
	$().ready(function() {
		bindingButtonClick();
		settingUpload();
		loadGroupList();
		loadList();
	});
	
	
	
	
	var loadActivityList = function(p) {	
		var param = null;
		var dataTable = $('#activitySearchModal');
		$.webAjax(getActivityListUrl, param, function(responseData) {		
			dataTable.find(".item").remove();
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					$.each(data.result, function(i, o){
						var template = dataTable.find("tr[item-template]");
						var tr = template.clone();
						tr.removeAttr("item-template");
						var items = tr.find("td");
						tr.attr("id", o.id);
						tr.addClass("item");
						if(o.id == lastModifiedId) {
							tr.addClass("last-modified");
						}
						tr.find("[item-id=button-selectAct]").click(function() {//绑定修改操作
							cleanActivityItem();
							
							var param = {};
							param['activityId']=o.id;
							param['title']=o.name;
							param['content']=o.beginDescription;
							param['url']=o.beginPicUrl;
							param['storagePath']=o.beginPicStoragePath;
							
							bindingActivityItem(param,'');
							$('#activitySearchModal').modal("hide");
						});
				
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
	
	var putActivityMap = function(){
		if(editForm.find('[name="activityId"]').val() == ""){
			return null;
		}

		var activityParam = {};
		activityParam['activityMessageContentId'] = editForm.find('[name="activityMessageContentId"]').val();
		activityParam['activityMessageId'] = editForm.find('[name="activityMessageId"]').val();
		activityParam['activityId'] = editForm.find('[name="activityId"]').val();
		activityParam['title'] = editForm.find('[name="title"]').val();
		activityParam['content'] = editForm.find('[name="content"]').val();
		activityParam['url'] = editForm.find('[name="picUrl"]').val();
		activityParam['storagePath'] = editForm.find('[name="storagePath"]').val();
		activityParam['linkUrl'] = editForm.find('[name="linkUrl"]').val();
		activityParam['status'] = 'new';
		activityMap.put(activityParam['activityId'], activityParam);
		return activityParam;
	}
	var cleanActivityItem = function(){
		editForm.find('[name="activityMessageContentId"]').val('');
		editForm.find('[name="activityMessageId"]').val('');
		editForm.find('[name="activityId"]').val('');
		editForm.find('[name="title"]').val('');
		editForm.find('[name="content"]').val('');
		
		editForm.find('[name="picUrl"]').val('');
		editForm.find('[name="storagePath"]').val('');
		editForm.find('[name="linkUrl"]').val('');
		$('[item-id="preview"]').find('img').attr('src','');
	};
	
	var bindingActivityItem = function (data,id){
		editForm.find('[name="activityMessageContentId"]').val(id);
		editForm.find('[name="activityMessageId"]').val(data.activityMessageId);
		editForm.find('[name="activityId"]').val(data.activityId);
		editForm.find('[name="title"]').val(data.title);
		editForm.find('[name="content"]').val(data.content);
		editForm.find('[name="picUrl"]').val(data.url);
		editForm.find('[name="storagePath"]').val(data.storagePath);
		editForm.find('[name="linkUrl"]').val(data.linkUrl);
		$('[item-id="preview"]').find('img').attr('src',data.url);
	};
	
	var createSetion = function(data){
		var div_OBJ = $('<tr name="activityId_'+data.activityId+'" activityId="'+data.activityId+'"></tr>').click(function(){
			bindingActivityItem(data,data.id);
		}).appendTo($('.section_activity'));
		$('<td></td>').appendTo(div_OBJ).html(data.title);
		$('<td></td>').appendTo(div_OBJ).html('<img src="'+data.url+'" width="20px" height="20px">');
		
		var btn = $('<button type="button" class="btn btn-danger btn-xs" item-id="button-activity-delete">删除</button>').click(function(){
			$('[name="activityId_'+data.activityId+'"]').remove();
			activityMap.remove(data.activityId);
		});
		$('<td></td>').appendTo(div_OBJ).append(btn);
	};
	
	
	/**
	 * 查询用户组列表
	 */
	var loadGroupList = function(p) {	
		var url = ctx + "/webadmin/marketing/activitymessage/activity-message!getGroupList.htm";
		$.webAjax(url, null, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					groupMap = new HashMap();
					
					$.each(data, function(i, o){
						groupMap.put(o.id, o);
					});
			}else {
				$.errorNotification(responseData.r_info);
			}
		}
		});
	};
	/**
	 * 加载用户组
	 */
	var loadGroup= function(form, selectedId) {
		form.find("[name=groupId]").children(".item").remove();
		if(selectedId != null) {
			form.find("[name=groupId]").parent().addClass("state-disabled");
			form.find("[name=groupId]").attr("disabled", false);
		} else {
			form.find("[name=groupId]").parent().removeClass("state-disabled");
			form.find("[name=groupId]").attr("disabled", false);
		}
		$.each(groupMap.values(), function(i, o) {
			var selected = "";
			if(selectedId) {
				var groupIds = selectedId.substring(selectedId.indexOf(":")+1);
				var groupValues = groupIds.split(",");
				$.each(groupValues, function(m, n){
					if(o.id == n) {
						selected = "selected";					
					}
				});
			} 
			form.find("[name=groupId]").append("<option value='"+o.id+"' "+selected+" class='item'>"+o.name+"</option>");
		});
		
		form.find("[name=groupId]").select2({
			placeholder: "用户组",
			allowClear: true
		});
		
	};
	
	
})