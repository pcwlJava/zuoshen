package com.offer.foundation.class5;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/3/29 - 20:14
 * @content: 并查集
 */
public class UnionFindSet {

    // 并查集和节点类型没有关系，节点的值类型是什么都无所谓
    // Node中不需要指针，因为并查集是Map实现的
    public static class Node{
        int i;
        public Node(int i){
            this.i = i;
        }
    }

    // 并查集是使用两个HashMap实现的
    HashMap<Node, Node> fatherMap;       // key:子节点  father:父节点
    HashMap<Node, Integer> sizeMap;      // 某一个节点所在的集合一共有多少个节点

    // 并查集结构必须一次性把数据给它
    public UnionFindSet(List<Node> list){
        initialSet(list);
    }

    // 初始化并查集
    private void initialSet(List<Node> nodes){
        fatherMap = new HashMap<Node, Node>();
        sizeMap = new HashMap<Node, Integer>();
        // 初始化：将每个节点作为一个集合，一个头结点指向自己
        for(Node node : nodes){
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    // 查看A、B是否属于同一个集合
    public boolean isSameSet(Node a, Node b){
        // 判断两个节点的所属集合的代表节点是否一样
        return findHead(a) == findHead(b);
    }

    // 合并两个集合
    public void union(Node a, Node b){
        if(a == null || b == null){
            return;
        }

        Node aHead = fatherMap.get(a);
        Node bHead = fatherMap.get(b);

        // 两个不在同一个集合中才需要合并
        if(aHead != bHead){
            int aSize = sizeMap.get(aHead);
            int bSize = sizeMap.get(bHead);
            if(aSize <= bSize){
                // 哪个集合大，合并到哪个集合下面
                fatherMap.put(aHead, bHead);  // b集合大，将a集合的代表节点直接挂在b集合的代表节点上
                sizeMap.put(bHead, aSize + bSize);
            }else{
                fatherMap.put(bHead, aHead);  // a集合大，将b集合的代表节点直接挂在a集合的代表节点上
                sizeMap.put(aHead, aSize + bSize);
            }
        }
    }

    // 查找代表节点
    public Node findHead(Node cur){
        if(cur == null){
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node father = fatherMap.get(cur);    // 获取cur的父节点
        while(cur != father){
            stack.push(cur);   // 不是头结点的就存起来，方便后面的优化：将它们的父节点直接指向后面找到的代表节点
            cur = father;      // 继续往上找
            father = fatherMap.get(cur);
        }
        // 优化：将栈中路径里的节点都直接指向代表节点
        while(!stack.isEmpty()){
            fatherMap.put(stack.pop(), father);
        }
        return father;
    }
}
