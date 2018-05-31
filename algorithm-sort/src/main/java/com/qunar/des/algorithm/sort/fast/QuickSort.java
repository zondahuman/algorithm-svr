package com.qunar.des.algorithm.sort.fast;

import java.util.Arrays;

/**      
 * 创建人：abin
 * 创建时间：2014年10月30日 下午11:02:40     
 * 快速排序
 * https://blog.csdn.net/u010853261/article/details/54884784
 */
public class QuickSort {
	/**
	 * 所谓快速排序：基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点并把基准点放于序列的开头（该基准点的选取可能影响快速排序的效率，
	 * 关于基准点的选择方法后面再讲解），然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，
	 * 如果发现有元素比该基准点的值小，就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
	 * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置，一次排序就完成了。之后再采用递归的方式分别对前半部分和后半部分排序，
	 * 当前半部分和后半部分均有序时该数组自然也就有序了。
	 * @param args
     */
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
		int temp = input[low]; //参照基准数据
		   //枢轴选定后永远不变，最终在中间，前小后大 
		while(low < high){
			while(low<high&&input[high]>temp){ //如果高位的比temp大，继续从右往左走，直到遇到了比temp小的数，然后下面一行把高位交给低位，达到小的数字交给temp左边
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
