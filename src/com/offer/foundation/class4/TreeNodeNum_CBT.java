package com.offer.foundation.class4;

/**
 * @author pengcheng
 * @date 2019/3/28 - 21:47
 * @content: 求一棵完全二叉树的节点个数
 */
public class TreeNodeNum_CBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public int getNodeNum(Node head){
        if(head == null){
            return 0;
        }
        int left_h = high(head.left);    // 当前节点的左子树高度
        int right_h = high(head.right);  // 当前节点的右子树高度

        if(left_h == right_h){
            /**
             * 如果右子树的高度等于左子树的高度，说明左子树一定是满二叉树。
             * 因为右子树的高度是遍历它的左边界得到的，和左子树相等，则说明右子树的左边界子树也是到了最下面一层了
             * 此时总节点个数 = 2^(left_h) - 1 + 1(根节点) + 右子树个数（递归处理，和根节点一样的问题）
             */
            return ((1 << left_h) - 1 + 1 + getNodeNum(head.right));
        }else{
            /**
             * 如果右子树的高度不等于左子树的高度，则右子树肯定是比左子树高度小1的满二叉树
             * 此时总节点个数 = 2^(right_h) - 1 + 1(根节点) + 左子树个数（递归处理，和根节点一样的问题）
             */
             return ((1 << right_h) - 1 + 1 + getNodeNum(head.left));
        }
    }

    // 求node作为根节点时，树的高度。遍历完全二叉树的左边界得到的肯定是树的高度
    public int high(Node node){
        if(node == null){
            return 0;
        }
        int h = 0;
        while(node != null){
            node = node.left;
            h++;
        }
        return h;
    }

}
