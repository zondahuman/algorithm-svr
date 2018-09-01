package com.abin.lee.algorithm.special.common.lru;

import java.util.HashMap;

/**
 * Created by abin on 2018/8/30.
 * 146. LRU Cache
 * <p>
 * https://blog.csdn.net/maoyeqiu/article/details/50452870
 * https://leetcode.com/problems/lru-cache/discuss/45922/JAVA-Easy-Version-To-Understand!!!!
 */
public class LruDefinitionCache {
    private final int MAX_SIZE;
    private Entry head;
    private Entry end;
    private HashMap<Integer, Entry> hashMap;
    int count;

    public LruDefinitionCache() {
        this(10);
    }

    public LruDefinitionCache(int cacheSize) {
        MAX_SIZE = cacheSize;
        hashMap = new HashMap<Integer, Entry>();
        head = new Entry(0, 0);
        end = new Entry(0, 0);
        head.next = end;
        end.pre = head;
        head.pre = null;
        end.next = null ;
        count = 0;
    }

    public void set(Integer key, Integer value) {
        Entry entry = hashMap.get(key);
        if (entry != null) {
            entry.value = value;
            remove(entry);
            addHead(entry);
        } else {
            Entry newEntry = new Entry(key, value);
            hashMap.put(key, newEntry);
            if (count < MAX_SIZE) {
                count++;
                addHead(newEntry);
            } else {
                hashMap.remove(end.pre.key);
                remove(end.pre);
                addHead(newEntry);
            }
        }
    }

    public int get(int key) {
        if (hashMap.get(key) != null) {
            Entry entry = hashMap.get(key);
            int result = entry.value;
            remove(entry);
            addHead(entry);
            return result;
        }
        return -1;
    }

    /**
     * 同时操作当前entry前后每一个的对象的pre和next
     *
     * @param entry
     */
    public void remove(Entry entry) {
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    /**
     * 同时操作当前entry前后每一个的对象的pre和next
     *
     * @param entry
     */
    public void addHead(Entry entry) {
        entry.next = head.next;
        entry.next.pre = entry;
        entry.pre = head;
        head.next = entry;
    }


    public static void main(String[] args) {
        LruDefinitionCache lru = new LruDefinitionCache(3);
        lru.set(1, 11);
        lru.set(2, 22);
        lru.set(3, 33);
        lru.set(4, 44);
        System.out.println("lru.hashMap=" + lru.hashMap);


    }

    public static class Entry {
        Integer key;
        Integer value;
        Entry pre;
        Entry next;

        public Entry() {
        }

        public Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


}
