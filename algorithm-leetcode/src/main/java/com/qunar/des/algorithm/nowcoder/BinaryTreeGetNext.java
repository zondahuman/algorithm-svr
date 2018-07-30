package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/30.
 * 二叉树的下一个结点
 * 题目描述
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 中序遍历：左子树---> 根结点 ---> 右子树
 后序遍历：左子树 ---> 右子树 ---> 根结点
 https://blog.csdn.net/sbq63683210/article/details/51839408
 */
public class BinaryTreeGetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode curNode = null;
        //第一步：判断是否有右孩子
        if(pNode.right != null){
            curNode = pNode.right;
            while(curNode.left != null) curNode = curNode.left;
            return curNode;
        }
        //第二步：判断是否是其父节点的左孩子
        if(pNode.next == null) return null;
        if(pNode == pNode.next.left){
            return pNode.next;
        }
        //第三步：向上找其父节点，直到父节点是其父节点的父节点的左孩子
        curNode = pNode.next;
        while(curNode.next != null){
            if(curNode == curNode.next.left){
                return curNode.next;
            }
            //继续向上找父节点
            curNode = curNode.next;
        }
        return null;
    }


    public static class TreeLinkNode {
        int val = 0;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int val) {
            this.val = val;

        }
    }

}
