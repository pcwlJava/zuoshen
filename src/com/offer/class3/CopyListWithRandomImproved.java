package com.offer.class3;

/**
 * @author pengcheng
 * @date 2019-03-27 09:31
 * content：拷贝含有random节点链表的进阶版
 */
public class CopyListWithRandomImproved {

    public static class Node{
        int value;
        Node next;
        Node random;    // 指向链表中任一节点或者null

        public Node(int value){
            this.value = value;
        }
    }

    public Node copyListWithRandom2(Node head){
        if(head == null){
            return null;
        }

        Node cur = head;
        Node tmp = null;
        // 拷贝节点，重建链表结构为：1->1'->2->2'->3->3'->...->null形式
        // 即将拷贝的节点直接关联到原节点的next指针上
        while(cur != null){
            tmp = head.next;                 // 先将当前指针原链表中的下一个节点保存起来
            cur.next = new Node(cur.value);  // 将当前节点复制的节点设置为当前节点的next节点
            cur.next.next = tmp;             // 将原节点的next节点设置为员节点拷贝节点的next节点
            cur = cur.next.next;
        }

        cur = head;
        Node curCopy = head.next;
        // 复制random结构
        while(cur != null){
            curCopy = cur.next;
            // 拷贝节点的random节点就是cur的random节点的后一个节点
            curCopy.random = (cur.random == null) ? null : cur.random.next;
            cur = cur.next.next;
        }

        Node headCopy = head.next;
        cur = head;
        // 拆分链表
        while(cur != null){
            curCopy = cur.next;
            cur.next = cur.next.next;   // 走两个next
            curCopy.next = curCopy.next == null ? null : curCopy.next.next;
            cur = cur.next;  // 推进节点
        }
        return headCopy;
    }
}
