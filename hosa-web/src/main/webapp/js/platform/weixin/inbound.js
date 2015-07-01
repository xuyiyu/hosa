var wxuserMap = new HashMap();
var currentOpenId = null;


/* 房间列表   */
var roomList = function(){
	var roomQueryUrl = ctx + "/webadmin/weixin/inbound/weixin-inbound!roomlist.htm";
	$.webAjax(roomQueryUrl, {}, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$.each(data,function(i,o){
					wxuserMap.put(o.openId,o);
					addNewQueueItem(o);
				});
				
			}
		}
	});
}
/* 同意进线 */
var agreeInbound = function(openId){
	var url = ctx + "/webadmin/weixin/inbound/weixin-inbound!agreeInbound.htm";
	$.ajax({
		type : 'post',
		url : url,
		data : {'openId':openId},
		success : function(data) {}
	});
}

/* 结束聊天 */
function removeCacheRoom(openId){
	removeLocalRoom(openId);
	wxuserMap.remove(openId);
	var url = ctx + "/webadmin/weixin/inbound/weixin-inbound!removeRoom.htm";
	$.ajax({
		type : 'post',
		url : url,
		data : {'openId':openId},
		success : function(data) {
			
		}
	});
}
/* 追加一个进线用户 */
var addNewQueue = function(user){
	addNewQueueItem(user);
	
	wxuserMap.put(user.openId,user);
	checkUnreadMsg();
	
	
}

var addNewQueueItem = function(user){
	console.log('add item user:');
	console.log(user);
	console.log('add item ');
	var container = $('#chat-container');
	//显示感叹号，提示有新消息
	container.find('.new-msg-warn').show();
	var listbody = container.find(".chat-list-body");
	var template = listbody.find('li[item-template]');
	var li = template.clone();
	li.addClass("item");
	li.attr("id",user.openId);
	li.removeAttr('item-template');
	li.find("img").attr("src",user.headImgUrl);
	li.find(".name").text(user.nickName);
	li.find(".unread").attr("cnt",1).text("1");
	li.appendTo(listbody.find("ul"));
	li.click(function(){
		$('.chat-footer').find('textarea').removeAttr('disabled');
		$('#sendMsg').removeAttr('disabled');
	
		$(this).find('.unread').attr('cnt',0);
		$(this).find('.unread').hide();
		currentOpenId = $(this).attr("id");
	
		$('#user_tag').html(user.nickName);
		$('#chat-container').removeClass('open');
		$('#chat-body').find("#message-list").find('.item').remove();
		checkUnreadMsg();
		agreeInbound(currentOpenId);
		unreadMsgList(currentOpenId);
		$('#user_tab').find('.tab-pane').removeClass('active');
		$('#user_tab > #tab1').addClass('active');
		
		$('#user_info').find('label[item-id=name]').html(user.nickName);
		$('#user_info').find('label[item-id=sex]').html(user.sex==1?"男":"女");
		$('#user_info').find('label[item-id=address]').html(user.country+user.province+user.city);
		
		
	});
	li.show();
}


var checkUnreadMsg = function(){
	var users = $('.chat-list-body').find('.item');

	var totalCnt = 0 ;
	var container = $('#chat-container');
	console.log(users);
	if(users instanceof Array){
		console.log('user array');
		$.each(users,function(i,o){
			console.log(o.find('.unread').attr('cnt'));
			totalCnt += o.find('.unread').attr('cnt');
		});
		
	}else if(users.length){
		console.log('single user');
		console.log(users);
		console.log(users.find('.unread').attr('cnt'));
		totalCnt += users.find('.unread').attr('cnt');
	}
	if(totalCnt == 0){
		//显示感叹号，提示有新消息
		container.find('.new-msg-warn').hide();
	}else{
		container.find('.new-msg-warn').show();
	}
	totalCnt = parseInt(totalCnt);
	
	$('#left-group').find('b').attr('cnt',totalCnt).html(totalCnt+"");
	
	
}


var removeLocalRoom = function(useropenid){
	var user = wxuserMap.remove(useropenid);
	
	$('#chat-container').find("#"+useropenid).remove();
	if(useropenid == currentOpenId){
		var messageList = $("#message-list");
		var template = messageList.find("li[item-template]");
		var li = template.clone();
		li.addClass("item");
		li.find("img").attr("src",user.headImgUrl);
		li.find("time").text(getCurrentTime());
		li.find(".username").text("系统消息");
		li.find("span").text("该用户已退出人工服务。");
		li.removeAttr("item-template");
		li.appendTo(messageList);
		li.show();
		
		$('.chat-footer').find('textarea').attr('disabled','disabled');
		$('#sendMsg').attr('disabled','disabled');
		
	}
	
	checkUnreadMsg();
}

/* 接收客户来的消息 */
var receiveMessage = function(message,user){
	console.log("message:");
	console.log(message);
	console.log("user:");
	console.log(user);
	if(message.userOpenId == currentOpenId){
		var messageList = $("#message-list");
		var template = messageList.find("li[item-template]");
		var li = template.clone();
		li.addClass("item");
//		li.find("img").attr("src","http://img0.bdstatic.com/img/image/shouye/zqsjbtlsjb.jpg");
		li.find("img").attr("src",user.headImgUrl);
		li.find("time").text(message.createdAtString);
		console.log("message:");
		console.log(message);
		li.find(".username").text(wxuserMap.get(message.userOpenId).nickName);
		li.find("span").text(message.content);
		li.removeAttr("item-template");
		li.appendTo(messageList);
		li.show();
		$('#chat-body').scrollTop(10000);
	}else{
		var userli = $('#chat-container').find("#"+message.userOpenId).find(".unread");
		var cnt = userli.attr('cnt');
		if(isNaN(cnt)){
			cnt = 0;
		}
		cnt ++;
		userli.attr("cnt",cnt).text(cnt);
	}
	checkUnreadMsg();
	
}




