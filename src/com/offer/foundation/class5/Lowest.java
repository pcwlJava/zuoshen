package com.offer.foundation.class5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pengcheng
 * @date 2019/3/30 - 10:53
 * @content: 贪心策略：按最低字典序拼接字符串
 */
public class Lowest {

    // 自定义比较器：给字符串按照自定义的规则排序
    public class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);   // 哪个小哪个放前面
        }
    }

    public String getLowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        // 给字符串数组按照自己定义的规则排序
        // 对于制定的贪心策略，先直观分析下对不对，不要去试图证明，可以使用对数器证明
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }

    // 测试
    public static void main(String[] args) {
        Lowest lowest = new Lowest();
        String[] str = {"ba", "b","baa"};  // baabab
        System.out.println(lowest.getLowestString(str));
    }
}
