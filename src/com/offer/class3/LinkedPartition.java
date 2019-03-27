package com.offer.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 21:22
 * content：链表的划分：小于、等于、大于
 */
public class LinkedPartition {

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    // 将链表中的元素先放进数组中，然后再进行划分
    public Node listPartition1(Node head, int num){
        if(head == null || head.next == null){
            return head;
        }

        int i = 0;
        Node cur = head;

        // 计算有多少个节点
        while(cur != null){
            i++;
            cur = cur.next;
        }

        int[] arr = new int[i];   // 申请一个和链表中元素个数相等的数组

        cur = head;
        i = 0;
        // 从链表头结点开始遍历，将节点的val存进数组中
        while(cur != null){
            arr[i++] = cur.val;
            cur = cur.next;
        }
        // 在数组中使用荷兰国旗的方法对值进行小、等于、大的区域划分
        arrPartition(arr, num);

        // 按照排好序的数组顺序，将对应val节点串起来
        cur = head;
        i = 0;
        while(cur != null){
            cur.val = arr[i++];
            cur = cur.next;
        }
        return head;
    }

    public void arrPartition(int[] arr, int num){
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while(cur != more){
            if(arr[cur] < num){
                // 当前数与最小区域边界后一个位置元素进行交换，cur指针推进一位
                swap(arr, ++less, cur++);
            }else if(arr[cur] > num){
                // 当前数与最大区域边界的前一个位置元素进行交换，cur指针不变
                swap(arr, cur, --more);
            }else{
                cur++;   // 等于时,cur自增
            }
        }

    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
