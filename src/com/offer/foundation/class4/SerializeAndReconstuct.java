package com.offer.foundation.class4;

import java.util.*;
/**
 * @author pengcheng
 * @date 2019/3/28 - 13:55
 * @content:二叉树的序列化和反序列化，代码实现都是以前序遍历为例的
 */
public class SerializeAndReconstuct {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    // 前序遍历来序列化一颗二叉树
    public String serialByPre(Node head){
        if(head == null){
            return "#_";   // 空节点用#表示，不同节点值之间用_隔开
        }
        String res = head.val + "_";      // 中
        res += serialByPre(head.left);    // 左
        res += serialByPre(head.right);   // 右
        return res;
    }

    // 前序遍历：反序列化一棵二叉树，怎么序列化的就怎么反序列化
    public Node reconByPreString(String str){
        String[] values = str.split("_");    // 将字符串分割成节点值组成的数组
        Queue<String> queue = new LinkedList<String>();
        for(String i : values){
            queue.add(i);   // 将数组中的节点元素添加到队列中，也可以直接使用数组
        }
        return reconPreOrder(queue);
    }

    // 根据一个队列构建一棵树
    public Node reconPreOrder(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#")){
            return null;    // 如果值为#，则构建一个空节点
        }
        // 还是按照中、左、右的方式去构建二叉树
        Node head = new Node(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
