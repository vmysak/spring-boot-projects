package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.SimpleLRUCache;

public class LRUCacheTest {

    public static void main(String ...args){
        int capacity=5;
        
        SimpleLRUCache<Integer, String> cache1=new SimpleLRUCache<>(capacity);
        SimpleLRUCache<Integer, String> cache2=new SimpleLRUCache<>(capacity);

        for(int i=1;i<=5;i++){
            cache1.put(i, String.valueOf(i));
            cache2.put(i, String.valueOf(i));
        }

        System.out.println(cache1.get(2));
        System.out.println(cache1.get(4));

        System.out.println(cache1);
        System.out.println(cache2);
    }
}
