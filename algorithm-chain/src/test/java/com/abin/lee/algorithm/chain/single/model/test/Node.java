package com.abin.lee.algorithm.chain.single.model.test;

/**      
 * 创建人：abin
 * 创建时间：2014年11月17日 下午10:18:21     
 *     
 */
public class Node<T> {
	T data;
	Node<T> next=null;
	public Node(T data)
	{
		this.data=data;
	}
	public Node()
	{
	
	}

}