package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-06-20-21:00
 */
public class LC55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
    }
}


class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
