package com.abin.lee.algorithm.basic.string.reverse;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-24 上午1:33
 */
public class ReverseMatrix {
    public void rotation(int[][] matrixParam) {
        int len = matrixParam.length;
        for (int i = 0; i < len; i++) {
            int[] innerArray = matrixParam[i];
            for (int j = 0; j < innerArray.length; j++) {
                if (j > i) {
                    int temp = matrixParam[i][j];
                    matrixParam[i][j] = matrixParam[j][i];
                    matrixParam[j][i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        ReverseMatrix reverseMatrix=new ReverseMatrix();
        reverseMatrix.rotation(matrix);
        for (int i = 0; i < matrix.length; i++) {
            int[] innerArray = matrix[i];
            for (int j = 0; j < innerArray.length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
