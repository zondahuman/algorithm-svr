package com.qunar.des.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * Created by abin on 2018/8/26.
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {
    /**
     * @param g 孩子数目
     * @param s 饼干树木
     * @return 给几个孩子分配了饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null | s.length == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] param1 = new int[] {1,2,3};
//        int[] param2 = new int[] {1,1};
        int[] param1 = new int[]{1, 2,3};
        int[] param2 = new int[]{3};
        int result = new AssignCookies().findContentChildren(param1, param2);
        System.out.println("result=" + result);
    }


}
