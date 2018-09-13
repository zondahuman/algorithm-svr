package com.abin.lee.algorithm.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/13.
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
        
        return 0 ;
    }

    public void put(int key, int value) {

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
            int res = hit.compareTo(o.hit);
            return res !=0 ? res : time.compareTo(o.time);
        }
    }

}
