package com.offer.foundation.class3;

import java.util.Stack;

/**
 * 用一个额外的栈空间维持一个最小元素
 */
public class MyStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack(){
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int obj){
        dataStack.push(obj);
        if(minStack.isEmpty()){
            minStack.push(obj);    // 当最小值栈为空时，直接将数存进去
        }else if(obj <= minStack.peek()){
            minStack.push(obj);    // 当obj小于等于最小值栈中的最小值时，直接压入栈中
        }else{
            minStack.push(minStack.peek());  // 将最小值栈中的最小值再压入一遍
        }
    }

    public int pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin(){
        if(minStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("the stack is empty!");
        }
        return minStack.peek();
    }
}
