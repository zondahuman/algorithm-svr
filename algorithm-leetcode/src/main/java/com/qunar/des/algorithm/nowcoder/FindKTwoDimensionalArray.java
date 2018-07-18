package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/18.
 * 二维数组中的查找
 题目描述
 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindKTwoDimensionalArray {

    public boolean Find(int target, int [][] array) {
        int row = array.length-1;;
        int column = 0;
        while(row>=0 && column<=array[0].length-1){
            if(array[row][column] < target){
                column++;
            }else if(array[row][column] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }



}
