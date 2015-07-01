$(function(){
	var spinner;
	$(document).ajaxStart(function(e){
		
	});
	$(document).ajaxStop(function(){
		$("#loading").hide();
		spinner.spin();
	});
	
	jQuery.extend({
		
		webAjax: function(url, postData, callback) {
			console.log("ajaxstart..");
		
			$("#loading").show();
			spinner = new Spinner({color: '#3d9bce'}).spin($("#loading")[0]);
			var success = function(data) {
				console.debug(data);
				if($.isFunction(callback)) {
					callback(data);
				}
			}

			$.post(url, postData, success);
			
		},
		getSpecifiedLength: function(val, length) {
			var len = 8;
			if(length) {
				len = length;
			}
			var str = val;
			cur = $.getByteLen(str); 
			if(cur > len) {
				str = $.getByteVal(val, len) + '...';
			}
			return str;
		},
		 getByteLen: function(val) { 
	    	var len = 0; 
	    	for (var i = 0; i < val.length; i++) { 
	    	if (val.charAt(i).match(/[^\x00-\xff]/ig) != null) //全角 
	    	len += 2; 
	    	else 
	    	len += 1; 
	    	} 
	    	return len; 
	    },
	    getByteVal: function (val, max) { 
	    	var returnValue = ''; 
	    	var byteValLen = 0; 
	    	for (var i = 0; i < val.length; i++) { 
		    	if (val.charAt(i).match(/[^\x00-\xff]/ig) != null) 
		    	byteValLen += 2; 
		    	else 
		    	byteValLen += 1; 
		    	if (byteValLen > max) 
		    	break; 
		    	returnValue += val.charAt(i); 
	    	} 
	    	return returnValue; 
	    },
	    successNotification: function(content, title, timeout) {
	    	if(!title) {
	    		title = "信息提示";
	    	}
	    	title = "<strong>" + title + "</strong>";
	    	if(!timeout) {
	    		timeout = 5000;
	    	}
	    	$.smallBox({
				title : title,
				content : content,
				color : "#739E73",
				icon : "fa fa-info",
				timeout : timeout
			});
	    },
	    errorNotification: function(content, title, timeout) {
	    	if(!title) {
	    		title = "信息提示";
	    	}
	    	title = "<strong>" + title + "</strong>";
	    	if(!timeout) {
	    		timeout = 5000;
	    	}
	    	$.smallBox({
	    		title : title,
				content : content,
				color : "#953b39",
				icon : "fa fa-info",
				timeout : timeout
			});
	    },
	    confirm: function(content, title, yesCallback, noCallback) {
	    	var p1 = content;
	    	var p2 = title;
	    	var p3 = yesCallback;
	    	var p4 = noCallback;
	    	if($.isFunction(title)) {
				p2 = "确认提示";
				p3 = title;
				p4 = yesCallback;
			}
	    	
	    	if(!p2) {
	    		p2 = "确认提示";
	    	}
	    	title = "<strong>" + p2 + "</strong>";
	    	$.SmartMessageBox({
				title : p2,
				content : p1,
				buttons : '[否][是]'
			}, function(ButtonPressed) {
				if (ButtonPressed === "是") {	
					if($.isFunction(p3)) {
						p3();
					}
				}
				if (ButtonPressed === "否") {
					if($.isFunction(p4)) {
						p4();
					}
				}
	
			});
	    },
	    alert: function(content, title) {
	    	var p1 = content;
	    	var p2 = title;
	    	
	    	
	    	if(!p2) {
	    		p2 = "提示";
	    	}
	    	title = "<strong>" + p2 + "</strong>";
	    	$.SmartMessageBox({
				title : p2,
				content : p1,
				buttons : '[关闭]'
			});
	    },
	    toUtf8: function (str) {   
	        var out, i, len, c;   
	        out = "";   
	        len = str.length;   
	        for(i = 0; i < len; i++) {   
	        	c = str.charCodeAt(i);   
	        	if ((c >= 0x0001) && (c <= 0x007F)) {   
	            	out += str.charAt(i);   
	        	} else if (c > 0x07FF) {   
	            	out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));   
	            	out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));   
	            	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
	        	} else {   
	            	out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));   
	            	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
	        	}   
	        }   
	        return out;   
	    }
	});
})