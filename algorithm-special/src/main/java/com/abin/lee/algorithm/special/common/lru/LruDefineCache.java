package com.abin.lee.algorithm.special.common.lru;

import java.util.HashMap;

/**
 * Created by abin on 2018/8/30.
 *
 */
public class LruDefineCache<K,V> {
    private final int MAX_SIZE;
    private Entry first;
    private Entry last;
    private HashMap<K, Entry<K, V>> hashMap;
    public LruDefineCache(){
        this(10);
    }
    public LruDefineCache(int cacheSize){
        MAX_SIZE = cacheSize ;
        hashMap = new HashMap<K, Entry<K, V>>();
    }
    public void put(K key, V value){
        Entry entry = hashMap.get(key);
        if(entry == null){
            if(hashMap.size()>= MAX_SIZE){
                hashMap.remove(last.key);
            }
        }
    }




    public static class Entry<K, V>{
        K key;
        V value;
        Entry pre;
        Entry next ;
    }

}
