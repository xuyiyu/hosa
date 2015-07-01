package com.mexp.web.internal.cometd;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.java.annotation.ServerAnnotationProcessor;
import org.cometd.server.BayeuxServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;


@Component
public class BayeuxInitializer implements DestructionAwareBeanPostProcessor, ServletContextAware
{
	private final static Logger logger = LoggerFactory.getLogger(BayeuxInitializer.class);
    private BayeuxServer bayeuxServer;
    private ServerAnnotationProcessor processor;

  

	
    @Inject
    private void setBayeuxServer(BayeuxServer bayeuxServer)
    {
        this.bayeuxServer = bayeuxServer;
    }

    @PostConstruct
    private void init()
    {
        this.processor = new ServerAnnotationProcessor(bayeuxServer);
    }

    @PreDestroy
    private void destroy()
    {
    }

    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException
    {
        processor.processDependencies(bean);
        processor.processConfigurations(bean);
        processor.processCallbacks(bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException
    {
        return bean;
    }

    public void postProcessBeforeDestruction(Object bean, String name) throws BeansException
    {
        processor.deprocessCallbacks(bean);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public BayeuxServer bayeuxServer()
    {
        BayeuxServerImpl bean = new BayeuxServerImpl();
        bean.setOption(BayeuxServerImpl.LOG_LEVEL, "0");
        bean.setOption("maxServerInterval", 0L);
        
        bean.addListener(new BayeuxServer.SessionListener(){

			@Override
			public void sessionAdded(ServerSession arg0) {
				// TODO Auto-generated method stub
				
				logger.debug("-------add--------- id: "+arg0.getId());
			}

			@Override
			 public void sessionRemoved(ServerSession arg0, boolean arg1) {
				String clientId = arg0.getId();
				logger.debug("---------remove------ client id: " + clientId);
				String loginId = null;
				try {
//					loginId = agentSessionManager.getByClientIdFromCached(clientId);
//					AgentSession agentSession = agentSessionManager.getByLoginIdFromCached(loginId);
//					logger.debug("---------remove session------ client id: " + agentSession.getSessionId());
//					if(agentSession.getSessionId() != null &&
//							agentSession.getSessionId().equals(clientId)	) {
//						logger.debug("remove login id: " + loginId);
//						openfireLoginService.logout(loginId);
//						securityService.logout(loginId);
//					} else {
//						agentSessionManager.removeClientSession(clientId);
//					}
					
	    			
					
				} catch (Exception e) {
					logger.error(" exception exit failure, reason: " + e.getMessage());
				}
//				
			}
        	
        });
        //bean.setOption("long-polling.multiSessionInterval", "32000");
        return bean;
    }

    public void setServletContext(ServletContext servletContext)
    {
        servletContext.setAttribute(BayeuxServer.ATTRIBUTE, bayeuxServer);
    }
}