$(function(){
	jQuery.validator.addMethod("chrnum", function(value, element) {
	    var chrnum = /^([a-zA-Z0-9]+)$/;
	    return this.optional(element) || (chrnum.test(value));
	}, "只能输入数字和字母(字符A-Z, a-z, 0-9)");
	
	jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
		  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
		}, "请正确输入您的身份证号码"); 
	
	jQuery.validator.addMethod("passport", function(value, element) { 
		  return this.optional(element) || checknumber(value);     
		}, "请正确输入您的护照编号"); 
	
	jQuery.validator.addMethod("isMobile", function(value, element) { 
		  var length = value.length; 
		  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
		  return this.optional(element) || (length == 11 && mobile.test(value)); 
		}, "请正确填写您的手机号码"); 
	
	jQuery.validator.addMethod("isTel", function(value, element) { 
		  var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678 
		  return this.optional(element) || (tel.test(value)); 
		}, "请正确填写您的电话号码"); 
	
	jQuery.validator.addMethod("isPhone", function(value,element) { 
		  var length = value.length; 
		  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
		  var tel = /^\d{3,4}-?\d{7,9}$/; 
		  return this.optional(element) || (tel.test(value) || mobile.test(value)); 

		}, "请正确填写您的联系电话"); 
	
	jQuery.validator.addMethod("isZipCode", function(value, element) { 
		  var tel = /^[0-9]{6}$/; 
		  return this.optional(element) || (tel.test(value)); 
		}, "请正确填写您的邮政编码"); 
})