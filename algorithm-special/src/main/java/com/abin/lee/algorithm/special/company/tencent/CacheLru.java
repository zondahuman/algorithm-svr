package com.abin.lee.algorithm.special.company.tencent;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abin on 2018/8/28.
 * 实现一个缓存
 */
public class CacheLru {
    Map<Integer, Integer> cache = null;
    int cacheSize = 3;

    public CacheLru() {
        cache = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public void set(Integer key, Integer value) {
        cache.put(key, value);
    }

    public void get(Integer key) {
        cache.get(key);
    }

    public static void main(String[] args) {
        CacheLru lru = new CacheLru();
        lru.set(1, 11);
        lru.set(2, 22);
        lru.set(3, 33);
        lru.set(4, 44);
        System.out.println("cache=" + JsonUtil.toJson(lru.cache));

    }

}
