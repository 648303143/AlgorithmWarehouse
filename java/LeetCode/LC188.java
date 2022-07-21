package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-07-21-14:24
 */
public class LC188 {
    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        int i = solution188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(i);
    }
}


class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            maxProfit(prices);
        }

        int[][][] dp = new int[n][k+1][2];

        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);

            }
        }

        return dp[n - 1][k][0];
    }


    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

}
