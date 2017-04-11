package com.qunar.des.algorithm.chain.single.list.basic.cross;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import org.junit.Test;

/**
 * 创建人：subin.li
 * 创建时间：2014年11月18日 上午9:56:22
 */
public class Chain {
    private ChainNode header;
    private int size;
    private int modCount;

    public void add(int data) {
        if (null == header) {
            header = new ChainNode(data, null);
            size++;
            modCount++;
        } else {
            header = new ChainNode(data, header);
            size++;
            modCount++;
        }
    }


    public int getSize() {
        return this.size;
    }

    public boolean isLoop(ChainNode chainNode) {
        boolean flag = false;
        ChainNode slow = chainNode;
        ChainNode fast = chainNode;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) {
                flag = true;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.add(0);
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(4);
        System.out.println(JsonUtil.toJson(chain.header));
        boolean flag = new Chain().isLoop(chain.header);
        System.out.println("flag=" + flag);
    }

    @Test
    public void testAdd() {
        Chain chain = new Chain();
        chain.add(0);
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(4);
        System.out.println(JsonUtil.toJson(chain.header));
    }

    @Test
    public void testIsLoop() {
        Chain chain = new Chain();
        chain.add(0);
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(4);
        chain.add(5);
        chain.add(6);
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(4);
        chain.add(5);
        chain.add(6);
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(4);
        chain.add(5);
        chain.add(6);
        System.out.println(JsonUtil.toJson(chain.header));
        boolean flag = new Chain().isLoop(chain.header);
        System.out.println("flag=" + flag);
    }
}
