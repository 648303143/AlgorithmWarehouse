package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-06-17-10:04
 */
public class LC34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] ints = solution34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[2];
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (nums[right] == target) {
            res[0] = right;
        }else {
            res[0] = -1;
        }
        left = 0;
        right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target + 1 <= nums[mid]) {
               right = mid;
            }else {
                left = mid+1;
            }
        }
        if (nums[right-1] == target) {
            res[1] = right-1;
        }else {
            res[1] = -1;
        }

        return res;
    }
}
