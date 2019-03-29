package com.offer.foundation.class4;

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

    // 后序遍历：左->右->中 可以由前序遍历转变而来:中左右--> 中右左 --> 左右中
    public void postOrderUnRecur(Node head){
        if(head == null){
            return;
        }

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();   // 用于将中右左变为左右中

        stack1.push(head);
        // stack1中最后弹出的顺序是：中、右、左，所以先压左再压右
        while(!stack1.isEmpty()){
            head = stack1.pop();   // 弹出当前节点
            // 将stack1弹出的元素压入stack2中，这样压入顺序是中、右、左，弹出顺序就是：左、中、右了
            stack2.push(head);
            if(head.left != null){
                stack1.push(head.left);
            }
            if(head.right != null){
                stack1.push(head.right);
            }
        }

        while(stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
    }

    // 中序遍历：左 —> 中 —> 右
    public void inOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        // 压一绺左边界，再从尾端依次往外弹，弹出一个节点，再去遍历它的右孩子。这个过程就模拟了：左、中、右这个过程
        // 需要判断head是否为null，是因为后序不同于先序和中序在循环前就将head压入栈中了
        while(!stack.isEmpty() || head != null){
            if(head != null){
                // 一压压一绺左边界节点
                while(head != null){
                    stack.push(head);
                    head = head.left;   // 遍历左边界节点
                }
            }else{
                // 当前节点为空，说明上面已经压完了一绺，弹出节点（中点），再处理右边
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }
}
