package com.qunar.des.algorithm.sort.test.quick;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] input = new int[]{3,0,5,1,4,2,6};
		quick(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
	}
	public static void quick(int[] input,int low,int high){
		if(low<high){
			int middle = getMiddle(input, low, high);
			quick(input, low, middle-1);
			quick(input, middle+1, high);
		}
	}
	public static int getMiddle(int[] input,int low,int high){
		int temp = input[low];
		while(low<high){
			while(low<high && input[high]>temp){
				high--;
			}
			input[low] = input[high];
			while(low<high && input[low]<temp){
				low++;
			}
			input[high] = input[low];
		}
		input[low] = temp;
		return low;
	}

}
