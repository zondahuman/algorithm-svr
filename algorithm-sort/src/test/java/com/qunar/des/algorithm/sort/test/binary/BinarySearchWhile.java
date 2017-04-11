package com.qunar.des.algorithm.sort.test.binary;

public class BinarySearchWhile {
	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7};
		int result = search(input, 0, input.length-1, 5);
		System.out.println(result);
	}
	public static int search(int[] input,int low,int high,int data){
		while(low<=high){
			int middle = (low+high)/2;
			if(data > input[middle]){
				low = middle+1;
			}else if(data < input[middle]){
				high = middle-1;
			}else {
				return middle;
			}
		}
		return -1;
	}

}
