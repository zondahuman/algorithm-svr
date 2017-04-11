package com.qunar.des.algorithm.sort.test.bubble;

import java.util.Arrays;

public class BubbleSort {
	public static int[] bubble(int[] input){
		int temp = 0;
		for(int i=0;i<input.length-1;i++){
			for(int j=0;j<input.length-i-1;j++){
				if(input[j]>input[j+1]){
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
		return input;
	}
	public static void main(String[] args) {
		int[] input = new int[]{1,0,4,3,5,2,6,9,8,7};
		input = bubble(input);
		System.out.println(Arrays.toString(input));
	}

}
