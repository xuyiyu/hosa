package com.mexp.core.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.rubyeye.xmemcached.MemcachedClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mexp.core.exceptions.ServiceException;

public class MemcachedManager {

	private static final Logger log = LoggerFactory.getLogger(MemcachedManager.class);

	@Autowired
	@Qualifier("memcachedClient")
	private MemcachedClient client;
	
	private Map<String, Memcached> manager = new ConcurrentHashMap<String, Memcached>();
	
	public final Memcached getCache(String name) throws ServiceException {
		if (log.isTraceEnabled()) {
            log.trace("Acquiring EhCache instance named [" + name + "]");
        }

        try {
        	Memcached cache = this.manager.get(name);
            if (cache == null) {
                if (log.isInfoEnabled()) {
                    log.info("Cache with name '{}' does not yet exist.  Creating now.", name);
                }
                cache = new Memcached(name, client);
                
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
            throw new ServiceException(e);
        }
	}
}
