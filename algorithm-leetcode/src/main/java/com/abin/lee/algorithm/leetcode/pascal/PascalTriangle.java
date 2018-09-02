package com.abin.lee.algorithm.leetcode.pascal;

import java.util.ArrayList;
import java.util.List;

/**      
 * 创建人：abin
 * 创建时间：2014年11月6日 下午3:09:47     
 * @version      
 */
public class PascalTriangle {
    public static List<List<Integer>> generater(int numRows) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if(numRows == 0)
    		return lists;
    	lists.add(new ArrayList<Integer>());
    	lists.get(0).add(1);
    	if(numRows == 1) 
    		return lists;
        for(int i = 1;i < numRows;i++){
        	lists.add(new ArrayList<Integer>());
        	lists.get(i).add(1);
        	for(int j=1;j<i;j++){
        		lists.get(i).add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
        	}
        	lists.get(i).add(1);
        }
        return lists;
    }
    
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if (numRows ==0) return l;
        l.add(new ArrayList<Integer>());
        l.get(0).add(1);
        if (numRows ==1) return l;
        for (int i = 1;i<numRows;++i){
            l.add(new ArrayList<Integer>());
            l.get(i).add(1);
            for (int j = 1; j<i;++j){
                l.get(i).add(l.get(i-1).get(j-1)+l.get(i-1).get(j));
            }
            l.get(i).add(1);
        }
        return l;
    }
    public static void main(String[] args) {
    	List<List<Integer>> result = generate(2);
    	System.out.println("result="+result);
    	List<List<Integer>> resulter = generater(4);
    	System.out.println("resulter="+resulter);
	}
}
