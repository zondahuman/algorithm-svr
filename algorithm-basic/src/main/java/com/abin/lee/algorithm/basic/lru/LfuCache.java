package com.abin.lee.algorithm.basic.lru;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abin on 2018/4/27 12:50.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.lru
 * https://stackoverflow.com/questions/21117636/how-to-implement-a-least-frequently-used-lfu-cache
 */


public class LfuCache {

    public static class CacheEntry {
        private String data;
        private int frequency;

        // default constructor
        private CacheEntry() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }

    public static int initialCapacity = 10;

    public LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<Integer, CacheEntry>();
    /* LinkedHashMap is used because it has features of both HashMap and LinkedList.
     * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
     * */

    public LfuCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void addCacheEntry(int key, String data) {
        if (!isFull()) {
            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
            if (minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public String getCacheEntry(int key) {
        if (cacheMap.containsKey(key))  // cache hit
        {
            CacheEntry temp = cacheMap.get(key);
            temp.frequency++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return null; // cache miss
    }

    public boolean isFull() {
        if (cacheMap.size() == initialCapacity)
            return true;

        return false;
    }


    public static void main(String[] args) {
        LfuCache request = new LfuCache(5);
        for (int i = 0; i < 6; i++) {
            request.addCacheEntry(i, "lee" + i);
        }
        System.out.println("request=" + JsonUtil.toJson(request.cacheMap));
        request.getCacheEntry(3);
        request.getCacheEntry(3);
        request.getCacheEntry(4);
        request.getCacheEntry(4);
        request.getCacheEntry(2);

        System.out.println("request=" + JsonUtil.toJson(request));


    }



}