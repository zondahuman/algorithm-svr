package com.abin.lee.algorithm.special.recursive;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 下午8:28
 */
public class MyTest {
    public static int addRecuesive(int num) {
        if (1 == num)
            return 1;
        return addRecuesive(num - 1) + num;
    }
    @Test
    public void testAddRecuesive() {
        int result = addRecuesive(5);
        System.out.println(result);
    }
    public static String transferTwo(int num){

        return null;
    }

}
