package com.offer.foundation.class6;

import java.util.HashMap;

/**
 * @author pengcheng
 * @date 2019/4/4 - 16:41
 * @content: 矩阵最小路径和问题
 */
public class MinPath {

    public static HashMap<String,Integer> cache = new HashMap<>();  // 缓存

    public static int minPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        // 从左上角走到右下角
        return walk(matrix, 0, 0);
    }

    // 从[i,j]位置走到右下角
    public static int walk(int[][] matrix, int i, int j){
        if(i == matrix.length - 1 && j == matrix[0].length - 1){
            // [i,j]位置已经在右下角了
            return 0;
        }

        if(i == matrix.length - 1){
            // [i,j]在矩阵的最后一行，所以只能往右走了
            return matrix[i][j] + walk(matrix, i, j + 1);
        }

        if(j == matrix[0].length - 1){
            // [i,j]在矩阵的最后一列，所以只能往下走了
            return matrix[i][j] + walk(matrix, i + 1, j);
        }

        int right = walk(matrix, i, j + 1);
        int down = walk(matrix, i + 1, j);

        return matrix[i][j] + Math.min(right,down);
    }

    // 动态规划版本
    public static int walkDynamic(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;
        int[][] dp = new int[lastRow][lastCol];  // 状态表

        dp[lastRow][lastCol] = matrix[lastRow][lastCol];   // basecase：右下角到右下角的距离为其本身大小

        // 填充最后一行其他位置处的状态值
        for(int i = lastRow, j = lastCol - 1; j >= 0; j--){
            // 左边位置的值等于右边位置值加上它自身的值
            dp[i][j] = matrix[i][j] + matrix[i][j + 1];
        }

        // 填充最后一列其他位置处的状态值
        for(int  j = lastCol, i = lastRow - 1; i >= 0; i--){
            // 上面的位置等于下面的位置值加上它本身的值
            dp[i][j] = matrix[i][j] + matrix[i + 1][j];
        }

        // 填充一般位置（除最后一行和最右一列的位置）
        for(int i = lastRow - 1; i >=0; i--){
            for(int j = lastCol - 1; j >= 0; j--){
                // 一般位置：当前位置值 + min(下面位置值，右面位置值)
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j],dp[i][j + 1]);
            }
        }
        return dp[0][0];   // 返回目标值
    }
}
