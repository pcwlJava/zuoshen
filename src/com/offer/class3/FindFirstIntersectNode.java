package com.offer.class3;

import java.util.HashSet;

/**
 * @author pengcheng
 * @date 2019-03-27 16:11
 * content：找两个链表第一个相交节点的问题
 */
public class FindFirstIntersectNode {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 主函数
    public Node findFirstIntersectNode(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }

        // 判断单链表是否有环，若有环则返回入环节点，否则返回null
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null){
            // 判断两个无环链表是否相交，相交则返回相交的第一个节点，不相交则返回null
            return noLoop(head1, head2);
        }else if(loop1 != null && loop2 != null){
            // 判断两个有环链表是否相交，相交则返回相交节点，否则返回null
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;  // 一个有环，一个无环，不可能相交，则直接返回null
    }

    // 1.检查单链表是否有环：利用HashSet去重的特性完成
    public Node getLoopNode(Node head){
        HashSet<Node> set = new HashSet<>();
        while(head != null){
            if(!set.contains(head)){
                set.add(head);     // 若head节点不在set里，则add进去
                head = head.next;  // 向后推进链表
            }else{
                // 到这里说明head节点在set里已经存在了，即有环，此节点即为环的入口节点
                return head;
            }
        }
        return null;
    }

    // 2.两无环单链表是否相交，相交则返回相交的第一个节点，不相交返回null
    public Node noLoop(Node head1, Node head2){
        HashSet<Node> set = new HashSet<>();
        // 将head1链表放入set中
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }
        // 遍历head2链表，与set集合中的head1链表的节点进行比较，看是否有相等的
        while(head2 != null){
            if(set.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;   // 遍历完head2都没有与head1有重复的节点，说明不相交
    }

    // 3.两有环链表是否相交
    public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        // 环外相交：可归结为无环单链表找相交点
        if(loop1 == loop2){
            HashSet<Node> set = new HashSet<>();
            while(head1 != loop1){
                // 遍历head1环以外的节点
                set.add(head1);
                head1 = head1.next;
            }
            while(head2 != loop2){
                // 将head2环外的节点与head1环外的节点进行对比，看是否有相等的
                if(set.contains(head2)){
                    return head2;
                }
                head2 = head2.next;
            }
            return loop1;
        }else{
            // 两个6形式无相交 + 环内相交（不同的环入口点）
            Node cur = loop1.next;
            while(cur != loop1){
                // cur从loo1开始在环中向下遍历，若直到再次遍历到loop1位置处，也没有遇到loop2，则说明二者不相交
                if(cur == loop2){
                    return loop1;   // 遇见了loop2，则说明相交，即为环内相交的情况
                }
                cur = cur.next;
            }
            return null;  // cur遍历完它自己那个环都没有遇到loop2，则说明不相交，即为两个6的情况
        }
    }
}
