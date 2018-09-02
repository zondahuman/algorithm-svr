package com.abin.lee.algorithm.leetcode.greedy;

/**
 * Created by abin on 2018/8/26.
 * 860.Lemonade Change
 * 柠檬水找零
 * https://leetcode.com/problems/lemonade-change/description/
 * https://blog.csdn.net/qq_38959715/article/details/80918681
 * https://blog.csdn.net/lym940928/article/details/80909584
 */
public class LemonadeChange {
    /**
     * Input: [5,5,5,10,20]
     * Output: true
     * Input: [5,5,10]
     * Output: true
     * Input: [10,10]
     * Output: false
     * <p>
     * Time Complexity: O(N)O(N), where NN is the length of bills.
     * <p>
     * Space Complexity: O(1)O(1).
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) five++;
            if (bills[i] == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            }
            if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 5;
        num -= 3;
        System.out.println("num=" + num);
//        int[] param = new int[] {5,5,5,10,20};
//        int[] param = new int[] {5,5,10};
        int[] param = new int[]{10, 10};
        boolean result = new LemonadeChange().lemonadeChange(param);
        System.out.println("result=" + result);
    }


}
