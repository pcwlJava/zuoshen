package com.offer.class3;

import java.util.HashMap;

/**
 * @author pengcheng
 * @date 2019-03-27 09:03
 * content：拷贝一个带有random节点的链表
 */
public class CopyListWithRandom {

    public static class Node{
        int value;
        Node next;
        Node random;    // 指向链表中任一节点或者null

        public Node(int value){
            this.value = value;
        }
    }

    // 利用hashmap来进行元素列表节点和复制节点之间的映射，key存原节点，value存对应的复制节点
    public Node copyListWithRandom1(Node head){
        // hashmap的key和value存的都是Node类型
        HashMap<Node,Node> map = new HashMap<Node, Node>();

        Node cur = head;
        // 第一次遍历：拷贝节点,形成节点之间的映射关系
        while(cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        // 第二次遍历：复制节点之间的关系，即：next和random指针
        // 原链表节点之间的指针关系是知道的，比如想知道A'和B'之间的关系，可以通过:A->B->B',这样就找到了B'
        while(cur != null){
            // key为cur的value节点的next指针指向的是key为cur.next对应的value节点
            map.get(cur).next = map.get(cur.next);
            // key为cur的value节点的random指针指向的是key为cur.random对应的value节点
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);  // 返回复制链表的头结点
    }

}
