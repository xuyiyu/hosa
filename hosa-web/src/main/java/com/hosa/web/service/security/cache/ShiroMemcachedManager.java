package com.hosa.web.service.security.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class ShiroMemcachedManager implements CacheManager, Initializable, Destroyable {

	private static final Logger log = LoggerFactory.getLogger(ShiroMemcachedManager.class);

	@Autowired
	@Qualifier("memcachedClient")
	private MemcachedClient client;
	
	private Map<String, ShiroMemcached> manager = new ConcurrentHashMap<String, ShiroMemcached>();
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws ShiroException {
		
	}

	@Override
	public final <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if (log.isTraceEnabled()) {
            log.trace("Acquiring EhCache instance named [" + name + "]");
        }

        try {
        	ShiroMemcached<K, V> cache = this.manager.get(name);
            if (cache == null) {
                if (log.isInfoEnabled()) {
                    log.info("Cache with name '{}' does not yet exist.  Creating now.", name);
                }
                cache = new ShiroMemcached<K, V>(name, client);
                
                manager.put(name, cache);

                if (log.isInfoEnabled()) {
                    log.info("Added cache named [" + name + "]");
                }
            } else {
                if (log.isInfoEnabled()) {
                    log.info("Using existing cache named [" + cache.getName() + "]");
                }
            }
            return cache;
        } catch (Exception e) {
            throw new CacheException(e);
        }
	}

}
