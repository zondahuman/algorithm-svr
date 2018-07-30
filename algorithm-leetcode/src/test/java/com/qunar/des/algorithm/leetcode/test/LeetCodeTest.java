package com.qunar.des.algorithm.leetcode.test;

/**
 * Created by abin on 2018/7/18.
 */
public class LeetCodeTest {
    public static void main(String[] args) {
        int param = 1 << 30;
        System.out.println("param="+param);
    }


    public String replaceSpace(StringBuffer str) {
        if(str ==null || str.equals(""))
            return "";
        StringBuffer res = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }



}
