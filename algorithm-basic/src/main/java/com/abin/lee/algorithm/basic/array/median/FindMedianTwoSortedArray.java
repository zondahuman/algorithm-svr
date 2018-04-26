package com.abin.lee.algorithm.basic.array.median;

/**
 * 创建人：abin
 * 创建时间：2014年11月16日 下午6:09:36
 *
 */
public class FindMedianTwoSortedArray {

	public static int median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
    {
		System.out.println("-----------");
        int mid1 = (h1 + l1 ) / 2;
        int mid2 = (h2 + l2 ) / 2;

        if (h1 - l1 == 1)
            return (Math.max(arr1[l1] , arr2[l2]) + Math.min(arr1[h1] , arr2[h2]))/2;
        else if (arr1[mid1] > arr2[mid2])
            return median(arr1, l1, mid1 , arr2, mid2 , h2);    
        else
            return median(arr1, mid1 , h1, arr2, l2 , mid2 );    
    }     
	public static void main(String[] args) {
//		int[] a = new int[]{0,1,2};
//		int[] b = new int[]{1,2,3};
		int[] a = new int[]{0,1,2,3};
		int[] b = new int[]{0,1,2,3};
//		int[] b = new int[]{3,5,6,7};
		int result = median(a, 0, a.length-1,b,0,b.length-1);
		System.out.println(result);
	}
}
