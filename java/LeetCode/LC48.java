package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-06-17-16:21
 */
public class LC48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution48.rotate(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }
}

class Solution48 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < (len+1)/2; j++) {
                int temp = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

//    public void rotate(int[][] matrix) {
//        int len = matrix.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len-i; j++) {
//                swap22(matrix,i,j,len-j-1, len-i-1);
//            }
//        }
//
//        for (int i = 0; i < len/2; i++) {
//            swap21(matrix, i, len-i-1);
//        }
//    }
//
//    public static void swap21(int[][] arr, int i, int j) {
//        int[] temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void swap22(int[][] arr, int i, int j, int x, int y) {
//        int temp = arr[i][j];
//        arr[i][j] = arr[x][y];
//        arr[x][y] = temp;
//    }
}
