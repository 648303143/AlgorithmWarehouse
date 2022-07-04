package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-07-04-21:36
 */
public class LC75 {
    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution75.sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                if (low < high) {
                    swap(nums, i, high);
                }
                low++;
                high++;
            } else if (nums[i] == 1) {
                swap(nums, i, high);
                high++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
