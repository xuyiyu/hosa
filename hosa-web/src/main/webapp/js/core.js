
/*
	 * VARIABLES
	 * Description: All Global Vars
	 */
	// Impacts the responce rate of some of the responsive elements (lower value affects CPU but improves speed)
	$.throttle_delay = 350;
	
	// The rate at which the menu expands revealing child elements on click
	$.menu_speed = 235;
	
	// Note: You will also need to change this variable in the "variable.less" file.
	$.navbar_height = 49; 

	/*
	 * APP DOM REFERENCES
	 * Description: Obj DOM reference, please try to avoid changing these
	 */	
	$.root_ = $('body');
	$.left_panel = $('#left-panel');
	$.shortcut_dropdown = $('#shortcut');
	$.bread_crumb = $('#ribbon ol.breadcrumb');

    // desktop or mobile
    $.device = null;

	/*
	 * APP CONFIGURATION
	 * Description: Enable / disable certain theme features here
	 */		
	$.navAsAjax = false; // Your left nav in your app will no longer fire ajax calls
	
	// Please make sure you have included "jarvis.widget.js" for this below feature to work
	$.enableJarvisWidgets = true;
	
	// Warning: Enabling mobile widgets could potentially crash your webApp if you have too many 
	// 			widgets running at once (must have $.enableJarvisWidgets = true)
	$.enableMobileWidgets = false;


	/*
	 * DETECT MOBILE DEVICES
	 * Description: Detects mobile device - if any of the listed device is detected
	 * a class is inserted to $.root_ and the variable $.device is decleard. 
	 */	
	
	/* so far this is covering most hand held devices */
	var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));

	if (!ismobile) {
		// Desktop
		$.root_.addClass("desktop-detected");
		$.device = "desktop";
	} else {
		// Mobile
		$.root_.addClass("mobile-detected");
		$.device = "mobile";
		
		// Removes the tap delay in idevices
		// dependency: js/plugin/fastclick/fastclick.js 
		//FastClick.attach(document.body);
	}
	
	
$(document).ready(function() {
	// COLLAPSE LEFT NAV
	$(".minifyme").click(function(e) {
		$("body").toggleClass("minified");
		$(this).effect("highlight", {}, 500);
		e.preventDefault();
	});
	// RESET WIDGETS
	$("#refresh").click(function(e) {
		$.SmartMessageBox({
			title : "<i class='fa fa-refresh' style='color:green'></i> Clear Local Storage",
			content : "Would you like to RESET all your saved widgets and clear LocalStorage?",
			buttons : "[No][Yes]"
		}, function(ButtonPressed) {
			if (ButtonPressed == "Yes" && localStorage) {
				localStorage.clear();
				location.reload();
			}
	
		});
		e.preventDefault();
	});
	/*
	 * Fire tooltips
	 */
	if ($("[rel=tooltip]").length) {
		$("[rel=tooltip]").tooltip();
	}
	
	// HIDE MENU
	$("#hide-menu >:first-child > a").click(function(e) {
		$("body").toggleClass("hidden-menu");
		if($("body").hasClass("hidden-menu")) {
			$(this).find("i").removeClass("fa-resize-full");
			$(this).find("i").addClass("fa-resize-small");
		} else {
			$(this).find("i").removeClass("fa-resize-small");
			$(this).find("i").addClass("fa-resize-full");
		}
		e.preventDefault();
	});
});


/*
 * CUSTOM MENU PLUGIN
 */

$.fn.extend({

	//pass the options variable to the function
	jarvismenu : function(options) {

		var defaults = {
			accordion : 'true',
			speed : 200,
			closedSign : '[+]',
			openedSign : '[-]'
		};

		// Extend our default options with those provided.
		var opts = $.extend(defaults, options);
		//Assign current element to variable, in this case is UL element
		var $this = $(this);

		//add a mark [+] to a multilevel menu
		$this.find("li").each(function() {
			if ($(this).find("ul").size() != 0) {
				//add the multilevel sign next to the link
				$(this).find("a:first").append("<b class='collapse-sign'>" + opts.closedSign + "</b>");

				//avoid jumping to the top of the page when the href is an #
				if ($(this).find("a:first").attr('href') == "#") {
					$(this).find("a:first").click(function() {
						return false;
					});
				}
			}
		});

		//open active level
		$this.find("li.active").each(function() {
			$(this).parents("ul").slideDown(opts.speed);
			$(this).parents("ul").parent("li").find("b:first").html(opts.openedSign);
			$(this).parents("ul").parent("li").addClass("open")
		});

		$this.find("li a").click(function() {

			if ($(this).parent().find("ul").size() != 0) {

				if (opts.accordion) {
					//Do nothing when the list is open
					if (!$(this).parent().find("ul").is(':visible')) {
						parents = $(this).parent().parents("ul");
						visible = $this.find("ul:visible");
						visible.each(function(visibleIndex) {
							var close = true;
							parents.each(function(parentIndex) {
								if (parents[parentIndex] == visible[visibleIndex]) {
									close = false;
									return false;
								}
							});
							if (close) {
								if ($(this).parent().find("ul") != visible[visibleIndex]) {
									$(visible[visibleIndex]).slideUp(opts.speed, function() {
										$(this).parent("li").find("b:first").html(opts.closedSign);
										$(this).parent("li").removeClass("open");
									});

								}
							}
						});
					}
				}// end if
				if ($(this).parent().find("ul:first").is(":visible") && !$(this).parent().find("ul:first").hasClass("active")) {
					$(this).parent().find("ul:first").slideUp(opts.speed, function() {
						$(this).parent("li").removeClass("open");
						$(this).parent("li").find("b:first").delay(opts.speed).html(opts.closedSign);
					});

				} else {
					$(this).parent().find("ul:first").slideDown(opts.speed, function() {
						/*$(this).effect("highlight", {color : '#616161'}, 500); - disabled due to CPU clocking on phones*/
						$(this).parent("li").addClass("open");
						$(this).parent("li").find("b:first").delay(opts.speed).html(opts.openedSign);
					});
				} // end else
			} // end if
		});
	} // end function
});

