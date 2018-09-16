package com.abin.lee.algorithm.test.basic.string;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by abin on 2017/12/6 13:53.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.strings.test
 * 求给定两个字符串的最长公共字符串
 */
public class LongCommonStringsTest {


    public static void main(String[] args) {
        //        String str1 = "BDCABA";
//        String str2 = "ABCBDAB";
        String str1 = "abcdefghab";
        String str2 = "cdefghijk";
//        String str1 = "";
//        String str2 = "";
        String result = maxSimpleCommonString(str1, str2);
        System.out.println(result);
    }

    public static String maxSimpleCommonString(String param1, String param2) {
        String max = param1.length() >= param2.length() ? param1 : param2;
        String min = param1.length() == max.length() ? param2 : param1;
        for (int i = min.length() - 1; i >= 1; i--) {
            for (int j = 0; j <= min.length()-i; j++) {
                String temp = min.substring(j, i);
                if (max.contains(temp))
                    return temp;
            }
        }
        return StringUtils.EMPTY;
    }



}
