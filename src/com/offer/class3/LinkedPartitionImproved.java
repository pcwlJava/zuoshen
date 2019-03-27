package com.offer.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 21:42
 * content：链表划分的进阶版：时间复杂度：O(N) 空间复杂度：O(1)、保证稳定性
 */
public class LinkedPartitionImproved {

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    // 将一条
    public Node listPartition2(Node head, int num){
        Node less = null;       // 存放小于num的节点,指向第一次出现在该区域的节点
        Node equal = null;
        Node more = null;
        Node endless = null;
        Node endequal = null;   // 指向各自链表的结尾
        Node endmore = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = null;  // 每次加入的节点都是指向null，就是less、equal、more的末尾节点
            if(head.val < num) {
                // 放入less区域
                if (less == null) {
                    less = head;
                    endless = head;
                } else {
                    endless.next = head;   // less区域的尾节点指针指向head
                    endless = head;        // 推进链表，将endless指针指向head节点
                }
            }else if(head.val > num){
                // 放入more区域
                if(more == null){
                    more = head;
                    endmore = head;
                }else{
                    endmore.next = head;
                    endmore = head;
                }
            }else{
                if(equal == null){
                    equal = head;
                    endequal = head;
                }else{
                    endequal.next = head;
                    endequal = head;
                }
            }
            head = head.next;
        }

        // 将划分好的三部分子链表串起来，返回
        // 需要考虑到可能某部分子链表可能不存在的情况
        if(less != null){
            endless.next = equal;     // less子链表存在
            if(equal != null){
                endequal.next = more; // equal子链表存在
            }else{
                endless.next = more;  // equal子链表不存在
            }
            return less;
        }else{
            // less子链表不存在
            if(equal != null){
                endequal.next = more;
                return equal;
            }else{
                // equal子链表不存在，直接返回more子链表
                return more;
            }
        }
    }
}
