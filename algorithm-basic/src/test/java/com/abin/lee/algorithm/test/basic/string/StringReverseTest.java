package com.abin.lee.algorithm.test.basic.string;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午8:11
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String init = "abcdef";
        String result = reverse(init);
        System.out.println("result=" + result);
//        char[] array = new char[]{'a', 'b', 'c', 'd', 'e'};
//        char[] resultArray = reverse(array, 0, array.length - 1);
//        System.out.println("resultArray=" + JsonUtil.toJson(resultArray));
//        int[] arrayer = new int[]{1,2,3,4,5};
//        int[] resultArrayer = reverse(arrayer, 0, arrayer.length - 1);
//        System.out.println("resultArrayer=" + JsonUtil.toJson(resultArray));
    }

    @Test
    public void test1(){
        String str = "abcdef";
        String result = str.substring(1);
        System.out.println("result=" + result);
        char result1 = str.charAt(0);
        System.out.println("result1=" + result1);
        String result2 = str.substring(1) + str.charAt(0);
        System.out.println("result2=" + result2);
    }

    @Test
    public void test2() {
        String str = "abcdef";
        String result = reverse(str);
        System.out.println("result=" + result);

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
