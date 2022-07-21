package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-07-21-16:20
 */
public class LC213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int rob = solution213.rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }
}


class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));

    }

    public int rob(int[] nums, int start, int end) {

        nums = Arrays.copyOfRange(nums, start, end);

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[n -1];
    }
}
