/*
 * 
 * 分页
 * var config = {}; 初始化配置文件
 * 
 * var paginId = id或[name=paginname]或.paginname
 * var sort = {
 * 		sortId: id或[name=sortname]或.sortname,
 * 		ascClass: asc样式，不传取默认,
 * 		descClass: desc样式，不传取默认
 * }
 * 
 * var param=  {	分页参数
 * 'page.pageNo':6,
 * 'page.pageSize':10,
 * 'page.totalCount':50,
 * 'page.totalPages':10,
 * 'page.linkPageNumbers':[4,5,6,7,8],
 * 'page.order': 'desc',
 * 'page.orderBy': 'username',}
 * 
 *
 * 
 * var callback = function(param){}; 回调函数
 * var loadCallback = function(param) {};//可为空，不传默认调用init方法的callback
 * $.paging(config).init(paginId, sort, callback).load(param, loadCallback);
 * 
 * 
 */

(function($) {

	$.paging = function(o) {
		var paging = new $.Paging(this, o);
		return paging;
	};
	
	var pagingDefaultConfig = {
			
			pageNoName: 'pageNo',					//当前页变量名称
			pageSizeName: 'pageSize',				//每页显示数变量名称
			totalCountName: 'totalCount',			//总数变量名称
			totalPagesName: 'totalPages',			//总页数变量名称
			linkPageNumbersName: 'linkPageNumbers',//链接页数变量名称
			orderName: 'order',					//排序变量名称
			orderByName: 'orderBy',					//排序字段变量名称
			template: 'default',							//模板名称
	};
	
	$.Paging = function(e, o) {
		
		var options = $.extend({}, pagingDefaultConfig, o || {});//加载配置项
		var defaultOptions =  _clone.call(this, options); //加载配置项
		var _id;
		var _element;
		var _param;
		var _callback_ = function(param){};
		var _template;
		var _data = {
				pageNo: 0,						//当前页
				pageSize: 0,					//每页显示数
				totalCount: 0,					//总数
				totalPages: 0,					//总页数
				linkPageNumbers: [],			//链接页数: [1,2,3,4,5],链接页数长度必须等于模板class=p_link_t数量+1
				order: '',						//排序
				orderBy: ''					//排序字段
		};
		
		var _sort = {
				sortId: null,
				ascClass: "sorting_asc",
				descClass: "sorting_desc",
				sortClass: "sorting"
		}
		
		var _summary;
		var _title;
		
		this.summary = function(dataSize) {
			if($("[paging-summary]")) {
				_summary = $("[paging-summary]");
			}

			_summary.find("[paging-summary-record-total]").text(dataSize);
		}
		
	
		this.paging = function(data, param1, param2) {
			var p1 = param1;
			var p2 = param2;
			if($.isFunction(param1)) {
				p1 = "";
				p2 = param1;
			}
			return _paging.call(this, data, p1, p2);
		}
		
		function _paging(param, parentObj, callback) {
			if(!$(parentObj+" [paging-data]")) {
				return;
			}
			_element = $(parentObj+" [paging-data]");
			
			if($(parentObj+" [paging-summary]")) {
				_summary = $(parentObj+" [paging-summary]");
			}
			
			if($(parentObj+" [paging-title]")) {
				_title = $(parentObj+" [paging-title]");
			}
			
			_param = param;
			
			if(callback != undefined && $.isFunction(callback)) {
				_callback_ = callback;
			}
			
			try {
				_data.pageNo = param[options.pageNoName];
				if(_data.pageNo == undefined) {
					throw new Error("pageNo 不存在");
				}
				_data.pageSize = param[options.pageSizeName];
				if(_data.pageSize == undefined) {
					throw new Error("pageSize 不存在");
				}
				_data.totalCount = param[options.totalCountName];
				if(_data.totalCount == undefined) {
					throw new Error("totalCount 不存在");
				}
				_data.totalPages = param[options.totalPagesName];
				if(_data.totalPages == undefined) {
					throw new Error("totalPages 不存在");
				}
				_data.linkPageNumbers = param[options.linkPageNumbersName];
				if(_data.linkPageNumbers == undefined) {
					throw new Error("linkPageNumbers 不存在");
				}
				_data.order = param[options.orderName];
				if(_data.order == undefined) {
					throw new Error("order 不存在");
				}
				_data.orderBy = param[options.orderByName];
				if(_data.orderBy == undefined) {
					throw new Error("orderBy 不存在");
				}
			}catch(e){
				alert('分页参数错误：' + e);
				return false;
			}
			
			
			_load.call(this, callback);
		}

		
		function _load(callback) {
	
			_loadTemplate();
			$.each(_element, function(i, n) {
				_assembly($(n));
			});
			_loadSummary();
			_loadSort();
		};
		
		function _loadTemplate() {
			var baseUrl = '';
		    
		    var es = document.getElementsByTagName("script");
		    for (var i = 0; i < es.length; i++)
		    {
		    	scriptUrl = es[i].src;
		    	var scriptName = scriptUrl.substring(scriptUrl.lastIndexOf('/') + 1);
		    	if(scriptName == 'jquery.paging.js') {
		    		baseUrl = scriptUrl.substring(0, scriptUrl.lastIndexOf('/'));
		    	}	
		    }

			var t = baseUrl + '/template/' + options.template + '.html';
			jQuery.ajax({
				url: t,
				type: 'GET',
				async: false,
				dataType: "html",
				complete: function( jqXHR, status, responseText ) {
					_template = jqXHR.responseText;
				}
			});
		}
		
		function _assembly(e) {
			e.html(_template);
			
			e.find("[paging-data-first]").off("click");
			if(_data.totalPages > 1 && _data.pageNo != 1) {
				
				e.find("[paging-data-first]").on("click", function() {
					_param[options.pageNoName] = 1;
					_callback_(_param);
				});
			} else {
				e.find("[paging-data-first]").off("click");
				e.find("[paging-data-first]").addClass("disabled");
			}
			
			e.find("[paging-data-previous]").off("click");
			if(_data.totalPages > 1 && _data.pageNo > 1) {				
				e.find("[paging-data-previous]").on("click", function() {
					_param[options.pageNoName] = _data.pageNo - 1;
					_callback_(_param);
				});
			} else {
				e.find("[paging-data-previous]").off("click");
				e.find("[paging-data-previous]").addClass("disabled");
			}
			
			e.find("[paging-data-next]").off("click");
			if(_data.totalPages > 1 && _data.pageNo < _data.totalPages) {
				e.find("[paging-data-next]").on("click", function() {
					_param[options.pageNoName] = _data.pageNo + 1;
					_callback_(_param);
				});
			} else {
				e.find("[paging-data-next]").off("click");
				e.find("[paging-data-next]").addClass("disabled");
			}
			
			e.find("[paging-data-last]").off("click");
			
			if(_data.totalPages > 1 && _data.pageNo < _data.totalPages) {
				e.find("[paging-data-last]").on("click", function() {
					_param[options.pageNoName] = _data.totalPages;
					_callback_(_param);
				});
			} else {
				console.debug(111);
				e.find("[paging-data-last]").off("click");
				e.find("[paging-data-last]").addClass("disabled");
			}			
			
			
			try {
				e.find("[paging-data-size]").off("change");
				
				e.find("[paging-data-size]").val( _data.pageSize);
				
				e.find("[paging-data-size]").on("change", function() {
					var size = $("[paging-data-size]").val();
					
					_param[options.pageSizeName] = size;

					_callback_(_param);
				});
			}catch(e) {
				console.error(e);
			}
			
			var len = _data.linkPageNumbers.length;
			e.find("[paging-data-link-current]").hide();
			e.find("[paging-data-link]").hide();
			var cnt = -1;
			$.each(_data.linkPageNumbers, function(i, n) {//循环页数
					
					
					if(n == _data.pageNo) {//页数等于当前页
						e.find("[paging-data-link-current] paging").text(n);
						e.find("[paging-data-link-current]").addClass("active");
						e.find("[paging-data-link-current] ").show();
						
						if(n != 1) {
							if($(e.find("[paging-data-link]")[cnt]).length>0) {
								$(e.find("[paging-data-link]")[cnt]).after(e.find("[paging-data-link-current]"));//移动当前页到当前显示页的后面
								$(e.find("[paging-data-link]")[cnt]).after('\n');
							}
						} 
					} else {//页数不等于当前页
						cnt++;
						if($(e.find("[paging-data-link]")[cnt]).length>0) {
							
							$(e.find("[paging-data-link] paging")[cnt]).text(n);

							$(e.find("[paging-data-link]")[cnt]).show();
							$(e.find("[paging-data-link]")[cnt]).on("click", function() {
								//alert('p_link_t:' + n);
								_param[options.pageNoName] = n;
								_callback_(_param);
							});
						}
						

					}

			});
	
		}
		
		function _loadSummary() {
			
			var currentFirst = ((_data.pageNo - 1) * _data.pageSize) + 1;
			if(_data.totalCount == 0) {
				_summary.find("[paging-summary-record-first]").text(0);
			} else {
				_summary.find("[paging-summary-record-first]").text(currentFirst);
			}
			
			var fullPage = currentFirst + _data.pageSize - 1;
			_summary.find("[paging-summary-record-last]").text(_data.totalCount < fullPage ? _data.totalCount : fullPage);
			_summary.find("[paging-summary-record-total]").text(_data.totalCount);
		
		}
		
		function _loadSort() {

			
			$.each(_title, function(i, o) {
				var _s = $(o).find("[paging-sort-column]");
				$.each(_s, function(m, n) {
					var _sortColumn = $(n).attr("paging-sort-column");
					if( typeof _sortColumn == 'string') {
						if(_sortColumn == _data.orderBy) {
							var sortClass = _sort.descClass;
							if(_data.order.toLowerCase() == 'asc') {
								sortClass = _sort.ascClass;
							} else {
								sortClass = _sort.descClass;
							}
							$(n).removeClass(_sort.ascClass);
							$(n).removeClass(_sort.descClass);
							$(n).removeClass(_sort.sortClass);
							$(n).addClass(sortClass);
						} else {
							$(n).removeClass(_sort.ascClass);
							$(n).removeClass(_sort.descClass);
							$(n).removeClass(_sort.sortClass);
							$(n).addClass(_sort.sortClass);
						}
						
					}
				})
				_s.off("click");
				_s.on("click", function() {
					console.log(11);
					var _sortColumn = $(this).attr("paging-sort-column");
					var sortClass = _sort.descClass;
					if(_sortColumn == _data.orderBy) {
						if(_data.order.toLowerCase() == 'desc') {
							_param[options.pageNoName] = 1;
							_param[options.orderName] = 'asc';
							sortClass = _sort.ascClass;
						} else {
							_param[options.pageNoName] = 1;
							_param[options.orderName] = 'desc';									
							sortClass = _sort.descClass;
						}
					} else {
						_param[options.pageNoName] = 1;
						_param[options.orderName] = 'desc';								
						sortClass = _sort.descClass;
					}
					_param[options.orderByName] = _sortColumn;
					_callback_(_param);
					_s.removeClass(_sort.ascClass);
					_s.removeClass(_sort.descClass);
					_s.removeClass(_sort.sortClass);
					$(this).addClass(sortClass);
				});
			})
			
		}
	
		function _clone(obj) {

			if (typeof (obj) != "object") {
				return obj;
			}
			var cloneDepth = ((arguments.length >= 1) ? ((isNaN(parseInt(arguments[0]))) ? (null)
					: parseInt(arguments[0]))
					: null);
			if (cloneDepth) {
				cloneDepth = ((cloneDepth <= 0) ? (null) : (cloneDepth));
			}
			var cloneObject = null;
			var thisConstructor = obj.constructor;
			var thisConstructorPrototype = thisConstructor.prototype;
			if (thisConstructor == Array) {
				cloneObject = new Array();
			} else if (thisConstructor == Object) {
				cloneObject = new Object();
			} else {
				try {
					cloneObject = new thisConstructor;
				} catch (exception) {
					cloneObject = new Object();
					cloneObject.constructor = thisConstructor;
					cloneObject.prototype = thisConstructorPrototype;
				}
			}

			var propertyName = "";
			var newObject = null;

			for (propertyName in obj) {
				newObject = obj[propertyName];
				if (!thisConstructorPrototype[propertyName]) {
					if (typeof (newObject) == "object") {
						if (newObject === null) {
							cloneObject[propertyName] = null;
						} else {
							if (cloneDepth) {
								if (cloneDepth == 1) {
									cloneObject[propertyName] = null;
								} else {
									cloneObject[propertyName] = _clone(newObject);
									(--cloneDepth);
								}
							} else {
								cloneObject[propertyName] = _clone(newObject);
							}
						}
					} else {
						cloneObject[propertyName] = newObject;
					}
				}
			}

			return cloneObject;

		};
	}
})(jQuery);


