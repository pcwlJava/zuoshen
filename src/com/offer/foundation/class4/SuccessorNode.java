package com.offer.foundation.class4;

/**
 * @author pengcheng
 * @date 2019/3/28 - 11:23
 * @content: 找二叉树中一个节点的后继节点：即中序遍历中一个节点的下一个节点
 */
public class SuccessorNode {

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;   // 新增：父节点指针

        public Node(int value){
            this.value = value;
        }
    }

    // 找到任一node节点的后继节点
    public Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }

        if(node.right != null){
            // 情况1：如果该节点存在右子节点，后继节点是右子树中的最左边节点
            return getLeafMost(node.right);
        }else{
            // 情况2：如果没有右子树，向上查找当前节点属于哪个节点的左子树下面，即找到一个父节点是左子节点的
            // 整棵树只有最后一个节点没有后继节点，会查找到根节点的父节点为null
            Node parent = node.parent;
            while(parent != null && node != parent.left){
                // parent != null 是为最后一个节点设置的，其后继节点就是根节点的父节点为null
                node = parent;
                parent = node.parent;  // 向上遍历
            }
            return parent;
        }
    }

    // 找到node节点的最左边的节点
    public Node getLeafMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
