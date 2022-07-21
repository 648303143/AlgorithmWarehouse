package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-21-15:28
 */
public class LC309 {
    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        int i = solution309.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }
}

class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];


        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
