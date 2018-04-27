package com.abin.lee.algorithm.basic.string.find;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 上午3:55
 * http://m.blog.csdn.net/qq_28618765/article/details/65627503
 */
public class FindCommonString {
    public static void main(String[] args) {
        String str1 = "abcdefghab";
        String str2 = "cdefghijk";
//        String result = getMaxString(str1,str2);
//        String result = getMaxCommon(str1,str2);
//        String result = getCommonStrLength(str1,str2);
//        System.out.println(result);

    }

    /**
     * 两个字符串最大公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxString(String str1, String str2) {
        String max = (str1.length() > str2.length() ? str1 : str2);
        String min = (max.equals(str1) ? str2 : str1);
        for (int i = 0; i < min.length() - 1; i++) {
//            for (int start = 0, end = min.length() - i; start++, end++) {
            for (int start = 0, end = min.length() - i; end != min.length() + 1; start++, end++) {
                System.out.println("start=" + start + " end=" + end);
                String common = min.substring(start, end);
                if (max.contains(common))
                    return common;
            }
        }
        return null;
    }

    /**
     * 两个字符串最大公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxCommon(String str1, String str2) {
        String max = (str1.length() > str2.length() ? str1 : str2);
        String min = (max.equals(str1) ? str2 : str1);
        for (int i = 0; i < min.length() - 1; i++) {
            for (int start = 0, end = min.length() - i; end < min.length() + 1; start++, end++) {
                System.out.println("start=" + start + " end=" + end);
                String temp = min.substring(start, end);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }



    public static String getCommonStrLength(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        String min = null;
        String max = null;
        String target = null;
        min = len1 <= len2 ? str1 : str2;
        max = len1 >  len2 ? str1 : str2;
        //最外层：min子串的长度，从最大长度开始
        for (int i = min.length(); i >= 1; i--) {
            //遍历长度为i的min子串，从0开始
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                if (max.contains(target)) {
                    return target;
                }
            }
        }
        return "";
    }

}
