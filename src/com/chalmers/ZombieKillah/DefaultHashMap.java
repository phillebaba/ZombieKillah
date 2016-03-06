package com.chalmers.ZombieKillah;

import java.util.HashMap;

/**
 * Class used for input so that the
 * default value returned if no object exists
 * for the key to be true
 * @author Philip Laine
 * @version 1.0.0 26/02/16
 */
public class DefaultHashMap<K,V> extends HashMap<K,V> {
    protected V defaultValue;

    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Will look up the key in this map and will
     * return the default value if a object is not found
     * for the key
     * @param k The key to be looked up
     * @return Return value, will default to default value if not found
     */
    @Override
    public V get(Object k) {
        return containsKey(k) ? super.get(k) : defaultValue;
    }
}
