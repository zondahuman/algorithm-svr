package com.qunar.des.algorithm.special.recursive.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-21 下午11:50
 */
public class ForTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<5000;i++){
            list.add(11);
        }
//        long tempfor = System.currentTimeMillis();
        for(int i=0;i<list.size();i++){
//            System.out.println("for="+list.get(i));
        }
//        System.out.println(System.currentTimeMillis()-tempfor);
//        long tempeach = System.currentTimeMillis();
        for(int temp:list){
//            System.out.println("foreach="+temp);
        }
//        System.out.println(System.currentTimeMillis()-tempeach);


    }
}
