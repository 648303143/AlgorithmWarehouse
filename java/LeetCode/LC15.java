package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @author zhangqingyang
 * @date 2022-06-06-17:15
 */
public class LC15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-2,0,1,1,2});
        lists.forEach(System.out::println);
    }

}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> group = new ArrayList<>();
                    Collections.addAll(group,nums[i] , nums[left] , nums[right]);
                    res.add(group);
                    while (++left < right && nums[left] == nums[left-1]){}
                    while (left < --right && nums[right] == nums[right+1]){}
                }else if (nums[i] + nums[left] + nums[right] > 0) {
                    while (left < --right && nums[right] == nums[right+1]){}
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    while (++left < right && nums[left] == nums[left-1]){}
                }
            }
        }
        return res;
    }
}
