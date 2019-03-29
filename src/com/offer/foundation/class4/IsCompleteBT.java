package com.offer.foundation.class4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pengcheng
 * @date 2019/3/28 - 17:18
 * @content:层序遍历：判断一棵树是否为完全二叉树
 */
public class IsCompleteBT {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public Boolean isCompleteBT(Node head){
        if(head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<Node>();
        Boolean afterMustLeaf = false;   // 当前节点后面的节点都必须是子节点的开启标志
        Node left = null;
        Node right = null;
        queue.offer(head);
        while(queue.isEmpty()){
            head = queue.poll();
            // 当开启所有子节点都必须为叶节点时，出现非叶节点，或者出现左子节点为空，右子节点不为空的情况直接返回false
            if(afterMustLeaf && (left != null || right != null) || (left == null && right != null)){
                return false;
            }
            // 压入左子节点
            if(left != null){
                queue.offer(left);
            }
            // 压入右子节点
            if(right != null){
                queue.offer(right);
            }else{
                // 前面的节点都是左右双全，但是到这里少了右子节点【左子节点可能有也可能没有】，后序节点都必须为叶节点，开启标志
                afterMustLeaf = true;
            }
        }
        return true;
    }


}
