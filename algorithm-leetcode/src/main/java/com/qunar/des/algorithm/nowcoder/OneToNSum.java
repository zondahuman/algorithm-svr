package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 * 求1+2+3+...+n
 题目描述
 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class OneToNSum {

    public int Sum_Solution(int n) {
        int sum = n;
        //boolean b = (n > 0) && (sum += Sum_Solution(n-1)) > 0;
        boolean b = (n == 0) || (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        int result = new OneToNSum().Sum_Solution(3);
        System.out.println("result="+result);
    }


}