var unreadMsgQueryUrl = ctx + "/webadmin/weixin/inbound/weixin-inbound!unreadMsgList.htm";

//未聊天框初始化未读消息
var unreadMsgList = function(openId){
	var param = {};
	param['openId'] = openId;
	$.webAjax(unreadMsgQueryUrl, param, function(responseData) {
		
		if(responseData.r_code == 0) {
			var data = responseData.r_data;
			if(data) {
				$('#chat-body').find('#message-list').find(".item").remove();
				var  listbody = $('#chat-body').find('#message-list')
				var template = $('#chat-body').find("#message-list").find('li[item-template]');
				$.each(data, function(i, o){
					var li = template.clone();
					li.addClass("item");
					li.attr("id",openId);
					li.removeAttr('item-template');
					li.find("img").attr("src",o.headImgUrl);
					li.find(".name").text(o.nickName);
					li.find(".unread").attr("cnt",1).text("1");
					li.appendTo(listbody.find("ul"));
					li.show();
					$('#chat-body').scrollTop(10000);
				});
			}
		}else {
			$.errorNotification(responseData.r_info);
		}
	});
}

var getCurrentTime = function(){
	var curDate = new Date();
	var year = curDate.getFullYear();
	var month = curDate.getMonth()+1;
	var day = curDate.getDate();
	var hour = curDate.getHours();
	var minute = curDate.getMinutes();
	var second = curDate.getSeconds();
	var dateString = year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
	return dateString;
}




$(function(){
	
	var sendWeixinMessages = function(content){
		var url = ctx + '/webadmin/weixin/inbound/weixin-inbound!sendWeixinMessages.htm';
		var param = {};
		param['openId']=currentOpenId;
		param['content']=content;
		$.ajax( {
			type : 'post',
			url : url,
			data : param,
			success : function(responseData) {
				if(responseData.r_code == 0) {
					var data = responseData.r_data;
				}else {
					$.errorNotification(responseData.r_info);
				}
				
			}
		});
		
	};
		
	$('.chat-footer').find('textarea').keydown(function(event){
		  if(event.keyCode ==13){
		    $("#sendMsg").click();
		    return false;
		  }
	});
	
	$('#sendMsg').click(function(){
		var content = $('.chat-footer').find('textarea').val();
		$('.chat-footer').find('textarea').val('');
		content = $.trim(content);
		console.log("content:"+content);
		
		if(content!=""){
			var messageList = $("#message-list");
			var template = messageList.find("li[item-template]");
			var li = template.clone();
			li.addClass("item");
			li.find("img").attr("src",headImageUrl);
			li.find("time").text(getCurrentTime());
			li.find(".username").text(loginId);
			li.find("span").text(content);
			li.removeAttr("item-template");
			li.appendTo(messageList);
			li.show();
			
			$('#chat-body').scrollTop(10000);
		
		
		
			sendWeixinMessages(content);
		}
		
	});
	
	
	/**
	 * 绑定列表参数
	 */
	var bindingListParam = function(o) {
		var param = {};
		if($.isEmptyObject(o)) {
			o = {
					"page.pageNo":1, 
					"page.pageSize":10, 
					"page.orderBy": "msg_id", 
					"page.order": "desc"
					};
		}
		param = o;
		return param;
	}
	
	var loadHistoryMessages = function(p) {	
		if(!currentOpenId){
			return ;
		}
		
		var queryUrl = ctx + '/webadmin/weixin/inbound/weixin-inbound!loadHistoryMessages.htm';
		var param = bindingListParam(p);
		param['openId']=currentOpenId;
		$.webAjax(queryUrl, param, function(responseData) {
			$('#history-message-list').find(".item").remove();
			console.log(responseData);
			if(responseData.r_code == 0) {
				var data = responseData.r_data;
				if(data) {
					var messageList = $("#history-message-list");
					var template = messageList.find("li[item-template]");	
					
					var currentUser = wxuserMap.get(param['openId']);
					var userNickName = "";
					var userHeadImg = "";
					if(currentUser){
						userNickName = currentUser.nickName;
						userHeadImg = currentUser.headImgUrl;
					}
					
					$.each(data.result,function(i,o){	
						if(o.type==2){//接受类型
							console.log('type 2');
							var li = template.clone();
							li.addClass("item");
							li.find("img").attr("src",userHeadImg);
							li.find("time").text(o.createdAtString);
							li.find(".username").text(userNickName);
							li.find("span").text(o.content);
							li.removeAttr("item-template");
							li.appendTo(messageList);
							li.show();
						}else{//发送类型
						//	console.log("staff");
						//	console.log(o.staff);
							var li = template.clone();
							li.addClass("item");
							li.find("img").attr("src",o.staff.headImageUrl);
							li.find("time").text(o.createdAtString);
							li.find(".username").text(o.staff.loginId);
							li.find("span").text(o.content);
							li.removeAttr("item-template");
							li.appendTo(messageList);
							li.show();
						}
					});
					$.paging({template: 'default'})				
					.paging(data, function(p) {
						param['page.pageNo'] = p.pageNo;
						param['page.pageSize'] = p.pageSize;
						param['page.orderBy'] = p.orderBy;
						param['page.order'] = p.order;
						loadHistoryMessages(param);
					});
					
					if(data.length == 0) {
						
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
						
						tr.appendTo(dataTable.find$("tbody"));		
						tr.show();
						
					}
				}
			}
		});
	}
	
	
	
	$('#history_click').click(function(){
		
		loadHistoryMessages();
	});
	
	
	roomList();
})