package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-07-04-19:33
 */
public class LC62 {
    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int i = solution62.uniquePaths(23, 12);
        System.out.println(i);
    }
}
class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }
//    public int uniquePaths(int m, int n) {
//        long res = 1;
//        for (int i = n,j = 1; j < m; i++, j++) {
//            res = res * i / j;
//        }
//        return (int) res;
//    }
}
