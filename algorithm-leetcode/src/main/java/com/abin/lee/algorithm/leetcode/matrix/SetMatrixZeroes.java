package com.abin.lee.algorithm.leetcode.matrix;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/9/10.
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26056/Java-2-solutions:-space-O(1)-and-O(m+n)-with-explaination
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        for (int row : rowSet)
            for (int i = 0; i <columnLength ; i++)
                matrix[row][i] = 0;
        for(int column:columnSet)
            for (int i = 0; i <rowLength ; i++)
                matrix[i][column] = 0;
    }

    public static void main(String[] args) {
//        int[][] params = {
//                {1,2,3,4},
//                {5,1,2,3},
//                {9,5,1,2},
//        };
        int[][] params = {
                {1, 0},
                {2, 2},
        };
        new SetMatrixZeroes().setZeroes(params);
        System.out.println("params=" + JsonUtil.toJson(params));
    }



    public void setZeroes1(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1||col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    
}
