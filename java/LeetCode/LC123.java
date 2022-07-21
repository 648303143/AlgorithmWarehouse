package LeetCode;


/**
 * @author zhangqingyang
 * @date 2022-07-21-15:44
 */
public class LC123 {
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        int i = solution123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(i);
    }
}


class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int k = 1; k < 3; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

            }
        }

        return dp[n - 1][2][0];
    }
}
