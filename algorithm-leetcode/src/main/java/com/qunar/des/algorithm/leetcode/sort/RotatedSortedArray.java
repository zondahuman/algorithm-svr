package com.qunar.des.algorithm.leetcode.sort;

import org.apache.commons.io.EndianUtils;


/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月10日 下午3:41:56     
 * Find Minimum in Rotated Sorted Array    
 */
public class RotatedSortedArray {
	public static void main(String[] args) {
//		int[] num = new int[]{0,1,2,4,5,6,7};
//		int[] num = new int[]{4,5,6,7,0,1,2};
//		int[] num = new int[]{1,2};
		int[] num = new int[]{3,1,2};
		int result = new RotatedSortedArray().findMin(num);
		System.out.println("result="+result);
	}

	public int findMin(int[] num) {
		int low = 0; 
		int high = num.length-1;
		if(num[low]<num[high])
			return num[0];
		while(high-low>1){
			int middle = (low+high)/2;
			if(num[low]<num[middle]){
				low = middle;
			}else{
				high = middle;
			}
		}
		return num[high];
	}

}
