package com.qunar.des.algorithm.chain.single.list.model.test;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月17日 下午10:19:00     
 *     
 */
public class LinkedList<T> {
	Node<T> header=null;
	//每次增加节点在表头后
	public void add(T value)
	{
		Node<T> node1=new Node<T>(value);
		if (header==null)
		{
			header=new Node<T>();
			header.next=node1;
		}
		else {
			node1.next=header.next;
			header.next=node1;
	
		}
			
		
	}
	//在某个点插入
	
	public void add(T value,int index)
	{
		Node<T> node1=new Node<T>(value);
		if (header==null)
		{
			if(index==1)
			{
			header=new Node<T>();
			header.next=node1;
			}
		}
		else {
			Node<T>  p=header.next;
			Node<T>  prep=header;
			int i=0;
			while(p!=null)
			{
				i++;
				if (i==index)
				{
					node1.next=p;
					prep.next=node1;
				}
				prep=p;
				p=p.next;
				
			}
			
			 
	
		}
			
		
	}
	
	public boolean contains(T value)
	{
		if (header==null)
			return false;
		Node<T> p=header.next;
		while (p!=null)
		{
			if (p.data.equals(value))
				return true;
			p=p.next;
		}
		return false;
		
		
	}
	public boolean remove (T value)
	{
		if (header==null)
			return false;
		Node<T> p=header.next;
		Node<T> prep=header;
		while (p!=null)
		{
			if (p.data.equals(value))
			{
				prep.next=p.next;
				p.next=null;
				return true;
			}
			prep=p;
			p=p.next;
		}
		return false;
	}
	
	public Node<T> getNode(int index)
	{
		if (header==null)
			return null;
		Node<T> p=header.next;
		int i=1;
	
		while (p!=null)
		{
			if (i==index)
			{
			return p;
			}
	
			p=p.next;
			i++;
		}
		return null;
	}
	
	public T getElement(int index)
	{
		if (header==null)
			return null;
		Node<T> p=header.next;
		int i=1;
	
		while (p!=null)
		{
			if (i==index)
			{
			return p.data;
			}
	
			p=p.next;
			i++;
		}
		return null;
	}
	
	public boolean isEmpty()
	{
		if (header==null)
		return true;
		return false;
	}
	
	public int size()
	{
		if (header==null)
			return 0;
		Node<T> p=header.next;
		int i=0;
		while (p!=null)
		{
			i++;
			p=p.next;
		}
		return i;
	}
	public LinkedList<T> clonelist()
	{
		if (header==null)
			return null;
		
		LinkedList<T> lk=new LinkedList<T>();
		Node<T> header1=new Node<T>();
		lk.header=header1;
		
		//链表第一个数据结点先行创建
		Node<T> p=header.next;
		Node<T> p1=new Node<T>();
		p1.next=null;
		p1.data=p.data;
		header1.next=p1;
		Node<T> prep1=null;
		while (true)
		{
			p=p.next;
		 if (p==null)
		 break;
		 
		 prep1=p1;
	 p1=new Node<T>();
			p1.next=null;
			p1.data=p.data;
		 prep1.next=p1;
		 
			
		}
		return lk;
		
		
		
	}
	
	
	

}

