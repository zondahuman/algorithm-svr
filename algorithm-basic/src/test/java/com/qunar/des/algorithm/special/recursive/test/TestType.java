package com.qunar.des.algorithm.special.recursive.test;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-24 下午10:24
 */
public class TestType {
    @Test
    public void test1() {
        Integer a = 100;
        Integer b = 100;
        boolean flag = (b==a);
        System.out.println("flag1="+flag);
        boolean status1 = (a.equals(b));
        System.out.println("status1="+status1);
    }
    @Test
    public void test2() {
        Integer a = 128;
        Integer b = 128;
        boolean flag = (b==a);
        System.out.println("flag2="+flag);
        boolean status2 = (a.equals(b));
        System.out.println("status2="+status2);
    }
    @Test
    public void test3() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        boolean flag = (b==a);
        System.out.println("flag3="+flag);
    }
    @Test
    public void test4() {
        Integer a = 15;
        int b = 15;
        boolean flag = (b==a);
        System.out.println("==--flag4="+flag);
//        boolean flag4e = (b.equals(a));
//        System.out.println("equals--flag4e="+flag4e);
    }
    @Test
    public void test5() {
        Integer a = new Integer(15);
        int b = 15;
        boolean flag = (b==a);
        System.out.println("==--flag5="+flag);
    }
    @Test
    public void test6() {
        Integer a = new Integer("15");
        int b = 15;
        boolean flag = (b==a);
        System.out.println("==--flag6="+flag);
    }
    @Test
    public void test7() {
        Integer a = new Integer("15");
        int b = new Integer(15);
        boolean flag = (b==a);
        System.out.println("==--flag7="+flag);
    }
    @Test
    public void test8() {
        Integer a = new Integer(15);
        Integer b = new Integer(15);
        boolean flag = (b==a);
        System.out.println("==--flag8="+flag);
    }
    @Test
    public void test9() {
        short v1 = 18;
        Long v2 = new Long("18");
        Long v3 = new Long(18);
        Short v4 = new Short(v1);
        boolean flag = (v3.equals(v4));
        System.out.println("==--flag9="+flag);
    }
    @Test
    public void test10() {
        String ab = "hello";
        String cd = "hello";
        boolean flag = (ab==cd);
        System.out.println("==--flag10="+flag);
    }
    @Test
    public void test11() {
        String ab = "hello";
        String cd = new String("hello");
        boolean flag = (ab==cd);
        System.out.println("==--flag11="+flag);
    }
}