/* ~ END: CUSTOM MENU PLUGIN */


/*
 * RESIZER WITH THROTTLE
 * Source: http://benalman.com/code/projects/jquery-resize/examples/resize/
 */

(function($, window, undefined) {

	var elems = $([]), jq_resize = $.resize = $.extend($.resize, {}), timeout_id, str_setTimeout = 'setTimeout', str_resize = 'resize', str_data = str_resize + '-special-event', str_delay = 'delay', str_throttle = 'throttleWindow';

	jq_resize[str_delay] = $.throttle_delay;

	jq_resize[str_throttle] = true;

	$.event.special[str_resize] = {

		setup : function() {
			if (!jq_resize[str_throttle] && this[str_setTimeout]) {
				return false;
			}

			var elem = $(this);
			elems = elems.add(elem);
			$.data(this, str_data, {
				w : elem.width(),
				h : elem.height()
			});
			if (elems.length === 1) {
				loopy();
			}
		},
		teardown : function() {
			if (!jq_resize[str_throttle] && this[str_setTimeout]) {
				return false;
			}

			var elem = $(this);
			elems = elems.not(elem);
			elem.removeData(str_data);
			if (!elems.length) {
				clearTimeout(timeout_id);
			}
		},

		add : function(handleObj) {
			if (!jq_resize[str_throttle] && this[str_setTimeout]) {
				return false;
			}
			var old_handler;

			function new_handler(e, w, h) {
				var elem = $(this), data = $.data(this, str_data);
				data.w = w !== undefined ? w : elem.width();
				data.h = h !== undefined ? h : elem.height();

				old_handler.apply(this, arguments);
			};
			if ($.isFunction(handleObj)) {
				old_handler = handleObj;
				return new_handler;
			} else {
				old_handler = handleObj.handler;
				handleObj.handler = new_handler;
			}
		}
	};

	function loopy() {
		timeout_id = window[str_setTimeout](function() {
			elems.each(function() {
				var elem = $(this), width = elem.width(), height = elem.height(), data = $.data(this, str_data);
				if (width !== data.w || height !== data.h) {
					elem.trigger(str_resize, [data.w = width, data.h = height]);
				}

			});
			loopy();

		}, jq_resize[str_delay]);

	};

})(jQuery, this);

/*
* NAV OR #LEFT-BAR RESIZE DETECT
* Description: changes the page min-width of #CONTENT and NAV when navigation is resized.
* This is to counter bugs for min page width on many desktop and mobile devices.
* Note: This script uses JSthrottle technique so don't worry about memory/CPU usage
*/

// Fix page and nav height
function nav_page_height() {
	var setHeight = $('#main').height();
	//menuHeight = $.left_panel.height();
	
	var windowHeight = $(window).height() - $.navbar_height;
	//set height

	if (setHeight > windowHeight) {// if content height exceedes actual window height and menuHeight
		$.left_panel.css('min-height', setHeight + 'px');
		$.root_.css('min-height', setHeight + $.navbar_height + 'px');

	} else {
		$.left_panel.css('min-height', windowHeight + 'px');
		$.root_.css('min-height', windowHeight + 'px');
	}
}

$('#main').resize(function() {
	nav_page_height();
	check_if_mobile_width();
})
$('nav').resize(function() {
	nav_page_height();
})

function check_if_mobile_width() {
	if ($(window).width() < 979) {
		$.root_.addClass('mobile-view-activated')
	} else if ($.root_.hasClass('mobile-view-activated')) {
		$.root_.removeClass('mobile-view-activated');
	}
}


//custom
function loadMainContent(url, name, text) {
	var div = $("<div></div>");
	div.attr("id", name).attr("text", text);
	div.addClass("main-content");
	div.fadeOut("fast");
	div.load(url, {}, function() {
		div.fadeIn("slow");
	});
	$("#main .main-content").remove();
	div.appendTo($("#main"));
}

function settingCheckAll() {
	 $("input[name=check-all]").click(
			 function() {
				 var checkbox = $(this).parents("table").find(
							"input[name=checkRow]:visible");
				 if ($(this).is(":checked")) {
					 checkbox.prop("checked", true);
				 } else {
					 checkbox.prop("checked", false);
				 }
	});
}

function getTableJSONVal(jsonObj, key) {
	if(key.indexOf(".") != -1) {
		var k = key.substring(0, key.indexOf("."));
		var m = key.substring(key.indexOf(".") + 1);
		if(jsonObj[k]) {
			return getTableJSONVal(jsonObj[k], m);
		} else {
			return "";
		}	    		
	} else {
		return jsonObj[key] == null?"":jsonObj[key];
	}
}