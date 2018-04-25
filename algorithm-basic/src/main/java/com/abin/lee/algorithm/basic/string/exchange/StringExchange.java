package com.abin.lee.algorithm.basic.string.exchange;

import java.util.HashMap;
import java.util.Map;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年10月30日 下午9:16:31     
 * @version      
 */
public class StringExchange {
	public static void main(String[] args) {
		Map<String, Integer> request = new HashMap<String, Integer>();
		request.put("a", 5);
		request.put("b", 7);
		Map<String, Integer> response = exchange(request);
		System.out.println(response);
	}
	public static Map<String, Integer> exchange(Map<String, Integer> request) {
		Map<String, Integer> response = new HashMap<String, Integer>();
		int b = request.get("b");
		int a = request.get("a");
		b = a + (a = b)*0;
		response.put("a", a);
		response.put("b", b);
		return response;
	}
	
}
