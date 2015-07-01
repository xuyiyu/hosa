(function($)
{
	var chatDefaultConfig = {
		contextPath : ctx
	}

    $.Chat = function(name, o)
    {
		this.options    = $.extend({}, chatDefaultConfig, o || {});
		this.cometdURL = location.protocol + "//" + location.host + this.options.contextPath + "/cometd";
		this. _connected = false;
		
		this.loginListener = null;
		this.changeStatusListener = null;
		this.queueJoinListener = null;
		this.queueLeaveListener = null;
		this.queueOfferReceivedListener = null;
		this.queueOfferRevokedListener = null;
		this.roomCreatedListener = null;
		this.roomLeaveListener = null;
		this.messageListener = new HashMap();
		this.roomInviteListener = null;
		this.participantListener = null;
		this.availableAgentsListener = null;
		this.logoutListener = null;
		
		this.directMessageCommonListener = null;
		this.directMessageListener = null;
		
		this.weixinMessageCommonListener = null;
		this.weixinMessageListener = null;
    };
    
    var $c = $.Chat;
     $c.fn = $c.prototype = {
    		Chat: '0'
    };
    $c.fn.extend = $c.extend = $.extend;
    
    $c.fn.extend({
    	connect: function(callback){
        	$.cometd.configure({
                url: this.cometdURL,
                logLevel: 'error'
            });
        	$.cometd.unregisterTransport('websocket');
        	
        	$.cometd.addListener('/meta/handshake', function(message) {
        		if (!$.isFunction(callback)) {
	                return;
	            }
        		//alert(message.clientId);
        		callback(message);	        	
	        });
        	
    		$.cometd.addListener('/meta/connect', function(message) {
    			
    			if (message.failure){
    				callback(message);
    		    }
	        	if ($.cometd.isDisconnected()) {
	        		console.log('[chat] cometd is Disconnected ');
			        return;
			    }
			    var wasConnected = _connected;
			    _connected = message.successful;
			    if (!wasConnected && _connected)
			    {
			        // Reconnected
			    	console.log('[chat] cometd Reconnected ');
			    }
			    else if (wasConnected && !_connected)
			    {
			        // Disconnected
			    	console.log('[chat] cometd Disconnected ');
			    }
	        });
    		
    		$.cometd.addListener('/meta/disconnect', function(message) {
    			console.log('------------');
    			console.log(message);
    			if (message.successful)
    		    {
    		        _connected = false;
    		        console.log('[chat] cometd disconnect ');
    		    }
	        });
    		$.cometd.handshake();
        },
        disconnect: function(){
        	$.cometd.disconnect();
        },
        addLoginListener: function(loginId, callback) {
        	console.log('[chat] loginListener: ' + this.loginListener);
        	if(this.loginListener) {
        		this.removeLoginListener();
        	}
        	this.loginListener = $.cometd.subscribe('/publish/agent/login/'+loginId, callback);
        	console.log('[chat] add login listener: ' + loginId);
        },
        removeLoginListener: function() {
        	$.cometd.unsubscribe(this.loginListener);
        	this.loginListener = null;
        	console.log('[chat] remove login listener: ');
        },
        addChangeStatusListener: function(loginId, callback) {
        	console.log('[chat] changeStatusListener: ' + this.changeStatusListener);
        	if(this.changeStatusListener) {
        		this.removeChangeStatusListener();
        	}
        	this.changeStatusListener = $.cometd.subscribe('/publish/agent/status/'+loginId, callback);
        	console.log('[chat] add change status listener: ' + loginId);
        },
        removeChangeStatusListener: function() {
        	$.cometd.unsubscribe(this.changeStatusListener);
        	this.changeStatusListener = null;
        	console.log('[chat] remove change status listener: ');
        },
        addQueueJoinListener: function(loginId, callback) {
        	console.log('[chat] queueJoinListener: ' + this.queueJoinListener);
        	if(this.queueJoinListener) {
        		this.removeQueueJoinListener();
        	}
        	this.queueJoinListener = $.cometd.subscribe('/publish/queue/join/'+loginId, callback);
        	console.log('[chat] add queue join listener: ' + loginId);
        },
        removeQueueJoinListener: function() {
        	$.cometd.unsubscribe(this.queueJoinListener);
        	this.queueJoinListener = null;
        	console.log('[chat] remove queue join listener: ');
        },
        addQueueLeaveListener: function(loginId, callback) {
        	console.log('[chat] queueLeaveListener: ' + this.queueLeaveListener);
        	if(this.queueLeaveListener) {
        		this.removeQueueLeaveListener();
        	}
        	this.queueLeaveListener = $.cometd.subscribe('/publish/queue/leave/'+loginId, callback);
        	console.log('[chat] add queue leave listener: ' + loginId);
        },
        removeQueueLeaveListener: function() {
        	$.cometd.unsubscribe(this.queueLeaveListener);
        	this.queueLeaveListener = null;
        	console.log('[chat] remove queue leave listener: ');
        },
        addQueueOfferReceivedListener: function(loginId, callback) {
        	console.log('[chat] queueOfferReceivedListener: ' + this.queueOfferReceivedListener);
        	if(this.queueOfferReceivedListener) {
        		this.removeQueueOfferReceivedListener();
        	}
        	this.queueOfferReceivedListener = $.cometd.subscribe('/publish/queue/offer/received/'+loginId, callback);
        	console.log('[chat] add queue offer received listener: ' + loginId);
        },
        removeQueueOfferReceivedListener: function() {
        	$.cometd.unsubscribe(this.queueOfferReceivedListener);
        	this.queueOfferReceivedListener = null;
        	console.log('[chat] remove queue offer received listener: ');
        },
        addQueueOfferRevokedListener: function(loginId, callback) {
        	console.log('[chat] queueOfferRevokedListener: ' + this.queueOfferRevokedListener);
        	if(this.queueOfferRevokedListener) {
        		this.removeQueueOfferRevokedListener();
        	}
        	this.queueOfferRevokedListener = $.cometd.subscribe('/publish/queue/offer/revoked/'+loginId, callback);
        	console.log('[chat] add queue offer revoked listener: ' + loginId);
        },
        removeQueueOfferRevokedListener: function() {
        	$.cometd.unsubscribe(this.queueOfferRevokedListener);
        	this.queueOfferRevokedListener = null;
        	console.log('[chat] remove queue offer revoked listener: ');
        },
        addRoomCreatedListener: function(loginId, callback) {
        	console.log('[chat] roomCreatedListener: ' + this.roomCreatedListener);
        	if(this.roomCreatedListener) {
        		this.removeRoomCreatedListener();
        	}
        	this.roomCreatedListener = $.cometd.subscribe('/publish/room/created/'+loginId, callback);
        	console.log('[chat] add room created listener: ' + loginId);
        },
        removeRoomCreatedListener: function() {
        	$.cometd.unsubscribe(this.roomCreatedListener);
        	this.roomCreatedListener = null;
        	console.log('[chat] remove room created listener: ');
        },
        addRoomLeaveListener: function(loginId, callback) {
        	console.log('[chat] roomLeaveListener: ' + this.roomLeaveListener);
        	if(this.roomLeaveListener) {
        		this.removeRoomLeaveListener();
        	}
        	this.roomLeaveListener = $.cometd.subscribe('/publish/room/leave/'+loginId, callback);
        	console.log('[chat] add room leave listener: ' + loginId);
        },
        removeRoomLeaveListener: function() {
        	$.cometd.unsubscribe(this.roomLeaveListener);
        	this.roomLeaveListener = null;
        	console.log('[chat] remove room leave listener: ');
        },
        addMessageListener: function(loginId, roomId, callback) {
        	console.log('[chat] messageListener: ' + this.messageListener.get(roomId));
        	if(this.messageListener.get(roomId)) {
        		this.removeMessageListener(roomId);
        	}
        	var message = $.cometd.subscribe('/publish/room/'+roomId +'/'+loginId, callback);
        	this.messageListener.put(roomId, message);
        	console.log('[chat] add message listener: ' + loginId + ', roomId=' + roomId);
        },
        removeMessageListener: function(roomId) {
        	var message = this.messageListener.get(roomId);
        	$.cometd.unsubscribe(message);
        	this.messageListener.remove(roomId);
        	console.log('[chat] remove message listener: roomId=' + roomId);
        },
        addRoomInviteListener: function(loginId, callback) {
        	console.log('[chat] roomInviteListener: ' + this.roomInviteListener);
        	if(this.roomInviteListener) {
        		this.removeRoomInviteListener();
        	}
        	this.roomInviteListener = $.cometd.subscribe('/publish/room/invite/'+loginId, callback);
        	console.log('[chat] add room invite listener: ' + loginId);
        },
        removeRoomInviteListener: function() {
        	$.cometd.unsubscribe(this.roomInviteListener);
        	this.roomInviteListener = null;
        	console.log('[chat] remove room invite listener: ');
        },
        addParticipantListener: function(loginId, callback) {
        	console.log('[chat] participantListener: ' + this.participantListener);
        	if(this.participantListener) {
        		this.removeParticipantListener();
        	}
        	this.participantListener = $.cometd.subscribe('/publish/room/participant/'+loginId, callback);
        	console.log('[chat] add participant listener: ' + loginId);
        },
        removeParticipantListener: function() {
        	$.cometd.unsubscribe(this.participantListener);
        	this.participantListener = null;
        	console.log('[chat] remove participant listener: ');
        },
        addAvailableAgentsListener: function(loginId, callback) {
        	console.log('[chat] availableAgentsListener: ' + this.availableAgentsListener);
        	if(this.availableAgentsListener) {
        		this.removeAvailableAgentsListener();
        	}
        	this.availableAgentsListener = $.cometd.subscribe('/publish/queue/availableagents/'+loginId, callback);
        	console.log('[chat] add available Agents Listener: ' + loginId);
        },
        removeAvailableAgentsListener: function() {
        	$.cometd.unsubscribe(this.availableAgentsListener);
        	this.availableAgentsListener = null;
        	console.log('[chat] remove available Agents Listener: ');
        },
        addLogoutListener: function(loginId, callback) {
        	console.log('[chat] logoutListener: ' + this.logoutListener);
        	if(this.logoutListener) {
        		this.removeLogoutListener();
        	}
        	this.logoutListener = $.cometd.subscribe('/publish/agent/logout/'+loginId, callback);
        	console.log('[chat] add logout listener: ' + loginId);
        },
        removeLogoutListener: function() {
        	$.cometd.unsubscribe(this.logoutListener);
        	this.logoutListener = null;
        	console.log('[chat] remove logout listener: ');
        },
        addDirectMessageListener: function(loginId, callback) {
        	console.log('[chat] directMessageListener: ' + this.directMessageListener);
        	if(this.directMessageListener) {
        		this.removeDirectMessageListener();
        	}
        	this.directMessageCommonListener = $.cometd.subscribe('/publish/message/all', callback);
        	this.directMessageListener = $.cometd.subscribe('/publish/message/'+loginId, callback);
        	console.log('[chat] add message listener: ' + loginId);
        },
        removeDirectMessageListener: function() {
        	$.cometd.unsubscribe(this.directMessageListener);
        	$.cometd.unsubscribe(this.directMessageCommonListener);
        	this.directMessageListener = null;
        	this.directMessageCommonListener = null;
        	console.log('[chat] remove message listener: ');
        },
        addWeixinMessageListener: function(loginId, callback) {
        	console.log('[chat] weixinMessageListener: ' + this.weixinMessageListener);
        	if(this.weixinMessageListener) {
        		this.removeWeixinMessageListener();
        	}
        	this.weixinMessageCommonListener = $.cometd.subscribe('/publish/weixin-message/all', callback);
        	this.weixinMessageListener = $.cometd.subscribe('/publish/weixin-message/'+loginId, callback);
        	console.log('[chat] add weixin message listener: ' + loginId);
        },
        removeWeixinMessageListener: function() {
        	$.cometd.unsubscribe(this.weixinMessageListener);
        	$.cometd.unsubscribe(this.weixinMessageCommonListener);
        	this.weixinMessageListener = null;
        	this.weixinMessageCommonListener = null;
        	console.log('[chat] remove weixin message listener: ');
        }
    });
    
    $c.extend({
    	
    });
   

})(jQuery);