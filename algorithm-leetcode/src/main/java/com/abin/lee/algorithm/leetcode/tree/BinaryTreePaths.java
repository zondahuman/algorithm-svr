package com.abin.lee.algorithm.leetcode.tree;


import java.util.*;

/**
 * Created by abin on 2018/9/13.
 * 257. Binary Tree Paths
 *  输出二叉树的从根节点到叶子节点的每一条路径
 https://leetcode.com/problems/binary-tree-paths/description/
 https://leetcode.com/problems/binary-tree-paths/discuss/68278/My-Java-solution-in-DFS-BFS-recursion
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        if(null == root) return list ;
        Stack<TreeNode> stackTree = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        stackTree.push(root);
        stackStr.push("");
        while(!stackTree.isEmpty()){
            TreeNode node = stackTree.pop();
            String str1 = stackStr.pop();
            if(node.left == null && node.right==null){
                list.add(str1 + node.val);
            }
            if(node.left != null){
                stackTree.push(node.left);
                stackStr.push(str1 + node.val + "->");
            }
            if(node.right != null) {
                stackTree.push(node.right);
                stackStr.push(str1 + node.val+"->");
            }
        }
        return list;
    }

    /**
     * Example:
     Input:
     1
     /   \
     2     3
     \
     5
     Output: ["1->2->5", "1->3"]
     Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     * @param args
     */
    public static void main(String[] args) {

    }

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT2(root, "", answer);
        return answer;
    }
    private void searchBT2(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT2(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT2(root.right, path + root.val + "->", answer);
    }


    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null) return paths;
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }
        for (String path : binaryTreePaths3(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths3(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }


    //Recursion
    public List<String> binaryTreePaths4(TreeNode root) {
        List<String> sList=new LinkedList<String>();
        //String s=new String();
        if (root==null) return sList;
        if (root.left==null && root.right==null) {
            sList.add(Integer.toString(root.val));
            return sList;
        }

        for (String s: binaryTreePaths4(root.left)) {
            sList.add(Integer.toString(root.val)+"->"+s);
        }
        for (String s: binaryTreePaths4(root.right)) {
            sList.add(Integer.toString(root.val)+"->"+s);
        }
        return sList;
    }

    //BFS - Queue
    public List<String> binaryTreePaths5(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
        Queue<String> qStr=new LinkedList<String>();

        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }
        return list;
    }

    //DFS - Stack
    public List<String> binaryTreePaths6(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Stack<TreeNode> sNode=new Stack<TreeNode>();
        Stack<String> sStr=new Stack<String>();

        if(root==null) return list;
        sNode.push(root);
        sStr.push("");
        while(!sNode.isEmpty()) {
            TreeNode curNode=sNode.pop();
            String curStr=sStr.pop();

            if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if(curNode.left!=null) {
                sNode.push(curNode.left);
                sStr.push(curStr+curNode.val+"->");
            }
            if(curNode.right!=null) {
                sNode.push(curNode.right);
                sStr.push(curStr+curNode.val+"->");
            }
        }
        return list;
    }


}
