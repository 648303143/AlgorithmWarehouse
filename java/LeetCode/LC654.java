package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-26-17:28
 */
public class LC654 {
}


class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);

        root.left = process(nums, left, index);
        root.right = process(nums, index+1, right);

        return root;
    }
}
