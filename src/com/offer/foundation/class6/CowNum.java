package com.offer.foundation.class6;

/**
 * @author pengcheng
 * @date 2019/3/31 - 17:09
 * @content: 母牛数量问题
 */
public class CowNum {

    // 求第n年的牛的数量
    public static int cowNum(int n){
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        if(n == 3){
            return 3;
        }
        return cowNum(n - 1) + cowNum(n - 3);
    }

    // 牛只能活10年
    public static int cowNum2(int n){
        if(n <= 3){
            return n;
        }else if(n <= 10){
            return cowNum2(n - 1) + cowNum2(n - 3);
        }else{
            return cowNum2(n - 1) + cowNum2(n - 3) + cowNum2(n - 10);
        }
    }

    // 测试
    public static void main(String[] args) {
        int num = cowNum2(11);
        System.out.println(num);
    }
}
