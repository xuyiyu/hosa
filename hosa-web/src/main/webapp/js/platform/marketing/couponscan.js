$(function() {
	var globalParam = {};
	
	
	var saveUrl = ctx + "/webadmin/marketing/couponscan/coupon-scan!saveBaideli.htm";
	var viewUrl = ctx + "/webadmin/marketing/couponscan/coupon-scan!viewScan.htm";
	
	var editForm = $("#edit-form");
	var viewForm = $("#couponView");
	
	var columns = [  "id" ,  "userId" ,  "type" ,  "level" ,  "valid" ,  "availableOver" ,  "idCard" ,  "plate" ,  "card" ,  "createdAt" ,  "integration" ,  "models" ,  "discount" ,  "frameNo" ,  "modified", "name", "email", "mobile", "birthday", "gender", "source"];	
	var searchColumns = [  "userId" ,  "type" ,  "level" ,  "valid" ,  "availableOver" ,  "idCardLike" ,  "plateLike" ,  "cardLike" ,  "createdAt" ,  "integration" ,  "modelsLike" ,  "discount" ,  "frameNoLike" ,  "modified", "nameLike", "email", "mobileLike", "birthday", "gender", "source", "groupId"];
	var filterColumns = [  "filter_userId" ,  "filter_type" ,  "filter_level" ,  "filter_valid" ,  "filter_availableOver" ,  "filter_idCard" ,  "filter_plate" ,  "filter_card" ,  "filter_createdAt" ,  "filter_integration" ,  "filter_models" ,  "filter_discount" ,  "filter_frameNo" ,  "filter_modified", "filter_name", "filter_email", "filter_mobile", "filter_birthday", "filter_gender", "filter_source"];
	

	var viewItem = function() {	
		var param = {};
		param["code"] = editForm.find("[name=code]").val();
		$.webAjax(viewUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				console.log(data);
				if(data) {
					
					var categoriesString = "";
					$.each(data.coupon.categories,function(i,o){
						categoriesString += o.name +",";
						
					});
					if(categoriesString.length>0){
						categoriesString = categoriesString.substring(0,categoriesString.length-1);
					}
					viewForm.find("[name=categoriesString]").text(categoriesString);
					viewForm.find("[name=ticketCardView]").css("backgroundColor",data.coupon.style);
					$.each(viewForm.find("[item-id]"), function(i, o) {
						var id = $(o).attr("item-id");
						var val = getTableJSONVal(data.coupon, id);
						
						$(o).text(val);
					});
					
					if(data.baideliUser){
						$.each(columns, function(i, o) {
							editForm.find("[name="+o+"]").val(data.baideliUser[o]);
						});
					}

					if(data.weixinUsers){
					
							editForm.find("[name=nickName]").val(data.weixinUsers["nickName"]);
						
					}
					$("#recordsId").val(data.id);
					
					$("#step2").show();
					$("#step1").hide();
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
//		if(!verifySaveParam()) {
//			return;
//		}
		
		var param = bindingSaveParam();
		
		//param["status"] = editForm.find("[name=status]").val();
		
		console.log(param);
	
		
		$.webAjax(saveUrl, param, function(responseData) {
			
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					lastModifiedId = data.id;
				}
				$.successNotification(responseData.r_info);
				
			}else {
				$.errorNotification(responseData.r_info);
			}
		});
		
	}
	
	var bindingSaveParam = function() {
		var param = {};
		
		$.each(columns, function(i, o) {
			var val =  $.trim(editForm.find("[name="+o+"]").val());
			if(val) {
				param["baideliUser."+o+""] = val;
			} else {
				param["baideliUser."+o+""] = "";
			}
		});
		
		param["id"] = $("#recordsId").val();
		
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
					userId : {
						required : true
					},
					type : {
						required : true
					},
					level : {
						required : true
					},
					valid : {
						required : true
					},
					availableOver : {
						required : true
					},
					idCard : {
						required : true
					},
					plate : {
						required : true
					},
					card : {
						required : true
					},
					createdAt : {
						required : true
					},
					integration : {
						required : true
					},
					models : {
						required : true
					},
					discount : {
						required : true
					},
					frameNo : {
						required : true
					},
					modified : {
						required : true
					},
					
					name : {
						required : true
					},
					email : {
						required : true,
						email: true
					},
					mobile : {
						required : true,
						isPhone: true
					},
					birthday : {
						required : true
					},
				},

				// Messages for form validation
				messages : {
					id : {
						required : '请输入编号'
					},
					userId : {
						required : '请输入用户编号'
					},
					type : {
						required : '请输入类型{1：标准会员，2：正式会员}'
					},
					level : {
						required : '请输入级别{0：准会员，1：普通会员，2：vip，3：金卡，4：银卡}'
					},
					valid : {
						required : '请输入有效期'
					},
					availableOver : {
						required : '请输入可用余额'
					},
					idCard : {
						required : '请输入身份证号'
					},
					plate : {
						required : '请输入车牌号'
					},
					card : {
						required : '请输入会员卡'
					},
					createdAt : {
						required : '请输入创建时间'
					},
					integration : {
						required : '请输入积分'
					},
					models : {
						required : '请输入车型'
					},
					discount : {
						required : '请输入折扣'
					},
					frameNo : {
						required : '请输入车架号'
					},
					modified : {
						required : '请输入最后修改时间'
					},
					
					name : {
						required : '请输入姓名'
					},
					email : {
						required : '请输入邮箱',
						email: '请输入有效的邮箱'
					},
					mobile : {
						required : '请输入联系方式',
						isPhone: '请输入有效的联系方式'
					},
					birthday : {
						required : '请输入出生日期'
					},
				},

				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			
			});
			 
			 return editForm.valid();
	}
	
	
	$().ready(function() {
		$("[item-id=button-toolbar-view]").click(function(){
			viewItem();
		});
		$("[item-id=button-save]").click(function(){
			saveItem();
		});
		
	});
	
	
})