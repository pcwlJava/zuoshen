package com.offer.class4;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/3/27 - 22:38
 * @content: 二叉树前中后序遍历的非递归版本
 */
public class BinaryTreeWithNoRecur {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    // 前序遍历：中->左->右：处理当前节点，有右先压右，有左再压左，这样就会先弹出左，再弹出右
    public void preOrderUnRecur(Node head){
        if(head == null){
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(stack.isEmpty()){
            head = stack.pop();  // 先弹出当前节点
            System.out.print(head.value + " ");
            // 先压右孩子
            if(head.right != null){
                stack.push(head.right);
            }
            // 再压左孩子
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }
}
