$(function()
{
	
	
	/*---------------- 微信信息触发事件    --------------- */
	$('.chat-listener').on('new-weixinmessage', function (event, assingAgentLognId, fromWeixinUser, toWeixinUser, weixinMessage,type,systemMessage) {
		console.log('---top---------------------------------------');
		console.log(assingAgentLognId);
		console.log(fromWeixinUser);
		console.log(toWeixinUser);
		console.log(weixinMessage);
		console.log(type);
		console.log(systemMessage);
		console.log('---down---------------------------------------');
		
		
		var container_test = $('#chat-container');
		console.log(container_test);
		if(!container_test.length){
			if(type!='leave'){
				var totalCnt = $('#left-group').find('b').attr('cnt');
				totalCnt = parseInt(totalCnt);
				totalCnt++;
				$('#left-group').find('b').attr('cnt',totalCnt).html(totalCnt+"");
			}
			return false;
			
		}
		
		if(type=='queue'){//进线
			addNewQueue(fromWeixinUser);
		}else if(type=='leave'){
			removeLocalRoom(fromWeixinUser);
		}else if(type=='message'){
			receiveMessage(weixinMessage,fromWeixinUser);
		}
		return false;
		//-----------------old ---------------------------------------------
		
	});
	
	
	/*------------------ 初始化服务器--------------------------*/
	function initServer() {
			console.log('--------init server-----------');
			var connected = false;
			$.chat = new $.Chat();
			$.chat.connect(function(message){
				//alert(message.clientId);
					console.log('chat.connect() response: ' + message.successful);
					
					if(message.successful && message.clientId ) {
						$.registerCommonListener();
						if($('.zx_online').length > 0) {//有chat权限
							if(!connected) {							
									$.registerListener();
									loginChatServer(message.clientId);
								
								connected = true;	
							} else {							
									connectChatServer(message.clientId, 1);
									$.reRegisterListener();							
							}
						}
					} else {
						alert('服务器重连中...');
						$.unRegisterCommonListener();
						if($('.zx_online').length > 0) {//有chat权限
							$.unRegisterListener();
						}
					}
					
				});

	}
	
	initServer();
	
	
	
	

})