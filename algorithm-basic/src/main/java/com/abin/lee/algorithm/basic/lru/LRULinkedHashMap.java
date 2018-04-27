package com.abin.lee.algorithm.basic.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午3:20
 * http://blog.csdn.net/wangxilong1991/article/details/70172302
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int Cache_Size = 5;

    public LRULinkedHashMap() {
        super(16, 0.75f, true);
    }

    //    public static int
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > Cache_Size;
    }

//    public void put(K k, V v){
//        cache.put(k, v);
//    }

    public static void main(String[] args) {
        LRULinkedHashMap request = new LRULinkedHashMap();
        for (int i = 0; i < 6; i++) {
            request.put("abin" + i, "lee" + i);
        }
        System.out.println("request=" + request);
        request.get("abin3");
        request.get("abin3");
        request.get("abin4");
        request.get("abin4");
        request.get("abin4");
        request.get("abin2");

        System.out.println("request=" + request);
        for (Iterator<Map.Entry<String, String>> iterator = request.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key=" + entry.getKey() + " value = " + entry.getValue());
        }

    }


}
