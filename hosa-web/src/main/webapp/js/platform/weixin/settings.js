$(function() {
	var queryUrl = ctx + "/webadmin/weixin/settings/settings!list.htm";
	var saveUrl = ctx + "/webadmin/weixin/settings/settings!save.htm";
	var queryMaterialUrl = ctx + "/webadmin/weixin/settings/settings!loadMaterial.htm";
	var editForm = $("#edit-form");
	var dataTable = $("#data-table");
	var variableMap = new HashMap();
	var materialArray = new Array(); 
	var materialMap = new HashMap();
	materialMap.put("1", "文本");
	materialMap.put("2", "图片");
	materialMap.put("3", "语音");
	materialMap.put("4", "视频");
	materialMap.put("6", "图文");
	materialMap.put("7", "链接");
	
	var columns = [  "variable" ,  "val" ,   "modified"];	
	
	var loadList = function(p) {	
		var param = {};
		
		$.webAjax(queryUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					variableMap = new HashMap();
					$.each(data, function(i, o){
						variableMap.put(o.variable, o);
						/*editForm.find("[item-id="+o.variable+"]").find("name=val").val(o.val);
						editForm.find("[item-id="+o.variable+"]").find("name=modified").val(o.modified);
						editForm.find("[item-id="+o.variable+"]").find("item-id=val").text(o.val);*/
					});
					
					$.each(editForm.find("tr"), function(i, o) {
						var id = $(o).find("[name=variable]").val();
						
						var item = variableMap.get(id);
						if(item && item.val) {
							var type = $(o).find("[name=val]").attr("type");
							$(o).find("[name=val]").val(item.val);
							$(o).find("[name=modified]").val(item.modified);
							$(o).find("[item-id=val]").text(item.val);
							if(type == "select") {
								$(o).find("[item-id=val]").text($(o).find("[name=val] option:selected").text());
								
							}
							if($(o).find("[name=variable]").val() == "SETTINGS_WEIXIN_SUBSCRIBE_WELCOME") {
								if(item.val==0) {
									$(o).find("[item-id=val]").text("进线菜单");
									$(o).find("[name=type]").find("option[value=0]").attr("selected",true);
								} else {
									
									$(o).find("[name=type]").find("option[value=1]").attr("selected",true);
									$(o).find("[name=val]").show();
									loadMaterial($(o), function() {
										$(o).find("[name=val]").select2("val", item.val);
										
										var selectedData = $(o).find("[name=val]").select2("data");
										console.debug(selectedData);
										if(selectedData) {
											$(o).find("[item-id=val]").text(selectedData.text);
										} else {
											$(o).find("[item-id=val]").text("未知内容");
										}
										
									});
								}
								
							}
						} else {
							$(o).find("[item-id=val]").text("未设置");
							//$(o).find("[name=val]").find("[item-id=val]").hide();
							//$(o).find("[name=val]").show();
						}
					});
					editForm.find("tr.edit").find("[item-id=val]").off("click");
					editForm.find("tr.edit").find("[item-id=val]").on("click", function() {
						editForm.find("tr").find("[item-id=button-cancel]").trigger("click");
						var tr = $(this).parents("tr");
						$(this).hide();
						if($(this).text() != "未设置") {
							var type = tr.find("[name=val]").attr("type");
							if(type != "select") {
								tr.find("[name=val]").val($(this).text());
							}
							
						} else {
							tr.find("[name=val]").val("");
						}						
						tr.find("[item-id=editVariable]").show();
						if(tr.find("[name=variable]").val() == "SETTINGS_WEIXIN_SUBSCRIBE_WELCOME") {
							tr.find("[name=type]").change(function() {
								if($(this).val() == 0) {
									
									tr.find("[name=val]").select2("destroy");
									tr.find("[name=val] .item").remove();
									$("<option value='0' class='item' selected>---</option>").appendTo(tr.find("[name=val]"));
									tr.find("[name=val]").hide();
								} else {
									tr.find("[name=val]").show();
									loadMaterial(tr);
								}
							});
							
						}
					});
					
					editForm.find("tr.edit").find(".editable-clear-x").off("click");
					editForm.find("tr.edit").find(".editable-clear-x").on("click", function() {
						var tr = $(this).parents("tr");
						
						tr.find("[name=val]").val("");
					});
					editForm.find("tr.edit").find("[item-id=button-save]").off("click");
					editForm.find("tr.edit").find("[item-id=button-save]").on("click", function() {
						var tr = $(this).parents("tr");
						saveItem(tr, function() {
							tr.find("[item-id=button-cancel]").trigger("click");
							loadList();
						});
					});
					editForm.find("tr.edit").find("[item-id=button-cancel]").off("click");
					editForm.find("tr.edit").find("[item-id=button-cancel]").on("click", function() {
						var tr = $(this).parents("tr");
						tr.find("[item-id=val]").show();
						tr.find("[item-id=editVariable]").hide();
					});
				
				}

			}else {
				$.errorNotification(responseData.r_info);
			}
		});
	}
	
	var saveItem = function(tr, callback) {
		if(!verifySaveParam(tr)) {
			return;
		}
		var param = bindingSaveParam(tr);
		console.debug(param);
		$.webAjax(saveUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					lastModifiedId = data.id;
				}
				$.successNotification(responseData.r_info);
				if($.isFunction(callback)) {
					callback();
				}
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	}
	
	var bindingSaveParam = function(tr) {
		var param = {};
		
		$.each(columns, function(i, o) {
			var val =  $.trim(tr.find("[name="+o+"]").val());
			
			
			if(val) {
				param["settings."+o+""] = val;
			} else {
				param["settings."+o+""] = "";
			}
		});

		
		return param;
	}
	
	var verifySaveParam = function(tr) {
		var val = $.trim(tr.find("[name=val]").val());
		console.debug(val);
		if(val == "") {
			tr.find(".editable-error-block").text("不能为空！");
			tr.find(".editable-error-block").show();
			return false;
		}

		tr.find(".editable-error-block").text("");
		tr.find(".editable-error-block").hide();
		return true;
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
		form.find("[name=val] .item").remove();
		$.each(materialMap.keys(), function(i, o){
			var materialText = materialMap.get(o);
			$("<optgroup></optgroup>").attr("id", o).attr("label", materialText).addClass("item").appendTo(form.find("[name=val]"));
		});
		
		$.each(materialArray, function(i, o) {
			
			var text = o.name;
			var selected = "";
			$("<option value='"+o.id+"' "+selected+" class='item' type='"+o.type+"'>"+text+"</option>").appendTo(form.find("[name=val] #" + o.type));
			
		});
		form.find("[name=val]").select2({
			placeholder: "素材内容",
			allowClear: true
		});
		
	}
	 
	$().ready(function() {
		loadList();
	});
	
	
})