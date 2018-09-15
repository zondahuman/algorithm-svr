package com.abin.lee.algorithm.leetcode.arrarer;

import org.junit.Test;

/**
 * Created by abin on 2018/9/15.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        return null;
    }

    public static void main(String[] args) {
        String[] param = new String[] {"flower","flow","flight"};
//        String[] param = new String[] {"dog","racecar","car"};
        String result = new LongestCommonPrefix().longestCommonPrefix(param);
        System.out.println("result=" + result);
    }

    @Test
    public void test(){
        String param1= "ab";
        String param2= "abc";
        System.out.println(param2.indexOf(param1));
        System.out.println(param1.indexOf(param2));
    }


}
