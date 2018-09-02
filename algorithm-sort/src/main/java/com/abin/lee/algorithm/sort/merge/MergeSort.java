package com.abin.lee.algorithm.sort.merge;

import java.util.Arrays;

/**      
 * 创建人：abin
 * 创建时间：2014年10月30日 下午9:34:24     
 * @version      
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] input = {1,5,2,4,3,6,0,7};
		input = MergeSort.sort(input, 0, input.length-1);
		System.out.println("input="+Arrays.toString(input));
	}
	public static int[] sort(int[] input,int low,int high) {
		int middle = (low + high) / 2;
		if(low < high){
			sort(input, low, middle);
			sort(input, middle+1, high);
			merge(input, low, high, middle);
		}
		return input;
	}
	public static void merge(int[] input,int low,int high,int middle) {
		int[] temp = new int[high-low+1];
		int i = low;
		int j = middle + 1;
		int k = 0;
		while(i <= middle && j <= high){
			if(input[i] < input[j]){
				temp[k++] = input[i++];
			}else{
				temp[k++] = input[j++];
			}
		}
		while(i <= middle){
			temp[k++] = input[i++];
		}
		while(j <= high){
			temp[k++] = input[j++];
		}
		for(int m=0;m<temp.length;m++){
			input[m+low] = temp[m];
		}
	}

}
