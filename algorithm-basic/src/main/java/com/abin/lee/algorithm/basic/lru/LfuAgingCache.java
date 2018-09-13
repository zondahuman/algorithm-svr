package com.abin.lee.algorithm.basic.lru;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/13.
 * 缓存淘汰算法 —— LFU-Aging（Java实现）
 * https://blog.csdn.net/varyall/article/details/82695211
 */
public class LfuAgingCache<K, V> extends HashMap<K, V> {
    private static final int DEFAULT_MAX_SIZE = 3;
    private int maxSize = DEFAULT_MAX_SIZE;
    Map<K, HitRate> keyMap = new HashMap<>();

    public LfuAgingCache() {
        this(DEFAULT_MAX_SIZE);
    }

    public LfuAgingCache(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    public V get(Object key) {
        V value = super.get(key);
        if (value != null) {
            HitRate hitRate = keyMap.get(key);
            hitRate.hit += 1;
            hitRate.time = System.currentTimeMillis();
        }
        return value;
    }

    public V put(K key, V value) {
        while (keyMap.size() >= maxSize) {
            K k = getLfuAging();
            super.remove(k);
            keyMap.remove(k);
        }
        V v = super.put(key, value);
        keyMap.put(key, new HitRate(key, 0, System.currentTimeMillis()));
        return v;
    }

    public K getLfuAging() {
        HitRate min = Collections.min(keyMap.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {
        K key;
        Integer hit;
        Long time;


        public HitRate(K key, Integer hit, Long time) {
            this.hit = hit;
            this.time = time;
            this.key = key;
        }

        public int compareTo(HitRate o) {
            int hitc = hit.compareTo(o.hit);
            return hitc != 0 ? hitc : time.compareTo(o.time);  //hitc != 0 ,表示这个hit次数不相等，那么就采用hitc，如果hit次数相等的话，那么接下来就开始比较time
        }
    }


    public static void main(String[] args) {
        LfuAgingCache<Integer, Integer> lfu = new LfuAgingCache<>();
        lfu.put(1, 1111);
        lfu.put(2, 2222);
        lfu.put(3, 3333);
        lfu.put(4, 4444);
        lfu.put(5, 5555);
        System.out.println("lfu-=" + JsonUtil.toJson(lfu.keyMap));
        System.out.println("lfu-=" + JsonUtil.toJson(lfu.getLfuAging()));
        lfu.get(5);
        lfu.get(5);
        lfu.get(3);
        lfu.get(3);
        lfu.get(4);
        lfu.put(6, 6666);

        System.out.println("lfu-=" + JsonUtil.toJson(lfu.keyMap));
    }


}
