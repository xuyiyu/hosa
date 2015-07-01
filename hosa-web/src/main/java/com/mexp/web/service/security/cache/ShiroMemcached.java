package com.mexp.web.service.security.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.mexp.core.cache.Memcached;

public class ShiroMemcached<K, V>  extends Memcached implements Cache<K, V>{

	public ShiroMemcached(String name, MemcachedClient cache) {
		super(name, cache);
		// TODO Auto-generated constructor stub
	}

	public V get(K key) throws CacheException {
       return super.get((String)key);
    }

    /**
     * Puts an object into the cache.
     *
     * @param key   the key.
     * @param value the value.
     */
    public V put(K key, V value) throws CacheException {
        return super.put((String)key, value);
    }

    /**
     * Removes the element which matches the key.
     *
     * <p>If no element matches, nothing is removed and no Exception is thrown.</p>
     *
     * @param key the key of the element to remove
     */
    public V remove(K key) throws CacheException {
        return super.remove((String)key);
    }

    /**
     * Removes all elements in the cache, but leaves the cache in a useable state.
     */
    public void clear() throws CacheException {
        super.clear();
    }

    public int size() {
        try {
                //TODO: unsupported
            return 0;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public Set<K> keys() {
        try {
                //TODO: unsupported
                return Collections.emptySet();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public Collection<V> values() {
        try {
            //TODO: unsupported
            return Collections.emptyList();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

}
