package com.offer.foundation.class5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pengcheng
 * @date 2019/3/30 - 20:07
 * @content: 贪心算法：做多做k个项目的最大利润
 */
public class IPO {

    // 项目节点
    public class Node{
        private int profit;    // 项目利润
        private int cost;      // 项目成本

        public Node(int profit, int cost){
            this.profit = profit;
            this.cost = cost;
        }
    }

    /**
     * @param k ：最多做k个项目
     * @param fund ：总的资金
     * @param profits ：每个项目的利润数组
     * @param cost ：每个项目的成本数组
     * @return
     */
    public int findMaxCapital(int k, int fund, int[] profits, int[] cost){
        // 初始化每个项目节点信息
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], cost[i]);
        }
        // 优先级队列是谁小谁放在前面，比较器决定谁小
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());       // 成本小顶堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());   // 利润大顶堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);   // 将所有的项目插入成本堆中
        }
        // 开始解锁项目，赚取利润
        for (int i = 0; i < k; i++) {
            // 解锁项目的前提条件：成本堆中还有项目未被解锁并且该项目的成本小于当前的总资金
            while(!minCostQ.isEmpty() && minCostQ.peek().cost <= fund){
                maxProfitQ.add(minCostQ.poll());   // 将当前成本最小的项目解锁
            }
            if(maxProfitQ.isEmpty()){
                // 如果maxProfitQ为空，则说明没有当前资金能够解锁的新项目了，之前解锁的项目也做完了，即无项目可做了
                return fund;   // 最后的总金额
            }
            fund += maxProfitQ.poll().profit;   // 做利润最大的项目
        }
        return fund;   // k个项目都做完了
    }

    // 成本小顶堆：成本最小的在堆顶
    public class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    // 利润大顶堆：利润最大的在堆顶
    public class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }
}
