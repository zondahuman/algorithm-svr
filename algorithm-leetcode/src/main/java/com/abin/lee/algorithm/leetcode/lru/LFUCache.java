package com.abin.lee.algorithm.leetcode.lru;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/13.
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/description/
 */
public class LFUCache extends HashMap<Integer, Integer> {
    private static final int defaultSize = 10;
    private int maxSize = defaultSize;
    private Map<Integer, HitRate> keyMap = new HashMap<>();

    public LFUCache(){
        this(defaultSize);
    }
    public LFUCache(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    public int get(int key) {
        Integer value = super.get(key);
        if(value != null){
            HitRate hitRate = keyMap.get(key);
            hitRate.hit+=1;
            hitRate.time = System.currentTimeMillis();
        }
        return value != null ? value : -1 ;
    }

    public void put(int key, int value) {
        if(keyMap.size()>maxSize){
            Integer key1 = getLfu();
            super.remove(key1);
            keyMap.remove(key1);
        }
        super.put(key, value);
        keyMap.put(key, new HitRate(key, 0, System.currentTimeMillis()));
    }
    public Integer getLfu(){
        HitRate min = Collections.min(keyMap.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate>{
        Integer key;
        Integer hit;
        Long time;
        public HitRate(Integer key ,Integer hit, Long time){
            this.key = key ;
            this.hit = hit;
            this.time = time ;
        }
        public int compareTo(HitRate o){
//            int res = hit.compareTo(o.hit);
//            return res !=0 ? res : time.compareTo(o.time);
            int res = o.hit.compareTo(hit);
            return res !=0 ? res : o.time.compareTo(time);
        }
    }

}
