package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-07-07-19:19
 */
public class LC322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int i = solution322.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}

class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];

    }
//    public int coinChange(int[] coins, int amount) {
//        int[] memory = new int[amount+1];
//        Arrays.fill(memory, -2);
//
//        return dp(coins,amount,memory);
//
//    }
//
//    public int dp(int[] coins, int amount, int[] memory){
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//
//        if (memory[amount] != -2) {
//            return memory[amount];
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//            int subRes = dp(coins, amount - coin, memory);
//            if (subRes == -1) {
//                continue;
//            }
//            min = Math.min(min, subRes + 1);
//        }
//
//        memory[amount] = min == Integer.MAX_VALUE ? -1 : min;
//        return memory[amount];
//    }

//    public int coinChange(int[] coins, int amount) {
//        return dp(coins,amount);
//
//    }
//
//    public int dp(int[] coins, int amount){
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//
//        int min = amount + 1;
//
//        for (int i = 0; i < coins.length; i++) {
//            int subRes = dp(coins, amount - coins[i]);
//            if (subRes == -1) {
//                continue;
//            }
//            min = Math.min(min, subRes+1);
//        }
//        return min == amount+1 ? -1 : min;
//    }
}
