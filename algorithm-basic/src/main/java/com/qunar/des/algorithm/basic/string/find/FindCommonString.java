package com.qunar.des.algorithm.basic.string.find;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 上午3:55
 */
public class FindCommonString {
    public static void main(String[] args) {
        String str1 = "abcdefghab";
        String str2 = "cdefghijk";
//        String result = getMaxString(str1,str2);
//        String result = getMaxCommon(str1,str2);
//        System.out.println(result);
        String str3 = "ababcar";

        Integer result = getMaxNoDuplicateSubString(str3);
        System.out.println("result="+result);
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

    /**
     * 求字符串中不包含重复字符的最长子串的长度
     *
     * @param param
     * @return
     */
    public static Integer getMaxNoDuplicateSubString(String param) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //map中的键key存放字符串中出现的字符，值value存放该字符当前的位置
        int maxLength = 0;    //保存最长字串长度
        int now = 0;        //记录头指针位置
        for (int i = 0; i < param.length(); i++) {
            if (map.containsKey(param.charAt(i))) {//如果map中已存在当前字符
                now = Math.max(now, map.get(param.charAt(i)) + 1);//更新当前指针位置，如果当前指针大，则使用当前指针，否则使用该指针下一个字符的位置
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            } else {        //map中不存在当前字符
                if ((i - now + 1) > maxLength) { //更新最长字串的长度
                    maxLength = i - now + 1;
                }
            }
            map.put(param.charAt(i), i);//修改当前字符的value，记录最新位置
        }
        return maxLength;
    }


}
