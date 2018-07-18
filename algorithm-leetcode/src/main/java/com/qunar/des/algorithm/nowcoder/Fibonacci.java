package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Fibonacci {
    public static void main(String[] args) {
        int result = new Fibonacci().Fibonacci(7);
        System.out.println("result=" + result);
        int result2 = new Fibonacci().Fibonacci(7);
        System.out.println("result2=" + result2);
    }


    public int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public int FibonacciLoop(int n) {
        int one = 1;
        int two = 1;
        int target = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                target = one + two;
                two = one;
                one = target;
            }
        }
        return target;
    }


}
