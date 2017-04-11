package com.qunar.des.algorithm.basic.array.duplicate;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-21 下午11:22
 */
public class RemoveDuplicatedObjects {
    public static void main(String[] args) {
        int[] arrayer = new int[]{1,2,3,4,3,2,5};
        System.out.println(JsonUtil.toJson(arrayer));
        Set<Integer> seter = new HashSet<Integer>();
        for(int temp:arrayer){
            seter.add(temp);
        }
        int[] last = new int[seter.size()];
        AtomicInteger increase = new AtomicInteger(0);
        for(Iterator<Integer> it=seter.iterator();it.hasNext();){
            Integer value = it.next();
            last[increase.get()] = value;
            increase.getAndIncrement();
        }
        System.out.println(JsonUtil.toJson(last));
    }
}
