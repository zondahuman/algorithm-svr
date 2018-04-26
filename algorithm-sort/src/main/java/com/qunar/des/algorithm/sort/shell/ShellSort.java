package com.qunar.des.algorithm.sort.shell;

import java.util.Arrays;

/**      
 * 创建人：abin
 * 创建时间：2014年11月7日 下午2:04:41     
 * @version      
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] input = new int[]{6,0,5,1,4,2,3};
		input = shell(input);
		System.out.println(Arrays.toString(input));
	}
	public static int[] shell(int[] input) {
		for(int increment=input.length/2;increment>0;increment-=2){
			for(int i=increment;i<input.length;i++){
				int temp = input[i];
				int j = 0;
				for(j=i;j>=increment;j-=increment){
					if(temp<input[j-increment]){
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
