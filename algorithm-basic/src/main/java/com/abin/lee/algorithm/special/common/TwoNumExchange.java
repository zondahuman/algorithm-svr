package com.abin.lee.algorithm.special.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by abin on 2018/5/15 23:50.
 * algorithm-svr
 * com.abin.lee.algorithm.special.common
 */
public class TwoNumExchange {
    public static void main(String[] args) {
        int a=5;
        int b=3;
        Map<String, Integer> transfer = transfer(a, b);
        System.out.println("transfer="+transfer);
    }
    public static Map<String, Integer> transfer(int a, int b){
        Map<String, Integer> request = Maps.newHashMap();
        a = a^b;
        b = a^b;
        a = a^b;
        request.put("a", a);
        request.put("b", b);
        return request;
    }
}
