
(function($)
{
	
	$.extend({
    	registerListener: function(reRegister) {

    		if($.chat) {
    			console.log('[listener] chat register');
    			
    			if(!reRegister){
    				//1.添加座席登录监听
        			console.log('[listener] 添加座席登录监听');
        			$.chat.addLoginListener(loginId, function(message){
    					console.log('[listener] LoginListener() response: result=' + message.data.result);
    					console.log('[listener] LoginListener() response: callbackLoginId=' + message.data.callbackLoginId);
    					
    					if(message.data.callbackLoginId == loginId) {//登录成功
    						
    						if(message.data.result == 'success') {
    							$('.chat-listener').trigger('change-status', ['online']);//top.js
    						} else {
    							console.error('[listener] LoginListener() response: 座席登入chat服务器失败。');
    						}
    					} 
    				});
    			}
    			
    			
    			//2.添加座席修改状态监听
    			console.log('[listener] 添加座席修改状态监听');
    			$.chat.addChangeStatusListener(loginId, function(message){
					console.log('[listener] ChangeStatusListener() response: result=' + message.data.result);
					console.log('[listener] ChangeStatusListener() response: callbackLoginId=' + message.data.callbackLoginId);
					
					if(message.data.callbackLoginId == loginId) {	
						if(message.data.result == 'success') {
							console.log('ChangeStatusListener() response: status=' + message.data.status);
							$('.chat-listener').trigger('change-status-display', [message.data.status, true]);//top.js
						} else {
							console.error('[listener] ChangeStatusListener() response: 座席改变状态失败。');
							alert('改变座席状态失败');
						}
					} 
				});
    			
    			//3.添加座席登入queue监听
    			console.log('[listener] 添加座席登入queue监听');
    			$.chat.addQueueJoinListener(loginId, function(message){
					console.log('[listener] QueueJoinListener() response: result=' + message.data.result);
					console.log('[listener] QueueJoinListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {//成功
						if(message.data.result != 'success') {
							console.error('[listener] QueueJoinListener() response: 座席登入queue失败。');
							alert('加入业务组失败');
						}else{
							//**********showQueueJoin(message.data.queueName);
							$('.chat-listener').trigger('change-queue-display', [message.data.queueName, true]);//top.js
						}
					} 
				});
    			//3.1 离开queue
    			console.log('[listener] 座席登出queue监听');
    			$.chat.addQueueLeaveListener(loginId, function(message){
					console.log('[listener] addQueueLeaveListener() response: result=' + message.data.result);
					console.log('[listener] addQueueLeaveListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId ) {//成功
						if(message.data.result != 'success') {
							console.error('[listener] addQueueLeaveListener() response: 座席登出queue失败。');
							alert('退出业务组失败');
						}else{
							//showQueueLeave(message.data.queueName);
							$('.chat-listener').trigger('change-queue-display', [message.data.queueName, true]);//top.js
						}
					} 
				});
    			
    			//4.添加queue中通知派发的监听
    			console.log('[listener] 添加queue中通知派发的监听');
    			$.chat.addQueueOfferReceivedListener(loginId, function(message){
					console.log('[listener] QueueOfferReceivedListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var offerId = message.data.offerId;//通知ID
						
						$('.chat-listener').trigger('received-offer', [offerId]);//top.js
						
						//*********var li = $('<li></li>');//通知起泡
						//li.addClass('ct-newmsg');
						//li.attr('id',offerId);
						//li.click(function(){//接受此通知
						//	acceptOffer(offerId);
						//});
						//console.log('[listener] QueueOfferReceivedListener() response: offerId=' + offerId);
						//console.log('[listener] QueueOfferReceivedListener() response: offer tab =' + $('#chat-tabs #' + offerId).attr('id'));
						//if(!$('#chat-tabs #' + offerId).attr('id')) {//如果此通知起泡不存在，加载到左侧页面
						//	$('#chat-tabs').append(li);
						//*********}
						
					}				
				});
    			
    			//5.添加queue中通知收回的监听
    			console.log('[listener] 添加queue中通知收回的监听');
    			$.chat.addQueueOfferRevokedListener(loginId, function(message){
					console.log('[listener] QueueOfferRevokedListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var offerId = message.data.offerId;
						console.log('[listener] QueueOfferRevokedListener() response: offerId=' + offerId);
						$('.chat-listener').trigger('revoked-offer', [offerId]);//top.js
						//*********$('#chat-tabs #' + offerId).remove();
					}					
				});
    			
    			//6.添加房间创建的监听
    			console.log('[listener] 添加房间创建的监听');
    			$.chat.addRoomCreatedListener(loginId, function(message){
					console.log('[listener] RoomCreatedListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var roomId = message.data.roomId;
						var nickName = message.data.nickName;
						var dataMap = message.data.dataMap;
						console.log('[listener] RoomCreatedListener() response: roomId=' + roomId);
						console.log('[listener] RoomCreatedListener() response: nickName=' + nickName);
						console.log('[listener] RoomCreatedListener() response: dataMap=' + dataMap);
						console.log(dataMap);
//						currentRooms.put(roomId, nickName);
						//创建房间div
						$('.label-message').trigger('new-room', [roomId, nickName, dataMap]);//message.js
						//*********createRoom(roomId, nickName,message.data.dataMap);
						//创建房间div
						
						//添加房间消息监听
						$.chat.addMessageListener(loginId, roomId, function(message){
							console.log('[listener] MessageListener() response: callbackLoginId=' + message.data.callbackLoginId);
							if(message.data.callbackLoginId == loginId) {
								var content = message.data.content;
								var nickName = message.data.nickName;
								var sendDateTime = message.data.sendDateTime;
								var isAgent = message.data.isAgent =='1';
								var isSelf = message.data.isSelf;
								//alert('addMessageListener:'+message.data.content);
								//*********if($('#content_' + roomId).is(":hidden")) {//如果该房间没有显示，设置通知起泡颜色
								//	$('#tab_'+roomId).addClass('ct-cur');
								//*********}
								$('.label-message').trigger('new-message', [roomId, content, nickName, sendDateTime, isAgent, isSelf]);//message.js
								//加载聊天内容
								//$('#content_' + roomId + ' .chat-record').append('&nbsp;' + nickName + '&nbsp;('+sendDateTime+'):<br/>&nbsp;&nbsp;&nbsp;&nbsp;' + message.data.content + '<br/><br/>');
								//*********var chatContentDiv = $('#content_' + roomId + ' .chat-record');
								//*********var isAgent = message.data.isAgent =='1';
								//*********showChatMessage(nickName,content,sendDateTime,isAgent,chatContentDiv);
								//*********$('#content_' + roomId + ' .chat-record').scrollTop($('#content_' + roomId + ' .chat-record')[0].scrollHeight - $('#content_' + roomId + ' .chat-record').outerHeight() + 50);							
							}
						});
						
						
					}
				
					//房间创建成功
					
				});
    			
    			//7.添加房间关闭的监听
    			console.log('[listener] 添加房间关闭的监听');
    			$.chat.addRoomLeaveListener(loginId, function(message){
					console.log('[listener] RoomLeaveListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var roomId = message.data.roomId;
						console.log('[listener] RoomLeaveListener() response: roomId=' + roomId);
						$.chat.removeMessageListener(roomId);
						$('.label-message').trigger('end-room', [roomId]);
					}
				});
    			
    			//8.添加会议、转接邀请的监听
    			console.log('[listener] 添加会议、转接邀请的监听');
    			$.chat.addRoomInviteListener(loginId, function(message){
					console.log('[listener] RoomInviteListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var roomId = message.data.roomId;
						var msg = message.data.message;
						var fromLoginId = message.data.fromLoginId;
						var toLoginId = message.data.toLoginId;
						var inviteFlag = message.data.inviteFlag;
						console.log('[listener] RoomInviteListener() response: roomId=' + roomId);
						console.log('[listener] RoomInviteListener() response: msg=' + msg);
						console.log('[listener] RoomInviteListener() response: fromLoginId=' + fromLoginId);
						console.log('[listener] RoomInviteListener() response: toLoginId=' + toLoginId);
						console.log('[listener] RoomInviteListener() response: inviteFlag=' + inviteFlag);
						var pu_title = '';
						if(inviteFlag == 'conference') {
							$('.chat-listener').trigger('invite-conference', [roomId, msg, fromLoginId, toLoginId]);//top.js
							return;
							//pu_title = '会议邀请提示';
						} else if(inviteFlag == 'transfer') {
							$('.chat-listener').trigger('invite-transfer', [roomId, msg, fromLoginId, toLoginId]);//top.js
							return;
							//pu_title = '转接提示';
						}
						if(inviteFlag == 'accept') {	
							var msg = '座席 ' + toLoginId + ' 接受了您的请求';
							$('.chat-listener').trigger('invite-prompt', [roomId, msg, fromLoginId, toLoginId]);//top.js
							return;
							
							//openPrompt(pu_title, '座席 ' + toLoginId + ' 接受了您的邀请', '');
							//return;
						} else if(inviteFlag == 'reject') {
							var msg = '座席 ' + toLoginId + ' 拒绝了您的请求';
							$('.chat-listener').trigger('invite-prompt', [roomId, msg, fromLoginId, toLoginId]);//top.js
							return;
							//openPrompt(pu_title, '座席 ' + toLoginId + ' 拒绝了您的邀请', '');
							//return;
						}
						var url = '';
						var promptObj = null;
						var promptSpan = $('<span></span>');
						var promptAccept = $('<input type="button" id="invitePromptAccept" value="接受" class="btn-normal">');
						promptAccept.bind('click', 
								function(){
									if(inviteFlag == 'conference') {
										url = ctx + '/chat/room!acceptInviteConerence.htm';
									} else if(inviteFlag == 'transfer') {
										url = ctx + '/chat/room!acceptInviteTransfer.htm';
									}
									console.log('[listener] RoomInvite accept() request');
									$.webAjax( {
										type : 'post',
										url : url,
										data : {'roomId':roomId, 'fromLoginId':fromLoginId, 'toLoginId':toLoginId},
										success : function(data) {
											console.log('[listener] RoomInvite accept() response: data=' + data);
										}
									});
									closePrompt(promptObj);
								});
						promptSpan.append(promptAccept);
						promptSpan.append('&nbsp;&nbsp;&nbsp;');
						var promptReject = $('<input type="button" id="invitePromptReject" value="拒绝" class="btn-normal">');
						promptReject.bind('click', 
								function(){
									if(inviteFlag == 'conference') {
										url = ctx + '/chat/room!rejectInviteConerence.htm';
									} else if(inviteFlag == 'transfer') {
										url = ctx + '/chat/room!rejectInviteTransfer.htm';
									}
									console.log('[listener] RoomInvite reject() request');
									$.webAjax( {
										type : 'post',
										url : url,
										data : {'roomId':roomId, 'fromLoginId':fromLoginId, 'toLoginId':toLoginId},
										success : function(data) {
											console.log('[listener] RoomInvite reject() response: data=' + data);
										}
									});
									closePrompt(promptObj);
								});
						promptSpan.append(promptReject);
						promptObj = openPrompt(pu_title, msg, promptSpan);
						
						
					}
				});
    			
    			//9.添加房间参与者的监听
    			console.log('[listener] 添加房间参与者的监听');
    			$.chat.addParticipantListener(loginId, function(message){//添加参与者的监听
					console.log('[listener] ParticipantListener() response: callbackLoginId=' + message.data.callbackLoginId);
					var isAgent = message.data.isAgent;
					var isJoin = message.data.isJoin;
					var nickName = message.data.nickName;
					var roomId = message.data.roomId;
					var dateTime = message.data.dateTime;
					var isSelf = message.data.isSelf;
					console.log('[listener] ParticipantListener() response: isAgent=' + isAgent);
					console.log('[listener] ParticipantListener() response: isJoin=' + isJoin);
					console.log('[listener] ParticipantListener() response: isSelf=' + isSelf);
					console.log('[listener] ParticipantListener() response: nickName=' + nickName);
					console.log('[listener] ParticipantListener() response: roomId=' + roomId);
					console.log('[listener] ParticipantListener() response: dateTime=' + dateTime);
					if(message.data.callbackLoginId == loginId) {
						//检测房间是否已经打开
//						var cnt = 0;
						$('.label-message').trigger('change-participant', [roomId, nickName, dateTime, isAgent, isJoin, isSelf]);
						
						return;
					
						
						
					}
				});
    			
    			//10.添加可用座席的监听
    			console.log('[listener] 添加获取可用座席的监听');
    			$.chat.addAvailableAgentsListener(loginId, function(message){
					console.log('[listener] AvailableAgentsListener() response: callbackLoginId=' + message.data.callbackLoginId);
					if(message.data.callbackLoginId == loginId) {
						var result = message.data.result;
						var availableAgentList = message.data.availableAgentList;
						var roomId = message.data.roomId;
						var availableAgents = message.data.availableAgents;
						console.log('[listener] AvailableAgentsListener() response: result=' + result);
						console.log('[listener] AvailableAgentsListener() response: availableAgentList=' + availableAgentList);
						if(result == 'success') {
							$('.label-message').trigger('available-agents', [roomId, availableAgentList]);
							return;

						} else {
							console.error('[listener] AvailableAgentsListener() response: 获取可用座席失败');
							alert('获取可用座席失败');
//							$(".maskbox").hide();
						}
						
					}
				});
    			//10.添加座席退出的监听
    			console.log('[listener] 添加座席退出监听');
    			$.chat.addLogoutListener(loginId, function(message){
					console.log('[listener] logoutListener() response: result=' + message.data.result);
					console.log('[listener] logoutListener() response: callbackLoginId=' + message.data.callbackLoginId);
					
					if(message.data.callbackLoginId == loginId) {//登录成功
						
						if(message.data.result == 'success') {
							alert('您已被管理员强制退出，请重新登录。','', function(){logout(true);});
							//logout(true);
						} else {
							console.error('[listener] logoutListener() response: 座席退出chat服务器失败。');
						}
					} 
				});
    			
    		
    			return;
    		
    		} else {
    			console.error('[listener] chat not initialized');
    		}
    	},
    	reRegisterListener: function() {
    		$.registerListener(true);
    	},
    	unRegisterListener: function() {
//    		$.chat.removeLoginListener();
//    		$.chat.removeChangeStatusListener();
    		$.chat.removeQueueJoinListener();
			$.chat.removeQueueOfferReceivedListener();
			$.chat.removeQueueOfferRevokedListener();
			$.chat.removeRoomCreatedListener();
			$.chat.removeRoomLeaveListener();
			$.chat.removeRoomInviteListener();
			$.chat.removeParticipantListener();
			$.chat.removeLogoutListener();
    	},
    	registerCommonListener: function(){
    		//11.添加私信新消息的监听
			console.log('[listener] 添加私信新消息的监111听');
			console.log('loginId:'+loginId); 
			$.chat.addDirectMessageListener(loginId, function(message){
				console.log('[listener] directMessageListener() response: result=' + message.data.result);
				console.log('[listener] directMessageListener() response: callbackLoginId=' + message.data.callbackLoginId);
				console.log('[listener] directMessageListener() response: tenantId=' + message.data.tenantId);
				if(message.data.tenantId == tenantId) {
					if(message.data.callbackLoginId == loginId || message.data.callbackLoginId == 'all') {
						console.log(loginId);
						if(message.data.result == 'success') {
							var assingAgentLognId = message.data.assingAgentLognId;
							var customerId = message.data.customerId;
							$('.chat-listener').trigger('new-directmessage', [assingAgentLognId, customerId, message.data]);
						} else {
							console.error('[listener] directMessageListener() response: ' + message.data.result);
						}
					} 
				}
				
			});
			
			console.log('[listener] 添加私信新消息的监听');
			$.chat.addWeixinMessageListener(loginId, function(message){
				console.log("ctx"+ctx);
				console.log('[listener] weixinMessageListener() response: result=' + message.data.result);
				console.log('[listener] weixinMessageListener() response: callbackLoginId=' + message.data.callbackLoginId);
				console.log('[listener] weixinMessageListener() response: tenantId=' + message.data.tenantId);
				if(message.data.tenantId == tenantId) {
					if(message.data.callbackLoginId == loginId || message.data.callbackLoginId == 'all') {
						console.log(loginId);
						console.log(message.data.result);
						
						if(message.data.result == 'success') {
							var assignAgentLoginId = message.data.assignAgentLoginId;
							var weixinMessage = message.data.weixinMessage;
							var fromWeixinUser = message.data.fromWeixinUser;
							var toWeixinUser = message.data.toWeixinUser;
							var systemMessage = message.data.systemMessage;
							var type=message.data.type;//system:系统通知，message：聊天消息，queue:进线消息,leave:退出
							console.log(type);
							var heartbeat=message.data.heartbeat;
							console.log(heartbeat);
							if(type == "queue"){
								
								var url = ctx+'/heartbeat.htm';
								console.log('heartbeat=='+heartbeat);
								
								$.ajax( {
									type : 'post',
									url : url,
									data : {'uuid':heartbeat},
									success : function(data){}
								});
							}
							
							$('.chat-listener').trigger('new-weixinmessage', [assignAgentLoginId, fromWeixinUser, toWeixinUser, weixinMessage, type,systemMessage]);
						} else {
							console.error('[listener] weixinMessageListener() response: ' + message.data.result);
						}
					} 
				}
				
			});
    	},
    	unRegisterCommonListener: function() {
    		$.chat.removeDirectMessageListener();
    		$.chat.removeWeixinMessageListener();
    	}
    });
   

})(jQuery);