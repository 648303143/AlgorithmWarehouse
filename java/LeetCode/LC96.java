package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-06-10:01
 */
public class LC96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int i = solution96.numTrees(19);
        System.out.println(i);
    }
}


class Solution96 {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i-1-j];
            }
        }
        return nums[n];
    }
}
