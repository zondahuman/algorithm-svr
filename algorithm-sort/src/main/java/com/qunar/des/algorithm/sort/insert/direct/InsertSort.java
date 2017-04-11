package com.qunar.des.algorithm.sort.insert.direct;

import java.util.Arrays;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月6日 下午4:44:41     
 * @version      
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] input = new int[]{6,0,1,5,2,4,3};
		input = insert(input);
		System.out.println(Arrays.toString(input));
	}
	public static int[] insert(int[] input){
		int temp = 0;
		for(int i=0;i<input.length;i++){
			temp= input[i];
			int j = 0;
			for(j=i-1;j>=0&&temp<input[j];j--){
				input[j+1] = input[j];
			}
			input[j+1] = temp;
		}
		return input;
	}
}
