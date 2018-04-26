package com.abin.lee.algorithm.special.common;

import java.util.Scanner;

/**
 * Created by abin on 2018/4/26 10:34.
 * algorithm-svr
 * com.abin.lee.algorithm.special.common
 * 汉诺塔问题
 * https://www.cnblogs.com/tonglin0325/p/5362236.html
 * https://blog.csdn.net/da_jie/article/details/50866741
 */
public class HanoiTower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int param = scanner.nextInt();
//        move(param, 1, 2, 3);
        move(param, 'a', 'b', 'c');
    }

    public static void move(int n, int a, int b, int c){
        if(n == 1){
            System.out.println("盘 " + n + " 由 " + a + " 移动到 " + c);
        }else{
            move(n-1, a, c, b);
            System.out.println("盘 " + n + " 由 " + a + " 移动到 " + c);
            move(n-1,b, a, c);
        }
    }

    public static void move(int n, char a, char b, char c){
        if(n == 1){
            System.out.println("盘 " + n + " 由 " + a + " 移动到 " + c);
        }else{
            move(n-1, a, c, b);
            System.out.println("盘 " + n + " 由 " + a + " 移动到 " + c);
            move(n-1,b, a, c);
        }
    }


}
