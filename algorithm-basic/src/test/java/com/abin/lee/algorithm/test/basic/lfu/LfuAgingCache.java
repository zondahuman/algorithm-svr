package com.abin.lee.algorithm.test.basic.lfu;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/13.
 * 缓存淘汰算法 —— LFU-Aging（Java实现）
 * https://blog.csdn.net/varyall/article/details/82695211
 */
public class LfuAgingCache extends HashMap<Integer, Integer> {
    private static final int DEFAULT_MAX_SIZE = 3;
    private int maxSize = DEFAULT_MAX_SIZE;
    Map<Integer, HitRate> keyMap = new HashMap<>();

    public LfuAgingCache() {
        this(DEFAULT_MAX_SIZE);
    }

    public LfuAgingCache(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    public Integer gets(Integer key) {
        Integer value = super.get(key);
        if (value != null) {
            HitRate hitRate = keyMap.get(key);
            hitRate.hit += 1;
            hitRate.time = System.currentTimeMillis();
        }
        return value;
    }

    public void put() {
        while (keyMap.size() >= maxSize) {
            Integer key = getLfuAging();
        }
    }

    public Integer getLfuAging() {
        HitRate min = Collections.min(keyMap.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {
        Integer hit;
        Long time;
        Integer key;

        public HitRate(Integer hit, Long time, Integer key) {
            this.hit = hit;
            this.time = time;
            this.key = key;
        }

        public int compareTo(HitRate o) {
            int hitc = hit.compareTo(o.hit);
            return hitc != 0 ? hitc : time.compareTo(o.time);
        }
    }


    @Test
    public void test() {
        HitRate hitRate1 = new HitRate(3, 111111111111111111L, 11);
    }

}
