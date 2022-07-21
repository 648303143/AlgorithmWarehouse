package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-21-17:29
 */
public class LC18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        List<List<Integer>> lists = solution18.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(lists);
    }
}


class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, target, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int n, long target, int start) {

        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = nums.length-1;
        if (n < 2 || nums.length < n) {
            return res;
        }
        if (n == 2) {
            while (left < right) {
                int low = nums[left];
                int high = nums[right];
                int sum = low + high;
                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(low, high)));
                    while (left < right && nums[left] == low) {left++;}
                    while (left < right && nums[right] == high) {right--;}
                }else if (sum > target) {
                    while (left < right && nums[right] == high) {right--;}
                }else {
                    while (left < right && nums[left] == low) {left++;}
                }
            }
        }else {
            for (int i = left; i < nums.length; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, target - nums[i], i + 1);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < nums.length-1 && nums[i] == nums[i + 1]) {i++;}
            }
        }

        return res;
    }
}
