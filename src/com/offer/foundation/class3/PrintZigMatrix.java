package com.offer.foundation.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 15:32
 * content：之字形打印一个矩阵
 */
public class PrintZigMatrix {

    public void printZigMatrix(int[][] matrix){
        // 每次打印轨迹的两个端点：A(a,b) B(c,d)
        int a = 0, b = 0, c = 0, d = 0;
        // 矩阵右下角的坐标：(endRow,endCol)
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        // 判断每次打印的方向，每打印一次就需要换向
        boolean direction = true;

        // A是先往右走，走到最右往下走；B是先往下走，走到最下开始往右走
        while (a <= endRow && b <= endCol){
            printSlash(matrix, a, b, c, d, direction);
            direction = !direction;  // 换向
            // A如果走到了最右边，则开始向下走，b必须要在a的下面，因为b值改变了会直接影响到a
            a = b >= endCol ? a + 1 : a;
            b = b < endCol ? b + 1 : b;

            // B如果走到了最下面，则开始向右走，c必须要在d的下面，因为c值改变了会直接影响到d
            d = c >= endRow ? d + 1 : d;
            c = c < endRow ? c + 1 : c;
        }
    }

    // 打印A和B两个点之间的轨迹
    public void printSlash(int[][] matrix, int a, int b, int c, int d, boolean direction){
        // direction为true时为从下往上打印，即 B --> A
        if(direction){
            for(; a <= c; c--, d++){
                System.out.print(matrix[c][d] + " ");
            }
        }else{
            for(; a <= c; a++, b--){
                System.out.print(matrix[a][b] + " ");
            }
        }
    }

    // 测试
    public static void main(String[] args){
        PrintZigMatrix pzm = new PrintZigMatrix();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        pzm.printZigMatrix(matrix);  // 1 2 5 9 6 3 4 7 10 11 8 12
    }
}
