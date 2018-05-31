package com.qunar.des.algorithm.sort.binary;


/**      
 * 创建人：abin
 * 创建时间：2014年10月31日 下午5:05:55     
 * 二分查找法：
 * https://www.cnblogs.com/yoyohong/p/5759138.html
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] input = new int[]{0,1,2,3,4,5,6,7};
//		int result = binaryRecursive(input, 0, input.length-1, 4);
//		System.out.println("result="+result);
		int result1 = binaryLoop(input, 0, input.length-1, 4);
		System.out.println("result1="+result1);
	}

	/**
	 * 二分查找递归
	 * @param input
	 * @param low
	 * @param high
	 * @param target
     * @return
     */
	public static int binaryRecursive(int[] input,int low,int high,int target){
		int middle = (low+high)/2;
		if(target == input[middle]){
			return middle;
		}else if(target < input[middle]){
			return binaryRecursive(input, low, middle-1, target);
		}else if(target > input[middle]){
			return binaryRecursive(input, middle+1, high, target);
		}else{
			return -1;
		}
	}

	/**
	 * 二分查找循环
	 * @param input
	 * @param low
	 * @param high
	 * @param target
     * @return
     */
	public static int binaryLoop(int[] input,int low,int high,int target){
		while(low <= high){
			int middle = (low+high)/2;
			if(input[middle]>target){
				high = middle-1;
			}else if(input[middle]<target){
				low = middle+1;
			}else{
				return middle;
			}
		}
		return -1;
	}

	/**
	 * 1.二分查找又称折半查找，它是一种效率较高的查找方法。

	 2.二分查找要求：（1）必须采用顺序存储结构 （2）.必须按关键字大小有序排列

	 3.原理：将数组分为三部分，依次是中值（所谓的中值就是数组中间位置的那个值）前，中值，中值后；将要查找的值和数组的中值进行比较，若小于中值则在中值前 面找，若大于中值则在中值后面找，等于中值时直接返回。然后依次是一个递归过程，将前半部分或者后半部分继续分解为三部分。

	 4.实现：二分查找的实现用递归和循环两种方式
	 */


}
