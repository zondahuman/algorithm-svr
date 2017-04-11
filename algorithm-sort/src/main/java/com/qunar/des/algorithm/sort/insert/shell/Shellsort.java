package com.qunar.des.algorithm.sort.insert.shell;

import java.util.Arrays;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月6日 下午4:23:40     
 * http://en.wikipedia.org/wiki/Shellsort  
 */
public class Shellsort {
	public static void main(String[] args) {
		int[] input = new int[]{5,0,1,4,2,3};
		input = shell(input);
		System.out.println(Arrays.toString(input));
	}
	public static int[] shell(int[] input) {
		for(int increment=input.length/2;increment>0;increment-=2){
			for(int i=increment;i<input.length;i++){
				int temp = input[i];
				int j = 0;
				for(j=i;j>=increment;j-=increment){
					if(temp < input[j-increment]){
						input[j] = input[j-increment];
					}else {
						break;
					}
				}
				input[j] = temp;
			}
		}
		return input;
	}
}
