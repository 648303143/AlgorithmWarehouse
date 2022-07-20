package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-20-16:33
 */
public class LC26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = solution26.removeDuplicates(nums);
        System.out.println(i);
    }
}


class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int left = 1;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] != nums[left - 1]) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
