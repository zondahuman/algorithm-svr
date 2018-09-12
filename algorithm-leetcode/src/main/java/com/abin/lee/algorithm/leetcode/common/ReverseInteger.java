package com.abin.lee.algorithm.leetcode.common;

/**
 * Created by abin on 2018/9/12.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
        return num;
    }

    public int reverse1(int x) {
        long num = 0;

        while (x != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        if (num >= Integer.MAX_VALUE || num <= Integer.MIN_VALUE) {
            return 0;
        }

        return (int) num;
    }

    public static void main(String[] args) {
        int one = 123;
        int result = new ReverseInteger().reverse(one);
//        int result = new ReverseInteger().reverse1(one);
        System.out.println("result=" + result);
    }

}
