package com.offer.foundation.class3;

/**
 * 打印矩阵问题
 */
public class PrintMatrix {

    public void printMatrix(int[][] matrix){
        int lr = 0;
        int lc = 0;
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;

        // 左上角的横纵坐标有一个大于等于右下角的横纵坐标的时候就停止打印
        while(lr <= rr && lc <= rc){
            printEdge(matrix, lr++, lc++, rr--, rc--);
        }
    }

    /**
     * 打印四条边：边界处理+四个while循环
     * @param matrix：矩阵
     * @param lr：左上角元素横坐标
     * @param lc：左上角元素纵坐标
     * @param rr：右下角元素横坐标
     * @param rc：右下角元素纵坐标
     */
    public void printEdge(int[][] matrix, int lr, int lc, int rr, int rc){
        if(lr == rr){
            // 如果 lr == rr ：说明只有一行数据，那只打印这一行数据就可以了
            for(int i = lc; i <= rc; i++){
                System.out.print(matrix[lr][i] + " ");
            }
        }else if(lc == rc){
            // 如果 lc == rc ：说明只有一列数据，那只打印这一列数据就可以了
            for(int i = lr; i <= rr; i++){
                System.out.print(matrix[lc][i] + " ");
            }
        }else{
            int curC = lc;
            int curR = lr;
            while (curC != rc){
                // 打印上横线
                System.out.print(matrix[lr][curC] + " ");
                curC++;
            }
            while (curR != rr){
                // 打印右竖线
                System.out.print(matrix[curR][rc] + " ");
                curR++;
            }
            while(curC != lc){
                // 打印下横线
                System.out.print(matrix[rr][curC] + " ");
                curC--;
            }
            while(curR != lr){
                // 打印左竖线
                System.out.print(matrix[curR][lc] + " ");
                curR--;
            }
        }
    }

    // 测试
    public static void main(String[] args){
        PrintMatrix pm = new PrintMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        pm.printMatrix(matrix);
    }

}
