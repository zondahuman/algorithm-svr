package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 */
public class NumberOfOne {

    public int NumberOf1(int n) {
        int count = 0;
        char[] char1 = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i <char1.length ; i++) {
            if(char1[i] == '1')
                count++;
        }
        return count;
    }
}
