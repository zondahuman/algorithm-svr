package com.abin.lee.algorithm.special.recursive;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午10:57
 */
public class StringIndexOf {
    public static void main(String[] args) {
        String str = "abcdefg";
        String sub = "def";
        int result = firstPosition(str.toCharArray(),sub.toCharArray());
        System.out.println("result="+result);
    }

    public static int firstPosition(char[] str, char[] sub) {
        int len = str.length;
        int sublen = sub.length;
        int limit = len - sublen + 1;
        searchloop:
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < sublen; j++) {
                if (str[j + i] != sub[j]) {
                    continue searchloop;
                }
            }
            return i;
        }
        return -1;
    }

    public static int myIndexOf(char[] str, char[] substr) {
        int len = str.length;
        int sublen = substr.length;
        int count = 0;
        if (sublen > len) {
            return -1;
        }
        for (int i = 0; i < len - sublen + 1; i++) {
            for (int j = 0; j < sublen; j++) {
                if (str[j + i] == substr[j]) {
                    count++;
                    if (count == sublen) {
                        return i;
                    }
                } else {
                    count = 0;
                    break;
                }
            }
        }
        return -1;
    }

}
