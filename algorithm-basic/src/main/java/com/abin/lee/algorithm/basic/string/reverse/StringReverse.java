package com.abin.lee.algorithm.basic.string.reverse;

import java.util.Stack;

/**
 * 创建人：abin
 * 创建时间：2014年10月30日 下午9:16:31
 */
public class StringReverse {
    /**
     * 通过 StringBuffer 完成交换
     *
     * @param str
     * @return
     */
    public static String reverseDirect(String str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            buffer.append(str.charAt(i));
        }
        return buffer.toString();
    }

    /**
     * 通过char[]来完成交换
     *
     * @param str
     * @return
     */
    public static String reverseChar(String str) {
        char[] arrayer = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arrayer[i] = str.charAt(str.length() - i - 1);
        }
        return new String(arrayer);
    }

    /**
     * 折半交换
     *
     * @param str
     * @return
     */
    public static String reverseExchange(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        while (i < str.length() - 1 - i) {
            char t = arr[i];
            arr[i] = arr[str.length() - 1 - i];
            arr[str.length() - 1 - i] = t;
            i++;
        }
        return new String(arr);
    }

    /**
     * 通过栈来实现
     *
     * @param str
     * @return
     */
    public static String reverseStack(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += stack.pop();
        }
        return result;
    }

    /**
     * 递归实现字符串反转
     *
     * @param str
     * @return
     */
    public static String reverseRecursive(String str) {
        if (str.length() == 1)
            return str;
        else
            return reverseRecursive(str.substring(1)) + str.charAt(0);
    }

    /**
     * 折半ASCII交换
     * @param str
     * @return
     */
    public static String reverseAscii(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        while (i < str.length() - 1 - i) {
            int im = arr[i] - arr[str.length() - 1 - i];
            arr[i] = (char) (arr[i] - im);
            arr[str.length() - i - 1] = (char) (arr[str.length() - 1 - i] + im);
            i++;
        }
        return new String(arr);
    }

    /**
     * 折半抑或ASCII交换
     * @param str
     * @return
     */
    public static String reverseByASCII(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        while (i < str.length() - 1 - i) {
            char temp = (char) (arr[i] ^ arr[str.length() - 1 - i]);
            arr[i] = (char) (temp ^ arr[i]);
            arr[str.length() - 1 - i] = (char) (temp ^ arr[str.length() - 1 - i]);
            i++;
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        String str = "abcdefg";
//		String result = reverseDirect(str);
//        String result = reverseChar(str);
//        String result = reverseExchange(str);
//        String result = reverseStack(str);
//        String result = reverseRecursive(str);
//        String result = reverseAscii(str);
        String result = reverseByASCII(str);
        System.out.println(result);
    }
}
