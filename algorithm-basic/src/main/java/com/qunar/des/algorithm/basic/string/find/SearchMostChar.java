package com.qunar.des.algorithm.basic.string.find;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-25 上午12:06
 */
public class SearchMostChar {
    public char search(String str) {
        int lenght = str.length();
        int max = 0;
        int index = 0;
        int j;
        char ch = str.charAt(0);
        for (int i = 0; i < lenght; ) {
            index = 0;
            for (j = i + 1; j < lenght; j++) {
                if (str.charAt(i) == str.charAt(j)) index++;
                else break;
            }
            if (index > max) {
                max = index;
                ch = str.charAt(i);
            }
            i = j;
        }
        return ch;
    }

    public static void main(String[] args) {
        SearchMostChar sc = new SearchMostChar();
        char ch = sc.search("abcdabcaba");
        System.out.println(ch);
    }
}
