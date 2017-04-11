package com.qunar.des.algorithm.basic.string.find;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-25 上午12:06
 */
public class SearchMost {
    public int[] getSuffixArray(String str)
    {
        if (str == null)
            return null;

// 初始化后缀数组
        String[] suffix = new String[str.length()];
        for (int i = 0; i < suffix.length; i++)
            suffix[i] = str.substring(i);

// 对后缀数组排序
        Arrays.sort(suffix);

// 求结果数组
        int[] result = new int[str.length()];
        for (int i = 0; i < suffix.length; i++)
        {
            result[i] = str.lastIndexOf(suffix[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        SearchMost sc = new SearchMost();
        int[] ch = sc.getSuffixArray("abcdabcaba");
        System.out.println(Arrays.toString(ch));
    }
}
