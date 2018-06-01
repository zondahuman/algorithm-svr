package com.qunar.des.algorithm.sort.test.binary;

public class BinarySearchTest {

    public static void main(String[] args) {
        int[] param = new int[]{1, 3, 5, 7, 9, 11, 13};
        int searchLoop = searchLoop(param, 0, param.length - 1, 9);
        System.out.println("searchLoop=" + searchLoop);
        int searchRecursive = searchRecursive(param, 0, param.length - 1, 9);
        System.out.println("searchRecursive=" + searchRecursive);
    }

    public static int searchLoop(int[] param, int low, int high, int target) {
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (param[middle] == target) {
                return middle;
            } else if (param[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return middle;
    }

    public static int searchRecursive(int[] param, int low, int high, int target) {
        int middle = (low + high) / 2;
        if (param[middle] == target) {
            return middle;
        } else if (param[middle] > target) {
            searchRecursive(param, low, middle - 1, target);
        } else if (param[middle] < target) {
            searchRecursive(param, middle + 1, high, target);
        } else {
            return -1;
        }
        return middle;
    }


}
