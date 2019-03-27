package com.offer.class3;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019-03-26 17:47
 * content：判断一个链表是否是回文结构
 */
public class IsPalindromList {

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    // 方法1：用栈结构存储整个链表元素，再依次弹出与链表从头开始比较，空间复杂度为：O(n)
    public boolean isPalindromList1(Node head){

       if(head == null || head.next == null){
           return true;  // 没有节点或者只有一个节点时，肯定是回文链表
       }

        Node cur = head;

        Stack<Node> stack = new Stack<Node>();
        // 遍历链表，将链表元素从头开始依次亚入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        // 开始比对栈中依次弹出的元素与链表从头开始遍历的元素是否都相等
        cur = head;
        while(cur != null){
            if(stack.pop() != cur){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // 方法2：用栈只存储链表一半的元素（中间位置到最后），然后依次弹出与链表的前半部分比较
    // 空间复杂度为：O(n/2)
    // 代码略

    // 方法3：将链表对折，后半部分的链表反转与前半部分链表进行比较
    public boolean isPalindromList2(Node head){
        if(head == null || head.next == null){
            return true;  // 没有节点或者只有一个节点时，肯定是回文链表
        }

        Node cur = head;
        Node slow = head;  // 慢指针：一次走一个节点
        Node fast = head;  // 快指针：一次走两个节点

        // 元素总个数为奇数时，慢指针最后指向中间位置，若为偶数，则走到中间位置的前一位
        // 注意：在向后遍历的时候，需要判断快指针指向的节点是否为空，不然会出现异常
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next; // 若fast.next != null，那么说明这是偶数个
            slow = slow.next;
        }

        // slow 到达的是中点位置，反转后半部分，反转后中点指向的是null
        Node end = reverseSingleList(slow);
        fast = end;
        // 将前半部分与后半部分折叠对比
        while(cur != null && fast != null){
            if(cur.val != fast.val){
                return false;
            }
            cur = cur.next;
            fast = fast.next;
        }
        // 不能改变原有的数据结构，所以还需要将后半部分反转还原过去
        cur = reverseSingleList(end);
        return true;
    }

    // 链表反转
    public Node reverseSingleList(Node head){
        Node pre = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            // 往后推进一个节点
            pre = head;
            head = next;
        }
        return pre;
    }
}
