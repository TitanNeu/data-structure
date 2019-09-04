package indi.datastructure;

import java.util.Random;

public class BSTDemo {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        for(int i = 10; i >= 1; i--){
            BST.createBST(root, i);
        }

        TreeNode node = BST.delete(root, 8);
        LVRBST(node);


    }

    /**
     * 中序遍历BST,是一个递增的数列
     * @param root
     */

    public static void LVRBST(TreeNode root){
        if(root == null)
            return;
        LVRBST(root.left);
        System.out.println(root.val);
        LVRBST(root.right);
    }



}



class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int i){
        this.val = i;
    }
}

class BST{

    //BST删除其中的元素
    public static TreeNode delete(TreeNode bst, int x){
        if(bst == null)
            return null;
        if(x > bst.val){
            bst.right = delete(bst.right, x);
        } else if(x < bst.val){
            bst.left = delete(bst.left, x);
        } else {
            //若左子树或者右子树是空
            if(bst.left == null || bst.right == null) {
                if(bst.left == null){
                    bst = bst.right;
                } else {
                    bst = bst.left;
                }
            } else {//若左右的子树都不是空
                //若删除的正好是当前根节点，采用右子树的最小元素，替代根节点的值，并删除右子树最小元素的策略
                int rightMin = findMin(bst.right);
                bst.val = rightMin;
                bst.right = delete(bst.right, rightMin);
            }


        }

        return bst;

    }

    //递归创建BST
    public static TreeNode createBST(TreeNode root, int i){

        if(root == null){
            return new TreeNode(i);
        }

        if(root.val < i){
            root.right = createBST(root.right, i);
        }
        if(root.val > i){
            root.left = createBST(root.left, i);
        }

        return root;

    }

    //找出BST以root为根的最小元素
    public static int findMin(TreeNode root){
        if(root == null){
            try {
                throw new Exception("null");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while(root != null && root.left != null){
            root = root.left;
        }
        return root.val;
    }
}