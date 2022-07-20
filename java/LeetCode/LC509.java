package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-07-20:14
 */
public class LC509 {
    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib(3));
    }
}

class Solution509 {
    public int fib(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}



