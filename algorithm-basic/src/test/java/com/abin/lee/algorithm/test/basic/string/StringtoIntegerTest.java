package com.abin.lee.algorithm.test.basic.string;

/**
 * Created by abin on 2018/6/25.
 */
public class StringtoIntegerTest {
    public static void main(String[] args) {
        String param = "1234" ;
        Integer result = transfer(param);
        System.out.println("result="+result);
    }

    public static Integer transfer(String str){
        int sign = 1 ;
        int index = 0;
        if(str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        int num = 0;
        for (;index<str.length();index++){
            num = num*10 + (str.charAt(index)-'0');
        }
        return sign*num;
    }


}
