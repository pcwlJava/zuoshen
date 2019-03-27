package com.offer.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 11:47
 * content：反转链表
 */
public class ReverseLinkedList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head){
        if(head == null){
            return null;
        }

        Node pre = null;    // 当前节点的前一个节点
        Node next = null;   // 当前节点的后一个节点

        while(head != null){
            // 先用next保存head的下一个节点的信息
            // 保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            // 保存完next，就可以让head从指向next变成指向pre了
            head.next = pre;
            // head指向pre后，就继续依次反转下一个节点
            // 让pre、head、next依次向后移动一个节点，继续下一个节点的指针反转
            pre = head;
            head = next;
        }
        // 如果head为null的时候，pre就为最后一个节点了，此时链表已经反转完毕，pre就是反转后链表的第一个节点
        return pre;
    }
}
