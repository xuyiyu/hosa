$(function () { 
	
	Array.prototype.del = function(n){
		if(n<0){
			return this;
		}
		else{
			return this.slice(0, n).concat(this.slice(n+1, this.length));
		}
	}
	
	
    HashMap = function () { 
    var index = 0; 
    var content = ''; 
    var keyV = new Array(); 
    var valueV = new Array(); 
    //向map中添加key，value键值对 
        this.put = function (key,value) { 
            if(key == undefined || key.Trim == '') { 
            return; 
            } 
            if(value == undefined || value.Trim == '') { 
            return; 
            } 
            var k = "{" + key + "}";
            if(content.indexOf(k) == -1) { 
            keyV[index] = key; 
            valueV[index++] = value; 
            content += k + ';'; 
            } else { 
            var contents = content.split(';'); 
            for(var i = 0; i < contents.length - 1; i++) { 
            if(k == contents[i]) { 
            valueV[i] = value; 
            break; 
            } 
            } 
            } 
        }; 
        //根据key获取value值 
        this.get = function(key) { 
        if(key == undefined || key.Trim == '') { 
            return; 
            } 
        key = "{" + key + "}";
        var contents = content.split(';'); 
        for(var i = 0; i < contents.length - 1; i++) { 
        if(key == contents[i]) { 
        return valueV[i]; 
        } 
        } 
        return ''; 
        }; 
        //判断是否包含制定的key值 
        this.containsKey = function(key) { 
        if(key == undefined || key.Trim == '') { 
            return false; 
            } 
        key = "{" + key + "}";
        var contents = content.split(';'); 
        for(var i = 0; i < contents.length - 1; i++) { 
        if(key == contents[i]) { 
        return true; 
        } 
        } 
        return false; 
        }; 
        //判断map是否为空 
        this.isEmpty = function() { 
        if(keyV.length == 0) { 
        return true; 
        } else { 
        return false; 
        } 
        }; 
        //获取该map的大小 
        this.size = function() { 
        return keyV.length; 
        }; 
        this.values = function() { 
            return valueV; 
        }; 
        this.keys = function() { 
            return keyV; 
        }; 
        //通过key删除元素
        this.remove = function(key){
        	  if(key == undefined || key.Trim == '') { 
                  return; 
                  } 
        	  key = "{" + key + "}";
              var contents = content.split(';'); 
              for(var i = 0; i < contents.length - 1; i++) { 
            	  if(key == contents[i]) {
            		  var _value = valueV[i]; 
            		  
            		  contents  = contents.del(i);
            		  content = contents.join(";");
            		  
            		  
            		  
            		  keyV = keyV.del(i);
            		  valueV = valueV.del(i); 
            		  return _value;
            	  } 
              }
        	
        }
    }; 
}); 