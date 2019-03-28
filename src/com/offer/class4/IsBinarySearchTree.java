package com.offer.class4;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/3/28 - 16:38
 * @content:判断一棵树是否是搜索二叉树
 */
public class IsBinarySearchTree {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    // 判断一棵树是否是二叉搜索树
    public Boolean isBinarySearchTree(Node head){
        if(head == null){
            return true;   // 空树是二叉搜索树
        }
        int pre = Integer.MIN_VALUE;  // 这里最好将值设置为int类型的最小值，因为树里面第一个节点可能存的也是很小的值
        Stack<Node> stack = new Stack<Node>();
        // 压一绺左边界，再从最下面依次往上弹，直到遇到一个有右孩子的节点，去遍历它的右孩子
        while(!stack.isEmpty() || head != null){
            if(head != null){
                while (head != null){
                    stack.push(head.left);   // 压一绺左节点
                    head = head.left;
                }
            }else{
                // 当前节点为空，说明左边界压完了，则弹出节点（中），再处理右边界
                head = stack.pop();  // 中
                // 判断前一个数是否小于二叉树
                if(pre > head.val){
                    return false;
                }
                pre = head.val;
                head = head.right;   // 右
            }
        }
        return true;
    }
}
