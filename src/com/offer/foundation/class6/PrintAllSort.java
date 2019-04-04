package com.offer.foundation.class6;

import java.util.HashSet;

/**
 * @author pengcheng
 * @date 2019/4/4 - 16:00
 * @content:
 */
public class PrintAllSort {

    public static void printAllSort(String string){
        if(string == null){
            return;
        }
        char[] chars = string.toCharArray();
        if(chars.length > 0){
            func2(0, chars);
        }
    }

    // 对i及i以后的字符进行全排序
    public static void func(int i, char[] chars){
        if(i == chars.length){
            System.out.println(String.valueOf(chars));
        }

        for(int j = i; j < chars.length; j++){
            swap(i, j, chars);     // 第i个位置有i~n-1这些选择
            func(i + 1, chars);  // 搞第i+1的位置
            swap(i, j, chars);
        }
    }

    // 对i及i以后的字符进行全排序
    public static void func2(int i, char[] chars){
        if(i == chars.length){
            System.out.println(String.valueOf(chars));
        }

        // 用于保证每次交换的字符不存在重复字符
        HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chars.length; j++){
            // 只有之前没有交换过这个字符才会交换
            if(!set.contains(chars[j])) {
                set.add(chars[j]);
                swap(i, j, chars);      // 第i个位置有i~n-1这些选择
                func2(i + 1, chars);  // 搞第i+1的位置
                swap(i, j, chars);

            }
        }
    }

    public static void swap(int i, int j, char[] chars){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // 测试
    public static void main(String[] args) {
        printAllSort("acc");
    }
}
