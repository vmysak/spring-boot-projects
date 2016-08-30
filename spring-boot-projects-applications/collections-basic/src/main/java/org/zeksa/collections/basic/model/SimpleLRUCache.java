package org.zeksa.collections.basic.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    /**
     * @param capacity must be value of power of 2; otherwise after map creation and before first element
     *                 insertion will be rounded to next power of 2;
     */
    public SimpleLRUCache(int capacity) {
        super(capacity, 1.0f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}
