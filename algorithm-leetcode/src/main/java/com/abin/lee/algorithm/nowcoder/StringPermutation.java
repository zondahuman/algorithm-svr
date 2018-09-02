package com.abin.lee.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by abin on 2018/7/19.
 * 字符串的排列
 题目描述
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>() ;
        if(str.equals("") || str == null)
            return list;
        TreeSet<String> treeSet = new TreeSet<String>();
        char[] chars = str.toCharArray();
        Permutation(chars, 0, treeSet);
        list.addAll(treeSet);
        return list;
    }
    public void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars == null || chars.length==0 || begin<0 || begin > chars.length-1)
            return;
        if(begin == chars.length-1){
            result.add(String.valueOf(chars));
        }else{
            for (int i = 0; i <chars.length ; i++) {
                swap(chars, begin, i);
                Permutation(chars, begin+1, result);
                swap(chars, begin, i);
            }
        }
    }
    public void swap(char[] chars, int a, int b){
        char temp = chars[a] ;
        chars[a] = chars[b] ;
        chars[b] = temp ;
    }






}
