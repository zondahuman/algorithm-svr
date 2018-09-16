package com.abin.lee.algorithm.leetcode.arrarer;

import org.junit.Test;

/**
 * Created by abin on 2018/9/15.
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Java中indexOf的用法
     * indexOf有四种用法：
     * 1.indexOf(int ch) 在给定字符串中查找字符(ASCII),找到返回字符数组所对应的下标找不到返回-1
     * 2.indexOf(String str)在给定符串中查找另一个字符串。。。
     * 3.indexOf(int ch,int fromIndex)从指定的下标开始查找某个字符，查找到返回下标，查找不到返回-1
     * 4.indexOf(String str,int fromIndex)从指定的下标开始查找某个字符串。。。
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] param = new String[]{"flower", "flow", "flight"};
//        String[] param = new String[] {"dog","racecar","car"};
        String result = new LongestCommonPrefix().longestCommonPrefix(param);
        System.out.println("result=" + result);
    }

    @Test
    public void test() {
        String param1 = "ab";
        String param2 = "abc";
        System.out.println(param2.indexOf(param1));
        System.out.println(param1.indexOf(param2));
    }


}
