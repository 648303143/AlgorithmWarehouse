package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zzzZqy
 * @create 2021-10-01 17:07
 */
/**
1. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
 */
public class LC1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{3,2,4};
        System.out.println(solution.twoSum(nums,6));
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return arr;
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    arr[0] = i;
//                    arr[1] = j;
//                    return arr;
//                }
//            }
//        }
//        return arr;
//    }
}
