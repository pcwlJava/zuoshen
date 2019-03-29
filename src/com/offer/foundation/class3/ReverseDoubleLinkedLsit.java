package com.offer.foundation.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 14:26
 * content：双向链表的反转
 */
public class ReverseDoubleLinkedLsit {

    public static class DoubleNode{

        int val;
        DoubleNode pre;    // 指向前一个节点
        DoubleNode next;   // 指向后一个节点

        public DoubleNode(int value){
            this.val = value;
        }
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        if(head == null){
            return null;
        }

        DoubleNode tmp = null;
        DoubleNode res = null;  // res的作用仅仅是记录head，因为最后一次循环后head为null，但是我们要返回最后一个不为null的head

        // 从头节点开始，依次往后挨个处理
        while(head != null){
            // pre和next指针互换
            tmp = head.next;
            head.next = head.pre;
            head.pre = tmp;
            res = head;     // 记录head节点
            head = tmp;     // 往后推进一个节点
        }
        return res;
    }
}
