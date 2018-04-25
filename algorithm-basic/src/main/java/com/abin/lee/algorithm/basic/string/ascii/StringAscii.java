package com.abin.lee.algorithm.basic.string.ascii;

/**
 * Created by abin on 2018/4/18 19:04.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.string.ascii
 */
public class StringAscii {

    public static void main(String[] args) {
        str2Ascii();
        str2Ascii2();
    }

    public static void str2Ascii() {// 字符串转换为ASCII码
        String str = "111111";// 字符串
        char[] chars = str .toCharArray(); // 把字符中转换为字符数组
        for (int i = 0; i < chars.length; i++) {// 输出结果
            System.out.println( chars[i] + " 转换结果为：" + (int) chars[i]);
        }
    }

    /**
     * 输出Ascii
     */
    public static void str2Ascii2() {// 字符串转换为ASCII码
        String str = "1a1b1c";// 字符串
        char[] chars = str .toCharArray(); // 把字符中转换为字符数组
        for (int i = 0; i < chars.length; i++) {// 输出结果
            System.out.println( chars[i] + " 转换结果为：" + (int) chars[i]);
        }
    }



}
