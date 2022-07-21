package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-21-15:28
 */
public class LC714 {
    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int i = solution714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(i);
    }
}

class Solution714 {
    public int maxProfit(int[] prices, int fee) {
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
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
