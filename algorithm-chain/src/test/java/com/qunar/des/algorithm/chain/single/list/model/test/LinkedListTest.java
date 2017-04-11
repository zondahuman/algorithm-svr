package com.qunar.des.algorithm.chain.single.list.model.test;

/**      
 * 创建人：subin.li   
 * 创建时间：2014年11月17日 下午10:20:04     
 *     
 */
public class LinkedListTest {

		public static void main(String[] args)
		{
			LinkedList<String> lk1=new LinkedList<String>();
			lk1.add("aa");
			lk1.add("bb");
			lk1.add("cc");
			lk1.add("dd");
			lk1.add("ee",3);
			System.out.println(lk1.contains("xx"));
			System.out.println(lk1.size());
			System.out.println(lk1.getElement(3));
			LinkedList<String> lk2=lk1.clonelist();
			System.out.println(lk2.contains("xx"));
			System.out.println(lk2.size());
			System.out.println(lk2.getElement(1));
			
		}

	}

