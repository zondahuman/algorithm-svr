package com.qunar.des.algorithm.basic.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午3:20
 */
public class LRULinkedHashMap {
    public static void main(String[] args) {
        Map<String,String> request = new LinkedHashMap<String, String>();
        for(int i=0;i<100;i++){
            request.put("abin"+i, "lee"+i);
        }
//        request.
    }
}
