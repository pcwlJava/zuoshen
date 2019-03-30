package com.offer.foundation.class6;

/**
 * @author pengcheng
 * @date 2019/3/30 - 22:18
 * @content: 汉诺塔问题
 */
public class Hanoi {

    public void hanoi(int n){
        if(n > 0){
            hanoi(n, "left", "right", "mid");
        }
    }

    /**
     * @param n ：n个数
     * @param from ：原位置
     * @param help ：辅助位置
     * @param to ： 目标位置
     */
    public void hanoi(int n, String from, String to, String help){
        if(n == 1){
            // 只有一个时，直接移到目标位置即可
            System.out.println(n + ":" + from + "->" + to);
            return;
        }
        // 下面是处理这个过程的递归问题，只用考虑当前n问题就行，不用尝试去理解它的子问题
        hanoi(n - 1, from, help, to);  // 第1步：将n-1个圆盘从原位置移动到辅助位置
        System.out.println(n + ":" + from + "->" + to);  // 第2步：将第n个圆盘移到目标位置，即打印即可
        hanoi(n - 1, help, to, from);   // 第3步：将位置上的n-1个元素移到到目标位置
    }
}
