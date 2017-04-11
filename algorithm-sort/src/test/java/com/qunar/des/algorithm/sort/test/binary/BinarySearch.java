package com.qunar.des.algorithm.sort.test.binary;

public class BinarySearch {
	public static int search(int[] input,int low,int high,int data){
		int middle = (low+high)/2;
		if(input[middle] == data){
			return middle;
		}else if(input[middle] < data){
			return search(input, middle+1, high, data);
		}else if(input[middle] > data){
			return search(input, low, middle-1, data);
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7};
		int result = search(input, 0, input.length-1, 5);
		System.out.println(result);
	}

}
