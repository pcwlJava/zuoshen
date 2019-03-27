package com.offer.class3;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStackWithQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 添加元素
    public void add(int obj){
        stack1.push(obj);
    }

    // 删除元素
    public int poll(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                // stack2如果为空，则stack1中的元素全部倒进stack2中
                stack2.push(stack1.pop());
            }
        }
        // 如果stack2中有元素，则直接弹出。只有当stack2为空时，才会从stack1中往stack2中放数据，而且肯定是一次性放完
        return stack2.pop();
    }

    // 弹出元素，不删除
    public int peek(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                // stack2如果为空，则stack1中的元素全部倒进stack2中
                stack2.push(stack1.pop());
            }
        }
        // 弹出stack2中最上面的元素，即实现了队列的先进先出
        return stack2.peek();   // 前面的和poll一样，只不过最后需要返回而不是删除
    }
}
