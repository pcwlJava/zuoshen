package com.offer.foundation.class4;

/**
 * @author pengcheng
 * @date 2019/3/27 - 22:00
 * @content: 二叉树的前、中、后序遍历的递归版
 */
public class BinaryTreeWithRecur {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    // 先序遍历
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        // 整体的打印顺序是：中->左->右
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序遍历
    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        // 整体的打印顺序是：左->中->右
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序遍历
    public void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        // 整体的打印顺序是左->右->中
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // 测试
    public static void main(String[] args) {
        BinaryTreeWithRecur tree = new BinaryTreeWithRecur();
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("=======前序遍历=======");
        tree.preOrderRecur(root);    // 1 2 4 5 3 6 7
        System.out.println();
        System.out.println("=======中序遍历=======");
        tree.inOrderRecur(root);     // 4 2 5 1 6 3 7
        System.out.println();
        System.out.println("=======后序遍历=======");
        tree.posOrderRecur(root);    // 4 5 2 6 7 3 1
    }
}
