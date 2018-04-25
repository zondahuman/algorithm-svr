package com.abin.lee.algorithm.basic.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午3:20
 * http://blog.csdn.net/wangxilong1991/article/details/70172302
 */
public class LRULinkedHashMap<K, V>  {
    public static void main(String[] args) {
        Map<String,String> request = new LinkedHashMap<String, String>();
        for(int i=0;i<100;i++){
            request.put("abin"+i, "lee"+i);
        }
//        request.
    }



}
