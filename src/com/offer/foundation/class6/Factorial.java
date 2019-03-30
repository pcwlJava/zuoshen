package com.offer.foundation.class6;

/**
 * @author pengcheng
 * @date 2019/3/30 - 21:27
 * @content: n! 问题
 */
public class Factorial {

    // 非递归版本
    public long getFactorial1(int n){
        long res = 1L;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // 递归版本
    public long getFactorial2(int n){
        if(n == 1){
            return 1L;
        }
        return (long) n * getFactorial2(n - 1);
    }

    // 测试
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.getFactorial1(5));   // 120
        System.out.println(factorial.getFactorial2(5));   // 120
    }
}
