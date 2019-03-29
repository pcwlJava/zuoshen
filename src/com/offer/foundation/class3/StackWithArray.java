package com.offer.foundation.class3;

/**
 * 固定数组实现栈结构
 */
public class StackWithArray {

    private int[] arr;
    private int index;   // 指向即将放入元素的位置

    public StackWithArray(int initialSize){
        if(initialSize < 0){
            throw new IllegalArgumentException("the init size is less than 0");
        }
        arr = new int[initialSize];
        index = 0;
    }

    // 压栈
    public void push(int obj){
        if(index == arr.length){
            throw new ArrayIndexOutOfBoundsException("the stack is full!");
        }
        arr[index++] = obj;   // index指向的就是当前要存储数据的位置
    }

    // 弹栈（删除元素）
    public int pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty!");
        }
        return arr[--index];  // 删除的是index指向的前一个元素，因为index指向的是位置为空
    }

    // 弹出元素，但不删除
    public int peek(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty!");
        }
        return arr[index - 1];  // index并没有减小，所以index位置上的元素并没有删除
    }
}
