package com.qunar.des.algorithm.basic.string.reverse;

/**
 * @author: hejixiang
 * @since:${version} 本类旨在实现字符串反转:
 */
public class StringReverser {

    /**
     * 直接分配一个新的数组，然后从字符串尾部开始读，存入新数组中，完成后转回字符串
     * @param src
     * @return
     */
    public static String reverseDirect(String src) {
        char[] arr = new char[src.length()];
        for (int i = 0; i < src.length(); i++) {
            arr[i] = src.charAt(src.length() - 1 - i);
        }
        return new String(arr);
    }

    /**
     * 借助栈翻转，先入栈，再出栈就完成了翻转
     * @param src
     * @return
     */
    public static String reverseByStack(String src) {
        Stack<Character> stack = new Stack<Character>(src.length());
        for (int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));
        }
        String s = "";
        while (stack.getSize() != 0) {
            s += stack.pop();
        }
        return s;
    }

    /**
     * 折半交换，需要一个临时变量存储其中一个字符。
     * @param src
     * @return
     */
    public static String reverseByExchange(String src) {
        char[] arr = src.toCharArray();
        int i = 0;
        while (i < src.length() - 1 - i) {
            char t = arr[i];
            arr[i] = arr[src.length() - 1 - i];
            arr[src.length() - 1 - i] = t;
            i++;
        }
        return new String(arr);
    }

    /**
     * 折半通过ascii码加减完成交换，需要一个临时变量存储两个字符ascii差值
     * @param src
     * @return
     */
    public static String reverseByAscii(String src) {
        char[] arr = src.toCharArray();
        int i = 0;
        while (i < src.length() - 1 - i) {
            int im = arr[i] - arr[src.length() - 1 - i];
            System.out.println((int)arr[i]);
            System.out.println((int)arr[src.length() - 1 - i]);
            System.out.println(im);
            arr[i] = (char) ((int) arr[i] - im);
            arr[src.length() - 1 - i] = (char) ((int) arr[src.length() - 1 - i] + im);
            i++;
        }
        return new String(arr);
    }

    /**
     * 递归完成翻转，当然利用的是方法栈
     * @param src
     * @return
     */
    public static String reverseByRecursive(String src) {
        if(src.length()==1){
            return src;
        }else{
            return reverseByRecursive(src.substring(1))+src.substring(0,1);
        }
    }
    public static String reverseByExclusiveOr(String src) {
        char[] arr = src.toCharArray();
        int i = 0;
        while (i < src.length() - 1 - i) {
            char t = (char)(arr[i]^arr[src.length() - 1 - i]);
            arr[i] = (char)(arr[i]^t);
            arr[src.length() - 1 - i] = (char)(arr[src.length() - 1 - i]^t);
            i++;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
//        System.out.println("reverseDirect:"+reverseDirect("abcde"));
        System.out.println("reverseByStack:" + reverseByStack("abcde"));
//        System.out.println("reverseByExchange:" + reverseByExchange("abcde"));
//        System.out.println("reverseByAscii:" + reverseByAscii("abcde"));
//        System.out.println("reverseByRecursive:" + reverseByRecursive("abcde"));
    }

}
