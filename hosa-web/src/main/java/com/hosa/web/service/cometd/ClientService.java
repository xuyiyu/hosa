package com.hosa.web.service.cometd;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ConfigurableServerChannel;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.java.annotation.Configure;
import org.cometd.java.annotation.Service;
import org.cometd.java.annotation.Session;
import org.cometd.server.authorizer.GrantAuthorizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 座席前端推送通知服务
 * @author allennb
 *
 */
@Named
@Service("clientService")
public class ClientService {

	private final static Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	@Inject
    private BayeuxServer bayeux;
	
	@Session
    private LocalSession localSession;

    @Session
    private ServerSession serverSession;
    
    /**
     * 设置座席通道的权限
     */
    @Configure ({"/publish/agent/**"})
    protected void configureLoginCallback(ConfigurableServerChannel channel){
    	channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
        channel.setPersistent(true);
    }
    
    /**
     * 推送前端座席登录的返回信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishLoginCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish login :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/agent/login/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席改变状态的返回信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishChangeStatusCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish change status :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/agent/status/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 设置queue通道的权限
     */
    @Configure ({"/publish/queue/**"})
    protected void configureQueueCallback(ConfigurableServerChannel channel){
    	channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
        channel.setPersistent(true);
    }
    
    /**
     * 推送前端座席登入queue的返回信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishQueueJoinCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish join queue :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/queue/join/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席登出queue的返回信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishQueueLeaveCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish leave queue :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/queue/leave/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席offer通知派发信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishOfferReceivedCallback(String loginId,  Map<String, Object> paramData) {
    	logger.debug("---------publish offer received :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/queue/offer/received/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席offer通知收回信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishOfferRevokedCallback(String loginId,  Map<String, Object> paramData) {
    	logger.debug("---------publish offer revoked :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/queue/offer/revoked/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 设置房间通道的权限
     */
    @Configure ({"/publish/room/**"})
    protected void configureRoomCallback(ConfigurableServerChannel channel){
    	channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
        channel.setPersistent(true);
    }
    
    /**
     * 推送前端座席房间创建信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishRoomCreatedCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish room created :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/created/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席房间关闭信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishRoomLeaveCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish leave room :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/leave/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席消息信息
     * @param loginId	座席登录id
     * @param roomId	房间id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishMessageCallback(String loginId, String roomId, Map<String, Object> paramData) {
    	logger.debug("---------publish message to agent :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/" + roomId + "/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席会议邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishInviteConferenceCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish invited agent :{} to join the conference. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席接受会议邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishAcceptInviteConferenceCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish accept agent :{} to join the conference. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席拒绝会议邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishRejectInviteConferenceCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish reject agent :{} to join the conference. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席转接邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishInviteTransferCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish invited agent :{} to transfer. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席接受转接邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishAcceptInviteTransferCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish accept agent :{} to transfer. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席拒绝转接邀请信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishRejectInviteTransferCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish reject agent :{} to transfer. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/invite/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端参与者信息
     * @param loginId
     * @param paramData
     */
    public void publishParticipantCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish invited agent :{} to transfer. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/room/participant/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端可用座席信息
     * @param loginId
     * @param paramData
     */
    public void publishAvailableAgentsCallback(String loginId, Map<String, Object> paramData) {
    	logger.debug("---------publish available agents to agent :{}. ------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/queue/availableagents/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 推送前端座席退出
     * @param loginId
     * @param paramData
     */
    public void publishLogoutCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish logout :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/agent/logout/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    
    /**
     * 设置私信的权限
     */
    @Configure ({"/publish/message/**"})
    protected void configureDirectMessageCallback(ConfigurableServerChannel channel){
    	channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
        channel.setPersistent(true);
    }
    
    /**
     * 推送前端私信信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishDirectMessageCallback(String loginId,  Map<String, String> paramData) {
    	logger.debug("---------publish login :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/message/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
    
    /**
     * 设置微信通道的权限
     */
    @Configure ({"/publish/weixin-message/**"})
    protected void configureWeixinCallback(ConfigurableServerChannel channel){
    	channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
        channel.setPersistent(true);
    }
    
    /**
     * 推送微信信息
     * @param loginId	座席登录id
     * @param paramData	推送数据 ：(key=callbackLoginId value=调用的座席登录id)
     */
    public void publishWeixinCallback(String loginId,  Map<String, Object> paramData) {
    	logger.debug("---------publish login :{}------------", loginId);
    	ClientSessionChannel _channel = serverSession.getLocalSession().getChannel("/publish/weixin-message/" + loginId);
    	paramData.put("callbackLoginId", loginId);
    	_channel.publish(paramData);
    }
}
