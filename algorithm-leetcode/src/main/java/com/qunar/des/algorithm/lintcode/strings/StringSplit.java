package com.qunar.des.algorithm.lintcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/7/11.
 * 字符串分割 时间复杂度将达到O(N)
 * https://mp.weixin.qq.com/s?__biz=MzU2NDU0MjE4MA==&mid=2247483805&idx=1&sn=7589082654a98a43fe68e2b7ae4e6c81&chksm=fc482e16cb3fa7008d9993de550bf323d70972625964ba7cbd80b0675b92704e5f2d30196bce&scene=0#rd
 */
public class StringSplit {

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(str);
        System.out.println("list=" + list);
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int right = 0, left = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            right = Math.max(right, last[S.charAt(i) - 'a']);
            if (i == right) {
                ans.add(i - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }


}
