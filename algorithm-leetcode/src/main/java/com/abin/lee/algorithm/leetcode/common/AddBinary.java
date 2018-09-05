package com.abin.lee.algorithm.leetcode.common;

/**
 * Created by abin on 2018/9/5.
 * 67. Add Binary
 * 字符串形式的二进制的加法
 * https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {


    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        StringBuffer stb = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int tempa = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tempb = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            stb.insert(0, (tempa + tempb + carry) % 2);
            carry = (tempa + tempb + carry) > 1 ? 1 : 0;
        }
        if (carry == 1)
            stb.insert(0, carry);
        return stb.toString();
    }

    /**
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * @param args
     */
    public static void main(String[] args) {
//        String a = "11";
//        String b = "1";
        String a = "1010";
        String b = "1011";
        String result = new AddBinary().addBinary(a, b);
        System.out.println("result=" + result);
    }

}