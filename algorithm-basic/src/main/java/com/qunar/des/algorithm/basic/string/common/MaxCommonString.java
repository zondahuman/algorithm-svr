package com.qunar.des.algorithm.basic.string.common;

/**
 * java 温习之字符串（获取两个字符串的最大公共字串）
 */
public class MaxCommonString {
    public static void main(String[] args) {
        String str1 = "adcfgeheightkdeffcser";
        String str2 = "theightyye";

        String result = getMaxString(str1, str2);
        System.out.println(result);
    }

    private static String getMaxString(String str1, String str2) {
        String max = null;
        String min = null;
        max = (str1.length() > str2.length() ? str1 : str2);
        min = max.equals(str1) ? str2 : str1;
        for (int i = 0; i < min.length(); i++) {
            for (int start = 0, end = min.length() - i; end != min.length() + 1; start++, end++) {
                String sub = min.substring(start, end);
                if (max.contains(sub))
                    return sub;
            }
        }
        return null;
    }

}
