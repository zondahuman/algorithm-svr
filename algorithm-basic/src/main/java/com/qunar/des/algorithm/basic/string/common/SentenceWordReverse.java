package com.qunar.des.algorithm.basic.string.common;

/**
 * Created by abin on 2017/12/7 13:48.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.string.common
 * 字符串中句子的反转（比如ABC DEF，输出DEF ABC）
 */
public class SentenceWordReverse {

    /**
     * 空格符:\s
     * 换行符:\n
     * \\ 反斜杠
     \' 单引号'
     \" 双引号"
     \uxxxx 以十六进制指定Unicode字符输出
     \dxxx 以八进制指定Unicode字符输出
     \b 倒退一个字符
     \f 换页
     \n 换行
     \r 光标移至行首
     \t 跳格（一个TAB键）
     * @param args
     */
    public static void main(String[] args) {
        String input = "i am a student";
        String result = reverseWord(input);
        System.out.printf("result="+result);
    }

    public static String reverseWord(String param){
        String[] sentence = param.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = sentence.length-1; i >= 0; i--) {
            buffer.append(sentence[i]).append(" ");
        }
        return buffer.toString();
    }





}
