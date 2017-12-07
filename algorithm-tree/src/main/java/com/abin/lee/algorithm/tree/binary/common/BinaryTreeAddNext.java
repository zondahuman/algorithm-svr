package com.abin.lee.algorithm.tree.binary.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;

/**
 * Created by abin on 2017/12/7 18:56.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * 题目：对于一颗完全二叉树，要求给所有节点加上一个pNext指针，指向同一层的相邻节点；如果当前节点已经是该层的最后一个节点，则将pNext指针指向NULL；给出程序实现，并分析时间复杂度和空间复杂度。
 运用队列，按层遍历，每次遍历一层时，添加新指针，由于每个节点只需要进队一次出队一次，时间复杂度为O(n)，空间复杂度为O(n)，具体代码如下：
 http://blog.csdn.net/fangjian1204/article/details/38403417
 */
public class BinaryTreeAddNext {
    public static void main(String[] args) {


    }
    public static void addNext(Node node){
        if(null == node)
            return ;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            Node first = null, second = null;
            while (levelLength > 0){
                first = queue.remove();
                
            }
        }
    }





    @Getter
    @Setter
    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }
}

