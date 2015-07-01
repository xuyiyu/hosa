$(function() {
	var globalParam = {};
	
	var queryUrl = ctx + "/webadmin/system/material/material!list.htm";
	var getUrl = ctx + "/webadmin/system/material/material!input.htm";
	var saveUrl = ctx + "/webadmin/system/material/material!save.htm";
	var deleteUrl = ctx + "/webadmin/system/material/material!delete.htm";
	
	var materialMap = new HashMap();
	
	
	var editForm = $("#edit-form");
	var editSubForm = $("#edit-sub-form");
	var searchForm = $("#search-form");
	var viewForm = $("#view-form");
	var viewSubForm = $("#view-sub-form");
	var dataTable = $("#data-table");
	var editFormValidator;
	var editSubFormValidator;
	var lastModifiedId = 0;
	
	var columns = [  "id" ,  "departmentId" ,  "name" ,  "type" ,  "description" ,  "modified"];	
	var searchColumns = [ "nameLike" ,  "type"];
	var filterColumns = [  "filter_departmentId" ,  "filter_name" ,  "filter_type" ,  "filter_description" ,  "filter_modified"];
	
	var currentType = 0;
	
	var materialMap = new HashMap();
	materialMap.put("1", "文本");
	materialMap.put("2", "图片");
	materialMap.put("3", "语音");
	materialMap.put("4", "视频");
	materialMap.put("6", "图文");
	materialMap.put("7", "链接");
	
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
		console.debug(param);
		$.webAjax(queryUrl, param, function(responseData) {		
			dataTable.find(".item").remove();
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					materialMap = new HashMap();
					$.each(data.result, function(i, o){
						materialMap.put(o.id, o);
						
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
		var item = materialMap.get(itemId);
		$.each(viewForm.find("[item-id]"), function(i, o) {
			var id = $(o).attr("item-id");
			var val = getTableJSONVal(item, id);
			$(o).text(val);
		});
		
		viewSubForm.find("[item-id=sub-list] .item").remove();
		if(item.materialContentList) {
			$.each(item.materialContentList, function(i, o) {
				var template = viewSubForm.find("[item-template]");
				var node = template.clone();
				node.removeAttr("item-template");
				node.addClass("item");
				node.appendTo(viewSubForm.find("[item-id=sub-list]"));						
				node.show();
				
				$.each(node.find("[item-id]"), function(m, n) {
					var id = $(n).attr("item-id");
					var val = getTableJSONVal(o, id);
					val = val.replace(/\n/g,"<br>");
					$(n).html(val);
					
				});
				
				if(item.type == 1) {
					node.find("[item-id=type]").html("");
					node.find("[item-id=type]").hide();
					node.find("[item-id=type]").next("section").removeClass("col-7");
				} else if(item.type == 2 || item.type == 6) {
					node.find("[item-id=type]").next("section").addClass("col-7");
					node.find("[item-id=type]").html("<div class='nailthumb-container'><img src='"+o.url+"' style='width: 100%'></div>");
				}else if(item.type == 3)  {
					node.find("[item-id=type]").next("section").addClass("col-7");
					node.find("[item-id=type]").html("<audio style='width: 100%;' controls='controls' ><source src='"+o.url+"' type='audio/mp3' /><embed height='100' width='100' src='"+o.url+"' /></audio>");
				}else if(item.type == 4 ) {
					node.find("[item-id=type]").next("section").addClass("col-7");
					node.find("[item-id=type]").html("<embed  src='"+ctx+"/js/plugin/ckplayer/ckplayer.swf' flashvars='f="+o.url+"&p=0' quality='high' width='200' height='180' align='middle' allowScriptAccess='always' allowFullscreen='true' type='application/x-shockwave-flash'/>");
				}else if(item.type == 7) {
					node.find("[item-id=type]").html("");
					node.find("[item-id=type]").hide();
					node.find("[item-id=type]").next("section").removeClass("col-7");
				} 
				
			});
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
		editForm.find("[name=type]").val(currentType);
		
		
		editSubForm.find("[item-id^='sub-']").hide();
		if(currentType == 1) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-content']").show();
			editSubForm.find("[item-id='sub-url']").show();
		} else if(currentType == 2) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-image']").show();
			editSubForm.find("[item-id='sub-url']").show();
		} else if(currentType == 3) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-voice']").show();
		} else if(currentType == 4) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-video']").show();
		} else if(currentType == 6) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-content']").show();
			editSubForm.find("[item-id='sub-image']").show();
			editSubForm.find("[item-id='sub-url']").show();
		} else if(currentType == 7) {
			editSubForm.find("[item-id='sub-title']").show();
			editSubForm.find("[item-id='sub-url']").show();
		}
		
		if(data.materialContentList) {
			$.each(data.materialContentList, function(i, o) {
				bindingSubItem(o);
			});
		}
		
		if(editSubForm.find("tbody tr.item").length == 0) {
			var template = editSubForm.find("tr[item-template]");
			
			var tr = template.clone();
			tr.removeAttr("item-template");
			tr.addClass("item-empty");
			
			var itemLength = tr.find("td").length;
			tr.empty();
			
			var item = $("<td></td>");
			item.addClass("data_empty");
			item.attr("colspan", itemLength);
			item.html(i18n.noRecordFound);
			item.appendTo(tr);
			
			tr.appendTo(editSubForm.find("tbody"));					
			tr.show();
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
			$.confirm("确认删除素材表？", function() {
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
			$.alert("请选择要删除的素材表。");
		}
	}
	
	/**
	 * 保存项
	 */
	var saveItem = function() {
		if(!verifySaveParam()) {
			return;
		}
		if(editSubForm.find("tbody tr.item").length == 0) {
			editSubForm.find("[item-id=sub-error]").show();
			return;
		} else {
			editSubForm.find("[item-id=sub-error]").hide();
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
				canceEditItem();
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
				param["material."+o+""] = val;
			} else {
				param["material."+o+""] = "";
			}
		});

		
		var subItems = editSubForm.find("tbody tr.item");
		var cnt = 0;
		$.each(subItems, function(i, o) {
			var titleVal = $(o).find("[name=title]").val();
			var linkUrlVal = $(o).find("[name=linkUrl]").val();
			var storagePathVal = $(o).find("[name=storagePath]").val();
			var urlVal = $(o).find("[name=url]").val();
			var contentVal = $(o).find("[name=content]").val();
			
			param['material.materialContentList[' + i + '].title'] = titleVal;
			param['material.materialContentList[' + i + '].linkUrl'] = linkUrlVal;
			param['material.materialContentList[' + i + '].storagePath'] = storagePathVal;
			param['material.materialContentList[' + i + '].url'] = urlVal;
			param['material.materialContentList[' + i + '].content'] = contentVal;
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
					}
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入编号'
					},
					name : {
						required : '请输入素材名称'
					},
					type : {
						required : '请输入素材类型'
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
	var canceEditItem = function() {
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
		
		editSubForm.find("[name^='temp']").val("");
		editSubForm.find("[item-id=preview] img").attr("src", ctx + "/img/user.png");
		editSubForm.find("tbody tr.item-empty").remove();
		editSubForm.find("tbody tr.item").remove();
		if(editSubFormValidator) {
			editSubForm.find(".state-error").removeClass("state-error");
			editSubForm.find(".state-error").removeClass("state-success");
			editSubFormValidator.resetForm();  
		}
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
				param["materialQuery."+o+""] = val;
			} else {
				param["materialQuery."+o+""] = "";
			}
		});
		param["materialQuery.type"] = currentType;
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
		loadList({"materialQuery.type": currentType});
		searchModal.modal("hide");
	}
	
	
	var canceSubEditItem = function() {
		editSubForm.find("[name^='temp']").val("");
		editSubForm.find("[item-id=preview] img").attr("src", ctx + "/img/user.png");
		loadVideo("");
		loadVocie();
	}
	
	var bindingSubItem = function(param) {
		var tr;
		if(param["tempId"]) {
			tr = editSubForm.find("tbody tr.item#"+param["tempId"]);
		} else {
			var template = editSubForm.find("tr[item-template]");
			tr = template.clone();
			tr.attr("id", editSubForm.find("tbody tr.item").length + 1);
			tr.removeAttr("item-template");
			tr.addClass("item");
			param["tempId"] = tr.attr("id");
			
			tr.appendTo(editSubForm.find("tbody"));		
		}
		
		
		
		tr.find("[name=id]").text(param["id"]);
		tr.find("[item-id=title]").text(param["title"]);
		tr.find("[name=title]").val(param["title"]);
		tr.find("[name=linkUrl]").val(param["linkUrl"]);
		tr.find("[name=storagePath]").val(param["storagePath"]);
		tr.find("[name=url]").val(param["url"]);
		tr.find("[name=content]").val(param["content"]);
		
						
		tr.show();
		
		editSubForm.find("tbody tr.item-empty").remove();
		
		tr.find("[item-id=title]").click(function() {
			console.debug($(this).parents("tr").attr("id"));
			console.debug(editSubForm.find("[name='tempId']"));
			editSubForm.find("[name='tempId']").val($(this).parents("tr").attr("id"));
			editSubForm.find("[name='tempTitle']").val($(this).parents("tr").find("[name=title]").val());
			editSubForm.find("[name='tempLinkUrl']").val($(this).parents("tr").find("[name=linkUrl]").val());
			editSubForm.find("[name='tempStoragePath']").val($(this).parents("tr").find("[name=storagePath]").val());
			editSubForm.find("[name='tempUrl']").val($(this).parents("tr").find("[name=url]").val());
			editSubForm.find("[item-id=preview] img").attr("src", $(this).parents("tr").find("[name=url]").val());
			loadVideo($(this).parents("tr").find("[name=url]").val());
			loadVocie($(this).parents("tr").find("[name=url]").val());
			editSubForm.find("[name='tempContent']").val($(this).parents("tr").find("[name=content]").val());
		});
		
		tr.find("[item-id=button-sub-delete]").click(function() {//绑定删除操作
			$(this).parents("tr").remove();
			if(editSubForm.find("tbody tr.item").length == 0) {
				var template = editSubForm.find("tr[item-template]");
				
				var tr = template.clone();
				tr.removeAttr("item-template");
				tr.addClass("item-empty");
				
				var itemLength = tr.find("td").length;
				tr.empty();
				
				var item = $("<td></td>");
				item.addClass("data_empty");
				item.attr("colspan", itemLength);
				item.html(i18n.noRecordFound);
				item.appendTo(tr);
				
				tr.appendTo(editSubForm.find("tbody"));		
				tr.show();
			}
			
		});
		canceSubEditItem();
	}
	var saveSubEditItem = function() {
		if(!verifySubSaveParam()) {
			return;
		}
		
		
		var idVal = editSubForm.find("[name='tempId']").val();
		var titleVal = editSubForm.find("[name='tempTitle']").val();
		var linkUrlVal = editSubForm.find("[name='tempLinkUrl']").val();
		var storagePathVal = editSubForm.find("[name='tempStoragePath']").val();
		var urlVal = editSubForm.find("[name='tempUrl']").val();
		var contentVal = editSubForm.find("[name='tempContent']").val();
		var param = {};
		param["tempId"] = idVal;
		param["title"] = titleVal;
		param["linkUrl"] = linkUrlVal;
		param["storagePath"] = storagePathVal;
		param["url"] = urlVal;
		param["content"] = contentVal;
		
		bindingSubItem(param);
	}
	
	var verifySubSaveParam = function() {
		editSubFormValidator = editSubForm.validate({
			onsubmit:false ,
			rules : {
				tempTitle : {
					required : true
				},
				tempUrl: {
					required : true
				},
				tempLinkUrl: {
					url : true
				},
				tempContent : {
					required : true
				}
			},

			// Messages for form validation
			messages : {
				tempTitle : {
					required : '请输入标题'
				},
				tempUrl: {
					required : '请上传文件'
				},
				tempLinkUrl: {
					url : '请输入正确的链接地址'
				},
				tempContent : {
					required : '请输入内容'
				}
			},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		
		});
		
		 return editSubForm.valid();
	}

	
	var settingUpload = function() {
    	editSubForm.find("[item-id=sub-image] [name=uploadFile]").fileupload({
	        dataType: 'json',
	        done: function (e, responseData) {
	        	
	        	if(responseData.result.r_code == 0) {
	        		var data = responseData.result.r_data;
	        		
	        		editSubForm.find("[item-id=sub-image] [item-id=preview] a").attr("href", data[0]);
	        		editSubForm.find("[item-id=sub-image] [item-id=preview] img").attr("src", data[0]);
	        		
	        		editSubForm.find("[name=tempUrl]").val(data[0]);
	        		editSubForm.find("[name=tempStoragePath]").val(data[1]);
	        		
	        	}
	            
	        }
	    });

    }
	
	var settingVideoUpload = function() {
		loadVideo("");
		editSubForm.find("[item-id=sub-video] [name=uploadFile]").fileupload({
	        dataType: 'json',
	        done: function (e, responseData) {
	        	console.debug(responseData);
	        	if(responseData.result.r_code == 0) {
	        		var data = responseData.result.r_data;

	        		loadVideo(data[0]);
	        		editSubForm.find("[name=tempUrl]").val(data[0]);
	        		editSubForm.find("[name=tempStoragePath]").val(data[1]);
	        	}
	            
	        }
	    });
 
    }
	var loadVideo = function(videoUrl) {
    	var flashvars={
				f: videoUrl,
				c:0
				};
			CKobject.embedSWF(ctx + '/js/plugin/ckplayer/ckplayer.swf','video-preview','ckplayer_a1','260','180',flashvars);
    }
	
	var settingVoiceUpload = function() {
		loadVocie();
		editSubForm.find("[item-id=sub-voice] [name=uploadFile]").fileupload({
	        dataType: 'json',
	        done: function (e, responseData) {
	        	console.debug(responseData);
	        	if(responseData.result.r_code == 0) {
	        		var data = responseData.result.r_data;

	        		loadVocie(data[0]);
	        		editSubForm.find("[name=tempUrl]").val(data[0]);
	        		editSubForm.find("[name=tempStoragePath]").val(data[1]);
	        	}
	            
	        }
	    });
 
    }
	var loadVocie = function(voiceUrl) {
		if(voiceUrl) {
			$("#voice-preview").html("<audio style='width: 100%;' controls='controls' ><source src='"+voiceUrl+"' type='audio/mp3' /><embed height='100' width='100' src='"+voiceUrl+"' /></audio>");
		} else {
			$("#voice-preview").html("<audio style='width: 100%;' controls='controls' ><source src='"+voiceUrl+"' type='audio/mp3' /><embed height='100' width='100' src='"+voiceUrl+"' /></audio>");
		}
		
    }
	
	/**
	 * 绑定页面按钮事件
	 */
	var bindingButtonClick = function() {
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
				$.alert("请选择要修改的素材表。");
				return;
			} else if(checkedObj.length > 1) {
				$.alert("只能修改一个素材表。");
				return;
			}
			loadEditItem(checkedObj.val());
		});
		$("[item-id=button-toolbar-delete]").click(function() {
			deleteItem();
		});
		$("[item-id=button-save]").click(function() {
			saveItem();
		});
		
		$("[item-id=button-cancel]").click(function() {
			canceEditItem();			
		});
		
		$("[item-id=button-sub-cancel]").click(function() {
			canceSubEditItem();			
		});		
		
		$("[item-id=button-sub-save]").click(function() {
			saveSubEditItem();			
		});
		/* 搜索*/
		$("[item-id=button-search]").click(function() {
			searchItem();
		});
		$("[item-id=button-search-reset]").click(function() {
			resetSearchItem();
		});

	}
	
	var loadTypeTab = function() {
		$("[item-id=tab-type]").html("");
		$.each(materialMap.keys(), function(i, o){
			var materialText = materialMap.get(o);
			
			var a = $("<a></a>");
			a.attr("href", "#s1").attr("data-toggle", "tab").attr("id", o);
			a.html(materialText);
			a.click(function() {
				var typeId = $(this).attr("id");
				currentType = typeId;
				var searchModal = $("#searchModal");
				$.each(searchColumns, function(i, o) {
					searchForm.find("[name="+o+"]").val("")
				});
				globalParam = {};
				loadList({"materialQuery.type": typeId});
			});
			a.appendTo($("<li></li>").appendTo($("[item-id=tab-type]")));
		});
	}
	
	$().ready(function() {
		bindingButtonClick();
		
		settingUpload();
		settingVideoUpload();
		settingVoiceUpload();
		
		loadTypeTab();
		$("[item-id=tab-type] a:first").trigger("click");
	});

	
})