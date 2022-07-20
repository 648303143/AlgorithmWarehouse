package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-20-16:51
 */
public class LC27 {
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }
}
