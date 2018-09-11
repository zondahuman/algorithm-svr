package com.abin.lee.algorithm.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/9/11.
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        String param = "abcabcbb";
//        String param = "bbbbb";
        String param = "pwwkew";
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(param);
        System.out.println("result=" + result);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int count = 0;
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                count = Math.max(count, end - start);
            }
        }
        return count;
    }


}
