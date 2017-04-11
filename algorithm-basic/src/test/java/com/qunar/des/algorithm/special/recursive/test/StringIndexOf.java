package com.qunar.des.algorithm.special.recursive.test;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-24 上午12:23
 */
public class StringIndexOf {
    public static void main(String[] args) {
        String str = "abcdefg";
        String sub = "def";
        int result = first(str.toCharArray(),sub.toCharArray());
        System.out.println("result="+result);
    }

    public static int first(char[] str, char[] sub) {
        int len = str.length;
        int sublen = sub.length;
        int limit = len - sublen + 1;
        int count = 0;
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < sublen; j++) {
                if (str[i + j] == sub[j]) {
                    count++;
                    if (count == sublen)
                        return i;
                } else {
                    count = 0;
                    break;
                }
            }
        }
        return -1;
    }
}
