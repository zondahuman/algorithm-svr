package com.abin.lee.algorithm.basic.array.median;

import java.util.Arrays;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年10月30日 下午9:12:22     
 * @version      
 */
public class ArrayReverse {
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6};
		reverse(input);
		System.out.println(Arrays.toString(input));
	}
	public static int[] reverse(int[] input) {
		for(int i=0;i<input.length/2;i++){
			int temp = input[i];
			input[i] = input[input.length-i-1];
			input[input.length-i-1] = temp;
		}
		return input;
	}
}
