package com.mexp.jmemcached;

import java.net.InetSocketAddress;

import com.thimbleware.jmemcached.CacheImpl;
import com.thimbleware.jmemcached.Key;
import com.thimbleware.jmemcached.LocalCacheElement;
import com.thimbleware.jmemcached.MemCacheDaemon;
import com.thimbleware.jmemcached.storage.CacheStorage;
import com.thimbleware.jmemcached.storage.hash.ConcurrentLinkedHashMap;

public class JMemcachedServer {

	
    
	public static void main(String args[]) {
		int maxItems = 1024;
	    long maxBytes = 1024 * 2048;
	    int idleTime=60*60*1; 
	    boolean binary=false;  
	    
		final MemCacheDaemon<LocalCacheElement> daemon = new MemCacheDaemon<LocalCacheElement>();

        CacheStorage<Key, LocalCacheElement> storage = ConcurrentLinkedHashMap.create(ConcurrentLinkedHashMap.EvictionPolicy.FIFO, maxItems, maxBytes);
        daemon.setCache(new CacheImpl(storage));
        daemon.setBinary(binary);
        daemon.setAddr(new InetSocketAddress("127.0.0.1", 11211));
        daemon.setIdleTime(idleTime);
        daemon.setVerbose(false);
        daemon.start();
	}
}
