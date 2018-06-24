package com.abin.lee.algorithm.basic.string.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/6/24.
 * char----int     num - '0' = int类型
 */
public class TwoStringSum {

    public static void main(String[] args) {
//        String str1 = "1234";
//        String str2 = "89";
        String str1 = "1234";
        String str2 = "8111";
        String result1 = sum(str1, str2);
        System.out.println("result1=" + result1);
    }

    /**
     * 两个String类型的整数相加，结果为String
     * @param str1
     * @param str2
     * @return
     */
    public static String sum(String str1, String str2) {
        String max = (str1.length() >= str2.length()) ? str1 : str2;
        String min = (str1.length() >= str2.length()) ? str2 : str1;
        String result = "";
        Map<Integer, Integer> carryBit = new HashMap<Integer, Integer>();
        for (int i = 0; i < max.length(); i++) {
            int little = 0;
            if (i < min.length())
                little = min.charAt(min.length() - i -1) - '0';
            int big = max.charAt(max.length() - i - 1) - '0';
            int current = little + big;
            if (current > 9) {
                carryBit.put(i, 1);
                current = current - 10;
            }
            if(carryBit.containsKey(i-1))
                current += 1;
            result =  current + "" + result;
        }
        if(carryBit.containsKey(max.length()-1))
            result =  "1" + result;
        return result;
    }


}
