package com.offer.foundation.class5;

/**
 * @author pengcheng
 * @date 2019/3/29 - 22:34
 * @content: Trie树的基本操作的实现
 */
public class TrieTree {

    public static class TrieNode{
        private int passNum;      // 表示有多少个字符串经过该节点
        private int endNum;       // 表示有多少个字符串以该节点结尾
        private TrieNode[] paths; // 存储的是该节点到下一级所有节点的路径是否存在

        public TrieNode(){
            passNum = 0;
            endNum = 0;
            paths = new TrieNode[26]; // 假设只有26个小写字母，即每一个节点拥有26条可能的路径
        }
    }

    private TrieNode root;     // 不管什么操作，都是从根节点开始的，所以要记录根节点
    public TrieTree(){
        // Trie树的初始化
        root = new TrieNode();
    }

    // 往trie树中插入一个字符串
    public void insert(String word){
        if(word == null){
            return;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;     // index值：0-25 对应 a-z
        for(int i = 0; i < chars.length; i++){
            index = chars[i] - 'a';   // 计算该字符在当前节点的那条路径上
            // 判断该路径是否已经存在
            if(node.paths[index] == null){
                node.paths[index] = new TrieNode();  // 如果路径不存在，则创建它
            }
            // 路径已经存在的话，就继续向下走
            node = node.paths[index];
            node.passNum++;   // 划过当前节点的字符串数+1
        }
        node.endNum++;   // 遍历结束了，记录下以该字母结束的字符串数+1
    }

    // 删除一个字符串
    public void delete(String word){
        // 删除之前，先判断有没有
        if(search(word) == 0){
            return;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            index = chars[i] - 'a';
            // 注意 --
            if(--node.paths[index].passNum == 0){
                // 如果遍历到某个节点时，将其index处passNum减1后等于0，则说明没有其他字符串经过它了，直接将其设置为null
                node.paths[index] = null;
                return;
            }
            node = node.paths[index];   // 继续向下遍历
        }
        node.endNum--;   // 遍历完了，删除了整个单词，则将以该单词最后一个字符结尾的字符串的数目减1
    }


    // 在trie树中查找word字符串出现的次数
    public int search(String word){
        if(word == null){
            return 0;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            index = chars[i] - 'a';
            if(node.paths[index] == null){
                return 0;   // 不存在
            }
            node = node.paths[index];   // 到达了该字母记录的节点路径，继续往下走
        }
        // 整个单词的所有字母都在树中，说明单词在树中，返回该单词最后一个字符的endNum
        return node.endNum;
    }

    // 返回有多少单词以pre为前缀的
    public int prefixNum(String pre){
        if(pre == null){
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            index = chars[i] - 'a';
            if(node.paths[index] == null){
                return 0;   // 不存在
            }
            node = node.paths[index];   // 继续向下找
        }
        return node.passNum;   // 找到pre最后一个字符的passNum值
    }
}
