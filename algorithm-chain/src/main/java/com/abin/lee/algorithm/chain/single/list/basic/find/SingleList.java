package com.abin.lee.algorithm.chain.single.list.basic.find;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-10 下午11:19
 */
public class SingleList {
    private Node header;

    public void addFirst(String data) {
        Node current = new Node(data);
        current.next = header;
        header = current;
    }

    public Node find(int index) {
        Node current = header;
        int i = 0;
        while (null != current) {
            if (i == index) {
                return current;
            } else {
                current = current.next;
            }
            i++;
        }
        return null;
    }

    public Node find(String target) {
        Node current = header;
        while (null != current) {
            if (target == current.data) {
                return current;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Node findLastN(int n) {
        Node totalNode = header;
        int total = 0;
        while (null != totalNode) {
            totalNode = totalNode.next;
            total++;
        }
        Node current = header;
        int curNum = 0 ;
        while (null != current) {
            curNum++;
            if (curNum == total - n) {
                return current;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Node findLastNNode(int n) {
        Node slowNode = header;
        Node fastNode = header;
        int already = 0;
        while (null != fastNode) {
            already++;
            fastNode = fastNode.next;
            if(already == n){
                break;
            }
        }
        while (null != slowNode) {
            fastNode = fastNode.next;
            if(null == fastNode){
                return slowNode;
            }
            slowNode = slowNode.next;
        }
        return null;
    }


    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst("a");
        singleList.addFirst("b");
        singleList.addFirst("c");
        singleList.addFirst("d");
        singleList.addFirst("e");
        System.out.println("singleList=" + JsonUtil.toJson(singleList.header));
        Node findNode = singleList.find(3);
        System.out.println("findNode=" + JsonUtil.toJson(findNode));
        Node findValueNode = singleList.find("d");
        System.out.println("findValueNode=" + JsonUtil.toJson(findValueNode));
        Node findLastN = singleList.findLastN(2);
        System.out.println("findLastN=" + JsonUtil.toJson(findLastN));
        Node findLastNNode = singleList.findLastNNode(2);
        System.out.println("findLastNNode=" + JsonUtil.toJson(findLastNNode));

    }

    public static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }

    }

}
