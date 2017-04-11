package com.qunar.des.algorithm.leetcode.pascal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月7日 下午11:19:45     
 * Two Sum     
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int[] result = new TwoSum().twoSum2(numbers, 9);
		System.out.println(Arrays.toString(result));
	}
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer,Integer> response = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			if(response.containsKey(target-numbers[i])){
				return new int[]{response.get(target-numbers[i]),i+1};
			}
			response.put(numbers[i], i+1);
		}
		return new int[]{0,0};
	}
	public int[] twoSum1(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++){
        	int temp = target-numbers[i];
        	for(int j=i+1;j<numbers.length;j++){
        		if(temp == numbers[j]){
        			return new int[]{i+1,j+1};
        		}
        	}
        }
        return new int[]{0,0}; 
    }
	public int[] twoSum2(int[] numbers, int target){
		Map<Integer, Integer> response = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;response.put(numbers[i], ++i)){
			if(response.containsKey(target-numbers[i])){
				return new int[]{response.get(target-numbers[i]),i+1};
			}
		}
		return new int[]{0,0};
	}
}
