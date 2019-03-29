package com.offer.foundation.class5;

/**
 * @author pengcheng
 * @date 2019/3/29 - 21:05
 * @content: 岛问题
 */
public class CountIslands {

    public int countIslands(int[][] matrix){
        if(matrix == null || matrix[0] == null){
            return 0;
        }

        int row = matrix.length;        // 行数
        int column = matrix[0].length;  // 列数
        int countOfIslands = 0;

        // 从头开始遍历
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == 1){
                    // 遇到1，就说明遇到了一个新的未感染的区域
                    countOfIslands++;   // 岛数目+1
                    inject(matrix, i, j, row, column);
                }
            }
        }
        return countOfIslands;
    }

    // 感染函数
    private void inject(int[][] matrix, int i, int j, int row, int column){
        // 当超出边界和遇到被感染区或者不相连的地方，就不再需要感染了
        if(i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] != 1){
            return;
        }
        matrix[i][j] = 2;   // 感染到的区域将值设置为1
        inject(matrix, i - 1, j, row, column);   // 感染上面
        inject(matrix, i + 1, j, row, column);   // 感染下面
        inject(matrix, i, j - 1, row, column);   // 感染左面
        inject(matrix, i, j + 1, row, column);   // 感染右面
    }
}
