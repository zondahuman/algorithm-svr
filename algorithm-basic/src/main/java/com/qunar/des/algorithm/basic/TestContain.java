package com.qunar.des.algorithm.basic;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-24 下午11:16
 */
public class TestContain {
    public static boolean bao(String str,String sub){
        char[] father = str.toCharArray();
        char[] son = sub.toCharArray();
        int slength = 0;
        for(int i=0;i<father.length;i++){
            if(father[i] == son[slength++]){
                 if(slength == son.length)
                     return true;
            }else{
                slength = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        String sub = "cdefg";
        boolean flag = bao(str, sub);
        System.out.println(flag);
    }
}
