package com.abin.lee.algorithm.special.company.other;

/**
 * Created by abin on 2018/9/3.
 * MT
 */
public class InsertPosition {
    public int getNum(String str) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                flag = false;
            } else if (str.charAt(i) == '0') {
                flag = true;
            }
            if (flag == true && (i + 2) < str.length() && str.charAt(i + 2) == '0' && str.charAt(i + 1) == '0') {
                count++;
            }
        }
        return count;
    }

    public int getNum1(String str) {
        int count = 0;
        int start = 0;
        int end = str.length();
        boolean flag = false;
        while (start < end) {
            if (str.charAt(start) == '1') {
                flag = false;
            } else if (str.charAt(start) == '0') {
                flag = true;
            }
            if (flag == true && (start + 2) < str.length() && str.charAt(start + 2) == '0' && str.charAt(start + 1) == '0') {
                count++;
            }
            ++start;
        }
        return count;
    }

    /**
     * 10001001, 在里面为0的地方插入1，保证不会出现11,1和1挨着的情况
     *
     * @param args
     */
    public static void main(String[] args) {
//        String str = "1000101";
        String str = "000101001";
//        int count = new InsertPosition().getNum(str);
        int count = new InsertPosition().getNum1(str);
        System.out.println("count=" + count);
    }

}
