package com.abin.lee.algorithm.basic.array.common;

/**
 * Created by abin on 2018/5/31 0:15.
 * algorithm-svr
 * com.abin.lee.algorithm.basic.array.common
 * 数组中第k大的数
 * https://blog.csdn.net/hqtc0704/article/details/74390512
 * https://www.cnblogs.com/shixiangwan/p/7529980.html
 */
public class FindKBigInAnyArray {
    public static int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (arr[high] <= temp && high > low)
                --high;
            arr[low] = arr[high];
            while (arr[low] >= temp && low < high)
                ++low;
            arr[high] = arr[low];
        }
        arr[high] = temp;
        return high;
    }

    public static void find_k(int k, int[] arr, int low, int high) {
        int temp = partition(arr, low, high);
        if (temp == k - 1) {
            System.out.print("第" + k + "大的数是：" + arr[temp]);
        } else if (temp > k - 1) {
            find_k(k, arr, low, temp - 1);
        } else {
            find_k(k - temp, arr, temp + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 7, 6};
        find_k(2, arr, 0, arr.length - 1);
    }

    /**
     * 类似于快速排序，执行一次快速排序之后，每次只选择一部分继续执行快速排序，直到找到第K大个元素为止，这个元素在数组位置后面的元素即为所求。

     时间复杂度：O（n）

     利用快排的思想，从数组arr中随机找出一个元素X，把数组分成两部分arr_a和arr_b。

     arr_a中的元素比x大，arr_b中的元素比x小。

     这个时候分为两种情况：

     1.arr_a中的元素小于K，则arr_b中第k-arr_a.length个元素即为第K大数。

     2.arr_a中的元素大于等于K，则返回arr_a中第K大数

     */

}
