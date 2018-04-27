package com.abin.lee.algorithm.basic.string.find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by abin on 2018/4/27 23:38.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.string.find
 * 最长无重复子串
 * http://xfhnever.com/2014/10/30/algorithm-lnrs/
 * http://www.lpnote.com/2017/09/08/leetcode-3-longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LongestNoRepeatingSubString {
    public static void main(String[] args) {
        String str3 = "ababcabcde";
//        Integer result = getMaxNoDuplicateSubString(str3);
        Integer result = longestSubSet(str3);
        System.out.println("result=" + result);
    }

    /**
     * 求字符串中不包含重复字符的最长子串的长度
     * http://m.blog.csdn.net/qq_28618765/article/details/65627503
     *
     * @param param
     * @return
     */
    public static Integer getMaxNoDuplicateSubString(String param) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //map中的键key存放字符串中出现的字符，值value存放该字符当前的位置
        int maxLength = 0;    //保存最长字串长度
        int now = 0;        //记录头指针位置
        for (int i = 0; i < param.length(); i++) {
            if (map.containsKey(param.charAt(i))) {//如果map中已存在当前字符
                now = Math.max(now, map.get(param.charAt(i)) + 1);//更新当前指针位置，如果当前指针大，则使用当前指针，否则使用该指针下一个字符的位置
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            } else {        //map中不存在当前字符
                if ((i - now + 1) > maxLength) { //更新最长字串的长度
                    maxLength = i - now + 1;
                }
            }
            map.put(param.charAt(i), i);//修改当前字符的value，记录最新位置
        }
        return maxLength;
    }


    public static int longestSubSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    public String getLnrs1(String str) {
        if (str == null)
            return str;
        int maxLen = 0;
        int index = 0;
        int lastIndex = 0;


        int current = 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(str.charAt(0), 0);
        for (int i = 1; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), i);
                current++;
            } else {
                if (lastIndex <= map.get(str.charAt(i))) {
                    current = i - map.get(str.charAt(i));
                    lastIndex = map.get(str.charAt(i)) + 1;
                    map.remove(str.charAt(i));
                    map.put(str.charAt(i), i);
                } else {
                    current++;
                    map.remove(str.charAt(i));
                    map.put(str.charAt(i), i);
                }
            }

            if (current > maxLen) {
                maxLen = current;
                index = i + 1 - maxLen;
            }
        }

        return str.substring(index, index + maxLen);
    }


    public String getLnrs2(String str) {
        if (str == null)
            return str;
        int maxLen = 0;
        int index = 0;
        int lastIndex = 0;

        int[] dp = new int[str.length()];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(str.charAt(0), 0);
        for (int i = 1; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), i);
                dp[i] = dp[i - 1] + 1;
            } else {
                if (lastIndex <= map.get(str.charAt(i))) {
                    dp[i] = i - map.get(str.charAt(i));
                    lastIndex = map.get(str.charAt(i)) + 1;
                    map.remove(str.charAt(i));
                    map.put(str.charAt(i), i);
                } else {
                    dp[i] = dp[i - 1] + 1;
                    map.remove(str.charAt(i));
                    map.put(str.charAt(i), i);
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                index = i + 1 - maxLen;
            }
        }

        return str.substring(index, index + maxLen);
    }

    public String getLnrs3(String str) {
        if (str == null)
            return str;
        int maxLen = 0;
        int index = 0;
        int lastIndex = 0;

        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            for (int j = i - 1; j >= lastIndex; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i] = i - j;
                    lastIndex = j + 1;
                    break;
                } else if (j == lastIndex) {
                    dp[i] = dp[i - 1] + 1;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                index = i + 1 - maxLen;
            }
        }

        return str.substring(index, index + maxLen);
    }

    public String getLnrs4(String str) {
        if (str == null)
            return str;
        int maxLen = 0;
        int index = 0;
        int j = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            map.clear();
            map.put(str.charAt(i), 1);

            for (j = i + 1; j < str.length(); j++) {
                if (map.get(str.charAt(j)) != null) {
                    break;
                }
                map.put(str.charAt(j), 1);
            }

            if (j - i > maxLen) {
                maxLen = j - i;
                index = i;
            }
        }

        return str.substring(index, index + maxLen);
    }


}
