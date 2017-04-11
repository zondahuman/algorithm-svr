package com.qunar.des.algorithm.sort.binary;


/**      
 * 创建人：subin.li   
 * 创建时间：2014年10月31日 下午5:05:55     
 * @version      
 */
public class BinarySearchWhile {
	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7};
		int result = binary(input, 0, input.length-1, 7);
		System.out.println("result="+result);
	}
	public static int binary(int[] input,int low,int high,int target){
		while(low <= high){
			int middle = (low+high)/2;
			if(input[middle]>target){
				high = middle-1;
			}else if(input[middle]<target){
				low = middle+1;
			}else{
				return middle;
			}
		}
		return -1;
	}
}
