package com.abin.lee.algorithm.leetcode.common;

/**
 * Created by abin on 2018/7/18.
 * 最小的K个数
 * <p>
 * 思路一:排序法,  对n个数排序,然后迭代前k个数即可,时间复杂度以 快排为准 是O(nlogn),代码略
 * 思路二:局部替换法   假设前k个数就是整个数组中最小的,找出最大的数和k+1比较,如果比k+1大就和K=1互换位置,然后再将k数组中的最大数找出,在进行比较,知道数组末尾.时间复杂度O(nk)
 * https://blog.csdn.net/yangchangji/article/details/60141016
 */
public class KthSmallestElementInArray {


    /**
     * 思路 二
     * 把整个数组分为k和n-k 2部分,找出最小的K个数的过程其实就是把最大的数放到n-k部分的过程,每次比较都把最大的数交换到n-k的部分里面。
     * 1.把最先遍历到的k个数赋值到大小为k的数组2中
     * 2.在数组2中找出最大元素max,时间复杂度是o(k),因为如果
     * 3.在数组1中遍历剩下的n-k个数,和max比较,如果小于max则交换位置,重复2的过程 o(k)+(n-k)o(k)=n*o(k)
     **/
    public static void scheme1(int[] ins, int k) {
        int[] ks = new int[k];
        // 最先遍历的k个数放入数组中 o(k)
        for (int i = 0; i < k; i++) {
            ks[i] = ins[i];
        }
        for (int i = k; i < ins.length; i++) {
            if (getMax(ks) > ins[i]) {
                ks[0] = ins[i];
            }
        }
        // 输出最小的K个数
        for (int i = 0; i < k; i++) {
            System.out.print(ks[i] + " ");
        }
    }

    public static int getMax(int[] arr) {
        // 选择一个基数,分别于数组中其他元素比较,始终保持基数对应的指针是最大值
        int radix = 0;
        for (int i = 0; i < arr.length; i++) {
            // 如果sub小于旁边值则交互位置
            if (arr[radix] < arr[i]) {
                int temp = arr[radix];
                arr[radix] = arr[i];
                arr[i] = temp;
            }
        }
        return arr[radix];
    }


    /**
     * 下面是方法三
     *
     * @param array
     */

    public static void headSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
    }

    /**
     * 创建堆
     */
    public static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //从最后的一个非叶子节点向上开始排,避免迭代没有意义的叶子节点
        int half = (array.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 调整堆(沉降法)
     * logn
     */
    public static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        //判断有没有左节点,如若有则比较替换largest
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        //判断有没有右节点,如若有则largest和右节点比较,注意largest有可能是left也有可能是index
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            //被替换的largest节点所在的堆,需要重新调整,使小值/大值一直下沉
            maxHeap(array, heapSize, largest);
        }

    }

    /**
     * 思路二 最大堆法
     * 利用树形的特点保存前面比较的结果,可以减少比较次数s
     */
    public static void scheme2(int[] ins, int k) {
        int[] ks = new int[k];
        // 最先遍历的k个数放入数组中 o(k)
        for (int i = 0; i < k; i++) {
            ks[i] = ins[i];
        }
        //构建前k个数的最大堆
        headSort(ks);
        //n-k个数和前面和k中最大数比较
        for (int i = k; i < ins.length; i++) {
            //如果堆顶大于n-k中数,则交换位置
            if (ks[0] > ins[i]) {
                ks[0] = ins[i];
                //调整堆,堆顶被替换了,加入被替换的值非常小,会一直下沉到叶子节点.
                maxHeap(ks, ks.length, 0);
            }

        }
        // 输出最小的K个数
        for (int i = 0; i < k; i++) {
            System.out.print(ks[i] + " ");
        }
    }


    public static void main(String[] args) {
        // 前key个最小的数
        int k = 6;
//        int[] ins = new int[]{8, 6, 10, 9, 7, 2, 1, 20, 13};
        int[] ins = new int[]{1, 6, 7, 8, 9, 2, 3, 5, 4};
        //使用方法二解决
        //scheme1(ins, k);
        //最大堆
        scheme2(ins, k);
    }


}
