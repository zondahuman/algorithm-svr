package com.abin.lee.algorithm.special.recursive;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午8:11
 */
public class StringReverse {
    public static void main(String[] args) {
        String init = "abcdef";
        String result = reverse(init);
        System.out.println("result=" + result);
        char[] array = new char[]{'a', 'b', 'c', 'd', 'e'};
        char[] resultArray = reverse(array, 0, array.length - 1);
        System.out.println("resultArray=" + JsonUtil.toJson(resultArray));
        int[] arrayer = new int[]{1,2,3,4,5};
        int[] resultArrayer = reverse(arrayer, 0, arrayer.length - 1);
        System.out.println("resultArrayer=" + JsonUtil.toJson(resultArray));
    }

    public static String reverse(String str) {
        if (str.length() < 2 || str == null || str.equals(""))
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static char[] reverse(char[] str, int low, int high) {
        if (low >= high)
            return str;
        char temp = str[low];
        str[low] = str[high];
        str[high] = temp;
        return reverse(str, ++low, --high);
    }
    public static int[] reverse(int[] str, int low, int high) {
        if (low >= high)
            return str;
        int temp = str[low];
        str[low] = str[high];
        str[high] = temp;
        return reverse(str, ++low, --high);
    }



}
