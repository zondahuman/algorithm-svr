package com.abin.lee.algorithm.basic.strings.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abin on 2018/6/24.
 */
public class StringCommonTest {
    public static void main(String[] args) {
//        char[] cha = {'s','g','h'};
        char[] cha = {'1','3','5'};
        String result = String.valueOf(cha);
        System.out.println(result);
        System.out.println("---="+Arrays.toString(cha));

    }

    @Test
    public void testString1(){
        char[] cha = new char[3];
        for (int i = 0; i <3 ; i++) {
            cha[i] = (char)(i+1);
        }
        String result = String.valueOf(cha);
        System.out.println("result="+result);
    }
    @Test
    public void testString2(){
        String result = "";
        for (int i = 0; i <3 ; i++) {
            result += String.valueOf(i+1);
        }

        System.out.println("result="+result);
    }





}
