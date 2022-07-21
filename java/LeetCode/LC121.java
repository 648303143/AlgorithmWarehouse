package LeetCode; /**
 * @author zhangqingyang02
 * @create 2022-04-02-20:07
 */

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LC121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int i = solution121.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}

class Solution121 {

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
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }

        return dp[n - 1][0];
    }


//    public int maxProfit(int[] prices) {
//        int[] preMin = new int[100001];
//        preMin[0] = prices[0];
//        int max = 0;
//        findPreMin(prices, preMin);
//        for (int i = 1; i < prices.length; i++) {
//            max = Math.max(max, prices[i] - preMin[i]);
//        }
//        return max;
//    }
//
//    private void findPreMin(int[] prices, int[] preMin) {
//        for (int i = 1; i < prices.length; i++) {
//            preMin[i] = Math.min(prices[i], preMin[i-1]);
//        }
//    }

    //暴力
    //超出时间限制
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                max = Math.max(max, prices[j] - prices[i]);
//            }
//        }
//        return max;
//    }

//    //记录最小值
//    public int maxProfit(int[] prices) {
//        int min = prices[0];
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            min = Math.min(min, prices[i]);
//            maxProfit = Math.max(maxProfit, prices[i] - min);
//        }
//        return maxProfit;
//    }
}
