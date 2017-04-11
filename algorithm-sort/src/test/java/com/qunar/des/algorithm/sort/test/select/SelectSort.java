package com.qunar.des.algorithm.sort.test.select;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] input = new int[]{1,0,4,3,5,2,6,9,8,7};
		input = select(input);
		System.out.println(Arrays.toString(input));
	}
	public static int[] select(int[] input){
		int temp = 0;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				if(input[i]>input[j]){
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}

}
