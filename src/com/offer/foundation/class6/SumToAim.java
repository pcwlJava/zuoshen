package com.offer.foundation.class6;

/**
 * @author pengcheng
 * @date 2019/4/4 - 19:27
 * @content:
 */
public class SumToAim {
    public static boolean IsSumToAim(int[] arr, int aim){
        if(arr == null){
            return false;
        }
        return process(arr, 0, 0, aim);
    }

    // pre:是 0 ~ （i - 1）随意相加产生的结果
    // 用于判断pre+i及其后面的数字随意相加，是否能够得到aim
    public static boolean process(int[] arr, int i, int pre, int aim){
        if(i == arr.length){
            return pre == aim;
        }
        // 位置i有两种选择：要或不要，有一个等于aim，即返回true
        return process(arr, i + 1, pre, aim) || process(arr, i + 1, pre + arr[i], aim);
    }

    // 递归版本
    public static boolean isSumToAim2(int[] arr, int aim){
        if(arr == null || arr.length == 0){
            return false;
        }

        //
        boolean[][] dp = new boolean[arr.length][aim + 1];

        // 填好最后一行:i为横坐标，pre为纵坐标
        for(int i = arr.length, sum = 0; sum <= aim; sum++){
            if(sum == aim){
                dp[i][sum] = true;   // 目标值处设置为true
            }else{
                dp[i][sum] = false;
            }
        }

        // 按照递归填好状态表中的每一个位置：从下一行推导出上一行的状态值
        for(int i = arr.length - 1; i >= 0; i--){
            for(int sum = aim; sum >= 0; sum--){
                if(sum + arr[i] > aim){
                    dp[i][sum] = dp[i + 1][sum];
                }else{
                    // dp[i][sum]值为true的两种情况：正下方值为true || dp[i+1][sum+arr[i]]的值为true，有一个为ture就行
                    dp[i][sum] = dp[i + 1][sum] || dp[i + 1][sum + arr[i]];
                }
            }
        }
    }

}
