package com.qunar.des.algorithm.sort.binary;


/**      
 * 创建人：abin
 * 创建时间：2014年10月31日 下午5:05:55     
 * @version      
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7};
		int result = binary(input, 0, input.length-1, 1);
		System.out.println("result="+result);
	}
	public static int binary(int[] input,int low,int high,int target){
		int middle = (low+high)/2;
		if(target == input[middle]){
			return middle;
		}else if(target < input[middle]){
			return binary(input, low, middle-1, target);
		}else if(target > input[middle]){
			return binary(input, middle+1, high, target);
		}else{
			return -1;
		}
	}
}
