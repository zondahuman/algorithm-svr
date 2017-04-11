package com.qunar.des.algorithm.sort.fast;

import java.util.Arrays;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年10月30日 下午11:02:40     
 * @version      
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] input = {1,5,2,6,0};
		QuickSort.quick(input, 0, input.length-1);
		System.out.println("input="+Arrays.toString(input));
	}
	/* 
	 * 先按照数组为数据原型写出算法，再写出扩展性算法。
	 */  
	public static void quick(int[] input,int low,int high) {
		if(low < high){
			//middle作为枢轴，较之小的元素在左，较之大的元素在右  
			int middle = getMiddle(input, low, high);
			//对左右数组递归调用快速排序，直到顺序完全正确  
			quick(input, low, middle-1);
			quick(input, middle+1, high);
		}
	}
	public static int getMiddle(int[] input,int low,int high){
		int temp = input[low];
		   //枢轴选定后永远不变，最终在中间，前小后大 
		while(low < high){
			while(low<high&&input[high]>temp){
				high--;
			}
			//将比枢轴小的元素移到低端，此时high位相当于空，等待低位比temp大的数补上
			input[low]=input[high];
			while(low<high && input[low]<temp){
				low++;
			}
			 //将比枢轴大的元素移到高端，此时low位相当于空，等待高位比temp小的数补上
            input[high] = input[low];
		}
		input[low] = temp;
		return low;
	}

}
