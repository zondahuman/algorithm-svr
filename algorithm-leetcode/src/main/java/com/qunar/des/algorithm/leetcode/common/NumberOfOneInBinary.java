package com.qunar.des.algorithm.leetcode.common;

/**
 * Created by abin on 2018/7/18.
 */
public class NumberOfOneInBinary {


    public static void main(String[] args) {
//        int result = numberOfOne(-8);
        int result = numberOfOne1(8);
        System.out.println("result=" + result);
    }

    public static int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static int numberOfOne1(int n) {
        int count = 0;
        while (n != 0) {
            int temp = n&1;
            if(temp == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }



}
