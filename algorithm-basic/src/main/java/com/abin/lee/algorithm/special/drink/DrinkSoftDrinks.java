package com.abin.lee.algorithm.special.drink;

/**
 * Created by abin on 2017/11/20 16:46.
 * algorithm-svr
 * com.qunar.des.algorithm.special.drink
 * 问题：一瓶汽水单价2.5元，四个瓶盖或者两个瓶子可以换取一瓶汽水。给定金额得出一共能喝几瓶汽水？
 */
public class DrinkSoftDrinks {

    public static void main(String[] args) {
        int result = drink(17);
        System.out.println("result=" + result);
    }

    public static int drink(double money) {
        double total = money / 2.5;
        int num = (int) total;
        int bottleCap = num; //瓶盖
        int emptyBottle = num;  //空瓶
        while (bottleCap >= 4 || emptyBottle >= 2) {
            int i = (bottleCap / 4) + (emptyBottle / 2);
            num = num + i;
            bottleCap = bottleCap % 4 + i;
            emptyBottle = emptyBottle % 2 + i;
        }
        return num;
    }


}
