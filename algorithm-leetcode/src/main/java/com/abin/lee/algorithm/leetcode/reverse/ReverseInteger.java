package com.abin.lee.algorithm.leetcode.reverse;

/**      
 * 创建人：abin
 * 创建时间：2014年11月8日 下午7:54:48     
 *     
 */
public class ReverseInteger {
	public static void main(String[] args) {
		int result = new ReverseInteger().reverse(-321);
		System.out.println(result);
	}
	public int reverse(int x) {
		int result = 0;
		StringBuffer buffer = new StringBuffer();
        String str = String.valueOf(x);
        boolean flag = str.contains("-");
        if(flag){
        	for(int i=str.length()-1;i>=1;i--){
        		buffer.append(str.charAt(i));
        	}
        	result = -Integer.parseInt(buffer.toString());
        }else{
        	for(int i=str.length()-1;i>=0;i--){
        		buffer.append(str.charAt(i));
        	}
        	result = Integer.parseInt(buffer.toString());
        }
        return result;
    }
}
