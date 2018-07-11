package com.abin.lee.algorithm.tree.heap;

import java.util.Scanner;

/**
 * Created by abin on 2018/7/10.
 */
public class SmallHeap {
    public static int[] arr;//堆数组，有效数组

    public SmallHeap(int m) {
        arr = new int[m];
    }

    static int m = 0;
    static int size = 0;//用来标记堆中有效的数据

    public static void addToSmall(int v) {
        //int[] a = {16,4,5,9,1,10,11,12,13,14,15,2,3,6,7,8,111,222,333,555,66,67,54};
        //堆的大小为10
        //arr = new int[10];
        if (size < arr.length) {
            arr[size] = v;
            add_sort(size);
            //add_sort1(size);
            size++;
        } else {
            arr[0] = v;
            add_sort1(0);
        }


    }

    public static void printSmall() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void del() {
        size--;
        arr[0] = arr[9];
        add_sort1(0);
    }

    public static void Small(int index) {
        if (m < arr.length) {
            add_sort(index);
            m++;
        } else {
            add_sort1(index);
            m++;
        }
    }

    public static void add_sort(int index) {//小顶堆，建堆
        /*
	        * 父节点坐标：index
	        * 左孩子节点：index*2
	        * 右孩子节点：index*2+1
	        *若数组中最后一个为奇数则为 左孩子
	        *若数组中最后一个为偶数则为 右孩子
	                     若孩子节点比父节点的值大，则进行值交换，若右孩子比左孩子大则进行值交换
		 *
		 */
        int par;
        if (index != 0) {
            if (index % 2 == 0) {
                par = (index - 1) / 2;
                if (arr[index] < arr[par]) {
                    swap(arr, index, par);
                    add_sort(par);
                }
                if (arr[index] > arr[par * 2]) {
                    swap(arr, index, par * 2);
                    if (arr[index] < arr[par]) {
                        swap(arr, index, par);
                    }
                    add_sort(par);
                }

            } else {
                par = index / 2;
                if (arr[index] < arr[par]) {
                    swap(arr, index, par);
                    add_sort(par);
                }
                if (arr[index] < arr[par * 2 + 1]) {
                    swap(arr, index, par * 2 + 1);
                    if (arr[index] < arr[par]) {
                        swap(arr, index, par);
                    }
                    add_sort(par);
                }
            }

        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void add_sort1(int index) {//调整小顶堆
		/*调整自顶向下
		 * 只要孩子节点比父节点的值大，就进行值交换，
		 */
        int left = index * 2;
        int right = index * 2 + 1;
        int max = 0;
        if (left < 10 && arr[left] < arr[index]) {
            max = left;
        } else {
            max = index;
        }
        if (right < 10 && arr[right] < arr[max]) {
            max = right;
        }
        if (max != index) {
            swap(arr, max, index);
            add_sort1(max);
        }
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("(小顶堆)请输入堆大小：");
        int m = scan.nextInt();
        SmallHeap test = new SmallHeap(m);
        int[] a = {16, 4, 5, 9, 1, 10, 11, 12, 13, 14, 15, 2, 3, 6, 7, 8};
        for (int i = 0; i < a.length; i++) {
            test.addToSmall(a[i]);
        }
        test.printSmall();
        test.del();
        test.printSmall();

        scan.close();
    }

}
