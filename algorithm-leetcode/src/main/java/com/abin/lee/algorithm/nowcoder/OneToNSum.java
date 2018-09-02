package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 * 求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * &&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算。
 */
public class OneToNSum {

    public int Sum_Solution(int n) {
        int sum = n;
//        boolean b = (n > 0) && (sum += Sum_Solution(n-1)) > 0;
        boolean b = (n == 0) || (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }


    // 解题思路：
    //        1.需利用逻辑与的短路特性实现递归终止。
    // 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
    //        3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
    // sum+=Sum_Solution(--n))>0  >0是干啥的 这是一个恒成立的判断式，其目的就是累加求和。
    // 设置flag是为了停止递归，当sum值递归到0的时候，&&运算符左边已经不满足true了，直接不进行判断运算符右边，也就是不会在调用递归了
    public int Sum_Solution1(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    //链接：https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1
    //来源：牛客网

    public int Sum_Solution2(int n) {
        return sum(n);
    }

    int sum(int n) {
        try {
            int i = 1 % n;
            return n + sum(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public int sumOneToN(int n){
        int sum = n ;
        boolean flag = (n>0) && ((sum += sumOneToN(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        int result = new OneToNSum().Sum_Solution(3);
        System.out.println("result=" + result);
    }


}
