package com.offer.foundation.class5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pengcheng
 * @date 2019/3/30 - 11:43
 * @content: 最小代价问题：实质上是霍夫曼编码问题
 */
public class LowestCost {

    public class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;   // 谁小把谁放在前面: -表示o1小
        }
    }

    // 输入的是一个数组，数组中的元素则是最终的切割方式，现在要找出这种方式需要花费的最小代价
    public int lowestCost(int[] arr){
        // 优先级队列是小根堆，谁在前面，就把谁的优先级设置小点
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for (int i : arr) {
            pq.add(i);
        }
        int costTotal = 0;   // 总的代价
        int costOne = 0;     // 两数合并的代价
        // 等于1的时候，说明堆里面只有一个元素了，即已经合并完成
        while(pq.size() > 1){
            costOne = pq.poll() + pq.poll();   // 合并堆里面最小的两个元素
            costTotal += costOne;              // 两小数合并的结果
            pq.add(costOne);                 // 将两小数合并的结果重新添加到堆里
        }
        return costTotal;
    }

    // 测试
    public static void main(String[] args) {
        LowestCost lc = new LowestCost();
        int[] arr = {10, 20, 30, 40};
        int res = lc.lowestCost(arr);
        System.out.println(res);      // 190 = 10 + 20 + 30 + 30 + 40 + 60
    }
}
