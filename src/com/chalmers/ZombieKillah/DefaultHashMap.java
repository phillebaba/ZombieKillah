package com.chalmers.ZombieKillah;

import java.util.HashMap;

/**
 * Created by Philip Laine on 26/02/16.
 */
public class DefaultHashMap<K,V> extends HashMap<K,V> {
    protected V defaultValue;
    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }
    @Override
    public V get(Object k) {
        return containsKey(k) ? super.get(k) : defaultValue;
    }
}
