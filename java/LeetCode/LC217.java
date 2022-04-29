package LeetCode;

import java.util.Arrays;

/**
 * @author zzzZqy
 * @create 2021-09-29 17:27
 */
/*
217.重复元素
给定一个整数数组，判断是否存在重复元素。
如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        //解法一: 超时
//        boolean isflag = false;
//
//        lable:for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j] && i !=j){
//                    isflag = true;
//                    break lable;
//                }
//            }
//        }
//        return isflag;


        //LeetCode官方解法
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;

        //还可使用哈希表

    }
}
