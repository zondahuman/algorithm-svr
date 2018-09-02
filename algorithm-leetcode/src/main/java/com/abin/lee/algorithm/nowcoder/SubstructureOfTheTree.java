package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 * 树的子结构
 * 题目描述
 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 https://blog.csdn.net/snow_7/article/details/51848566
 https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class SubstructureOfTheTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return  false;
        if(root1 ==null && root2 != null) return false ;
        boolean flag = false;
        if(root1.val == root2.val){
            flag = isSubTree(root1, root2);
        }
        if(!flag){
            flag = isSubTree(root1.left, root2);
            if(!flag){
                flag = isSubTree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2 == null) return  true;
        if(root1 ==null && root2 != null) return false ;
        if(root1.val == root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }




    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
