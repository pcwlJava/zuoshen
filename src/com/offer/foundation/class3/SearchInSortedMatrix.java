package com.offer.foundation.class3;

/**
 * @author pengcheng
 * @date 2019-03-26 16:52
 * content：在一个行和列都排好序的矩阵中查找一个数。要求时间复杂度为：O(n+m)
 */
public class SearchInSortedMatrix {

    public boolean search(int[][] matrix, int k){
        int i = 0;
        int j = matrix[0].length - 1;

        // 从右上角开始搜索
        while(i < matrix.length && j > -1){
            if(matrix[i][j] < k){
                // matrix[i][j] 如果小于 k ，则在matrix[i][j]下方找
                i++;
            }else if(matrix[i][j] > k){
                // matrix[i][j] 如果大于 k ，则在matrix[i][j]左边找
                j--;
            }else{
                return true;   // matrix[i][j] = k
            }
        }
        return false;
    }

    // 测试
    public static void main(String[] args){
        SearchInSortedMatrix search = new SearchInSortedMatrix();
        int[][] matrix = new int[][]{{0,1,2,5},{2,3,4,7},{4,4,4,8}};
        Boolean res = search.search(matrix, 8);
        System.out.print(res);
    }
}
