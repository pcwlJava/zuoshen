package com.offer.class3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个栈实现队列
 */
public class TwoQueueWithStack {

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueueWithStack(){
        // LinkedList实现了Queue接口
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    // 插入一个元素
    public void push(int obj){
        // 插入元素永远都是插入到queue中
        queue.add(obj);
    }

    // 删除一个元素
    public int pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        while(queue.size() > 1){
            // 将queue中除最后一个元素外，全部弹出添加到help中
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    // 弹出一个元素（不删除）
    public int peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        while(queue.size() > 1){
            // 将queue中除最后一个元素外，全部弹出添加到help中
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    // 互换queue和help的指针,help只是辅助队列，始终操作的还是queue
    public void swap(){
        Queue<Integer> temp = help;
        help = queue;
        queue = temp;
    }
}
