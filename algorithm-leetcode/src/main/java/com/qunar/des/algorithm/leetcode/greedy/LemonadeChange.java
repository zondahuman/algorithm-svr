package com.qunar.des.algorithm.leetcode.greedy;

/**
 * Created by abin on 2018/8/26.
 * 860.Lemonade Change
 * 柠檬水找零
 * https://leetcode.com/problems/lemonade-change/description/
 * https://blog.csdn.net/qq_38959715/article/details/80918681
 * https://blog.csdn.net/lym940928/article/details/80909584
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int max = 0;
        for (int i = 0; i <bills.length ; i++) {

        }

        return false;
    }

    public static void main(String[] args) {
        int num = 5;
        num-=3;
        System.out.println("num="+num);
        int[] param = new int[] {1,2,3};
        boolean result = new LemonadeChange().lemonadeChange(param);
        System.out.println("result=" + result);
    }



}
