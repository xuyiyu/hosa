package com.hosa.core.cache;

import net.rubyeye.xmemcached.MemcachedClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hosa.core.exceptions.ServiceException;

public class Memcached {

	private static final Logger log = LoggerFactory.getLogger(Memcached.class);
	
	private String name;
	
	private MemcachedClient cache;
	
	public Memcached(String name, MemcachedClient cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.name  = name;
        this.cache = cache;
    }
    
   

    
    public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}


	private String convertKey(String key) {
		return (name + "_" +key);
	}


	public <T> T get(String key) throws ServiceException {
        try {
            if (log.isTraceEnabled()) {
                log.trace("Getting object from cache [" + cache.getName() + "] for key [" + key + "]");
            }
            if (key == null) {
                return null;
            } else {
                return cache.get(convertKey(key));
            }
        } catch (Throwable t) {
            throw new ServiceException(t);
        }
    }

    /**
     * Puts an object into the cache.
     *
     * @param key   the key.
     * @param value the value.
     */
    public <T> T put(String key, T value) throws ServiceException {
        if (log.isTraceEnabled()) {
            log.trace("Putting object in cache [" + cache.getName() + "] for key [" + key + "]");
        }
        try {
            T previous = get(key);
            cache.set(convertKey(key), 0, value);
            return previous;
        } catch (Throwable t) {
            throw new ServiceException(t);
        }
    }
    
    /**
     * 
     * @param key
     * @param exp	
     * @param value
     * @return
     * @throws ServiceException
     */
    public <T> T put(String key, int exp, T value) throws ServiceException {
        if (log.isTraceEnabled()) {
            log.trace("Putting object in cache [" + cache.getName() + "] for key [" + key + "]");
        }
        try {
            T previous = get(key);
            cache.set(convertKey(key), exp, value);
            return previous;
        } catch (Throwable t) {
            throw new ServiceException(t);
        }
    }

    /**
     * Removes the element which matches the key.
     *
     * <p>If no element matches, nothing is removed and no Exception is thrown.</p>
     *
     * @param key the key of the element to remove
     */
    public <T> T remove(String key) throws ServiceException {
        if (log.isTraceEnabled()) {
            log.trace("Removing object from cache [" + cache.getName() + "] for key [" + key + "]");
        }
        try {
            T previous = get(key);
            cache.delete(convertKey(key));
            return previous;
        } catch (Throwable t) {
            throw new ServiceException(t);
        }
    }

    /**
     * Removes all elements in the cache, but leaves the cache in a useable state.
     */
    public void clear() throws ServiceException {
        if (log.isTraceEnabled()) {
            log.trace("Clearing all objects from cache [" + cache.getName() + "]");
        }
        try {
            cache.flushAllWithNoReply();
        } catch (Throwable t) {
            throw new ServiceException(t);
        }
    }


    /**
     * Returns &quot;Memcache [&quot; + cache.getName() + &quot;]&quot;
     *
     * @return &quot;Memcache [&quot; + cache.getName() + &quot;]&quot;
     */
    public String toString() {
        return "Memcache [" + cache.getName() + "]";
    }
}
