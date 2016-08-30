package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.SimpleLRUCache;

public class LRUCacheTest {

    public static void main(String ...args){
//        test1();
        test2();
    }

    private static void test1(){
        int capacity=8;

        SimpleLRUCache<Integer, String> cache1=new SimpleLRUCache<>(capacity);
        SimpleLRUCache<Integer, String> cache2=new SimpleLRUCache<>(capacity);

        for(int i=1;i<=capacity;i++){
            cache1.put(i, String.valueOf(i));
            cache2.put(i, String.valueOf(i));
        }

        System.out.println(cache1.get(2));
        System.out.println(cache1.get(4));

        System.out.println(cache1);
        System.out.println(cache2);

        cache1.put(9, String.valueOf(9));
        cache2.put(9, String.valueOf(9));

        System.out.println(cache1);
        System.out.println(cache2);
    }

    private static void test2(){
       int capacity=2;
        SimpleLRUCache<Integer,Integer> cache=new SimpleLRUCache<>(capacity);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        cache.get(2);
        cache.put(9,9);

        System.out.println(cache);
    }
}
