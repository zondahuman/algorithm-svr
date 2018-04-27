package com.abin.lee.algorithm.basic.string.common;

/**
 *
 * 找出两个字符串的最大公共子序列
 * https://www.ojcoder.cn/LintCode/79-longest-common-substring/index.php?slang=java
 *
 *
 */
public class FindMaxSequenceString {
    public static void main(String[] args) {
//        String str1 = "adcfgeheightkdeffcser";
//        String str2 = "theightyye";
        String str1 = "abcdefg";
        String str2 = "abdefg";
        int result = longestCommonSubstring(str1, str2);
        System.out.println("result=" + result);
        int result2 = lcs(str1, str2);
        System.out.println("result2=" + result2);
    }

    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) return 0;

        char[] charA = A.toCharArray(), charB = B.toCharArray();
        int[][] DP = new int[charA.length + 1][charB.length + 1];
        int maxLen = 0;

        for (int i = 1; i <= charA.length; i++)
            for (int j = 1; j <= charB.length; j++) {
                if (charA[i - 1] == charB[j - 1])
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                maxLen = Math.max(maxLen, DP[i][j]);
            }

        return maxLen;
    }


    /**
     *  1、 lcs(i,j)=0      (i=0, j=0)
     *  2、 lcs(i,j)=lcs(i-1,j-1)+1  (i=j )
     *  3、 lcs(i,j)= max(lcs(i,j-1), lcs(i-1,j))  (i!=j )
     * @param param1
     * @param param2
     * @return
     */
    public static int lcs(String param1, String param2){
        int[][] result = new int[param1.length()+1][param2.length()+1];
        for (int i = 1; i <=param1.length() ; i++) {
            for (int j = 1; j <=param2.length() ; j++) {
                if(param1.charAt(i-1) == param2.charAt(j-1)){
                    result[i][j] = result[i-1][j-1] + 1;
                }else{
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }
        return result[param1.length()][param2.length()];
    }



}
