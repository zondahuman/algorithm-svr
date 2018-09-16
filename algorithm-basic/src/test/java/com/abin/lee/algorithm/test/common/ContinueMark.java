package com.abin.lee.algorithm.test.common;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by abin on 2017/11/13 13:19.
 * algorithm-svr
 * com.abin.lee.algorithm
 */
public class ContinueMark {

    public static void main(String[] args) {
        test1();
//        test2();

    }


    public static void test1() {
        System.out.println("continue--test1--start");
        for (int i = 0; i <5 ; i++) {
            if(i%2 != 1){
//                System.out.println("i%2="+ i);
                continue;
            }else{
                System.out.println("oridinal--test1--output="+i);
            }
        }
        System.out.println("continue--test1--end");

    }

    public static void test2() {
        System.out.println("continue--test2--start");
        searchLoop:
        for (int i = 0; i <5 ; i++) {
            if(i%2 != 1){
//                System.out.println("i%2="+ i);
                continue searchLoop;
            }else{
                System.out.println("oridinal--test2--output="+i);
            }
        }
        System.out.println("continue--test2--end");

    }


}
