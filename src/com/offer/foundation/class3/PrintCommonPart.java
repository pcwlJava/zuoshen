package com.offer.foundation.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 17:10
 * content：打印两个有序链表的公共部分
 */
public class PrintCommonPart {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void printCommonPart(Node head1, Node head2){
        while (head1.next != null && head2.next != null){
            if(head1.value < head2.value){
                head1 = head1.next;   // 链表1往后走
            }else if(head1.value > head2.value){
                head2 = head2.next;   // 链表2往后走
            }else{
                // head1.value = head2.val
                System.out.print(head1.value + " ");
                // head1和head2同时往后走一位，继续找相同的地方
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
