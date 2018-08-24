package com.abin.lee.algorithm.chain.single.list.basic.cross;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;


/**      
 * 创建人：abin
 * 创建时间：2014年11月19日 下午6:14:48     
 *     
 */
public class SingList{
	public SingNode header;
	public void add(int data){
		if(header == null){
			header = new SingNode(data, null);
		}else{
			header = new SingNode(data, header);
		}
	}
	 //检测链表是否有环
	public boolean checkLoop(SingNode singNode){
		boolean flag = false;
		SingNode slow = singNode;
		SingNode fast = singNode;
		while(null != fast && null != fast.next){
			slow = slow.next;
			fast = fast.next.next;
			if(slow.data == fast.data){
				flag = true;
			}
		}
		return flag;
	}
	//判断连个链表是否相交
	public boolean checkCross(SingNode singNode1, SingNode singNode2){
		boolean flag = false;
		int data1 = 0;
		int data2 = 0;
		SingNode node1 = singNode1;
		while(null != node1.next){
			node1 = node1.next;
		}
		data1 = node1.data;
		SingNode node2 = singNode2;
		while(null != node2.next){
			node2 = node2.next;
		}
		data2 = node2.data;
		if(data1 == data2){
			flag =true;
		}
		return flag;
	} 
	public static void main(String[] args) {
		SingNode singNode1 = new SingNode(1,null);
		SingNode singNode2 = new SingNode(2,singNode1);
		SingNode singNode3 = new SingNode(3,singNode2);
		SingNode singNode4 = new SingNode(4,singNode3);
		SingNode singNode5 = new SingNode(5,singNode4);
		SingNode singNode6 = new SingNode(6,singNode5);
		SingNode singNode7 = new SingNode(7,singNode6);
		SingNode singNode8 = new SingNode(8,singNode2);
		System.out.println("singNode8="+ JsonUtil.toJson(singNode8));
		boolean flag = new SingList().checkLoop(singNode8);
		System.out.println("flag="+flag);
		SingList list1 = new SingList();
		for(int i=0;i<10;i++){
			list1.add(i);
		}
		SingList list2 = new SingList();
		for(int i=0;i<7;i++){
			list2.add(i);
		}
//		boolean isCross = new SingList().checkCross(list1, list2);
//		System.out.println("isCross="+isCross);
	}



	public static class SingNode {
		public Integer data;
		public SingNode next;
		public SingNode(int data,SingNode next){
			this.data = data;
			this.next = next;
		}

	}
}
