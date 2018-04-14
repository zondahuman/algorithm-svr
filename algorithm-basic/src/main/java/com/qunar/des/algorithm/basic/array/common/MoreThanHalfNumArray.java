package com.qunar.des.algorithm.basic.array.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by abin on 2018/4/15 2:56.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.array.common
 * 数组中出现次数超过一半的数字
 * https://blog.csdn.net/lingongheng/article/details/52735096
 */
public class MoreThanHalfNumArray {
    public static void main(String[] args) {
        int[] param = new int[]{1,2,3,4,5,6,5,5,5,5,5};
        Integer result = half(param);
        System.out.println("result=" + result);
    }

    public static Integer half(int[] param){
        if(null == param) {
            return null;
        }else{
            Map<Integer, Integer> map = Maps.newHashMap();
            for (int i = 0; i <param.length ; i++) {
                if(map.containsKey(param[i])){
                    Integer count = map.get(param[i]) ;
                    map.put(param[i], ++count);
                }else {
                    map.put(param[i], 1);
                }
                if(map.get(param[i]) > param.length/2)
                    return param[i];
            }
        }
        return null;
    }


}
