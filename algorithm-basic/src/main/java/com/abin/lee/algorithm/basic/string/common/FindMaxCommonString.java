package com.abin.lee.algorithm.basic.string.common;

/**
 * 获取两个字符串的最大公共子串
 * 找出两个字符串的最大公共子串
 * https://blog.csdn.net/cleverlzc/article/details/49363541
 */
public class FindMaxCommonString {
    public static void main(String[] args) {
//        String str1 = "adcfgeheightkdeffcser";
//        String str2 = "theightyye";
        String str1 = "abcdefg";
        String str2 = "abdefg";
        String result = getMaxString(str1, str2);
        System.out.println("result=" + result);
    }

    private static String getMaxString(String str1, String str2) {
        String max = null;
        String min = null;
        max = (str1.length() > str2.length() ? str1 : str2);
        min = max.equals(str1) ? str2 : str1;
        for (int i = 0; i < min.length(); i++) {
            // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
            for (int start = 0, end = min.length() - i; end <= min.length(); start++, end++) {
//            for (int start = 0, end = min.length() - i; end != min.length() + 1; start++, end++) {
                String sub = min.substring(start, end);
                if (max.contains(sub))
                    return sub;
            }
        }
        return null;
    }




}
