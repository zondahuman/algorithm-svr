package com.abin.lee.tree.test;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-11-15
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree {
    private static Node root = null;
    public static class Node{
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public static Node insert(Node node,Integer data){
        if(null == node){
            node = new Node(data);
        }else{
            if(data<=node.data)
                node.left=insert(node.left,data);
            else
                node.right=insert(node.right,data);
        }
        return node;
    }

    public static void preOrder(Node node){
        if(null == node)
            return;
        else{
            System.out.println("preOrder-data: " + node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void inOrder(Node node){
        if(null == node)
            return;
        else{
            inOrder(node.left);
            System.out.println("inOrder-data: "+node.data);
            inOrder(node.right);
        }
    }
    public static void postOrder(Node node){
        if(null == node)
            return;
        else{
            postOrder(node.left);
            postOrder(node.right);
            System.out.println("postOrder-data: "+node.data);
        }
    }

    public static int height(Node node){
        if(null == node)
            return 0;
        else{
            int lhight = height(node.left);
            int rheight = height(node.right);
            return (lhight>rheight)?(lhight+1):(rheight+1);
        }
    }
    public static int size(Node node){
        if(null == node)
            return 0;
        else{
            return 1+size(node.left)+size(node.right);
        }
    }
    public static Node getElement(Node node,Integer data){
        while(data != node.getData()){
            if(data<node.getData())
                node = node.left;
            else if(data>node.getData())
                node = node.right;
            else
                return null;
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(root));
        int[] arr = new int[]{6,1,2,9,3,4,8,7,5};
        for(int i=0;i<arr.length;i++){
            root = insert(root,arr[i]);
        }
        System.out.println("root"+JsonUtil.toJson(root));
//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
        int height = height(root);
        System.out.println("height= "+height);
        int size = size(root);
        System.out.println("size= "+size);
        Node findNode = getElement(root,3);
        System.out.println("findNode="+JsonUtil.toJson(findNode));

    }
}
