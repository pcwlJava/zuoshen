package com.offer.class3;

/**
 * 固定数组实现队列
 * 三个变量：start、end、size
 */
public class QueueWithArray {

    private int start;  // 指向队头，每次要取数据的位置
    private int end;    // 指向队尾，每次要添加数据的位置
    private int size;   // 队列中元素的个数，利用size实现start和end之间的解耦
    private int[] arr;

    public QueueWithArray(int initialSize){
        if(initialSize < 0){
            throw new IllegalArgumentException("the initialSzie is less than 0");
        }
        arr = new int[initialSize];
        start = 0;
        end = 0;
        size = 0;
    }

    // 添加一个元素
    public void push(int obj){
        if(size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[end] = obj;
        // 如果end指向数组中最后一个元素的位置，那么需要跳到开始的位置，从头开始
        end = (end == arr.length - 1) ? 0 : end + 1;
    }

    public int poll(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int tmp = start;
        start = (start == arr.length - 1) ? 0 : start + 1;
        return arr[tmp];
    }

}
