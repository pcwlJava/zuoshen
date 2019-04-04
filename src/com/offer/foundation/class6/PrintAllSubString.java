package com.offer.foundation.class6;

/**
 * @author pengcheng
 * @date 2019/3/31 - 15:19
 * @content: 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubString {

    public void printAllSub(String str){
        if(str == null){
            return;
        }
        char[] chars = str.toCharArray();
        if(chars.length > 0){
            String pre = new String("");   // pre：表示从0到i-1位置上形成的结果
            printAllSub(0, pre, chars);
        }else{
            System.out.println("");          // 输入空字符串也会打印空
        }
    }

    public void printAllSub(int i, String pre, char[] chars){
        // 已经到数组最后一个字符了，所有的选择都做完了，该返回了
        if(i == chars.length){
            System.out.println(pre);
            return;
        }

        // 如果没有到最后一个字符，那么当前字符两种选择：选择要或者选择不要
        printAllSub(i + 1, pre, chars);                                  // 不要当前字符
        printAllSub(i + 1, pre + String.valueOf(chars[i]), chars);   // 要当前字符
    }

    // 测试
    public static void main(String[] args) {
        PrintAllSubString p = new PrintAllSubString();
        String str = "abc";
        p.printAllSub(str);
    }
}
