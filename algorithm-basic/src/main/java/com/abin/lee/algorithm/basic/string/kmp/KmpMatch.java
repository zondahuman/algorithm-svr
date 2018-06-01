package com.abin.lee.algorithm.basic.string.kmp;

/**
 * Created by abin on 2018/6/1 18:30.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.string.kmp
 * KMP是一个解决模式串在文本串是否出现过，以及若是出现时，最早出现的位置的经典算法。
 * https://blog.csdn.net/V_0617/article/details/79114860
 * https://blog.csdn.net/christ1750/article/details/51259425
 */
public class KmpMatch {

    public static int kmp(String str, String dest, int[] next) {//str文本串  dest 模式串
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }

    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);
        int res = kmp(b, a, next);
        System.out.println("res=" + res);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        System.out.println(next.length);
    }


}
