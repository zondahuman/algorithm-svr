package com.abin.lee.algorithm.tree.binary.common;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * Created by abin on 2017/11/27 13:38.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * http://blog.csdn.net/snow_7/article/details/51823408
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:

 二叉树的镜像定义：源二叉树
 8
 /  \
 6   10
 / \  / \
 5  7 9 11
 镜像二叉树
 8
 /  \
 10   6
 / \  / \
 11 9 7  5
 其实就是交换二叉树的左右子树，可用递归实现：
 交换根节点的左右孩子，再分别对左孩子进行镜像和右孩子进行镜像
 */
public class BinaryTreeMirror {
    public static MirrorNode mirrorRecursive(MirrorNode node){
        if(null == node)
            return null;
        MirrorNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorRecursive(node.left);
        mirrorRecursive(node.right);
        return node;
    }

    public static Stack<MirrorNode> mirrorLoop(MirrorNode root){
        if(null == root)
            return null;
        Stack<MirrorNode> stack = new Stack<>();//借助于辅助栈
        MirrorNode current = null;//存放出栈的栈顶元素
        MirrorNode temp = null;
        stack.push(root);
        while(!stack.isEmpty()){
            current = stack.pop(); //将根元素出栈 交换根元素的左右子树
            if(current.left != null || current.right != null){
                temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
            //将根元素的左右孩子压入栈中
            if(current.left != null)
                stack.push(current.left);
            if(current.right != null)
                stack.push(current.right);
        }
        return stack;
    }

    public static void mirrorCycle(MirrorNode root){
        if(null == root)
            return;
        Stack<MirrorNode> stack = new Stack<>();//借助于辅助栈
        MirrorNode current = null;//存放出栈的栈顶元素
        MirrorNode temp = null;
        stack.push(root);
        while(!stack.isEmpty()){
            current = stack.pop(); //将根元素出栈 交换根元素的左右子树
            if(current.left != null || current.right != null){
                temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
            //将根元素的左右孩子压入栈中
            if(current.left != null)
                stack.push(current.left);
            if(current.right != null)
                stack.push(current.right);
        }
    }

    public static void main(String[] args) {
        MirrorNode node1 = new MirrorNode(1);
        MirrorNode node2 = new MirrorNode(2);
        MirrorNode node3 = new MirrorNode(3, node1, node2);
        MirrorNode node4 = new MirrorNode(4);
        MirrorNode node5 = new MirrorNode(5);
        MirrorNode node6 = new MirrorNode(6, node4, node5);
        MirrorNode node7 = new MirrorNode(7, node6, node3);
        System.out.println("mirrorNode1---before = " + JsonUtil.toJson(node7));
//        MirrorNode mirrorNode1 = mirrorRecursive(node7);
//        System.out.println("mirrorNode1---after = " + JsonUtil.toJson(mirrorNode1));

        mirrorLoop(node7);
        System.out.println("mirrorNode2---after = " + JsonUtil.toJson(node7));

//        mirrorCycle(node7);
//        System.out.println("mirrorNode3---after = " + JsonUtil.toJson(node7));


    }
}


@Getter
@Setter
class MirrorNode {
    public int value;
    public MirrorNode left;
    public MirrorNode right;

    public MirrorNode() {
    }

    public MirrorNode(int value) {
        this.value = value;
    }

    public MirrorNode(int value, MirrorNode left, MirrorNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


}
